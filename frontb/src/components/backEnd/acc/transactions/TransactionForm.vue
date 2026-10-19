<template>
  <b-card no-body>
    <b-overlay :show="loading" rounded="sm">
      <b-card-header class="d-flex justify-content-between align-items-center">
        <div>
          <div class="h5 mb-1">سند حسابداری</div>
          <div class="text-muted small">
            شماره: {{ tx.transactionNumber || "جدید" }} |
            وضعیت:
            <b-badge :variant="statusVariant">
              {{ tx.transactionStatus }}
            </b-badge>
          </div>
        </div>

        <b-button
            variant="outline-secondary"
            :to="{ name: 'transactions.list' }"
        >
          بازگشت
        </b-button>
      </b-card-header>

      <b-card-body>
        <!-- Header -->
        <b-row>
          <b-col md="3">
            <label class="mb-1">تاریخ سند</label>

            <b-form-datepicker
                v-model="tx.transactionDate"
                :disabled="!isEditable"
            />
          </b-col>

          <b-col md="9">
            <label class="mb-1">شرح</label>

            <b-form-input
                v-model.trim="tx.description"
                :disabled="!isEditable"
                placeholder="شرح کلی سند"
            />
          </b-col>
        </b-row>

        <hr />

        <!-- Items -->
        <TransactionItemsTable
            v-model="tx.details"
            :readonly="!isEditable"
            @totals="onTotals"
        />

        <TransactionSummary
            class="mt-3"
            :total-debit="totals.debit"
            :total-credit="totals.credit"
        />
      </b-card-body>

      <b-card-footer>
        <TransactionActions
            :tx="tx"
            :is-balanced="isBalanced"
            :is-editable="isEditable"
            @save="save"
            @post="postTx"
            @lock="lockTx"
            @cancel="cancelTx"
            @reverse="reverseTx"
            @delete="deleteTx"
        />
      </b-card-footer>
    </b-overlay>
  </b-card>
</template>

<script>
import TransactionItemsTable from "./TransactionItemsTable.vue";
import TransactionActions from "./TransactionActions.vue";
import TransactionSummary from "./TransactionSummary.vue";

function todayISO() {
  const d = new Date();
  const pad = function (n) {
    return String(n).padStart(2, "0");
  };

  return (
      d.getFullYear() +
      "-" +
      pad(d.getMonth() + 1) +
      "-" +
      pad(d.getDate())
  );
}

export default {
  components: {
    TransactionItemsTable,
    TransactionActions,
    TransactionSummary,
  },

  props: {
    id: {
      type: String,
      default: null,
    },
  },

  data() {
    return {
      loading: false,

      tx: {
        id: null,
        transactionNumber: null,
        transactionDate: todayISO(),
        transactionStatus: "DRAFT",
        description: "",
        details: [this.newLine()],
      },

      totals: {
        debit: 0,
        credit: 0,
      },
    };
  },

  computed: {
    isNew() {
      return !this.id || this.id === "new";
    },

    isEditable() {
      return this.tx.transactionStatus === "DRAFT";
    },

    isBalanced() {
      return (
          this.totals.debit > 0 &&
          this.totals.debit === this.totals.credit
      );
    },

    statusVariant() {
      const map = {
        DRAFT: "secondary",
        POSTED: "primary",
        LOCKED: "dark",
        CANCELLED: "danger",
        REVERSED: "warning",
      };

      return map[this.tx.transactionStatus] || "info";
    },
  },

  methods: {
    newLine() {
      return {
        id: null,
        accountId: null,
        debit: 0,
        credit: 0,
        description: "",
      };
    },

    toast(title, msg, variant) {
      if (!variant) {
        variant = "info";
      }

      if (this.$bvToast) {
        this.$bvToast.toast(msg, {
          title: title,
          variant: variant,
          solid: true,
        });
      }
    },

    normalizePayload(tx) {
      const details = (tx.details || [])
          .map(function (l) {
            return {
              id: l.id || null,
              accountId: l.accountId || null,
              debit: Number(l.debit) || 0,
              credit: Number(l.credit) || 0,
              description: l.description || "",
            };
          })
          .filter(function (l) {
            return (
                l.accountId ||
                l.debit ||
                l.credit ||
                l.description
            );
          });

      return {
        transactionDate: tx.transactionDate,
        description: tx.description,
        details: details,
      };
    },

    validateBeforeSave() {
      if (!this.isEditable) {
        return "این سند قابل ویرایش نیست.";
      }

      if (!this.tx.transactionDate) {
        return "تاریخ سند الزامی است.";
      }

      if (!this.tx.details || !this.tx.details.length) {
        return "حداقل یک سطر وارد کنید.";
      }

      for (let i = 0; i < this.tx.details.length; i++) {
        const l = this.tx.details[i];

        const debit = Number(l.debit) || 0;
        const credit = Number(l.credit) || 0;

        if (!l.accountId) {
          return "در سطر " + (i + 1) + " انتخاب حساب الزامی است.";
        }

        if (
            (debit > 0 && credit > 0) ||
            (debit === 0 && credit === 0)
        ) {
          return (
              "در سطر " +
              (i + 1) +
              " فقط یکی از بدهکار یا بستانکار باید مقدار داشته باشد."
          );
        }

        if (debit < 0 || credit < 0) {
          return (
              "در سطر " +
              (i + 1) +
              " مبلغ منفی مجاز نیست."
          );
        }
      }

      if (!this.isBalanced) {
        return "سند تراز نیست (جمع بدهکار و بستانکار برابر نیست).";
      }

      return null;
    },

    async loadAccountsIfStoreExists() {
      if (this.$store && this.$store.dispatch) {
        await this.$store.dispatch("transactions/fetchAccounts");
      }
    },

    async load() {
      this.loading = true;

      try {
        await this.loadAccountsIfStoreExists();

        if (this.isNew) {
          return;
        }

        await this.$store.dispatch(
            "transactions/fetchTransaction",
            this.id
        );

        const tx =
            this.$store.getters["transactions/transaction"];

        this.tx = JSON.parse(JSON.stringify(tx));

        if (!this.tx.details || !this.tx.details.length) {
          this.tx.details = [this.newLine()];
        }
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در دریافت اطلاعات سند",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },

    onTotals(t) {
      this.totals = t;
    },

    async save() {
      const err = this.validateBeforeSave();

      if (err) {
        return this.toast("اعتبارسنجی", err, "warning");
      }

      this.loading = true;

      try {
        const payload = this.normalizePayload(this.tx);

        if (!this.tx.id) {
          const created = await this.$store.dispatch(
              "transactions/createTransaction",
              payload
          );

          if (created) {
            this.tx = JSON.parse(
                JSON.stringify(created)
            )
          }

          if (created && created.id) {
            this.$router.replace({
              name: "tx-edit",
              params: {
                id: String(created.id),
              },
            });
          }
        } else {
          await this.$store.dispatch(
              "transactions/updateTransaction",
              {
                id: this.tx.id,
                payload: payload,
              }
          );

          await this.$store.dispatch(
              "transactions/fetchTransaction",
              this.tx.id
          );

          this.tx = JSON.parse(
              JSON.stringify(
                  this.$store.getters["transactions/transaction"]
              )
          );
        }

        this.toast("موفق", "سند ذخیره شد.", "success");
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در ذخیره سند",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },

    async postTx() {
      if (!this.tx.id) {
        return this.toast(
            "خطا",
            "ابتدا سند را ذخیره کنید.",
            "warning"
        );
      }

      if (!this.isBalanced) {
        return this.toast(
            "خطا",
            "سند تراز نیست.",
            "warning"
        );
      }

      if (!confirm("سند ثبت قطعی (POST) شود؟")) {
        return;
      }

      this.loading = true;

      try {
        await this.$store.dispatch(
            "transactions/postTransaction",
            this.tx.id
        );

        await this.$store.dispatch(
            "transactions/fetchTransaction",
            this.tx.id
        );

        this.tx = JSON.parse(
            JSON.stringify(
                this.$store.getters["transactions/transaction"]
            )
        );

        this.toast("موفق", "سند POST شد.", "success");
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در POST",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },

    async lockTx() {
      if (!this.tx.id) {
        return;
      }

      if (!confirm("سند قفل نهایی (LOCK) شود؟")) {
        return;
      }

      this.loading = true;

      try {
        await this.$store.dispatch(
            "transactions/lockTransaction",
            this.tx.id
        );

        await this.load();

        this.toast("موفق", "سند LOCK شد.", "success");
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در LOCK",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },

    async cancelTx() {
      if (!this.tx.id) {
        return;
      }

      if (!confirm("سند لغو (CANCEL) شود؟")) {
        return;
      }

      this.loading = true;

      try {
        await this.$store.dispatch(
            "transactions/cancelTransaction",
            this.tx.id
        );

        await this.load();

        this.toast("موفق", "سند CANCEL شد.", "success");
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در CANCEL",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },

    async reverseTx() {
      if (!this.tx.id) {
        return;
      }

      const reason = prompt(
          "علت برگشت/اصلاح سند را وارد کنید:"
      );

      if (!reason) {
        return;
      }

      this.loading = true;

      try {
        const res = await this.$store.dispatch(
            "transactions/reverseTransaction",
            {
              id: this.tx.id,
              reason: reason,
            }
        );

        let newTxId = null;

        if (res && res.id) {
          newTxId = res.id;
        }

        this.toast(
            "موفق",
            "سند معکوس صادر شد.",
            "success"
        );

        if (newTxId) {
          this.$router.push({
            name: "tx-edit",
            params: {
              id: String(newTxId),
            },
          });
        } else {
          await this.load();
        }
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در Reverse",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },

    async deleteTx() {
      if (!this.tx.id) {
        return;
      }

      if (this.tx.transactionStatus !== "DRAFT") {
        return this.toast(
            "خطا",
            "فقط سند DRAFT قابل حذف است.",
            "warning"
        );
      }

      if (!confirm("سند حذف شود؟")) {
        return;
      }

      this.loading = true;

      try {
        await this.$store.dispatch(
            "transactions/deleteTransaction",
            this.tx.id
        );

        this.toast(
            "موفق",
            "سند حذف شد.",
            "success"
        );

        this.$router.push({
          name: "transactions.list",
        });
      } catch (e) {
        this.toast(
            "خطا",
            e.normalizedMessage || "خطا در حذف",
            "danger"
        );
      } finally {
        this.loading = false;
      }
    },
  },

  mounted() {
    this.load();
  },

  watch: {
    id() {
      this.load();
    },
  },
};
</script>

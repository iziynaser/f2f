<template>
  <div class="container-fluid mt-3">

    <b-card class="mb-3">

      <h4 class="mb-3">
        دفتر حساب
      </h4>

      <b-form @submit.prevent="loadLedger">

        <b-row>

          <b-col md="4">
            <b-form-group label="دوره مالی">

              <b-form-select
                  v-model="form.periodId"
                  :options="periodOptions">
              </b-form-select>

            </b-form-group>
          </b-col>

          <b-col md="4">
            <b-form-group label="حساب">

              <b-form-select
                  v-model="form.accountId"
                  :options="accountOptions">
              </b-form-select>

            </b-form-group>
          </b-col>

          <b-col md="2" class="align-self-end">

            <b-button
                type="submit"
                variant="primary"
                block>

              نمایش دفتر

            </b-button>

          </b-col>

        </b-row>

      </b-form>

    </b-card>

    <b-alert
        v-if="ledger"
        show
        variant="info"
        class="mb-3">

      <div>
        <strong>مانده اول دوره:</strong>
        {{ formatNumber(ledger.openingBalance) }}
      </div>

      <div>
        <strong>مانده پایان دوره:</strong>
        {{ formatNumber(ledger.closingBalance) }}
      </div>

    </b-alert>

    <b-card v-if="ledger">

      <div class="mb-3">

        <h5>
          {{ ledger.account.accountCode }}
          -
          {{ ledger.account.name }}
        </h5>

      </div>

      <b-table
          striped
          bordered
          hover
          responsive
          small
          :items="ledger.entries"
          :fields="fields">

        <template #cell(debit)="data">
          {{ formatNumber(data.item.debit) }}
        </template>

        <template #cell(credit)="data">
          {{ formatNumber(data.item.credit) }}
        </template>

        <template #cell(balance)="data">
          {{ formatNumber(data.item.balance) }}
        </template>

      </b-table>

    </b-card>

  </div>
</template>

<script>

import ledgerService from '@/services/ledgerService'

export default {

  name: 'AccountLedger',

  data() {
    return {

      form: {
        accountId: null,
        periodId: null
      },

      ledger: null,

      fields: [
        {
          key: 'date',
          label: 'تاریخ'
        },
        {
          key: 'transactionNumber',
          label: 'شماره سند'
        },
        {
          key: 'description',
          label: 'شرح'
        },
        {
          key: 'debit',
          label: 'بدهکار'
        },
        {
          key: 'credit',
          label: 'بستانکار'
        },
        {
          key: 'balance',
          label: 'مانده'
        }
      ],

      periodOptions: [
        {
          value: null,
          text: 'انتخاب دوره مالی'
        }
      ],

      accountOptions: [
        {
          value: null,
          text: 'انتخاب حساب'
        }
      ]

    }
  },

  methods: {

    async loadLedger() {

      if (!this.form.accountId || !this.form.periodId) {
        this.$bvToast.toast('حساب و دوره مالی را انتخاب کنید', {
          title: 'خطا',
          variant: 'danger',
          solid: true
        })

        return
      }

      try {

        const response = await ledgerService.getAccountLedger(
            this.form.accountId,
            this.form.periodId
        )

        this.ledger = response.data

      } catch (e) {

        console.error(e)

        this.$bvToast.toast('خطا در دریافت اطلاعات', {
          title: 'خطا',
          variant: 'danger',
          solid: true
        })
      }
    },

    formatNumber(value) {

      if (value == null) {
        return 0
      }

      return new Intl.NumberFormat().format(value)
    },

    async loadPeriods() {

      /*
      این بخش را به API واقعی خود متصل کنید
      */

      this.periodOptions = [
        {
          value: null,
          text: 'انتخاب دوره مالی'
        },
        {
          value: 1,
          text: 'دوره مالی 1404'
        }
      ]
    },

    async loadAccounts() {

      /*
      این بخش را به API واقعی حساب‌ها متصل کنید
      */

      this.accountOptions = [
        {
          value: null,
          text: 'انتخاب حساب'
        },
        {
          value: 1,
          text: 'بانک'
        },
        {
          value: 2,
          text: 'صندوق'
        }
      ]
    }

  },

  async mounted() {

    await this.loadPeriods()
    await this.loadAccounts()

  }

}
</script>

<style scoped>

.container-fluid {
  direction: rtl;
}

</style>

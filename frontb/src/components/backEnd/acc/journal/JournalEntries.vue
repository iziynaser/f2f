<template>
  <b-container fluid>
    <h4 class="mb-3">لیست اسناد روزنامه</h4>

    <b-card class="mb-3" header="فیلترها">
      <b-form @submit.prevent="loadJournal">
        <b-row>
          <b-col md="3" class="mb-2">
            <label>از تاریخ</label>
            <b-form-datepicker v-model="filter.fromDate" :date-format="dateFormat" placeholder="از تاریخ" />
          </b-col>

          <b-col md="3" class="mb-2">
            <label>تا تاریخ</label>
            <b-form-datepicker v-model="filter.toDate" :date-format="dateFormat" placeholder="تا تاریخ" />
          </b-col>

          <b-col md="3" class="mb-2">
            <label>شماره سند</label>
            <b-form-input v-model="filter.txNo" placeholder="شماره سند" />
          </b-col>

          <b-col md="3" class="mb-2">
            <label>شرح</label>
            <b-form-input v-model="filter.description" placeholder="شرح" />
          </b-col> <!-- اینجا اصلاح شد -->
        </b-row>

        <b-row class="mt-3">
          <b-col md="12" class="text-left">
            <b-button type="submit" variant="primary" :disabled="loading">جستجو</b-button>
            <b-button class="ml-2" variant="outline-secondary" @click="resetFilter" :disabled="loading">پاک کردن فیلتر</b-button>
          </b-col>
        </b-row>
      </b-form>
    </b-card>

    <b-alert v-if="errorMessage" variant="danger" show class="mb-3">{{ errorMessage }}</b-alert>

    <b-card>
      <template #header>
        <div class="d-flex justify-content-between align-items-center">
          <span>اسناد روزنامه</span>
          <b-badge variant="info">تعداد: {{ journals.length }}</b-badge>
        </div>
      </template>

      <b-table :items="journals" :fields="fields" striped hover bordered small :busy="loading" show-empty :tbody-tr-class="rowClass">
        <template #table-busy>
          <div class="text-center my-2">
            <b-spinner small type="grow"></b-spinner>
            <span class="ml-2">در حال دریافت اطلاعات...</span>
          </div>
        </template>

        <template #cell(actions)="row">
          <b-button size="sm" variant="outline-primary" @click="row.toggleDetails">
            {{ row.detailsShowing ? 'بستن' : 'جزئیات' }}
          </b-button>
        </template>

        <template #row-details="row">
          <b-card class="mb-0">
            <b-row class="mb-2">
              <b-col md="4"><strong>تاریخ:</strong> {{ row.item.transactionDate }}</b-col>
              <b-col md="4"><strong>شماره:</strong> {{ row.item.transactionNumber }}</b-col>
              <b-col md="4"><strong>شرح:</strong> {{ row.item.description }}</b-col>
            </b-row>
            <b-table :items="row.item.accountTransactionDetails" :fields="detailFields" small bordered responsive="sm">
              <template #cell(debit)="d"><span>{{ d.item.debit ? d.item.debit.toLocaleString() : 0 }}</span></template>
              <template #cell(credit)="d"><span>{{ d.item.credit ? d.item.credit.toLocaleString() : 0 }}</span></template>
            </b-table>
          </b-card>
        </template>

        <template #cell(totalDebit)="row"><span>{{ row.item.totalDebit ? row.item.totalDebit.toLocaleString() : 0 }}</span></template>
        <template #cell(totalCredit)="row"><span>{{ row.item.totalCredit ? row.item.totalCredit.toLocaleString() : 0 }}</span></template>
      </b-table>
    </b-card>
  </b-container>
</template>

<script>
export default {
  name: 'JournalEntries',
  data() {
    return {
      loading: false,
      errorMessage: null,
      dateFormat: 'yyyy-MM-dd',
      filter: { fromDate: null, toDate: null, txNo: null, description: null },
      journals: [],
      fields: [
        { key: 'transactionDate', label: 'تاریخ', sortable: true },
        { key: 'transactionNumber', label: 'شماره سند', sortable: true },
        { key: 'description', label: 'شرح' },
        { key: 'totalDebit', label: 'جمع بدهکار' },
        { key: 'totalCredit', label: 'جمع بستانکار' },
        { key: 'actions', label: 'عملیات' }
      ],
      detailFields: [
        { key: 'accountCode', label: 'کد حساب' },
        { key: 'accountTitle', label: 'نام حساب' },
        { key: 'description', label: 'شرح ردیف' },
        { key: 'debit', label: 'بدهکار' },
        { key: 'credit', label: 'بستانکار' }
      ]
    }
  },
  methods: {
    rowClass(item) {
      if (!item) return ''
      return item.totalDebit !== item.totalCredit ? 'table-danger' : ''
    },
    resetFilter() {
      this.filter = { fromDate: null, toDate: null, txNo: null, description: null };
      this.journals = [];
    },
    async loadJournal() {
      this.loading = true;
      this.errorMessage = null;
      try {
        const res = await this.$axios.post('/api/reports/journal', this.filter);
        this.journals = res.data.data || [];
      } catch (e) {
        if (e && e.response && e.response.data && e.response.data.message) {
          this.errorMessage = e.response.data.message;
        } else {
          this.errorMessage = 'خطا در ارتباط با سرور';
        }

      } finally {
        this.loading = false;
      }
    }
  }
}
</script>

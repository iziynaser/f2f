<template>
  <b-container fluid>
    <h4 class="mb-3">خلاصه اسناد روزنامه</h4>

    <b-card class="mb-3" header="فیلترها">
      <b-form @submit.prevent="loadSummary">
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
          </b-col> <!-- اصلاح شد -->
        </b-row>
        <b-row class="mt-3">
          <b-col md="12">
            <b-button type="submit" variant="primary" :disabled="loading">جستجو</b-button>
          </b-col>
        </b-row>
      </b-form>
    </b-card>

    <b-table :items="rows" :fields="fields" striped hover bordered small :busy="loading" show-empty>
      <template #cell(debit)="row"><span>{{ row.item.debit.toLocaleString() }}</span></template>
      <template #cell(credit)="row"><span>{{ row.item.credit.toLocaleString() }}</span></template>
    </b-table>
  </b-container>
</template>

<script>
export default {
  name: 'JournalSummary',
  data() {
    return {
      loading: false,
      dateFormat: 'yyyy-MM-dd',
      filter: { fromDate: null, toDate: null, txNo: null, description: null },
      rows: [],
      fields: [
        { key: 'transactionDate', label: 'تاریخ' },
        { key: 'transactionNumber', label: 'شماره' },
        { key: 'description', label: 'شرح' },
        { key: 'debit', label: 'بدهکار', class: 'text-right' },
        { key: 'credit', label: 'بستانکار', class: 'text-right' }
      ]
    }
  },
  methods: {
    async loadSummary() {
      this.loading = true;
      try {
        const res = await this.$axios.post('/api/reports/journal/summary', this.filter);
        this.rows = res.data.data || [];
      } finally {
        this.loading = false;
      }
    }
  }
}
</script>

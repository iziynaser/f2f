<template>
  <b-container fluid>
    <h4 class="mb-3">گردش حساب</h4>

    <b-card class="mb-3">
      <b-form @submit.prevent="loadAccountJournal">
        <b-row>
          <b-col md="4">
            <label>حساب</label>
            <b-form-select v-model="accountId" :options="accountOptions">
              <template #first><b-form-select-option :value="null" disabled>انتخاب حساب...</b-form-select-option></template>
            </b-form-select>
          </b-col>
          <b-col md="3">
            <label>از تاریخ</label>
            <b-form-datepicker v-model="filter.fromDate" :date-format="dateFormat" />
          </b-col>
          <b-col md="3">
            <label>تا تاریخ</label>
            <b-form-datepicker v-model="filter.toDate" :date-format="dateFormat" />
          </b-col>
          <b-col md="2" class="d-flex align-items-end">
            <b-button type="submit" variant="primary" block :disabled="!accountId || loading">نمایش</b-button>
          </b-col>
        </b-row>
      </b-form>
    </b-card>

    <div v-if="journal.lines.length > 0">
      <b-alert variant="info" show>مانده اول دوره: {{ journal.openingBalance.toLocaleString() }}</b-alert>
      <b-table :items="journal.lines" :fields="fields" bordered small striped>
        <template #cell(debit)="r"><span>{{ r.item.debit.toLocaleString() }}</span></template>
        <template #cell(credit)="r"><span>{{ r.item.credit.toLocaleString() }}</span></template>
        <template #cell(balance)="r"><span>{{ r.item.balance.toLocaleString() }}</span></template>
      </b-table>
      <b-alert variant="success" show>مانده پایان دوره: {{ journal.closingBalance.toLocaleString() }}</b-alert>
    </div>
  </b-container>
</template>

<script>
export default {
  name: 'AccountJournal',
  data() {
    return {
      accountId: null,
      accounts: [],
      loading: false,
      dateFormat: 'yyyy-MM-dd',
      filter: { fromDate: null, toDate: null },
      journal: { openingBalance: 0, closingBalance: 0, lines: [] },
      fields: [
        { key: 'date', label: 'تاریخ' },
        { key: 'txNo', label: 'شماره' },
        { key: 'description', label: 'شرح' },
        { key: 'debit', label: 'بدهکار' },
        { key: 'credit', label: 'بستانکار' },
        { key: 'balance', label: 'مانده' }
      ]
    }
  },
  computed: {
    accountOptions() { return this.accounts.map(a => ({ value: a.id, text: `${a.code} - ${a.title}` })) }
  },
  methods: {
    async loadAccountJournal() {
      this.loading = true;
      try {
        const res = await this.$axios.post(`/api/reports/journal/account/${this.accountId}`, this.filter);
        this.journal = res.data.data;
      } finally { this.loading = false; }
    },
    async loadAccounts() {
      const res = await this.$axios.get('/api/accounts');
      this.accounts = res.data.data || [];
    }
  },
  mounted() { this.loadAccounts(); }
}
</script>

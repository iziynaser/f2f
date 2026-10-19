<template>
  <b-card class="shadow-sm">
    <b-table
        :items="items"
        :fields="fields"
        striped
        bordered
        hover
        responsive
        small
        show-empty
        empty-text="رکوردی یافت نشد"
        foot-clone
    >
      <template #cell(rowNo)="row">
        {{ row.index + 1 }}
      </template>

      <template #cell(accountCode)="row">
        <span class="font-weight-bold">{{ row.item.accountCode }}</span>
      </template>

      <template #cell(accountName)="row">
        <a href="#" @click.prevent="$emit('drill-down', row.item)">
          {{ row.item.accountName }}
        </a>
      </template>

      <template #cell(debitTotal)="row">
        <span class="text-success">{{ formatNumber(row.item.debitTotal) }}</span>
      </template>

      <template #cell(creditTotal)="row">
        <span class="text-danger">{{ formatNumber(row.item.creditTotal) }}</span>
      </template>

      <template #cell(netBalance)="row">
        <span :class="balanceClass(row.item.netBalance)">
          {{ formatNumber(row.item.netBalance) }}
        </span>
      </template>

      <template #foot(rowNo)>
        #
      </template>

      <template #foot(accountCode)>
        -
      </template>

      <template #foot(accountName)>
        <strong>جمع کل</strong>
      </template>

      <template #foot(debitTotal)>
        <strong class="text-success">{{ formatNumber(totalDebit) }}</strong>
      </template>

      <template #foot(creditTotal)>
        <strong class="text-danger">{{ formatNumber(totalCredit) }}</strong>
      </template>

      <template #foot(netBalance)>
        <strong :class="balanceClass(netDifference)">
          {{ formatNumber(netDifference) }}
        </strong>
      </template>
    </b-table>
  </b-card>
</template>

<script>
export default {
  name: 'TrialBalanceTable',
  props: {
    items: {
      type: Array,
      default: () => []
    },
    totalDebit: {
      type: [Number, String],
      default: 0
    },
    totalCredit: {
      type: [Number, String],
      default: 0
    }
  },
  computed: {
    netDifference() {
      return Number(this.totalDebit || 0) - Number(this.totalCredit || 0);
    },
    fields() {
      return [
        { key: 'rowNo', label: '#', thStyle: { width: '60px' }, tdClass: 'text-center' },
        { key: 'accountCode', label: 'کد حساب', thStyle: { width: '160px' } },
        { key: 'accountName', label: 'نام حساب' },
        { key: 'debitTotal', label: 'جمع بدهکار', tdClass: 'text-right', thClass: 'text-right' },
        { key: 'creditTotal', label: 'جمع بستانکار', tdClass: 'text-right', thClass: 'text-right' },
        { key: 'netBalance', label: 'مانده خالص', tdClass: 'text-right', thClass: 'text-right' }
      ];
    }
  },
  methods: {
    formatNumber(value) {
      return new Intl.NumberFormat('fa-IR').format(Number(value || 0));
    },
    balanceClass(balance) {
      const n = Number(balance || 0);
      if (n > 0) return 'text-success';
      if (n < 0) return 'text-danger';
      return 'text-dark';
    }
  }
};
</script>

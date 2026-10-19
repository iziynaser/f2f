<template>
  <b-row class="mb-3">
    <b-col md="4" sm="12" class="mb-2">
      <b-card class="shadow-sm border-right border-success border-3">
        <div class="summary-label">جمع بدهکار</div>
        <div class="summary-value text-success">{{ formatNumber(totalDebit) }}</div>
      </b-card>
    </b-col>

    <b-col md="4" sm="12" class="mb-2">
      <b-card class="shadow-sm border-right border-danger border-3">
        <div class="summary-label">جمع بستانکار</div>
        <div class="summary-value text-danger">{{ formatNumber(totalCredit) }}</div>
      </b-card>
    </b-col>

    <b-col md="4" sm="12" class="mb-2">
      <b-card class="shadow-sm border-right border-info border-3">
        <div class="summary-label">اختلاف</div>
        <div :class="['summary-value', difference === 0 ? 'text-success' : 'text-warning']">
          {{ formatNumber(difference) }}
        </div>
      </b-card>
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: 'TrialBalanceSummaryCards',
  props: {
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
    difference() {
      return Number(this.totalDebit || 0) - Number(this.totalCredit || 0);
    }
  },
  methods: {
    formatNumber(value) {
      return new Intl.NumberFormat('fa-IR').format(Number(value || 0));
    }
  }
};
</script>

<style scoped>
.summary-label {
  color: #6c757d;
  font-size: 13px;
}
.summary-value {
  font-size: 22px;
  font-weight: 700;
  margin-top: 8px;
}
</style>

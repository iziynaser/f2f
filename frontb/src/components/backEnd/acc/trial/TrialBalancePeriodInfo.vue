<template>
  <b-card v-if="period" class="mb-3 shadow-sm">
    <b-row>
      <b-col md="2" sm="6" class="mb-2">
        <div class="label">سال مالی</div>
        <div class="value">{{ period.fiscalYear || '-' }}</div>
      </b-col>

      <b-col md="3" sm="6" class="mb-2">
        <div class="label">نام دوره</div>
        <div class="value">{{ period.periodName || '-' }}</div>
      </b-col>

      <b-col md="2" sm="6" class="mb-2">
        <div class="label">شماره دوره</div>
        <div class="value">{{ period.periodNumber || '-' }}</div>
      </b-col>

      <b-col md="2" sm="6" class="mb-2">
        <div class="label">از تاریخ</div>
        <div class="value">{{ period.fromDate || '-' }}</div>
      </b-col>

      <b-col md="2" sm="6" class="mb-2">
        <div class="label">تا تاریخ</div>
        <div class="value">{{ period.toDate || '-' }}</div>
      </b-col>

      <b-col md="1" sm="6" class="mb-2">
        <div class="label">وضعیت</div>
        <b-badge :variant="period.isClosed ? 'danger' : 'success'">
          {{ period.isClosed ? 'بسته' : 'باز' }}
        </b-badge>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'TrialBalancePeriodInfo',
  props: {
    period: {
      type: Object,
      default: null
    }
  }
};
</script>

<style scoped>
.label {
  color: #6c757d;
  font-size: 12px;
}
.value {
  font-weight: 600;
  margin-top: 4px;
}
</style>

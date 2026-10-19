<template>
  <b-card class="mb-3 shadow-sm">
    <div class="d-flex flex-wrap justify-content-between align-items-center">
      <div class="mb-2 mb-md-0">
        <h4 class="mb-0">گزارش تراز آزمایشی</h4>
        <small class="text-muted">نمایش جمع بدهکار و بستانکار حساب‌ها در یک دوره مالی</small>
      </div>

      <div class="d-flex flex-wrap">
        <b-button variant="outline-secondary" class="ml-2 mb-1" @click="$emit('refresh')">
          بروزرسانی
        </b-button>

        <b-button variant="outline-success" class="ml-2 mb-1" @click="$emit('export-csv')">
          خروجی CSV
        </b-button>

        <b-button variant="outline-danger" class="ml-2 mb-1" @click="$emit('export-pdf')">
          PDF
        </b-button>

        <b-button variant="primary" class="mb-1" @click="$emit('print')">
          چاپ
        </b-button>
      </div>
    </div>
  </b-card>
</template>

<script>
export default {
  name: 'TrialBalanceToolbar'
};
</script>

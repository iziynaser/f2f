<template>
  <b-alert :variant="isBalanced ? 'success' : 'warning'" show class="mb-0">
    <div class="d-flex justify-content-between">
      <div>جمع بدهکار: <strong>{{ fmt(totalDebit) }}</strong></div>
      <div>جمع بستانکار: <strong>{{ fmt(totalCredit) }}</strong></div>
      <div>
        وضعیت:
        <strong v-if="isBalanced">تراز</strong>
        <strong v-else>نامتوازن (اختلاف: {{ fmt(diff) }})</strong>
      </div>
    </div>
  </b-alert>
</template>

<script>
export default {
  props: {
    totalDebit: { type: Number, required: true },
    totalCredit: { type: Number, required: true },
  },
  computed: {
    isBalanced() {
      return this.totalDebit > 0 && this.totalDebit === this.totalCredit;
    },
    diff() {
      return Math.abs((this.totalDebit || 0) - (this.totalCredit || 0));
    },
  },
  methods: {
    fmt(n) {
      return Number(n || 0).toLocaleString();
    },
  },
};
</script>

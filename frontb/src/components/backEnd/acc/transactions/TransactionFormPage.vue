<template>
  <b-container fluid class="py-4" dir="rtl">
    <TransactionForm :id="id" />
  </b-container>
</template>

<script>
import TransactionForm from "./TransactionForm.vue";

export default {
  components: { TransactionForm },
  props: {
    id: { type: String, default: null },
  },
};
</script>

<template>
  <div class="container py-4">
    <h4>انتخاب روش پرداخت</h4>

    <div class="payment-options">
      <div
          v-for="method in methods"
          :key="method.value"
          class="payment-box d-flex align-items-center"
          :class="{ selected: selectedMethod === method.value }"
          @click="selectedMethod = method.value"
      >
        <b-icon :icon="method.icon" font-scale="1.8" class="mr-3" />
        <div>
          <h5 class="mb-0">{{ method.text }}</h5>
        </div>
        <b-form-radio v-model="selectedMethod" :value="method.value" class="d-none" />
      </div>
    </div>

    <!-- اگر پرداخت آنلاین انتخاب شد -->
    <payment-gateway-select v-if="selectedMethod === 'online'" />

    <!-- اگر پرداخت در محل انتخاب شد -->
    <div v-else-if="selectedMethod === 'cod'" class="mt-3">
      <b-button variant="primary" block @click="handleCOD">
        پرداخت در محل - ثبت سفارش
      </b-button>
    </div>
  </div>
</template>

<script>
import PaymentGatewaySelect from './PaymentGatewaySelect.vue';  // مسیر درست وارد شود
import { mapGetters } from 'vuex';

export default {
  name: 'PaymentMethodSelect',
  components: {
    PaymentGatewaySelect
  },
  data() {
    return {
      selectedMethod: null,
      methods: [
        { text: 'پرداخت آنلاین', value: 'online', icon: 'credit-card' },
        { text: 'پرداخت در محل', value: 'cod', icon: 'cash-stack' }
      ]
    };
  },
  computed: {
    ...mapGetters('order', ['currentOrder'])
  },
  methods: {
    handleCOD() {
      alert('پرداخت در محل انتخاب شد. سفارش شما ثبت می‌شود.');
      this.$router.push('/registerOrder');
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: auto;
}

.payment-options {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.payment-box {
  border: 2px solid #ccc;
  border-radius: 8px;
  padding: 1rem;
  cursor: pointer;
  transition: all 0.3s ease;
  background-color: white;
}

.payment-box:hover {
  border-color: #007bff;
}

.payment-box.selected {
  border-color: #007bff;
  background-color: #e7f1ff;
}
</style>

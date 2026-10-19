<template>
  <div class="container py-4" style="max-width: 700px;">
    <h4 class="mb-4">انتخاب درگاه پرداخت</h4>

    <b-alert variant="warning" v-if="!gateways.length" show>
      هیچ درگاه فعالی یافت نشد.
    </b-alert>

    <b-list-group>
      <b-list-group-item
          v-for="gw in gateways"
          :key="gw.id"
          :active="selectedGateway === gw.gatewayType"
          @click="selectedGateway = gw.gatewayType"
          button
      >
        <strong>{{ gw.gatewayType }}</strong> - {{ gw.description || '...' }}
      </b-list-group-item>
    </b-list-group>

    <b-button
        class="mt-3"
        variant="success"
        block
        :disabled="!selectedGateway || !canSubmit"
        @click="startPaymentHandler"
    >
      شروع پرداخت
    </b-button>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  name: 'PaymentGatewaySelect',
  data() {
    return {
      selectedGateway: null
    };
  },
  computed: {
    ...mapGetters('payment', ['paymentGateways', 'paymentUrl']),
    ...mapGetters('order', ['currentOrder']),
    gateways() {
      return this.paymentGateways || [];
    },
    canSubmit() {
      return this.currentOrder && this.currentOrder.id;
    }
  },
  methods: {
    ...mapActions('payment', ['fetchPaymentGateways', 'initiatePayment']),
    async startPaymentHandler() {
      if (!this.canSubmit || !this.selectedGateway) return;

      await this.initiatePayment({
        orderId: this.currentOrder.id,
        gateway: this.selectedGateway
      });

      if (this.paymentUrl) {
        window.location.href = this.paymentUrl;
      } else {
        alert('آدرس درگاه دریافت نشد.');
      }
    }
  },
  async created() {
    await this.fetchPaymentGateways();
    console.log(this.gateways);
    if (this.gateways.length > 0) {
      // اختصاص دادن اولین درگاه یا درگاه پیش‌فرض
      const defaultGateway = this.gateways.find(gw => gw.defaultGateway);
      this.selectedGateway = defaultGateway ? defaultGateway.gatewayType : this.gateways[0].gatewayType;
    }
  }
};
</script>

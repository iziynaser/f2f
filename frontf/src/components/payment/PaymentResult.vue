<template>
  <div class="container py-4 text-center">
    <h4>نتیجه پرداخت</h4>
    <b-alert :variant="statusVariant" show>
      {{ paymentMessage }}
    </b-alert>
    <b-button to="/" variant="primary">بازگشت به صفحه اصلی</b-button>
  </div>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex';

export default {
  name: 'PaymentResult',

  computed: {
    ...mapGetters('payment', ['paymentStatus', 'paymentMessage']),
    statusVariant: function () {
      return this.paymentStatus === 'success' ? 'success' : 'danger';
    }
  },

  methods: {
    ...mapActions('payment', ['finalizePayment']),
    ...mapMutations('payment', ['setPaymentStatus', 'setPaymentMessage'])
  },

  async created() {
    var query = this.$route.query;
    var authority = query.authority;
    var token = query.token;

    console.log('query params:', query);

    if (!authority || !token) {
      this.setPaymentStatus('failed');
      this.setPaymentMessage('اطلاعات بازگشتی نامعتبر است');
      return;
    }

    var paymentResult = {
      authority: authority,
      token: token
    };

    await this.finalizePayment(paymentResult);
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: auto;
}
</style>

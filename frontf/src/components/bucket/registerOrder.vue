<template>
  <div class="container py-4" style="max-width: 700px;">
    <h4 class="mb-4">نهایی‌سازی و ثبت سفارش</h4>

    <!-- نمایش آدرس و زمان تحویل -->
    <b-card class="mb-3" v-if="address && address.id">
      <b-card-header>آدرس و زمان تحویل انتخاب شده</b-card-header>
      <b-card-body>
        <p>
          {{ (address.ostanId && address.ostanName) || '' }}،
          {{ (address.shahrId && address.shahrName) || '' }}،
          {{ address.postalAddress || '' }}<br />
          واحد: {{ address.unit || '' }}، پلاک: {{ address.pelak || '' }}
        </p>
        <p>تحویل گیرنده: {{ address.deliverName || '' }} {{ address.deliverFamily || '' }}</p>
        <p>موبایل: {{ address.mobileNo1 || '' }}</p>
        <p>کد پستی: {{ address.postalCode || '' }}</p>
        <p>
          <strong>روز تحویل:</strong> {{ deliveryDayText }} |
          <strong>بازه زمانی:</strong> {{ deliveryTime }}
        </p>
      </b-card-body>
    </b-card>

    <!-- خلاصه سفارش -->
    <b-card class="mb-3" v-if="orderItems && orderItems.length > 0">
      <b-card-header>خلاصه سفارش</b-card-header>
      <b-card-body>
        <p>تعداد کالاها: {{ orderItems.length }}</p>
        <p>قیمت کل: {{ formattedOrderTotal }} تومان</p>
      </b-card-body>
    </b-card>

    <!-- یادداشت سفارش -->
    <b-form-group label="توضیحات سفارش (اختیاری):" class="mb-3">
      <b-form-textarea v-model="note" rows="3" placeholder="اگر نکته‌ای دارید وارد کنید" />
    </b-form-group>

    <!-- انتخاب روش پرداخت -->
<!--    <b-form-group label="روش پرداخت:" class="mb-3">-->
<!--      <b-form-radio-group v-model="paymentMethod" :options="paymentMethods" buttons button-variant="outline-primary" />-->
<!--    </b-form-group>-->

    <!-- دکمه ثبت سفارش -->
    <b-button variant="success" block @click="submitOrderHandler" :disabled="isSubmitting || !canSubmit">
      <b-spinner small v-if="isSubmitting" label="در حال ارسال..." class="ml-2"></b-spinner>
      ثبت سفارش و ادامه
    </b-button>

  </div>
</template>

<script>
import { mapGetters, mapActions, mapMutations } from 'vuex';

export default {
  name: 'RegisterOrder',
  data() {
    return {
      // paymentMethod: 'cod',
      // paymentMethods: [
      //   { text: 'پرداخت در محل', value: 'cod' },
      //   { text: 'پرداخت آنلاین', value: 'online' }
      // ],
      note: '',
      isSubmitting: false,
      orderStatus: null
    };
  },
  computed: {
    ...mapGetters('delivery', ['defaultDelivery']),
    ...mapGetters('order', ['currentOrder', 'orderMessage']),
    address() {
      return this.defaultDelivery || {};
    },
    deliveryDayText() {
      return this.address.deliveryDay || 'تعریف نشده';
    },
    deliveryTime() {
      return this.address.deliveryTime || 'تعریف نشده';
    },
    orderItems() {
      return (this.currentOrder && this.currentOrder.items) || [];
    },
    formattedOrderTotal() {
      const total = this.currentOrder && this.currentOrder.totalPrice;
      return total ? total.toLocaleString() : '0';
    },
    canSubmit() {
      return (
        this.address.id &&
        this.orderItems.length > 0 &&
        this.deliveryDayText !== 'تعریف نشده' &&
        this.deliveryTime !== 'تعریف نشده'
      );
    }
  },
  methods: {
    ...mapActions('order', ['submitOrder', 'prepareCurrentOrderFromCart']),
    ...mapMutations('order', ['setOrderMessage']),
    async prepareOrder() {
      await this.prepareCurrentOrderFromCart(); // تهیه سفارش از سبد
    },
    clearOrderMessage() {
      this.setOrderMessage('');
      this.orderStatus = null;
    },
    async submitOrderHandler() {
      if (!this.canSubmit) {
        this.orderStatus = 'failed';
        return;
      }
      this.isSubmitting = true;
      this.clearOrderMessage();

      try {
        const result = await this.submitOrder(this.note);
        //console.log('res:', result);

        if (result.success) {
          this.$bvToast.toast(result.message, {
            title: 'سبد خرید',
            variant: 'success',
            solid: true,
            toaster: 'b-toaster-top-center',
            autoHideDelay: 3000
          });

          //const route = this.paymentMethod === 'online' ? '/payment' : '/order-success';
          const orderId = result.body.id ;
          this.$router.push({ name: 'PaymentPage', query: { orderId } });

          // if (this.paymentMethod === 'online') {
          //   this.$router.push({ name: 'PaymentPage', query: { orderId } });
          // } else {
          //   //console.log('orderId:', result.body.id);
          //   this.$router.push({ name: 'OrderSuccess', params: { orderId: orderId } });
          // }
        } else {
          this.$bvToast.toast('ثبت سفارش با خطا مواجه شد.', {
            title: 'خطا',
            variant: 'danger',
            solid: true,
            toaster: 'b-toaster-top-center',
            autoHideDelay: 3000
          });
        }
      } catch (err) {
        this.orderStatus = 'failed';
        this.setOrderMessage('ثبت سفارش با خطا مواجه شد.');
        console.log('Order error:', err);
      } finally {
        this.isSubmitting = false;
      }
    }

  },
  created() {
    if (!this.address.id) {
      console.log('آدرس انتخاب نشده است');
    }

    if (!this.orderItems.length) {
      console.log('اقلام سفارش وجود ندارد');
      this.prepareOrder(); // فراخوانی اکشن جدید
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 700px;
  margin: auto;
}
</style>

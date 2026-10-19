<template>
  <div class="container py-4 text-right" dir="rtl" style="max-width: 700px;">

    <b-spinner v-if="loading" label="در حال بارگذاری سفارش..."></b-spinner>

    <b-card class="mb-3 border-success">
      <template #header>
        <h5 class="mb-0 text-success">سفارش با موفقیت ثبت شد!</h5>
      </template>

      <p>سفارش شما با کد <strong>{{ order.orderCode }}</strong> ثبت شد.</p>
      <p>تاریخ ثبت سفارش: {{ formattedOrderDate }}</p>
      <p>تاریخ تحویل: {{ formattedDeliveryDate }}</p>
      <p>بازه زمانی تحویل: {{ formattedDeliveryTime }}</p>
      <p>وضعیت فعلی سفارش: {{ orderStatusText }}</p>
      <p>مبلغ کل سفارش: {{ formattedTotalAmount }} تومان</p>
    </b-card>

    <b-card v-if="order.items && order.items.length > 0" header="اقلام سفارش" class="mb-3 text-right">
      <ul>
        <li v-for="item in order.items" :key="item.id">
          {{ item.productName }} - تعداد: {{ item.quantity }} - قیمت: {{ formatPrice(item.price) }} تومان
        </li>
      </ul>
    </b-card>

    <b-button variant="primary" block @click="$router.push('/')">بازگشت به صفحه اصلی</b-button>
  </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
    name: "OrderSuccess",
    props: {
    },
    data() {
        return {
            order: null,
            loading: false,
            error: null
        };
    },
    async created() {
        this.loading = true;
        try {
            const orderId = this.$route.params.orderId
            this.order = await this.fetchOrderById(orderId);
        } catch (err) {
            this.error = 'بار گذاری سفارش با مشکل مواجه شد';
            console.log(err);
        } finally {
            this.loading = false;
        }
    },
    computed: {
        formattedOrderDate() {
            return this.formatDateTime(this.order.orderDate);
        },
        formattedDeliveryDate() {
            return this.formatDate(this.order.deliveryDate);
        },
        formattedDeliveryTime() {
            // فرض: رشته زمان به صورت "08:00:00"
            return this.order.deliveryTime ? this.order.deliveryTime.substring(0, 5) : "تعریف نشده";
        },
        formattedTotalAmount() {
            return this.order.totalAmount ? this.order.totalAmount.toLocaleString() : "0";
        },
        orderStatusText() {
            const mapStatus = {
                PRE_ORDER: "در انتظار",
                CONFIRMED: "تأیید شده",
                SHIPPED: "ارسال شده",
                DELIVERED: "تحویل داده شده",
                CANCELED: "لغو شده",
            };
            return mapStatus[this.order.currentStatus] || this.order.currentStatus;
        },
    },
    methods: {
      ...mapActions('order', ['fetchOrderById']),
        formatDate(dateStr) {
            if (!dateStr) return "تعریف نشده";
            const d = new Date(dateStr);
            return d.toLocaleDateString("fa-IR");
        },
        formatDateTime(dateTimeStr) {
            if (!dateTimeStr) return "تعریف نشده";
            const d = new Date(dateTimeStr);
            return d.toLocaleString("fa-IR");
        },
        formatPrice(value) {
            return value ? value.toLocaleString() : "0";
        },
    },
};
</script>

<style scoped>
.container {
    max-width: 700px;
    margin: auto;
}
</style>

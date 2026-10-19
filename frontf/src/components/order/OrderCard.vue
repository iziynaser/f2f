<template>
    <b-card class="mb-3">
        <div class="d-flex justify-content-between">
            <div>
                <div><strong>تاریخ سفارش:</strong> {{ order.orderDate | jalaliDate }}</div>
                <div><strong>کد سفارش:</strong> {{ order.orderCode }}</div>
                <div>
                    <strong>{{ statusIcon(order.currentStatus).label }}</strong>
                    <b-icon :icon="statusIcon(order.currentStatus).icon"
                        :variant="statusIcon(order.currentStatus).variant" v-b-tooltip.hover />
                </div>
            </div>
            <div class="text-right">
                <div><strong>مبلغ کل:</strong> {{ order.totalAmount }} تومان</div>
                <b-button @click="toggleOrderItems" variant="outline-primary" size="sm">
                    {{ showItems ? 'بستن سفارش' : 'مشاهده سفارش' }}
                </b-button>
            </div>
        </div>

        <hr v-if="showItems" />

        <div v-if="showItems">
            <div v-if="loading" class="text-center text-muted">
                در حال بارگذاری...
            </div>
            <div v-else>
                <OrderItem v-for="item in orderItems" :key="item.orderItemId" :item="item" />
            </div>
        </div>
    </b-card>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';
import OrderItem from './OrderItem.vue';

export default {
    name: 'OrderCard',
    props: {
        order: { type: Object, required: true }
    },
    components: { OrderItem },
    data() {
        return {
            showItems: false,
            loading: false,
            orderItems: []
        };
    },
    methods: {
        statusIcon(status) {
            switch (status) {
                case 'CREATED':
                    return { icon: 'clock', variant: 'secondary', label: 'ایجاد شده' };
                case 'PAID':
                    return { icon: 'credit-card', variant: 'info', label: 'پرداخت شده' };
                case 'PROCESSING':
                    return { icon: 'gear', variant: 'warning', label: 'در حال پردازش' };
                case 'DELIVERED':
                    return { icon: 'check-circle', variant: 'success', label: 'تحویل داده شده' };
                case 'RETURNED':
                    return { icon: 'arrow-counterclockwise', variant: 'danger', label: 'مرجوعی' };
                case 'CANCELED':
                    return { icon: 'x-circle', variant: 'dark', label: 'لغو شده' };
                default:
                    return { icon: 'question-circle', variant: 'muted', label: 'نامشخص' };
            }
        },
        toggleOrderItems() {
            this.showItems = !this.showItems;
            if (this.showItems && this.orderItems.length === 0) {
                this.fetchOrderItems();
            }
        },
        fetchOrderItems() {
            this.loading = true;
          axiosInstance.get(`/orders/${this.order.orderCode}/items`)
                .then(response => {
                    this.orderItems = response.data;
                })
                .catch(error => {
                    console.error('خطا در دریافت اقلام سفارش:', error);
                })
                .finally(() => {
                    this.loading = false;
                });
        },
        formatCurrency(amount) {
            if (!amount) return '۰';
            return amount.toLocaleString('fa-IR');
        }
    }
};
</script>

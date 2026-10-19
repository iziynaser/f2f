<!-- OrderItem.vue -->
<template>
    <b-card class="mb-2 p-2">
        <b-row>
            <b-col cols="3">
                <b-img :src="item.imageUrl || defaultImage" alt="product image" fluid class="rounded border" />
            </b-col>
            <b-col cols="9">
                <div><strong>کالا:</strong> {{ item.productName }}</div>
                <div><strong>کد:</strong> {{ item.productItemCode }}</div>
                <div v-if="item.productColor"><strong>رنگ:</strong> {{ item.productColor }}</div>
                <div v-if="item.productSize"><strong>سایز:</strong> {{ item.productSize }}</div>
                <div><strong>قیمت واحد:</strong> {{ formatCurrency(item.defaultPrice) }} تومان</div>
                <div><strong>تعداد:</strong> {{ item.quantity }}</div>
                <div><strong>جمع:</strong> {{ formatCurrency(item.totalAmount) }} تومان</div>
            </b-col>
        </b-row>
    </b-card>
</template>

<script>
export default {
    name: 'OrderItem',
    props: {
        item: { type: Object, required: true }
    },
    computed: {
        totalAmount() {
            return (this.item.defaultPrice || 0) * (this.item.quantity || 1);
        },
        defaultImage() {
            return '/assets/images/no-image.png'; // مسیر پیش‌فرض تصویر
        }
    },
    methods: {
        formatCurrency(amount) {
            if (!amount) return '۰';
            return amount.toLocaleString('fa-IR');
        }
    }
};
</script>

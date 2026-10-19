<template>
    <div class="border p-3 rounded shadow-sm">
        <!-- قیمت -->
        <div class="mb-3">
            <div class="h5 mb-0 text-success font-weight-bold">
                {{ formattedFinalPrice }}
            </div>
            <div v-if="hasDiscount" class="text-muted small">
                <s>{{ formattedBasePrice }}</s> &nbsp;
                <span class="badge badge-danger">{{ discountPercent }}٪ تخفیف</span>
            </div>
        </div>



    </div>
</template>

<script>

//import { mapGetters } from 'vuex';

export default {
    name: 'ProductPriceAddToCart',
    props: {
        basePrice: Number,
        finalPrice: Number,
        discountName: String,
    },
    computed: {
        hasDiscount() {
            return this.finalPrice < this.basePrice;
        },
        discountPercent() {
            const discount = ((this.basePrice - this.finalPrice) / this.basePrice) * 100;
            return Math.round(discount);
        },
        formattedBasePrice() {
            return this.formatPrice(this.basePrice);
        },
        formattedFinalPrice() {
            return this.formatPrice(this.finalPrice);
        },
    },
    methods: {
        formatPrice(price) {
            return price.toLocaleString('fa-IR') + ' تومان';
        },
        addToCart() {
            this.$emit('add-to-cart');
        }
    }
};
</script>

<style scoped>
.badge-danger {
    font-size: 0.8rem;
}
</style>

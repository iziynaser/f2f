<template>
    <div>
        <b-dropdown no-caret variant="link" toggle-class="text-decoration-none" right>
            <template #button-content>
                <b-button variant="outline-primary" size="md" class="position-relative">
                    <b-icon-bucket-fill />
                    <b-badge v-if="cartSize > 0" variant="danger"
                        class="position-absolute top-0 start-100 translate-middle rounded-circle"
                        style="font-size: 0.7rem; width: 1.3rem; height: 1.3rem; padding: 0.1rem;">
                        {{ cartSize }}
                    </b-badge>
                </b-button>
            </template>

            <!-- وقتی سبد خالی است -->
            <b-dropdown-item v-if="cartSize === 0" disabled>
                {{ $t('SHOPPING_CART_bucketIsEmpty') || 'سبد خرید شما خالی است' }}
            </b-dropdown-item>

            <!-- وقتی سبد خالی نیست -->
            <div v-else>
                <b-dropdown-item disabled class="font-weight-bold">
                    {{ cartSize }} {{ $t('SHOPPING_CART_product') || 'محصول' }}
                </b-dropdown-item>

                <b-dropdown-divider />

                <!-- نمایش حداکثر ۳ محصول -->
                <b-dropdown-item v-for="product in limitedProducts" :key="product.id" class="py-2">
                    <div class="d-flex align-items-center">
                        <b-img :src="urlI(product.cardImageUrl || '/images/default.png')" fluid thumbnail height="40"
                            width="40" class="mr-2" alt="product image" />
                        <div class="flex-grow-1 text-truncate" style="max-width: 160px;">
                            {{ product.name }}
                        </div>
                        <div class="mx-3">
                            <small>تعداد: {{ product.quantity }}</small>
                        </div>
                        <div>
                            <b-icon icon="plus" variant="success" class="mx-1 text-success cursor-pointer" role="button"
                                tabindex="0" @click.stop="addToCart(product.id)" v-b-tooltip.hover
                                title="افزایش تعداد" />
                            <b-icon icon="trash" variant="danger" class="mx-1 text-danger cursor-pointer" role="button"
                                tabindex="0" @click.stop="removeFromCart(product.id)" v-b-tooltip.hover
                                title="حذف از سبد" />
                        </div>
                    </div>
                </b-dropdown-item>

                <!-- اگر بیشتر از 3 محصول بود -->
                <b-dropdown-item v-if="hasMoreProducts" class="text-center small text-primary">
                    <b-link to="/bucketView" @click.native.stop>
                        +{{ cartSize - limitedProducts.length }} محصول دیگر...
                    </b-link>
                </b-dropdown-item>

                <b-dropdown-divider />

                <!-- جمع کل قابل پرداخت -->
                <b-dropdown-item disabled class="d-flex justify-content-between font-weight-bold">
                    <span>{{ $t('SHOPPING_CART_payableSum') || 'مبلغ قابل پرداخت' }}:</span>
                    <span>{{ formattedTotalAmount }} تومان</span>
                </b-dropdown-item>

                <b-dropdown-item class="text-center">
                    <b-button variant="success" size="sm" block to="/bucketView" @click.native.stop>
                        {{ $t('SHOPPING_CART_registerOrder') || 'ثبت سفارش' }}
                    </b-button>
                </b-dropdown-item>
            </div>
        </b-dropdown>
    </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import { baseUrl } from '../api/util'
import { formatPrice } from '../api/formatters'

export default {
    name: 'shoppingCart',
    computed: {
        ...mapGetters('cart', ['cartSize', 'cartTotalAmount', 'enrichedCart']),

        limitedProducts() {
            return this.enrichedCart.slice(0, 3)
        },
        hasMoreProducts() {
            return Array.isArray(this.enrichedCart) && this.enrichedCart.length > 3;
        },
        formattedTotalAmount() {
            return formatPrice(this.cartTotalAmount);
        }
    },
    methods: {
        ...mapActions('cart', ['addToCart', 'removeFromCart']),
        urlI(u) {
            return baseUrl(u)
        },
    }
}
</script>

<style scoped>
.cursor-pointer {
    cursor: pointer;
}

.text-truncate {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.position-relative {
    position: relative;
}

.position-absolute {
    position: absolute;
}

.top-0 {
    top: 0;
}

.start-100 {
    left: 100%;
}

.translate-middle {
    transform: translate(-50%, -50%);
}
</style>

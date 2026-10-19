<template>
  <div>
    <b-card class="product-card shadow-sm rounded-lg border-0 position-relative">

      <!-- دایره‌های رنگی بالا -->
      <div class="color-dots-vertical position-absolute" style="top: 10px; right: 10px;">
        <span v-for="(color, index) in product.colors" :key="index" class="color-circle mb-1" :title="color.name"
          :style="{ backgroundColor: color.code }">
        </span>
      </div>

      <!-- تصویر محصول -->
      <router-link :to="{ name: 'product', params: { id: product.id, title: product.name } }">
        <b-img :src="cardImage" fluid class="rounded-top" style="height: 200px; object-fit: cover;" />
      </router-link>

      <!-- بدنه کارت -->
      <b-card-body>
        <h5 class="text-primary">{{ product.name }}</h5>
        <h6 class="text-muted">{{ product.subtitle }}</h6>

        <!-- قیمت با تخفیف -->
        <div v-if="product.discountAmount && product.discountAmount > 0" class="mb-2">
          <div>
            <span class="text-muted small text-decoration-line-through">
              {{ product.basePrice.toLocaleString() }}
            </span>
          </div>
          <div class="d-flex align-items-center mt-1">
            <span class="text-danger fw-bold fs-5">
              {{ product.finalPrice.toLocaleString() }}
            </span>
            <span class="badge bg-danger text-white ms-2">
              {{ getDiscountPercent(product.basePrice, product.finalPrice) }}٪
            </span>
          </div>
        </div>

        <!-- قیمت بدون تخفیف -->
        <div v-else class="mb-2">
          <span class="text-success fw-bold fs-5">
            {{ (product.finalPrice || product.basePrice || 0).toLocaleString() }}
          </span>
        </div>

        <!-- مزایای غیرمالی (ارسال رایگان، هدیه و...) -->
        <div v-if="product.nonFinancialBenefits && product.nonFinancialBenefits.length > 0" class="mb-2">
          <div class="d-flex flex-wrap gap-2">
            <span v-for="(benefit, i) in product.nonFinancialBenefits" :key="i" class="badge bg-info text-white">
              <b-icon :icon="mapBenefitToIcon(benefit)" variant="primary" />
              {{ mapBenefitToText(benefit) }}
            </span>
          </div>
        </div>

        <!-- نظرات و لایک -->
        <div class="d-flex justify-content-between align-items-center mb-1">
          <p class="text-secondary small mb-0">
            {{ $t('CART_comments') }}
          </p>
          <div class="d-flex gap-2 align-items-center" v-if="product.totalLikes || product.totalDislikes">
            <span v-if="product.totalLikes > 0" class="badge bg-success">
              <b-icon icon="hand-thumbs-up" class="me-1" /> {{ product.totalLikes }}
            </span>
            <span v-if="product.totalDislikes > 0" class="badge bg-danger">
              <b-icon icon="hand-thumbs-down" class="me-1" /> {{ product.totalDislikes }}
            </span>
          </div>
        </div>

        <!-- دکمه خرید یا ناموجود -->
        <div v-if="inStock">

          <!-- دکمه خرید -->
          <b-button :disabled="addingToCart" variant="primary" size="sm" block class="mb-2"
            @click="addToCartHandler(product.id)">
            <template v-if="addingToCart">
              <b-spinner small type="border" class="me-1" />
              در حال افزودن...
            </template>
            <template v-else>
              <b-icon icon="cart-plus" class="me-1" />
              افزودن به سبد خرید
            </template>
          </b-button>

        </div>
        <div v-else class="font-weight-bold text-center mt-2 text-left">
          <b-button disabled variant="outline-primary" size="sm" block>
            ناموجود
          </b-button>
        </div>


      </b-card-body>

      <!-- فوتر: تخفیف + هشدار موجودی کم -->
      <div v-if="inCartQuantity > 0">
        <b-card-footer class="bg-light text-muted small text-center">

          <!-- نام قانون تخفیف -->
          <p v-if="product.appliedRuleName" class="text-warning small mb-1">
            {{ product.appliedRuleName }}
          </p>

          <!-- هشدار موجودی -->
          <div v-if="product.available && inCartQuantity > 0 && inCartQuantity <= 5"
            class="text-danger text-center mt-1">
            تنها {{ inCartQuantity }} عدد در انبار باقی مانده
          </div>
        </b-card-footer>
      </div>
    </b-card>
  </div>
</template>
<script>
import { mapActions } from 'vuex';

export default {
  name: 'cards',
  props: ["cardImage", "product"],
  data() {
    return {
      addingToCart: false
    }
  },
  methods: {
    getDiscountPercent(base, final) {
      if (!base || !final || base <= final) return 0;
      return Math.round(((base - final) / base) * 100);
    },

    mapBenefitToIcon(benefit) {
      switch (benefit) {
        case 'FREE_SHIPPING': return 'truck';
        case 'FAST_DELIVERY': return 'lightning';
        case 'BUY_ONE_GET_ONE': return 'gift';
        case 'GIFT_ITEM': return 'gift-fill';
        case 'EXTRA_GUARANTEE': return 'shield-check';
        case 'BONUS_POINTS': return 'star';
        default: return 'award';
      }
    },

    mapBenefitToText(benefit) {
      switch (benefit) {
        case 'FREE_SHIPPING': return 'ارسال رایگان';
        case 'FAST_DELIVERY': return 'ارسال سریع';
        case 'BUY_ONE_GET_ONE': return 'یکی بخر دوتا ببر';
        case 'GIFT_ITEM': return 'هدیه ویژه';
        case 'EXTRA_GUARANTEE': return 'ضمانت بیشتر';
        case 'BONUS_POINTS': return 'امتیاز وفاداری';
        default: return 'مزیت ویژه';
      }
    },

    ...mapActions('cart', ['addToCart']),

    async addToCartHandler(productId) {
      this.addingToCart = true;
      try {
        await this.addToCart(productId); // متد Vuex
        this.$bvToast.toast('کالا به سبد خرید اضافه شد', {
          title: 'سبد خرید',
          variant: 'success',
          solid: true,
          toaster: 'b-toaster-top-center',
          autoHideDelay: 3000
        });
      } catch (err) {
        this.$bvToast.toast('خطا در افزودن به سبد خرید', {
          title: 'خطا',
          variant: 'danger',
          solid: true,
          toaster: 'b-toaster-top-center',
          autoHideDelay: 3000
        });
      } finally {
        this.addingToCart = false;
      }
    }
  },
  computed: {
    inCartQuantity() {
      return this.product.quantity || 0;
    },
    inStock() {
      const available = this.product.available;
      const quantity = this.product.quantity;

      if (available !== null && available !== undefined) {
        return available === true;
      }

      return quantity !== null && quantity !== undefined && quantity > 0;
    }
  }
}
</script>


<style scoped>
.product-card {
  border: 1px solid #ddd;
  transition: transform 0.3s ease, box-shadow 0.3s ease, border-color 0.3s ease;
}

.product-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 20px rgba(0, 123, 255, 0.25);
  border-color: #007bff;
}

.bg-light.text-muted.small.text-center {
  font-size: 0.85rem;
}

button[disabled] {
  background-color: #e0e0e0;
  border-color: #ccc;
  color: #999;
}

.color-dots-vertical {
  top: 10px;
  left: 10px;
  display: flex;
  flex-direction: column;
  z-index: 2;
}

.color-circle {
  width: 16px;
  height: 16px;
  border-radius: 50%;
  border: 1px solid #ccc;
  display: inline-block;
  margin: 2px;
  cursor: pointer;
}

@media (min-width: 768px) {
  .product-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 20px rgba(0, 123, 255, 0.15);
  }
}
</style>

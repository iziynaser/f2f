<template>
  <div class="container py-4">
    <h3 class="mb-4 text-center">🛒 سبد خرید شما</h3>

    <div v-if="enrichedCart.length === 0">
      <b-alert show variant="warning" class="text-center">
        سبد خرید شما خالی است 😕
      </b-alert>
    </div>

    <b-card v-for="product in enrichedCart" :key="product.id" class="mb-3 shadow-sm" no-body>
      <b-row no-gutters>
        <b-col cols="3" class="p-2 d-flex align-items-center justify-content-center">
          <b-img :src="product.cardImageUrl" fluid alt="product image" style="max-height: 100px;" />
        </b-col>

        <b-col cols="9" class="p-2">
          <h5 class="mb-1">{{ product.name }}</h5>
          <p class="mb-2 text-muted">تعداد: {{ product.quantity }}</p>

          <b-row>
            <b-col cols="6">
              <b-button variant="outline-success" size="sm" block @click="addToCart(product.id)">
                <b-icon icon="plus" /> افزایش تعداد
              </b-button>
            </b-col>
            <b-col cols="6">
              <b-button variant="outline-danger" size="sm" block @click="removeFromCart(product.id)">
                <b-icon icon="trash" /> حذف از سبد
              </b-button>
            </b-col>
          </b-row>
        </b-col>
      </b-row>
    </b-card>

    <b-button :disabled="enrichedCart.length === 0" to="/selectAddress" variant="success" size="lg" block class="mb-4">
      ادامه به انتخاب آدرس ارسال
    </b-button>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
//import { baseUrl } from '../../api/util';

export default {
  name: 'BucketView',
  computed: {
    ...mapGetters('cart', ['enrichedCart'])
  },
  methods: {
    // getImageUrl(imagePath) {
    //   if (!imagePath || imagePath.trim() === '') {
    //     return baseUrl('/images/default.png');
    //   }
    //   return baseUrl(imagePath);
    // },
    ...mapActions('cart', ['addToCart', 'removeFromCart'])
  }
};
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: auto;
}
</style>

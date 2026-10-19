<template>
  <div>
    <div class="container mt-5 py-2">
      <div>
        <h1>
          تعداد کالاها
          {{ productSize }}
        </h1>
      </div>
      <div class="row">
        <div
            class="col-12 col-sm-6 col-md-4 col-lg-3 mb-4"
            v-for="product in listOfProducts"
            :key="product.id"
        >
          <cards :product="product" :cardImage="urlI(product.cardImageUrl)" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import cards from "./cards";
import { baseUrl } from "../api/util";

export default {
  name: "Products",
  components: { cards },
  computed: {
    ...mapGetters("shop", ["productSize", "products"]),
    listOfProducts() {
      // ← استفاده از getter جدید filteredProducts برای فیلتر لوکال
      return this.$store.getters['shop/filteredProducts'];
    }
  },
  // ← watcher روی props filters حذف شد، چون فیلترها از Vuex خوانده می‌شوند
  methods: {
    urlI(u) {
      return baseUrl(u);
    },
    ...mapActions("shop", ["fetchProducts"])
  },
  created() {
    // فقط بارگذاری اولیه یا وقتی category تغییر کرد
    this.fetchProducts();
  }
};
</script>

<style scoped></style>

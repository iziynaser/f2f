<template>
  <div>
    <!-- بنر بالای هدر -->
    <div class="header-banner d-flex align-items-center">
      <div class="banner-content text-white">
        <h2 class="banner-text">eCommerce</h2>
        <p class="banner-description">Open Source App</p>
      </div>
    </div>

    <!-- بخش اصلی هدر -->
    <b-container fluid class="header-top px-3 py-2">
      <b-row class="align-items-center flex-wrap">
        <!-- لوگو -->
        <b-col cols="12" sm="2" class="text-center text-sm-left mb-2 mb-sm-0">
          <Logo />
        </b-col>

        <!-- عنوان شرکت -->
        <b-col cols="12" sm="2" class="text-center text-sm-left mb-2 mb-sm-0">
          <h5 class="company-title m-0">Face2Face</h5>
        </b-col>

        <!-- جستجو -->
        <b-col cols="12" sm="4" class="mb-2 mb-sm-0">
          <FSearchBar />
        </b-col>

        <!-- آیکن‌ها -->
        <b-col cols="12" sm="4" class="d-flex align-items-center justify-content-end text-sm-right text-center">
          <shoppingList class="mx-1" />
          <shoppingCart class="mx-1" />
          <b-button variant="outline-primary" size="sm" class="mx-1">
            <b-icon icon="bell" />
          </b-button>
        </b-col>
      </b-row>

      <!-- breadcrumb داینامیک -->
      <b-row class="align-items-center mt-2 category-divider">
        <b-col cols="12" sm="auto" class="text-center text-sm-start">
          <CategoriesMenu/>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import shoppingList from '../components/shoppingList'
import shoppingCart from '../components/shoppingCart'
import Logo from '../components/front/Logo.vue'
import FSearchBar from '../components/front/fSearchBar.vue'
import CategoriesMenu from '../components/categories/categoriesMenu.vue';


export default {
  name: 'headers',
  components: {
    shoppingList,
    shoppingCart,
    Logo,
    FSearchBar,
    CategoriesMenu
  },
  computed: {},
  methods: {}
}
</script>

<style scoped>
.header-banner {
  background-image: url('/images/header-bg.png');
  background-size: cover;
  background-position: center;
  height: 70px;
  border-radius: 5px;
  margin-bottom: 15px;
}

.banner-text {
  font-size: 1.8rem;
  text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.6);
  font-weight: bold;
}

.banner-description {
  font-size: 0.9rem;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.5);
}

.banner-content {
  text-align: left;
  max-width: 300px;
  padding-left: 15px;
}

.header-top {
  background-color: #ffffff;
  border-radius: 6px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.05);
}

.company-title {
  font-weight: bold;
  font-size: 1.2rem;
  color: #333;
}

.b-breadcrumb {
  background-color: transparent;
  font-size: 0.9rem;
}

.line-left,
.line-right{
  border: none;
  height: 1px;
  background-color: #ddd;
  margin: 0 1px;
}

.line-right{
  width: 100%;
}
.line-left{
  width: 100%;
}
</style>

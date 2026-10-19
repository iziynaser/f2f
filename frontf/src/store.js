import Vue from 'vue'
import Vuex from 'vuex'

import assistance from './store/modules/assistance'

import order from './store/modules/order/orderStore'
import cart  from './store/modules/cart/cartStore'
import payment from './store/modules/payment/paymentStore'
import delivery from './store/modules/delivery/deliveryStore'
import shop from './store/modules/shop/shopStore'
import compare from './store/modules/compare/compareStore'
import toast from './store/modules/toast/toastStore'
import auth from './store/modules/auth/authStore'
import createPersistedState from 'vuex-persistedstate'
import categoriesStore from "./store/modules/category/categoriesStore";
import productFeature from "./store/modules/product-feature/featureStore";
import filter from "./store/modules/filter/FilterStore"
import brand from "./store/modules/brand/brand"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {

  },
  mutations: {

  },
  actions: {

  },
  modules:{
    auth:auth,
    cart: cart,
    assistance: assistance,
    order: order,
    payment: payment,
    delivery: delivery,
    shop: shop,
    compare: compare,
    toast:toast,
    categories:categoriesStore ,
    feature: productFeature,
    filter: filter,
    brand:brand
  },
  plugins:[createPersistedState({
    key: 'f2f',
    storage: window.sessionStorage
  })]
})

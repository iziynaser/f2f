import axiosInstance from '@/api/axiosInstance';

const state = {
  cart: [],  // [{ productId, quantity }]
  cartProducts: []  // اطلاعات کامل محصول برای کالاهایی که در shop نیستند
};

const getters = {
  cartSize: state => state.cart.length,

  enrichedCart: (state, getters, rootState) => {
    return state.cart.map(item => {
      let product =
        rootState.shop.products.find(p => p.id === item.productId) ||
        state.cartProducts.find(p => p.id === item.productId) ||
        null;

      return {
        productId: item.productId,
        quantity: item.quantity,
        product
      };
    });
  },

  cartTotalAmount: (state, getters) => {
    return getters.enrichedCart.reduce((total, item) => {
      var price = (item.product && item.product.finalPrice) ||
            (item.product && item.product.basePrice) || 0;
      return total + price * item.quantity;
    }, 0);
  }
};

const actions = {
  initializeCart({ commit, dispatch }) {
    const cart = JSON.parse(localStorage.getItem('cart') || '[]');
    commit('setCartFromStorage', cart);
    cart.forEach(item => {
      dispatch('ensureCartProductLoaded', item.productId);
    });
  },

  async ensureCartProductLoaded({ commit, state, rootState }, productId) {
    const existsInShop = rootState.shop.products.some(p => p.id === productId);
    const existsInCartProducts = state.cartProducts.some(p => p.id === productId);
    if (!existsInShop && !existsInCartProducts) {
      try {
        const res = await axiosInstance.get(`/products/${productId}`);
        commit('addCartProduct', res.data);
      } catch (err) {
        console.error('خطا در دریافت اطلاعات محصول', err);
      }
    }
  },

  async addToCart({ commit, dispatch }, productId) {
    commit('addToCart', productId);
    dispatch('ensureCartProductLoaded', productId);
    dispatch('persistCart');
  },

  removeFromCart({ commit, dispatch }, productId) {
    commit('removeFromCart', productId);
    dispatch('persistCart');
  },

  deleteFromCart({ commit, dispatch }, productId) {
    commit('deleteFromCart', productId);
    dispatch('persistCart');
  },

  persistCart({ state }) {
    localStorage.setItem('cart', JSON.stringify(state.cart));
  }
};

const mutations = {
  setCartFromStorage(state, cart) {
    state.cart = cart;
  },

  addCartProduct(state, product) {
    const exists = state.cartProducts.some(p => p.id === product.id);
    if (!exists) state.cartProducts.push(product);
  },

  addToCart(state, productId) {
    const item = state.cart.find(i => i.productId === productId);
    if (item) {
      item.quantity += 1;
    } else {
      state.cart.push({ productId, quantity: 1 });
    }
  },

  removeFromCart(state, productId) {
    const index = state.cart.findIndex(i => i.productId === productId);
    if (index !== -1) {
      if (state.cart[index].quantity <= 1) {
        state.cart.splice(index, 1);
      } else {
        state.cart[index].quantity -= 1;
      }
    }
  },

  deleteFromCart(state, productId) {
    state.cart = state.cart.filter(i => i.productId !== productId);
  },

  clearCart(state) {
    state.cart = [];
    state.cartProducts = [];
    localStorage.removeItem('cart');
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};

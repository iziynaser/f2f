// store/modules/compare.js
import { fetchProductFeatures } from '../product-feature/featureApi';

const state = () => ({
  compareList: []
});

const mutations = {
  addToCompare(state, productData) {
    state.compareList.push(productData);
  },
  removeFirst(state) {
    state.compareList.shift();
  },
  removeFromCompare(state, productId) {
    state.compareList = state.compareList.filter(p => p.id !== productId);
  },
  clearCompare(state) {
    state.compareList = [];
  }
};

const actions = {
  async addProductToCompare({ state, commit }, productId) {

    if (state.compareList.find(p => p.id === productId)) return;

    if (state.compareList.length >= 3) {
      commit('removeFirst');
    }

    try {
      const response = await fetchProductFeatures(productId);
      const features = response.data;

      commit('addToCompare', { id: productId, features });
    } catch (error) {
      console.error('خطا در بارگذاری ویژگی‌های محصول برای مقایسه:', error);
    }
  },
  removeProductFromCompare({ commit }, productId) {
    commit('removeFromCompare', productId);
  },
  clearCompareList({ commit }) {
    commit('clearCompare');
  }
};

const getters = {
  getCompareList(state) {
    return state.compareList;
  }
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
};

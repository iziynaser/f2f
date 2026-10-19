import shopApi from './shopApi';

const state = {
  products: [], // لیست کالاها
  loading: false,
  error: null,
  lastLoadedParams: null // برای جلوگیری از لود تکراری
};

const getters = {
  allProducts: (state) => state.products,
  filteredProducts: (state, getters, rootState) => {
    const filters = rootState.filter;
    let result = state.products || [];

    // فیلترهای محلی (در کلاینت)
    if (filters.brandIds && filters.brandIds.length > 0) {
      result = result.filter(p => filters.brandIds.includes(p.brandId));
    }

    result = result.filter(p =>
        p.price >= filters.priceRange[0] && p.price <= filters.priceRange[1]
    );

    if (filters.colors && filters.colors.length > 0) {
      result = result.filter(p => filters.colors.includes(p.colorCode));
    }

    if (filters.searchTerm) {
      const term = filters.searchTerm.toLowerCase();
      result = result.filter(p => p.name.toLowerCase().includes(term));
    }

    if (filters.inStockOnly) {
      result = result.filter(p => p.stock > 0);
    }

    // مرتب‌سازی
    if (filters.sortBy === 'priceAsc') {
      result = [...result].sort((a, b) => a.price - b.price);
    } else if (filters.sortBy === 'priceDesc') {
      result = [...result].sort((a, b) => b.price - a.price);
    }

    return result;
  },
  productSize(state) {
    return state.products ? state.products.length : 0
  },
  products: function (state) {
    return state.products;
  },
  productCount: function (state) {
    return state.products.length;
  },
  isLoading: function (state) {
    return state.loading;
  },
  error: function (state) {
    return state.error;
  }
};

const actions = {

  applyLocalFilter() {
      console.log('local filters applied on existing products');
    },

  async fetchProducts({ commit, state }, params = {}) {
    const paramString = JSON.stringify(params || {});
    // جلوگیری از لود یکسان
    if (paramString === state.lastLoadedParams) {
      //console.log("similar params..");
      return;
    }

    commit('setLoading', true);
    try {
      console.log('fetch products with params ',params);
      // اگر page>1 بخواد append کن (infinite scroll) — backend باید page/pageSize بپذیرد
      const res = await shopApi.getProducts(params);
      if (params.page && params.page > 1) {
        commit('appendProducts', res); // mutation جدید برای الحاق
      } else {
        commit('setProducts', res);
      }
      commit('setLastLoadedParams', paramString);
      commit('setError', null);
    } catch (err) {
      commit('setError', 'خطا در دریافت محصولات');
      console.error(err);
    } finally {
      commit('setLoading', false);
    }
  }
  ,
  clearProducts({ commit }) {
    commit('setProducts', []);
    commit('setLastLoadedParams', null);
  }
};

const mutations = {
  setProducts(state, products) {
    state.products = products;
  },
  appendProducts(state, products) {
    state.products = (state.products || []).concat(products);
  },
  setLoading(state, loading) {
    state.loading = loading;
  },
  setError(state, error) {
    state.error = error;
  },
  setLastLoadedParams(state, paramString) {
    state.lastLoadedParams = paramString;
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};

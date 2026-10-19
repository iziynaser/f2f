//store/modules/brand.js
import { getBrandsByCategory } from './brandService';

export default {
    namespaced: true,
    state: () => ({
        brands: [],
        loading: false,
        error: null
    }),
    getters: {
        allBrands: (state) => state.brands,
        isLoading: (state) => state.loading,
        error: (state) => state.error
    },
    mutations: {
        setBrands(state, brands) { state.brands = brands },
        setLoading(state, val) { state.loading = val },
        setError(state, error) { state.error = error }
    },
    actions: {
        async fetchBrandsByCategory({ commit }, categoryId) {
            if (!categoryId) {
                commit('setBrands', []);
                return;
            }
            commit('setLoading', true);
            try {
                const data = await getBrandsByCategory(categoryId); // سرویس
                commit('setBrands', data);
                commit('setError', null);
            } catch (err) {
                commit('setError', 'خطا در دریافت برندها');
                commit('setBrands', []);
            } finally {
                commit('setLoading', false);
            }
        }
    }
};

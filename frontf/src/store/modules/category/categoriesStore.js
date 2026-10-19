import axiosInstance from '@/api/axiosInstance';

const state = {
    categories: [],
    loading: false,
    error: null,
};

const getters = {
    getCategories: (state) => state.categories,
    isLoading: (state) => state.loading,
    getError: (state) => state.error,
};

const actions = {
    async fetchCategories({ commit, state }) {
        if (state.categories.length > 0) return;

        commit('setLoading', true);
        commit('setError', null);

        try {
            const response = await axiosInstance.get('/category/listTop10');
            console.log('categories : ',response.data);
            commit('setCategories', response.data);
        } catch (error) {
            commit('setError', 'خطا در دریافت دسته‌بندی‌ها');
            console.error(error);
        } finally {
            commit('setLoading', false);
        }
    },
};

const mutations = {
    setCategories(state, categories) {
        state.categories = categories;
    },
    setLoading(state, loading) {
        state.loading = loading;
    },
    setError(state, error) {
        state.error = error;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};

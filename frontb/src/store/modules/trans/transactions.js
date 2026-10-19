import * as api from './api'

const state = {
    transactions: [],
    transaction: null,
    accounts: [],
    loading: false,
    error: null,
}

const getters = {
    transactions: state => state.transactions,
    transaction: state => state.transaction,
    accounts: state => state.accounts,
    loading: state => state.loading,
    error: state => state.error,
    accountsOptions: state => [
        { value: null, text: "انتخاب حساب..." },
        ...state.accounts.map(a => ({
            value: a.id,
            text: a.code ? `${a.code} - ${a.name}` : a.name
        }))
    ]
}

const mutations = {
    SET_LOADING(state, value) {
        state.loading = value
    },
    SET_ERROR(state, error) {
        state.error = error
    },
    SET_TRANSACTIONS(state, data) {
        state.transactions = data
    },
    SET_TRANSACTION(state, data) {
        state.transaction = data
    },
    SET_ACCOUNTS(state, data) {
        state.accounts = data
    },
}

const actions = {
    async fetchTransactions({ commit }) {
        commit('SET_LOADING', true)
        try {
            const { data } = await api.getTransactions()
            commit('SET_TRANSACTIONS', data)
        } catch (e) {
            commit('SET_ERROR', e)
        } finally {
            commit('SET_LOADING', false)
        }
    },

    async fetchTransaction({ commit }, id) {
        commit('SET_LOADING', true)
        try {
            const { data } = await api.getTransaction(id)
            commit('SET_TRANSACTION', data)
        } catch (e) {
            commit('SET_ERROR', e)
        } finally {
            commit('SET_LOADING', false)
        }
    },

    async createTransaction({ dispatch }, payload) {
        await api.createTransaction(payload)
        await dispatch('fetchTransactions')
    },

    async deleteTransaction({ dispatch }, id) {
        await api.deleteTransaction(id)
        await dispatch('fetchTransactions')
    },

    async postTransaction(_, id) {
        return api.postTransaction(id)
    },

    async lockTransaction(_, id) {
        return api.lockTransaction(id)
    },

    async cancelTransaction(_, id) {
        return api.cancelTransaction(id)
    },

    async reverseTransaction(_, id) {
        const data = await api.reverseTransaction(id)
        return data
    },

    async fetchAccounts({ commit }) {
        const { data } = await api.getAccounts()
        commit('SET_ACCOUNTS', data)
    },
    async searchTransactions({ commit }, filter) {
        commit('SET_LOADING', true)
        try {
            const { data } = await api.searchTransactions(filter)
            commit('SET_TRANSACTIONS', data.content)
        } catch (e) {
            commit('SET_ERROR', e)
        } finally {
            commit('SET_LOADING', false)
        }
    },


}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
}

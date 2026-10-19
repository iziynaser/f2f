import * as api from "./chartOfAccount"

const state = {
    tree: [],
    account: null,
    loading: false,
}

const getters = {
    tree: state => state.tree,
    account: state => state.account,
    loading: state => state.loading,
}

const mutations = {

    SET_TREE(state, tree) {
        state.tree = tree
    },

    SET_ACCOUNT(state, account) {
        state.account = account
    },

    SET_LOADING(state, value) {
        state.loading = value
    }

}

const actions = {

    async fetchTree({ commit }) {

        commit("SET_LOADING", true)

        try {

            const res = await api.getAccountTree()

            commit("SET_TREE", res.data)

            return res.data

        } finally {

            commit("SET_LOADING", false)

        }

    },

    async fetchAccount({ commit }, id) {

        commit("SET_LOADING", true)

        try {

            const res = await api.getAccount(id)

            commit("SET_ACCOUNT", res.data)

            return res.data

        } finally {

            commit("SET_LOADING", false)

        }

    },

    async createAccount({ dispatch }, payload) {

        const res = await api.createAccount(payload)

        await dispatch("fetchTree")

        return res.data

    },

    async updateAccount({ dispatch }, { id, payload }) {

        const res = await api.updateAccount(id, payload)

        await dispatch("fetchTree")

        return res.data

    },

    async deleteAccount({ dispatch }, id) {

        await api.deleteAccount(id)

        await dispatch("fetchTree")

    }

}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
}

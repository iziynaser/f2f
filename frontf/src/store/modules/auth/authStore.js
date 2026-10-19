import axiosInstance from '@/api/axiosInstance'
import router from '../../../router'

const state = {
    access_token: window.localStorage.getItem('access_token') || null,
    token_type: window.localStorage.getItem('token_type') || null,
    refresh_token: window.localStorage.getItem('refresh_token') || null,
    expires_in: window.localStorage.getItem('expires_in') || null,
    scope: window.localStorage.getItem('scope') || null,
    user_name: window.localStorage.getItem('user_name') || null,
    authorities: window.localStorage.getItem('authorities') || null
}

const getters = {
    isLoggedIn: function(state) {
        return !!state.access_token
    },
    getAccessToken: function(state) {
        return state.access_token
    },
    getUserName: function(state) {
        return state.user_name
    },
    getAuthorities: function(state) {
        return state.authorities
    }
}

const actions = {
    async login({ dispatch }, { username, password }) {
        try {
            const body = {
                username: username,
                password: password
            }
            const response = await axiosInstance.post('/auth/signin', body)
            // response.data باید شامل accessToken و tokenType و username و roles باشد
            await dispatch('finalizeLogin', response.data)
        } catch (err) {
            throw err
        }
    },

    logout: function({ commit }) {
        commit('setToken', null)
        commit('setRefreshToken', null)
        commit('setExpireIn', null)
        commit('setScope', null)
        commit('setTokenType', null)
        commit('setUserName', null)
        commit('setAuthorities', null)

        window.localStorage.removeItem('access_token')
        window.localStorage.removeItem('refresh_token')
        window.localStorage.removeItem('expires_in')
        window.localStorage.removeItem('scope')
        window.localStorage.removeItem('token_type')
        window.localStorage.removeItem('user_name')
        window.localStorage.removeItem('authorities')

        router.push('/')
    },

    finalizeLogin: function({ commit }, data) {
        const access_token = data.accessToken
        const token_type = data.tokenType
        const user_name = data.username
        const authorities = data.roles.join(',')

        commit('setToken', access_token)
        commit('setTokenType', token_type)
        commit('setUserName', user_name)
        commit('setAuthorities', authorities)

        window.localStorage.setItem('access_token', access_token)
        window.localStorage.setItem('token_type', token_type)
        window.localStorage.setItem('user_name', user_name)
        window.localStorage.setItem('authorities', authorities)

        router.push('/')
    }
}

const mutations = {
    setToken: function(state, token) { state.access_token = token },
    setTokenType: function(state, val) { state.token_type = val },
    setUserName: function(state, val) { state.user_name = val },
    setAuthorities: function(state, val) { state.authorities = val },
    setRefreshToken: function(state, token) { state.refresh_token = token },
    setExpireIn: function(state, val) { state.expires_in = val },
    setScope: function(state, val) { state.scope = val }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}

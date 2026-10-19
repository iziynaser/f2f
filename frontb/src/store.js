import Vue from 'vue'
import Vuex from 'vuex'
import auth from './store/modules/auth'

import mstore from './store/modules/mstore'
import assistance from './store/modules/assistance'
import transactions from './store/modules/trans/transactions'
import account from './store/modules/accounts/account'
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
    mstore: mstore,
    assistance:assistance,
    transactions:transactions,
    account:account
  }
})

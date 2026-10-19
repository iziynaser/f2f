import paymentApi from './paymentApi';

const state = {
  paymentStatus: null,
  paymentMessage: '',
  paymentUrl: '',
  currentOrderId: null,
  gateways: []
};

const getters = {
  paymentStatus: function (state) { return state.paymentStatus; },
  paymentMessage: function (state) { return state.paymentMessage; },
  paymentUrl: function (state) { return state.paymentUrl; },
  paymentGateways: function (state) { return state.gateways; }
};

const actions = {
  async fetchPaymentGateways({ commit, state }) {
    if (state.gateways && state.gateways.length > 0) {
      return; // جلوگیری از بارگذاری مجدد
    }
    try {
      const res = await paymentApi.getActiveGateways();
      if (res && res.data && res.data.body) {
        commit('setGateways', res.data.body);
      } else {
        commit('setGateways', []);
      }
    } catch (err) {
      console.log('خطا در دریافت درگاه', err);
    }
  },

  async initiatePayment({ commit }, { orderId, gateway }) {
    commit('resetPaymentState');
    const amount = 1000; // TODO: بعداً مقدار واقعی را دریافت کنید

    try {
      const res = await paymentApi.startPayment(orderId, amount, gateway);
      let redirectUrl = null;

      if (res && res.data && res.data.body && res.data.body.redirectUrl) {
        redirectUrl = res.data.body.redirectUrl;
      }

      if (redirectUrl) {
        commit('setPaymentUrl', redirectUrl);
        commit('setCurrentOrderId', orderId);
        window.location.href = redirectUrl;
      } else {
        commit('setPaymentMessage', 'آدرس درگاه نامعتبر');
      }
    } catch (err) {
      commit('setPaymentMessage', 'خطا در شروع پرداخت');
      console.error(err);
    }
  },

  async finalizePayment({ commit, dispatch }, paymentResult) {
    try {
      const res = await paymentApi.verifyPayment(paymentResult);
      let body = null;
      if (res && res.data && res.data.body) {
        body = res.data.body;
      }

      const isSuccess = body && body.success;
      const msg = body && body.message;

      commit('setPaymentStatus', isSuccess ? 'success' : 'failed');
      commit('setPaymentMessage', msg || 'نتیجه پرداخت نامشخص');

      if (isSuccess) {
        dispatch('order/clearOrder', null, { root: true });
      }
    } catch (err) {
      commit('setPaymentStatus', 'failed');
      commit('setPaymentMessage', 'خطا در تایید پرداخت');
      console.error(err);
    }
  },

  resetPayment({ commit }) {
    commit('resetPaymentState');
  }
};

const mutations = {
  setGateways(state, gateways) {
    state.gateways = gateways;
  },
  setPaymentUrl(state, url) {
    state.paymentUrl = url;
  },
  setPaymentStatus(state, status) {
    state.paymentStatus = status;
  },
  setPaymentMessage(state, msg) {
    state.paymentMessage = msg;
  },
  setCurrentOrderId(state, orderId) {
    state.currentOrderId = orderId;
  },
  resetPaymentState(state) {
    state.paymentStatus = null;
    state.paymentMessage = '';
    state.paymentUrl = '';
    state.currentOrderId = null;
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};

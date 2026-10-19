import deliveryApi from './deliveryApi';

const DEFAULT_USER_ID = 1;

const state = {
  deliveries: [],
  defaultDelivery: null,
  note: '',
  loading: false,
  error: null
};

const getters = {
  deliveries: state => state.deliveries,
  defaultDelivery: state => state.defaultDelivery,
  isDeliveryLoading: state => state.loading,
  deliveryError: state => state.error,
  note: state => state.note,
};

const actions = {
  saveNote({ commit }, note) {
    commit('setNote', note);
  },

  async saveDeliveryInfo({ commit }, deliveryInfo) {
    //console.log('saveDeliveryInfo:', deliveryInfo);
    commit('setDefaultDelivery', deliveryInfo);
  },

  async fetchDeliveries({ commit }) {
    commit('setLoading', true);
    const userId = getUserIdOrDefault();

    try {
      const res = await deliveryApi.getDeliveryList(userId);
      commit('setDeliveries', res.data);
      commit('setError', null);
    } catch (err) {
      commit('setError', 'خطا در دریافت لیست آدرس‌ها');
      console.error(err);
    } finally {
      commit('setLoading', false);
    }
  },

  async fetchDefaultDelivery({ commit }) {
    const userId = getUserIdOrDefault();
    try {
      const res = await deliveryApi.getDefaultDelivery(userId);
      commit('setDefaultDelivery', res.data);
    } catch (err) {
      console.error('خطا در دریافت آدرس پیش‌فرض:', err);
    }
  },

  async setDefaultDelivery({ dispatch }, deliveryId) {
    const userId = getUserIdOrDefault();
    try {
      await deliveryApi.setDefaultDelivery(deliveryId, userId);
      await dispatch('fetchDefaultDelivery');
    } catch (err) {
      console.error('خطا در تعیین آدرس پیش‌فرض:', err);
    }
  },

  async saveDelivery({ dispatch }, deliveryData) {
    const userId = getUserIdOrDefault();
    deliveryData.userAccountId = deliveryData.userAccountId || userId;

    try {
      if (deliveryData.id) {
        await deliveryApi.updateDelivery(deliveryData.id, deliveryData);
      } else {
        await deliveryApi.addDelivery(deliveryData);
      }
      await dispatch('fetchDeliveries');
    } catch (err) {
      console.error('خطا در ذخیره آدرس:', err);
    }
  },

  async deleteDelivery({ dispatch }, id) {
    const userId = getUserIdOrDefault();
    try {
      await deliveryApi.deleteDelivery(id, userId);
      await dispatch('fetchDeliveries');
    } catch (err) {
      console.error('خطا در حذف آدرس:', err);
    }
  }
};

const mutations = {
  setNote(state, note) {
    state.note = note;
  },
  setDeliveries(state, deliveries) {
    state.deliveries = deliveries;
  },
  setDefaultDelivery(state, delivery) {
    state.defaultDelivery = delivery;
  },
  setLoading(state, loading) {
    state.loading = loading;
  },
  setError(state, error) {
    state.error = error;
  }
};

function getUserIdOrDefault() {
  let userId = null;
  try {
    userId = parseInt(localStorage.getItem('userId'), 10);
    if (!userId || isNaN(userId)) {
      userId = DEFAULT_USER_ID;
    }
  } catch (e) {
    userId = DEFAULT_USER_ID;
  }
  return userId;
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};

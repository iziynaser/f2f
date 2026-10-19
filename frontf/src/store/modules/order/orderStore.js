import orderApi from './orderApi';

const DEFAULT_CUSTOMER_ID = 1;

const state = {
  myOrders: [],
  currentOrder: null,
  orderMessage: '',
  loading: false,
  error: null
};

const getters = {
  myOrders: state => state.myOrders,
  currentOrder: state => state.currentOrder,
  orderMessage: state => state.orderMessage,
  orderLoading: state => state.loading,
  orderError: state => state.error
};

const actions = {

    async fetchOrderById(_,orderId) {
    try {
      console.log(orderId);
      const response = await orderApi.getOrderById(orderId); // فرض api
      if (response.status === 'OK' && response.body) {
        return response.body;
      } else {
        throw new Error('سفارش یافت نشد');
      }
    } catch (error) {
      console.error(error);
      throw error;
    }
  },

  prepareCurrentOrderFromCart({ rootGetters, commit }) {
    const cartItems = rootGetters['cart/enrichedCart'];
    const total = cartItems.reduce((sum, item) => sum + item.price * item.quantity, 0);
    const order = {
      items: cartItems,
      totalPrice: total
    };
    commit('setCurrentOrder', order);
  },

  async submitOrder({ commit, rootGetters }, note) {
    const cart = rootGetters['cart/enrichedCart'];
    const delivery = rootGetters['delivery/defaultDelivery'];

    if (!delivery || !delivery.id || !delivery.deliveryDay || !delivery.deliveryTime) {
      commit('setOrderMessage', 'لطفاً آدرس و زمان تحویل را کامل انتخاب کنید.');
      commit('setError', 'اطلاعات تحویل ناقص است.');
      return Promise.reject(new Error('اطلاعات تحویل ناقص است.'));
    }

    const items = cart.map(item => ({
      productItemId: item.productItemId,  
      quantity: item.quantity
    }));

    const noteToSend = note || delivery.note || '';

    const customerId = rootGetters['auth/customerId'] || DEFAULT_CUSTOMER_ID;

    const orderRequest = {
      customerId,
      note: noteToSend,
      deliveryInfo: {
        addressId: delivery.id,
        deliveryDay: delivery.deliveryDay,
        deliveryTime: delivery.deliveryTime
      },
      items
    };

    console.log('OrderRequest:', JSON.stringify(orderRequest, null, 2));

    commit('setLoading', true);

    try {
      const res = await orderApi.submitOrder(orderRequest);

      if (res.data && res.data.status === 'OK' && res.data.body) {
        commit('setCurrentOrder', res.data.body);
        commit('cart/clearCart', null, { root: true });
        commit('setError', null);
        return { success: true , message : res.data.message || 'سفارش ثبت شد',body : res.data.body };
      } else {
        return {success : false , message: res.data.message || 'خطا در ثبت سفارش' }
      }

    } catch (err) {
      const msg = 'خطا در ثبت سفارش';
        commit('setOrderMessage', msg);
        return {success : false , message:'خطا در ثبت سفارش',error: err}
    } finally {
      commit('setLoading', false);
    }
  },

  async fetchMyOrders({ commit }, status) {
    try {
      const customerId = DEFAULT_CUSTOMER_ID;
      const res = await orderApi.getMyOrders(customerId, status);
      commit('setMyOrders', res.data);
    } catch (err) {
      console.error('خطا در دریافت سفارش‌ها:', err);
    }
  },
  clearOrder({ commit }) {
    commit('setCurrentOrder', null);
  }
};

const mutations = {
  setMyOrders(state, orders) {
    state.myOrders = orders;
  },
  setCurrentOrder(state, order) {
    state.currentOrder = order;
  },
  setOrderMessage(state, msg) {
    state.orderMessage = msg;
  },
  setLoading(state, loading) {
    state.loading = loading;
  },
  setError(state, error) {
    state.error = error;
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};

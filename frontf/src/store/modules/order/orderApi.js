// src/api/orderApi.js
import axiosInstance from '@/api/axiosInstance';

const CHECKOUT_BASE = '/checkout';
const ORDER_BASE = '/orders';

export default {

  submitOrder(orderRequest) {
    return axiosInstance.post(`${CHECKOUT_BASE}`, orderRequest);//.data;
  },

  async getMyOrders(customerId, status = '') {
    const url = status ? `${ORDER_BASE}/customer/${customerId}/${status}` : `${ORDER_BASE}/customer/${customerId}`;
    const reponse = await axiosInstance.get(url);
    return reponse.data;
  },

  async getOrderById(id) {
    console.log(id);
    const response = await axiosInstance.get(`${ORDER_BASE}/${id}`);
    console.log(response);
    return response.data;
  }
};

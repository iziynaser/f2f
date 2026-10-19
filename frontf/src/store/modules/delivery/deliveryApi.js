// src/api/deliveryApi.js
import axiosInstance from '@/api/axiosInstance';

const BASE = '/delivery';

export default {
  getDefaultDelivery(userId) {
    return axiosInstance.get(`${BASE}/user/${userId}/default`);
  },

  getDeliveryList(userId) {
    return axiosInstance.get(`${BASE}/user/${userId}`);
  },

  setDefaultDelivery(deliveryId, userId) {
    return axiosInstance.post(`${BASE}/${deliveryId}/default/user/${userId}`);
  },

  addDelivery(deliveryData) {
    return axiosInstance.post(`${BASE}`, deliveryData);
  },

  updateDelivery(id, deliveryData) {
    return axiosInstance.put(`${BASE}/${id}`, deliveryData);
  },

  deleteDelivery(deliveryId, userId) {
    return axiosInstance.delete(`${BASE}/${deliveryId}/user/${userId}`);
  }
};

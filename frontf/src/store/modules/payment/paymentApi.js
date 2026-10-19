import axiosInstance from '@/api/axiosInstance';

export default {
  // دریافت لیست درگاه‌های فعال
  getActiveGateways: function () {
    return axiosInstance.get('/api/payment/gateway/active');
  },

  // شروع فرآیند پرداخت
  startPayment: function (orderId, amount, gatewayType) {
    const dto = {
      orderId: orderId,
      amount: amount,
      gateway: gatewayType,
      callbackUrl: window.location.origin + '/payment-result' // token در سمت سرور اضافه می‌شود
    };
    return axiosInstance.post('/api/payment/initiate', dto);
  },

  // تأیید نتیجه پرداخت
  verifyPayment: function (queryParams) {
    var urlParams = new URLSearchParams(window.location.search);
    var token = urlParams.get('token');

    const dto = {
      authority: queryParams.authority,
      token: token,
      callbackUrl: window.location.href
    };

    return axiosInstance.post('/api/payment/verify', dto);
  }
};

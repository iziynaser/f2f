// interceptors.js
export default function interceptorSetup(axiosInstance) {
    const token = window.localStorage.getItem('access_token');

    // تنظیم Authorization فقط یک بار
    if (token) {
        axiosInstance.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    }

    // interceptor برای هر درخواست
    axiosInstance.interceptors.request.use(
        config => {
            // در صورت نیاز تغییر URL یا هدرهای خاص
            return config;
        },
        error => Promise.reject(error)
    );

    // interceptor برای پاسخ‌ها
    axiosInstance.interceptors.response.use(
        response => response,
        error => {
            if (error.message && error.message.includes('Network Error')) {
                console.log('Network Error:', error.message);
            }

            if (error.response && error.response.status === 401) {
                console.log('Unauthorized: Token may have expired.');
                // می‌توان logout یا redirect به /login انجام داد
            }

            return Promise.reject(error);
        }
    );
}

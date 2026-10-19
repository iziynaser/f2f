import axios from "axios";
import { appUrl, baseUrl } from "./util";

function getAccessToken() {
    return window.localStorage.getItem('access_token') || null;
}

const axiosInstance = axios.create({
    baseURL: appUrl('/'),
    timeout: 15000,
});

axiosInstance.interceptors.request.use(
    function(config) {
        var token = getAccessToken();

        var excludedUrls = [
            "/api/auth/signin",
            "/oauth/signIn",
            "/auth/signUp",
            "/captcha",
            "/oauth/token"
        ];

        var shouldSkipAuth = excludedUrls.some(function(url) {
            return config.url.indexOf(url) !== -1;
        });

        if (!shouldSkipAuth && token) {
            config.headers['Authorization'] = "Bearer " + token;
        }

        if (config.url.indexOf("oauth") !== -1 || config.url.indexOf("captcha") !== -1) {
            config.baseURL = baseUrl('/');
        }

        return config;
    },
    function(error) {
        return Promise.reject(error);
    }
);

axiosInstance.interceptors.response.use(
    function(response) {
        return response;
    },
    function(error) {
        if (error.message && error.message.indexOf("Network Error") !== -1) {
            console.log("❌ Network Error:", error.message);
            return Promise.reject(error);
        }

        if (error.response && error.response.status === 401) {
            console.log("⛔ Unauthorized → Token might be expired.");

            // اگر refresh token دارید، اینجا می‌شود Refresh Token زد
            // در غیر این صورت:
            // window.localStorage.removeItem("access_token");

            // optional redirect:
            // window.location.href = "/login";
        }

        return Promise.reject(error);
    }
);

export default axiosInstance;

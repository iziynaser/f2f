import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue, BootstrapVueIcons, ToastPlugin } from 'bootstrap-vue'
import router from './router'
import store from './store'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueI18Next from '@panter/vue-i18next';
import i18next from 'i18next';

import VueAxios from 'vue-axios';
import axiosInstance from './api/axiosInstance'; // instance اختصاصی Axios

import pdate from './components/pdate';
import f2fInvoiceType from './components/base/f2fInvoiceType';

import enJson from './locales/en';
import faJson from './locales/fa';

import interceptorSetup from './interceptors'; // default import

import { f2fChangeLocale } from './f2fUtils';
import { jalaliDate } from './filters/jalaliDate'

Vue.filter('jalaliDate', jalaliDate);

import moment from 'vue-jalali-moment'
Vue.use(moment)

import PersianCalendar from 'vue-persian-calendar';
Vue.use(PersianCalendar)

Vue.config.productionTip = false

Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)
Vue.use(VueI18Next)
Vue.use(ToastPlugin)
Vue.use(VueAxios, axiosInstance) // استفاده از instance اختصاصی

Vue.component('pdate', pdate);
Vue.component('f2fInvoiceType', f2fInvoiceType);

// تنظیم interceptorها
interceptorSetup(axiosInstance);

// i18next
i18next.init({
  lng: 'fa',
  fallbackLng: 'fa',
  whitelist: ['en', 'fa'],
  debug: true,
  resources: {
    en: enJson,
    fa: faJson
  }
}, (err, t) => {
  if (err) console.log('something went wrong loading', err);
  t('key');
});
const i18n = new VueI18Next(i18next);

f2fChangeLocale('fa');
Vue.config.devtools = true;

new Vue({
  router,
  store,
  i18n: i18n,
  render: h => h(App)
}).$mount('#app')

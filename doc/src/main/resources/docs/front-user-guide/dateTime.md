ابتدا در سمت کلاینت کامپوننت های لازم را نصب می کنیم
npm install moment moment-jalaali


بعد نحوه ثبت ان در کل پروزه
تغیرات زیر را درفایل main.js می دهیم:


import { jalaliDate } from './filters/jalaliDate';

// ثبت فیلتر عمومی به نام 'jalaliDate'
Vue.filter('jalaliDate', jalaliDate);

حالا هر جا نیاز داریم
<span>{{ order.createdAt | jalaliDate }}</span>
استفاده می کنیم

در صورتی که شخصی سازی شده بخواهیم :
computed: {
formattedDate() {
return this.$options.filters.jalaliDate(this.order.createdAt, 'jYYYY/jMM/jDD');
}
}


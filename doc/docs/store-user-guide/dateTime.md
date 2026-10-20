ابتدا در سمت کلاینت کامپوننت‌های لازم را نصب می‌کنیم:

```bash
npm install moment moment-jalaali
```

سپس در فایل `main.js`:

```javascript
import { jalaliDate } from './filters/jalaliDate';

// ثبت فیلتر عمومی
Vue.filter('jalaliDate', jalaliDate);
```

استفاده در Template:

```vue
<span>{{ order.createdAt | jalaliDate }}</span>
```

استفاده در computed:

```javascript
computed: {
  formattedDate() {
    return this.$options.filters.jalaliDate(
      this.order.createdAt,
      'jYYYY/jMM/jDD'
    );
  }
}
```
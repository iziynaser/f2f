---
# https://vitepress.dev/reference/default-theme-home-page
layout: home

hero:
  name: "face2face"
  text: "ERP/../CRM"
  tagline:  یادگیری و مستندسازی progressive توسعه نرم‌افزارهای کاربردی
  actions:
    - theme: brand
      text: مشاهده نسخه دمو
      link: /demo
    - theme: alt
      text: مشتریان/کاربران
      link: /users
    - theme: client
      text: فرانت
      link: /store-user-guide/
    - theme: alt
      text: بک اند
      link: /back-user-guide/
    - theme: alt
      text: احراز هویت
      link: /auth-guide/
    - theme: alt
      text:  گیت وی
      link: /gate-way-guide/
    - theme: alt
      text:  توسعه و برنامه نویسی
      link: /dev-guide/

features:
  - title: فروشگاه اینترنتی
    details: نرم افزار کاربردی برای راه اندازی فروشگاه انلاین. برای عرضه ، نمایش ، خرید و معرفی محصولات اینترنتی
  - title: بک افیس
    details: سیستم مدیریت قدرتمند و  برای پردازش سفارشات ، مدیریت موجودی ، مشتریان ، گزارشها است .
    
---

## 🧱 تکنولوژی مستندات
- **VitePress**
- Markdown
- RTL / فارسی
- GitHub Pages (در آینده)


برای اجرای برنامه بک اند به طور مستقیم بدون اینکه سایر مازول ها اجرا شده باشند امکان پذیر است
تنها باید دیتابیس های ردیس و پایگاه داده ای که برنامه بک اند داده های خود را در ان ذخیره می کنند در حال اجرا باشد
سپس در فایل
ApiPrefixConfig
به مقدار apiPrefix
را در ابتدای تمامی درخواست هایی که به سمت بک اند ارسال می شود قرار دهید به عنوان مثال اگر
این مقدار برابر با api
باشد درخواست های ارسالی به سرور مانند شکل زیر می شود:
http://localhost:8080/api/order/hi
http://localhost:8080/api/content/hi


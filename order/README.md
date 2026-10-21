# ماژول سفارش

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
- مازول سفارش ها
  

مثال:

- مدیریت سفارش‌ها (order)

---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- هنگام ساختن مازول وب این زیر مازول به برنامه اصلی اضافه می شود 
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl order

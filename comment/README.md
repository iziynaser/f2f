# <ModuleName> comment Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
- مازول نظرات : بصورت کلی دیده شده است تا امکان استفاده در سایر مازول ها فراهم باشد  
مثال:

- مدیریت نظرات
- مدیریت لایک / دیس لایک
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- هنگام ساخت مازول اصلی وب این زیر مازول به برنامه اضافه می شود 
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

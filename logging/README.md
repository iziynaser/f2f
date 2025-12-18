# <ModuleName> logging Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
- مازول لاک سیستم که سایر مازول ها بتوانند از ان استفاده کنند
مثال:

- مدیریت لاگ ها
- 
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- هنگام ساخت مازول وب این زیر مازول به برنامه اضافه می شود
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

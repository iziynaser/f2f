# <ModuleName> content Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
مازول وب که مدیریت محتوا را برای سایر مازول ها و برنامه ها فراهم می کند  
مثال:

- مدیریت مقاله ها
- مدیریت محتوا
- مدیریت تگ ها
- مدیریت صفحات
- مدیریت slug
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- هنگام ساخت مازول وب برنامه این زیر مازول به ان اضافه می شود 
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

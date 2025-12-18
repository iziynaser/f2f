# <ModuleName> delivery Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
 این مازول مدیریت delivery را انجام مید هد  
مثال:

- مدیریت delivery
- تعریف شهر/استان
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- هنگام ساخت مازول وب این زیر مازول به ان اضافه می شود 
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

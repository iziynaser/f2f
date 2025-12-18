# <ModuleName> asset Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
مازول دارایی ها و دارایی های ثابت   
مثال:

- asset
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- این مازول هنکام ساخت مازول وب به برنامه اصلی اضافه می شود
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

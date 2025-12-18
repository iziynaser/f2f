# <ModuleName> authClient Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
- این مازول برای اتصال برنامه به برنامه خارجی احراز هویت کمک می کند  
مثال:

- بلک لیست
- اتصال به برنامه خارجی احراز هویت
- کمک به اعتبار سنجی توکن ها
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- این برنامه هنگام ساختن مازول وب به برنامه اضافه می شود
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

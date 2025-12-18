# <ModuleName> frontb Module

> **Status:** 🟡 Draft  
> **Last Updated:** 2025-12-14  
> **Contributor-friendly:** ✅

---

## هدف ماژول
- مازول pwa بک افیس در این جا قرار گرفته است . برنامه بصورت مستقل توسعه داده شده است
- برای ساخت ان کافی است که خروجی برنامه در این مازول کپی شود
مثال:

- pwa 
- back office
- فرانت برنامه بک افیس
---

## بخش‌ها و اجزای داخلی
- Service‌ها
- Repository‌ها
- Controller‌ها
- مدل‌ها (Entities / DTOs)

> 🔸 دیاگرام ساده معماری می‌تواند اضافه شود

---

## نحوه استفاده و تست
- این برنامه بصورت جدا توسعه یافته است . 
- امکان integrate  کردن ان با core برنامه فراهم شده است 
```bash
# در ریشه پروژه اجرا شود
mvn clean install
mvn spring-boot:run -pl <ModuleName>

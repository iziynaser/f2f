لاگ‌های AOP در لایه Service مناسب‌تر هستند.

ولی اگر نیاز به پوشش لایه پایین‌تر داری (مثل Repository):

یا دستی catch و throw کن

یا اگر تعداد زیاد است، AOP روی Repository نیز فعال کن با @EnableAspectJAutoProxy(proxyTargetClass = true)
---
Spring Data Repositoryها proxy-based هستند و ممکن است AOP روی آن‌ها به‌صورت کامل کار نکند (بسته به تنظیمات). برای اینکه AOP در لایه Repository هم کار کند، باید تنظیمات proxyTargetClass=true باشد و @EnableAspectJAutoProxy(proxyTargetClass = true) را در کانفیگ فعال کرده باشی.
---
مشکلی در کوئری (مثل null ورودی)

یا اتصال دیتابیس قطع شده

اگر این Exception مثلاً javax.persistence.NoResultException یا org.hibernate.ObjectNotFoundException باشد و Hibernate یا Spring Data آن را داخل خودش هندل کند و فقط null یا empty Optional برگرداند، آنگاه شما هیچ Exceptionی در این متد نخواهید داشت.

پس AOP هم چیزی برای log کردن ندارد.
---
در Spring، وقتی می‌گوییم که Repositoryها proxy-based هستند، یعنی Spring به‌جای اینکه مستقیم کلاس Repository را بسازد، یک کلاس واسط (proxy) می‌سازد که عملکرد اصلی را اجرا کرده و در عین حال می‌تواند رفتارهای اضافی مانند Transaction، Logging، Caching و غیره را به آن اضافه کند.
---
چرا @Loggable در لایه Repository کار نمی‌کند؟
1. Repositoryها در Spring Data با Proxyهای JDK ساخته می‌شن (نه CGLIB)
یعنی فقط interfaceها پروکسی می‌شن، نه کلاس‌ها یا متدها.

وقتی از @Loggable روی متدهایی که در interface هستند استفاده می‌کنی، AOP نمی‌تونه به‌درستی اون‌ها رو "intercept" کنه.
---

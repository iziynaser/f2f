برای تعداد خیلی زیاد داده‌ها (مثلاً بیش از ۱۰۰۰۰ پرسش) این روش ممکن است فشار RAM ایجاد کند و باید با استفاده از NativeQuery یا QueryDSL در سطح DB حل شود.

## j1

Hibernate با JPQL نمی‌تواند ترکیب GROUP BY و ORDER BY COUNT(...) را به‌صورت کاملاً portable در همه دیتابیس‌ها پشتیبانی کند، مخصوصاً هنگام استفاده از Pageable.

## j2

Pageable وقتی با HQL یا JPQL استفاده می‌شود، باید توسط Hibernate تبدیل به SQL شود. اما اگر شما از یک projection (مثل QuestionWithAnswerCount) استفاده کنید، Hibernate باید هم:

تعداد کل نتایج را حساب کند (countQuery)

و هم نتایج اصلی را صفحه‌بندی کند (select ... with offset/limit)

## j3

constructor expression
HQL + DTO mapping

## j4

برای aggregate (COUNT) + GROUP BY و صفحه‌بندی مناسب‌تر است.

## j5

برای تعداد خیلی زیاد داده‌ها (مثلاً بیش از ۱۰۰۰۰ پرسش) این روش ممکن است فشار RAM ایجاد کند و باید با استفاده از NativeQuery یا QueryDSL در سطح DB حل شود.
---
Hibernate با JPQL نمی‌تواند ترکیب GROUP BY و ORDER BY COUNT(...) را به‌صورت کاملاً portable در همه دیتابیس‌ها پشتیبانی کند، مخصوصاً هنگام استفاده از Pageable.
---
Pageable وقتی با HQL یا JPQL استفاده می‌شود، باید توسط Hibernate تبدیل به SQL شود. اما اگر شما از یک projection (مثل QuestionWithAnswerCount) استفاده کنید، Hibernate باید هم:

تعداد کل نتایج را حساب کند (countQuery)

و هم نتایج اصلی را صفحه‌بندی کند (select ... with offset/limit)
---
constructor expression
HQL + DTO mapping
---
برای aggregate (COUNT) + GROUP BY و صفحه‌بندی مناسب‌تر است.
---
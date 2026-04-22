package com.f2f.service;

/*
بررسی اینکه دوره قبلی بسته نشده باشد
بررسی وجود تراکنش‌های POSTED
محاسبه Closing Balance برای هر حساب
تغییر وضعیت دوره به CLOSED
محاسبه Opening Balance برای دوره بعد (فقط ایجاد داده، نه فعال کردن دوره)


الگوریتم:
1. یافتن دوره
اگر دوره CLOSED بود → خطا

2. بررسی وجود تراکنش POSTED:
اگر در دوره تراکنش DRAFT باشد → خطا

(این موضوع بسیار مهم است)

3. استخراج AccountBalanceهای دوره جاری

4. محاسبه closingBalance:
closing = opening + debit - credit

5. ذخیره closingBalanceها

6. تغییر status دوره به CLOSED

7. ایجاد OpeningBalance برای دوره بعد (اگر دوره بعد وجود دارد)



 */

public interface PeriodClosingService {
    void closePeriod(Long periodId);
}

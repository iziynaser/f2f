package com.f2f.service;

import com.f2f.entity.AccountingPeriod;

/*
دوره بعدی را پیدا کن
اگر دوره بعد وجود ندارد → هیچ کاری نکن
برای هر حساب → یک AccountBalance جدید بساز
مقدار openingBalance = closingBalance دوره قبلی
debit/credit دوره جدید = 0
closingBalance = openingBalance
(موقتی؛ بعداً در طول دوره به‌روز می‌شود)
 */

public interface OpeningBalanceGenerator {
    void generateOpening(AccountingPeriod closedPeriod);
}

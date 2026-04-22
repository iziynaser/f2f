package com.f2f.service;

import com.f2f.dto.AccountLedgerDto;
import com.f2f.dto.GeneralLedgerDto;
/*
منطق محاسباتی (algorithm)
برای Account Ledger:
opening balance = جمع مانده قبل از شروع دوره
از AccountBalance یا از سرویس موجود balanceUpdater استفاده می‌شود
دریافت همه TransactionDetail های حساب
برای هر Detail:
اگر debit → مانده += amountFunctional
اگر credit → مانده -= amountFunctional
ساخت LedgerEntryDto
محاسبه closing balance

مانده:
if (type == DEBIT) balance = balance + amount
if (type == CREDIT) balance = balance - amount


 */

public interface LedgerService {

    AccountLedgerDto getAccountLedger(Long accountId, Long periodId);
    GeneralLedgerDto getGeneralLedger(Long periodId);
}

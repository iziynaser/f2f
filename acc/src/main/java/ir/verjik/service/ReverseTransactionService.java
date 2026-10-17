package ir.verjik.service;

import ir.verjik.entity.AccountingTransaction;

/*
1. دریافت transaction اصلی
2. اگر پیدا نشد → Exception
3. اگر status != POSTED → Exception
4. اگر period بسته است → Exception
5. ساخت یک تراکنش جدید:
      - همان period
      - همان تاریخ
      - توضیح = "REVERSAL OF TX-XXX"
      - status = POSTED
6. برای هر detail:
      debit ↔ credit swap
7. ذخیره reversal
8. تغییر status تراکنش اصلی به REVERSED
9. set reversedFrom روی reversal
10. save هر دو
11. فراخوانی AccountBalanceUpdaterService برای sync

 */
public interface ReverseTransactionService {
    AccountingTransaction reverse(Long transactionId, String reason);
}

4) تجمیع و گزارش‌گیری Balance Sheet / Trial Balance / P&L – نیازمند API سرویس

با دیتای موجود، خیلی راحت می‌توانیم سرویس‌های زیر را بسازیم:

Trial Balance
General Ledger
Account Ledger
Balance Sheet
Profit & Loss

LedgerService
FinancialReportService
TrialBalanceService

getAccountLedger(accountId, period)
getTrialBalance(period)
getBalanceSheet(period)
getProfitAndLoss(period)

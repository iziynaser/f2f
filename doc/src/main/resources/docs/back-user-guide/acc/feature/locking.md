6) موتور Locking اسناد (Transaction Locking Engine) – نیازمند تکمیل

تو فقط سه وضعیت داری:

DRAFT
POSTED
LOCKED
REVERSED
CANCELLED

ما منطق تغییر وضعیت کامل نیست.

باید اضافه شود:
هر سند Posted شده باید immutable شود
اگر دوره بسته شد → هیچ سند جدید ثبت نشود
Reverse باید سند معکوس ایجاد کند

برای هر Detail:
اگر Debit → Credit
اگر Credit → Debit
amount همان

ایجاد سند جدید با link به منبع


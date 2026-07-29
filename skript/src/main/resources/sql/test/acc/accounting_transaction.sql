-- =========================================
-- ACCOUNTING TRANSACTIONS
-- =========================================

INSERT INTO accounting_transaction
(
    id,
    transaction_number,
    period_id,
    transaction_status,
    transaction_type,
    posted_date,
    posted_by,
    approved_by,
    auto_generated,
    description,
    additional_data,
    entry_date,
    transaction_date,
    source_module,
    source_id,
    reversed_from_id,
    reversal_reason,
    record_status,
    version,
    remarks,
    sort_priority,
    date_created,
    last_modified
)
VALUES
-- فروش نسیه
(1,'TRX-1001',1,'POSTED','INVOICE','2025-01-01',101,201,false,
 'فاکتور فروش نسیه','{}','2025-01-01','2025-01-01',
 'SALES',1001,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- دریافت وجه از مشتری
(2,'TRX-1002',1,'POSTED','RECEIPT','2025-01-02',101,201,false,
 'دریافت وجه مشتری','{}','2025-01-02','2025-01-02',
 'CASH',1002,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- خرید موجودی نسیه
(3,'TRX-1003',1,'POSTED','INVENTORY','2025-01-03',101,201,false,
 'خرید مواد اولیه','{}','2025-01-03','2025-01-03',
 'WAREHOUSE',1003,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- پرداخت حقوق
(4,'TRX-1004',1,'POSTED','HR','2025-01-04',101,201,false,
 'پرداخت حقوق اداری','{}','2025-01-04','2025-01-04',
 'HR',1004,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- دریافت درآمد خدمات
(5,'TRX-1005',1,'POSTED','RECEIPT','2025-01-05',101,201,false,
 'درآمد خدمات','{}','2025-01-05','2025-01-05',
 'SERVICE',1005,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- انتقال وجه صندوق به بانک
(6,'TRX-1006',1,'POSTED','TRANSFER','2025-01-06',101,201,false,
 'انتقال وجه به بانک','{}','2025-01-06','2025-01-06',
 'BANK',1006,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- ثبت استهلاک
(7,'TRX-1007',1,'POSTED','ADJUSTMENT','2025-01-07',101,201,false,
 'ثبت هزینه استهلاک','{}','2025-01-07','2025-01-07',
 'ACCOUNTING',1007,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- ثبت سرمایه اولیه
(8,'TRX-1008',1,'POSTED','OPENING','2025-01-08',101,201,false,
 'ثبت سرمایه اولیه','{}','2025-01-08','2025-01-08',
 'ACCOUNTING',1008,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- ثبت هزینه اجاره
(9,'TRX-1009',1,'POSTED','TRANSFER','2025-01-09',101,201,false,
 'پرداخت اجاره','{}','2025-01-09','2025-01-09',
 'ACCOUNTING',1009,NULL,NULL,0,0,NULL,0,NOW(),NOW()),

-- برگشت فروش
(10,'TRX-1010',1,'POSTED','REVERSAL','2025-01-10',101,201,false,
 'برگشت از فروش','{}','2025-01-10','2025-01-10',
 'SALES',1010,NULL,NULL,0,0,NULL,0,NOW(),NOW());

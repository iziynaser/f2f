
-- 2. درج سفارش‌ها با وضعیت‌های مختلف

-- سفارش 1 - جاری (CREATED)
INSERT INTO orders (id, order_code, creator_person_id, order_date, current_status, invoice_id)
VALUES (1, 'ORD-1001', 1, NOW() - INTERVAL '2 day', 'CREATED', NULL);

-- سفارش 2 - تحویل شده (DELIVERED)
INSERT INTO orders (id, order_code, creator_person_id, order_date, current_status, invoice_id)
VALUES (2, 'ORD-1002', 2, NOW() - INTERVAL '10 day', 'DELIVERED', 101);

-- سفارش 3 - لغو شده (CANCELED)
INSERT INTO orders (id, order_code, creator_person_id, order_date, current_status, invoice_id)
VALUES (3, 'ORD-1003', 1, NOW() - INTERVAL '5 day', 'CANCELED', NULL);

-- سفارش 4 - مرجوع شده (RETURNED)
INSERT INTO orders (id, order_code, creator_person_id, order_date, current_status, invoice_id)
VALUES (4, 'ORD-1004', 3, NOW() - INTERVAL '7 day', 'RETURNED', 102);

-- 3. درج آیتم‌های سفارش برای هر سفارش

-- سفارش 1
INSERT INTO order_item (id, order_id, product_item_id, quantity, unit_price, total_price)
VALUES
    (1, 1, 1001, 2, 150000, 300000),
    (2, 1, 1002, 1, 250000, 250000);

-- سفارش 2
INSERT INTO order_item (id, order_id, product_item_id, quantity, unit_price, total_price)
VALUES
    (115, 2, 111, 1000, 200000, 200000),
    (116, 2, 1001, 1001, 75000, 150000),
    (117, 2, 1000, 1001, 75000, 150000),
    (118, 2, 1011, 1001, 75000, 150000),
    (119, 2, 1010, 1001, 75000, 150000);

-- سفارش 3
INSERT INTO order_item (id, order_id, product_item_id, quantity, unit_price, total_price)
VALUES
    (15, 3, 111, 1000, 200000, 200000),
    (16, 3, 1001, 1001, 75000, 150000),
    (17, 3, 1000, 1001, 75000, 150000),
    (18, 3, 1011, 1001, 75000, 150000),
    (19, 3, 1010, 1001, 75000, 150000);

-- سفارش 4
INSERT INTO order_item (id, order_id, product_item_id, quantity, unit_price, total_price)
VALUES
    (5, 4, 111, 1000, 200000, 200000),
    (6, 4, 1001, 1001, 75000, 150000),
    (7, 4, 1000, 1001, 75000, 150000),
    (8, 4, 1011, 1001, 75000, 150000),
    (9, 4, 1010, 1001, 75000, 150000);

-- 4. درج تاریخچه وضعیت سفارش‌ها

-- سفارش 1 (CREATED)
INSERT INTO order_status (id, order_id, status, status_date, comment, startDate, endDate, registerDate, deliveryDate)
VALUES
    (1, 1, 'CREATED', NOW() - INTERVAL '2 day', 'سفارش ثبت شد', NOW() - INTERVAL '2 day', NULL, NOW() - INTERVAL '2 day', NULL);

-- سفارش 2 (DELIVERED)
INSERT INTO order_status (id, order_id, status, status_date, comment, startDate, endDate, registerDate, deliveryDate)
VALUES
    (2, 2, 'CREATED', NOW() - INTERVAL '12 day', 'سفارش ثبت شد', NOW() - INTERVAL '12 day', NULL, NOW() - INTERVAL '12 day', NULL),
    (3, 2, 'PAID', NOW() - INTERVAL '11 day', 'پرداخت انجام شد', NOW() - INTERVAL '11 day', NULL, NOW() - INTERVAL '11 day', NULL),
    (4, 2, 'PROCESSING', NOW() - INTERVAL '10 day', 'در حال پردازش', NOW() - INTERVAL '10 day', NULL, NOW() - INTERVAL '10 day', NULL),
    (5, 2, 'DELIVERED', NOW() - INTERVAL '8 day', 'تحویل داده شد', NOW() - INTERVAL '8 day', NULL, NOW() - INTERVAL '8 day', NOW() - INTERVAL '8 day');

-- سفارش 3 (CANCELED)
INSERT INTO order_status (id, order_id, status, status_date, comment, startDate, endDate, registerDate, deliveryDate)
VALUES
    (6, 3, 'CREATED', NOW() - INTERVAL '6 day', 'سفارش ثبت شد', NOW() - INTERVAL '6 day', NULL, NOW() - INTERVAL '6 day', NULL),
    (7, 3, 'CANCELED', NOW() - INTERVAL '5 day', 'سفارش لغو شد', NOW() - INTERVAL '5 day', NOW() - INTERVAL '5 day', NOW() - INTERVAL '5 day', NULL);

-- سفارش 4 (RETURNED)
INSERT INTO order_status (id, order_id, status, status_date, comment, startDate, endDate, registerDate, deliveryDate)
VALUES
    (8, 4, 'CREATED', NOW() - INTERVAL '9 day', 'سفارش ثبت شد', NOW() - INTERVAL '9 day', NULL, NOW() - INTERVAL '9 day', NULL),
    (9, 4, 'DELIVERED', NOW() - INTERVAL '7 day', 'تحویل داده شد', NOW() - INTERVAL '7 day', NULL, NOW() - INTERVAL '7 day', NOW() - INTERVAL '7 day'),
    (10, 4, 'RETURNED', NOW() - INTERVAL '3 day', 'مرجوع شده', NOW() - INTERVAL '3 day', NOW() - INTERVAL '3 day', NOW() - INTERVAL '3 day', NULL);

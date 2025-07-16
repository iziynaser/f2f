-- 1. تخفیف ۱۰ درصدی عمومی
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, discount_type, discount_value, active, start_date, end_date)
VALUES (1, 'تخفیف ۱۰ درصدی', 'MONETARY', 'DISCOUNT_PERCENTAGE', 'PERCENTAGE', 10, true, CURRENT_DATE, CURRENT_DATE + INTERVAL '5 days');

-- شرط: اعمال در تهران
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (1, 'geoLocation', 'EQ', 'TEHRAN', 'STRING');


-- 2. قابل مرجوعی تا ۲ روز (مزیت غیرمالی سفارشی)
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, active, start_date, end_date)
VALUES (2, 'قابل مرجوعی تا ۲ روز', 'NON_MONETARY', 'CUSTOM_BENEFIT', true, CURRENT_DATE, CURRENT_DATE + INTERVAL '5 days');

-- شرط: حداقل یک کالا
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (2, 'quantity', 'GTE', '1', 'NUMBER');


-- 3. ۲۰٪ تخفیف برای افراد خاص
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, discount_type, discount_value, active, start_date, end_date)
VALUES (3, '۲۰٪ تخفیف برای افراد خاص', 'MONETARY', 'DISCOUNT_PERCENTAGE', 'PERCENTAGE', 20, true, CURRENT_DATE, CURRENT_DATE + INTERVAL '7 days');

-- شرط: اعمال فقط برای برخی کاربران
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (3, 'personId', 'IN', '123,456', 'NUMBER');


-- 4. تخفیف عمومی ۱۰٪
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, discount_type, discount_value, active, start_date, end_date)
VALUES (4, 'تخفیف ۱۰٪ عمومی', 'MONETARY', 'DISCOUNT_PERCENTAGE', 'PERCENTAGE', 10, true, CURRENT_DATE, CURRENT_DATE + INTERVAL '7 days');


-- 5. یکی بخر دوتا ببر
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, active, start_date, end_date)
VALUES (5, 'یکی بخر دوتا ببر', 'NON_MONETARY', 'BUY_ONE_GET_ONE', true, CURRENT_DATE, CURRENT_DATE + INTERVAL '3 days');

-- شرط: اعمال فقط برای دو کالا خاص
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (5, 'productItemId', 'IN', '1001,1002', 'NUMBER');


-- 6. ارسال سریع محصولات برند خاص
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, active, start_date, end_date)
VALUES (6, 'ارسال سریع محصولات برند خاص', 'NON_MONETARY', 'FAST_DELIVERY', true, CURRENT_DATE, CURRENT_DATE + INTERVAL '7 days');

-- شرط: برند خاص
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (6, 'brandId', 'EQ', '2001', 'NUMBER');


-- 7. هدیه برای برند خاص
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, active, start_date, end_date)
VALUES (7, 'هدیه برای برند خاص', 'NON_MONETARY', 'GIFT_ITEM', true, CURRENT_DATE, CURRENT_DATE + INTERVAL '7 days');

-- شرط: برند خاص
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (7, 'brandId', 'EQ', '2001', 'NUMBER');


-- 8. تخفیف روز تولد
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, discount_type, discount_value, active, start_date, end_date)
VALUES (8, 'تخفیف روز تولد', 'MONETARY', 'DISCOUNT_PERCENTAGE', 'PERCENTAGE', 15, true, CURRENT_DATE, CURRENT_DATE + INTERVAL '3 days');

-- شرط: تاریخ تولد = امروز
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (8, 'birthDate', 'EQ', CURRENT_DATE::text, 'DATE');


-- 9. تخفیف روز مهندس
INSERT INTO discount_rule (id, name, benefit_type, benefit_action, discount_type, discount_value, active, start_date, end_date)
VALUES (9, 'تخفیف روز مهندس', 'MONETARY', 'DISCOUNT_PERCENTAGE', 'PERCENTAGE', 10, true, '2025-02-24', '2025-03-05');

-- شرط: دقیقاً روز ۵ اسفند
INSERT INTO rule_condition (discount_rule_id, field, operator, value, value_type)
VALUES (9, 'requestDate', 'EQ', '2025-03-05', 'DATE');

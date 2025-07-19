-- ====== COMMENT_TARGET ======
INSERT INTO comment_target (id, target_type, target_id)
VALUES
    (100, 'PRODUCT', 2001),
    (101, 'ORDER', 3001);

-- ====== COMMENT ======
INSERT INTO comment (id, comment_target_id, subject, body, status, user_account_id)
VALUES
    (1000, 100, 'خرید عالی بود', 'کالای با کیفیتی بود و سریع رسید.', 'APPROVED', 1),
    (1001, 100, 'مشکل در حمل', 'محصول خوب بود ولی دیر رسید.', 'PENDING', 2),
    (1002, 101, 'سفارش ناقص بود', 'یک مورد داخل جعبه نبود.', 'REJECTED', 3);

-- ====== COMMENT_BENEFITS ======
INSERT INTO comment_benefits (id, comment_id, name)
VALUES
    (1, 1000, 'کیفیت بالا'),
    (2, 1000, 'بسته‌بندی مناسب'),
    (3, 1001, 'ظاهر مناسب');

-- ====== COMMENT_UPSETS ======
INSERT INTO comment_upsets (id, comment_id, name)
VALUES
    (1, 1001, 'تاخیر در ارسال'),
    (2, 1002, 'کالای ناقص'),
    (3, 1002, 'پشتیبانی ضعیف');

-- ====== COMMENT_REACTIONS ======
INSERT INTO comment_reactions (id, comment_id, user_id, reaction_type)
VALUES
    (1, 1000, 11, 'LIKE'),
    (2, 1000, 12, 'LIKE'),
    (3, 1000, 13, 'LAUGH'),
    (4, 1001, 11, 'DISLIKE'),
    (5, 1002, 14, 'ANGRY');

-- QaTarget‌ها (مثلاً برای درس‌ها با شناسه‌های مختلف)
INSERT INTO qa_target (id, target_type, target_id)
VALUES
    (1, 'PRODUCT', 1001),
    (2, 'PRODUCT', 1002),
    (3, 'PRODUCT', 2),
    (4, 'PRODUCT', 1),
    (5, 'PRODUCT', 111);


-- سوالات اصلی (parent = null)
INSERT INTO question_answer
(id, qa_target_id, subject, body, status, user_account_id, parent_id)
VALUES
    (1, 1, 'چگونه در آزمون موفق شوم؟', 'لطفا نکاتی برای موفقیت در آزمون‌ها ارائه دهید.', 'APPROVED', 1001, NULL),
    (2, 1, 'منابع پیشنهادی برای درس ریاضی چیست؟', 'کدام کتاب‌ها برای تقویت ریاضی توصیه می‌کنید؟', 'APPROVED', 1002, NULL),
    (3, 2, 'چطور برنامه‌نویسی را شروع کنیم؟', 'از چه زبان‌هایی شروع کنیم بهتر است؟', 'APPROVED', 1003, NULL),
    (4, 2, 'آیا این محصول گارانتی دارد؟', 'می‌خواهم بدانم شرایط گارانتی چگونه است.', 'APPROVED', 1004, NULL),
    (5, 3, 'چطور برنامه‌نویسی را شروع کنیم؟', 'از چه زبان‌هایی شروع کنیم بهتر است؟', 'APPROVED', 1003, NULL),
    (6, 3, 'آیا این محصول گارانتی دارد؟', 'می‌خواهم بدانم شرایط گارانتی چگونه است.', 'APPROVED', 1004, NULL),
    (7, 4, 'چطور برنامه‌نویسی را شروع کنیم؟', 'از چه زبان‌هایی شروع کنیم بهتر است؟', 'APPROVED', 1003, NULL),
    (8, 4, 'آیا این محصول گارانتی دارد؟', 'می‌خواهم بدانم شرایط گارانتی چگونه است.', 'APPROVED', 1004, NULL);

-- پاسخ‌ها به سوالات بالا
INSERT INTO question_answer (id, qa_target_id, subject, body, status, user_account_id, parent_id)
VALUES
    (5, 1, null, 'مرور منظم و تست‌زنی کمک می‌کند.', 'APPROVED', 1005, 1),
    (6, 1, null, 'آزمون‌های شبیه‌سازی شده هم مفیدند.', 'APPROVED', 1006, 1),
    (7, 1, null, 'فقط تمرین، تمرین، تمرین!', 'APPROVED', 1007, 1),
    (8, 2, null, 'کتاب‌های نشر الگو عالی‌اند.', 'APPROVED', 1008, 2),
    (9, 2, null, 'ریاضی مهندس هم بد نیست.', 'APPROVED', 1009, 2),
    (10, 2, null, 'فیلم‌های آموزشی یوتیوب را ببینید.', 'APPROVED', 1010, 2),
    (11, 3, null, 'از Khan Academy شروع کنید.', 'APPROVED', 1011, 3),
    (12, 3, null, 'پایتون بهترین شروع است.', 'APPROVED', 1012, 3),
    (13, 3, null, 'اول الگوریتم یاد بگیر.', 'APPROVED', 1013, 3),
    (14, 4, null, 'آزمون‌های شبیه‌سازی شده هم مفیدند.', 'APPROVED', 1006, 4),
    (15, 4, null, 'فقط تمرین، تمرین، تمرین!', 'APPROVED', 1007, 4),
    (16, 4, null, 'کتاب‌های نشر الگو عالی‌اند.', 'APPROVED', 1008, 4),
    (17, 5, null, 'از Khan Academy شروع کنید.', 'APPROVED', 1011, 5),
    (18, 5, null, 'پایتون بهترین شروع است.', 'APPROVED', 1012, 5),
    (19, 5, null, 'اول الگوریتم یاد بگیر.', 'APPROVED', 1013, 5);

-- واکنش‌ها به سوالات و پاسخ‌ها (Like / Dislike)
INSERT INTO qa_reactions (id, question_answer_id, user_id, reaction_type, date_created, date_modified)
VALUES
    (1, 1, 1002, 'LIKE', now(), now()),
    (2, 1, 1003, 'DISLIKE', now(), now()),
    (3, 5, 1001, 'LIKE', now(), now()),
    (4, 6, 1001, 'LIKE', now(), now()),
    (5, 6, 1005, 'DISLIKE', now(), now()),
    (6, 8, 1002, 'LIKE', now(), now()),
    (7, 9, 1004, 'LIKE', now(), now()),
    (8, 10, 1006, 'LIKE', now(), now()),
    (9, 11, 1007, 'DISLIKE', now(), now()),
    (10, 12, 1008, 'LIKE', now(), now()),
    (11, 12, 1009, 'LIKE', now(), now()),
    (12, 13, 1010, 'DISLIKE', now(), now());

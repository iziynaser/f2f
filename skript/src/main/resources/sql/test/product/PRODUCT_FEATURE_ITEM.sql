INSERT INTO pr_feature_item (id, feature_item_name, feature_item_value, feature_group_id, orders) VALUES
                        (200, 'نوع گوشی', 'موبایل', 100, 1),
                        (201, 'سیستم عامل', 'اندروید', 100, 2),
                        (202, 'دسته‌بندی', 'پرچم‌دار', 100, 3),
                        (203, 'مدل', 'Galaxy S24 Ultra', 100, 4),
                        (204, 'ابعاد', '۸.۶×۷۹×۱۶۲.۳ میلی‌متر', 100, 5),
                        (205, 'وزن', '۲۳۳ گرم', 100, 6),
                        (206, 'تعداد سیم کارت', 'دو عدد', 100, 7);


INSERT INTO pr_feature_value (id, feature_items_name, feature_items_value, feature_item_id, orders) VALUES
                                                                                                        (300, 'نوع گوشی', 'موبایل', 200, 1),
                                                                                                        (301, 'سیستم عامل', 'اندروید', 201, 1),
                                                                                                        (302, 'دسته‌بندی', 'پرچم‌دار', 202, 1),
                                                                                                        (303, 'مدل', 'Galaxy S24 Ultra', 203, 1),
                                                                                                        (304, 'ابعاد', '۸.۶×۷۹×۱۶۲.۳ میلی‌متر', 204, 1),
                                                                                                        (305, 'وزن', '۲۳۳ گرم', 205, 1),
                                                                                                        (306, 'تعداد سیم کارت', 'دو عدد', 206, 1);

INSERT INTO pr_feature_group (id, feature_group_name, feature_group_value, product_id, orders)
VALUES (101, 'صفحه نمایش', 'مشخصات نمایشگر', 1, 2);

INSERT INTO pr_feature_item (id, feature_item_name, feature_item_value, feature_group_id, orders) VALUES
                                                                                                      (210, 'فناوری صفحه‌ نمایش', 'Dynamic LTPO AMOLED 2X', 101, 1),
                                                                                                      (211, 'نرخ به‌روزرسانی تصویر', '120 هرتز', 101, 2),
                                                                                                      (212, 'روشنایی صفحه نمایش', '2600 نیت', 101, 3),
                                                                                                      (213, 'اندازه', '6.8 اینچ', 101, 4),
                                                                                                      (214, 'رزولوشن', '1440×3120 پیکسل', 101, 5);

INSERT INTO pr_feature_value (id, feature_items_name, feature_items_value, feature_item_id, orders) VALUES
                                                                                                        (310, 'فناوری صفحه‌ نمایش', 'Dynamic LTPO AMOLED 2X', 210, 1),
                                                                                                        (311, 'نرخ به‌روزرسانی تصویر', '120 هرتز', 211, 1),
                                                                                                        (312, 'روشنایی صفحه نمایش', '2600 نیت', 212, 1),
                                                                                                        (313, 'اندازه', '6.8 اینچ', 213, 1),
                                                                                                        (314, 'رزولوشن', '1440×3120 پیکسل', 214, 1);

INSERT INTO pr_feature_group (id, feature_group_name, feature_group_value, product_id, orders)
VALUES (102, 'پردازنده', 'مشخصات سخت افزاری', 1, 3);

INSERT INTO pr_feature_item (id, feature_item_name, feature_item_value, feature_group_id, orders) VALUES
                                                                                                      (220, 'تراشه', 'Snapdragon 8 Gen 3', 102, 1),
                                                                                                      (221, 'پردازنده مرکزی', '8 هسته‌ای با فرکانس 3.39 تا 2.2 GHz', 102, 2),
                                                                                                      (222, 'پردازنده گرافیکی', 'Adreno 750 (1 GHz)', 102, 3);

INSERT INTO pr_feature_value (id, feature_items_name, feature_items_value, feature_item_id, orders) VALUES
                                                                                                        (320, 'تراشه', 'Snapdragon 8 Gen 3', 220, 1),
                                                                                                        (321, 'پردازنده مرکزی', '8 هسته‌ای با فرکانس 3.39 تا 2.2 GHz', 221, 1),
                                                                                                        (322, 'پردازنده گرافیکی', 'Adreno 750 (1 GHz)', 222, 1);

-- 5. گروه ویژگی: باتری
INSERT INTO pr_feature_group (id, feature_group_name, feature_group_value, product_id, orders)
VALUES (103, 'باتری', 'مشخصات باتری و شارژ', 1, 4);

INSERT INTO pr_feature_item (id, feature_item_name, feature_item_value, feature_group_id, orders) VALUES
                                                                                                      (230, 'ظرفیت باتری', '5000 میلی آمپر ساعت', 103, 1),
                                                                                                      (231, 'نوع باتری', 'لیتیوم یونی', 103, 2),
                                                                                                      (232, 'توان شارژ', '45 وات', 103, 3);

INSERT INTO pr_feature_value (id, feature_items_name, feature_items_value, feature_item_id, orders) VALUES
                                                                                                        (330, 'ظرفیت باتری', '5000 میلی آمپر ساعت', 230, 1),
                                                                                                        (331, 'نوع باتری', 'لیتیوم یونی', 231, 1),
                                                                                                        (332, 'توان شارژ', '45 وات', 232, 1);

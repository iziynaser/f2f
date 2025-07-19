-- محصولات دیجیتال
INSERT INTO PRODUCT (product_id, name, internal_name, product_code, category_id, divisible, product_dimension, is_virtual, intro_date, description)
VALUES
    (300, 'گوشی گلکسی A50', 'galaxy-a50', 'MBL-A50', 1, false, '146x70x7.7', 'N', '2025-01-01', 'گوشی میان‌رده سامسونگ'),
    (301, 'تلویزیون ال‌جی 55 اینچ', 'lg-tv-55', 'TV-LG-55', 1, false, '123x72x8', 'N', '2025-03-01', 'تلویزیون هوشمند ال‌جی'),

-- پوشاک
    (302, 'کفش ورزشی مردانه نایکی', 'nike-shoe-men', 'SHOE-NIKE-MEN', 2, false, '30x15x10', 'N', '2025-02-01', 'کفش اورجینال نایکی مخصوص دویدن'),
    (303, 'تاپ زنانه آدیداس', 'adidas-top-women', 'TOP-ADIDAS-WOMEN', 3, false, '25x20x2', 'N', '2025-04-01', 'تاپ زنانه مناسب ورزش'),

-- لوازم خانگی
    (304, 'زودپز تفال مدل 10 لیتری', 'tefal-pressure-cooker', 'COOKER-TEFAL', 4, false, '40x30x30', 'N', '2025-01-01', 'زودپز استیل با کیفیت');

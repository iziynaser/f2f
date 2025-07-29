INSERT INTO DELIVERY (
    id, user_account_id, ostan_id, shahr_id, postal_address,
    pelak, unit, postal_code, deliver_name, deliver_famil,
    national_code, mobile_no, mobile_no2, who_is_getter,
    latitude, longitude, delivery_status, delivery_time,
    delivery_date, is_active, is_default
)
VALUES (
           3,                       -- فرض بر اینکه از sequence استفاده می‌کنی
           123,                     -- userAccountId
           1,                       -- ostanId
           10,                      -- shahrId
           'تهران، خیابان انقلاب، پلاک 10، واحد 2',
           '10',                    -- pelak
           '2',                     -- unit
           '1234567890',            -- postal_code
           'علی',                  -- deliver_name
           'رضایی',                -- deliver_famil
           '0012345678',            -- national_code
           '09121234567',           -- mobile_no1
           NULL,                    -- mobile_no2
           'self',                  -- who_is_getter
           '35.6892',               -- latitude
           '51.3890',               -- longitude
           'PENDING',               -- delivery_status (Enum)
           NULL,                    -- delivery_time
           NULL,                    -- delivery_date
           true,                    -- is_active
           false                    -- is_default
       );

INSERT INTO DELIVERY (
    id, user_account_id, ostan_id, shahr_id, postal_address,
    pelak, unit, postal_code, deliver_name, deliver_famil,
    national_code, mobile_no, mobile_no2, who_is_getter,
    latitude, longitude, delivery_status, delivery_time,
    delivery_date, is_active, is_default
)
VALUES (
           4,                       -- فرض بر اینکه از sequence استفاده می‌کنی
           1,                     -- userAccountId
           1,                       -- ostanId
           10,                      -- shahrId
           'تهران، خیابان انقلاب، پلاک 10، واحد 2',
           '10',                    -- pelak
           '2',                     -- unit
           '1234567890',            -- postal_code
           'علی',                  -- deliver_name
           'رضایی',                -- deliver_famil
           '0012345678',            -- national_code
           '09121234567',           -- mobile_no1
           NULL,                    -- mobile_no2
           'self',                  -- who_is_getter
           '35.6892',               -- latitude
           '51.3890',               -- longitude
           'PENDING',               -- delivery_status (Enum)
           NULL,                    -- delivery_time
           NULL,                    -- delivery_date
           true,                    -- is_active
           false                    -- is_default
       );

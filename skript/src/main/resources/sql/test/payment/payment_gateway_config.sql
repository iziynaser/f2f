INSERT INTO payment_gateway_config (
    gateway_type, active, default_gateway, merchant_id, callback_url, sandbox, description
) VALUES
    ('MOCK', true, true, 'mock-merchant', 'http://localhost:8080/payment/callback', true, 'شبیه‌ساز پرداخت');

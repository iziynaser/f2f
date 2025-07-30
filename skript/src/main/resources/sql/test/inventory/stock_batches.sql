INSERT INTO stock_batches
(product_item_id, warehouse_id, batch_number, entry_Date, arrival_Date, manufacture_Date, expiry_Date, quantity, sold, remaining, available, out_Stock_Date)
VALUES
    (2, 2, 1001, '2025-07-01', '2025-07-01', '2025-06-15', '2027-06-15', 100, 20, 80, true, NULL),
    (3, 2, 1002, '2025-07-05', '2025-07-05', '2025-06-20', '2027-06-20', 50, 10, 40, true, NULL),
    (4, 3, 2001, '2025-07-03', '2025-07-03', '2025-05-01', '2026-05-01', 200, 50, 150, true, NULL);

INSERT INTO stock_batches
(product_item_id, warehouse_id, batch_number, entry_Date, arrival_Date, manufacture_Date, expiry_Date, quantity, sold, remaining, available, out_Stock_Date)
VALUES
    (28, 2, 1001, '2025-07-01', '2025-07-01', '2025-06-15', '2027-06-15', 100, 20, 80, true, NULL),
    (30, 2, 1001, '2025-07-01', '2025-07-01', '2025-06-15', '2027-06-15', 100, 20, 80, true, NULL),
    (31, 2, 1001, '2025-07-01', '2025-07-01', '2025-06-15', '2027-06-15', 100, 20, 80, true, NULL);
INSERT INTO pos
(name, telephone, cellphone, address, model, brand, id_city, id_conn_type,
 morning_opening, morning_closing, afternoon_opening, afternoon_closing, insert_date)
VALUES
    ('POS Central', '021111111', '0991111111', 'Main street 1', 'X100', 'Verifone', 1, 1,
     '08:00', '12:00', '14:00', '18:00', CURRENT_DATE),

    ('POS Market', '021222222', '0992222222', 'Market ave 10', 'A920', 'Ingenico', 1, 2,
     '07:30', '11:30', '13:30', '17:30', CURRENT_DATE),

    ('POS Mall', '021333333', '0993333333', 'Mall road 5', 'Move5000', 'Verifone', 2, 1,
     '09:00', '13:00', '15:00', '19:00', CURRENT_DATE),

    ('POS Airport', '021444444', '0994444444', 'Airport terminal', 'DX8000', 'PAX', 2, 2,
     '06:00', '12:00', '13:00', '20:00', CURRENT_DATE),

    ('POS Pharmacy', '021555555', '0995555555', 'Health st 7', 'A80', 'Ingenico', 1, 1,
     '08:30', '12:30', '14:30', '18:30', CURRENT_DATE),

    ('POS Gas Station', '021666666', '0996666666', 'Highway km 12', 'IM30', 'PAX', 2, 2,
     '00:00', '12:00', '12:00', '23:59', CURRENT_DATE);

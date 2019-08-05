INSERT INTO simple_service_contacts (id, first_name, last_name)
VALUES  (1, 'Mr', 'Mittens'),
        (2, 'Mr', 'Fuzzy'),
        (3, 'Ms', 'Scar'),
        (4, 'Lady', 'Jingles'),
        (5, 'Sir', 'Pur')
ON CONFLICT DO NOTHING;
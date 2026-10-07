INSERT INTO partner (id, name, description, is_active, created_date)
SELECT gen_random_uuid(), 'OTT', 'Over The Top', TRUE, now()
WHERE NOT EXISTS (SELECT 1 FROM partner WHERE UPPER(name) = 'OTT');

INSERT INTO partner (id, name, description, is_active, created_date)
SELECT gen_random_uuid(), 'IPTV', 'Internet Protocol Television', TRUE, now()
WHERE NOT EXISTS (SELECT 1 FROM partner WHERE UPPER(name) = 'IPTV');

INSERT INTO partner (id, name, description, is_active, created_date)
SELECT gen_random_uuid(), 'ONT', 'Optical Network Terminal', TRUE, now()
WHERE NOT EXISTS (SELECT 1 FROM partner WHERE UPPER(name) = 'ONT');

-- Seed: add missing ANP partner type
INSERT INTO partner (id, name, description, is_active)
SELECT gen_random_uuid(), 'ANP', 'Access Network Provider', TRUE
WHERE NOT EXISTS (SELECT 1 FROM partner WHERE name = 'ANP');
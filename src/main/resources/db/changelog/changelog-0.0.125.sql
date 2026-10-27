INSERT INTO olt_provider (id, name, description, is_active, created_date)
SELECT v.id, v.name, v.description, TRUE, now()
FROM (VALUES
        ('263e19ce-82b0-4f75-9966-27fc57c33129'::uuid, 'BNU', 'BNU'),
        ('03fc64ce-a9b1-4c58-8597-9a7c5880d85c'::uuid, 'ANP', 'Access Network Provider')) AS v(id, name, description)
WHERE NOT EXISTS (SELECT 1 FROM olt_provider o WHERE UPPER(TRIM(o.name)) = v.name OR o.id = v.id);

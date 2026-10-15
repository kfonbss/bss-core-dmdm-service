INSERT INTO gateway (id, code, type, gateid)
SELECT next_ids.id, 'BILLDESK', 'BillDesk', next_ids.gateid
FROM (
  SELECT COALESCE(MAX(id), 0) + 1 AS id, COALESCE(MAX(gateid), 0) + 1 AS gateid FROM gateway
) next_ids
WHERE NOT EXISTS (
  SELECT 1 FROM gateway WHERE UPPER(TRIM(code)) = 'BILLDESK' OR UPPER(TRIM(type)) = 'BILLDESK'
);

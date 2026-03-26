-- Table: partner
DROP TABLE IF EXISTS partner CASCADE;

CREATE TABLE partner (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO partner (id, name, description, is_active) VALUES
  (gen_random_uuid(), 'AGNP', 'Aggregate Network Provider', TRUE),
  (gen_random_uuid(), 'LNP', 'Local Network Provider', TRUE),
  (gen_random_uuid(), 'ISP', 'Internet Service Provider', TRUE),
  (gen_random_uuid(), 'MSP', 'Managed Service Provider', TRUE),
  (gen_random_uuid(), 'PB', 'Playbox', TRUE),
  (gen_random_uuid(), 'Veremax', 'Veremax Technologie Services Limited', TRUE);
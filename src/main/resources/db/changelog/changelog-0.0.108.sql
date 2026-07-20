-- Table: olt_provider
DROP TABLE IF EXISTS olt_provider CASCADE;

CREATE TABLE olt_provider (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO olt_provider (id, name, description, is_active) VALUES
  (gen_random_uuid(), 'LNP', 'Local Network Provider', TRUE),
  (gen_random_uuid(), 'KFON', 'Kerala Fibre Optic Network', TRUE);
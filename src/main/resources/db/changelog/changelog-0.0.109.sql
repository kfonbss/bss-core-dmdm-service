-- Table: partner_category
DROP TABLE IF EXISTS partner_category CASCADE;

CREATE TABLE partner_category (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO partner_category (id, name, description, is_active) VALUES
  (gen_random_uuid(), 'MSE', 'Micro and Small Enterprise', TRUE),
  (gen_random_uuid(), 'SC/ST', 'Scheduled Caste / Scheduled Tribe', TRUE),
  (gen_random_uuid(), 'Women', 'Women owned firm/company', TRUE);
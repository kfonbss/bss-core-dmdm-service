-- Supporting Documents Master Tables
-- document_category: registry of document categories (POA, POI, POS, ...)
-- document_type: master list of all unique document names
-- document_category_mapping: many-to-many junction linking documents to categories

CREATE TABLE document_category (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  category_code VARCHAR(10) NOT NULL UNIQUE,
  category_name VARCHAR(100) NOT NULL,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE document_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  document_name VARCHAR(255) NOT NULL UNIQUE,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE document_category_mapping (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  document_type_id UUID NOT NULL REFERENCES document_type(id),
  category_id UUID NOT NULL REFERENCES document_category(id),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_doc_category_mapping UNIQUE (document_type_id, category_id)
);

CREATE INDEX idx_dcm_category_id ON document_category_mapping(category_id);
CREATE INDEX idx_dcm_document_type_id ON document_category_mapping(document_type_id);

-- Seed: categories
INSERT INTO document_category (category_code, category_name) VALUES
  ('POA', 'Proof of Address'),
  ('POI', 'Proof of Identity');

-- Seed: all unique document types across POA and POI
INSERT INTO document_type (document_name) VALUES
  ('AADHAR Card'),
  ('Election commission ID card'),
  ('Passport'),
  ('Ration card'),
  ('Certificate from Employer of reputed companies on letter head'),
  ('Water bill'),
  ('Telephone bill (BSNL)'),
  ('Electricity bill'),
  ('Driving Licence'),
  ('Statement of running bank account'),
  ('Income Tax Assessment Order'),
  ('Bank Passbook'),
  ('Proof of Gas Connection'),
  ('Registered Rental Agreement'),
  ('PAN Card'),
  ('VOTER Id'),
  ('Company ID');

-- Seed: POA mappings
INSERT INTO document_category_mapping (document_type_id, category_id)
SELECT dt.id, dc.id FROM document_type dt, document_category dc
WHERE dc.category_code = 'POA'
  AND dt.document_name IN (
    'AADHAR Card',
    'Election commission ID card',
    'Passport',
    'Ration card',
    'Certificate from Employer of reputed companies on letter head',
    'Water bill',
    'Telephone bill (BSNL)',
    'Electricity bill',
    'Driving Licence',
    'Statement of running bank account',
    'Income Tax Assessment Order',
    'Bank Passbook',
    'Proof of Gas Connection',
    'Registered Rental Agreement'
  );

-- Seed: POI mappings
INSERT INTO document_category_mapping (document_type_id, category_id)
SELECT dt.id, dc.id FROM document_type dt, document_category dc
WHERE dc.category_code = 'POI'
  AND dt.document_name IN (
    'PAN Card',
    'AADHAR Card',
    'VOTER Id',
    'Company ID',
    'Driving Licence',
    'Passport',
    'Election commission ID card'
  );

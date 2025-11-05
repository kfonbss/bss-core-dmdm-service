DROP TABLE IF EXISTS df_masterdata CASCADE;

CREATE TABLE df_masterdata (
  data_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  district VARCHAR(45) DEFAULT NULL,
  link_type VARCHAR(160) DEFAULT NULL,
  link_type_id VARCHAR(160) DEFAULT NULL,
  link VARCHAR(160) DEFAULT NULL,
  fiber_type VARCHAR(45) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT 0.00,
  noof_strands INTEGER DEFAULT 0,
  noof_strands_consumed INTEGER DEFAULT 0,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_masterdata PRIMARY KEY (data_id)
);

COMMENT ON COLUMN df_masterdata.is_active IS '0=In Active,1=Active';

INSERT INTO df_masterdata (
  data_id, id, district, link_type, link_type_id, link,
  fiber_type, unit_price, noof_strands, noof_strands_consumed,
  code, name, name_in_local,
  is_active, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 'Thiruvananthapuram', 'Backbone', 'LT-001', 'Trivandrum-Kollam Link',
  'Single Mode', 1200.50, 24, 6,
  'MD-001', 'Main Backbone Link', 'പ്രധാന ബാക്ക്ബോൺ ലിങ്ക്',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS df_otccharges CASCADE;

CREATE TABLE df_otccharges (
  charges_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  amount DECIMAL(13,2) DEFAULT 0.00,
  opgw_amount DECIMAL(13,2) DEFAULT 0.00,
  adds_intercity_amount DECIMAL(13,2) DEFAULT 0.00,
  adds_intracity_amount DECIMAL(13,2) DEFAULT 0.00,
  opgw_core_cost DECIMAL(13,2) DEFAULT 0.00,
  opgw_pair_cost DECIMAL(13,2) DEFAULT 0.00,
  adss_core_cost DECIMAL(13,2) DEFAULT 0.00,
  adss_pair_cost DECIMAL(13,2) DEFAULT 0.00,
  otc_amount DECIMAL(13,2) DEFAULT 0.00,
  rack_amount DECIMAL(13,2) DEFAULT NULL,
  year VARCHAR(10) DEFAULT NULL,
  fyear_s_date DATE DEFAULT NULL,
  fyear_e_date DATE DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_otccharges PRIMARY KEY (charges_id)
);

COMMENT ON COLUMN df_otccharges.is_active IS '0=In Active,1=Active';

INSERT INTO df_otccharges (
  charges_id, id, amount, opgw_amount, adds_intercity_amount, adds_intracity_amount,
  opgw_core_cost, opgw_pair_cost, adss_core_cost, adss_pair_cost, otc_amount, rack_amount,
  year, fyear_s_date, fyear_e_date, code, name, name_in_local,
  is_active, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 150000.00, 50000.00, 30000.00, 20000.00,
  2500.00, 5000.00, 2000.00, 4000.00, 25000.00, 15000.00,
  '2025-26', '2025-04-01', '2026-03-31',
  'OTC-001', 'Dark Fiber OTC Charges FY 2025-26', 'കെ-ഫോൺ OTC ചാർജുകൾ 2025-26',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);



DROP TABLE IF EXISTS df_otcinovoice CASCADE;

CREATE TABLE df_otcinovoice (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  subscriberid BIGINT DEFAULT NULL,
  groupid INTEGER DEFAULT NULL,
  mg_invoiceid INTEGER DEFAULT NULL,
  subfinanceid INTEGER DEFAULT NULL,
  billing_type INTEGER DEFAULT NULL,
  invoiceno VARCHAR(64) DEFAULT NULL,
  invoicedate DATE DEFAULT NULL,
  grossamount DECIMAL(26,10) DEFAULT NULL,
  groupmount DECIMAL(26,10) DEFAULT NULL,
  servicetax DECIMAL(10,10) DEFAULT NULL,
  servicetaxrate DECIMAL(10,10) DEFAULT NULL,
  servicestartdate DATE DEFAULT NULL,
  serviceenddate DATE DEFAULT NULL,
  quarter_start_date DATE DEFAULT NULL,
  quarter_end_date DATE DEFAULT NULL,
  gst_value DECIMAL(26,10) DEFAULT NULL,
  cgst_value DECIMAL(26,10) DEFAULT NULL,
  sgst_value DECIMAL(26,10) DEFAULT NULL,
  igst_value DECIMAL(26,10) DEFAULT NULL,
  cgst_rate DECIMAL(26,2) DEFAULT NULL,
  sgst_rate DECIMAL(26,2) DEFAULT NULL,
  igst_rate DECIMAL(26,2) DEFAULT NULL,
  gstin VARCHAR(18) DEFAULT NULL,
  particulars VARCHAR(180) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_otcinovoice PRIMARY KEY (id)
);

COMMENT ON COLUMN df_otcinovoice.is_active IS '0=In Active,1=Active';

INSERT INTO df_otcinovoice (
  id, slno, subscriberid, groupid, mg_invoiceid, subfinanceid, billing_type,
  invoiceno, invoicedate, grossamount, groupmount, servicetax, servicetaxrate,
  servicestartdate, serviceenddate, quarter_start_date, quarter_end_date,
  gst_value, cgst_value, sgst_value, igst_value,
  cgst_rate, sgst_rate, igst_rate, gstin, particulars,
  code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 1001, 201, 501, 301, 1,
  'OTC-INV-2025-001', '2025-10-05', 180000.0000000000, 175000.0000000000, 0.5000000000, 0.0500000000,
  '2025-07-01', '2025-09-30', '2025-07-01', '2025-09-30',
  9000.0000000000, 4500.0000000000, 4500.0000000000, 0.0000000000,
  2.50, 2.50, 0.00, '29ABCDE1234F2Z5',
  'OTC invoice for dark fiber for Q3 FY 2025-26',
  'OTC-INV-001', 'Dark Fiber OTC Invoice', 'ഡാർക്ക് ഫൈബർ OTC ഇൻവോയ്സ്',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);



DROP TABLE IF EXISTS df_payment_history CASCADE;

CREATE TABLE df_payment_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  invoiceid INTEGER DEFAULT NULL,
  utr_number VARCHAR(25) DEFAULT NULL,
  amount DECIMAL(26,10) DEFAULT NULL,
  it_tdsamount DECIMAL(10,2) DEFAULT 0.00,
  gst_tdsamount DECIMAL(10,2) DEFAULT 0.00,
  payment_recipt VARCHAR(150) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_payment_history PRIMARY KEY (history_id)
);

COMMENT ON COLUMN df_payment_history.is_active IS '0=Inactive,1=Active';

INSERT INTO df_payment_history (
  history_id, id, invoiceid, utr_number, amount, it_tdsamount, gst_tdsamount,
  payment_recipt, code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 1001, 'UTR9876543210', 25000.7500000000, 500.00, 250.00,
  'PAYMENT_REC_2025_001.pdf', 'PAY-001', 'Dark Fiber Payment', 'ഡാർക്ക് ഫൈബർ പേയ്മെന്റ്',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

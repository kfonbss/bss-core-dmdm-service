DROP TABLE IF EXISTS demouser_account_request CASCADE;

CREATE TABLE demouser_account_request (
  request_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  partnerid BIGINT NOT NULL,
  activesubscriber INTEGER DEFAULT NULL,
  approve_status SMALLINT DEFAULT 1,
  remarks VARCHAR(250) DEFAULT NULL,
  msp_remarks VARCHAR(250) DEFAULT NULL,
  created_by VARCHAR(30) DEFAULT NULL,
  updated_by VARCHAR(30) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_demouser_account_request PRIMARY KEY (request_id)
);

COMMENT ON COLUMN demouser_account_request.approve_status IS '1=open,2=approve,3=reject';
COMMENT ON COLUMN demouser_account_request.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS demousers CASCADE;

CREATE TABLE demousers (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  userid SERIAL,
  username VARCHAR(64) DEFAULT NULL,
  password VARCHAR(64) DEFAULT NULL,
  packageid VARCHAR(45) DEFAULT NULL,
  start_date TIMESTAMP DEFAULT NULL,
  end_date TIMESTAMP DEFAULT NULL,
  allotted_volume BIGINT DEFAULT NULL,
  demo_remarks VARCHAR(180) DEFAULT NULL,
  cur_speed VARCHAR(45) DEFAULT NULL,
  partnerid BIGINT DEFAULT NULL,
  user_type INTEGER DEFAULT 1,
  is_msp_dc SMALLINT DEFAULT 0,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_demousers PRIMARY KEY (id)
);

COMMENT ON COLUMN demousers.user_type IS '1=Normal Demo user,2=LNP Demo user';
COMMENT ON COLUMN demousers.is_msp_dc IS '0=No,1=Yes';
COMMENT ON COLUMN demousers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS designations CASCADE;

CREATE TABLE designations (
  designations_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  name VARCHAR(20) NOT NULL,
  description VARCHAR(100) NOT NULL,
  bgcolor CHAR(7) NOT NULL DEFAULT '#607D8B',
  CONSTRAINT pk_designations PRIMARY KEY (designations_id)
);


DROP TABLE IF EXISTS df_bank_details CASCADE;

CREATE TABLE df_bank_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  beneficiary_name VARCHAR(200) DEFAULT NULL,
  account_number VARCHAR(100) DEFAULT NULL,
  ifsc_code VARCHAR(100) DEFAULT NULL,
  bank VARCHAR(200) DEFAULT NULL,
  branch VARCHAR(100) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_bank_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN df_bank_details.is_active IS '0=In Active,1=Active';

INSERT INTO df_bank_details (
  details_id, id, beneficiary_name, account_number, ifsc_code, bank, branch,
  code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 'John Doe', '123456789012', 'SBIN0001234', 'State Bank of India', 'MG Road',
  'BD-001', 'Primary Bank Account', 'പ്രൈമറി ബാങ്ക് അക്കൗണ്ട്',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS df_customer_details CASCADE;

CREATE TABLE df_customer_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  customer_name VARCHAR(250) DEFAULT NULL,
  customer_email VARCHAR(156) DEFAULT NULL,
  customer_contact VARCHAR(20) DEFAULT NULL,
  cperson_name VARCHAR(250) DEFAULT NULL,
  cperson_email VARCHAR(156) DEFAULT NULL,
  cperson_contact VARCHAR(20) DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL,
  enq_ref INTEGER DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_customer_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN df_customer_details.is_active IS '0=In Active,1=Active';

INSERT INTO df_customer_details (
  details_id, id, customer_name, customer_email, customer_contact,
  cperson_name, cperson_email, cperson_contact, address, enq_ref,
  code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 'Acme Corp', 'contact@acme.com', '9876543210',
  'Alice Smith', 'alice.smith@acme.com', '9123456780', '123, MG Road, City', 101,
  'CUST-001', 'Acme Customer', 'ആക്‌മെ കസ്റ്റമർ',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS df_demandnote_history CASCADE;

CREATE TABLE df_demandnote_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  cnid INTEGER DEFAULT NULL,
  linkid INTEGER DEFAULT NULL,
  grouplinkid INTEGER DEFAULT NULL,
  groupid INTEGER DEFAULT NULL,
  ss_date DATE DEFAULT NULL,
  se_date DATE DEFAULT NULL,
  total_sdays INTEGER DEFAULT 0,
  unit_price DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  link_gst DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  link_amount DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  link_grand_amount DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  fiber_lenght DECIMAL(13,3) DEFAULT 0.000,
  trands_count INTEGER DEFAULT 0,
  link_type INTEGER DEFAULT NULL,
  feeder_id INTEGER DEFAULT NULL,
  pop_id INTEGER DEFAULT NULL,
  no_of_rack_units INTEGER DEFAULT NULL,
  power_rating_id INTEGER DEFAULT NULL,
  rating_cost_per_30_days DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  total_rating_cost DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  total_rating_gstcost DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  total_power_rating_cost DECIMAL(25,10) NOT NULL DEFAULT 0.0000000000,
  group_type INTEGER DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_demandnote_history PRIMARY KEY (history_id)
);

COMMENT ON COLUMN df_demandnote_history.is_active IS '0=In Active,1=Active';

INSERT INTO df_demandnote_history (
  history_id, id, cnid, linkid, grouplinkid, groupid, ss_date, se_date,
  total_sdays, unit_price, link_gst, link_amount, link_grand_amount,
  fiber_lenght, trands_count, link_type, feeder_id, pop_id, no_of_rack_units,
  power_rating_id, rating_cost_per_30_days, total_rating_cost, total_rating_gstcost,
  total_power_rating_cost, group_type,
  code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 1001, 2001, 3001, 4001, '2025-01-01', '2025-01-31',
  30, 5000.0000000000, 900.0000000000, 5000.0000000000, 5900.0000000000,
  10.500, 2, 1, 101, 201, 5,
  1, 1500.0000000000, 1500.0000000000, 270.0000000000, 1770.0000000000, 1,
  'DNH-001', 'January Demand Note', 'ജനുവരി ഡിമാൻഡ് നോട്ട്',
  TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS df_demandnote_master CASCADE;

CREATE TABLE df_demandnote_master (
  master_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  subscriberid BIGINT DEFAULT NULL,
  groupid INTEGER DEFAULT NULL,
  dnno VARCHAR(64) DEFAULT NULL,
  dndate DATE DEFAULT NULL,
  dngrossamount DECIMAL(26,10) DEFAULT NULL,
  dnamount DECIMAL(26,10) DEFAULT NULL,
  servicetax DECIMAL(10,10) DEFAULT NULL,
  servicetaxrate DECIMAL(10,2) DEFAULT NULL,
  servicestartdate DATE DEFAULT NULL,
  serviceenddate DATE DEFAULT NULL,
  quarter_start_date DATE DEFAULT NULL,
  quarter_end_date DATE DEFAULT NULL,
  gst_value DECIMAL(26,10) DEFAULT NULL,
  cgst_value DECIMAL(26,10) DEFAULT NULL,
  sgst_value DECIMAL(26,10) DEFAULT NULL,
  igst_value DECIMAL(26,10) DEFAULT NULL,
  cgst_rate DECIMAL(26,10) DEFAULT NULL,
  sgst_rate DECIMAL(26,10) DEFAULT NULL,
  igst_rate DECIMAL(26,10) DEFAULT NULL,
  gstin VARCHAR(18) DEFAULT NULL,
  pan VARCHAR(10) DEFAULT NULL,
  taxpayertype SMALLINT DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_df_demandnote_master PRIMARY KEY (master_id)
);

COMMENT ON COLUMN df_demandnote_master.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_disbursement CASCADE;

CREATE TABLE df_disbursement (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  disburseid SERIAL,
  partnergroupid INTEGER DEFAULT NULL,
  groupid INTEGER DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  cause VARCHAR(100) DEFAULT NULL,
  woid INTEGER DEFAULT NULL,
  revenue DECIMAL(26,10) DEFAULT NULL,
  disbursestatusid INTEGER DEFAULT 0,
  subfinanceid INTEGER DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1,
  CONSTRAINT pk_df_disbursement PRIMARY KEY (id)
);

COMMENT ON COLUMN df_disbursement.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_feeder_list CASCADE;

CREATE TABLE df_feeder_list (
  list_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  pop_id INTEGER NOT NULL,
  feeder_name VARCHAR(255) DEFAULT NULL,
  noof_strands_consumed INTEGER DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1,
  CONSTRAINT pk_df_feeder_list PRIMARY KEY (list_id)
);

COMMENT ON COLUMN df_feeder_list.is_active IS '0=In Active,1=Active';



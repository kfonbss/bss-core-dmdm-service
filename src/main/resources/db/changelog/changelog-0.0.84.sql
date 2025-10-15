DROP TABLE IF EXISTS demouser_account_request CASCADE;

CREATE TABLE demouser_account_request (
  request_id UUID PRIMARY KEY NOT NULL,
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
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN demouser_account_request.request_id IS 'Unique identifier for demo user account request records';
COMMENT ON COLUMN demouser_account_request.approve_status IS '1=open,2=approve,3=reject';
COMMENT ON COLUMN demouser_account_request.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS demousers CASCADE;

CREATE TABLE demousers (
  id UUID PRIMARY KEY NOT NULL,
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
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN demousers.id IS 'Unique identifier for demo users records';
COMMENT ON COLUMN demousers.user_type IS '1=Normal Demo user,2=LNP Demo user';
COMMENT ON COLUMN demousers.is_msp_dc IS '0=No,1=Yes';
COMMENT ON COLUMN demousers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS designations CASCADE;

CREATE TABLE designations (
  designations_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  name VARCHAR(20) NOT NULL,
  description VARCHAR(100) NOT NULL,
  bgcolor CHAR(7) NOT NULL DEFAULT '#607D8B'
);

COMMENT ON COLUMN designations.designations_id IS 'Unique identifier for designations records';


DROP TABLE IF EXISTS df_bank_details CASCADE;

CREATE TABLE df_bank_details (
  details_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  beneficiary_name VARCHAR(200) DEFAULT NULL,
  account_number VARCHAR(100) DEFAULT NULL,
  ifsc_code VARCHAR(100) DEFAULT NULL,
  bank VARCHAR(200) DEFAULT NULL,
  branch VARCHAR(100) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_bank_details.details_id IS 'Unique identifier for dark fiber bank details records';
COMMENT ON COLUMN df_bank_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_customer_details CASCADE;

CREATE TABLE df_customer_details (
  details_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  customer_name VARCHAR(250) DEFAULT NULL,
  customer_email VARCHAR(156) DEFAULT NULL,
  customer_contact VARCHAR(20) DEFAULT NULL,
  cperson_name VARCHAR(250) DEFAULT NULL,
  cperson_email VARCHAR(156) DEFAULT NULL,
  cperson_contact VARCHAR(20) DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL,
  enq_ref INTEGER DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1
);

COMMENT ON COLUMN df_customer_details.details_id IS 'Unique identifier for dark fiber customer details records';
COMMENT ON COLUMN df_customer_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_demandnote_history CASCADE;

CREATE TABLE df_demandnote_history (
  history_id UUID PRIMARY KEY NOT NULL,
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
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_demandnote_history.history_id IS 'Unique identifier for dark fiber demand note history records';
COMMENT ON COLUMN df_demandnote_history.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_demandnote_master CASCADE;

CREATE TABLE df_demandnote_master (
  master_id UUID PRIMARY KEY NOT NULL,
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
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_demandnote_master.master_id IS 'Unique identifier for dark fiber demand note master records';
COMMENT ON COLUMN df_demandnote_master.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_disbursement CASCADE;

CREATE TABLE df_disbursement (
  id UUID PRIMARY KEY NOT NULL,
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
  is_active INTEGER DEFAULT 1
);

COMMENT ON COLUMN df_disbursement.id IS 'Unique identifier for dark fiber disbursement records';
COMMENT ON COLUMN df_disbursement.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_feeder_list CASCADE;

CREATE TABLE df_feeder_list (
  list_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  pop_id INTEGER NOT NULL,
  feeder_name VARCHAR(255) DEFAULT NULL,
  noof_strands_consumed INTEGER DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1
);

COMMENT ON COLUMN df_feeder_list.list_id IS 'Unique identifier for dark fiber feeder list records';
COMMENT ON COLUMN df_feeder_list.is_active IS '0=In Active,1=Active';



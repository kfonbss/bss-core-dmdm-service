DROP TABLE IF EXISTS df_masterdata CASCADE;

CREATE TABLE df_masterdata (
  df_masterdata_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  district VARCHAR(45) DEFAULT NULL,
  link_type VARCHAR(160) DEFAULT NULL,
  link_type_id VARCHAR(160) DEFAULT NULL,
  link VARCHAR(160) DEFAULT NULL,
  fiber_type VARCHAR(45) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT 0.00,
  noof_strands INTEGER DEFAULT 0,
  noof_strands_consumed INTEGER DEFAULT 0,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_masterdata.df_masterdata_id IS 'Unique identifier for dark fiber master data records';
COMMENT ON COLUMN df_masterdata.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_otccharges CASCADE;

CREATE TABLE df_otccharges (
  df_otccharges_id UUID PRIMARY KEY NOT NULL,
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
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_otccharges.df_otccharges_id IS 'Unique identifier for dark fiber OTC charges records';
COMMENT ON COLUMN df_otccharges.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_otcinovoice CASCADE;

CREATE TABLE df_otcinovoice (
  df_otcinovoice_id UUID PRIMARY KEY NOT NULL,
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
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_otcinovoice.df_otcinovoice_id IS 'Unique identifier for dark fiber OTC invoice records';
COMMENT ON COLUMN df_otcinovoice.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_payment_history CASCADE;

CREATE TABLE df_payment_history (
  df_payment_history_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  invoiceid INTEGER DEFAULT NULL,
  utr_number VARCHAR(25) DEFAULT NULL,
  amount DECIMAL(26,10) DEFAULT NULL,
  it_tdsamount DECIMAL(10,2) DEFAULT 0.00,
  gst_tdsamount DECIMAL(10,2) DEFAULT 0.00,
  payment_recipt VARCHAR(150) DEFAULT NULL,
  created_by VARCHAR(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN df_payment_history.df_payment_history_id IS 'Unique identifier for dark fiber payment history records';
COMMENT ON COLUMN df_payment_history.is_active IS '0=Inactive,1=Active';
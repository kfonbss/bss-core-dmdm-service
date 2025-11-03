DROP TABLE IF EXISTS df_group_details CASCADE;

CREATE TABLE df_group_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  group_name VARCHAR(250) DEFAULT NULL,
  woid INTEGER DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  balance DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  start_pop VARCHAR(100) DEFAULT NULL,
  end_pop VARCHAR(100) DEFAULT NULL,
  ss_date DATE DEFAULT NULL,
  expiry_date DATE DEFAULT NULL,
  last_recharge_date TIMESTAMP DEFAULT NULL,
  commission_doc VARCHAR(100) DEFAULT NULL,
  approve_status INTEGER DEFAULT 0,
  d_status INTEGER DEFAULT 0,
  d_status_date DATE DEFAULT NULL,
  rechargecount INTEGER DEFAULT 0,
  group_type INTEGER DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_group_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN df_group_details.d_status IS '1=Commissioned,0=Not Commissioned';
COMMENT ON COLUMN df_group_details.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN df_group_details.group_type IS '1=Inter-City, 2=Intra-City, 3=Co-location';

INSERT INTO df_group_details (
  id, group_name, woid, subscriberid, balance, start_pop, end_pop,
  ss_date, expiry_date, last_recharge_date, commission_doc, approve_status,
  d_status, d_status_date, rechargecount, code, name, name_in_local,
  is_active, created_by, modified_by
)
VALUES
(1, 'Trivandrum North Group', 1001, 2001, 1250.75, 'POP-A', 'POP-B',
 '2025-01-10', '2026-01-10', '2025-10-25 10:30:00', 'doc_001.pdf', 1,
 1, '2025-01-15', 3, 'TRV001', 'Trivandrum North', 'തിരുവനന്തപുരം നോർത്ത്',
 TRUE, gen_random_uuid(), gen_random_uuid());

DROP TABLE IF EXISTS df_group_details_movent CASCADE;

CREATE TABLE df_group_details_movent (
  movent_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  groupid INTEGER DEFAULT NULL,
  approve_status INTEGER DEFAULT 0,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_df_group_details_movent PRIMARY KEY (movent_id)
);

COMMENT ON COLUMN df_group_details_movent.approve_status IS '1=Group Created,2=Group Approved';
COMMENT ON COLUMN df_group_details_movent.is_active IS '0=In Active,1=Active';

INSERT INTO df_group_details_movent (
  id, groupid, approve_status, code, name, name_in_local,
  is_active, created_by, modified_by
)
VALUES
(1, 1, 1, 'MOV001', 'Trivandrum Movement', 'തിരുവനന്തപുരം മൂവ്മെന്റ്',
 TRUE, gen_random_uuid(), gen_random_uuid());

DROP TABLE IF EXISTS df_groupinovoice CASCADE;

CREATE TABLE df_groupinovoice (
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
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_df_groupinovoice PRIMARY KEY (id)
);

COMMENT ON COLUMN df_groupinovoice.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_groupinovoice_master CASCADE;

CREATE TABLE df_groupinovoice_master (
  master_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  subscriberid BIGINT DEFAULT NULL,
  groupid INTEGER DEFAULT NULL,
  subfinanceid INTEGER DEFAULT NULL,
  billing_type INTEGER DEFAULT NULL,
  invoiceno VARCHAR(64) DEFAULT NULL,
  invoicedate DATE DEFAULT NULL,
  grossamount DECIMAL(26,10) DEFAULT NULL,
  groupmount DECIMAL(26,10) DEFAULT NULL,
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
  taxpayertype SMALLINT DEFAULT NULL,
  particulars VARCHAR(180) DEFAULT NULL,
  einvoice_generated SMALLINT DEFAULT 0,
  crnote_amount DECIMAL(26,10) DEFAULT 0.0000000000,
  crnote_gst DECIMAL(26,10) DEFAULT 0.0000000000,
  crnote_total DECIMAL(26,10) DEFAULT 0.0000000000,
  paid_amount VARCHAR(10) DEFAULT '0',
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_df_groupinovoice_master PRIMARY KEY (master_id)
);

COMMENT ON COLUMN df_groupinovoice_master.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_link_details CASCADE;

CREATE TABLE df_link_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  woid INTEGER DEFAULT NULL,
  groupid INTEGER DEFAULT NULL,
  linkid INTEGER DEFAULT NULL,
  strands_count INTEGER DEFAULT NULL,
  fiber_type VARCHAR(45) DEFAULT NULL,
  unit_price DECIMAL(13,2) DEFAULT 0.00,
  fiber_lenght DECIMAL(13,3) DEFAULT 0.000,
  pop_id INTEGER DEFAULT NULL,
  feeder_id INTEGER DEFAULT NULL,
  link_type INTEGER DEFAULT NULL,
  no_of_rack_units INTEGER DEFAULT NULL,
  power_rating_id INTEGER DEFAULT NULL,
  power_rating_cost DECIMAL(13,2) DEFAULT NULL,
  approve_status INTEGER DEFAULT 0,
  link_d_status SMALLINT DEFAULT 1,
  link_d_status_date DATE DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_df_link_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN df_link_details.link_d_status IS '1=Commissioned,2=DeCommissioned';
COMMENT ON COLUMN df_link_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS df_link_renewal_history CASCADE;

CREATE TABLE df_link_renewal_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  mg_invoiceid INTEGER DEFAULT NULL,
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
  subfinanceid INTEGER DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_df_link_renewal_history PRIMARY KEY (history_id)
);

COMMENT ON COLUMN df_link_renewal_history.is_active IS '0=In Active,1=Active';



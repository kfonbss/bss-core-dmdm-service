-- Drop tables if they exist
DROP TABLE IF EXISTS reconcile CASCADE;
DROP TABLE IF EXISTS reconcile_details CASCADE;
DROP TABLE IF EXISTS reconcile_temp2 CASCADE;
DROP TABLE IF EXISTS regions CASCADE;
DROP TABLE IF EXISTS remarks CASCADE;
DROP TABLE IF EXISTS residenceprooftype CASCADE;
DROP TABLE IF EXISTS retail_control CASCADE;

-- Table: reconcile
CREATE TABLE reconcile (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  partnerid VARCHAR(20) NOT NULL,
  p_op_balance NUMERIC(10,2) DEFAULT 0.00,
  p_cl_balance NUMERIC(10,2) DEFAULT 0.00,
  p_topup NUMERIC(10,2) DEFAULT 0.00,
  p_revenueshare NUMERIC(10,2) DEFAULT 0.00,
  rev_inc_tax NUMERIC(12,4),
  monthpart VARCHAR(10) NOT NULL,
  s_cl_bal NUMERIC(10,2) DEFAULT 0.00,
  s_op_bal NUMERIC(10,2) DEFAULT 0.00,
  s_inflow NUMERIC(10,2) DEFAULT 0.00,
  s_outflow NUMERIC(10,2) DEFAULT 0.00,
  s_rechargeonly NUMERIC(10,2) DEFAULT 0.00,
  s_disburseonly NUMERIC(10,2) DEFAULT 0.00,
  s_revenuewithtax NUMERIC(12,4),
  p_transfer NUMERIC(10,2),
  state VARCHAR(50),
  isagp VARCHAR(20),
  p_eff_bal NUMERIC(10,2) DEFAULT 0.00,
  revertfromsub NUMERIC(10,2),
  s_reverttopart NUMERIC(10,2),
  transfrompart NUMERIC(10,2),
  transtopart NUMERIC(10,2),
  s_rechargewithtax NUMERIC(10,2),
  p_topup_cash NUMERIC(10,2) DEFAULT 0.00,
  p_topup_cor NUMERIC(10,2) DEFAULT 0.00,
  gst_paid NUMERIC(13,2) DEFAULT 0.00,
  RStopup NUMERIC(13,2),
  ewstopup NUMERIC(13,2),
  RSrevenueshare NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  RSpayment NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  GSTreverted NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_sinflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_soutflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_revenue NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_cl_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_partnertransfer NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_op_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_partnertopup NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  RSrevenueshare_TDSGST NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  shift_balance NUMERIC(13,2) DEFAULT 0.00,
  gst_valet NUMERIC(13,2) DEFAULT 0.00,
  p_ontshare NUMERIC(10,2) DEFAULT 0.00,
  ptnr_reversal NUMERIC(10,2) DEFAULT 0.00
);

-- Table: reconcile_details
CREATE TABLE reconcile_details (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  table_id INT,
  table_name VARCHAR(255),
  cause VARCHAR(255),
  cause_type VARCHAR(255),
  rechargemode INT,
  payment_gateway VARCHAR(50),
  term_plan INT,
  disburse_wallet INT,
  partnerreceipt INT DEFAULT 0,
  revert INT DEFAULT 0,
  is_active INT,
  create_date DATE,
  lastupdate TIMESTAMP,
  remarks TEXT
);

-- Table: reconcile_temp2
CREATE TABLE reconcile_temp2 (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  partnerid VARCHAR(20) NOT NULL,
  p_op_balance NUMERIC(10,2) DEFAULT 0.00,
  p_cl_balance NUMERIC(10,2) DEFAULT 0.00,
  p_topup NUMERIC(10,2) DEFAULT 0.00,
  p_revenueshare NUMERIC(10,2) DEFAULT 0.00,
  rev_inc_tax NUMERIC(12,4),
  monthpart VARCHAR(10) NOT NULL,
  s_cl_bal NUMERIC(10,2) DEFAULT 0.00,
  s_op_bal NUMERIC(10,2) DEFAULT 0.00,
  s_inflow NUMERIC(10,2) DEFAULT 0.00,
  s_outflow NUMERIC(10,2) DEFAULT 0.00,
  s_rechargeonly NUMERIC(10,2) DEFAULT 0.00,
  s_disburseonly NUMERIC(10,2) DEFAULT 0.00,
  s_revenuewithtax NUMERIC(12,4),
  p_transfer NUMERIC(10,2),
  state VARCHAR(50),
  isagp VARCHAR(20),
  p_eff_bal NUMERIC(10,2) DEFAULT 0.00,
  revertfromsub NUMERIC(10,2),
  s_reverttopart NUMERIC(10,2),
  transfrompart NUMERIC(10,2),
  transtopart NUMERIC(10,2),
  s_rechargewithtax NUMERIC(10,2),
  p_topup_cash NUMERIC(10,2) DEFAULT 0.00,
  p_topup_cor NUMERIC(10,2) DEFAULT 0.00,
  gst_paid NUMERIC(13,2) DEFAULT 0.00,
  RStopup NUMERIC(13,2),
  ewstopup NUMERIC(13,2),
  RSrevenueshare NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  RSpayment NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  GSTreverted NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_sinflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_soutflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_revenue NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_cl_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_partnertransfer NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_op_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_partnertopup NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  RSrevenueshare_TDSGST NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  shift_balance NUMERIC(13,2) DEFAULT 0.00,
  gst_valet NUMERIC(13,2) DEFAULT 0.00,
  p_ontshare NUMERIC(10,2) DEFAULT 0.00,
  ptnr_reversal NUMERIC(10,2) DEFAULT 0.00
);

-- Table: regions
CREATE TABLE regions (
  id UUID NOT NULL PRIMARY KEY,
  region_id SERIAL ,
  state_code VARCHAR(5),
  state_name VARCHAR(128),
  name VARCHAR(128),
  region VARCHAR(50),
  status INT DEFAULT 1 NOT NULL
);

-- Table: remarks
CREATE TABLE remarks (
  remarks_id UUID NOT NULL PRIMARY KEY,
  id SERIAL ,
  remarks VARCHAR(4000),
  ticketid VARCHAR(50),
  ticketno VARCHAR(50),
  "user" VARCHAR(25),
  posted_time TIMESTAMP,
  issuetype VARCHAR(50),
  status VARCHAR(50)
);
CREATE INDEX remticket ON remarks(ticketid);

-- Table: residenceprooftype
CREATE TABLE residenceprooftype (
  id UUID NOT NULL PRIMARY KEY,
  residenceprooftypeid SERIAL ,
  residenceprooftype VARCHAR(45) NOT NULL UNIQUE,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: retail_control
CREATE TABLE retail_control (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  ptr NUMERIC(10,2),
  sinflow NUMERIC(10,2),
  ptrdiff NUMERIC(10,2),
  revshare NUMERIC(10,2),
  paid_amount NUMERIC(10,2),
  sharediff NUMERIC(10,2),
  subopbal NUMERIC(10,2),
  popbal NUMERIC(10,2),
  subclbal NUMERIC(10,2),
  pclbal NUMERIC(10,2),
  sclbal_fin NUMERIC(10,2),
  pclbal_fin NUMERIC(10,2),
  sbaldiff NUMERIC(10,2),
  pbaldiff NUMERIC(10,2),
  recharge NUMERIC(10,2),
  revenue NUMERIC(10,2),
  rechdiff NUMERIC(10,2),
  gstdiff NUMERIC(10,2),
  revfromsub NUMERIC(10,2),
  revtopart NUMERIC(10,2),
  subclbal_prev NUMERIC(10,2),
  pclbalprev NUMERIC(10,2),
  monthpart VARCHAR(50),
  disbrevdiff NUMERIC(10,2),
  remarks VARCHAR(100),
  updatedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

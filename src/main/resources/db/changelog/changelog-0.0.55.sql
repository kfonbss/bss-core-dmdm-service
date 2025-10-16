-- Drop tables if they exist
DROP TABLE IF EXISTS retail_workorder CASCADE;
DROP TABLE IF EXISTS retail_workorderfinance CASCADE;
DROP TABLE IF EXISTS rev_sub CASCADE;
DROP TABLE IF EXISTS rev_sub_prev CASCADE;
DROP TABLE IF EXISTS rev_sub_temp CASCADE;
DROP TABLE IF EXISTS revenue_check CASCADE;
DROP TABLE IF EXISTS revenue_control CASCADE;
DROP TABLE IF EXISTS revenue_control_partner CASCADE;
DROP TABLE IF EXISTS revenueshare CASCADE;

-- Table: retail_workorder
CREATE TABLE retail_workorder (
  id UUID NOT NULL PRIMARY KEY,
  wid SERIAL ,
  wono VARCHAR(50),
  cus_count INTEGER DEFAULT 0,
  packageid INTEGER DEFAULT 0,
  validity INTEGER DEFAULT 0,
  service_sdate DATE,
  service_edate DATE,
  current_status VARCHAR(50),
  next_status VARCHAR(50),
  remarks VARCHAR(200),
  balance NUMERIC(10,2),
  createdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: retail_workorderfinance
CREATE TABLE retail_workorderfinance (
  id UUID NOT NULL PRIMARY KEY,
  wfinid SERIAL ,
  wono VARCHAR(50),
  partnerid BIGINT,
  subscriberid BIGINT,
  amount NUMERIC(10,2),
  cause VARCHAR(100),
  createdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: rev_sub
CREATE TABLE rev_sub (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  s_cl_bal NUMERIC(10,2) DEFAULT 0.00,
  s_op_bal NUMERIC(10,2) DEFAULT 0.00,
  s_inflow NUMERIC(10,2) DEFAULT 0.00,
  s_outflow NUMERIC(10,2) DEFAULT 0.00,
  s_rechargeonly NUMERIC(10,2) DEFAULT 0.00,
  s_revenuewithtax NUMERIC(12,4) DEFAULT 0.0000,
  partnerid BIGINT DEFAULT 0,
  monthpart VARCHAR(15),
  s_disburseonly NUMERIC(10,2) DEFAULT 0.00,
  subscriberid INTEGER,
  reverttopart NUMERIC(10,2) DEFAULT 0.00,
  rechargewithtax NUMERIC(10,2) DEFAULT 0.00,
  rs_sinflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_soutflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_revenue NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_cl_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_op_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  shift_balance NUMERIC(13,2) DEFAULT 0.00
);

-- Table: rev_sub_prev
CREATE TABLE rev_sub_prev (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  subscriberid INTEGER,
  s_cl_bal NUMERIC(10,2) DEFAULT 0.00,
  monthpart VARCHAR(15),
  rs_s_op_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_cl_bal NUMERIC(13,2) DEFAULT 0.00,
  CONSTRAINT idx_rev_sub_prev_subscriberid UNIQUE (subscriberid)
);

-- Table: rev_sub_temp
CREATE TABLE rev_sub_temp (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  monthpart VARCHAR(15),
  subscriberid INTEGER,
  partnerid VARCHAR(20),
  s_op_bal NUMERIC(10,2) DEFAULT 0.00,
  s_inflow NUMERIC(10,2) DEFAULT 0.00,
  s_rechargewithtax NUMERIC(10,2) DEFAULT 0.00,
  reverttopart NUMERIC(10,2) DEFAULT 0.00,
  s_cl_bal NUMERIC(10,2) DEFAULT 0.00,
  s_revenuewithtax NUMERIC(10,2) DEFAULT 0.00,
  rs_sinflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_soutflow NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_revenue NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_cl_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  rs_s_op_bal NUMERIC(13,2) DEFAULT 0.00 NOT NULL,
  shift_balance NUMERIC(13,2) DEFAULT 0.00,
  remarks VARCHAR(50),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_rev_sub_temp_subscriberid ON rev_sub_temp(subscriberid);

-- Table: revenue_check
CREATE TABLE revenue_check (
  id UUID NOT NULL PRIMARY KEY,
  monthpart VARCHAR(10),
  revenue NUMERIC(15,2) DEFAULT 0.00,
  invoice_amt NUMERIC(15,2) DEFAULT 0.00,
  sub_outflow NUMERIC(10,2),
  rev_inv_diff NUMERIC(10,2) DEFAULT 0.00,
  sub_fin_inamt NUMERIC(12,2) DEFAULT 0.00,
  sfin_inv_diff NUMERIC(10,2) DEFAULT 0.00,
  ptr_transfer NUMERIC(15,2) DEFAULT 0.00,
  sub_inflow NUMERIC(15,2) DEFAULT 0.00,
  ptr_diff NUMERIC(10,2) DEFAULT 0.00,
  ptopup NUMERIC(15,2) DEFAULT 0.00,
  p_reciept NUMERIC(15,2) DEFAULT 0.00,
  ptopup_diff NUMERIC(10,2) DEFAULT 0.00,
  remarks VARCHAR(100),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  lastupdate TIMESTAMP
);

-- Table: revenue_control
CREATE TABLE revenue_control (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  partnerid VARCHAR(20) NOT NULL,
  p_op_balance NUMERIC(10,2) NOT NULL,
  p_cl_balance NUMERIC(10,2) NOT NULL,
  p_topup NUMERIC(10,2) NOT NULL,
  p_revenueshare NUMERIC(10,2) NOT NULL,
  revenue NUMERIC(10,2) NOT NULL,
  s_op_balance NUMERIC(10,2) NOT NULL,
  s_cl_balance NUMERIC(10,2) NOT NULL,
  s_topup NUMERIC(10,2) NOT NULL,
  monthpart VARCHAR(10) NOT NULL,
  rev_inc_tax NUMERIC(10,2) NOT NULL
);

-- Table: revenue_control_partner
CREATE TABLE revenue_control_partner (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  partnerid VARCHAR(20) NOT NULL,
  p_op_balance NUMERIC(10,2) NOT NULL,
  p_cl_balance NUMERIC(10,2) NOT NULL,
  p_topup NUMERIC(10,2) NOT NULL,
  p_revenueshare NUMERIC(10,2) NOT NULL,
  revenue NUMERIC(10,2) NOT NULL,
  rev_inc_tax NUMERIC(10,2) NOT NULL,
  monthpart VARCHAR(10) NOT NULL,
  state VARCHAR(10) NOT NULL,
  isagp VARCHAR(5)
);

-- Table: revenueshare
CREATE TABLE revenueshare (
  id UUID NOT NULL PRIMARY KEY,
  revenueshareid SERIAL ,
  sharename VARCHAR(1000),
  subgroup INT DEFAULT 0,
  ibnpshare NUMERIC(5,2) DEFAULT 30.00 NOT NULL,
  ibwpshare NUMERIC(5,2) DEFAULT 0.00 NOT NULL,
  anpshare NUMERIC(5,2) DEFAULT 10.00 NOT NULL,
  agpshare NUMERIC(5,2) DEFAULT 7.00 NOT NULL,
  cnpshare NUMERIC(5,2) DEFAULT 3.00 NOT NULL,
  mspshare NUMERIC(5,2) DEFAULT 15.00 NOT NULL,
  mktshare NUMERIC(5,2) DEFAULT 5.00 NOT NULL,
  ispshare NUMERIC(5,2) DEFAULT 30.00 NOT NULL,
  permshare NUMERIC(10,2) DEFAULT 0.00 NOT NULL,
  dotshare NUMERIC(10,2) DEFAULT 4.00 NOT NULL,
  provshare NUMERIC(10,2) DEFAULT 0.00,
  state VARCHAR(64),
  prs NUMERIC(10,2) DEFAULT 0.00,
  isactive INT,
  CONSTRAINT uq_revenueshare_sharename UNIQUE (sharename),
  CONSTRAINT uq_revenueshare_composite UNIQUE (
    sharename, ibnpshare, ibwpshare, anpshare, agpshare, cnpshare,
    mspshare, mktshare, ispshare, permshare
  )
);

-- Drop existing tables if they exist
DROP TABLE IF EXISTS school_project CASCADE;
DROP TABLE IF EXISTS se_customers CASCADE;
DROP TABLE IF EXISTS se_disbursement CASCADE;
DROP TABLE IF EXISTS se_inovoice CASCADE;
DROP TABLE IF EXISTS se_inovoice_master CASCADE;
DROP TABLE IF EXISTS se_kyc_details CASCADE;

-- Table: school_project
CREATE TABLE school_project (
  project_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL ,
  username VARCHAR(60),
  workorderid VARCHAR(60)
);

-- Table: se_customers
CREATE TABLE se_customers (
  customer_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL ,
  company_name VARCHAR(100),
  short_name VARCHAR(50),
  contact_person VARCHAR(50),
  mobile VARCHAR(12),
  email VARCHAR(50),
  address VARCHAR(250),
  pincode VARCHAR(6),
  description VARCHAR(250),
  kyc_added INt DEFAULT 0,  -- 0=Not Added, 1=Added
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INt DEFAULT 1   -- 0=Inactive, 1=Active
);

-- Table: se_disbursement
CREATE TABLE se_disbursement (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  disburseid SERIAL ,
  locid INTEGER,
  cause VARCHAR(100),
  revenue NUMERIC(26,10),
  disbursestatusid INTEGER DEFAULT 1,
  finrefid INTEGER,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1    -- 0=Inactive, 1=Active
);

-- Table: se_inovoice
CREATE TABLE se_inovoice (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  slno BIGSERIAL ,
  locid INTEGER,
  custid INTEGER,
  finrefid INTEGER,
  invoiceno VARCHAR(64),
  invoicedate DATE,
  grossamount NUMERIC(26,10),
  locamount NUMERIC(26,10),
  servicetax NUMERIC(10,10),
  servicestartdate DATE,
  serviceenddate DATE,
  gst_value NUMERIC(26,10),
  cgst_value NUMERIC(26,10),
  sgst_value NUMERIC(26,10),
  igst_value NUMERIC(26,10),
  cgst_rate NUMERIC(26,10),
  sgst_rate NUMERIC(26,10),
  igst_rate NUMERIC(26,10),
  gstin VARCHAR(18),
  particulars VARCHAR(180),
  mg_invoiceid INTEGER,
  inv_type INt DEFAULT 1,  -- 1=Normal Invoice, 2=OTC Invoice
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INt DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: se_inovoice_master
CREATE TABLE se_inovoice_master (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  slno BIGSERIAL ,
  locid INTEGER,
  custid INTEGER,
  finrefid INTEGER,
  invoiceno VARCHAR(64),
  invoicedate DATE,
  grossamount NUMERIC(26,10),
  locamount NUMERIC(26,10),
  servicetax NUMERIC(10,10),
  servicestartdate DATE,
  serviceenddate DATE,
  gst_value NUMERIC(26,10),
  cgst_value NUMERIC(26,10),
  sgst_value NUMERIC(26,10),
  igst_value NUMERIC(26,10),
  cgst_rate NUMERIC(26,10),
  sgst_rate NUMERIC(26,10),
  igst_rate NUMERIC(26,10),
  paid_amount NUMERIC(26,10) DEFAULT 0.0000000000,
  gstin VARCHAR(18),
  taxpayertype INt,
  einvoice_generated INt DEFAULT 0,
  crnote_amount NUMERIC(26,10) DEFAULT 0.0000000000,
  crnote_gst NUMERIC(26,10) DEFAULT 0.0000000000,
  crnote_total NUMERIC(26,10) DEFAULT 0.0000000000,
  particulars VARCHAR(180),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INt DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: se_kyc_details
CREATE TABLE se_kyc_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL ,
  customerid INTEGER,
  pan_numer VARCHAR(10),
  pan_copy VARCHAR(100),
  gstin VARCHAR(15),
  gstindoc VARCHAR(100),
  taxpayertype INt,
  legalname VARCHAR(250),
  tradename VARCHAR(250),
  sac VARCHAR(20),
  service_description VARCHAR(150),
  gst_status INt DEFAULT 0,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1  -- 0=Inactive, 1=Active
);

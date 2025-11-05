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
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
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
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);
INSERT INTO se_customers (
    customer_id, code, name, name_in_local, is_active, id, company_name, short_name, contact_person,
    mobile, email, address, pincode, description, kyc_added, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'CUST001', 'ABC Technologies Pvt Ltd', 'എബി‌സി ടെക്നോളജീസ് പ്രൈവറ്റ് ലിമിറ്റഡ്', true, 1,
    'ABC Technologies Pvt Ltd', 'ABC Tech', 'John Mathew', '9876543210', 'info@abctech.com',
    '123, Tech Park, Kochi, Kerala', '682030', 'Leading IT service provider', 1,
    CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);

-- Table: se_disbursement
CREATE TABLE se_disbursement (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  disburseid SERIAL ,
  locid INTEGER,
  cause VARCHAR(100),
  revenue NUMERIC(26,10),
  disbursestatusid INTEGER DEFAULT 1,
  finrefid INTEGER,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);
INSERT INTO se_disbursement (
    id, code, name, name_in_local, is_active, disburseid, locid, cause,
    revenue, disbursestatusid, finrefid, created_date, modified_date,
    created_by, modified_by
) VALUES (
    gen_random_uuid(), 'DISB001', 'Revenue Disbursement Q1', 'വരുമാന വിതരണം Q1',
    true, 1, 101, 'Quarterly partner revenue settlement',
    150000.7500000000, 1, 501, CURRENT_TIMESTAMP, NULL,
    gen_random_uuid(), gen_random_uuid()
);

-- Table: se_inovoice
CREATE TABLE se_inovoice (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  slno BIGSERIAL ,
  locid INTEGER,
  custid INTEGER,
  finrefid INTEGER,
  invoiceno VARCHAR(64),
  invoicedate DATE,
  grossamount NUMERIC(26,10),
  locamount NUMERIC(26,10),
  servicetax NUMERIC(26,10),
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
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);
INSERT INTO se_inovoice (
    id, code, name, name_in_local, is_active, slno, locid, custid, finrefid,
    invoiceno, invoicedate, grossamount, locamount, servicetax,
    servicestartdate, serviceenddate, gst_value, cgst_value, sgst_value,
    igst_value, cgst_rate, sgst_rate, igst_rate, gstin, particulars,
    mg_invoiceid, inv_type, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'INV001', 'Service Invoice Q1', 'സർവീസ് ഇൻവോയ്സ് Q1', true, 1, 1001, 5001, 3001,
    'INV-2025-001', CURRENT_DATE, 150000.0000000000, 145000.0000000000, 5000.0000000000,
    '2025-01-01', '2025-03-31', 27000.0000000000, 13500.0000000000, 13500.0000000000,
    0.0000000000, 9.0000000000, 9.0000000000, 0.0000000000, '32ABCDE1234F1Z5',
    'Quarterly service billing for Jan–Mar 2025', 8001, 1, CURRENT_TIMESTAMP, NULL,
    gen_random_uuid(), gen_random_uuid()
);

-- Table: se_inovoice_master
CREATE TABLE se_inovoice_master (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  slno BIGSERIAL ,
  locid INTEGER,
  custid INTEGER,
  finrefid INTEGER,
  invoiceno VARCHAR(64),
  invoicedate DATE,
  grossamount NUMERIC(26,10),
  locamount NUMERIC(26,10),
  servicetax NUMERIC(26,10),
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
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);
INSERT INTO se_inovoice_master (
    id, code, name, name_in_local, is_active, slno, locid, custid, finrefid,
    invoiceno, invoicedate, grossamount, locamount, servicetax, servicestartdate, serviceenddate,
    gst_value, cgst_value, sgst_value, igst_value, cgst_rate, sgst_rate, igst_rate,
    paid_amount, gstin, taxpayertype, einvoice_generated, crnote_amount, crnote_gst, crnote_total,
    particulars, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'INV-M001', 'Invoice Master April', 'ഇൻവോയ്സ് മാസ്റ്റർ ഏപ്രിൽ', true, 1, 101, 501, 301,
    'INV-M-2025-001', '2025-04-10', 250000.0000000000, 245000.0000000000, 5000.0000000000,
    '2025-04-01', '2025-04-30', 45000.0000000000, 22500.0000000000, 22500.0000000000, 0.0000000000,
    9.0000000000, 9.0000000000, 0.0000000000, 100000.0000000000, '32ABCDE1234F1Z5', 1, 0,
    2000.0000000000, 360.0000000000, 2360.0000000000, 'Monthly invoice for April 2025',
    CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);

-- Table: se_kyc_details
CREATE TABLE se_kyc_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
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
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);
INSERT INTO se_kyc_details (
  details_id, code, name, name_in_local, is_active, id, customerid, pan_numer, pan_copy, gstin, gstindoc,
  taxpayertype, legalname, tradename, sac, service_description, gst_status, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'KYC001', 'KYC Details for Customer 1', 'കസ്റ്റമർ 1 ന്റെ KYC വിശദാംശങ്ങൾ', true, 1, 1001, 'ABCDE1234F', 'pan_doc_1001.pdf',
  '32ABCDE1234F1Z5', 'gst_doc_1001.pdf', 1, 'Legal Entity Pvt Ltd', 'Trade Name Ltd', '9983', 'IT and Network Services',
  1, CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);

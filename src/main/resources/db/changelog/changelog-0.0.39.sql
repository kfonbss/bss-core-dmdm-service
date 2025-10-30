DROP TABLE IF EXISTS ce_disbursement_history CASCADE;

CREATE TABLE ce_disbursement_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  type boolean DEFAULT true,
  disbid int DEFAULT NULL,
  partnergroupid int DEFAULT NULL,
  subscriberid int NOT NULL,
  locid int NOT NULL,
  packageid int DEFAULT NULL,
  cause varchar(30) DEFAULT NULL,
  servicestartdate timestamp DEFAULT NULL,
  serviceenddate timestamp DEFAULT NULL,
  revenue decimal(26,10) DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  revenueshareid int DEFAULT NULL,
  disbursestatusid boolean DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_disbursement_history PRIMARY KEY (history_id)
);

INSERT INTO ce_disbursement_history (history_id, code,name, name_in_local, is_active, type, disbid, partnergroupid, subscriberid, locid, packageid, cause, servicestartdate, serviceenddate, revenue, subfinanceid, revenueshareid, disbursestatusid, created_by, modified_by)
VALUES (gen_random_uuid(), 'HA001','Subscriber Revenue Distribution History', 'സബ്സ്ക്രൈബർ വരുമാന വിതരണം ചരിത്രം', TRUE, TRUE, 1001, 201, 5002, 305, 450, 'Monthly revenue distribution', '2025-09-01 00:00:00', '2025-09-30 23:59:59', 15890.7500000000, 1201, 2201, TRUE, gen_random_uuid(), gen_random_uuid());

DROP TABLE IF EXISTS ce_dnote_master CASCADE;

CREATE TABLE ce_dnote_master (
  master_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  slno BIGSERIAL,
  subscriberid bigint DEFAULT NULL,
  locid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  notenumber varchar(64) DEFAULT NULL,
  notemonth varchar(20) DEFAULT NULL,
  notedate date DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  locamount decimal(26,10) DEFAULT NULL,
  servicetax decimal(26,10) DEFAULT NULL,
  servicetaxrate decimal(10,2) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  quarter_start_date date DEFAULT NULL,
  quarter_end_date date DEFAULT NULL,
  gst_value decimal(26,10) DEFAULT NULL,
  cgst_value decimal(26,10) DEFAULT NULL,
  sgst_value decimal(26,10) DEFAULT NULL,
  igst_value decimal(26,10) DEFAULT NULL,
  cgst_rate decimal(26,10) DEFAULT NULL,
  sgst_rate decimal(26,10) DEFAULT NULL,
  igst_rate decimal(26,10) DEFAULT NULL,
  paid_amount decimal(26,10) DEFAULT 0.0000000000,
  gstin varchar(18) DEFAULT NULL,
  taxpayertype smallint DEFAULT NULL,
  particulars varchar(180) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_dnote_master PRIMARY KEY (master_id)
);

INSERT INTO ce_dnote_master (master_id, code, name, name_in_local, is_active, subscriberid, locid, subfinanceid, notenumber, notemonth, notedate, grossamount, locamount, servicetax, servicetaxrate, servicestartdate, serviceenddate, quarter_start_date, quarter_end_date, gst_value, cgst_value, sgst_value, igst_value, cgst_rate, sgst_rate, igst_rate, paid_amount, gstin, taxpayertype, particulars, created_by, modified_by)
VALUES (gen_random_uuid(), 'MA001', 'Quarterly Disbursement Note', 'ത്രൈമാസ വിതരണ കുറിപ്പ്', TRUE, 5501, 305, 1201, 'DN-2025-10-001', 'October-2025', '2025-10-15', 25000.7500000000, 24000.5000000000, 500.0000000000, 2.00, '2025-07-01', '2025-09-30', '2025-07-01', '2025-09-30', 4500.0, 2250.0000000000, 2250.0, 0.00, 9.000, 9.0000, 0.00, 20000.000, '32ABCDE1234F1Z5', 1, 'Disbursement note for Q3 FY2025 subscribers', gen_random_uuid(), gen_random_uuid());


DROP TABLE IF EXISTS ce_dnote_renewal_history CASCADE;

CREATE TABLE ce_dnote_renewal_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  locid int DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  breakupid int DEFAULT NULL,
  serviceid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  mg_invoiceid int DEFAULT NULL,
  service_sdate date DEFAULT NULL,
  service_edate date DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  total_sdays int DEFAULT 0,
  discount_percent int DEFAULT 0,
  disount_amount decimal(26,10) DEFAULT NULL,
  original_renewalfee decimal(26,10) DEFAULT NULL,
  renewalfee_after_disount decimal(26,10) DEFAULT NULL,
  cost_per_day decimal(26,10) DEFAULT NULL,
  loc_amount decimal(26,10) DEFAULT NULL,
  loc_gst_amount decimal(26,10) DEFAULT NULL,
  loc_grand_amount decimal(26,10) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_dnote_renewal_history PRIMARY KEY (history_id)
);

INSERT INTO ce_dnote_renewal_history (history_id, code, name, name_in_local, is_active, locid, subscriberid, breakupid, serviceid, packageid, mg_invoiceid, service_sdate, service_edate, subfinanceid, total_sdays, discount_percent, disount_amount, original_renewalfee, renewalfee_after_disount, cost_per_day, loc_amount, loc_gst_amount, loc_grand_amount, created_by, modified_by)
VALUES (gen_random_uuid(),'HS001', 'Renewal Entry - October 2025', 'പുതുക്കൽ രേഖ - ഒക്ടോബർ 2025', TRUE, 305, 5501, 1001, 2001, 3001, 4001, '2025-10-01', '2026-09-30', 1201, 365, 10, 150.0000000000, 1500.0000000000, 1350.0000000000, 4.0000000000, 1350.0000000000, 243.0000000000, 1593.0000000000, gen_random_uuid(), gen_random_uuid());



DROP TABLE IF EXISTS ce_eodetails CASCADE;

CREATE TABLE ce_eodetails (
  eodetails_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  locid int DEFAULT NULL,
  subid int DEFAULT NULL,
  contact_person_name varchar(50) DEFAULT NULL,
  mobileno varchar(10) DEFAULT NULL,
  land_line_number varchar(10) DEFAULT NULL,
  emailid varchar(50) DEFAULT NULL,
  customer_address varchar(250) DEFAULT NULL,
  installation_address varchar(250) DEFAULT NULL,
  commission_date date DEFAULT NULL,
  commission_doc varchar(250) DEFAULT NULL,
  created_by_platform varchar(50) DEFAULT NULL,
  end_office_name varchar(100) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_eodetails PRIMARY KEY (eodetails_id)
);
INSERT INTO ce_eodetails (eodetails_id,code,name, name_in_local, is_active, locid, subid, contact_person_name, mobileno, land_line_number, emailid, customer_address, installation_address, commission_date, commission_doc, created_by_platform, end_office_name, created_by, modified_by)
VALUES (gen_random_uuid(), 'EO001','End Office Fiber Installation', 'എൻഡ് ഓഫീസ് ഫൈബർ ഇൻസ്റ്റലേഷൻ', TRUE, 305, 5501, 'Rajesh Kumar', '9876543210', '0484222334', 'rajesh.kumar@example.com', '123 MG Road, Kochi, Kerala', '456 Installation Site, Kakkanad, Kochi', '2025-10-01', 'commission_doc_2025.pdf', 'WebPortal', 'Kochi Main End Office', gen_random_uuid(), gen_random_uuid());

DROP TABLE IF EXISTS ce_inovoice CASCADE;

CREATE TABLE ce_inovoice (
  inovoice_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  slno BIGSERIAL,
  subscriberid bigint DEFAULT NULL,
  locid int DEFAULT NULL,
  mg_invoiceid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  invoiceno varchar(64) DEFAULT NULL,
  invoicedate date DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  locamount decimal(26,10) DEFAULT NULL,
  servicetax decimal(26,10) DEFAULT NULL,
  servicetaxrate decimal(26,10) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  quarter_start_date date DEFAULT NULL,
  quarter_end_date date DEFAULT NULL,
  gst_value decimal(26,10) DEFAULT NULL,
  cgst_value decimal(26,10) DEFAULT NULL,
  sgst_value decimal(26,10) DEFAULT NULL,
  igst_value decimal(26,10) DEFAULT NULL,
  cgst_rate decimal(26,2) DEFAULT NULL,
  sgst_rate decimal(26,2) DEFAULT NULL,
  igst_rate decimal(26,2) DEFAULT NULL,
  gstin varchar(18) DEFAULT NULL,
  particulars varchar(180) DEFAULT NULL,
  packageid int DEFAULT NULL,
  enable_opay boolean DEFAULT false,
  status_opay boolean DEFAULT false,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  taxpayertype smallint DEFAULT NULL,
  loc_reccount int DEFAULT 0,
  CONSTRAINT pk_ce_inovoice PRIMARY KEY (inovoice_id)
);

INSERT INTO ce_inovoice (inovoice_id, code, name, name_in_local, is_active, subscriberid, locid, mg_invoiceid, subfinanceid, invoiceno, invoicedate, grossamount, locamount, servicetax, servicetaxrate, servicestartdate, serviceenddate, quarter_start_date, quarter_end_date, gst_value, cgst_value, sgst_value, igst_value, cgst_rate, sgst_rate, igst_rate, gstin, particulars, packageid, enable_opay, status_opay, created_by, modified_by, taxpayertype, loc_reccount)
VALUES (gen_random_uuid(), 'INV001', 'Test Invoice', 'ടെസ്റ്റ് ഇൻവോയ്സ്', true, 1001, 12, 501, 201, 'INV-2025-001', CURRENT_DATE, 5000.00, 4500.00, 250.00, 5.00, CURRENT_DATE - INTERVAL '30 days', CURRENT_DATE, CURRENT_DATE - INTERVAL '90 days', CURRENT_DATE, 900.00, 450.00, 450.00, 0.00, 9.00, 9.00, 0.00, '32AAAAA0000A1Z5', 'Monthly broadband service', 1, false, false, gen_random_uuid(), gen_random_uuid(), 1, 10);

DROP TABLE IF EXISTS ce_inovoice_master CASCADE;

CREATE TABLE ce_inovoice_master (
  master_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  slno BIGSERIAL,
  subscriberid bigint DEFAULT NULL,
  locid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  invoiceno varchar(64) DEFAULT NULL,
  invoicemonth varchar(20) DEFAULT NULL,
  invoicedate date DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  locamount decimal(26,10) DEFAULT NULL,
  servicetax decimal(26,10) DEFAULT NULL,
  servicetaxrate decimal(26,2) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  quarter_start_date date DEFAULT NULL,
  quarter_end_date date DEFAULT NULL,
  gst_value decimal(26,10) DEFAULT NULL,
  cgst_value decimal(26,10) DEFAULT NULL,
  sgst_value decimal(26,10) DEFAULT NULL,
  igst_value decimal(26,10) DEFAULT NULL,
  cgst_rate decimal(26,10) DEFAULT NULL,
  sgst_rate decimal(26,10) DEFAULT NULL,
  igst_rate decimal(26,10) DEFAULT NULL,
  paid_amount decimal(26,10) DEFAULT 0.0000000000,
  gstin varchar(18) DEFAULT NULL,
  taxpayertype smallint DEFAULT NULL,
  particulars varchar(180) DEFAULT NULL,
  einvoice_generated boolean DEFAULT false,
  crnote_amount decimal(26,10) DEFAULT 0.0000000000,
  crnote_gst decimal(26,10) DEFAULT 0.0000000000,
  crnote_total decimal(26,10) DEFAULT 0.0000000000,
  poid int DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_inovoice_master PRIMARY KEY (master_id)
);
INSERT INTO ce_inovoice_master (master_id, code, name, name_in_local, is_active, subscriberid, locid, subfinanceid, invoiceno, invoicemonth, invoicedate, grossamount, locamount, servicetax, servicetaxrate, servicestartdate, serviceenddate, quarter_start_date, quarter_end_date, gst_value, cgst_value, sgst_value, igst_value, cgst_rate, sgst_rate, igst_rate, paid_amount, gstin, taxpayertype, particulars, einvoice_generated, crnote_amount, crnote_gst, crnote_total, poid, created_by, modified_by)
VALUES (gen_random_uuid(), 'INV-M001', 'Broadband October Invoice', 'ബ്രോഡ്ബാൻഡ് ഒക്ടോബർ ഇൻവോയ്സ്', true, 12001, 15, 300, 'INV-2025-10-001', 'OCT-2025', CURRENT_DATE, 7500.00, 7000.00, 375.00, 5.00, CURRENT_DATE - INTERVAL '30 days', CURRENT_DATE, CURRENT_DATE - INTERVAL '90 days', CURRENT_DATE, 1350.00, 675.00, 675.00, 0.00, 9.00, 9.00, 0.00, 7500.00, '32AAAAA0000A1Z5', 1, 'Monthly broadband and maintenance service', false, 0.00, 0.00, 0.00, 101, gen_random_uuid(), gen_random_uuid());



DROP TABLE IF EXISTS ce_kyc_details CASCADE;

CREATE TABLE ce_kyc_details (
  kyc_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  customerid int DEFAULT NULL,
  pan_numer varchar(10) DEFAULT NULL,
  pan_copy varchar(100) DEFAULT NULL,
  gstin varchar(15) DEFAULT NULL,
  gstindoc varchar(100) DEFAULT NULL,
  supportdoc varchar(100) DEFAULT NULL,
  taxpayertype boolean DEFAULT NULL,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_status boolean DEFAULT false,
  lut_doc varchar(200) DEFAULT NULL,
  sez_verified boolean DEFAULT false,
  approve_status boolean DEFAULT false,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_kyc_details PRIMARY KEY (kyc_id)
);
INSERT INTO ce_kyc_details (kyc_id, code, name, name_in_local, is_active, customerid, pan_numer, pan_copy, gstin, gstindoc, supportdoc, taxpayertype, legalname, tradename, sac, service_description, gst_status, lut_doc, sez_verified, approve_status, created_by, modified_by)
VALUES (gen_random_uuid(), 'KYC001', 'John Traders Pvt Ltd', 'ജോൺ ട്രേഡേഴ്സ് പ്രൈവറ്റ് ലിമിറ്റഡ്', true, 2001, 'ABCDE1234F', 'pan_copy.pdf', '32AAAAA0000A1Z5', 'gst_doc.pdf', 'supporting_doc.pdf', true, 'John Traders Private Limited', 'John Traders', '9984', 'Internet and broadband service', true, 'lut_2025.pdf', false, true, gen_random_uuid(), gen_random_uuid());


DROP TABLE IF EXISTS ce_location_movement CASCADE;

CREATE TABLE ce_location_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  locid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  created_by_platform varchar(128) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_location_movement PRIMARY KEY (movement_id)
);

INSERT INTO ce_location_movement (movement_id, code, name, name_in_local, is_active, locid, approve_status, remarks, created_by_platform, created_by, modified_by)
VALUES (gen_random_uuid(), 'MOV001', 'Warehouse Relocation', 'വെയർഹൗസ് മാറ്റം', true, 101, 1, 'Location moved from Kochi to Trivandrum', 'WebApp', gen_random_uuid(), gen_random_uuid());

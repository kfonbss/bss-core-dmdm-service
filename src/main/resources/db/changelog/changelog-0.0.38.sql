DROP TABLE IF EXISTS caf_details CASCADE;

CREATE TABLE caf_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active BOOLEAN,
  id SERIAL,
  caf_no varchar(60) DEFAULT NULL,
  loc varchar(60) DEFAULT NULL,
  caf_type varchar(60) DEFAULT NULL,
  prefix varchar(10) DEFAULT NULL,
  firstname varchar(60) DEFAULT NULL,
  middlename varchar(60) DEFAULT NULL,
  lastname varchar(60) DEFAULT NULL,
  nameof_firm varchar(160) DEFAULT NULL,
  gender int NOT NULL,
  nationality varchar(60) DEFAULT NULL,
  father_husband_name varchar(60) DEFAULT NULL,
  dateofbirth date NOT NULL,
  panno varchar(60) DEFAULT NULL,
  marital_status varchar(10) DEFAULT NULL,
  existing_customer varchar(10) DEFAULT NULL,
  proof_of_identity varchar(10) DEFAULT NULL,
  proof_of_identity_anyother varchar(60) DEFAULT NULL,
  proof_of_address varchar(10) DEFAULT NULL,
  proof_of_address_anyother varchar(60) DEFAULT NULL,
  customer_photo varchar(250) DEFAULT NULL,
  status varchar(45) DEFAULT 'Submitted',
  instalation_address varchar(256) DEFAULT NULL,
  instalation_city varchar(60) DEFAULT NULL,
  instalation_pincode varchar(60) DEFAULT NULL,
  instalation_landmark varchar(60) DEFAULT NULL,
  instalation_mobile varchar(60) DEFAULT NULL,
  instalation_telephone varchar(60) DEFAULT NULL,
  instalation_faxno varchar(60) DEFAULT NULL,
  instalation_emailid varchar(250) DEFAULT NULL,
  billing_address varchar(256) DEFAULT NULL,
  billing_city varchar(60) DEFAULT NULL,
  billing_pincode varchar(60) DEFAULT NULL,
  billing_landmark varchar(60) DEFAULT NULL,
  billing_mobile varchar(60) DEFAULT NULL,
  billing_telephone varchar(60) DEFAULT NULL,
  billing_faxno varchar(60) DEFAULT NULL,
  billing_emailid varchar(250) DEFAULT NULL,
  packageid int DEFAULT NULL,
  connection_type varchar(60) DEFAULT NULL,
  package_type varchar(60) DEFAULT NULL,
  port_sped varchar(60) DEFAULT NULL,
  port_sped_usage varchar(160) DEFAULT NULL,
  service1 varchar(160) DEFAULT NULL,
  service2 varchar(160) DEFAULT NULL,
  service3 varchar(160) DEFAULT NULL,
  service4 varchar(160) DEFAULT NULL,
  noof_static_ips varchar(160) DEFAULT NULL,
  amount_paid_inr decimal(13,2) DEFAULT NULL,
  amount_paid_wrds varchar(250) DEFAULT NULL,
  mode_of_payments varchar(25) DEFAULT NULL,
  cash_reciept_no varchar(250) DEFAULT NULL,
  dd_check_no varchar(250) DEFAULT NULL,
  dateofpaid date DEFAULT NULL,
  bank_name varchar(250) DEFAULT NULL,
  branch_name varchar(250) DEFAULT NULL,
  authorized_sign varchar(250) DEFAULT NULL,
  dateofsign date DEFAULT NULL,
  partnerid varchar(60) NOT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  modified_date timestamp DEFAULT NULL,
  idproof varchar(100) DEFAULT NULL,
  addressproof varchar(100) DEFAULT NULL,
  photoattaced varchar(10) DEFAULT NULL,
  fsecode varchar(100) DEFAULT NULL,
  fsesignanddate varchar(100) DEFAULT NULL,
  asmcode varchar(100) DEFAULT NULL,
  crmcorsignanddate varchar(100) DEFAULT NULL,
  paymentrealizationdate date DEFAULT NULL,
  custommacid varchar(100) DEFAULT NULL,
  accessprovider varchar(100) DEFAULT NULL,
  fsmacid varchar(100) DEFAULT NULL,
  wiredprovider varchar(100) DEFAULT NULL,
  bsmacid varchar(100) DEFAULT NULL,
  wirelessprovider varchar(100) DEFAULT NULL,
  fsport varchar(100) DEFAULT NULL,
  activationdate date DEFAULT NULL,
  bsport varchar(100) DEFAULT NULL,
  officeuse varchar(10) DEFAULT NULL,
  anpstampname varchar(100) DEFAULT NULL,
  signatureofanp varchar(100) DEFAULT NULL,
  mspstamname varchar(100) DEFAULT NULL,
  signaturofmsp varchar(100) DEFAULT NULL,
  mspcode varchar(100) DEFAULT NULL,
  mspdate date DEFAULT NULL,
  railtelrepresentivename varchar(100) DEFAULT NULL,
  railtelsignature varchar(100) DEFAULT NULL,
  railtel_desgnation varchar(100) DEFAULT NULL,
  railtel_date date DEFAULT NULL,
  feasbilitycheckdate date DEFAULT NULL,
  flag boolean DEFAULT NULL,
  corp_loc_id int DEFAULT NULL,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_caf_details PRIMARY KEY (details_id)
);
INSERT INTO caf_details (
  details_id, code, name, name_in_local, is_active, id, caf_no, loc, caf_type, prefix, firstname, middlename, lastname,
  nameof_firm, gender, nationality, father_husband_name, dateofbirth, panno, marital_status, existing_customer,
  proof_of_identity, proof_of_identity_anyother, proof_of_address, proof_of_address_anyother, customer_photo, status,
  instalation_address, instalation_city, instalation_pincode, instalation_landmark, instalation_mobile,
  instalation_telephone, instalation_faxno, instalation_emailid, billing_address, billing_city, billing_pincode,
  billing_landmark, billing_mobile, billing_telephone, billing_faxno, billing_emailid, packageid, connection_type,
  package_type, port_sped, port_sped_usage, service1, service2, service3, service4, noof_static_ips, amount_paid_inr,
  amount_paid_wrds, mode_of_payments, cash_reciept_no, dd_check_no, dateofpaid, bank_name, branch_name,
  authorized_sign, dateofsign, partnerid, created_date, modified_date, idproof, addressproof, photoattaced, fsecode,
  fsesignanddate, asmcode, crmcorsignanddate, paymentrealizationdate, custommacid, accessprovider, fsmacid,
  wiredprovider, bsmacid, wirelessprovider, fsport, activationdate, bsport, officeuse, anpstampname, signatureofanp,
  mspstamname, signaturofmsp, mspcode, mspdate, railtelrepresentivename, railtelsignature, railtel_desgnation,
  railtel_date, feasbilitycheckdate, flag, corp_loc_id, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'CAF001', 'John Doe CAF', 'ജോൺ ഡോ സി.എ.എഫ്', true, 1, 'CAF-2025-001', 'Trivandrum', 'Individual', 'Mr',
  'John', '', 'Doe', 'JD Solutions Pvt Ltd', 1, 'Indian', 'Richard Doe', '1990-05-21', 'ABCDE1234F', 'Single', 'No',
  'Passport', NULL, 'Aadhaar', NULL, 'photo.jpg', 'Submitted', '123 MG Road', 'Trivandrum', '695001', 'Near Park',
  '9876543210', '0471234567', NULL, 'john@example.com', '123 MG Road', 'Trivandrum', '695001', 'Near Park',
  '9876543210', NULL, NULL, 'billing@example.com', 101, 'FTTH', 'Residential', '100 Mbps', 'Unlimited', 'Internet',
  'Voice', NULL, NULL, '0', 1500.00, 'One Thousand Five Hundred Only', 'Cash', 'CR123', NULL, '2025-04-10', 'SBI',
  'Main Branch', 'John Doe', '2025-04-10', 'PART001', CURRENT_TIMESTAMP, NULL, 'PAN', 'Aadhaar', 'Yes', 'FSE001',
  '2025-04-11', 'ASM001', '2025-04-12', '2025-04-13', '00:1B:44:11:3A:B7', 'BSNL', 'FSM001', 'RailTel', 'BSM001',
  'Airtel', 'FS001', '2025-04-20', 'BS001', 'Yes', 'ANP123', 'SignANP', 'MSP123', 'SignMSP', 'MSP001', '2025-04-22',
  'Ravi Kumar', 'SignRail', 'Manager', '2025-04-25', '2025-04-18', true, 12, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS campaign CASCADE;

CREATE TABLE campaign (
  campaign_uuid UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  campaign_id int NOT NULL,
  campaign_source varchar(200) DEFAULT NULL,
  campaign_type varchar(100) DEFAULT NULL,
  campaign_reference varchar(100) DEFAULT NULL,
  campaign_hash varchar(100) DEFAULT NULL,
  link varchar(250) DEFAULT NULL,
  short_link varchar(200) DEFAULT NULL,
  link_validity date DEFAULT NULL,
  is_active boolean NOT NULL DEFAULT true,
  created_by varchar(100) DEFAULT NULL,
  created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_campaign PRIMARY KEY (campaign_uuid)
);

CREATE UNIQUE INDEX campaign_id_unique ON campaign (campaign_id);


DROP TABLE IF EXISTS cause_details CASCADE;

CREATE TABLE cause_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  rechargemode int DEFAULT NULL,
  sf_pscause varchar(250) DEFAULT NULL,
  sf_gstcause varchar(250) DEFAULT NULL,
  rstatus_advance int DEFAULT NULL,
  pf_pscause varchar(250) DEFAULT NULL,
  pf_ngcause varchar(250) DEFAULT NULL,
  dis_status_id_after int DEFAULT NULL,
  plantype int DEFAULT NULL,
  payment_gateway varchar(10) DEFAULT NULL,
  vas_type varchar(250) DEFAULT NULL,
  preciept int DEFAULT 0,
  remarks varchar(250) DEFAULT NULL,
  is_active int DEFAULT 1,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  upadate_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_cause_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN cause_details.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS ce_connection_breakup CASCADE;

CREATE TABLE ce_connection_breakup (
  breakup_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active BOOLEAN,
  id SERIAL,
  serviceid int DEFAULT NULL,
  quoationid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  otc_cost int DEFAULT NULL,
  noof_connections int DEFAULT 0,
  discount decimal(5,1) DEFAULT 0.0,
  description varchar(250) DEFAULT NULL,
  alternate_name varchar(250) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_connection_breakup PRIMARY KEY (breakup_id)
);

INSERT INTO ce_connection_breakup (breakup_id, code, name, name_in_local, is_active, serviceid, quoationid, packageid, otc_cost, noof_connections, discount, description, alternate_name, created_by, modified_by)
VALUES ('2a9e5e6f-58e3-4b94-9b91-fc7e2f8e2a19', 'CE001', 'Enterprise Fiber Connection', 'എന്റർപ്രൈസ് ഫൈബർ കണക്ഷൻ', TRUE, 101, 2001, 3001, 2500, 5, 10.0, 'High-speed enterprise fiber plan for corporate clients', 'Corporate Fiber Plan', 'b9fba2de-72b8-4d21-8cf3-6c9e1b9ad8ff', 'b9fba2de-72b8-4d21-8cf3-6c9e1b9ad8ff');


DROP TABLE IF EXISTS ce_connection_breakup_movement CASCADE;

CREATE TABLE ce_connection_breakup_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active BOOLEAN,
  id SERIAL,
  breakupid int DEFAULT NULL,
  quoationid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  discount int DEFAULT 0,
  created_by_platform varchar(128) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_connection_breakup_movement PRIMARY KEY (movement_id)
);

INSERT INTO ce_connection_breakup_movement (movement_id, code, name, name_in_local, is_active, breakupId, quoationId, approve_status, discount, created_by_platform, created_by, modified_by)
VALUES ('b8e1c5f7-01a2-4db3-8a73-3c34f1d8d1c1', 'MOV001', 'Initial Connection Movement', 'ആദ്യ കണക്ഷൻ മൂവ്‌മെന്റ്', TRUE, 101, 2001, 1, 5, 'WebPortal', 'c7a4e8a3-23ef-4d8b-a7e5-1a2b3c4d5e6f', 'c7a4e8a3-23ef-4d8b-a7e5-1a2b3c4d5e6f');

DROP TABLE IF EXISTS ce_connection_breakup_movement_revision CASCADE;

CREATE TABLE ce_connection_breakup_movement_revision (
  revision_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  breakupid int DEFAULT NULL,
  quoationid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  discount int DEFAULT 0,
  created_by_platform varchar(128) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  migrated int DEFAULT NULL,
  CONSTRAINT pk_ce_connection_breakup_movement_revision PRIMARY KEY (revision_id)
);
INSERT INTO ce_connection_breakup_movement_revision (revision_id, code,name, name_in_local, is_active, breakupId, quoationId, approve_status, discount, created_by_platform, created_by, modified_by, migrated)
VALUES ('9c7d2e2f-45b8-4f32-9b77-9e6b9a2a1f77', 'RI001','Revised Connection Movement', 'പുനഃപരിശോധിച്ച കണക്ഷൻ മൂവ്‌മെന്റ്', TRUE, 101, 2001, 2, 15, 'AdminPortal', 'b1f7c2e3-12a4-4f5b-8c7a-9d2e4f6a1b8c', 'b1f7c2e3-12a4-4f5b-8c7a-9d2e4f6a1b8c', 0);

DROP TABLE IF EXISTS ce_customers CASCADE;

CREATE TABLE ce_customers (
  customer_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  id SERIAL,
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  company_name varchar(100) DEFAULT NULL,
  short_name varchar(50) DEFAULT NULL,
  contact_person varchar(50) DEFAULT NULL,
  mobile varchar(100) DEFAULT NULL,
  email varchar(250) DEFAULT NULL,
  address varchar(500) DEFAULT NULL,
  pincode varchar(6) DEFAULT NULL,
  description varchar(250) DEFAULT NULL,
  kyc_added boolean DEFAULT false,
  --0=Not Added,1=Added
  service_type int NOT NULL DEFAULT 1,
  pay_via_invoice boolean DEFAULT false,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  enquiry_id int DEFAULT NULL,
  company_type varchar(100) DEFAULT NULL,
  billing_category varchar(50) DEFAULT NULL,
  parent_dept_id varchar(200) DEFAULT NULL,
  enable_cdnote boolean DEFAULT false,
  location_wise_dnote boolean DEFAULT false,
  CONSTRAINT pk_ce_customers PRIMARY KEY (customer_id)
);

INSERT INTO ce_customers (
    customer_id, code,id, name, name_in_local, is_active, company_name, short_name, contact_person,
    mobile, email, address, pincode, description, kyc_added, service_type, pay_via_invoice,
    created_by, modified_by, enquiry_id, company_type, billing_category, parent_dept_id,
    enable_cdnote, location_wise_dnote
)
VALUES
('44444444-4444-4444-4444-444444444444', 'CUS001',2, 'Green Energy Solutions', 'ഗ്രീൻ എനർജി സൊല്യൂഷൻസ്', true,
 'Green Energy Solutions LLP', 'GES', 'Sneha Raj', '9123456789', 'contact@greenenergy.com',
 'Technopark, Trivandrum, Kerala', '695581', 'Renewable energy project client', false, 2, false,
 '55555555-5555-5555-5555-555555555555', '66666666-6666-6666-6666-666666666666', 102,
 'LLP', 'Industrial', 'Energy-Dept', false, true);


DROP TABLE IF EXISTS ce_disbursement CASCADE;

CREATE TABLE ce_disbursement (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  disburseid SERIAL,
  partnergroupid int DEFAULT NULL,
  locid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  cause varchar(100) DEFAULT NULL,
  revenue decimal(26,10) DEFAULT NULL,
  disbursestatusid int DEFAULT 0,
  subfinanceid int DEFAULT NULL,
  revenueshareid int DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_disbursement PRIMARY KEY (id)
);
INSERT INTO ce_disbursement (id, code,name, name_in_local, is_active, partnergroupid, locid, packageid, subscriberid, cause, revenue, disbursestatusid, subfinanceid, revenueshareid, created_by, modified_by)
VALUES ('b47f82b2-6781-4cb0-8d91-7c4b1b0aebd2', 'DIS001','Monthly Fiber Revenue Share', 'മാസാന്ത്യ ഫൈബർ വരുമാന പങ്ക്', TRUE, 10, 205, 301, 4502, 'Quarterly disbursement for subscriber group A', 12500.7500000000, 1, 1001, 2001, 'b1a5d82b-6712-4bb0-91f5-9a3a9f1e1b23', 'b1a5d82b-6712-4bb0-91f5-9a3a9f1e1b23');

-- Table: partneraccount_balance_report
DROP TABLE IF EXISTS partneraccount_balance_report;

CREATE TABLE partneraccount_balance_report (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  rptid BIGSERIAL ,
  state VARCHAR(64) DEFAULT NULL,
  partnerid VARCHAR(45) DEFAULT NULL,
  companyname VARCHAR(128) DEFAULT NULL,
  ptype CHAR(5) DEFAULT NULL,
  openbalance NUMERIC(10,2) DEFAULT NULL,
  partnertopup NUMERIC(10,2) DEFAULT NULL,
  received_share NUMERIC(10,2) DEFAULT NULL,
  sub_transfer NUMERIC(10,2) DEFAULT NULL,
  closebalance NUMERIC(10,2) DEFAULT NULL,
  rmonth VARCHAR(15) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO partneraccount_balance_report (
    id, rptid, state, partnerid, companyname, ptype,
    openbalance, partnertopup, received_share, sub_transfer,
    closebalance, rmonth, code, name, name_in_local,
    is_active, created_date, modified_date, created_by, modified_by
) VALUES
(
    gen_random_uuid(), DEFAULT, 'Kerala', 'P001', 'TechNet Solutions', 'A',
    10000.00, 2000.00, 1500.00, 500.00,
    12000.00, '2025-10', 'RPT01', 'Account Balance Report', 'അക്കൗണ്ട് ബാലൻസ് റിപ്പോർട്ട്',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

-- Table: partneragreementdetail
DROP TABLE IF EXISTS partneragreementdetail;

CREATE TABLE partneragreementdetail (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL ,
  partnerid BIGINT DEFAULT NULL,
  version INT DEFAULT NULL,
  renewed_agreementdate DATE DEFAULT NULL,
  renewed_agreementcopy VARCHAR(256) DEFAULT NULL,
  updated_by VARCHAR(20) DEFAULT NULL,
  updated_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table: partnerdemousers
DROP TABLE IF EXISTS partnerdemousers;

CREATE TABLE partnerdemousers (
  user_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  demoid BIGSERIAL ,
  partnerid VARCHAR(45) DEFAULT NULL,
  username VARCHAR(64) DEFAULT NULL,
  password VARCHAR(64) DEFAULT NULL,
  status INT DEFAULT NULL,
  speed CHAR(15) DEFAULT NULL,
  expirydate DATE DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NULL,
  lastupdate TIMESTAMP DEFAULT NULL,
  startdate DATE DEFAULT NULL,
  packageid INT DEFAULT NULL,
  alloted_vol BIGINT DEFAULT NULL,
  consumed_vol BIGINT DEFAULT NULL,
  created_by VARCHAR(30) DEFAULT NULL
);

CREATE INDEX index2_partnerdemousers ON partnerdemousers (partnerid, username);

-- Table: partnerdetail
DROP TABLE IF EXISTS partnerdetail;

CREATE TABLE partnerdetail (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  partnerid BIGINT ,
  partnercompanyname VARCHAR(150) DEFAULT NULL,
  status BOOLEAN NOT NULL DEFAULT FALSE,
  companyregistrationno VARCHAR(64) DEFAULT NULL,
  servicetaxno VARCHAR(64) DEFAULT NULL,
  incometaxno VARCHAR(45) DEFAULT NULL,
  vatno VARCHAR(45) DEFAULT NULL,
  state VARCHAR(64) DEFAULT NULL,
  pin INT DEFAULT NULL,
  registrationdate DATE DEFAULT NULL,
  agreementno VARCHAR(100) DEFAULT NULL,
  agreementdate DATE DEFAULT NULL,
  keycontactname VARCHAR(45) DEFAULT NULL,
  keycontactnumber BIGINT DEFAULT NULL,
  keycontactemail VARCHAR(128) DEFAULT NULL,
  lastupdate TIMESTAMP DEFAULT NULL,
  supportcontactname VARCHAR(128) DEFAULT NULL,
  supportcontactno VARCHAR(15) DEFAULT NULL,
  supportcontactemail VARCHAR(128) DEFAULT NULL,
  managercontactname VARCHAR(45) DEFAULT NULL,
  managercontactno BIGINT DEFAULT NULL,
  managercontactemail VARCHAR(128) DEFAULT NULL,
  allocated_bw VARCHAR(45) DEFAULT NULL,
  consumed_bw VARCHAR(45) DEFAULT NULL,
  pgiopt INT NOT NULL DEFAULT 0,
  statecode VARCHAR(5) DEFAULT NULL,
  acholdername VARCHAR(100) DEFAULT NULL,
  actype VARCHAR(5) DEFAULT NULL,
  bankname VARCHAR(100) DEFAULT NULL,
  branchname VARCHAR(100) DEFAULT NULL,
  acnumber VARCHAR(50) DEFAULT NULL,
  "IFSC" VARCHAR(30) DEFAULT NULL,
  ptype CHAR(25) DEFAULT NULL,
  address VARCHAR(300) DEFAULT NULL,
  approval_date TIMESTAMP DEFAULT NULL,
  approval_cl VARCHAR(300) DEFAULT NULL,
  approval_response VARCHAR(300) DEFAULT NULL,
  agreementcopy VARCHAR(256) DEFAULT NULL,
  bankpasscopy VARCHAR(256) DEFAULT NULL,
  incometaxproof VARCHAR(256) DEFAULT NULL,
  servicetaxproof VARCHAR(256) DEFAULT NULL,
  bank_acholder VARCHAR(128) DEFAULT NULL,
  bank_actype VARCHAR(45) DEFAULT NULL,
  bank_name VARCHAR(128) DEFAULT NULL,
  bank_branch VARCHAR(128) DEFAULT NULL,
  bank_acno VARCHAR(64) DEFAULT NULL,
  bank_ifsc VARCHAR(64) DEFAULT NULL,
  companynature VARCHAR(64) DEFAULT NULL,
  STCode CHAR(3) DEFAULT NULL,
  address_line1 VARCHAR(120) DEFAULT NULL,
  address_line2 VARCHAR(120) DEFAULT NULL,
  city VARCHAR(64) DEFAULT NULL,
  PinCode VARCHAR(7) DEFAULT NULL,
  StateName VARCHAR(64) DEFAULT NULL,
  District VARCHAR(64) DEFAULT NULL,
  gstin VARCHAR(45) DEFAULT NULL,
  service_description VARCHAR(180) DEFAULT NULL,
  SAC VARCHAR(45) DEFAULT NULL,
  gstindoc VARCHAR(120) DEFAULT NULL,
  gst_verfied INT NOT NULL DEFAULT 0,
  taxpayertype INT NOT NULL DEFAULT 0,
  gstdeclartionstatus INT NOT NULL DEFAULT 0,
  subonrecharge INT DEFAULT 1,
  onlinepaymode VARCHAR(100) DEFAULT NULL,
  mspverified INT DEFAULT 1,
  otp VARCHAR(20) DEFAULT NULL,
  otp_time TIMESTAMP DEFAULT NULL,
  remarks VARCHAR(100) DEFAULT NULL,
  paymodedate TIMESTAMP DEFAULT NULL,
  mspverfieddate TIMESTAMP DEFAULT NULL,
  bankverfieddate TIMESTAMP DEFAULT NULL,
  lastrenewed_agreementdate DATE DEFAULT NULL,
  lastrenewed_agreementcopy VARCHAR(256) DEFAULT NULL,
  loc_type INT DEFAULT NULL,
  gst_status INT DEFAULT NULL,
  catagory VARCHAR(30) DEFAULT NULL,
  vas_enabled VARCHAR(45) DEFAULT NULL,
  cbldoc VARCHAR(256) DEFAULT NULL,
  railtelflag INT DEFAULT 1,
  territory_name VARCHAR(45) DEFAULT NULL,
  ptnrattid VARCHAR(100) DEFAULT NULL,
  ptnrlang VARCHAR(100) DEFAULT NULL,
  bu_id INT DEFAULT NULL,
  subonrechargeatom INT DEFAULT 1,
  gway_available INT DEFAULT NULL,
  ring VARCHAR(50) DEFAULT NULL,
  brasip VARCHAR(50) DEFAULT NULL,
  switchip_anp VARCHAR(50) DEFAULT NULL,
  dropping VARCHAR(50) DEFAULT NULL,
  interface VARCHAR(50) DEFAULT NULL,
  port_number VARCHAR(50) DEFAULT NULL,
  pop_name VARCHAR(50) DEFAULT NULL,
  pop_pincode VARCHAR(50) DEFAULT NULL,
  vlan VARCHAR(100) DEFAULT NULL,
  port_speed VARCHAR(15) DEFAULT NULL,
  subonlinerechargeikon INT DEFAULT 1,
  subonlinerechargehdfc INT DEFAULT 1,
  updated_service_area INT DEFAULT 0,
  lnk_es_status VARCHAR(20) DEFAULT 'Not_Delivered',
  lnk_es_lnktype VARCHAR(20) DEFAULT NULL,
  lnk_es_date DATE DEFAULT NULL,
  frc_recieved VARCHAR(20) DEFAULT 'No',
  frc_paymt_date DATE DEFAULT NULL,
  reasfor_nlink_delivery VARCHAR(200) DEFAULT NULL,
  brief_remarks VARCHAR(200) DEFAULT NULL,
  allowfreecon INT DEFAULT 0,
  enable_acs INT DEFAULT NULL,
  aadhaar_number VARCHAR(15) DEFAULT NULL,
  aadhaarcopy VARCHAR(100) DEFAULT NULL,
  olt_provider VARCHAR(20) DEFAULT NULL,
  alternate_phone BIGINT DEFAULT NULL,
  enable_ews_service INT DEFAULT 0,
  enableplaybox INT DEFAULT 1,
  code VARCHAR(50),
  name VARCHAR(255),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX index2_partnerdetail ON partnerdetail (statecode);

INSERT INTO partnerdetail
(id, partnerid, partnercompanyname, status, companyregistrationno, servicetaxno, incometaxno, vatno, state, pin, registrationdate, agreementno, agreementdate, keycontactname, keycontactnumber, keycontactemail, lastupdate, supportcontactname, supportcontactno, supportcontactemail, managercontactname, managercontactno, managercontactemail, allocated_bw, consumed_bw, pgiopt, statecode, acholdername, actype, bankname, branchname, acnumber, "IFSC", ptype, address, approval_date, approval_cl, approval_response, agreementcopy, bankpasscopy, incometaxproof, servicetaxproof, bank_acholder, bank_actype, bank_name, bank_branch, bank_acno, bank_ifsc, companynature, STCode, address_line1, address_line2, city, PinCode, StateName, District, gstin, service_description, SAC, gstindoc, gst_verfied, taxpayertype, gstdeclartionstatus, subonrecharge, onlinepaymode, mspverified, otp, otp_time, remarks, paymodedate, mspverfieddate, bankverfieddate, lastrenewed_agreementdate, lastrenewed_agreementcopy, loc_type, gst_status, catagory, vas_enabled, cbldoc, railtelflag, territory_name, ptnrattid, ptnrlang, bu_id, subonrechargeatom, gway_available, ring, brasip, switchip_anp, dropping, interface, port_number, pop_name, pop_pincode, vlan, port_speed, subonlinerechargeikon, subonlinerechargehdfc, updated_service_area, lnk_es_status, lnk_es_lnktype, lnk_es_date, frc_recieved, frc_paymt_date, reasfor_nlink_delivery, brief_remarks, allowfreecon, enable_acs, aadhaar_number, aadhaarcopy, olt_provider, alternate_phone, enable_ews_service, enableplaybox, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 1001, 'Test Partner Company', TRUE, 'REG12345', 'ST12345', 'IT12345', 'VAT12345', 'Kerala', 682001, '2025-01-01', 'AG123', '2025-01-10', 'John Doe', 9876543210, 'john.doe@example.com', NOW(), 'Support Team', '9876543211', 'support@example.com', 'Manager Name', 9876543212, 'manager@example.com', '100Mbps', '50Mbps', 1, 'KL', 'Alice', 'SB', 'Test Bank', 'Main Branch', '1234567890', 'SBIN0001234', 'PT', '123 Main Street', NOW(), 'Approved', 'Response OK', 'agreement.pdf', 'bankpass.pdf', 'incometax.pdf', 'servicetax.pdf', 'Alice', 'SB', 'Test Bank', 'Main Branch', '1234567890', 'SBIN0001234', 'IT Company', 'KL', 'Address Line1', 'Address Line2', 'Kochi', '682001', 'Kerala', 'Ernakulam', '29ABCDE1234F2Z5', 'Internet Service', 'SAC123', 'gstdoc.pdf', 1, 1, 1, 1, 'Online', 1, 'OTP123', NOW(), 'No remarks', NOW(), NOW(), NOW(), '2025-01-15', 'agreement_copy.pdf', 1, 1, 'Category1', 'VAS', 'cbldoc.pdf', 1, 'Territory1', 'PT001', 'EN', 1, 1, 1, 'Ring1', 'BR001', '192.168.1.1', '192.168.1.2', 'IF1', '8080', 'POP1', '682001', 'VLAN1', '1Gbps', 1, 1, 1, 'Not_Delivered', 'LinkType1', '2025-01-05', 'No', '2025-01-06', 'Reason text', 'Brief remarks', 0, 1, '123456789012', 'aadhaar.pdf', 'OLT1', 9876543213, 0, 1, 'PD001', 'Partner Detail Name', 'പാർട്ണർ ഡീറ്റെയിൽ', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table: partnerdisbursement
DROP TABLE IF EXISTS partnerdisbursement;

CREATE TABLE partnerdisbursement (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  partnerdisbursementid SERIAL ,
  partnergroupid INT NOT NULL,
  revenue NUMERIC(10,2) NOT NULL,
  disbursestatusid INT DEFAULT 3,
  subscriberid BIGINT DEFAULT NULL,
  cause VARCHAR(100) DEFAULT NULL,
  subfinanceid BIGINT DEFAULT NULL,
  onsubbssref VARCHAR(64) DEFAULT NULL,
  lowestrevenue NUMERIC(10,2) DEFAULT NULL,
  agramount NUMERIC(10,2) DEFAULT NULL,
  oldsubfinanceid BIGINT DEFAULT NULL,
  rechargemode INT DEFAULT 0,
  plantype INT DEFAULT 0,
  revenueshareid INT DEFAULT NULL,
  packageid INT DEFAULT NULL,
  sub_packageid INT DEFAULT NULL,
  diburse_mode INT DEFAULT 0,
  cause_detail_id INT DEFAULT 0,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX index2_partnerdisbursement ON partnerdisbursement (partnergroupid, modified_date, disbursestatusid);

INSERT INTO partnerdisbursement (
    id, partnerdisbursementid, partnergroupid, revenue, disbursestatusid, subscriberid,
    cause, subfinanceid, onsubbssref, lowestrevenue, agramount, oldsubfinanceid,
    rechargemode, plantype, revenueshareid, packageid, sub_packageid,
    diburse_mode, cause_detail_id, code, name, name_in_local, is_active,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), DEFAULT, 101, 15000.00, 3, 50001,
    'Monthly Partner Revenue', 2001, 'ONSBSS-REF-001', 12000.00, 15000.00, NULL,
    1, 2, 301, 401, 501,
    0, 10, 'PD001', 'Partner Disbursement Sample', 'പാർട്നർ വിതരണം സാമ്പിൾ',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

-- Table: partnerfinance
DROP TABLE IF EXISTS partnerfinance;

CREATE TABLE partnerfinance (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  partnerfinanceid SERIAL ,
  partnerid BIGINT DEFAULT NULL,
  cause VARCHAR(100) DEFAULT NULL,
  amount NUMERIC(10,2) DEFAULT NULL,
  subscriberid INT DEFAULT NULL,
  subonlineref BIGINT DEFAULT NULL,
  subfinanceid BIGINT DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX partnerfinance_index ON partnerfinance (partnerid, cause, modified_date);

INSERT INTO partnerfinance (
    id, partnerfinanceid, partnerid, cause,amount,
    subscriberid, subonlineref, subfinanceid, code, name, name_in_local,
    is_active, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), DEFAULT, 20001, 'Revenue Share Settlement', 25000.00,
    60001, 9876543210, 3001, 'PF001', 'Partner Finance Sample', 'പാർട്നർ ഫിനാൻസ് സാമ്പിൾ',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

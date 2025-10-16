-- Table: partneraccount_balance_report
DROP TABLE IF EXISTS partneraccount_balance_report;

CREATE TABLE partneraccount_balance_report (
  id UUID NOT NULL PRIMARY KEY,
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
  rmonth VARCHAR(15) DEFAULT NULL
);

-- Table: partneragreementdetail
DROP TABLE IF EXISTS partneragreementdetail;

CREATE TABLE partneragreementdetail (
  details_id UUID NOT NULL PRIMARY KEY,
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
  user_id UUID NOT NULL PRIMARY KEY,
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
  id UUID NOT NULL PRIMARY KEY,
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
  isactive INT NOT NULL DEFAULT 1,
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
  updated_by VARCHAR(20) DEFAULT NULL,
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
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_service_area INT DEFAULT 0,
  lnk_es_status VARCHAR(20) DEFAULT 'Not_Delivered',
  lnk_es_lnktype VARCHAR(20) DEFAULT NULL,
  lnk_es_date DATE DEFAULT NULL,
  frc_recieved VARCHAR(20) DEFAULT 'No',
  frc_paymt_date DATE DEFAULT NULL,
  reasfor_nlink_delivery VARCHAR(200) DEFAULT NULL,
  brief_remarks VARCHAR(200) DEFAULT NULL,
  is_active INT DEFAULT 1,
  allowfreecon INT DEFAULT 0,
  enable_acs INT DEFAULT NULL,
  aadhaar_number VARCHAR(15) DEFAULT NULL,
  aadhaarcopy VARCHAR(100) DEFAULT NULL,
  olt_provider VARCHAR(20) DEFAULT NULL,
  alternate_phone BIGINT DEFAULT NULL,
  enable_ews_service INT DEFAULT 0,
  enableplaybox INT DEFAULT 1
);

CREATE INDEX index2_partnerdetail ON partnerdetail (statecode);

-- Table: partnerdisbursement
DROP TABLE IF EXISTS partnerdisbursement;

CREATE TABLE partnerdisbursement (
  id UUID NOT NULL PRIMARY KEY,
  partnerdisbursementid SERIAL ,
  partnergroupid INT NOT NULL,
  revenue NUMERIC(10,2) NOT NULL,
  disbursestatusid INT DEFAULT 3,
  subscriberid BIGINT DEFAULT NULL,
  cause VARCHAR(100) DEFAULT NULL,
  lastupdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_date TIMESTAMP DEFAULT NULL,
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
  cause_detail_id INT DEFAULT 0
);

CREATE INDEX index2_partnerdisbursement ON partnerdisbursement (partnergroupid, lastupdate, disbursestatusid);

-- Table: partnerfinance
DROP TABLE IF EXISTS partnerfinance;

CREATE TABLE partnerfinance (
  id UUID NOT NULL PRIMARY KEY,
  partnerfinanceid SERIAL ,
  partnerid BIGINT DEFAULT NULL,
  cause VARCHAR(100) DEFAULT NULL,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  amount NUMERIC(10,2) DEFAULT NULL,
  subscriberid INT DEFAULT NULL,
  subonlineref BIGINT DEFAULT NULL,
  subfinanceid BIGINT DEFAULT NULL
);

CREATE INDEX partnerfinance_index ON partnerfinance (partnerid, cause, lastupdate);


-- Table : onboardanp_details
DROP TABLE IF EXISTS onboardanp_details CASCADE;

CREATE TABLE onboardanp_details (
  onboardanp_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  partnerid int NOT NULL,
  partnercompanyname varchar(150) DEFAULT NULL,
  status INT NOT NULL DEFAULT 0,
  companyregistrationno varchar(64) DEFAULT NULL,
  servicetaxno varchar(64) DEFAULT NULL,
  incometaxno varchar(45) DEFAULT NULL,
  state varchar(64) DEFAULT NULL,
  registrationdate date DEFAULT NULL,
  agreementno varchar(100) DEFAULT NULL,
  agreementdate date DEFAULT NULL,
  keycontactname varchar(45) DEFAULT NULL,
  keycontactnumber int DEFAULT NULL,
  keycontactemail varchar(128) DEFAULT NULL,
  statecode varchar(5) DEFAULT NULL,
  ptype varchar(5) DEFAULT NULL,
  address varchar(300) DEFAULT NULL,
  agreementcopy varchar(256) DEFAULT NULL,
  bankpasscopy varchar(256) DEFAULT NULL,
  incometaxproof varchar(256) DEFAULT NULL,
  servicetaxproof varchar(256) DEFAULT NULL,
  bank_acholder varchar(128) DEFAULT NULL,
  bank_actype varchar(45) DEFAULT NULL,
  bank_name varchar(128) DEFAULT NULL,
  bank_branch varchar(128) DEFAULT NULL,
  bank_acno varchar(64) DEFAULT NULL,
  bank_ifsc varchar(64) DEFAULT NULL,
  companynature varchar(64) DEFAULT NULL,
  STCode varchar(3) DEFAULT NULL,
  address_line1 varchar(120) DEFAULT NULL,
  address_line2 varchar(120) DEFAULT NULL,
  city varchar(64) DEFAULT NULL,
  PinCode varchar(7) DEFAULT NULL,
  StateName varchar(64) DEFAULT NULL,
  District varchar(64) DEFAULT NULL,
  gstin varchar(45) DEFAULT NULL,
  service_description varchar(180) DEFAULT NULL,
  SAC varchar(45) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  gst_verfied INT NOT NULL DEFAULT 0,
  taxpayertype INT NOT NULL DEFAULT 0,
  gstdeclartionstatus INT NOT NULL DEFAULT 0,
  remarks varchar(100) DEFAULT NULL,
  bankverfieddate timestamp DEFAULT NULL,
  lastrenewed_agreementdate date DEFAULT NULL,
  lastrenewed_agreementcopy varchar(256) DEFAULT NULL,
  gst_status INT DEFAULT 0,
  loc_type INT DEFAULT NULL,
  -- '1 Urban 2 Rural',
  catagory varchar(30) DEFAULT NULL,
  cbldoc varchar(256) DEFAULT NULL,
  territory_name varchar(45) DEFAULT NULL,
  ptnrattid varchar(100) DEFAULT NULL,
  ptnrlang varchar(100) DEFAULT NULL,
  ring varchar(255) DEFAULT NULL,
  brasip varchar(100) DEFAULT NULL,
  switchip_anp varchar(100) DEFAULT NULL,
  dropping varchar(255) DEFAULT NULL,
  interface varchar(100) DEFAULT NULL,
  port_number varchar(50) DEFAULT NULL,
  pop_name varchar(64) DEFAULT NULL,
  pop_pincode varchar(7) DEFAULT NULL,
  approve_status varchar(50) DEFAULT NULL,
  is_onboarde INT DEFAULT 0,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  create_date timestamp DEFAULT NULL,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_onboardanp_details PRIMARY KEY (onboardanp_details_id)
);

-- Create indexes for better performance
CREATE INDEX idx_onboardanp_details_index2 ON onboardanp_details (statecode);

-- Table : onboardanp_gstdetails
DROP TABLE IF EXISTS onboardanp_gstdetails CASCADE;

CREATE TABLE onboardanp_gstdetails (
  onboardanp_gstdetails_id UUID DEFAULT gen_random_uuid() NOT NULL,
  partnerid int  NOT NULL,
  gstin varchar(20) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_verfied INT DEFAULT 0,
  created_date timestamp DEFAULT NULL,
  createdby int DEFAULT NULL,
  verified_date timestamp DEFAULT NULL,
  verfied_by varchar(50) DEFAULT NULL,
  taxpayertype INT DEFAULT NULL,
  gst_status INT DEFAULT 0,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  pan varchar(10) DEFAULT NULL,
  pan_copy varchar(200) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_onboardanp_gstdetails PRIMARY KEY (onboardanp_gstdetails_id)
);


-- Table : onboardanp_movement
DROP TABLE IF EXISTS onboardanp_movement CASCADE;

CREATE TABLE onboardanp_movement (
  onboardanp_movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  requestid int DEFAULT NULL,
  approve_status char(50) DEFAULT NULL,
  remarks varchar(180) DEFAULT NULL,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_onboardanp_movement PRIMARY KEY (onboardanp_movement_id)
);


-- Table : onboardanp_recharge_details
DROP TABLE IF EXISTS onboardanp_recharge_details CASCADE;

CREATE TABLE onboardanp_recharge_details (
  onboardanp_recharge_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  ordernumber varchar(64) DEFAULT NULL,
  status varchar(18) DEFAULT NULL,
  amount decimal(13,2) DEFAULT NULL,
  partnerid varchar(45) DEFAULT NULL,
  submitdate timestamp DEFAULT NULL,
  txnid varchar(64) DEFAULT NULL,
  banktxnid varchar(64) DEFAULT NULL,
  txnamout decimal(13,2) DEFAULT NULL,
  txndate timestamp DEFAULT NULL,
  currency varchar(5) DEFAULT NULL,
  respcode varchar(45) DEFAULT NULL,
  respmsg varchar(256) DEFAULT NULL,
  gatewayname varchar(45) DEFAULT NULL,
  bankname varchar(256) DEFAULT NULL,
  TxnReferenceNo varchar(45) DEFAULT NULL,
  AuthStatus_code varchar(45) DEFAULT NULL,
  AuthStatus_desc varchar(250) DEFAULT NULL,
  ErrorStatus varchar(45) DEFAULT NULL,
  ErrorDescription varchar(350) DEFAULT NULL,
  ChecksumStatus varchar(45) DEFAULT NULL,
  paymentmode varchar(45) DEFAULT NULL,
  gateway_type int DEFAULT 0,
  -- '1=Paytm,2=Billdesk',
  is_recharge_completed int DEFAULT 0,
  -- '1=Not Completed,2=Completed',
  create_date timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_onboardanp_recharge_details PRIMARY KEY (onboardanp_recharge_details_id)
);


-- Table : oneplusone
DROP TABLE IF EXISTS oneplusone CASCADE;

CREATE TABLE oneplusone (
  oneplusone_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  subscriberid varchar(45) DEFAULT NULL,
  packageid varchar(45) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  create_by varchar(45) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_oneplusone PRIMARY KEY (oneplusone_id)
);
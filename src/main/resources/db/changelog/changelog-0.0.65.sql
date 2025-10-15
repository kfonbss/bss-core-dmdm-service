DROP TABLE IF EXISTS corporatecrmsla CASCADE;

CREATE TABLE corporatecrmsla (
  corporate_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  pono VARCHAR(20) DEFAULT NULL,
  uptimefrom VARCHAR(10) DEFAULT NULL,
  uptimeto VARCHAR(10) DEFAULT NULL,
  penality VARCHAR(10) DEFAULT NULL
);

COMMENT ON COLUMN corporatecrmsla.corporate_id IS 'Unique identifier for corporate CRM SLA records';


DROP TABLE IF EXISTS corporatecustomer CASCADE;

CREATE TABLE corporatecustomer (
  customer_id UUID PRIMARY KEY NOT NULL,
  corporateid SERIAL,
  customer VARCHAR(128) DEFAULT NULL,
  description VARCHAR(256) DEFAULT NULL,
  contactname VARCHAR(64) DEFAULT NULL,
  contactdesignation VARCHAR(128) DEFAULT NULL,
  contactemail VARCHAR(128) DEFAULT NULL,
  contactmobile VARCHAR(15) DEFAULT NULL,
  contactofficephone VARCHAR(45) DEFAULT NULL,
  contactbillingaddress VARCHAR(256) DEFAULT NULL,
  registrationdate TIMESTAMP DEFAULT NULL,
  region VARCHAR(100) DEFAULT NULL,
  state VARCHAR(100) DEFAULT NULL,
  pincode BIGINT DEFAULT NULL,
  password VARCHAR(128) DEFAULT NULL,
  status SMALLINT DEFAULT 0,
  role VARCHAR(100) DEFAULT 'CORPCUST',
  service_type VARCHAR(150) DEFAULT NULL,
  po_date DATE DEFAULT NULL,
  bill_start_date DATE DEFAULT NULL,
  po_type VARCHAR(45) DEFAULT NULL,
  cus_type INTEGER DEFAULT 0
);

COMMENT ON COLUMN corporatecustomer.customer_id IS 'Unique identifier for corporate customer records';
COMMENT ON COLUMN corporatecustomer.status IS '0=Inactive,1=Active';
COMMENT ON COLUMN corporatecustomer.cus_type IS '1=BPL,2=End Office';


DROP TABLE IF EXISTS corporatedisbursement CASCADE;

CREATE TABLE corporatedisbursement (
  id UUID PRIMARY KEY NOT NULL,
  disburseid SERIAL,
  partnergroupid INTEGER NOT NULL,
  revenue DECIMAL(10,2) NOT NULL,
  disbursestatusid INTEGER DEFAULT 3,
  disbursedate TIMESTAMP DEFAULT NULL,
  cause VARCHAR(64) DEFAULT NULL,
  subscriberid BIGINT DEFAULT NULL,
  workorderid VARCHAR(45) DEFAULT NULL,
  t_status INTEGER DEFAULT 0,
  t_app_date TIMESTAMP DEFAULT NULL,
  referenceno BIGINT DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN corporatedisbursement.id IS 'Unique identifier for corporate disbursement records';
COMMENT ON COLUMN corporatedisbursement.t_status IS '0=Pending,1=Approved';


DROP TABLE IF EXISTS corporatedisbursementclosed CASCADE;

CREATE TABLE corporatedisbursementclosed (
  id UUID PRIMARY KEY NOT NULL,
  closeddisbursementid SERIAL,
  partnergroupid INTEGER NOT NULL,
  sumrevenue DECIMAL(10,2) NOT NULL,
  revenueshareid INTEGER NOT NULL,
  done INTEGER NOT NULL DEFAULT 0,
  lastupdate TIMESTAMP DEFAULT NULL
);

COMMENT ON COLUMN corporatedisbursementclosed.id IS 'Unique identifier for corporate disbursement closed records';
COMMENT ON COLUMN corporatedisbursementclosed.done IS '0=Pending,1=Completed';


DROP TABLE IF EXISTS corporatesubfinance CASCADE;

CREATE TABLE corporatesubfinance (
  finance_id UUID PRIMARY KEY NOT NULL,
  subfinanceid SERIAL,
  subscriberid INTEGER NOT NULL,
  amount DECIMAL(10,2) NOT NULL,
  cause VARCHAR(45) NOT NULL,
  transaction_date TIMESTAMP DEFAULT NULL,
  workorderid VARCHAR(45) NOT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN corporatesubfinance.finance_id IS 'Unique identifier for corporate subscriber finance records';


DROP TABLE IF EXISTS corporatesubscriber_ex_rew CASCADE;

CREATE TABLE corporatesubscriber_ex_rew (
  id UUID PRIMARY KEY NOT NULL,
  corid SERIAL,
  subscriberid INTEGER NOT NULL,
  workorderid VARCHAR(128) NOT NULL,
  expirydate TIMESTAMP NOT NULL,
  renewaldate TIMESTAMP NOT NULL,
  created_at TIMESTAMP NOT NULL,
  cause VARCHAR(128) DEFAULT NULL,
  monthpart VARCHAR(10) DEFAULT NULL,
  referenceno INTEGER DEFAULT NULL
);

COMMENT ON COLUMN corporatesubscriber_ex_rew.id IS 'Unique identifier for corporate subscriber expiry renewal records';


DROP TABLE IF EXISTS corporatesubscribers CASCADE;

CREATE TABLE corporatesubscribers (
  subscribers_id UUID PRIMARY KEY NOT NULL,
  cosubid SERIAL,
  username VARCHAR(64) DEFAULT NULL,
  password VARCHAR(50) DEFAULT NULL,
  subscriber VARCHAR(256) DEFAULT NULL,
  workorderid VARCHAR(45) DEFAULT NULL,
  accountstatus INTEGER NOT NULL DEFAULT 0,
  workorderstatus INTEGER NOT NULL DEFAULT 0,
  packageid VARCHAR(50) DEFAULT NULL,
  expirydate DATE DEFAULT NULL,
  activationdate DATE DEFAULT NULL,
  balance DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  partnergroupid INTEGER DEFAULT NULL,
  remarks VARCHAR(256) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NULL,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  firstuse INTEGER NOT NULL DEFAULT 1,
  office_type INTEGER DEFAULT NULL,
  validity_period INTEGER DEFAULT NULL,
  districtid VARCHAR(120) DEFAULT NULL,
  loc_code VARCHAR(50) DEFAULT NULL,
  sub_ip_address VARCHAR(128) DEFAULT NULL,
  subnet_mask VARCHAR(128) DEFAULT NULL,
  vlan_id VARCHAR(128) DEFAULT NULL,
  circuit_details VARCHAR(128) DEFAULT NULL,
  status DECIMAL(10,2) DEFAULT NULL,
  d_status INTEGER DEFAULT 1,
  d_status_date DATE DEFAULT NULL,
  vlantableid INTEGER DEFAULT NULL,
  contact_number BIGINT DEFAULT NULL,
  contact_person VARCHAR(100) DEFAULT NULL,
  cur_speed VARCHAR(100) DEFAULT NULL,
  allocted_vol VARCHAR(100) DEFAULT NULL,
  consumed_vol VARCHAR(100) DEFAULT NULL,
  fup_alert SMALLINT NOT NULL DEFAULT 0,
  last_recharged_date TIMESTAMP DEFAULT NULL,
  usage_flag SMALLINT NOT NULL DEFAULT 0,
  postuploaddata BIGINT DEFAULT NULL,
  postdownloaddata BIGINT DEFAULT NULL,
  nms_status VARCHAR(2) DEFAULT NULL,
  api_id INTEGER DEFAULT NULL,
  constituency VARCHAR(256) DEFAULT NULL,
  cus_type INTEGER DEFAULT 0
);

COMMENT ON COLUMN corporatesubscribers.subscribers_id IS 'Unique identifier for corporate subscribers records';
COMMENT ON COLUMN corporatesubscribers.accountstatus IS 'Account status flag';
COMMENT ON COLUMN corporatesubscribers.workorderstatus IS 'Work order status flag';
COMMENT ON COLUMN corporatesubscribers.fup_alert IS '0=No Alert,1=Alert Sent';
COMMENT ON COLUMN corporatesubscribers.usage_flag IS '0=Not Used,1=Used';
COMMENT ON COLUMN corporatesubscribers.nms_status IS '0=Inactive,1=Active';
COMMENT ON COLUMN corporatesubscribers.cus_type IS '1=BPL,2=End Office';


DROP TABLE IF EXISTS corporatesubscribers_temp CASCADE;

CREATE TABLE corporatesubscribers_temp (
  temp_id UUID PRIMARY KEY NOT NULL,
  cosubid BIGINT NOT NULL DEFAULT 0,
  username VARCHAR(64) DEFAULT NULL,
  subscriber VARCHAR(256) DEFAULT NULL,
  workorderid VARCHAR(45) DEFAULT NULL,
  accountstatus INTEGER NOT NULL DEFAULT 0,
  workorderstatus INTEGER NOT NULL DEFAULT 0,
  packageid INTEGER DEFAULT NULL,
  expirydate DATE DEFAULT NULL,
  activationdate DATE DEFAULT NULL,
  balance DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  partnergroupid INTEGER DEFAULT NULL,
  remarks VARCHAR(256) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NULL,
  lastupdate TIMESTAMP DEFAULT NULL,
  firstuse INTEGER NOT NULL DEFAULT 1,
  office_type INTEGER DEFAULT NULL,
  validity_period INTEGER DEFAULT NULL,
  districtid INTEGER DEFAULT NULL
);

COMMENT ON COLUMN corporatesubscribers_temp.temp_id IS 'Unique identifier for corporate subscribers temporary records';


DROP TABLE IF EXISTS cp_cannel_partner_registration CASCADE;

CREATE TABLE cp_cannel_partner_registration (
  registration_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  applicant_name VARCHAR(200) DEFAULT NULL,
  organization_name VARCHAR(200) DEFAULT NULL,
  orgtype INTEGER DEFAULT NULL,
  email_id VARCHAR(250) DEFAULT NULL,
  phone_number BIGINT DEFAULT NULL,
  gst_number VARCHAR(20) DEFAULT NULL,
  district VARCHAR(50) DEFAULT NULL,
  created_source VARCHAR(20) NOT NULL DEFAULT 'WEB',
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN cp_cannel_partner_registration.registration_id IS 'Unique identifier for channel partner registration records';












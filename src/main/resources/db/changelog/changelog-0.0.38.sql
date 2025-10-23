DROP TABLE IF EXISTS caf_details CASCADE;

CREATE TABLE caf_details (
  details_id UUID NOT NULL,
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
  CONSTRAINT pk_caf_details PRIMARY KEY (details_id)
);


DROP TABLE IF EXISTS campaign CASCADE;

CREATE TABLE campaign (
  campaign_uuid UUID NOT NULL,
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
  details_id UUID NOT NULL,
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
  breakup_id UUID NOT NULL,
  id SERIAL,
  serviceid int DEFAULT NULL,
  quoationid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  otc_cost int DEFAULT NULL,
  noof_connections int DEFAULT 0,
  discount decimal(5,1) DEFAULT 0.0,
  description varchar(250) DEFAULT NULL,
  alternate_name varchar(250) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_connection_breakup PRIMARY KEY (breakup_id)
);

COMMENT ON COLUMN ce_connection_breakup.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_connection_breakup_movement CASCADE;

CREATE TABLE ce_connection_breakup_movement (
  movement_id UUID NOT NULL,
  id SERIAL,
  breakupid int DEFAULT NULL,
  quoationid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  discount int DEFAULT 0,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_connection_breakup_movement PRIMARY KEY (movement_id)
);

COMMENT ON COLUMN ce_connection_breakup_movement.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_connection_breakup_movement_revision CASCADE;

CREATE TABLE ce_connection_breakup_movement_revision (
  revision_id UUID NOT NULL,
  id SERIAL,
  breakupid int DEFAULT NULL,
  quoationid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  discount int DEFAULT 0,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  migrated int DEFAULT NULL,
  CONSTRAINT pk_ce_connection_breakup_movement_revision PRIMARY KEY (revision_id)
);

COMMENT ON COLUMN ce_connection_breakup_movement_revision.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_customers CASCADE;

CREATE TABLE ce_customers (
  customer_id UUID NOT NULL,
  id SERIAL,
  company_name varchar(100) DEFAULT NULL,
  short_name varchar(50) DEFAULT NULL,
  contact_person varchar(50) DEFAULT NULL,
  mobile varchar(100) DEFAULT NULL,
  email varchar(250) DEFAULT NULL,
  address varchar(500) DEFAULT NULL,
  pincode varchar(6) DEFAULT NULL,
  description varchar(250) DEFAULT NULL,
  kyc_added boolean DEFAULT false,
  service_type int NOT NULL DEFAULT 1,
  pay_via_invoice boolean DEFAULT false,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  enquiry_id int DEFAULT NULL,
  company_type varchar(100) DEFAULT NULL,
  billing_category varchar(50) DEFAULT NULL,
  parent_dept_id varchar(200) DEFAULT NULL,
  enable_cdnote boolean DEFAULT false,
  location_wise_dnote boolean DEFAULT false,
  CONSTRAINT pk_ce_customers PRIMARY KEY (customer_id)
);

COMMENT ON COLUMN ce_customers.kyc_added IS '0=Not Added,1=Added';
COMMENT ON COLUMN ce_customers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_disbursement CASCADE;

CREATE TABLE ce_disbursement (
  id UUID NOT NULL,
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
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_disbursement PRIMARY KEY (id)
);

COMMENT ON COLUMN ce_disbursement.is_active IS '0=In Active,1=Active';
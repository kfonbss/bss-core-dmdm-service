-- Table : e_invoice_details
DROP TABLE IF EXISTS e_invoice_details CASCADE;

CREATE TABLE e_invoice_details (
  e_invoice_details_id UUID NOT NULL,
  id SERIAL,
  invoiceno varchar(20) DEFAULT NULL,
  invid int DEFAULT NULL,
  subid int DEFAULT NULL,
  irn varchar(300) DEFAULT NULL,
  qrcodeurl varchar(400) DEFAULT NULL,
  qrcode_image varchar(400) DEFAULT NULL,
  EinvoicePdf varchar(400) DEFAULT NULL,
  user_type int DEFAULT NULL,
  document_type int DEFAULT 1,
  -- '1=Invoice,2=CreditNote',
  seller_gst varchar(15) DEFAULT NULL,
  is_cancelled INT DEFAULT 0,
  CancelDate timestamp DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_e_invoice_details PRIMARY KEY (e_invoice_details_id)
);

-- Table : einvoice_config
DROP TABLE IF EXISTS einvoice_config CASCADE;

CREATE TABLE einvoice_config (
  einvoice_config_id UUID NOT NULL,
  id SERIAL,
  username varchar(100) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  Client_id varchar(100) DEFAULT NULL,
  Client_secret varchar(100) DEFAULT NULL,
  grant_type varchar(100) DEFAULT NULL,
  Content_Type varchar(100) DEFAULT NULL,
  end_point varchar(100) DEFAULT NULL,
  auth_token varchar(1000) DEFAULT NULL,
  auth_expiry timestamp DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_einvoice_config PRIMARY KEY (einvoice_config_id)
);


-- Table : ekyc
DROP TABLE IF EXISTS ekyc CASCADE;

CREATE TABLE ekyc (
  ekyc_id UUID NOT NULL,
  id SERIAL,
  olid int  DEFAULT NULL,
  ce_kycid int DEFAULT NULL,
  name varchar(150) DEFAULT NULL,
  gender varchar(50) DEFAULT NULL,
  co varchar(150) DEFAULT NULL,
  house varchar(200) DEFAULT NULL,
  street varchar(200) DEFAULT NULL,
  lm varchar(150) DEFAULT NULL,
  loc varchar(200) DEFAULT NULL,
  vtc varchar(150) DEFAULT NULL,
  po varchar(100) DEFAULT NULL,
  subdist varchar(100) DEFAULT NULL,
  dist varchar(100) DEFAULT NULL,
  state varchar(100) DEFAULT NULL,
  country varchar(150) DEFAULT NULL,
  pc varchar(64) DEFAULT NULL,
  dob varchar(64) DEFAULT NULL,
  photo text DEFAULT NULL,
  aadhaartranid varchar(150) DEFAULT NULL,
  createdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  txtnid varchar(150) DEFAULT NULL,
  aadharnum bigint DEFAULT NULL,
  mobilenum bigint DEFAULT NULL,
  email varchar(128) DEFAULT NULL,
  status varchar(30) DEFAULT NULL,
  subprofile bigint DEFAULT NULL,
  remarks varchar(50) DEFAULT NULL,
  addressproof varchar(256) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_ekyc PRIMARY KEY (ekyc_id)
);


-- Table : ekyc_auth_details
DROP TABLE IF EXISTS ekyc_auth_details CASCADE;

CREATE TABLE ekyc_auth_details (
  ekyc_auth_details_id UUID NOT NULL,
  Id SERIAL,
  url varchar(100) DEFAULT NULL,
  submit_url varchar(100) DEFAULT NULL,
  username varchar(50) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  Token varchar(512) DEFAULT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp NULL DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_ekyc_auth_details PRIMARY KEY (ekyc_auth_details_id)
);


-- Table : emp_plan
DROP TABLE IF EXISTS emp_plan CASCADE;

CREATE TABLE emp_plan (
  id UUID NOT NULL,
  emp_id SERIAL,
  emp_speed varchar(100) DEFAULT NULL,
  emp_rental varchar(100) DEFAULT NULL,
  emp_usage varchar(100) DEFAULT NULL,
  after_emp varchar(100) DEFAULT NULL,
  fk_state varchar(100) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_emp_plan PRIMARY KEY (id)
);


-- Table : endoffice_master
DROP TABLE IF EXISTS endoffice_master CASCADE;

CREATE TABLE endoffice_master (
  endoffice_master_id UUID NOT NULL,
  id SERIAL,
  eo varchar(256) DEFAULT NULL,
  district char(50) DEFAULT NULL,
  poptype char(50) DEFAULT NULL,
  pop varchar(256) DEFAULT NULL,
  department varchar(256) DEFAULT NULL,
  deptheadtype varchar(128) DEFAULT NULL,
  depthead varchar(256) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_endoffice_master PRIMARY KEY (endoffice_master_id)
);
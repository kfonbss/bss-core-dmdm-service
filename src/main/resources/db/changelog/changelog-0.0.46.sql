DROP TABLE IF EXISTS ce_subscriberdetails CASCADE;

CREATE TABLE ce_subscriberdetails (
  details_id UUID NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  username varchar(64) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  balance decimal(10,2) NOT NULL DEFAULT 0.00,
  expirydate date DEFAULT NULL,
  commission_date date DEFAULT NULL,
  packageid int DEFAULT NULL,
  service_provider int DEFAULT NULL,
  loc_type smallint DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  partnergroupid int DEFAULT NULL,
  status decimal(10,2) DEFAULT NULL,
  d_status int DEFAULT 1,
  d_status_date date DEFAULT NULL,
  cur_speed varchar(100) DEFAULT NULL,
  rccount int DEFAULT 0,
  last_recharge_date timestamp DEFAULT NULL,
  revenueshareid int DEFAULT NULL,
  service_oneyear_completed boolean DEFAULT false,
  dnote_expirydate date DEFAULT NULL,
  dnote_validity_date date DEFAULT NULL,
  gen_invoice int DEFAULT 1,
  partially_paid boolean DEFAULT false,
  pppoe_enabled boolean DEFAULT NULL,
  is_eo_discoverd boolean DEFAULT NULL,
  eo_upstatus boolean DEFAULT NULL,
  reason_for_down varchar(250) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_subscriberdetails PRIMARY KEY (details_id)
);

COMMENT ON COLUMN ce_subscriberdetails.loc_type IS '1-Urban,2-Rural';
COMMENT ON COLUMN ce_subscriberdetails.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_subscribers CASCADE;

CREATE TABLE ce_subscribers (
  id UUID NOT NULL,
  subscriberid SERIAL,
  username varchar(64) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  woid int DEFAULT NULL,
  customerid int DEFAULT NULL,
  group_type varchar(10) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_subscribers PRIMARY KEY (id)
);

COMMENT ON COLUMN ce_subscribers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_subscribers_document CASCADE;

CREATE TABLE ce_subscribers_document (
  document_id UUID NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  sub_document varchar(50) DEFAULT NULL,
  doc_type boolean DEFAULT false,
  remarks varchar(150) DEFAULT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT false,
  data_collected_date date DEFAULT NULL,
  hyi_flag int DEFAULT 0,
  CONSTRAINT pk_ce_subscribers_document PRIMARY KEY (document_id)
);


DROP TABLE IF EXISTS ce_subshifdetails CASCADE;

CREATE TABLE ce_subshifdetails (
  details_id UUID NOT NULL,
  id SERIAL,
  serviceprovider int DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  frompartnerid bigint DEFAULT NULL,
  topartnerid bigint DEFAULT NULL,
  slaid varchar(20) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_subshifdetails PRIMARY KEY (details_id)
);

COMMENT ON COLUMN ce_subshifdetails.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_supportsub_document CASCADE;

CREATE TABLE ce_supportsub_document (
  document_id UUID NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  caf_doc varchar(50) DEFAULT NULL,
  caf_date date DEFAULT NULL,
  agr_doc varchar(50) DEFAULT NULL,
  agr_date date DEFAULT NULL,
  icr_doc varchar(50) DEFAULT NULL,
  icr_date date DEFAULT NULL,
  preins_doc varchar(50) DEFAULT NULL,
  preins_date date DEFAULT NULL,
  postins_doc varchar(50) DEFAULT NULL,
  postins_date date DEFAULT NULL,
  network_doc varchar(50) DEFAULT NULL,
  network_date date DEFAULT NULL,
  kyc_doc varchar(50) DEFAULT NULL,
  kyc_date date DEFAULT NULL,
  hyi_doc varchar(50) DEFAULT NULL,
  hyi_date date DEFAULT NULL,
  oth_doc varchar(50) DEFAULT NULL,
  oth_date date DEFAULT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp DEFAULT CURRENT_TIMESTAMP,
  hyi_flag int DEFAULT 0,
  CONSTRAINT pk_ce_supportsub_document PRIMARY KEY (document_id)
);


DROP TABLE IF EXISTS ce_workorder CASCADE;

CREATE TABLE ce_workorder (
  workorder_id UUID NOT NULL,
  slno SERIAL,
  po_id int DEFAULT NULL,
  wo_no varchar(25) DEFAULT NULL,
  short_name varchar(25) DEFAULT NULL,
  wo_start_date date DEFAULT NULL,
  wo_end_date date DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_workorder PRIMARY KEY (workorder_id)
);

COMMENT ON COLUMN ce_workorder.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS check_xmls CASCADE;

CREATE TABLE check_xmls (
  xmls_id UUID NOT NULL,
  post text DEFAULT NULL,
  files text DEFAULT NULL,
  CONSTRAINT pk_check_xmls PRIMARY KEY (xmls_id)
);

COMMENT ON COLUMN check_xmls.xmls_id IS 'Unique identifier for check XMLs records';


DROP TABLE IF EXISTS ci_sessions CASCADE;

CREATE TABLE ci_sessions (
  sessions_id UUID NOT NULL,
  id varchar(40) NOT NULL,
  username varchar(100) DEFAULT NULL,
  ip_address varchar(45) NOT NULL,
  timestamp int NOT NULL DEFAULT 0,
  data bytea NOT NULL,
  CONSTRAINT pk_ci_sessions PRIMARY KEY (sessions_id)
);

CREATE INDEX ci_sessions_timestamp ON ci_sessions (timestamp);
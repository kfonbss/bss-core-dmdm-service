-- Table : mobile_app_version_details
DROP TABLE IF EXISTS mobile_app_version_details CASCADE;

CREATE TABLE mobile_app_version_details (
  mobile_app_version_details_id UUID NOT NULL,
  id SERIAL,
  devicetype varchar(100) DEFAULT NULL,
  latest_build_number int DEFAULT NULL,
  support_build_number int DEFAULT NULL,
  is_active int DEFAULT 1,
  -- '0=inactive,1=active',
  -- Primary key constraint
CONSTRAINT pk_mobile_app_version_details PRIMARY KEY (mobile_app_version_details_id)
);


-- Table : mobile_billing_state_list
DROP TABLE IF EXISTS mobile_billing_state_list CASCADE;

CREATE TABLE mobile_billing_state_list (
  mobile_billing_state_list_id UUID NOT NULL,
  id SERIAL,
  state_name varchar(50) DEFAULT NULL,
  state_code varchar(50) DEFAULT NULL,
  app_url varchar(50) DEFAULT NULL,
  is_active int DEFAULT 1,
  region varchar(10) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_mobile_billing_state_list PRIMARY KEY (mobile_billing_state_list_id)
);


-- Table : mobile_faqs_details
DROP TABLE IF EXISTS mobile_faqs_details CASCADE;

CREATE TABLE mobile_faqs_details (
  mobile_faqs_details_id UUID NOT NULL,
  id SERIAL,
  faq_question text DEFAULT NULL,
  faq_answer text DEFAULT NULL,
  is_active INT DEFAULT 1,
  -- Primary key constraint
CONSTRAINT pk_mobile_faqs_details PRIMARY KEY (mobile_faqs_details_id)
);


-- Table : modules
DROP TABLE IF EXISTS modules CASCADE;

CREATE TABLE modules (
  modules_id UUID NOT NULL,
  module_id int  DEFAULT NULL,
  module_name char(255) DEFAULT NULL,
  module_parent_id int DEFAULT NULL,
  category char(25) DEFAULT NULL,
  more_permissions text DEFAULT NULL,
  default_module int DEFAULT NULL,
  status int DEFAULT 0,
  created_by char(255) DEFAULT NULL,
  created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  updated_by char(255) DEFAULT NULL,
  updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_modules PRIMARY KEY (modules_id)
);


-- Table : monthgroup
DROP TABLE IF EXISTS monthgroup CASCADE;

CREATE TABLE monthgroup (
  monthgroup_id UUID NOT NULL,
  monthgroupid SERIAL,
  monthgroupname varchar(45) NOT NULL DEFAULT 0,
  startmonth int NOT NULL,
  endmonth int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_monthgroup_monthgroupname UNIQUE (monthgroupname),
  CONSTRAINT uq_monthgroup_startmonth_endmonth UNIQUE (startmonth, endmonth),
  -- Primary key constraint
CONSTRAINT pk_monthgroup PRIMARY KEY (monthgroup_id)
);


-- Table : monthlydata
DROP TABLE IF EXISTS monthlydata CASCADE;

CREATE TABLE monthlydata (
  monthlydata_id UUID NOT NULL,
  slno SERIAL,
  partnername varchar(75) DEFAULT NULL,
  netsum decimal DEFAULT NULL,
  taxno varchar(25) DEFAULT NULL,
  pan varchar(20) DEFAULT NULL,
  taxdispersed decimal DEFAULT NULL,
  railteltax decimal DEFAULT NULL,
  servicetax decimal DEFAULT NULL,
  railtelactual decimal DEFAULT NULL,
  tds float DEFAULT NULL,
  doorno varchar(50) DEFAULT NULL,
  premise varchar(150) DEFAULT NULL,
  street varchar(150) DEFAULT NULL,
  locality varchar(150) DEFAULT NULL,
  grossvalue float DEFAULT NULL,
  netvalue float DEFAULT NULL,
  comments varchar(250) DEFAULT NULL,
  state varchar(64) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_monthlydata PRIMARY KEY (monthlydata_id)
);


-- Table : monthlyinvoice
DROP TABLE IF EXISTS monthlyinvoice CASCADE;

CREATE TABLE monthlyinvoice (
  monthlyinvoice_id UUID NOT NULL,
  slno SERIAL,
  pgid int DEFAULT 0,
  subid int DEFAULT 0,
  disburseid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  disbid int DEFAULT 0,
  revenue decimal(10,2) DEFAULT 0.00,
  anpid decimal DEFAULT 0,
  anp_share decimal(12,4) DEFAULT 0.0000,
  anp_percent decimal(12,4) DEFAULT NULL,
  agpid int DEFAULT 0,
  agp_share decimal(12,4) DEFAULT 0.0000,
  agp_percent decimal(12,4) DEFAULT NULL,
  mspid int DEFAULT 0,
  msp_share decimal(12,4) DEFAULT 0.0000,
  msp_percent decimal(12,4) DEFAULT NULL,
  ispid int DEFAULT 0,
  isp_share decimal(12,4) DEFAULT 0.0000,
  isp_percent decimal(12,4) DEFAULT NULL,
  disb_date timestamp DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  statecode varchar(10) DEFAULT 0,
  pst_code varchar(10) DEFAULT 0,
  revenueshareid int DEFAULT 0,
  connType INT DEFAULT NULL,
  oldrevenueshareid int DEFAULT NULL,
  OTTprov_percent decimal(12,4) DEFAULT NULL,
  OTTprov_share decimal(12,4) DEFAULT NULL,
  OTTprov_id int DEFAULT NULL,
  revenue_type varchar(20) DEFAULT 0,
  monthpart varchar(20) DEFAULT 0,
  dot_percent decimal(12,4) DEFAULT NULL,
  cashbackelg decimal(12,4) DEFAULT 0.0000,
  prs_percent int DEFAULT 0,
  prs_share decimal(12,4) DEFAULT 0.0000,
  dot_share decimal(12,4) DEFAULT 0.0000,
  online int DEFAULT 0,
  remarks varchar(100) DEFAULT 0,
  -- Primary key constraint
CONSTRAINT pk_monthlyinvoice PRIMARY KEY (monthlyinvoice_id)
);
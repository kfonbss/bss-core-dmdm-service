DROP TABLE IF EXISTS cp_organization_type_list CASCADE;

CREATE TABLE cp_organization_type_list (
  list_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  org_id INTEGER NOT NULL,
  org_name VARCHAR(100) NOT NULL,
  is_active SMALLINT NOT NULL DEFAULT 1,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_cp_organization_type_list PRIMARY KEY (list_id)
);

COMMENT ON COLUMN cp_organization_type_list.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS created_quotation CASCADE;

CREATE TABLE created_quotation (
  quotation_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  cmpname VARCHAR(60) DEFAULT NULL,
  ref_no VARCHAR(40) NOT NULL,
  address TEXT,
  district VARCHAR(45) DEFAULT NULL,
  pincode VARCHAR(45) DEFAULT NULL,
  mobileno VARCHAR(20) DEFAULT NULL,
  contactemail VARCHAR(60) DEFAULT NULL,
  validity VARCHAR(50) DEFAULT NULL,
  payment_term VARCHAR(45) DEFAULT NULL,
  delivery_period VARCHAR(45) DEFAULT NULL,
  gstinval VARCHAR(45) DEFAULT NULL,
  post_values TEXT,
  CreatedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  pan VARCHAR(50) DEFAULT NULL,
  discount_type VARCHAR(20) DEFAULT '%',
  discount_val DECIMAL(10,2) DEFAULT 0,
  CONSTRAINT pk_created_quotation PRIMARY KEY (quotation_id)
);


DROP TABLE IF EXISTS created_quotation_requote CASCADE;

CREATE TABLE created_quotation_requote (
  requote_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  cmpname VARCHAR(60) DEFAULT NULL,
  ref_no VARCHAR(40) NOT NULL,
  address TEXT,
  district VARCHAR(45) DEFAULT NULL,
  pincode VARCHAR(45) DEFAULT NULL,
  mobileno VARCHAR(20) DEFAULT NULL,
  contactemail VARCHAR(60) DEFAULT NULL,
  validity VARCHAR(50) DEFAULT NULL,
  payment_term VARCHAR(45) DEFAULT NULL,
  delivery_period VARCHAR(45) DEFAULT NULL,
  gstinval VARCHAR(45) DEFAULT NULL,
  post_values TEXT,
  CreatedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  pan VARCHAR(50) DEFAULT NULL,
  fin_status VARCHAR(20) DEFAULT 'Pending',
  discount_type VARCHAR(15) DEFAULT '%',
  discount_val DECIMAL(10,2) DEFAULT 0,
  CONSTRAINT pk_created_quotation_requote PRIMARY KEY (requote_id)
);

COMMENT ON COLUMN created_quotation_requote.fin_status IS 'Pending,Approved,Rejected,OnHold';


DROP TABLE IF EXISTS crm_issue_mapping_list CASCADE;

CREATE TABLE crm_issue_mapping_list (
  list_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  issue_cat INTEGER DEFAULT NULL,
  issue_sub_cat INTEGER DEFAULT NULL,
  issuestype INTEGER DEFAULT NULL,
  user_access VARCHAR(100) DEFAULT 'All',
  is_active SMALLINT NOT NULL DEFAULT 1,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_crm_issue_mapping_list PRIMARY KEY (list_id)
);

COMMENT ON COLUMN crm_issue_mapping_list.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS crm_issue_mapping_list_backup CASCADE;

CREATE TABLE crm_issue_mapping_list_backup (
  backup_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  issue_cat INTEGER DEFAULT NULL,
  issue_sub_cat INTEGER DEFAULT NULL,
  issuestype INTEGER DEFAULT NULL,
  is_active SMALLINT NOT NULL DEFAULT 1,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_crm_issue_mapping_list_backup PRIMARY KEY (backup_id)
);

COMMENT ON COLUMN crm_issue_mapping_list_backup.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS crm_msptarget CASCADE;

CREATE TABLE crm_msptarget (
  msptarget_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  mspid VARCHAR(20) DEFAULT NULL,
  statecode VARCHAR(5) DEFAULT NULL,
  partnerexp INTEGER DEFAULT NULL,
  subexp INTEGER DEFAULT NULL,
  monthpart VARCHAR(10) DEFAULT NULL,
  CONSTRAINT pk_crm_msptarget PRIMARY KEY (msptarget_id)
);


DROP TABLE IF EXISTS crm_support_persons_actual CASCADE;

CREATE TABLE crm_support_persons_actual (
  actual_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  createdby VARCHAR(100) DEFAULT NULL,
  subscriber VARCHAR(100) DEFAULT NULL,
  peakL1 INTEGER DEFAULT NULL,
  nonpeakL1 INTEGER DEFAULT NULL,
  totalL1 INTEGER DEFAULT NULL,
  L2 INTEGER DEFAULT NULL,
  date TIMESTAMP DEFAULT NULL,
  time_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  monthyear VARCHAR(10) DEFAULT NULL,
  CONSTRAINT pk_crm_support_persons_actual PRIMARY KEY (actual_id)
);


DROP TABLE IF EXISTS crmusers CASCADE;

CREATE TABLE crmusers (
  crmusers_id UUID DEFAULT gen_random_uuid() NOT NULL,
  username VARCHAR(128) NOT NULL,
  role VARCHAR(50) DEFAULT NULL,
  remarks VARCHAR(128) DEFAULT NULL,
  level VARCHAR(50) DEFAULT NULL,
  slno SERIAL,
  statecode VARCHAR(45) DEFAULT NULL,
  CONSTRAINT pk_crmusers PRIMARY KEY (crmusers_id)
);


DROP TABLE IF EXISTS crossroad CASCADE;

CREATE TABLE crossroad (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  crossroadid SERIAL,
  crossroadname VARCHAR(250) DEFAULT NULL,
  CONSTRAINT pk_crossroad PRIMARY KEY (id)
);

-- Table : monthlyreport
DROP TABLE IF EXISTS monthlyreport CASCADE;

CREATE TABLE monthlyreport (
  monthlyreport_id UUID NOT NULL,
  slno SERIAL,
  partnername varchar(75) DEFAULT NULL,
  netsum decimal DEFAULT NULL,
  taxno varchar(50) DEFAULT NULL,
  pan varchar(20) DEFAULT NULL,
  dot int DEFAULT NULL,
  rly int DEFAULT NULL,
  servicetax float DEFAULT NULL,
  taxYes varchar(1) DEFAULT NULL,
  tds decimal DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  isp varchar(10) DEFAULT NULL,
  cnp varchar(10) DEFAULT NULL,
  agpR varchar(20) DEFAULT NULL,
  grossvalue decimal DEFAULT NULL,
  netvalue decimal DEFAULT NULL,
  comments varchar(250) DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  agpL varchar(10) DEFAULT NULL,
  mkt varchar(10) DEFAULT NULL,
  msp varchar(10) DEFAULT NULL,
  anp varchar(10) DEFAULT NULL,
  ibnp varchar(10) DEFAULT NULL,
  ibwp varchar(10) DEFAULT NULL,
  firstsum int DEFAULT NULL,
  agpOtherLco int DEFAULT NULL,
  agramt int DEFAULT NULL,
  owneranp varchar(20) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_monthlyreport PRIMARY KEY (monthlyreport_id)
);


-- Table : mrk_marketing_list
DROP TABLE IF EXISTS mrk_marketing_list CASCADE;

CREATE TABLE mrk_marketing_list (
  mrk_marketing_list_id UUID NOT NULL,
  id SERIAL,
  marketing_type_id int NOT NULL,
  type_name varchar(200) DEFAULT NULL,
  is_active INT NOT NULL DEFAULT 1,
  created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_mrk_marketing_list_marketing_type_id UNIQUE (marketing_type_id),
  -- Primary key constraint
CONSTRAINT pk_mrk_marketing_list PRIMARY KEY (mrk_marketing_list_id)
);


-- Table : mrk_marketingdetails
DROP TABLE IF EXISTS mrk_marketingdetails CASCADE;

CREATE TABLE mrk_marketingdetails (
  mrk_marketingdetails_id UUID NOT NULL,
  id SERIAL,
  partnerid varchar(100) NOT NULL,
  marketing_type varchar(150) NOT NULL,
  brochure_quantity int DEFAULT 0,
  subscriber_count int DEFAULT 0,
  height_x decimal(10,0) DEFAULT NULL,
  width decimal(10,0) DEFAULT NULL,
  contactno_tobeprint bigint DEFAULT NULL,
  name_tobeprint varchar(200) DEFAULT NULL,
  status int NOT NULL DEFAULT 0,
  is_active INT NOT NULL DEFAULT 1,
  remarks text DEFAULT NULL,
  created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar(100) NOT NULL,
  modified_by varchar(100) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_mrk_marketingdetails PRIMARY KEY (mrk_marketingdetails_id)
);


-- Table : mrk_marketingdetails_movement
DROP TABLE IF EXISTS mrk_marketingdetails_movement CASCADE;

CREATE TABLE mrk_marketingdetails_movement (
  mrk_marketingdetails_movement_id UUID NOT NULL,
  id SERIAL,
  tracking_field varchar(200) DEFAULT NULL,
  tracking_field_values varchar(200) DEFAULT NULL,
  status int NOT NULL DEFAULT 0,
  remarks text DEFAULT NULL,
  created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar(100) DEFAULT NULL,
  marketing_id int NOT NULL,
  -- Primary key constraint
CONSTRAINT pk_mrk_marketingdetails_movement PRIMARY KEY (mrk_marketingdetails_movement_id)
);


-- Table : msp_details
DROP TABLE IF EXISTS msp_details CASCADE;

CREATE TABLE msp_details (
  msp_details_id UUID NOT NULL,
  id SERIAL,
  msp_name varchar(300) DEFAULT NULL,
  msp_address varchar(1000) DEFAULT NULL,
  terre_office varchar(1000) DEFAULT NULL,
  enquires varchar(500) DEFAULT NULL,
  fk_state varchar(30) DEFAULT NULL,
  phone varchar(30) DEFAULT NULL,
  region_office_zone varchar(300) DEFAULT NULL,
  region_office_address varchar(1000) DEFAULT NULL,
  feedback_email varchar(300) DEFAULT NULL,
  contact_details varchar(1000) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_msp_details PRIMARY KEY (msp_details_id)
);


-- Table : msp_sentsms
DROP TABLE IF EXISTS msp_sentsms CASCADE;

CREATE TABLE msp_sentsms (
  msp_sentsms_id UUID NOT NULL,
  id SERIAL,
  subscriberid int DEFAULT NULL,
  mobileno int DEFAULT NULL,
  partnerid varchar(45) DEFAULT NULL,
  partnername varchar(150) DEFAULT NULL,
  templateid int DEFAULT NULL,
  parameters varchar(100) DEFAULT NULL,
  status varchar(25) DEFAULT NULL,
  response varchar(300) DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  initiated_time timestamp DEFAULT NULL,
  sentime timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_msp_sentsms PRIMARY KEY (msp_sentsms_id)
);


-- Table : msplnp_status_master
DROP TABLE IF EXISTS msplnp_status_master CASCADE;

CREATE TABLE msplnp_status_master (
  msplnp_status_master_id UUID NOT NULL,
  id int NOT NULL,
  status_code varchar(30) NOT NULL,
  status_name varchar(50) NOT NULL,
  description text DEFAULT NULL,
  next_possible_statuses varchar(50) DEFAULT NULL,
  rejection_type varchar(20) DEFAULT NULL,
  is_active INT DEFAULT 1,
  order_sequence int DEFAULT NULL,
  badge_class varchar(50) DEFAULT NULL,
  created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_msplnp_status_master_status_code UNIQUE (status_code),
  -- Primary key constraint
CONSTRAINT pk_msplnp_status_master PRIMARY KEY (msplnp_status_master_id)
);


-- Table : msplnp_ticket_documents
DROP TABLE IF EXISTS msplnp_ticket_documents CASCADE;

CREATE TABLE msplnp_ticket_documents (
  msplnp_ticket_documents_id UUID NOT NULL,
  id SERIAL,
  ticket_id int NOT NULL,
  document_type varchar(50) NOT NULL,
  file_path varchar(255) NOT NULL,
  uploaded_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  uploaded_by int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_msplnp_ticket_documents PRIMARY KEY (msplnp_ticket_documents_id)
);


-- Table : msplnp_ticket_history
DROP TABLE IF EXISTS msplnp_ticket_history CASCADE;

CREATE TABLE msplnp_ticket_history (
  msplnp_ticket_history_id UUID NOT NULL,
  id SERIAL,
  ticket_id int NOT NULL,
  status varchar(50) NOT NULL,
  remarks text DEFAULT NULL,
  updated_by varchar(100) DEFAULT NULL,
  created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_msplnp_ticket_history PRIMARY KEY (msplnp_ticket_history_id)
);
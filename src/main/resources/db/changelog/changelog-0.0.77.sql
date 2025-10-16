-- Table : gri_tickets_dup
DROP TABLE IF EXISTS gri_tickets_dup CASCADE;

CREATE TABLE gri_tickets_dup (
  gri_tickets_dup_id UUID NOT NULL,
  id SERIAL,
  ticketid bigint NOT NULL,
  incident_dt timestamp DEFAULT NULL,
  submit_date timestamp DEFAULT NULL,
  due_date timestamp DEFAULT NULL,
  servicetype varchar(50) DEFAULT NULL,
  ticket_type varchar(50) DEFAULT NULL,
  complaint_type varchar(30) DEFAULT NULL,
  helpdesk varchar(10) DEFAULT NULL,
  source int DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  username varchar(256) DEFAULT NULL,
  created_by varchar(45) DEFAULT NULL,
  assignedto varchar(45) DEFAULT NULL,
  assignedto_type char(5) DEFAULT NULL,
  subject text DEFAULT NULL,
  description text DEFAULT NULL,
  priority varchar(45) DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  region varchar(50) DEFAULT NULL,
  mobile varchar(20) DEFAULT NULL,
  email varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  updated_dt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_gri_tickets_dup PRIMARY KEY (gri_tickets_dup_id)
);


-- Table : groups
DROP TABLE IF EXISTS groups CASCADE;

CREATE TABLE groups (
  groups_id UUID NOT NULL,
  id int  DEFAULT NULL,
  name varchar(20) NOT NULL,
  description varchar(100) NOT NULL,
  bgcolor char(7) NOT NULL DEFAULT '#607D8B',
  -- Primary key constraint
CONSTRAINT pk_groups PRIMARY KEY (groups_id)
);


-- Table : gst_verification_details
DROP TABLE IF EXISTS gst_verification_details CASCADE;

CREATE TABLE gst_verification_details (
  gst_verification_details_id UUID NOT NULL,
  id SERIAL,
  partnerid varchar(50) DEFAULT NULL,
  partnercompanyname varchar(150) DEFAULT NULL,
  keycontactemail varchar(128) DEFAULT NULL,
  ptype char(5) DEFAULT NULL,
  gstin_in_bss varchar(60) DEFAULT NULL,
  taxpayertype_in_bss varchar(1) DEFAULT NULL,
  taxpayertype_in_portal INT DEFAULT NULL,
  gstin_status_inportal varchar(50) DEFAULT NULL,
  gstin_cancellation_date date DEFAULT NULL,
  is_taxtype_mismatch int DEFAULT 0,
  -- '0=Not Missmatched,1=Missmatched',
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  is_mail_sent int DEFAULT 0,
  -- '0=Mail Not Sent,1=Mail hasbeen Sent',
  created_date timestamp DEFAULT NULL,
  updated_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_gst_verification_details PRIMARY KEY (gst_verification_details_id)
);


-- Table : gstvalet_movement
DROP TABLE IF EXISTS gstvalet_movement CASCADE;

CREATE TABLE gstvalet_movement (
  gstvalet_movement_id UUID NOT NULL,
  noteid SERIAL,
  gstvalet_tid int DEFAULT NULL,
  note varchar(255) DEFAULT NULL,
  created_by varchar(64) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  gst_invoiceno varchar(25) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_gstvalet_movement PRIMARY KEY (gstvalet_movement_id)
);


-- Table : helpdesk
DROP TABLE IF EXISTS helpdesk CASCADE;

CREATE TABLE helpdesk (
  helpdesk_id UUID NOT NULL,
  deskid SERIAL,
  helpdesk varchar(64) DEFAULT NULL,
  description varchar(128) DEFAULT NULL,
  manager varchar(45) DEFAULT NULL,
  manager_type char(5) DEFAULT NULL,
  manager_email varchar(256) DEFAULT NULL,
  manager_mobile varchar(15) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  lastupdate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_helpdesk PRIMARY KEY (helpdesk_id)
);


-- Table : idprooftype
DROP TABLE IF EXISTS idprooftype CASCADE;

CREATE TABLE idprooftype (
  idprooftype_id UUID NOT NULL,
  idprooftypeid SERIAL,
  idprooftype varchar(45) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_idprooftype_idprooftype UNIQUE (idprooftype),
  -- Primary key constraint
CONSTRAINT pk_idprooftype PRIMARY KEY (idprooftype_id)
);


-- Table : ikm_pg
DROP TABLE IF EXISTS ikm_pg CASCADE;

CREATE TABLE ikm_pg (
  ikm_pg_id UUID NOT NULL,
  id SERIAL,
  company_id varchar(10) DEFAULT NULL,
  client_id int DEFAULT NULL,
  service varchar(10) DEFAULT NULL,
  payment_id varchar(50) DEFAULT NULL,
  amount varchar(50) DEFAULT NULL,
  transaction_currency char(3) DEFAULT NULL,
  pgtuid varchar(50) DEFAULT NULL,
  emailid varchar(50) DEFAULT NULL,
  mobileno varchar(12) DEFAULT NULL,
  pgreference_id varchar(50) DEFAULT NULL,
  bankreference_id varchar(50) DEFAULT NULL,
  transaction_dt timestamp DEFAULT NULL,
  response_page varchar(100) DEFAULT NULL,
  transaction_status varchar(20) DEFAULT NULL,
  status_message varchar(512) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  partnerid varchar(50) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_ikm_pg PRIMARY KEY (ikm_pg_id)
);


-- Table : inactsub_feedback
DROP TABLE IF EXISTS inactsub_feedback CASCADE;

CREATE TABLE inactsub_feedback (
  inactsub_feedback_id UUID NOT NULL,
  id SERIAL,
  subscriberid int DEFAULT NULL,
  subscriber varchar(100) DEFAULT NULL,
  remarks varchar(256) DEFAULT NULL,
  rate varchar(30) DEFAULT NULL,
  feedback varchar(256) DEFAULT NULL,
  circle char(10) DEFAULT NULL,
  expiry timestamp DEFAULT NULL,
  created timestamp DEFAULT NULL,
  submiited_by varchar(50) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_inactsub_feedback PRIMARY KEY (inactsub_feedback_id)
);


-- Table : inactsub_remarks
DROP TABLE IF EXISTS inactsub_remarks CASCADE;

CREATE TABLE inactsub_remarks (
  inactsub_remarks_id UUID NOT NULL,
  id SERIAL,
  remarks varchar(100) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_inactsub_remarks PRIMARY KEY (inactsub_remarks_id)
);


-- Table : inbound_sms
DROP TABLE IF EXISTS inbound_sms CASCADE;

CREATE TABLE inbound_sms (
  inbound_sms_id UUID NOT NULL,
  id SERIAL,
  from_mobile varchar(12) DEFAULT NULL,
  dest_mobile varchar(12) DEFAULT NULL,
  msg varchar(2000) DEFAULT NULL,
  time timestamp DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inbound_sms PRIMARY KEY (inbound_sms_id)
);


-- Table : incentive
DROP TABLE IF EXISTS incentive CASCADE;

CREATE TABLE incentive (
  incentive_id UUID NOT NULL,
  slno SERIAL,
  partnerid int DEFAULT NULL,
  incentive decimal(10,2) DEFAULT NULL,
  monthpart varchar(10) DEFAULT NULL,
  weeklyshare decimal(10,2) DEFAULT NULL,
  elgsub int DEFAULT NULL,
  unqsub int DEFAULT NULL,
  elgrevenue decimal(13,2) DEFAULT NULL,
  remarks varchar(64) DEFAULT NULL,
  pgid int DEFAULT NULL,
  elgagr decimal(13,2) NOT NULL DEFAULT 0.00,
  totalrevenue decimal(13,2) NOT NULL DEFAULT 0.00,
  -- Primary key constraint
CONSTRAINT pk_incentive PRIMARY KEY (incentive_id)
);
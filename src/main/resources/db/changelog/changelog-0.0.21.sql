DROP TABLE IF EXISTS admin CASCADE;

CREATE TABLE admin (
  admin_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  category varchar(255) NOT NULL,
  status int NOT NULL,
  CONSTRAINT pk_admin PRIMARY KEY (admin_id)
);


DROP TABLE IF EXISTS admin_preferences CASCADE;

CREATE TABLE admin_preferences (
  preferences_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  user_panel boolean NOT NULL DEFAULT false,
  sidebar_form boolean NOT NULL DEFAULT false,
  messages_menu boolean NOT NULL DEFAULT false,
  notifications_menu boolean NOT NULL DEFAULT false,
  tasks_menu boolean NOT NULL DEFAULT false,
  user_menu boolean NOT NULL DEFAULT true,
  ctrl_sidebar boolean NOT NULL DEFAULT false,
  transition_page boolean NOT NULL DEFAULT false,
  CONSTRAINT pk_admin_preferences PRIMARY KEY (preferences_id)
);


DROP TABLE IF EXISTS advance_topup_receipt CASCADE;

CREATE TABLE advance_topup_receipt (
  receipt_id UUID DEFAULT gen_random_uuid() NOT NULL,
  receiptid BIGSERIAL,
  receipt_no varchar(45) DEFAULT NULL,
  receipt_date timestamp DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  partnercompanyname varchar(120) DEFAULT NULL,
  billing_from date DEFAULT NULL,
  billing_to date DEFAULT NULL,
  placeofsupply varchar(120) DEFAULT NULL,
  subscriber_name varchar(100) DEFAULT NULL,
  subscriber_address varchar(256) DEFAULT NULL,
  subscriber_gstin char(16) DEFAULT NULL,
  username varchar(64) DEFAULT NULL,
  packageid int DEFAULT NULL,
  packagename varchar(64) DEFAULT NULL,
  railtel_gstin varchar(45) DEFAULT NULL,
  railtel_pan varchar(45) DEFAULT NULL,
  railtel_sac varchar(45) DEFAULT NULL,
  state_railtel_address varchar(256) DEFAULT NULL,
  mspid varchar(45) DEFAULT NULL,
  cc_address1 varchar(80) DEFAULT NULL,
  cc_address2 varchar(80) DEFAULT NULL,
  cc_address3 varchar(80) DEFAULT NULL,
  cc_address4 varchar(80) DEFAULT NULL,
  particulars varchar(80) DEFAULT NULL,
  taxablevalue decimal(12,2) DEFAULT NULL,
  cgst_rate decimal(12,2) DEFAULT NULL,
  cgst_value decimal(12,2) DEFAULT NULL,
  sgst_rate decimal(12,2) DEFAULT NULL,
  sgst_value decimal(12,2) DEFAULT NULL,
  igst_rate decimal(12,2) DEFAULT NULL,
  igst_value decimal(12,2) DEFAULT NULL,
  total_receipt_value decimal(12,2) DEFAULT NULL,
  total_receipt_value_words varchar(150) DEFAULT NULL,
  gst_status smallint DEFAULT NULL,
  CONSTRAINT pk_advance_topup_receipt PRIMARY KEY (receipt_id)
);


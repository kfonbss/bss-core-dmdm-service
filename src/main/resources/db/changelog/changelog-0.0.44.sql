DROP TABLE IF EXISTS ce_sub_package CASCADE;

CREATE TABLE ce_sub_package (
  ce_sub_package_id UUID PRIMARY KEY NOT NULL,
  sub_packageid SERIAL,
  packageid int NOT NULL,
  sub_renewperiod int DEFAULT 0,
  sub_renewalfee double precision DEFAULT 0,
  service_cat int DEFAULT 0,
  description varchar(250) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true
);

COMMENT ON COLUMN ce_sub_package.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_sub_package.ce_sub_package_id IS 'Unique identifier for CE sub package records';


DROP TABLE IF EXISTS ce_sub_package_renewal_history CASCADE;

CREATE TABLE ce_sub_package_renewal_history (
  ce_sub_package_renewal_history_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  sub_packageid int DEFAULT NULL,
  mg_invoiceid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  total_sdays int DEFAULT 0,
  lrhid int DEFAULT NULL,
  discount_percent decimal(5,1) DEFAULT NULL,
  disount_amount decimal(26,10) DEFAULT NULL,
  original_renewalfee decimal(26,10) DEFAULT NULL,
  renewalfee_after_disount decimal(26,10) DEFAULT NULL,
  cost_per_day decimal(26,10) DEFAULT NULL,
  loc_amount decimal(26,10) DEFAULT NULL,
  loc_gst_amount decimal(26,10) DEFAULT NULL,
  loc_grand_amount decimal(26,10) DEFAULT NULL,
  description varchar(250) DEFAULT NULL,
  service_cat int DEFAULT 0,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_sub_package_renewal_history.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_sub_package_renewal_history.ce_sub_package_renewal_history_id IS 'Unique identifier for CE sub package renewal history records';

DROP TABLE IF EXISTS ce_sub_service_list CASCADE;

CREATE TABLE ce_sub_service_list (
  ce_sub_service_list_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  ce_service_id int DEFAULT NULL,
  serviceid int DEFAULT NULL,
  servicename varchar(50) DEFAULT NULL,
  sname_short varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_sub_service_list.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_sub_service_list.ce_sub_service_list_id IS 'Unique identifier for CE sub service list records';


DROP TABLE IF EXISTS ce_subfinance CASCADE;

CREATE TABLE ce_subfinance (
  ce_subfinance_id UUID PRIMARY KEY NOT NULL,
  subfinanceid SERIAL,
  subscriberid int NOT NULL,
  amount decimal(10,2) NOT NULL,
  cause varchar(45) NOT NULL,
  locid int DEFAULT NULL,
  rstatus boolean DEFAULT false,
  subonlineref bigint DEFAULT NULL,
  subid bigint DEFAULT NULL,
  packageid int DEFAULT NULL,
  finrefid int DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true
);

COMMENT ON COLUMN ce_subfinance.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_subfinance.ce_subfinance_id IS 'Unique identifier for CE subfinance records';


DROP TABLE IF EXISTS ce_subonlinerecharge CASCADE;

CREATE TABLE ce_subonlinerecharge (
  ce_subonlinerecharge_id UUID PRIMARY KEY NOT NULL,
  id BIGSERIAL,
  ordernumber varchar(64) DEFAULT NULL,
  status char(18) DEFAULT NULL,
  amount decimal(13,2) DEFAULT NULL,
  order_time timestamp DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  txnid varchar(64) DEFAULT NULL,
  banktxnid varchar(64) DEFAULT NULL,
  txnamout decimal(13,2) DEFAULT NULL,
  txndate timestamp DEFAULT NULL,
  currency varchar(5) DEFAULT NULL,
  respcode varchar(45) DEFAULT NULL,
  respmsg varchar(500) DEFAULT NULL,
  gatewayname varchar(45) DEFAULT NULL,
  bankname varchar(256) DEFAULT NULL,
  paymentmode varchar(45) DEFAULT NULL,
  ErrorStatus varchar(100) DEFAULT NULL,
  ErrorDescription varchar(200) DEFAULT NULL,
  lnpshare decimal(20,2) DEFAULT 0.00,
  kfonshare decimal(20,2) DEFAULT 0.00,
  flag boolean DEFAULT false,
  partially_paid boolean DEFAULT false,
  packageid int DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  rechargesite smallint DEFAULT 1,
  paymnetgateway int DEFAULT 1,
  invoiceid int DEFAULT NULL
);

CREATE UNIQUE INDEX ordernumber_unique ON ce_subonlinerecharge (ordernumber);
CREATE INDEX p_idx ON ce_subonlinerecharge (subscriberid);

COMMENT ON COLUMN ce_subonlinerecharge.rechargesite IS '1=BSS,2=Others';
COMMENT ON COLUMN ce_subonlinerecharge.paymnetgateway IS '1=IKM,2=HDFC,3=Others';
COMMENT ON COLUMN ce_subonlinerecharge.ce_subonlinerecharge_id IS 'Unique identifier for CE subscriber online recharge records';


DROP TABLE IF EXISTS ce_subscriberdetails CASCADE;

CREATE TABLE ce_subscriberdetails (
  ce_subscriberdetails_id UUID PRIMARY KEY NOT NULL,
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
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_subscriberdetails.loc_type IS '1-Urban,2-Rural';
COMMENT ON COLUMN ce_subscriberdetails.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_subscriberdetails.ce_subscriberdetails_id IS 'Unique identifier for CE subscriber details records';
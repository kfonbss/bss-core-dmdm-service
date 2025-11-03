DROP TABLE IF EXISTS ce_sub_package CASCADE;

CREATE TABLE ce_sub_package (
  package_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active boolean,
  sub_packageid SERIAL,
  packageid int NOT NULL,
  sub_renewperiod int DEFAULT 0,
  sub_renewalfee double precision DEFAULT 0,
  service_cat int DEFAULT 0,
  description varchar(250) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_sub_package PRIMARY KEY (package_id)
);

INSERT INTO ce_sub_package (
    package_id, code, name, name_in_local, is_active, sub_packageid, packageid,
    sub_renewperiod, sub_renewalfee, service_cat, description, created_date, modified_date,
    created_by, modified_by
) VALUES (
    gen_random_uuid(), 'PKG001', 'Internet Sub Package', 'ഇന്റർനെറ്റ് സബ് പാക്കേജ്',
    true, 1, 101, 12, 1500.00, 2, 'Monthly renewal for broadband service',
    CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_sub_package_renewal_history CASCADE;

CREATE TABLE ce_sub_package_renewal_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active boolean,
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
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_sub_package_renewal_history PRIMARY KEY (history_id)
);
INSERT INTO ce_sub_package_renewal_history (
    history_id, code, name, name_in_local, is_active, id, locid, sub_packageid, mg_invoiceid, subfinanceid,
    total_sdays, lrhid, discount_percent, disount_amount, original_renewalfee, renewalfee_after_disount,
    cost_per_day, loc_amount, loc_gst_amount, loc_grand_amount, description, service_cat, created_date,
    modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'HIS001', 'Sub Package Renewal', 'സബ് പാക്കേജ് പുതുക്കൽ', true, 1, 1001, 501, 7001, 8001,
    30, 9001, 10.0, 500.0000000000, 5000.0000000000, 4500.0000000000, 166.6666666667,
    4500.0000000000, 810.0000000000, 5310.0000000000, 'Renewed for next billing cycle',
    2, CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_sub_service_list CASCADE;

CREATE TABLE ce_sub_service_list (
  list_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  ce_service_id int DEFAULT NULL,
  serviceid int DEFAULT NULL,
  servicename varchar(50) DEFAULT NULL,
  sname_short varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_sub_service_list PRIMARY KEY (list_id)
);

COMMENT ON COLUMN ce_sub_service_list.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_subfinance CASCADE;

CREATE TABLE ce_subfinance (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_subfinance PRIMARY KEY (id)
);

COMMENT ON COLUMN ce_subfinance.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_subonlinerecharge CASCADE;

CREATE TABLE ce_subonlinerecharge (
  recharge_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  invoiceid int DEFAULT NULL,
  CONSTRAINT pk_ce_subonlinerecharge PRIMARY KEY (recharge_id)
);

CREATE UNIQUE INDEX ordernumber_unique ON ce_subonlinerecharge (ordernumber);
CREATE INDEX idx_ce_recharge_subid ON ce_subonlinerecharge (subscriberid);

COMMENT ON COLUMN ce_subonlinerecharge.rechargesite IS '1=BSS,2=Others';
COMMENT ON COLUMN ce_subonlinerecharge.paymnetgateway IS '1=IKM,2=HDFC,3=Others';


DROP TABLE IF EXISTS ce_subscriberdetails CASCADE;

CREATE TABLE ce_subscriberdetails (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
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

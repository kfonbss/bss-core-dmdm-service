-- Table : kapartnergroup
DROP TABLE IF EXISTS kapartnergroup CASCADE;

CREATE TABLE kapartnergroup (
  kapartnergroup_id UUID NOT NULL,
  id SERIAL,
  partnergroupid int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_kapartnergroup PRIMARY KEY (kapartnergroup_id)
);


-- Table : kapartners
DROP TABLE IF EXISTS kapartners CASCADE;

CREATE TABLE kapartners (
  kapartners_id UUID NOT NULL,
  id SERIAL,
  partnerid int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_kapartners PRIMARY KEY (kapartners_id)
);


-- Table : keys
DROP TABLE IF EXISTS keys CASCADE;

CREATE TABLE keys (
  keys_id UUID NOT NULL,
  id SERIAL,
  user_id int NOT NULL,
  key varchar(40) NOT NULL,
  level int NOT NULL,
  ignore_limits INT NOT NULL DEFAULT 0,
  is_private_key INT NOT NULL DEFAULT 0,
  ip_addresses text DEFAULT NULL,
  date_created int NOT NULL,
  -- Primary key constraint
CONSTRAINT pk_keys PRIMARY KEY (keys_id)
);


-- Table : kfon_users
DROP TABLE IF EXISTS kfon_users CASCADE;

CREATE TABLE kfon_users (
  kfon_users_id UUID NOT NULL,
  id SERIAL,
  loc_code varchar(20) DEFAULT NULL,
  username varchar(100) DEFAULT NULL,
  activationdt timestamp DEFAULT NULL,
  expirydt timestamp DEFAULT NULL,
  plan varchar(100) DEFAULT NULL,
  district varchar(100) DEFAULT NULL,
  CONSTRAINT uq_kfon_users_username UNIQUE (username),
  -- Primary key constraint
CONSTRAINT pk_kfon_users PRIMARY KEY (kfon_users_id)
);


-- Table : kl_recover
DROP TABLE IF EXISTS kl_recover CASCADE;

CREATE TABLE kl_recover (
  kl_recover_id UUID NOT NULL,
  scode varchar(40) NOT NULL,
  amt decimal(10,2) NOT NULL,
  -- Primary key constraint
CONSTRAINT pk_kl_recover PRIMARY KEY (kl_recover_id)
);


-- Table : klc
DROP TABLE IF EXISTS klc CASCADE;

CREATE TABLE klc (
  klc_id UUID NOT NULL,
  sid int DEFAULT NULL,
  uname varchar(200) DEFAULT NULL,
  oldp int DEFAULT NULL,
  newp int DEFAULT NULL,
  oldpgid int DEFAULT NULL,
  newpgid int DEFAULT NULL,
  bal decimal(10,2) DEFAULT NULL,
  vlan int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_klc PRIMARY KEY (klc_id)
);


-- Table : kyc_login
DROP TABLE IF EXISTS kyc_login CASCADE;

CREATE TABLE kyc_login (
  kyc_login_id UUID NOT NULL,
  id SERIAL,
  username varchar(50) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  status int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_kyc_login PRIMARY KEY (kyc_login_id)
);


-- Table : kyc_logs
DROP TABLE IF EXISTS kyc_logs CASCADE;

CREATE TABLE kyc_logs (
  kyc_logs_id UUID NOT NULL,
  id SERIAL,
  loc_code varchar(20) DEFAULT NULL,
  error_details text DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_kyc_logs PRIMARY KEY (kyc_logs_id)
);


-- Table : kyc_update_detail
DROP TABLE IF EXISTS kyc_update_detail CASCADE;

CREATE TABLE kyc_update_detail (
  kyc_update_detail_id UUID NOT NULL,
  id SERIAL,
  olid bigint DEFAULT NULL,
  updatedby int DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  updated_date timestamp DEFAULT NULL,
  status int DEFAULT NULL,
  statusupdatedby int DEFAULT NULL,
  statusupdateddate timestamp DEFAULT NULL,
  review varchar(255) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_kyc_update_detail PRIMARY KEY (kyc_update_detail_id)
);

-- Create indexes for better performance
CREATE INDEX idx_kyc_update_detail_olid ON kyc_update_detail (olid);
CREATE INDEX idx_kyc_update_detail_updatedby ON kyc_update_detail (updatedby);

-- Table : lb_master
DROP TABLE IF EXISTS lb_master CASCADE;

CREATE TABLE lb_master (
  lb_master_id UUID NOT NULL,
  id SERIAL,
  LBID int DEFAULT NULL,
  LBNameLoc varchar(156) DEFAULT NULL,
  LBName varchar(156) DEFAULT NULL,
  intLBTypeID varchar(156) DEFAULT NULL,
  BlockID int DEFAULT NULL,
  BlockName varchar(156) DEFAULT NULL,
  DistId int DEFAULT NULL,
  District varchar(156) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_lb_master PRIMARY KEY (lb_master_id)
);


-- Table : lco_agp_approve
DROP TABLE IF EXISTS lco_agp_approve CASCADE;

CREATE TABLE lco_agp_approve (
  lco_agp_approve_id UUID NOT NULL,
  slno SERIAL,
  imonth varchar(10) DEFAULT NULL,
  approvedby varchar(100) DEFAULT NULL,
  status varchar(20) DEFAULT NULL,
  statecode varchar(5) DEFAULT NULL,
  time_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  approvedon timestamp DEFAULT NULL,
  remarks varchar(250) DEFAULT NULL,
  modifiedby varchar(100) DEFAULT NULL,
  modifiedon timestamp DEFAULT NULL,
  spocapproval varchar(25) DEFAULT NULL,
  spocapprovedate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_lco_agp_approve PRIMARY KEY (lco_agp_approve_id)
);


-- Table : lco_agp_list
DROP TABLE IF EXISTS lco_agp_list CASCADE;

CREATE TABLE lco_agp_list (
  lco_agp_list_id UUID NOT NULL,
  slno SERIAL,
  imonth varchar(10) DEFAULT NULL,
  partnerid varchar(25) DEFAULT NULL,
  partnername varchar(150) DEFAULT NULL,
  statecode varchar(5) DEFAULT NULL,
  agpid varchar(25) DEFAULT NULL,
  agpname varchar(150) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_lco_agp_list PRIMARY KEY (lco_agp_list_id)
);


-- Table : lco_mobilenos
DROP TABLE IF EXISTS lco_mobilenos CASCADE;

CREATE TABLE lco_mobilenos (
  lco_mobilenos_id UUID NOT NULL,
  id SERIAL,
  mobile varchar(12) DEFAULT NULL,
  sms_sent int DEFAULT 0,
  -- Primary key constraint
CONSTRAINT pk_lco_mobilenos PRIMARY KEY (lco_mobilenos_id)
);


-- Table : limits
DROP TABLE IF EXISTS limits CASCADE;

CREATE TABLE limits (
  limits_id UUID NOT NULL,
  id SERIAL,
  uri varchar(255) NOT NULL,
  count int NOT NULL,
  hour_started int NOT NULL,
  api_key varchar(40) NOT NULL,
  -- Primary key constraint
CONSTRAINT pk_limits PRIMARY KEY (limits_id)
);
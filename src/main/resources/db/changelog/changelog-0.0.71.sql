-- Table : discovered_offices
DROP TABLE IF EXISTS discovered_offices CASCADE;

CREATE TABLE discovered_offices (
  discovered_offices_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  domain_name varchar(20) DEFAULT NULL,
  state varchar(20) DEFAULT NULL,
  district varchar(128) DEFAULT NULL,
  pop varchar(128) DEFAULT NULL,
  vendor varchar(128) DEFAULT NULL,
  olt_ipaddress varchar(20) DEFAULT NULL,
  olt_hostname varchar(128) DEFAULT NULL,
  ont_macaddress varchar(128) DEFAULT NULL,
  ont_hostname1 varchar(128) DEFAULT NULL,
  endofficename varchar(256) DEFAULT NULL,
  status varchar(128) DEFAULT NULL,
  uptime varchar(128) DEFAULT NULL,
  downduration varchar(128) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  secdept varchar(512) DEFAULT NULL,
  linedept varchar(512) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_discovered_offices PRIMARY KEY (discovered_offices_id)
);


-- Table : discovered_offices_tmp
DROP TABLE IF EXISTS discovered_offices_tmp CASCADE;

CREATE TABLE discovered_offices_tmp (
  discovered_offices_tmp_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  domain_name varchar(20) DEFAULT NULL,
  state varchar(20) DEFAULT NULL,
  district varchar(128) DEFAULT NULL,
  pop varchar(128) DEFAULT NULL,
  vendor varchar(128) DEFAULT NULL,
  olt_ipaddress varchar(20) DEFAULT NULL,
  olt_hostname varchar(128) DEFAULT NULL,
  ont_macaddress varchar(128) DEFAULT NULL,
  ont_hostname1 varchar(128) DEFAULT NULL,
  endofficename varchar(256) DEFAULT NULL,
  status varchar(128) DEFAULT NULL,
  uptime varchar(128) DEFAULT NULL,
  downduration varchar(128) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  secdept varchar(512) DEFAULT NULL,
  linedept varchar(512) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_discovered_offices_tmp PRIMARY KEY (discovered_offices_tmp_id)
);


-- Table : district
DROP TABLE IF EXISTS district CASCADE;

CREATE TABLE district (
  district_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  code VARCHAR(250),
  state_code VARCHAR(45),
  name VARCHAR(250),
  name_in_local VARCHAR(250),
  is_active BOOLEAN,
  shortname char(3) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_district PRIMARY KEY (district_id)
);

INSERT INTO district (district_id, code, state_code, name, name_in_local, is_active, shortname)
VALUES (
  gen_random_uuid(),
  '001',
  'KL01',
  'Thiruvananthapuram',
  'തിരുവനന്തപുരം',
  true,
  'TVM'
);
-- Table : dittotv
DROP TABLE IF EXISTS dittotv CASCADE;

CREATE TABLE dittotv (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  subid SERIAL,
  username varchar(45) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_dittotv PRIMARY KEY (id)
);


-- Table : dth_subscribers
DROP TABLE IF EXISTS dth_subscribers CASCADE;

CREATE TABLE dth_subscribers (
  dth_subscribers_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  slno varchar(128) DEFAULT NULL,
  couponid varchar(256) DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  username varchar(128) DEFAULT NULL,
  statecode char(5) DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  amount decimal DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  expiry_dt timestamp DEFAULT NULL,
  ordernumber varchar(64) DEFAULT NULL,
  packageid varchar(5) DEFAULT NULL,
  active INT DEFAULT 0,
  lock1 INT DEFAULT 0,
  -- Primary key constraint
CONSTRAINT pk_dth_subscribers PRIMARY KEY (dth_subscribers_id)
);


-- Table : dunning_config
DROP TABLE IF EXISTS dunning_config CASCADE;

CREATE TABLE dunning_config (
  dunning_config_id UUID DEFAULT gen_random_uuid() NOT NULL,
  did SERIAL,
  name varchar(250) DEFAULT NULL,
  template varchar(500) DEFAULT NULL,
  level smallint DEFAULT NULL,
  type char(10) DEFAULT NULL,
  remainder_period varchar(15) DEFAULT NULL,
  status smallint DEFAULT NULL,
  remainder_time varchar(50) DEFAULT NULL,
  command varchar(255) NOT NULL,
  interval_sec int NOT NULL,
  last_run_at timestamp DEFAULT NULL,
  next_run_at timestamp DEFAULT NULL,
  created_at timestamp DEFAULT NULL,
  created_by varchar(100) DEFAULT NULL,
  updated_at timestamp DEFAULT NULL,
  updated_by varchar(100) DEFAULT NULL,
  b_type int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_dunning_config PRIMARY KEY (dunning_config_id)
);


-- Table : dunning_period_master
DROP TABLE IF EXISTS dunning_period_master CASCADE;

CREATE TABLE dunning_period_master (
  dunning_period_master_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  period varchar(15) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_dunning_period_master PRIMARY KEY (dunning_period_master_id)
);
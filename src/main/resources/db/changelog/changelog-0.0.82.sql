DROP TABLE IF EXISTS data_usage_details CASCADE;

CREATE TABLE data_usage_details (
  details_id UUID NOT NULL,
  id SERIAL,
  username VARCHAR(45) DEFAULT NULL,
  total_upload DECIMAL(10,2) DEFAULT NULL,
  total_download DECIMAL(10,2) DEFAULT NULL,
  total_usage DECIMAL(10,2) DEFAULT NULL,
  month VARCHAR(10) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1,
  CONSTRAINT pk_data_usage_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN data_usage_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS dategroup CASCADE;

CREATE TABLE dategroup (
  id UUID NOT NULL,
  dategroupid SERIAL,
  dategroupname VARCHAR(45) NOT NULL DEFAULT '0',
  startdate INTEGER NOT NULL,
  enddate INTEGER NOT NULL,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_dategroup PRIMARY KEY (id)
);


DROP TABLE IF EXISTS daygroup CASCADE;

CREATE TABLE daygroup (
  id UUID NOT NULL,
  daygroupid SERIAL,
  daygroupname VARCHAR(45) NOT NULL DEFAULT '0',
  startday INTEGER NOT NULL,
  endday INTEGER NOT NULL,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_daygroup PRIMARY KEY (id)
);


DROP TABLE IF EXISTS daywise_data_usage_details CASCADE;

CREATE TABLE daywise_data_usage_details (
  details_id UUID NOT NULL,
  id SERIAL,
  username VARCHAR(45) DEFAULT NULL,
  total_upload DECIMAL(10,2) DEFAULT NULL,
  total_download DECIMAL(10,2) DEFAULT NULL,
  total_usage DECIMAL(10,2) DEFAULT NULL,
  date DATE DEFAULT NULL,
  month VARCHAR(10) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1,
  CONSTRAINT pk_daywise_data_usage_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN daywise_data_usage_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS delete_radius_users CASCADE;

CREATE TABLE delete_radius_users (
  users_id UUID NOT NULL,
  id BIGINT NOT NULL,
  subscriber VARCHAR(512) DEFAULT NULL,
  username VARCHAR(512) DEFAULT NULL,
  password VARCHAR(100) DEFAULT NULL,
  profile VARCHAR(100) DEFAULT NULL,
  endday VARCHAR(50) DEFAULT NULL,
  CONSTRAINT pk_delete_radius_users PRIMARY KEY (users_id)
);

COMMENT ON COLUMN delete_radius_users.users_id IS 'Unique identifier for delete radius users records';


DROP TABLE IF EXISTS deletedipusers CASCADE;

CREATE TABLE deletedipusers (
  users_id UUID NOT NULL,
  id SERIAL,
  customerid INTEGER DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  ip_type INTEGER DEFAULT NULL,
  framed_pool VARCHAR(200) DEFAULT NULL,
  ipv4_address VARCHAR(200) DEFAULT NULL,
  delegated_IPv6_Prefix VARCHAR(200) DEFAULT NULL,
  alc_IPv6_Address VARCHAR(200) DEFAULT NULL,
  framed_route VARCHAR(200) DEFAULT NULL,
  active_from DATE DEFAULT NULL,
  active_to DATE DEFAULT NULL,
  created_by VARCHAR(200) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1,
  CONSTRAINT pk_deletedipusers PRIMARY KEY (users_id)
);

COMMENT ON COLUMN deletedipusers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS deletedipusersk CASCADE;

CREATE TABLE deletedipusersk (
  id UUID NOT NULL,
  slno SERIAL,
  framedip VARCHAR(18) DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  deleted_date TIMESTAMP DEFAULT NULL,
  created_date TIMESTAMP DEFAULT NULL,
  lastupdated_date TIMESTAMP DEFAULT NULL,
  username VARCHAR(100) DEFAULT NULL,
  state VARCHAR(18) DEFAULT NULL,
  CONSTRAINT pk_deletedipusersk PRIMARY KEY (id)
);


DROP TABLE IF EXISTS demo_package CASCADE;

CREATE TABLE demo_package (
  id UUID NOT NULL,
  packageid SERIAL,
  packagename VARCHAR(50) NOT NULL,
  billingtypeid INTEGER DEFAULT 1,
  maxvolume DECIMAL(10,2) DEFAULT NULL,
  fallbackspeed VARCHAR(45) DEFAULT NULL,
  description VARCHAR(256) DEFAULT NULL,
  speedinkbps BIGINT DEFAULT NULL,
  j_profile VARCHAR(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1,
  CONSTRAINT pk_demo_package PRIMARY KEY (id)
);

COMMENT ON COLUMN demo_package.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS demo_users CASCADE;

CREATE TABLE demo_users (
  users_id UUID NOT NULL,
  id SERIAL,
  demo_id VARCHAR(20) DEFAULT NULL,
  password VARCHAR(256) DEFAULT NULL,
  assignto VARCHAR(256) DEFAULT NULL,
  region VARCHAR(10) DEFAULT NULL,
  circle VARCHAR(5) DEFAULT NULL,
  start_dt TIMESTAMP DEFAULT NULL,
  end_dt TIMESTAMP DEFAULT NULL,
  requested_by VARCHAR(256) DEFAULT NULL,
  approved_by VARCHAR(256) DEFAULT NULL,
  status SMALLINT DEFAULT NULL,
  dvr_ip VARCHAR(100) DEFAULT NULL,
  CONSTRAINT pk_demo_users PRIMARY KEY (users_id)
);



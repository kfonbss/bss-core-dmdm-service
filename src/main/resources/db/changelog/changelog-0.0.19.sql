DROP TABLE IF EXISTS acs_config CASCADE;

CREATE TABLE acs_config (
  config_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  default_username varchar(100) DEFAULT NULL,
  api_end_point varchar(100) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN acs_config.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN acs_config.config_id IS 'Unique identifier for ACS configuration records';


DROP TABLE IF EXISTS acs_device_provisioning CASCADE;

CREATE TABLE acs_device_provisioning (
  provisioning_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  username varchar(64) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  deviceid int DEFAULT NULL,
  serial_no varchar(250) DEFAULT NULL,
  partner_vlanid varchar(45) DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  http_status varchar(50) DEFAULT NULL,
  response_status varchar(50) DEFAULT NULL,
  response_message varchar(300) DEFAULT NULL,
  transaction_id varchar(300) DEFAULT NULL,
  provising_status int DEFAULT 1,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN acs_device_provisioning.provising_status IS '1=Pending,2=Completed';
COMMENT ON COLUMN acs_device_provisioning.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN acs_device_provisioning.provisioning_id IS 'Unique identifier for ACS device provisioning records';

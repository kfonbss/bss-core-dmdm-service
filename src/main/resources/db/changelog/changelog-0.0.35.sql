DROP TABLE IF EXISTS block_details CASCADE;

CREATE TABLE block_details (
  details_id UUID PRIMARY KEY NOT NULL,
  id BIGSERIAL,
  village_name varchar(250) DEFAULT NULL,
  block_id int DEFAULT NULL,
  block_name varchar(250) DEFAULT NULL,
  village_type varchar(50) DEFAULT NULL,
  village_type_id int DEFAULT NULL,
  district varchar(100) DEFAULT NULL,
  district_id int DEFAULT NULL,
  loc_type int DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true
);

CREATE INDEX idx_block ON block_details (district_id, block_id, village_type_id);
COMMENT ON COLUMN block_details.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN block_details.details_id IS 'Unique identifier for block details records';


DROP TABLE IF EXISTS bod_bandwidth CASCADE;

CREATE TABLE bod_bandwidth (
  bandwidth_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  speed varchar(45) DEFAULT NULL,
  radius_profile varchar(45) DEFAULT NULL,
  status varchar(45) NOT NULL DEFAULT '1'
);

COMMENT ON COLUMN bod_bandwidth.bandwidth_id IS 'Unique identifier for BOD bandwidth records';


DROP TABLE IF EXISTS bodprofile_map CASCADE;

CREATE TABLE bodprofile_map (
  id UUID PRIMARY KEY NOT NULL,
  idbodprofile_map SERIAL,
  bod_planid int DEFAULT NULL,
  bod_bandwidthid int DEFAULT NULL,
  status boolean NOT NULL DEFAULT true
);

COMMENT ON COLUMN bodprofile_map.id IS 'Unique identifier for BOD profile map records';
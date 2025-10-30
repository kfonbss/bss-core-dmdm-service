DROP TABLE IF EXISTS GST CASCADE;

CREATE TABLE GST (
  gst_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  STCode char(3) DEFAULT NULL,
  Taxtype varchar(15) DEFAULT NULL,
  value decimal(12,2) DEFAULT NULL,
  isactive boolean NOT NULL,
  CONSTRAINT pk_GST PRIMARY KEY (gst_id)
);


DROP TABLE IF EXISTS NMS_response CASCADE;

CREATE TABLE NMS_response (
  response_id UUID DEFAULT gen_random_uuid() NOT NULL,
  json_response text DEFAULT NULL,
  call_type text DEFAULT NULL,
  update_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_NMS_response PRIMARY KEY (response_id)
);


DROP TABLE IF EXISTS STATE_DIST_SUBDIST_BLOCK CASCADE;

CREATE TABLE STATE_DIST_SUBDIST_BLOCK (
  block_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id BIGSERIAL,
  StateName varchar(64) DEFAULT NULL,
  STCode char(3) DEFAULT NULL,
  DTName varchar(64) DEFAULT NULL,
  DTCode char(4) DEFAULT NULL,
  SDTName varchar(64) DEFAULT NULL,
  NSDTCode varchar(45) DEFAULT NULL,
  NBLKCode varchar(45) DEFAULT NULL,
  BLKName varchar(64) DEFAULT NULL,
  CONSTRAINT pk_STATE_DIST_SUBDIST_BLOCK PRIMARY KEY (block_id)
);

CREATE INDEX idx_state_dist_subdist_block_stcode_dtcode_nblkcode ON STATE_DIST_SUBDIST_BLOCK (STCode, DTCode, NBLKCode);

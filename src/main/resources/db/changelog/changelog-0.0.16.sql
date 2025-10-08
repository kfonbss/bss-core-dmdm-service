DROP TABLE IF EXISTS GST CASCADE;

CREATE TABLE GST (
  gst_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  STCode char(3) DEFAULT NULL,
  Taxtype varchar(15) DEFAULT NULL,
  value decimal(12,2) DEFAULT NULL,
  isactive boolean NOT NULL
);

COMMENT ON COLUMN GST.gst_id IS 'Unique identifier for GST records';


DROP TABLE IF EXISTS NMS_response CASCADE;

CREATE TABLE NMS_response (
  nms_response_id UUID PRIMARY KEY NOT NULL,
  json_response text DEFAULT NULL,
  call_type text DEFAULT NULL,
  update_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN NMS_response.nms_response_id IS 'Unique identifier for NMS response records';


DROP TABLE IF EXISTS STATE_DIST_SUBDIST_BLOCK CASCADE;

CREATE TABLE STATE_DIST_SUBDIST_BLOCK (
  state_dist_subdist_block_id UUID PRIMARY KEY NOT NULL,
  id BIGSERIAL,
  StateName varchar(64) DEFAULT NULL,
  STCode char(3) DEFAULT NULL,
  DTName varchar(64) DEFAULT NULL,
  DTCode char(4) DEFAULT NULL,
  SDTName varchar(64) DEFAULT NULL,
  NSDTCode varchar(45) DEFAULT NULL,
  NBLKCode varchar(45) DEFAULT NULL,
  BLKName varchar(64) DEFAULT NULL
);

CREATE INDEX index2 ON STATE_DIST_SUBDIST_BLOCK (STCode, DTCode, NBLKCode);
COMMENT ON COLUMN STATE_DIST_SUBDIST_BLOCK.state_dist_subdist_block_id IS 'Unique identifier for state district sub-district block records';

DROP TABLE IF EXISTS anpmimoissue CASCADE;

CREATE TABLE anpmimoissue (
  anpmimoissue_id UUID PRIMARY KEY NOT NULL,
  id BIGSERIAL,
  ordernumber varchar(64) DEFAULT NULL,
  txnid varchar(64) DEFAULT NULL,
  subscriberid int NOT NULL,
  partnerid bigint DEFAULT NULL,
  orderdate timestamp DEFAULT NULL,
  state varchar(50) DEFAULT NULL
);

COMMENT ON COLUMN anpmimoissue.anpmimoissue_id IS 'Unique identifier for ANP MIMO issue records';


DROP TABLE IF EXISTS anpstaticiptopup CASCADE;

CREATE TABLE anpstaticiptopup (
  anpstaticiptopup_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  staticpackageid int DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  packageid int DEFAULT NULL,
  requesttype varchar(50) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  status varchar(20) DEFAULT NULL,
  packtype varchar(10) DEFAULT NULL,
  topupstatus boolean DEFAULT false,
  createddate timestamp DEFAULT NULL,
  updateddate timestamp DEFAULT NULL,
  ticketid bigint NOT NULL
);

COMMENT ON COLUMN anpstaticiptopup.anpstaticiptopup_id IS 'Unique identifier for ANP static IP topup records';


DROP TABLE IF EXISTS anpstaticiptopupcopy CASCADE;

CREATE TABLE anpstaticiptopupcopy (
  anpstaticiptopupcopy_id UUID PRIMARY KEY NOT NULL,
  id int NOT NULL DEFAULT 0,
  staticpackageid int DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  packageid int DEFAULT NULL,
  requesttype varchar(20) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  status varchar(20) DEFAULT NULL,
  packtype varchar(10) DEFAULT NULL,
  topupstatus boolean DEFAULT false,
  createddate timestamp DEFAULT NULL,
  updateddate timestamp DEFAULT NULL,
  ticketid bigint NOT NULL
);

COMMENT ON COLUMN anpstaticiptopupcopy.anpstaticiptopupcopy_id IS 'Unique identifier for ANP static IP topup copy records';

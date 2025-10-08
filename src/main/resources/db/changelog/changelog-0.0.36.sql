DROP TABLE IF EXISTS bodsubscription CASCADE;

CREATE TABLE bodsubscription (
  bodsubscription_id UUID PRIMARY KEY NOT NULL,
  bodid SERIAL,
  subscriberid int NOT NULL,
  bodcharges decimal(10,2) NOT NULL,
  bodexpiry date NOT NULL,
  bodportspeedid int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  bodperiod int NOT NULL,
  bodstartdate timestamp NOT NULL DEFAULT '1970-01-01 00:00:00'
);

CREATE UNIQUE INDEX Index_2_bod ON bodsubscription (subscriberid, bodstartdate);
COMMENT ON COLUMN bodsubscription.bodsubscription_id IS 'Unique identifier for BOD subscription records';


DROP TABLE IF EXISTS bodsubscriptioncomplete CASCADE;

CREATE TABLE bodsubscriptioncomplete (
  bodsubscriptioncomplete_id UUID PRIMARY KEY NOT NULL,
  bodcompleteid int NOT NULL,
  subscriberid int NOT NULL,
  bodcharges decimal(10,2) NOT NULL,
  bodexpiry date NOT NULL,
  bodportspeedid int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  bodperiod int NOT NULL,
  bodstartdate timestamp NOT NULL DEFAULT '1970-01-01 00:00:00',
  bodstatus varchar(45) DEFAULT 'Dormant'
);

COMMENT ON COLUMN bodsubscriptioncomplete.bodsubscriptioncomplete_id IS 'Unique identifier for BOD subscription complete records';

DROP TABLE IF EXISTS bpl_duplicates CASCADE;

CREATE TABLE bpl_duplicates (
  bpl_duplicates_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  po_no char(10) DEFAULT NULL,
  loc_code char(10) DEFAULT NULL,
  locname varchar(100) DEFAULT NULL,
  locadr varchar(100) DEFAULT NULL,
  d_count int DEFAULT NULL
);

COMMENT ON COLUMN bpl_duplicates.bpl_duplicates_id IS 'Unique identifier for BPL duplicates records';


DROP TABLE IF EXISTS bpl_duplicates_all CASCADE;

CREATE TABLE bpl_duplicates_all (
  bpl_duplicates_all_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  po_no char(10) DEFAULT NULL,
  loc_code char(10) DEFAULT NULL,
  locname varchar(100) DEFAULT NULL,
  locadr varchar(100) DEFAULT NULL,
  d_count int DEFAULT NULL
);

COMMENT ON COLUMN bpl_duplicates_all.bpl_duplicates_all_id IS 'Unique identifier for BPL duplicates all records';

DROP TABLE IF EXISTS bpl_masterdata CASCADE;

CREATE TABLE bpl_masterdata (
  bpl_masterdata_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  locname varchar(128) DEFAULT NULL,
  address varchar(256) DEFAULT NULL,
  category varchar(256) DEFAULT NULL,
  ratincard varchar(128) DEFAULT NULL,
  dist_code char(3) DEFAULT NULL,
  constituency varchar(256) DEFAULT NULL,
  district varchar(128) DEFAULT NULL,
  uniqueid char(10) DEFAULT NULL,
  packageid varchar(50) DEFAULT NULL,
  GramaPanchayath varchar(128) DEFAULT NULL
);

COMMENT ON COLUMN bpl_masterdata.bpl_masterdata_id IS 'Unique identifier for BPL master data records';


DROP TABLE IF EXISTS bpl_users_tmp CASCADE;

CREATE TABLE bpl_users_tmp (
  bpl_users_tmp_id UUID PRIMARY KEY NOT NULL,
  slno int DEFAULT NULL,
  gp varchar(100) DEFAULT NULL,
  name varchar(100) DEFAULT NULL,
  address varchar(128) DEFAULT NULL,
  category varchar(100) DEFAULT NULL,
  contactno varchar(12) DEFAULT NULL,
  rationcardno varchar(12) DEFAULT NULL,
  district_short varchar(5) DEFAULT NULL,
  constituency varchar(100) DEFAULT NULL,
  district varchar(100) DEFAULT NULL,
  UniqueID varchar(100) DEFAULT NULL
);

COMMENT ON COLUMN bpl_users_tmp.bpl_users_tmp_id IS 'Unique identifier for BPL users temporary records';


DROP TABLE IF EXISTS bplgp_tmp CASCADE;

CREATE TABLE bplgp_tmp (
  bplgp_tmp_id UUID PRIMARY KEY NOT NULL,
  loc_code varchar(50) DEFAULT NULL,
  vtc varchar(156) DEFAULT NULL,
  gp varchar(156) DEFAULT NULL
);

COMMENT ON COLUMN bplgp_tmp.bplgp_tmp_id IS 'Unique identifier for BPL GP temporary records';


DROP TABLE IF EXISTS bplgp_tmp1 CASCADE;

CREATE TABLE bplgp_tmp1 (
  bplgp_tmp1_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  loc_code varchar(50) DEFAULT NULL,
  vtc varchar(156) DEFAULT NULL,
  gp varchar(156) DEFAULT NULL
);

COMMENT ON COLUMN bplgp_tmp1.bplgp_tmp1_id IS 'Unique identifier for BPL GP temporary 1 records';
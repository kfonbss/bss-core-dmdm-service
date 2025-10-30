DROP TABLE IF EXISTS bodsubscription CASCADE;

CREATE TABLE bodsubscription (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  bodid SERIAL,
  subscriberid int NOT NULL,
  bodcharges decimal(10,2) NOT NULL,
  bodexpiry date NOT NULL,
  bodportspeedid int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  bodperiod int NOT NULL,
  bodstartdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_bodsubscription PRIMARY KEY (id)
);

CREATE UNIQUE INDEX idx_bodsubscription ON bodsubscription (subscriberid, bodstartdate);


DROP TABLE IF EXISTS bodsubscriptioncomplete CASCADE;

CREATE TABLE bodsubscriptioncomplete (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  bodcompleteid int NOT NULL,
  subscriberid int NOT NULL,
  bodcharges decimal(10,2) NOT NULL,
  bodexpiry date NOT NULL,
  bodportspeedid int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  bodperiod int NOT NULL,
  bodstartdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  bodstatus varchar(45) DEFAULT 'Dormant',
  CONSTRAINT pk_bodsubscriptioncomplete PRIMARY KEY (id)
);


DROP TABLE IF EXISTS bpl_duplicates CASCADE;

CREATE TABLE bpl_duplicates (
  duplicates_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  po_no char(10) DEFAULT NULL,
  loc_code char(10) DEFAULT NULL,
  locname varchar(100) DEFAULT NULL,
  locadr varchar(100) DEFAULT NULL,
  d_count int DEFAULT NULL,
  CONSTRAINT pk_bpl_duplicates PRIMARY KEY (duplicates_id)
);


DROP TABLE IF EXISTS bpl_duplicates_all CASCADE;

CREATE TABLE bpl_duplicates_all (
  duplicates_all_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  po_no char(10) DEFAULT NULL,
  loc_code char(10) DEFAULT NULL,
  locname varchar(100) DEFAULT NULL,
  locadr varchar(100) DEFAULT NULL,
  d_count int DEFAULT NULL,
  CONSTRAINT pk_bpl_duplicates_all PRIMARY KEY (duplicates_all_id)
);


DROP TABLE IF EXISTS bpl_masterdata CASCADE;

CREATE TABLE bpl_masterdata (
  masterdata_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  GramaPanchayath varchar(128) DEFAULT NULL,
  CONSTRAINT pk_bpl_masterdata PRIMARY KEY (masterdata_id)
);


DROP TABLE IF EXISTS bpl_users_tmp CASCADE;

CREATE TABLE bpl_users_tmp (
  tmp_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  UniqueID varchar(100) DEFAULT NULL,
  CONSTRAINT pk_bpl_users_tmp PRIMARY KEY (tmp_id)
);


DROP TABLE IF EXISTS bplgp_tmp CASCADE;

CREATE TABLE bplgp_tmp (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  loc_code varchar(50) DEFAULT NULL,
  vtc varchar(156) DEFAULT NULL,
  gp varchar(156) DEFAULT NULL,
  CONSTRAINT pk_bplgp_tmp PRIMARY KEY (id)
);


DROP TABLE IF EXISTS bplgp_tmp1 CASCADE;

CREATE TABLE bplgp_tmp1 (
  tmp1_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  loc_code varchar(50) DEFAULT NULL,
  vtc varchar(156) DEFAULT NULL,
  gp varchar(156) DEFAULT NULL,
  CONSTRAINT pk_bplgp_tmp1 PRIMARY KEY (tmp1_id)
);

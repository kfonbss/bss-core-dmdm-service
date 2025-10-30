DROP TABLE IF EXISTS audittable CASCADE;

CREATE TABLE audittable (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  audittableid SERIAL,
  subscriberid int NOT NULL,
  dblogin varchar(45) DEFAULT '',
  dbtable varchar(45) DEFAULT '',
  dbfield varchar(45) DEFAULT '',
  dbaction varchar(45) DEFAULT 'Modify',
  oldvalue varchar(128) DEFAULT '',
  newvalue varchar(128) DEFAULT '',
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_audittable PRIMARY KEY (id)
);


DROP TABLE IF EXISTS b2b_packages CASCADE;

CREATE TABLE b2b_packages (
  packages_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  package_name varchar(60) DEFAULT NULL,
  speed varchar(45) DEFAULT NULL,
  data_volume varchar(45) DEFAULT NULL,
  otc varchar(45) DEFAULT NULL,
  tariff varchar(45) DEFAULT NULL,
  validity varchar(45) DEFAULT NULL,
  status varchar(2) NOT NULL DEFAULT '0',
  CreatedOn timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_b2b_packages PRIMARY KEY (packages_id)
);

COMMENT ON COLUMN b2b_packages.status IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS back_disbure_weekly_reversal CASCADE;

CREATE TABLE back_disbure_weekly_reversal (
  reversal_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  partnerid bigint DEFAULT NULL,
  balance_before decimal(13,2) NOT NULL DEFAULT 0.00,
  total_amt decimal(13,2) NOT NULL DEFAULT 0.00,
  CONSTRAINT pk_back_disbure_weekly_reversal PRIMARY KEY (reversal_id)
);

CREATE INDEX index2_bdwr ON back_disbure_weekly_reversal (partnerid);

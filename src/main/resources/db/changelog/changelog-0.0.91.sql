-- Table : issuetype
DROP TABLE IF EXISTS issuetype CASCADE;

CREATE TABLE issuetype (
  issuetype_id UUID NOT NULL,
  slno SERIAL,
  issuetype varchar(20) DEFAULT NULL,
  msg varchar(255) DEFAULT NULL,
  status varchar(50) NOT NULL,
  etr int DEFAULT NULL,
  assigned varchar(20) DEFAULT NULL,
  category varchar(50) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_issuetype PRIMARY KEY (issuetype_id)
);


-- Table : issuetype_backup
DROP TABLE IF EXISTS issuetype_backup CASCADE;

CREATE TABLE issuetype_backup (
  issuetype_backup_id UUID NOT NULL,
  slno SERIAL,
  issuetype varchar(20) DEFAULT NULL,
  msg varchar(255) DEFAULT NULL,
  status varchar(50) NOT NULL,
  etr int DEFAULT NULL,
  assigned varchar(20) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_issuetype_backup PRIMARY KEY (issuetype_backup_id)
);


-- Table : ivr_call
DROP TABLE IF EXISTS ivr_call CASCADE;

CREATE TABLE ivr_call (
  ivr_call_id UUID NOT NULL,
  id SERIAL,
  partnerid varchar(25) DEFAULT NULL,
  subscriberid varchar(50) DEFAULT NULL,
  submob varchar(50) DEFAULT NULL,
  createDate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_ivr_call PRIMARY KEY (ivr_call_id)
);


-- Table : july_adjust
DROP TABLE IF EXISTS july_adjust CASCADE;

CREATE TABLE july_adjust (
  july_adjust_id UUID NOT NULL,
  amt decimal(10,2) DEFAULT NULL,
  Partnerid varchar(10) DEFAULT NULL,
  lastupdate varchar(19) DEFAULT NULL,
  cause varchar(22) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_july_adjust PRIMARY KEY (july_adjust_id)
);


-- Table : july_adjust2
DROP TABLE IF EXISTS july_adjust2 CASCADE;

CREATE TABLE july_adjust2 (
  july_adjust2_id UUID NOT NULL,
  amt decimal(19,2) DEFAULT NULL,
  partnerid varchar(10) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_july_adjust2 PRIMARY KEY (july_adjust2_id)
);


-- Table : july_sub
DROP TABLE IF EXISTS july_sub CASCADE;

CREATE TABLE july_sub (
  july_sub_id UUID NOT NULL,
  amt decimal(10,2) DEFAULT NULL,
  subid varchar(20) DEFAULT NULL,
  lastupdate varchar(19) DEFAULT NULL,
  cause varchar(30) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_july_sub PRIMARY KEY (july_sub_id)
);


-- Table : june_agp
DROP TABLE IF EXISTS june_agp CASCADE;

CREATE TABLE june_agp (
  june_agp_id UUID NOT NULL,
  slno int NOT NULL DEFAULT 0,
  pid varchar(25) DEFAULT NULL,
  amt decimal(10,2) DEFAULT NULL,
  cause varchar(100) DEFAULT NULL,
  lastdate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_june_agp PRIMARY KEY (june_agp_id)
);


-- Table : june_anp
DROP TABLE IF EXISTS june_anp CASCADE;

CREATE TABLE june_anp (
  june_anp_id UUID NOT NULL,
  slno int NOT NULL DEFAULT 0,
  pid varchar(25) DEFAULT NULL,
  amt decimal(10,2) DEFAULT NULL,
  cause varchar(100) DEFAULT NULL,
  lastdate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_june_anp PRIMARY KEY (june_anp_id)
);


-- Table : ka_july
DROP TABLE IF EXISTS ka_july CASCADE;

CREATE TABLE ka_july (
  ka_july_id UUID NOT NULL,
  partnerid int NOT NULL,
  amount decimal(10,2) NOT NULL,
  cause varchar(45) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_ka_july PRIMARY KEY (ka_july_id)
);


-- Table : ka_july_sub
DROP TABLE IF EXISTS ka_july_sub CASCADE;

CREATE TABLE ka_july_sub (
  ka_july_sub_id UUID NOT NULL,
  subscriberid int NOT NULL,
  cause varchar(45) NOT NULL,
  amount decimal(10,2) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_ka_july_sub PRIMARY KEY (ka_july_sub_id)
);

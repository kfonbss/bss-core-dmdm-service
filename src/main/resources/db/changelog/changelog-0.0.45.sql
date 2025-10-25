-- Drop tables if they exist
DROP TABLE IF EXISTS selfcare_eo CASCADE;
DROP TABLE IF EXISTS service CASCADE;
DROP TABLE IF EXISTS service_type CASCADE;
DROP TABLE IF EXISTS servicetype CASCADE;
DROP TABLE IF EXISTS sez_approval_movement CASCADE;
DROP TABLE IF EXISTS sfin_monthly CASCADE;
DROP TABLE IF EXISTS sidebar_menus CASCADE;
DROP TABLE IF EXISTS smonthlyinvoice CASCADE;
DROP TABLE IF EXISTS smonthlyinvoicenov CASCADE;

-- Table: selfcare_eo
CREATE TABLE selfcare_eo (
  eo_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  district VARCHAR(50),
  name VARCHAR(256),
  address VARCHAR(512),
  contactpersonname VARCHAR(256),
  contactpersonemail VARCHAR(100),
  phoneno VARCHAR(50),
  typeofinstitution CHAR(100),
  latitude VARCHAR(100),
  minutes VARCHAR(50),
  seconds VARCHAR(100),
  longitude VARCHAR(100),
  secminutes VARCHAR(100),
  secseconds VARCHAR(100),
  numberoflan VARCHAR(100),
  x_id VARCHAR(100),
  y_id VARCHAR(100)
);

-- Table: service
CREATE TABLE service (
  id UUID NOT NULL PRIMARY KEY,
  serviceid SERIAL,
  code VARCHAR(50),
  name VARCHAR(100) NOT NULL UNIQUE,
  name_in_local VARCHAR(150),
  baserental NUMERIC(10,2) NOT NULL,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO service (id, code, name, name_in_local, baserental, is_active,created_date, modified_date, created_by, modified_by)
VALUES
    (gen_random_uuid(), 'VOIP', 'VoIP Service', 'വോയിസ് ഓവർ ഐപി', 300.00, TRUE,NOW(), NOW(), gen_random_uuid(), gen_random_uuid());

-- Table: service_type
CREATE TABLE service_type (
    id UUID PRIMARY KEY,
    type_id SERIAL,
    code VARCHAR(50),
    name VARCHAR(45),
    name_in_local VARCHAR(150),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO service_type (
    id, type_id, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by
)VALUES
  (
    gen_random_uuid(), 1, 'INT', 'Internet Service', 'ഇന്റർനെറ്റ് സേവനം', TRUE,
    NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
  );

-- Table: servicetype
CREATE TABLE servicetype (
  service_id UUID NOT NULL PRIMARY KEY,
  id SMALLSERIAL,
  servicename VARCHAR(128),
  status INT,
  created_dt TIMESTAMP,
  updated_dt TIMESTAMP
);

-- Table: sez_approval_movement
CREATE TABLE sez_approval_movement (
  movement_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  requestid INTEGER,
  subtype INT DEFAULT 1,
  subscriberid INTEGER,
  status VARCHAR(5),
  remarks VARCHAR(300),
  created_by VARCHAR(50),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: sfin_monthly
CREATE TABLE sfin_monthly (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL,
  subscriberid INTEGER,
  amount NUMERIC(10,2) DEFAULT 0.00,
  cause VARCHAR(100),
  lastupdate TIMESTAMP,
  monthpart VARCHAR(10)
);

CREATE INDEX idx_sfin_subscriberid ON sfin_monthly(subscriberid);

-- Table: sidebar_menus
CREATE TABLE sidebar_menus (
  id UUID NOT NULL PRIMARY KEY,
  menuid SERIAL,
  parent_menuid INTEGER NOT NULL DEFAULT 0,
  menu_groupid INTEGER NOT NULL DEFAULT 0,
  icon VARCHAR(100),
  name VARCHAR(100),
  title VARCHAR(100),
  link VARCHAR(100),
  weight INT,
  link_target VARCHAR(50),
  link_type VARCHAR(50),
  status INT NOT NULL DEFAULT 1,
  more_permissions VARCHAR(255),
  visibility INT NOT NULL DEFAULT 1,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  created_by VARCHAR(100),
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_by VARCHAR(100)
);

-- Table: smonthlyinvoice
CREATE TABLE smonthlyinvoice (
  id UUID NOT NULL PRIMARY KEY,
  slno INTEGER NOT NULL DEFAULT 0,
  partnerid BIGINT,
  pgid INTEGER,
  subid BIGINT,
  monthpart VARCHAR(20),
  amount NUMERIC(10,2),
  cause VARCHAR(30),
  agpid BIGINT,
  statecode VARCHAR(10),
  mspid VARCHAR(20),
  cashbackelg NUMERIC(10,2),
  cashbackcur NUMERIC(10,2),
  disbid INTEGER
);

-- Table: smonthlyinvoicenov
CREATE TABLE smonthlyinvoicenov (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL,
  partnerid BIGINT,
  pgid INTEGER,
  subid BIGINT,
  monthpart VARCHAR(20),
  amount NUMERIC(10,2),
  cause VARCHAR(30),
  agpid BIGINT,
  statecode VARCHAR(10),
  mspid VARCHAR(20)
);

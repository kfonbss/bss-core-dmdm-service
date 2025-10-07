-- Drop tables if they exist
DROP TABLE IF EXISTS state CASCADE;
DROP TABLE IF EXISTS state_district CASCADE;
DROP TABLE IF EXISTS state_map CASCADE;
DROP TABLE IF EXISTS statewise_railtel CASCADE;
DROP TABLE IF EXISTS staticippackage CASCADE;
DROP TABLE IF EXISTS status CASCADE;
DROP TABLE IF EXISTS statusmaster CASCADE;

-- Table: state
CREATE TABLE state (
  id UUID NOT NULL PRIMARY KEY,
  stateid SERIAL ,
  statename VARCHAR(250),
  statecode VARCHAR(45)
);

-- Table: state_district
CREATE TABLE state_district (
  district_id UUID NOT NULL PRIMARY KEY,
  id BIGSERIAL ,
  statename VARCHAR(64),
  stcode CHAR(5),
  dtname VARCHAR(64),
  statecode CHAR(3),
  districtcode VARCHAR(45)
);

CREATE INDEX idx_state_district_stcode ON state_district (stcode);

-- Table: state_map
CREATE TABLE state_map (
  state_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  stcode VARCHAR(10),
  mstcode VARCHAR(10)
);

-- Table: statewise_railtel
CREATE TABLE statewise_railtel (
  state_wise_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  stcode CHAR(3),
  pan VARCHAR(15),
  gstin VARCHAR(18),
  billing_address VARCHAR(180),
  bank_acholder VARCHAR(128),
  bank_name VARCHAR(128),
  bank_acno VARCHAR(64),
  bank_ifsc VARCHAR(64),
  bank_branch VARCHAR(128),
  cin_number VARCHAR(30),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1 CHECK (is_active IN (0,1))
);

CREATE INDEX idx_statewise_railtel_stcode ON statewise_railtel (stcode);

-- Table: staticippackage
CREATE TABLE staticippackage (
  id UUID NOT NULL PRIMARY KEY,
  staticpackid SERIAL,
  staticpackagename VARCHAR(100),
  price NUMERIC(12,2),
  status INT NOT NULL DEFAULT 0
);

-- Table: status
CREATE TABLE status (
  status_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  statusname VARCHAR(50)
);

-- Table: statusmaster
CREATE TABLE statusmaster (
  id UUID NOT NULL PRIMARY KEY,
  slno INTEGER,
  status VARCHAR(50),
  statuscode VARCHAR(10)
);

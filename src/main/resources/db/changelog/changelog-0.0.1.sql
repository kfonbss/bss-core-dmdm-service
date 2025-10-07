-- Drop tables if they exist
DROP TABLE IF EXISTS workorder CASCADE;
DROP TABLE IF EXISTS workorderfinance CASCADE;
DROP TABLE IF EXISTS workorderreciept CASCADE;
DROP TABLE IF EXISTS workordersummary CASCADE;
DROP TABLE IF EXISTS workorderupload CASCADE;

-- ========================================
-- Table: workorder
-- ========================================
CREATE TABLE workorder (
  id UUID NOT NULL PRIMARY KEY,
  workorderid VARCHAR(45),
  shortname VARCHAR(64),
  corporateid VARCHAR(45),
  order_account_balance NUMERIC(10,2) NOT NULL DEFAULT 0.00,
  create_date TIMESTAMP,
  order_description VARCHAR(256),
  lastupdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  remarks VARCHAR(256),
  subscribercount INTEGER,
  reference_letter_dtd DATE,
  completed INTEGER NOT NULL DEFAULT 0,
  lastdisbursedamount NUMERIC(10,2) NOT NULL DEFAULT 0.00,
  validity_period INTEGER,
  po_no VARCHAR(45),
  stdate TIMESTAMP,
  eddate TIMESTAMP,
  podesc VARCHAR(250),
  gstin VARCHAR(20),
  sac VARCHAR(20),
  pan VARCHAR(15),
  gstindoc VARCHAR(120),
  taxpayertype SMALLINT NOT NULL DEFAULT 0,
  servicedesc VARCHAR(250)
);

-- ========================================
-- Table: workorderfinance
-- ========================================
CREATE TABLE workorderfinance (
  id UUID NOT NULL PRIMARY KEY,
  wofinanceid BIGSERIAL,
  workorderid VARCHAR(45),
  amount NUMERIC(10,2),
  cause VARCHAR(128),
  subscriberid VARCHAR(15),
  transaction_date TIMESTAMP,
  description VARCHAR(100)
);

-- ========================================
-- Table: workorderreciept
-- ========================================
CREATE TABLE workorderreciept (
  id UUID NOT NULL PRIMARY KEY,
  worecieptid BIGSERIAL,
  workorderid VARCHAR(45),
  amount NUMERIC(10,2) NOT NULL DEFAULT 0.00,
  reference VARCHAR(256),
  reciept_date TIMESTAMP
);

-- ========================================
-- Table: workordersummary
-- ========================================
CREATE TABLE workordersummary (
  workorder_summary_id UUID NOT NULL PRIMARY KEY,
  id INTEGER NOT NULL DEFAULT 0,
  workorderid VARCHAR(256),
  username VARCHAR(256),
  workorder_amount NUMERIC(10,2),
  lastupdate TIMESTAMP
);

-- ========================================
-- Table: workorderupload
-- ========================================
CREATE TABLE workorderupload (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL,
  time_date TIMESTAMP,
  fileupload VARCHAR(255),
  uploadedby VARCHAR(100),
  workorderid VARCHAR(45),
  type VARCHAR(100),
  size VARCHAR(50),
  path VARCHAR(250),
  date DATE,
  name VARCHAR(100)
);

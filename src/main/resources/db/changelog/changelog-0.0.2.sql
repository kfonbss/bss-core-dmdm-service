-- ========================================
-- Drop existing tables if they exist
-- ========================================
DROP TABLE IF EXISTS vlantable CASCADE;
DROP TABLE IF EXISTS vrfattri_ptnrdemousers CASCADE;
DROP TABLE IF EXISTS vrfattri_users CASCADE;
DROP TABLE IF EXISTS wofinance CASCADE;

-- ========================================
-- Table: vlantable
-- ========================================
CREATE TABLE vlantable (
  id UUID NOT NULL PRIMARY KEY,
  vlantableid SERIAL,
  partnerid VARCHAR(45),
  vlanname VARCHAR(128),
  nasid INTEGER,
  vlanid VARCHAR(45),
  create_date TIMESTAMP,
  update_date TIMESTAMP,
  update_by VARCHAR(64),
  create_by VARCHAR(64),
  nastype VARCHAR(25) NOT NULL DEFAULT 'Juniper'
);

-- ========================================
-- Table: vrfattri_ptnrdemousers
-- ========================================
CREATE TABLE vrfattri_ptnrdemousers (
  demo_user_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  username VARCHAR(64),
  partnerid BIGINT,
  attribute VARCHAR(64),
  value VARCHAR(253),
  createdt TIMESTAMP,
  updatedt TIMESTAMP
);

-- ========================================
-- Table: vrfattri_users
-- ========================================
CREATE TABLE vrfattri_users (
  user_id UUID NOT NULL PRIMARY KEY,
  id BIGSERIAL,
  subscriberid BIGINT,
  username VARCHAR(256),
  partnerid BIGINT,
  partnercompanyname VARCHAR(256),
  vrfattribute VARCHAR(100),
  vrfvalue VARCHAR(50),
  createdt TIMESTAMP,
  updatedt TIMESTAMP
);

-- ========================================
-- Table: wofinance
-- ========================================
CREATE TABLE wofinance (
  id UUID NOT NULL PRIMARY KEY,
  wofinanceid BIGSERIAL,
  workorderid VARCHAR(45),
  amount NUMERIC(10,2),
  cause VARCHAR(128),
  subscriberid VARCHAR(15),
  transaction_date TIMESTAMP,
  description VARCHAR(100)
);

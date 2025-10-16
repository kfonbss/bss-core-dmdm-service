-- Drop existing tables
DROP TABLE IF EXISTS se_proposal_movement CASCADE;
DROP TABLE IF EXISTS se_proposals CASCADE;
DROP TABLE IF EXISTS se_purchase_order CASCADE;
DROP TABLE IF EXISTS se_renewal_details CASCADE;
DROP TABLE IF EXISTS se_workorders CASCADE;
DROP TABLE IF EXISTS security CASCADE;

-- Table: se_proposal_movement
CREATE TABLE se_proposal_movement (
  movement_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  propid INTEGER,
  approve_status INTEGER,
  remarks VARCHAR(250),
  created_by VARCHAR(128),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1 -- 0=Inactive, 1=Active
);

-- Table: se_proposals
CREATE TABLE se_proposals (
  proposals_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  customerid INTEGER,
  proposal_name VARCHAR(100),
  con_count INTEGER DEFAULT 0,
  service_days INTEGER DEFAULT 0,
  remarks VARCHAR(250),
  approve_status INTEGER DEFAULT 1, -- 1=Proposal Created
  is_rejected INT DEFAULT 0,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1 -- 0=Inactive, 1=Active
);

-- Table: se_purchase_order
CREATE TABLE se_purchase_order (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL,
  customerid INTEGER,
  propid INTEGER,
  po_doc VARCHAR(100),
  po_no VARCHAR(30),
  paymnet_mode INT,
  approve_status INTEGER DEFAULT 0,
  remarks VARCHAR(255),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1 -- 0=Inactive, 1=Active
);

-- Table: se_renewal_details
CREATE TABLE se_renewal_details (
  details_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  locid INTEGER,
  cause VARCHAR(100),
  service_sdate DATE,
  service_edate DATE,
  finrefid INTEGER,
  total_sdays INTEGER DEFAULT 0,
  bandwidth_cost NUMERIC(26,10) DEFAULT 0.0000000000,
  bandwidth_gst NUMERIC(26,10) DEFAULT 0.0000000000,
  establishment_cost NUMERIC(26,10) DEFAULT 0.0000000000,
  establishment_gst NUMERIC(26,10) DEFAULT 0.0000000000,
  otc_cost NUMERIC(26,10) DEFAULT 0.0000000000,
  otc_gst NUMERIC(26,10) DEFAULT 0.0000000000,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1 -- 0=Inactive, 1=Active
);

-- Table: se_workorders
CREATE TABLE se_workorders (
  orders_id UUID NOT NULL PRIMARY KEY,
  id SERIAL,
  poid INTEGER,
  proposalid INTEGER,
  wo_no VARCHAR(25),
  approve_status INTEGER DEFAULT 1,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1 -- 0=Inactive, 1=Active
);

-- Table: security
CREATE TABLE security (
  id UUID NOT NULL PRIMARY KEY,
  subscriberid BIGSERIAL,
  username VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(45) NOT NULL DEFAULT 'Railwire123',
  groupid INTEGER NOT NULL DEFAULT 1,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  resetpass INT DEFAULT 0,
  reset_key VARCHAR(255),
  reset_timeout TIMESTAMP,
  CONSTRAINT idx_security_username_password UNIQUE (username, password)
);

-- Drop existing tables
DROP TABLE IF EXISTS se_location_movement CASCADE;
DROP TABLE IF EXISTS se_locations CASCADE;
DROP TABLE IF EXISTS se_locfinance CASCADE;
DROP TABLE IF EXISTS se_payment_details CASCADE;
DROP TABLE IF EXISTS se_payment_history CASCADE;
DROP TABLE IF EXISTS se_po_movement CASCADE;

-- Table: se_location_movement
CREATE TABLE se_location_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  locid INTEGER,
  approve_status INTEGER,
  remarks VARCHAR(255),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);
INSERT INTO se_location_movement (
  movement_id, code, name, name_in_local, is_active, id, locid, approve_status, remarks,
  created_by, created_date, modified_date, modified_by
) VALUES (
  gen_random_uuid(), 'MOV001', 'Location Movement 1', 'ലൊക്കേഷൻ മൂവ്‌മെന്റ് 1', true, 1, 501, 1,
  'Initial approval for location change', gen_random_uuid(), CURRENT_TIMESTAMP, NULL, gen_random_uuid()
);

-- Table: se_locations
CREATE TABLE se_locations (
  location_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  slno SERIAL,
  proid INTEGER,
  custid INTEGER,
  service_type INTEGER,
  service_provider INTEGER,
  partnerid INTEGER,
  loc_code VARCHAR(10),
  loc_address VARCHAR(250),
  bandwidth VARCHAR(100),
  bandwidth_cost NUMERIC(10,2) DEFAULT 0.00 NOT NULL,
  establishment_cost NUMERIC(10,2) DEFAULT 0.00 NOT NULL,
  otc_cost NUMERIC(10,2) DEFAULT 0.00 NOT NULL,
  remarks VARCHAR(250),
  approve_status INTEGER DEFAULT 0,
  expirydate DATE,
  balance NUMERIC(10,2) DEFAULT 0.00 NOT NULL,
  commission_date DATE,
  commission_doc VARCHAR(100),
  circuit_details VARCHAR(100),
  d_status INTEGER DEFAULT 0,  -- 0=Inactive, 1=Active, 2=Decommissioned
  d_status_date DATE,
  rccount INTEGER DEFAULT 0,
  last_recharge_date TIMESTAMP,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: se_locfinance
CREATE TABLE se_locfinance (
  finance_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  finid SERIAL,
  locid INTEGER,
  amount NUMERIC(10,2) NOT NULL,
  cause VARCHAR(45) NOT NULL,
  finrefid INTEGER,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: se_payment_details
CREATE TABLE se_payment_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  poid INTEGER,
  utr_number VARCHAR(50),
  paid_amount NUMERIC(26,10),
  paymnet_date DATE,
  created_by VARCHAR(150),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: se_payment_history
CREATE TABLE se_payment_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  invoiceid VARCHAR(15),
  utr_number VARCHAR(25),
  amount VARCHAR(10),
  it_tdsamount NUMERIC(10,2) DEFAULT 0.00,
  gst_tdsamount NUMERIC(10,2) DEFAULT 0.00,
  payment_recipt VARCHAR(150),
  created_by VARCHAR(150),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: se_po_movement
CREATE TABLE se_po_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  poid INTEGER,
  approve_status INTEGER,
  remarks VARCHAR(255),
  created_by VARCHAR(128),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Drop table if exists
DROP TABLE IF EXISTS vas_subscription CASCADE;

-- Table: vas_subscription
CREATE TABLE vas_subscription (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  subscriberid BIGINT,
  pb_expiry TIMESTAMP NULL,
  packageid INT DEFAULT 1,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1,  -- 0=Inactive, 1=Active
  CONSTRAINT chk_is_active CHECK (is_active IN (0, 1))
);


-- Table: village_types
DROP TABLE IF EXISTS village_types CASCADE;

CREATE TABLE village_types (
  village_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id BIGSERIAL,
  village_type_id INT,
  village_type VARCHAR(50),
  loc_type INT,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1 CHECK (is_active IN (0, 1))
);

-- Table: vlanrequest_movement
DROP TABLE IF EXISTS vlanrequest_movement CASCADE;

CREATE TABLE vlanrequest_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id BIGSERIAL,
  reqid INT,
  partnerid BIGINT,
  remarks VARCHAR(200),
  created_by VARCHAR(64),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  approve_status SMALLINT,
  vlantableid VARCHAR(45)
);

-- Table: vlanrequests
DROP TABLE IF EXISTS vlanrequests CASCADE;

CREATE TABLE vlanrequests (
  request_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id BIGSERIAL,
  partnerid BIGINT NOT NULL,
  pop_name VARCHAR(50),
  port_number VARCHAR(50),
  vlan_range VARCHAR(50),
  switchtype VARCHAR(50),
  switchip VARCHAR(50),
  sfp VARCHAR(50),
  created_by VARCHAR(50),
  remarks VARCHAR(200),
  vstatus SMALLINT DEFAULT 0,
  vlantableid INT,
  is_active SMALLINT DEFAULT 1,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

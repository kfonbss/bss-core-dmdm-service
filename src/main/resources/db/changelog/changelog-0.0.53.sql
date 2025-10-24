-- Drop tables if they exist
DROP TABLE IF EXISTS revenueshare_monthwise CASCADE;
DROP TABLE IF EXISTS role_type CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS roles_modules CASCADE;
DROP TABLE IF EXISTS rules CASCADE;
DROP TABLE IF EXISTS sampletax CASCADE;

-- Table: revenueshare_monthwise
CREATE TABLE revenueshare_monthwise (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  pgid INTEGER DEFAULT 0,
  subid BIGINT DEFAULT 0,
  disburseid INTEGER,
  packageid INTEGER,
  disbid INTEGER DEFAULT 0,
  revenue NUMERIC(10,2) DEFAULT 0.00,
  anpid BIGINT DEFAULT 0,
  anp_share NUMERIC(12,4) DEFAULT 0.0000,
  anp_percent NUMERIC(12,4),
  agpid BIGINT DEFAULT 0,
  agp_share NUMERIC(12,4) DEFAULT 0.0000,
  agp_percent NUMERIC(12,4),
  mspid BIGINT DEFAULT 0,
  msp_share NUMERIC(12,4) DEFAULT 0.0000,
  msp_percent NUMERIC(12,4),
  ispid BIGINT DEFAULT 0,
  isp_share NUMERIC(12,4) DEFAULT 0.0000,
  isp_percent NUMERIC(12,4),
  disb_date TIMESTAMP,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  statecode VARCHAR(10) DEFAULT '0',
  pst_code VARCHAR(10) DEFAULT '0',
  revenueshareid INTEGER DEFAULT 0,
  connType INT,
  oldrevenueshareid INTEGER,
  OTTprov_percent NUMERIC(12,4),
  OTTprov_share NUMERIC(12,4),
  OTTprov_id BIGINT,
  revenue_type VARCHAR(20) DEFAULT '0',
  monthpart VARCHAR(20) DEFAULT '0',
  dot_percent NUMERIC(12,4),
  cashbackelg NUMERIC(12,4) DEFAULT 0.0000,
  prs_percent INTEGER DEFAULT 0,
  prs_share NUMERIC(12,4) DEFAULT 0.0000,
  dot_share NUMERIC(12,4) DEFAULT 0.0000,
  online INTEGER DEFAULT 0,
  remarks VARCHAR(100) DEFAULT '0',
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: role_type
CREATE TABLE role_type (
  type_id UUID NOT NULL PRIMARY KEY,
  id SERIAL ,
  official VARCHAR(100),
  description VARCHAR(100)
);

-- Table: roles
CREATE TABLE roles (
  id UUID NOT NULL PRIMARY KEY,
  role_id SMALLSERIAL ,
  role_name VARCHAR(255),
  official VARCHAR(100),
  role_parent_id INT DEFAULT 0,
  description VARCHAR(255),
  default_role INT DEFAULT 0,
  status INT DEFAULT 0,
  is_show INT DEFAULT 0,
  landing_url VARCHAR(100),
  profilemenu INT DEFAULT 0,
  profileurl VARCHAR(100),
  access_permission VARCHAR(100) DEFAULT 'Public',
  created_by VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_by VARCHAR(255),
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_roles_name ON roles(role_name);

-- Table: roles_modules
CREATE TABLE roles_modules (
  id UUID NOT NULL PRIMARY KEY,
  rm_id SERIAL ,
  role_id INTEGER,
  module_id INTEGER,
  submodule_id INTEGER,
  permissions TEXT,
  category VARCHAR(25),
  created_by VARCHAR(256),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_by VARCHAR(256),
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_role_id ON roles_modules(role_id);

-- Table: rules
CREATE TABLE rules (
  rule_id UUID NOT NULL PRIMARY KEY,
  id SERIAL ,
  action TEXT,
  status INT,
  roles VARCHAR(256),
  users VARCHAR(256),
  p1 VARCHAR(256),
  p2 VARCHAR(256),
  p3 VARCHAR(256),
  rule TEXT
);

-- Table: sampletax
CREATE TABLE sampletax (
  tax_id UUID NOT NULL PRIMARY KEY,
  id SERIAL ,
  amount NUMERIC(10,2) NOT NULL
);

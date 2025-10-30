-- Drop tables if they exist
DROP TABLE IF EXISTS sop_doc_details_movement CASCADE;
DROP TABLE IF EXISTS sop_sub_category CASCADE;
DROP TABLE IF EXISTS sourcemaster CASCADE;
DROP TABLE IF EXISTS sp_profile CASCADE;
DROP TABLE IF EXISTS special_incentive CASCADE;
DROP TABLE IF EXISTS special_plans CASCADE;

-- Table: sop_doc_details_movement
CREATE TABLE sop_doc_details_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  sop_doc_id INT NOT NULL,
  status VARCHAR(100) DEFAULT 'Open',
  document VARCHAR(300),
  remarks VARCHAR(300),
  created_by VARCHAR(100),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: sop_sub_category
CREATE TABLE sop_sub_category (
  category_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  deptid INT NOT NULL,
  catid INT NOT NULL,
  sopsubcat_name VARCHAR(300),
  isactive INT NOT NULL DEFAULT 1,
  created_by VARCHAR(100),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: sourcemaster
CREATE TABLE sourcemaster (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  slno INTEGER NOT NULL DEFAULT 0,
  source VARCHAR(40),
  statuscode VARCHAR(10)
);

-- Table: sp_profile
CREATE TABLE sp_profile (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  speedinkbps VARCHAR(25),
  m_profile VARCHAR(45),
  j_profile VARCHAR(45)
);

-- Table: special_incentive
CREATE TABLE special_incentive (
  incentive_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  scheme VARCHAR(20),
  plantype VARCHAR(10),
  revenueshareid INT,
  subscribercount INT,
  pgid INT,
  lnp BIGINT,
  msp BIGINT,
  isp BIGINT,
  revenue NUMERIC(23,10),
  dotshare NUMERIC(23,10),
  agr NUMERIC(23,10),
  incentive NUMERIC(23,10),
  mspshare NUMERIC(23,10),
  ispshare NUMERIC(23,10),
  monthpart VARCHAR(20),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: special_plans
CREATE TABLE special_plans (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  packageid SERIAL,
  packagename VARCHAR(64),
  renewperiod INT,
  subscriberprofileid INT,
  speed VARCHAR(20),
  billingtypeid INT,
  onetimecharge NUMERIC(10,2) NOT NULL DEFAULT 0.00,
  renewalfee NUMERIC(10,2) DEFAULT 0.00,
  isactive INT NOT NULL DEFAULT 1,
  po_no VARCHAR(45),
  m_profile VARCHAR(45),
  j_profile VARCHAR(45),
  package_type VARCHAR(100),
  allotcated_vol VARCHAR(100),
  fallback_speed VARCHAR(100)
);

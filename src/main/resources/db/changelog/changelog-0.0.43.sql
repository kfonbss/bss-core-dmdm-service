-- Drop tables if they exist
DROP TABLE IF EXISTS sms CASCADE;
DROP TABLE IF EXISTS sms_check CASCADE;
DROP TABLE IF EXISTS smscheck CASCADE;
DROP TABLE IF EXISTS sop_category CASCADE;
DROP TABLE IF EXISTS sop_department CASCADE;
DROP TABLE IF EXISTS sop_doc_details CASCADE;

-- Table: sms
CREATE TABLE sms (
  sms_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id BIGSERIAL,
  sms_date TIMESTAMP,
  sms_to VARCHAR(15),
  sms_msg VARCHAR(400),
  sms_reply VARCHAR(300),
  bil_region VARCHAR(15),
  sms_type VARCHAR(45)
);

CREATE INDEX idx_sms_to ON sms(sms_to);

-- Table: sms_check
CREATE TABLE sms_check (
  check_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  template INTEGER,
  circle VARCHAR(10),
  success INTEGER,
  fail INTEGER,
  smsdate TIMESTAMP,
  create_date TIMESTAMP
);

-- Table: smscheck
CREATE TABLE smscheck (
  check_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  tempid INTEGER,
  mobileno BIGINT,
  status VARCHAR(50),
  circle VARCHAR(10),
  sms_date TIMESTAMP,
  create_date TIMESTAMP
);

-- Table: sop_category
CREATE TABLE sop_category (
  category_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  deptid INTEGER NOT NULL,
  sopcat_name VARCHAR(300),
  isactive INTEGER NOT NULL DEFAULT 1,
  created_by VARCHAR(100),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: sop_department
CREATE TABLE sop_department (
  department_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  department VARCHAR(300),
  approval_role VARCHAR(300),
  isactive INTEGER NOT NULL DEFAULT 1,
  created_by VARCHAR(100),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: sop_doc_details
CREATE TABLE sop_doc_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id SERIAL,
  deptid INTEGER NOT NULL,
  catid INTEGER NOT NULL,
  subcatid INTEGER NOT NULL,
  sop_doc_name VARCHAR(200),
  doc_classification VARCHAR(100),
  top_secret VARCHAR(100),
  sop_remarks VARCHAR(300),
  sop_document VARCHAR(300),
  sop_status VARCHAR(300) DEFAULT 'Open',
  isactive INTEGER NOT NULL DEFAULT 1,
  created_by VARCHAR(100),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

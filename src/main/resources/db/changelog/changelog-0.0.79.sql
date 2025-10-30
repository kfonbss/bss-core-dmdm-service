-- Table : inv_device_cat
DROP TABLE IF EXISTS inv_device_cat CASCADE;

CREATE TABLE inv_device_cat (
  inv_device_cat_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dc_name varchar(100) DEFAULT NULL,
  dc_desc varchar(250) DEFAULT NULL,
  cat_type int DEFAULT 0,
  -- '1=Type-1-Single Band,2=Type-2-Dual Band,3=GPON-4-PON Port-OLT.4=GPON-8-PON Port-OLT',
  ont_type int DEFAULT NULL,
  no_of_pon_port int DEFAULT NULL,
  created_by varchar(70) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_cat PRIMARY KEY (inv_device_cat_id)
);


-- Table : inv_device_condition_status
DROP TABLE IF EXISTS inv_device_condition_status CASCADE;

CREATE TABLE inv_device_condition_status (
  inv_device_condition_status_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  condition_statusid int DEFAULT NULL,
  condition_status_name varchar(100) DEFAULT NULL,
  category INT DEFAULT 1,
  -- '1=Faulty List,2=Return List',
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_condition_status PRIMARY KEY (inv_device_condition_status_id)
);


-- Table : inv_device_details
DROP TABLE IF EXISTS inv_device_details CASCADE;

CREATE TABLE inv_device_details (
  inv_device_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dcid int DEFAULT NULL,
  dmoid int DEFAULT NULL,
  dvid int DEFAULT NULL,
  asset_type INT DEFAULT 1,
  device_slno varchar(250) DEFAULT NULL,
  old_deviceslno varchar(250) DEFAULT NULL,
  slno_updatedate date DEFAULT NULL,
  device_serial_number varchar(250) DEFAULT NULL,
  device_mack varchar(250) DEFAULT NULL,
  sfp_distance varchar(250) DEFAULT NULL,
  invoice_date varchar(12) DEFAULT NULL,
  warranty_sdate varchar(12) DEFAULT NULL,
  warranty_edate varchar(12) DEFAULT NULL,
  po_no varchar(200) DEFAULT NULL,
  file_name varchar(70) DEFAULT NULL,
  device_status int DEFAULT 1,
  noc_id int DEFAULT NULL,
  kfon_dcid int DEFAULT NULL,
  msp_dcid int DEFAULT NULL,
  lnpid bigint DEFAULT NULL,
  subid int DEFAULT NULL,
  user_type INT DEFAULT NULL,
  appid int DEFAULT NULL,
  ce_kycid int DEFAULT NULL,
  reqid int DEFAULT NULL,
  dc_reqid int DEFAULT NULL,
  con_device_type int DEFAULT NULL,
  -- '1=Router,2=Siwtch,3=OLT',
  ip_address varchar(50) DEFAULT NULL,
  port_number varchar(20) DEFAULT NULL,
  secondry_remarks varchar(250) DEFAULT NULL,
  device_mapped_to int DEFAULT NULL,
  -- '1=KFON POP,2=LNP',
  pop_name varchar(100) DEFAULT NULL,
  discovered_inacs int DEFAULT 1,
  device_status_inacs INT DEFAULT NULL,
  -- '1=In-Active,2=Active',
  condition_statusid int DEFAULT 1,
  oem_request_id int DEFAULT NULL,
  repair_status INT DEFAULT 0,
  created_userid int DEFAULT NULL,
  created_username varchar(100) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_details PRIMARY KEY (inv_device_details_id)
);

-- Create indexes for better performance
CREATE INDEX idx_inv_device_details_dtid ON inv_device_details (dtid);
CREATE INDEX idx_inv_device_details_dmid ON inv_device_details (dmid);
CREATE INDEX idx_inv_device_details_dcid ON inv_device_details (dcid);
CREATE INDEX idx_inv_device_details_dmoid ON inv_device_details (dmoid);
CREATE INDEX idx_inv_device_details_dvid ON inv_device_details (dvid);
CREATE INDEX idx_inv_device_details_device_status ON inv_device_details (device_status);
CREATE INDEX idx_inv_device_details_kfon_dcid ON inv_device_details (kfon_dcid);
CREATE INDEX idx_inv_device_details_msp_dcid ON inv_device_details (msp_dcid);
CREATE INDEX idx_inv_device_details_lnpid ON inv_device_details (lnpid);
CREATE INDEX idx_inv_device_details_subid ON inv_device_details (subid);
CREATE INDEX idx_inv_device_details_appid ON inv_device_details (appid);
CREATE INDEX idx_inv_device_details_reqid ON inv_device_details (reqid);
CREATE INDEX idx_inv_device_details_dc_reqid ON inv_device_details (dc_reqid);

-- Table : inv_device_details_audit
DROP TABLE IF EXISTS inv_device_details_audit CASCADE;

CREATE TABLE inv_device_details_audit (
  inv_device_details_audit_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  deviceid int DEFAULT NULL,
  old_deviceid int DEFAULT NULL,
  invoice_date varchar(12) DEFAULT NULL,
  warranty_sdate varchar(12) DEFAULT NULL,
  warranty_edate varchar(12) DEFAULT NULL,
  po_no varchar(200) DEFAULT NULL,
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_details_audit PRIMARY KEY (inv_device_details_audit_id)
);


-- Table : inv_device_details_movement
DROP TABLE IF EXISTS inv_device_details_movement CASCADE;

CREATE TABLE inv_device_details_movement (
  inv_device_details_movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  deviceid int DEFAULT NULL,
  reqid int DEFAULT NULL,
  dc_reqid int DEFAULT NULL,
  lnp_reqid int DEFAULT NULL,
  cnid int DEFAULT NULL,
  device_status int DEFAULT 1,
  noc_id int DEFAULT NULL,
  kfon_dcid int DEFAULT NULL,
  msp_dcid int DEFAULT NULL,
  subid int DEFAULT NULL,
  user_type INT DEFAULT NULL,
  appid bigint DEFAULT NULL,
  ce_kycid int DEFAULT NULL,
  lnpid bigint DEFAULT NULL,
  remarks varchar(100) DEFAULT NULL,
  device_mapped_to int DEFAULT NULL,
  -- '1=KFON POP,2=LNP',
  pop_name varchar(100) DEFAULT NULL,
  condition_statusid int DEFAULT NULL,
  return_faulty_id int DEFAULT NULL,
  oem_request_id int DEFAULT NULL,
  repair_status INT NOT NULL DEFAULT 0,
  return_remarks varchar(250) DEFAULT NULL,
  con_device_type int DEFAULT NULL,
  -- '1=Router,2=Siwtch,3=OLT',
  ip_address varchar(50) DEFAULT NULL,
  port_number varchar(20) DEFAULT NULL,
  secondry_remarks varchar(250) DEFAULT NULL,
  created_by_id bigint DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_details_movement PRIMARY KEY (inv_device_details_movement_id)
);

-- Create indexes for better performance
CREATE INDEX idx_inv_device_details_movement_deviceid ON inv_device_details_movement (deviceid);
CREATE INDEX idx_inv_device_details_movement_reqid ON inv_device_details_movement (reqid);
CREATE INDEX idx_inv_device_details_movement_dc_reqid ON inv_device_details_movement (dc_reqid);
CREATE INDEX idx_inv_device_details_movement_lnp_reqid ON inv_device_details_movement (lnp_reqid);
CREATE INDEX idx_inv_device_details_movement_cnid ON inv_device_details_movement (cnid);
CREATE INDEX idx_inv_device_details_movement_device_status ON inv_device_details_movement (device_status);
CREATE INDEX idx_inv_device_details_movement_kfon_dcid ON inv_device_details_movement (kfon_dcid);
CREATE INDEX idx_inv_device_details_movement_msp_dcid ON inv_device_details_movement (msp_dcid);
CREATE INDEX idx_inv_device_details_movement_subid ON inv_device_details_movement (subid);
CREATE INDEX idx_inv_device_details_movement_user_type ON inv_device_details_movement (user_type);
CREATE INDEX idx_inv_device_details_movement_appid ON inv_device_details_movement (appid);
CREATE INDEX idx_inv_device_details_movement_lnpid ON inv_device_details_movement (lnpid);
CREATE INDEX idx_inv_device_details_movement_device_mapped_to ON inv_device_details_movement (device_mapped_to);
CREATE INDEX idx_inv_device_details_movement_condition_statusid ON inv_device_details_movement (condition_statusid);
CREATE INDEX idx_inv_device_details_movement_return_faulty_id ON inv_device_details_movement (return_faulty_id);
CREATE INDEX idx_inv_device_details_movement_con_device_type ON inv_device_details_movement (con_device_type);
CREATE INDEX idx_inv_device_details_movement_created_by_id ON inv_device_details_movement (created_by_id);

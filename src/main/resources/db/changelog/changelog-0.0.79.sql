-- Table : inv_device_cat
DROP TABLE IF EXISTS inv_device_cat CASCADE;

CREATE TABLE inv_device_cat (
  cat_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dc_name varchar(100) DEFAULT NULL,
  dc_desc varchar(250) DEFAULT NULL,
  cat_type int DEFAULT 0,
  -- '1=Type-1-Single Band,2=Type-2-Dual Band,3=GPON-4-PON Port-OLT.4=GPON-8-PON Port-OLT',
  ont_type int DEFAULT NULL,
  no_of_pon_port int DEFAULT NULL,
  created_by_name varchar(70) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_device_cat PRIMARY KEY (cat_id)
);
INSERT INTO inv_device_cat (
  cat_id, code, name, name_in_local, is_active, id, dtid, dmid, dc_name, dc_desc, cat_type, ont_type,
  no_of_pon_port, created_by_name, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'CAT001', 'Dual Band ONT', 'ഡ്യൂവൽ ബാൻഡ് ഒ.എൻ.ടി', true, 1, 10, 20, 'ONT Device', 'Dual band fiber ONT device with 2 PON ports',
  2, 1, 2, 'System Admin', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
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
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
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
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_device_details PRIMARY KEY (details_id)
);
INSERT INTO inv_device_details (
  details_id, code, name, name_in_local, is_active, id, dtid, dmid, dcid, dmoid, dvid,
  asset_type, device_slno, old_deviceslno, slno_updatedate, device_serial_number, device_mack,
  sfp_distance, invoice_date, warranty_sdate, warranty_edate, po_no, file_name, device_status,
  noc_id, kfon_dcid, msp_dcid, lnpid, subid, user_type, appid, ce_kycid, reqid, dc_reqid,
  con_device_type, ip_address, port_number, secondry_remarks, device_mapped_to, pop_name,
  discovered_inacs, device_status_inacs, condition_statusid, oem_request_id, repair_status,
  created_userid, created_username, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'DEV001', 'GPON OLT Device', 'ജി.പി.ഒ.എൻ ഒ.എൽ.ടി ഉപകരണം', TRUE, 1, 101, 202, 303, 404, 505,
  1, 'SN123456', 'OLD123456', CURRENT_DATE, 'SN987654', 'MAC-AA:BB:CC:DD:EE:FF',
  '20km', '2025-01-15', '2025-01-16', '2028-01-15', 'PO-2025-01', 'invoice_2025.pdf', 1,
  11, 22, 33, 444555666, 77, 1, 88, 99, 100, 111,
  1, '192.168.10.10', '8080', 'Test device remarks', 1, 'KFON POP-1',
  1, 2, 1, 55, 0,
  1010, 'System Admin', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);


-- Create indexes for better performance
CREATE INDEX idx_inv_device_details_device_status ON inv_device_details (device_status);
CREATE INDEX idx_inv_device_details_dc_reqid ON inv_device_details (dc_reqid);

-- Table : inv_device_details_audit
DROP TABLE IF EXISTS inv_device_details_audit CASCADE;

CREATE TABLE inv_device_details_audit (
  audit_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  deviceid int DEFAULT NULL,
  old_deviceid int DEFAULT NULL,
  invoice_date varchar(12) DEFAULT NULL,
  warranty_sdate varchar(12) DEFAULT NULL,
  warranty_edate varchar(12) DEFAULT NULL,
  po_no varchar(200) DEFAULT NULL,
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_device_details_audit PRIMARY KEY (audit_id)
);
INSERT INTO inv_device_details_audit (
  audit_id, id, code, name, name_in_local, is_active, deviceid, old_deviceid,
  invoice_date, warranty_sdate, warranty_edate, po_no,
  created_by_id, created_by_name, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 'AUD001', 'Device Audit Entry', 'ഡിവൈസ് ഓഡിറ്റ് എൻട്രി', true,
  101, 99, '2024-06-10', '2024-06-15', '2027-06-15', 'PO-123456',
  11, 'AuditUser', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
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

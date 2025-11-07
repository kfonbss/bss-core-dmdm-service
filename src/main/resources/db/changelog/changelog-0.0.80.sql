-- Table : inv_device_make
DROP TABLE IF EXISTS inv_device_make CASCADE;

CREATE TABLE inv_device_make (
  inv_device_make_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dm_name varchar(100) DEFAULT NULL,
  dm_desc varchar(250) DEFAULT NULL,
  maker_id int DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_make PRIMARY KEY (inv_device_make_id)
);

INSERT INTO inv_device_make (
  inv_device_make_id, id, dtid, dm_name, dm_desc, maker_id,
  code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 101, 'Cisco Systems', 'High-performance network devices', 201,
  'MAKE-001', 'Cisco', 'സിസ്കോ', TRUE,
  NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);



-- Table : inv_device_model
DROP TABLE IF EXISTS inv_device_model CASCADE;

CREATE TABLE inv_device_model (
  inv_device_model_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dcid int DEFAULT NULL,
  dmo_name varchar(100) DEFAULT NULL,
  dmo_desc varchar(250) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_model PRIMARY KEY (inv_device_model_id)
);

INSERT INTO inv_device_model (
  inv_device_model_id, id, dtid, dmid, dcid, dmo_name, dmo_desc,
  code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 101, 1, 301, 'Cisco Catalyst 9300', 'Enterprise-class network switch',
  'MODEL-001', 'Catalyst 9300', 'കാറ്റലിസ്റ്റ് 9300', TRUE,
  NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table : inv_device_return_tooem
DROP TABLE IF EXISTS inv_device_return_tooem CASCADE;

CREATE TABLE inv_device_return_tooem (
  inv_device_return_tooem_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  returncount int DEFAULT NULL,
  request_status int DEFAULT 1,
  -- '1=Request Created By KFON-DC,2=Request Approved By KFON-DGM,3=Request Rejected By KFON-DGM',
  support_doc varchar(255) DEFAULT NULL,
  kfondc_id int DEFAULT NULL,
  remarks text DEFAULT NULL,
  approval_reject_remarks text DEFAULT NULL,
  enable_for_dgm INT DEFAULT 0,
  created_by_id bigint DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=Inactive,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_return_tooem PRIMARY KEY (inv_device_return_tooem_id)
);

INSERT INTO inv_device_return_tooem (
  inv_device_return_tooem_id, id, returncount, request_status, support_doc,
  kfondc_id, remarks, approval_reject_remarks, enable_for_dgm, created_by_id,
  code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 5, 1, 'RETURN_DOC_2025_001.pdf',
  1001, 'Defective routers returned to OEM', 'Pending DGM approval', 0, 501,
  'RET-001', 'Device Return to OEM', 'ഡിവൈസ് മടക്കൽ ഒഇഎമ്മിലേക്ക്', TRUE,
  NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);



-- Table : inv_device_status
DROP TABLE IF EXISTS inv_device_status CASCADE;

CREATE TABLE inv_device_status (
  inv_device_status_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  status_id int DEFAULT NULL,
  device_status_name varchar(100) DEFAULT NULL,
  global_user INT DEFAULT 1,
  kfondc_user INT DEFAULT 0,
  mspdc_user INT DEFAULT 0,
  partner_user INT DEFAULT 0,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_status PRIMARY KEY (inv_device_status_id)
);

INSERT INTO inv_device_status (
  inv_device_status_id, id, status_id, device_status_name,
  global_user, kfondc_user, mspdc_user, partner_user,
  code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 1, 101, 'Available',
  1, 1, 0, 0,
  'STS-001', 'Device Available', 'ഡിവൈസ് ലഭ്യമാണ്', TRUE,
  NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table : inv_device_type
DROP TABLE IF EXISTS inv_device_type CASCADE;

CREATE TABLE inv_device_type (
  inv_device_type_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dt_name varchar(100) DEFAULT NULL,
  dt_desc varchar(250) DEFAULT NULL,
  device_type int DEFAULT 0,
  -- '1=OLT,2=ONT,3=Switch,4=SFP=5=Fiber Patch cord,6=PON SFP',
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_type PRIMARY KEY (inv_device_type_id)
);

INSERT INTO inv_device_type (
  inv_device_type_id, id, dt_name, dt_desc, device_type, code, name, name_in_local,
  is_active, created_date, modified_date, created_by, modified_by
) VALUES
(gen_random_uuid(), 1, 'OLT Device', 'Optical Line Terminal device used for fiber distribution', 1, 'DT001', 'OLT', 'ഓ.എൽ.ടി.', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_device_vendor
DROP TABLE IF EXISTS inv_device_vendor CASCADE;

CREATE TABLE inv_device_vendor (
  inv_device_vendor_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dcid int DEFAULT NULL,
  dmoid int DEFAULT NULL,
  dve_name varchar(100) DEFAULT NULL,
  dve_desc varchar(250) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_vendor PRIMARY KEY (inv_device_vendor_id)
);

INSERT INTO inv_device_vendor (
  inv_device_vendor_id, id, dtid, dmid, dcid, dmoid, dve_name, dve_desc, code, name, name_in_local,
  is_active, created_date, modified_date, created_by, modified_by
) VALUES
(gen_random_uuid(), 1, 1, 1, 1, 1, 'Cisco Systems', 'Leading network equipment vendor', 'DV001', 'Cisco', 'സിസ്കോ', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_dtransfer_request
DROP TABLE IF EXISTS inv_dtransfer_request CASCADE;

CREATE TABLE inv_dtransfer_request (
  inv_dtransfer_request_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dcid int DEFAULT NULL,
  dmoid int DEFAULT NULL,
  noc_id int DEFAULT NULL,
  kfon_dcid int DEFAULT NULL,
  device_count int DEFAULT 0,
  transfer_type int DEFAULT 1,
  -- '1=Normal,2=Bulk',
  request_status int DEFAULT 1,
  -- '1=KFON-MGR Ceated the request,2=KFON-GM Approved the   request,3=KFON-GM Rejected the request',
  remarks varchar(150) DEFAULT NULL,
  accepted_count int DEFAULT 0,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_dtransfer_request PRIMARY KEY (inv_dtransfer_request_id)
);

INSERT INTO inv_dtransfer_request (
  inv_dtransfer_request_id, dtid, dmid, dcid, dmoid, noc_id, kfon_dcid,
  device_count, transfer_type, request_status, remarks,
  accepted_count, code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
)
VALUES
  (gen_random_uuid(), 101, 201, 301, 401, 501, 601, 10, 1, 1, 'Initial transfer request', 5, 'TRF001', 'Device Transfer Request 1', 'ഡിവൈസ് ട്രാൻസ്ഫർ 1', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_dtransfer_rmovement
DROP TABLE IF EXISTS inv_dtransfer_rmovement CASCADE;

CREATE TABLE inv_dtransfer_rmovement (
  inv_dtransfer_rmovement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  reqid int DEFAULT NULL,
  request_status int DEFAULT 1,
  -- '1=KFON-MGR Ceated the request,2=KFON-GM Approved the   request,3=KFON-GM Rejected the request',
  remarks varchar(150) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_dtransfer_rmovement PRIMARY KEY (inv_dtransfer_rmovement_id)
);

INSERT INTO inv_dtransfer_rmovement (
  inv_dtransfer_rmovement_id, reqid, request_status, remarks,
  code, name, name_in_local, is_active,
  created_date, modified_date, created_by, modified_by
)
VALUES
  (gen_random_uuid(), 1, 1, 'Movement initiated by MGR', 'RMV001', 'Device Movement 1', 'ഡിവൈസ് മൂവ്‌മെന്റ് 1', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_kfondc_device_request
DROP TABLE IF EXISTS inv_kfondc_device_request CASCADE;

CREATE TABLE inv_kfondc_device_request (
  request_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  device_count int DEFAULT 0,
  status INT DEFAULT 0,
  -- '1=Request Created,2=Request Approved,3=Request Rejected',
  kfon_dcid int DEFAULT NULL,
  remarks varchar(250) DEFAULT NULL,
  rej_app_remarks varchar(250) DEFAULT NULL,
  accepted_count int DEFAULT 0,
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_kfondc_device_request PRIMARY KEY (request_id)
);
INSERT INTO inv_kfondc_device_request (
  request_id, code, name, name_in_local, is_active, id, device_count, status,
  kfon_dcid, remarks, rej_app_remarks, accepted_count, created_by_id,
  created_by_name, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'REQ001', 'KFON DC Device Request', 'കെഫോൺ ഡി.സി ഉപകരണ അഭ്യർത്ഥന', TRUE, 1,
  50, 2, 101, 'Request approved for 50 ONT devices', 'Approved successfully',
  50, 1001, 'System Admin', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);

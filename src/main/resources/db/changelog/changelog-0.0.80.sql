-- Table : inv_device_make
DROP TABLE IF EXISTS inv_device_make CASCADE;

CREATE TABLE inv_device_make (
  inv_device_make_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  dm_name varchar(100) DEFAULT NULL,
  dm_desc varchar(250) DEFAULT NULL,
  maker_id int DEFAULT NULL,
  created_by varchar(70) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_make PRIMARY KEY (inv_device_make_id)
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
  created_by varchar(70) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_model PRIMARY KEY (inv_device_model_id)
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
  created_by_name varchar(150) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=Inactive,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_return_tooem PRIMARY KEY (inv_device_return_tooem_id)
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
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_status PRIMARY KEY (inv_device_status_id)
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
  created_by varchar(70) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_type PRIMARY KEY (inv_device_type_id)
);


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
  created_by varchar(70) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_device_vendor PRIMARY KEY (inv_device_vendor_id)
);


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
  created_by varchar(70) DEFAULT NULL,
  accepted_count int DEFAULT 0,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_dtransfer_request PRIMARY KEY (inv_dtransfer_request_id)
);


-- Table : inv_dtransfer_rmovement
DROP TABLE IF EXISTS inv_dtransfer_rmovement CASCADE;

CREATE TABLE inv_dtransfer_rmovement (
  inv_dtransfer_rmovement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  reqid int DEFAULT NULL,
  request_status int DEFAULT 1,
  -- '1=KFON-MGR Ceated the request,2=KFON-GM Approved the   request,3=KFON-GM Rejected the request',
  remarks varchar(150) DEFAULT NULL,
  created_by varchar(70) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_dtransfer_rmovement PRIMARY KEY (inv_dtransfer_rmovement_id)
);


-- Table : inv_kfondc_device_request
DROP TABLE IF EXISTS inv_kfondc_device_request CASCADE;

CREATE TABLE inv_kfondc_device_request (
  inv_kfondc_device_request_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_kfondc_device_request PRIMARY KEY (inv_kfondc_device_request_id)
);
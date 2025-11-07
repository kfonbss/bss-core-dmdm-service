-- Table : inv_lnp_device_request
DROP TABLE IF EXISTS inv_lnp_device_request CASCADE;

CREATE TABLE inv_lnp_device_request (
  inv_lnp_device_request_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  dtid int DEFAULT NULL,
  req_dev_count int DEFAULT 0,
  app_dev_count int DEFAULT 0,
  device_type int DEFAULT 0,
  lnpid int DEFAULT NULL,
  mspdc_id int DEFAULT NULL,
  request_from int DEFAULT 1,
  remarks varchar(250) DEFAULT NULL,
  request_status int DEFAULT 1,
  -- '1=LNP Raised a request,2=DC Approved Request,3=DC Rejected Request',
  approve_remarks varchar(250) DEFAULT NULL,
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
CONSTRAINT pk_inv_lnp_device_request PRIMARY KEY (inv_lnp_device_request_id)
);

INSERT INTO inv_lnp_device_request (inv_lnp_device_request_id, dtid, req_dev_count, app_dev_count, device_type, lnpid, mspdc_id, request_from, remarks, request_status, approve_remarks, accepted_count, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 101, 10, 8, 2, 501, 301, 1, 'Initial request for devices', 1, 'Approved partially', 8, 'LNP001', 'LNP Request 1', 'എൽഎൻപി അഭ്യർത്ഥന 1', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_lnp_device_request_movement
DROP TABLE IF EXISTS inv_lnp_device_request_movement CASCADE;

CREATE TABLE inv_lnp_device_request_movement (
  inv_lnp_device_request_movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  reqid int DEFAULT NULL,
  remarks varchar(250) DEFAULT NULL,
  request_status int DEFAULT 1,
  -- '1=LNP Raised a request,2=DC Approved Request,3=DC Rejected Request,4=LNP acknowledged ',
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
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
CONSTRAINT pk_inv_lnp_device_request_movement PRIMARY KEY (inv_lnp_device_request_movement_id)
);

INSERT INTO inv_lnp_device_request_movement (inv_lnp_device_request_movement_id, reqid, remarks, request_status, created_by_id, created_by_name, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 101, 'Request raised by LNP', 1, 1001, 'John LNP', 'LNPMV001', 'LNP Request Movement 1', 'എൽഎൻപി അഭ്യർത്ഥന ചലനം 1', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_po_details
DROP TABLE IF EXISTS inv_po_details CASCADE;

CREATE TABLE inv_po_details (
  inv_po_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  po_no varchar(200) DEFAULT NULL,
  remarks varchar(250) DEFAULT NULL,
  created_by_id int DEFAULT NULL,
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
CONSTRAINT pk_inv_po_details PRIMARY KEY (inv_po_details_id)
);

INSERT INTO inv_po_details (
  inv_po_details_id, po_no, remarks, created_by_id, code, name, name_in_local,
  is_active, created_date, modified_date, created_by, modified_by
) VALUES
  (gen_random_uuid(), 'PO-001', 'First batch of routers', 101, 'PO001', 'Router Purchase', 'റൗട്ടർ വാങ്ങൽ', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_po_documnets
DROP TABLE IF EXISTS inv_po_documnets CASCADE;

CREATE TABLE inv_po_documnets (
  inv_po_documnets_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  poid int DEFAULT NULL,
  documnet varchar(250) DEFAULT NULL,
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
CONSTRAINT pk_inv_po_documnets PRIMARY KEY (inv_po_documnets_id)
);

INSERT INTO inv_po_documnets (
  inv_po_documnets_id, poid, documnet, code, name, name_in_local,
  is_active, created_date, modified_date, created_by, modified_by
) VALUES
  (gen_random_uuid(), 1, 'po_001_invoice.pdf', 'DOC001', 'Invoice for PO-001', 'PO-001 ഇൻവോയ്സ്', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table : inv_return_faulty_request
DROP TABLE IF EXISTS inv_return_faulty_request CASCADE;

CREATE TABLE inv_return_faulty_request (
  inv_return_faulty_request_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  deviceid int DEFAULT NULL,
  condition_statusid int DEFAULT NULL,
  request_type INT DEFAULT 1,
  -- '1=Faulty Request,2=Return Request',
  status INT DEFAULT 1,
  -- '1=Open,2=Approved,3=Rejected',
  lnpid int DEFAULT NULL,
  mspdc_id int DEFAULT NULL,
  kfondc_id int DEFAULT NULL,
  noc_id int DEFAULT NULL,
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_inv_return_faulty_request PRIMARY KEY (inv_return_faulty_request_id)
);


-- Table : invoice_creditnote
DROP TABLE IF EXISTS invoice_creditnote CASCADE;

CREATE TABLE invoice_creditnote (
  invoice_creditnote_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  subtype int DEFAULT 1,
  customerid int DEFAULT NULL,
  no_of_loc varchar(20) DEFAULT 1,
  service_invoice varchar(64) DEFAULT NULL,
  service_invoiceid int DEFAULT NULL,
  notenumber varchar(64) DEFAULT NULL,
  serviceinvoice_date date DEFAULT NULL,
  baseamount decimal(26,10) DEFAULT NULL,
  gstamount decimal(26,10) DEFAULT NULL,
  servicestartdate timestamp DEFAULT NULL,
  serviceenddate timestamp DEFAULT NULL,
  gstrate int DEFAULT NULL,
  cgstrate int DEFAULT NULL,
  sgstrate int DEFAULT NULL,
  igstrate int DEFAULT NULL,
  gstin varchar(18) DEFAULT NULL,
  pan varchar(20) DEFAULT NULL,
  taxpayertype int DEFAULT NULL,
  payment_type INT DEFAULT 1,
  einvoice_status INT DEFAULT 0,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_invoice_creditnote PRIMARY KEY (invoice_creditnote_id)
);


-- Table : invoice_creditnote_details
DROP TABLE IF EXISTS invoice_creditnote_details CASCADE;

CREATE TABLE invoice_creditnote_details (
  invoice_creditnote_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  subtype int DEFAULT 1,
  -- '2=ILL,3=DF,4-EO,5-SPE',
  type int DEFAULT NULL,
  servicename varchar(100) DEFAULT NULL,
  packageid varchar(100) DEFAULT NULL,
  packagename varchar(100) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  subname varchar(100) DEFAULT NULL,
  linkid varchar(250) DEFAULT NULL,
  linkname varchar(250) DEFAULT NULL,
  service_invoice varchar(64) DEFAULT NULL,
  service_invoiceid int DEFAULT NULL,
  noteid int NOT NULL,
  notenumber varchar(64) DEFAULT NULL,
  baseamount decimal(26,10) DEFAULT NULL,
  basegst decimal(26,10) DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  credit_amount decimal(26,10) DEFAULT NULL,
  credit_gst decimal(26,10) DEFAULT NULL,
  credit_cgst decimal(26,10) DEFAULT NULL,
  credit_sgst decimal(26,10) DEFAULT NULL,
  credit_igst decimal(26,10) DEFAULT NULL,
  paid_amount decimal(26,10) DEFAULT 0.0000000000,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_invoice_creditnote_details PRIMARY KEY (invoice_creditnote_details_id)
);


-- Table : invoice_statecode
DROP TABLE IF EXISTS invoice_statecode CASCADE;

CREATE TABLE invoice_statecode (
  invoice_statecode_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  STCode char(3) DEFAULT NULL,
  state_code varchar(10) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_invoice_statecode PRIMARY KEY (invoice_statecode_id)
);


-- Table : issuehistory
DROP TABLE IF EXISTS issuehistory CASCADE;

CREATE TABLE issuehistory (
  issuehistory_id UUID DEFAULT gen_random_uuid() NOT NULL,
  ticketid varchar(50) DEFAULT NULL,
  assignedto varchar(100) DEFAULT NULL,
  createdby varchar(100) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  date timestamp DEFAULT NULL,
  ticketno int NOT NULL DEFAULT 0,
  oldstatus varchar(50) DEFAULT NULL,
  oldassignedto varchar(100) DEFAULT NULL,
  remarks varchar(200) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_issuehistory PRIMARY KEY (issuehistory_id)
);


-- Table : issuetracker
DROP TABLE IF EXISTS issuetracker CASCADE;

CREATE TABLE issuetracker (
  issuetracker_id UUID DEFAULT gen_random_uuid() NOT NULL,
  ticketno SERIAL,
  partnerid varchar(50) DEFAULT NULL,
  username varchar(100) DEFAULT NULL,
  time_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  issue varchar(255) DEFAULT NULL,
  startdate timestamp DEFAULT NULL,
  modifiedon date DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  assignedto varchar(100) DEFAULT NULL,
  createdby varchar(100) DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  etr varchar(20) DEFAULT NULL,
  downtime varchar(50) DEFAULT NULL,
  resolution varchar(255) DEFAULT NULL,
  owner varchar(20) DEFAULT NULL,
  source varchar(20) DEFAULT NULL,
  issuetype varchar(50) DEFAULT NULL,
  expclosedate timestamp DEFAULT NULL,
  modifiedby varchar(100) DEFAULT NULL,
  actualclosedate timestamp DEFAULT NULL,
  priority varchar(20) DEFAULT NULL,
  custstatus varchar(10) DEFAULT NULL,
  feedback varchar(255) DEFAULT NULL,
  ticketid varchar(50) DEFAULT NULL,
  statecode varchar(45) DEFAULT NULL,
  responsemsg varchar(255) DEFAULT NULL,
  sendsms varchar(3) DEFAULT NULL,
  smsdate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_issuetracker PRIMARY KEY (issuetracker_id)
);
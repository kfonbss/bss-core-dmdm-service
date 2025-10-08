-- Table : endoffice_master_details
DROP TABLE IF EXISTS endoffice_master_details CASCADE;

CREATE TABLE endoffice_master_details (
  endoffice_master_details_id UUID NOT NULL,
  id SERIAL,
  boqid varchar(50) DEFAULT NULL,
  mstype char(5) DEFAULT NULL,
  district char(50) DEFAULT NULL,
  popname varchar(100) DEFAULT NULL,
  eoname varchar(128) DEFAULT NULL,
  boqshort int DEFAULT NULL,
  contactperson varchar(50) DEFAULT NULL,
  mobile varchar(12) DEFAULT NULL,
  contactno varchar(12) DEFAULT NULL,
  landline varchar(50) DEFAULT NULL,
  upgrade char(10) DEFAULT NULL,
  fir char(20) DEFAULT NULL,
  ontattachment varchar(256) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_endoffice_master_details PRIMARY KEY (endoffice_master_details_id)
);


-- Table : endoffice_nms_master
DROP TABLE IF EXISTS endoffice_nms_master CASCADE;

CREATE TABLE endoffice_nms_master (
  endoffice_nms_master_id UUID NOT NULL,
  id SERIAL,
  boqid varchar(100) DEFAULT NULL,
  loc_code varchar(20) DEFAULT NULL,
  popname varchar(100) DEFAULT NULL,
  conn_status varchar(100) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_endoffice_nms_master PRIMARY KEY (endoffice_nms_master_id)
);


-- Table : enq_location
DROP TABLE IF EXISTS enq_location CASCADE;

CREATE TABLE enq_location (
  enq_location_id UUID NOT NULL,
  enq_ref varchar(60) DEFAULT NULL,
  enq_id SERIAL,
  location_name varchar(200) DEFAULT NULL,
  locadr text DEFAULT NULL,
  pincode int DEFAULT NULL,
  district varchar(45) DEFAULT NULL,
  feasibility_update varchar(10) DEFAULT NULL,
  -- above is enum('','0','1') DEFAULT NULL,
  speed varchar(45) DEFAULT NULL,
  unit varchar(10) DEFAULT 'Mbps',
  -- above is enum('Kbps','Mbps','Gbps') DEFAULT 'Mbps',
  connection_type varchar(10) DEFAULT NULL,
  -- above is enum('Home','Others','FUP','Unlimited') DEFAULT NULL,
  validity varchar(45) DEFAULT NULL,
  refeasibility_check varchar(10) DEFAULT NULL,
  -- above is enum('0','1') DEFAULT NULL,
  pkg_created int DEFAULT NULL,
  service_type varchar(45) DEFAULT 1,
  latitude varchar(45) DEFAULT NULL,
  longitude varchar(45) DEFAULT NULL,
  boqid varchar(512) DEFAULT NULL,
  mobileno varchar(12) DEFAULT NULL,
  constituency varchar(256) DEFAULT NULL,
  gramapanchayath varchar(256) DEFAULT NULL,
  category varchar(256) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_enq_location PRIMARY KEY (enq_location_id)
);


-- Table : enquiry_management
DROP TABLE IF EXISTS enquiry_management CASCADE;

CREATE TABLE enquiry_management (
  enquiry_management_id UUID NOT NULL,
  id SERIAL,
  enq_ref varchar(60) DEFAULT NULL,
  cmp_name varchar(60) DEFAULT NULL,
  district varchar(45) DEFAULT NULL,
  pincode int DEFAULT NULL,
  address text DEFAULT NULL,
  contactemail varchar(60) DEFAULT NULL,
  mobileno varchar(45) DEFAULT NULL,
  pan varchar(45) DEFAULT NULL,
  payment_type varchar(10) DEFAULT 'postpaid',
  -- above is enum('prepaid','postpaid') DEFAULT 'postpaid',
  gstinval varchar(45) DEFAULT NULL,
  created_by int DEFAULT NULL,
  CreatedOn timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  feasibility_status varchar(10) DEFAULT 'Enquiry',
  -- above is enum('Enquiry','Feasibile','Not_Feasibile','On_Hold','Quotation_Given','Under_Negotiation','Order_Confirmed','Service_Provisioning_Completed') DEFAULT 'Enquiry',
  assigning_status varchar(10) NOT NULL DEFAULT 0,
  --above is enum('0','1') DEFAULT 0,
  quotation_created varchar(10) DEFAULT 0,
  -- above is enum('0','1') DEFAULT 0,
  -- Primary key constraint
CONSTRAINT pk_enquiry_management PRIMARY KEY (enquiry_management_id)
);

-- Table : eo
DROP TABLE IF EXISTS eo CASCADE;

CREATE TABLE eo (
  eo_id UUID NOT NULL,
  id SERIAL,
  linkcode char(10) DEFAULT NULL,
  boqid varchar(256) DEFAULT NULL,
  mstype char(10) DEFAULT NULL,
  district_code char(10) DEFAULT NULL,
  popname varchar(256) DEFAULT NULL,
  location varchar(256) DEFAULT NULL,
  endoffice_name varchar(512) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_eo PRIMARY KEY (eo_id)
);


-- Table : eo_master
DROP TABLE IF EXISTS eo_master CASCADE;

CREATE TABLE eo_master (
  eo_master_id UUID NOT NULL,
  id SERIAL,
  mstype char(10) DEFAULT NULL,
  district varchar(128) DEFAULT NULL,
  pop varchar(256) DEFAULT NULL,
  endoffice varchar(512) DEFAULT NULL,
  address1 text DEFAULT NULL,
  address2 text DEFAULT NULL,
  location varchar(512) DEFAULT NULL,
  secdepartment varchar(512) DEFAULT NULL,
  linedepartment varchar(512) DEFAULT NULL,
  contactperson varchar(256) DEFAULT NULL,
  mobile varchar(256) DEFAULT NULL,
  email varchar(256) DEFAULT NULL,
  landline varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  pincode varchar(10) DEFAULT NULL,
  landmark varchar(300) DEFAULT NULL,
  updated_dt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_eo_master PRIMARY KEY (eo_master_id)
);


-- Table : eo_master_tmp
DROP TABLE IF EXISTS eo_master_tmp CASCADE;

CREATE TABLE eo_master_tmp (
  eo_master_tmp_id UUID NOT NULL,
  id SERIAL,
  mstype char(10) DEFAULT NULL,
  district varchar(128) DEFAULT NULL,
  pop varchar(256) DEFAULT NULL,
  endoffice varchar(512) DEFAULT NULL,
  address1 text DEFAULT NULL,
  address2 text DEFAULT NULL,
  location varchar(512) DEFAULT NULL,
  secdepartment varchar(512) DEFAULT NULL,
  linedepartment varchar(512) DEFAULT NULL,
  contactperson varchar(256) DEFAULT NULL,
  mobile varchar(256) DEFAULT NULL,
  email varchar(256) DEFAULT NULL,
  landline varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  pincode varchar(10) DEFAULT NULL,
  landmark varchar(300) DEFAULT NULL,
  updated_dt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_eo_master_tmp PRIMARY KEY (eo_master_tmp_id)
);


-- Table : expirycheck
DROP TABLE IF EXISTS expirycheck CASCADE;

CREATE TABLE expirycheck (
  expirycheck_id UUID NOT NULL,
  id SERIAL,
  subscriberid int DEFAULT NULL,
  username varchar(64) DEFAULT NULL,
  startdate timestamp DEFAULT NULL,
  expirydate timestamp DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_expirycheck PRIMARY KEY (expirycheck_id)
);


-- Table : failed_jobs
DROP TABLE IF EXISTS failed_jobs CASCADE;

CREATE TABLE failed_jobs (
  failed_jobs_id UUID NOT NULL,
  id SERIAL,
  uuid varchar(255) NOT NULL,
  connection text NOT NULL,
  queue text  NOT NULL,
  payload text  NOT NULL,
  exception text NOT NULL,
  failed_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_failed_jobs_uuid UNIQUE (uuid),
  -- Primary key constraint
CONSTRAINT pk_failed_jobs PRIMARY KEY (failed_jobs_id)
);


-- Table : fengremarks
DROP TABLE IF EXISTS fengremarks CASCADE;

CREATE TABLE fengremarks (
  fengremarks_id UUID NOT NULL,
  id SERIAL,
  taskid int DEFAULT NULL,
  remarks varchar(500) DEFAULT NULL,
  "user" varchar(50) DEFAULT NULL,
  createtime timestamp DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_fengremarks PRIMARY KEY (fengremarks_id)
);


-- Table : fengtask
DROP TABLE IF EXISTS fengtask CASCADE;

CREATE TABLE fengtask (
  fengtask_id UUID NOT NULL,
  id SERIAL,
  emp_id int DEFAULT NULL,
  task text DEFAULT NULL,
  status varchar(25) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_fengtask PRIMARY KEY (fengtask_id)
);
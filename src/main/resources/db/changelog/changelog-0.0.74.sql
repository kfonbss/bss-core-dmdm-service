-- Table : field_eng
DROP TABLE IF EXISTS field_eng CASCADE;

CREATE TABLE field_eng (
  field_eng_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  emp_name varchar(30) DEFAULT NULL,
  user_name varchar(30) DEFAULT NULL,
  emp_code varchar(10) DEFAULT NULL,
  emp_email varchar(30) DEFAULT NULL,
  mobileno varchar(50) DEFAULT NULL,
  emp_district varchar(50) DEFAULT NULL,
  target int DEFAULT 0,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_field_eng PRIMARY KEY (field_eng_id)
);


-- Table : field_eng_district
DROP TABLE IF EXISTS field_eng_district CASCADE;

CREATE TABLE field_eng_district (
  field_eng_district_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  district varchar(30) DEFAULT NULL,
  code varchar(30) DEFAULT NULL,
  is_active int DEFAULT 1,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_field_eng_district PRIMARY KEY (field_eng_district_id)
);


-- Table : fileupload
DROP TABLE IF EXISTS fileupload CASCADE;

CREATE TABLE fileupload (
  fileupload_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  time_date timestamp DEFAULT NULL,
  fileupload varchar(255) DEFAULT NULL,
  uploadedby varchar(100) DEFAULT NULL,
  ticketno int DEFAULT NULL,
  taskname varchar(100) DEFAULT NULL,
  type varchar(100) DEFAULT NULL,
  size varchar(50) DEFAULT NULL,
  path varchar(250) DEFAULT NULL,
  date date DEFAULT NULL,
  name varchar(100) DEFAULT NULL,
  projectid int DEFAULT NULL,
  resourceid varchar(100) DEFAULT NULL,
  ticketid varchar(30) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_fileupload PRIMARY KEY (fileupload_id)
);


-- Table : fileupload_bank
DROP TABLE IF EXISTS fileupload_bank CASCADE;

CREATE TABLE fileupload_bank (
  fileupload_bank_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  time_date timestamp DEFAULT NULL,
  fileupload varchar(255) DEFAULT NULL,
  uploadedby varchar(100) DEFAULT NULL,
  type varchar(100) DEFAULT NULL,
  size varchar(50) DEFAULT NULL,
  path varchar(250) DEFAULT NULL,
  date date DEFAULT NULL,
  name varchar(100) DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_fileupload_bank PRIMARY KEY (fileupload_bank_id)
);


-- Table : fileuploads
DROP TABLE IF EXISTS fileuploads CASCADE;

CREATE TABLE fileuploads (
  fileuploads_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  time_date timestamp DEFAULT NULL,
  uploadedby varchar(100) DEFAULT NULL,
  ticketid varchar(30) DEFAULT NULL,
  type varchar(100) DEFAULT NULL,
  size varchar(50) DEFAULT NULL,
  path varchar(250) DEFAULT NULL,
  filename varchar(100) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_fileuploads PRIMARY KEY (fileuploads_id)
);


-- Table : fin_agpinvoicing
DROP TABLE IF EXISTS fin_agpinvoicing CASCADE;

CREATE TABLE fin_agpinvoicing (
  fin_agpinvoicing_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  invoicemonth varchar(20) DEFAULT NULL,
  status INT DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  remarks varchar(100) DEFAULT NULL,
  agpid bigint DEFAULT NULL,
  designation varchar(50) DEFAULT NULL,
  verifiedby varchar(50) DEFAULT NULL,
  approvedate timestamp DEFAULT NULL,
  invoiceno varchar(50) DEFAULT NULL,
  anp_invoiceno varchar(100) DEFAULT NULL,
  nettotal decimal(10,2) DEFAULT NULL,
  STtotal decimal(10,2) DEFAULT NULL,
  GrossTotal decimal(10,2) DEFAULT NULL,
  dot decimal(10,2) DEFAULT NULL,
  agrtotal decimal(10,2) DEFAULT NULL,
  agpshare decimal(10,2) DEFAULT NULL,
  agpewsshare decimal(10,2) DEFAULT NULL,
  netshare decimal(10,2) DEFAULT NULL,
  STpartner decimal(10,2) DEFAULT NULL,
  GrossShare decimal(10,2) DEFAULT NULL,
  TDSpartner decimal(10,2) DEFAULT NULL,
  NetPayable decimal(10,2) DEFAULT NULL,
  STno varchar(45) DEFAULT NULL,
  Pan varchar(12) DEFAULT NULL,
  requestdate timestamp DEFAULT NULL,
  response varchar(300) DEFAULT NULL,
  responsedate timestamp DEFAULT NULL,
  spocapproval INT NOT NULL DEFAULT 0,
  spocapprove_date timestamp DEFAULT NULL,
  spocremark varchar(300) DEFAULT NULL,
  mspresponse varchar(300) DEFAULT NULL,
  tmapproval INT NOT NULL DEFAULT 0,
  tmremark varchar(300) DEFAULT NULL,
  tmresponse varchar(300) DEFAULT NULL,
  spocresponse varchar(300) DEFAULT NULL,
  mspagpresponse varchar(300) DEFAULT NULL,
  gsround decimal(10,2) DEFAULT NULL,
  tdsround decimal(10,2) DEFAULT NULL,
  sbcess decimal(10,2) DEFAULT 0.00,
  kkcess decimal(10,2) DEFAULT NULL,
  deemedappvdate timestamp DEFAULT NULL,
  gst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  cgst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  sgst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  igst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  gst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  cgst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  sgst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  igst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  paid_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  gstin varchar(15) DEFAULT NULL,
  bank_name varchar(120) DEFAULT NULL,
  bank_branch varchar(120) DEFAULT NULL,
  bank_account varchar(50) DEFAULT NULL,
  bank_beneficiray varchar(50) DEFAULT NULL,
  bank_ifsc varchar(50) DEFAULT NULL,
  gst_disburse_status INT NOT NULL DEFAULT 0,
  STCode char(3) DEFAULT NULL,
  pst_code char(3) DEFAULT NULL,
  taxpayertype INT NOT NULL DEFAULT 0,
  gst_disbursedate timestamp DEFAULT NULL,
  sgsttds_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  cgsttds_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  cashbackrev decimal(10,2) DEFAULT NULL,
  normalrevenue decimal(12,2) DEFAULT NULL,
  ewsrevenue decimal(12,2) DEFAULT NULL,
  ottrevenue decimal(13,2) DEFAULT NULL,
  ottshare decimal(13,2) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_fin_agpinvoicing PRIMARY KEY (fin_agpinvoicing_id)
);
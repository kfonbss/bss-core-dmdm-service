DROP TABLE IF EXISTS companygstdetail CASCADE;

CREATE TABLE companygstdetail (
  detail_id UUID DEFAULT gen_random_uuid() NOT NULL,
  companyid bigint NOT NULL,
  gstin varchar(20) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_verfied boolean DEFAULT false,
  created_date timestamp DEFAULT NULL,
  createdby bigint DEFAULT NULL,
  verified_date timestamp DEFAULT NULL,
  verfied_by varchar(50) DEFAULT NULL,
  taxpayertype boolean DEFAULT NULL,
  gst_status boolean DEFAULT false,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  pan varchar(10) DEFAULT NULL,
  pan_copy varchar(200) DEFAULT NULL,
  CONSTRAINT pk_companygstdetail PRIMARY KEY (detail_id)
);


DROP TABLE IF EXISTS connectiontype CASCADE;

CREATE TABLE connectiontype (
  type_id UUID DEFAULT gen_random_uuid() NOT NULL,
  connectiontypeid SERIAL,
  connectiontype varchar(45) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  attribute varchar(45) DEFAULT 'Service-Type',
  value varchar(45) NOT NULL DEFAULT 'Framed-User',
  CONSTRAINT pk_connectiontype PRIMARY KEY (type_id)
);

CREATE UNIQUE INDEX Index_2_connectiontype ON connectiontype (connectiontype);


DROP TABLE IF EXISTS contactcenter CASCADE;

CREATE TABLE contactcenter (
  center_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id int NOT NULL,
  center varchar(128) DEFAULT NULL,
  address1 varchar(256) DEFAULT NULL,
  address2 varchar(256) DEFAULT NULL,
  address3 varchar(256) DEFAULT NULL,
  address4 varchar(256) DEFAULT NULL,
  CONSTRAINT pk_contactcenter PRIMARY KEY (center_id)
);


DROP TABLE IF EXISTS cor_agplist_approval CASCADE;

CREATE TABLE cor_agplist_approval (
  approval_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  agpid bigint DEFAULT NULL,
  state varchar(15) DEFAULT NULL,
  invoicemonth varchar(45) DEFAULT NULL,
  tmapproval int DEFAULT NULL,
  tmremark varchar(300) DEFAULT NULL,
  tmresponse varchar(300) DEFAULT NULL,
  CONSTRAINT pk_cor_agplist_approval PRIMARY KEY (approval_id)
);


DROP TABLE IF EXISTS cor_fin_agpinvoicing CASCADE;

CREATE TABLE cor_fin_agpinvoicing (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  subgroup smallint DEFAULT NULL,
  invoicemonth varchar(20) DEFAULT NULL,
  invoicedate date DEFAULT NULL,
  status int DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  remarks varchar(100) DEFAULT NULL,
  agpid bigint DEFAULT NULL,
  designation varchar(50) DEFAULT NULL,
  verifiedby varchar(50) DEFAULT NULL,
  approvedate timestamp DEFAULT NULL,
  invoiceno varchar(50) DEFAULT NULL,
  nettotal decimal(10,2) DEFAULT NULL,
  STtotal decimal(10,2) DEFAULT NULL,
  GrossTotal decimal(10,2) DEFAULT NULL,
  dot decimal(10,2) DEFAULT NULL,
  agrtotal decimal(10,2) DEFAULT NULL,
  agpshare decimal(10,2) DEFAULT NULL,
  netshare decimal(10,2) DEFAULT NULL,
  STpartner decimal(10,2) DEFAULT NULL,
  GrossShare decimal(10,2) DEFAULT NULL,
  TDSpartner decimal(10,2) DEFAULT NULL,
  NetPayable decimal(10,2) DEFAULT NULL,
  STno varchar(100) DEFAULT NULL,
  Pan varchar(20) DEFAULT NULL,
  requestdate timestamp DEFAULT NULL,
  response varchar(300) DEFAULT NULL,
  responsedate timestamp DEFAULT NULL,
  spocapproval int DEFAULT NULL,
  spocapprove_date timestamp DEFAULT NULL,
  spocremark varchar(300) DEFAULT NULL,
  mspresponse varchar(300) DEFAULT NULL,
  tmapproval int DEFAULT NULL,
  tmremark varchar(300) DEFAULT NULL,
  tmresponse varchar(300) DEFAULT NULL,
  spocresponse varchar(300) DEFAULT NULL,
  mspagpresponse varchar(300) DEFAULT NULL,
  workorderid varchar(45) DEFAULT NULL,
  sbcess decimal(10,2) DEFAULT NULL,
  pdate timestamp DEFAULT NULL,
  pstatus int DEFAULT 0,
  pamount decimal(10,2) DEFAULT NULL,
  kkcess decimal(10,2) DEFAULT NULL,
  paymode varchar(100) DEFAULT NULL,
  deemedappvdate timestamp DEFAULT NULL,
  pst_code char(3) DEFAULT NULL,
  gst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  cgst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  sgst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  igst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  gst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  cgst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  sgst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  igst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  gstin varchar(15) DEFAULT NULL,
  gst_disburse_status boolean NOT NULL DEFAULT false,
  STCode char(3) DEFAULT NULL,
  paid_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  taxpayertype boolean NOT NULL DEFAULT false,
  gst_disbursedate timestamp DEFAULT NULL,
  special_month varchar(250) DEFAULT NULL,
  cgsttds_amount decimal(13,2) DEFAULT NULL,
  sgsttds_amount decimal(13,2) DEFAULT NULL,
  anp_invoiceno varchar(50) DEFAULT NULL,
  createdate timestamp DEFAULT CURRENT_TIMESTAMP,
  updatedate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  CONSTRAINT pk_cor_fin_agpinvoicing PRIMARY KEY (id)
);
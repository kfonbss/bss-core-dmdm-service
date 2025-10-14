DROP TABLE IF EXISTS cor_otc_invoicing CASCADE;

CREATE TABLE cor_otc_invoicing (
  otc_invoicing_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  subgroup SMALLINT DEFAULT NULL,
  pgroupid INTEGER DEFAULT NULL,
  total_locations INTEGER DEFAULT NULL,
  invoicemonth VARCHAR(20) DEFAULT NULL,
  invoicedate DATE DEFAULT NULL,
  status INTEGER DEFAULT NULL,
  state VARCHAR(50) DEFAULT NULL,
  remarks VARCHAR(100) DEFAULT NULL,
  partnerid BIGINT DEFAULT NULL,
  designation VARCHAR(50) DEFAULT NULL,
  verifiedby VARCHAR(50) DEFAULT NULL,
  approvedate TIMESTAMP DEFAULT NULL,
  invoiceno VARCHAR(50) DEFAULT NULL,
  nettotal DECIMAL(10,2) DEFAULT NULL,
  STtotal DECIMAL(10,2) DEFAULT NULL,
  GrossTotal DECIMAL(10,2) DEFAULT NULL,
  dot DECIMAL(10,2) DEFAULT NULL,
  agrtotal DECIMAL(10,2) DEFAULT NULL,
  ibnpshare DECIMAL(10,2) DEFAULT NULL,
  anpshare DECIMAL(10,2) DEFAULT NULL,
  netshare DECIMAL(10,2) DEFAULT NULL,
  STpartner DECIMAL(10,2) DEFAULT NULL,
  GrossShare DECIMAL(10,2) DEFAULT NULL,
  TDSpartner DECIMAL(10,2) DEFAULT NULL,
  NetPayable DECIMAL(10,2) DEFAULT NULL,
  STno VARCHAR(100) DEFAULT NULL,
  Pan VARCHAR(20) DEFAULT NULL,
  requestdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  cnpshare DECIMAL(10,2) DEFAULT NULL,
  agnpshare DECIMAL(10,2) DEFAULT NULL,
  mktshare DECIMAL(10,2) DEFAULT NULL,
  prsshare DECIMAL(10,2) DEFAULT NULL,
  mspshare DECIMAL(10,2) DEFAULT NULL,
  workorderid VARCHAR(45) DEFAULT NULL,
  locid INTEGER DEFAULT NULL,
  mdisbid INTEGER DEFAULT NULL,
  otc DECIMAL(10,2) DEFAULT NULL,
  lcototal DECIMAL(10,2) DEFAULT NULL,
  sbcess DECIMAL(10,2) DEFAULT NULL,
  loc_code VARCHAR(30) DEFAULT NULL,
  pstatus INTEGER DEFAULT 0,
  pdate TIMESTAMP DEFAULT NULL,
  pamount DECIMAL(10,2) DEFAULT NULL,
  kkcess DECIMAL(10,2) DEFAULT NULL,
  subscriberid BIGINT DEFAULT NULL,
  paymode VARCHAR(50) DEFAULT NULL,
  gst_rate DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  cgst_rate DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  sgst_rate DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  igst_rate DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  gst_amount DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  cgst_amount DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  sgst_amount DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  igst_amount DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  gstin VARCHAR(15) DEFAULT NULL,
  gst_disburse_status SMALLINT NOT NULL DEFAULT 0,
  STCode CHAR(3) DEFAULT NULL,
  paid_amount DECIMAL(13,2) NOT NULL DEFAULT 0.00,
  pst_code CHAR(3) DEFAULT NULL,
  taxpayertype SMALLINT DEFAULT NULL,
  gst_disbursedate TIMESTAMP DEFAULT NULL,
  cgsttds_amount DECIMAL(13,2) DEFAULT NULL,
  sgsttds_amount DECIMAL(13,2) DEFAULT NULL,
  response VARCHAR(256) DEFAULT NULL,
  responsedate TIMESTAMP DEFAULT NULL,
  anp_invoiceno VARCHAR(50) DEFAULT NULL,
  createdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active SMALLINT DEFAULT 1
);

COMMENT ON COLUMN cor_otc_invoicing.otc_invoicing_id IS 'Unique identifier for OTC invoicing records';
COMMENT ON COLUMN cor_otc_invoicing.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS cor_otc_partnertransfer CASCADE;

CREATE TABLE cor_otc_partnertransfer (
  otc_partnertransfer_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  partnerid BIGINT DEFAULT NULL,
  invoiceid VARCHAR(128) DEFAULT NULL,
  transferedon TIMESTAMP DEFAULT NULL,
  transferedby VARCHAR(100) DEFAULT NULL,
  remarks VARCHAR(100) DEFAULT NULL,
  amount DECIMAL(10,2) DEFAULT NULL
);

COMMENT ON COLUMN cor_otc_partnertransfer.otc_partnertransfer_id IS 'Unique identifier for OTC partner transfer records';


DROP TABLE IF EXISTS cor_package CASCADE;

CREATE TABLE cor_package (
  package_uuid UUID PRIMARY KEY NOT NULL,
  packageid SERIAL,
  packagename VARCHAR(45) NOT NULL,
  renewperiod INTEGER NOT NULL,
  subscriberprofileid INTEGER NOT NULL,
  portspeedid INTEGER NOT NULL,
  serviceid INTEGER NOT NULL,
  billingtypeid INTEGER NOT NULL,
  onetimecharge DECIMAL(10,2) DEFAULT 0.00,
  discount DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  renewalfee DECIMAL(10,2) DEFAULT 0,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  renewaltaxtypeid INTEGER DEFAULT 1,
  trailpackage INTEGER DEFAULT 0,
  active INTEGER NOT NULL DEFAULT 0,
  enddate TIMESTAMP DEFAULT NULL,
  bandid INTEGER DEFAULT NULL,
  maxvolume DECIMAL(10,2) DEFAULT NULL,
  fallbackspeed VARCHAR(10) DEFAULT NULL,
  description VARCHAR(256) DEFAULT NULL,
  speed BIGINT DEFAULT NULL,
  m_profile VARCHAR(45) DEFAULT NULL,
  j_profile VARCHAR(45) DEFAULT NULL,
  po_no VARCHAR(25) DEFAULT NULL,
  category VARCHAR(45) DEFAULT 'REGULAR',
  plan_type VARCHAR(45) DEFAULT 'ALL'
);

COMMENT ON COLUMN cor_package.package_uuid IS 'Unique identifier for package records';
COMMENT ON COLUMN cor_package.active IS '0=Inactive,1=Active';
COMMENT ON COLUMN cor_package.trailpackage IS '0=Regular Package,1=Trial Package';


DROP TABLE IF EXISTS cor_partneraccount CASCADE;

CREATE TABLE cor_partneraccount (
  partneraccount_uuid UUID PRIMARY KEY NOT NULL,
  partneraccountid SERIAL,
  partnerid BIGINT DEFAULT NULL,
  balance DECIMAL(10,2) DEFAULT NULL,
  lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  remarks VARCHAR(200) DEFAULT NULL
);

COMMENT ON COLUMN cor_partneraccount.partneraccount_uuid IS 'Unique identifier for partner account records';
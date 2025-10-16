-- Table: partnerfinance2
DROP TABLE IF EXISTS partnerfinance2;

CREATE TABLE partnerfinance2 (
  id UUID NOT NULL PRIMARY KEY,
  partnerfinanceid SERIAL ,
  partnerid bigint NOT NULL,
  cause varchar(128) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  amount float(10) NOT NULL
);

CREATE INDEX index_finance_group ON partnerfinance2(partnerid, cause, lastupdate);


-- Table: partnergroup
DROP TABLE IF EXISTS partnergroup;

CREATE TABLE partnergroup (
  id UUID NOT NULL PRIMARY KEY,
  partnergroupid SERIAL ,
  ibnp bigint DEFAULT NULL,
  ibwp bigint DEFAULT NULL,
  anp bigint DEFAULT NULL,
  agp bigint DEFAULT NULL,
  cnp bigint DEFAULT NULL,
  msp bigint DEFAULT NULL,
  mkt bigint DEFAULT NULL,
  isp bigint DEFAULT NULL,
  lastupdate timestamp DEFAULT NULL,
  perm bigint DEFAULT NULL,
  revenueshareid int DEFAULT NULL,
  isactive INT NOT NULL DEFAULT 1
);

CREATE INDEX index_group ON partnergroup(ibnp);


-- Table: partnergstdetail
DROP TABLE IF EXISTS partnergstdetail;

CREATE TABLE partnergstdetail (
  id UUID NOT NULL PRIMARY KEY,
  partnerid bigint ,
  gstin varchar(20) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_verfied INT DEFAULT 0,
  created_date timestamp DEFAULT NULL,
  createdby bigint DEFAULT NULL,
  verified_date timestamp DEFAULT NULL,
  verfied_by varchar(50) DEFAULT NULL,
  taxpayertype INT DEFAULT NULL,
  gst_status INT DEFAULT 0,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  pan varchar(10) DEFAULT NULL,
  pan_copy varchar(200) DEFAULT NULL
);


-- Table: partnergstinvoice
DROP TABLE IF EXISTS partnergstinvoice;

CREATE TABLE partnergstinvoice (
  id UUID NOT NULL PRIMARY KEY,
  slno SERIAL ,
  state varchar(20) DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  ptype varchar(10) DEFAULT NULL,
  pst_code char(3) DEFAULT NULL,
  billtype int DEFAULT NULL,
  invoiceno varchar(50) DEFAULT NULL,
  invoicemonth varchar(20) DEFAULT NULL,
  taxable_value decimal(10,2) DEFAULT NULL,
  bss_gstin varchar(20) DEFAULT NULL,
  taxpayertype INT DEFAULT NULL,
  cgst_value decimal(10,2) DEFAULT NULL,
  sgst_value decimal(10,2) DEFAULT NULL,
  gst_value decimal(10,2) DEFAULT NULL,
  invoice_value decimal(10,2) DEFAULT NULL,
  anp_invoiceno varchar(150) DEFAULT NULL,
  gst_invoiceno varchar(150) DEFAULT NULL,
  invoicedate date DEFAULT NULL,
  central_tax float(10) DEFAULT NULL,
  state_tax float(10) DEFAULT NULL,
  created_by varchar(100) DEFAULT NULL,
  created_on timestamp DEFAULT NULL,
  updated_on timestamp DEFAULT NULL
);

CREATE INDEX id_partnerid ON partnergstinvoice(partnerid);
CREATE INDEX id_invoicemonth ON partnergstinvoice(invoicemonth);


-- Table: partneronlinerecharge
DROP TABLE IF EXISTS partneronlinerecharge;

CREATE TABLE partneronlinerecharge (
  recharge_id UUID NOT NULL PRIMARY KEY,
  id BIGSERIAL ,
  ordernumber varchar(64) DEFAULT NULL,
  status char(18) DEFAULT NULL,
  amount float(13) DEFAULT NULL,
  partnerid varchar(45) DEFAULT NULL,
  order_time timestamp DEFAULT NULL,
  txnid varchar(64) DEFAULT NULL,
  banktxnid varchar(64) DEFAULT NULL,
  txnamout float(13) DEFAULT NULL,
  txndate timestamp DEFAULT NULL,
  currency varchar(5) DEFAULT NULL,
  respcode varchar(45) DEFAULT NULL,
  respmsg varchar(256) DEFAULT NULL,
  gatewayname varchar(45) DEFAULT NULL,
  bankname varchar(256) DEFAULT NULL,
  paymentmode INT DEFAULT 0,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  rechargesite INT DEFAULT 1
);

CREATE INDEX p_idx ON partneronlinerecharge(partnerid);


-- Table: partnerreciept
DROP TABLE IF EXISTS partnerreciept;

CREATE TABLE partnerreciept (
  id UUID NOT NULL PRIMARY KEY,
  recieptid SERIAL ,
  partnerid bigint NOT NULL,
  amount float(10) NOT NULL,
  reciepttypeid int NOT NULL,
  recieptstatusid int NOT NULL,
  recieptdate timestamp NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  reference varchar(64) NOT NULL,
  Amtreceived float DEFAULT NULL,
  status varchar(25) DEFAULT NULL,
  receiveddate date DEFAULT NULL,
  chqno varchar(25) DEFAULT NULL,
  pchqno varchar(45) DEFAULT NULL,
  pchqdate date DEFAULT NULL,
  pchqbank varchar(100) DEFAULT NULL,
  attachment varchar(120) DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL
);

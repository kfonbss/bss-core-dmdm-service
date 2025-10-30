-- Table: partnerfinance2
DROP TABLE IF EXISTS partnerfinance2;

CREATE TABLE partnerfinance2 (
  id UUID DEFAULT gen_random_uuid(),
  partnerfinanceid SERIAL ,
  partnerid bigint NOT NULL,
  cause varchar(128) NOT NULL,
  amount float(10) NOT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX index_finance_group ON partnerfinance2(partnerid, cause, modified_date);

INSERT INTO partnerfinance2 (
    id, partnerfinanceid, partnerid, cause, amount, code, name, name_in_local,
    is_active, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), DEFAULT, 10001, 'Security Deposit', 25000.00, 'PF001',
    'Security Deposit Entry', 'സെക്യൂരിറ്റി ഡെപ്പോസിറ്റ് എൻട്രി',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

-- Table: partnergroup
DROP TABLE IF EXISTS partnergroup;

CREATE TABLE partnergroup (
  id UUID DEFAULT gen_random_uuid(),
  partnergroupid SERIAL ,
  ibnp bigint DEFAULT NULL,
  ibwp bigint DEFAULT NULL,
  anp bigint DEFAULT NULL,
  agp bigint DEFAULT NULL,
  cnp bigint DEFAULT NULL,
  msp bigint DEFAULT NULL,
  mkt bigint DEFAULT NULL,
  isp bigint DEFAULT NULL,
  perm bigint DEFAULT NULL,
  revenueshareid int DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX index_group ON partnergroup(ibnp);

INSERT INTO partnergroup (
    id, partnergroupid, ibnp, ibwp, anp, agp, cnp, msp, mkt, isp, perm, revenueshareid,
    code, name, name_in_local, is_active,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), DEFAULT, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 5001, 2001,
    'PG001', 'Partner Group Alpha', 'പാർട്ണർ ഗ്രൂപ്പ് ആൽഫ',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table: partnergstdetail
DROP TABLE IF EXISTS partnergstdetail;

CREATE TABLE partnergstdetail (
  id UUID DEFAULT gen_random_uuid(),
  partnerid bigint ,
  gstin varchar(20) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_verfied INT DEFAULT 0,
  verified_date timestamp DEFAULT NULL,
  verfied_by varchar(50) DEFAULT NULL,
  taxpayertype INT DEFAULT NULL,
  gst_status INT DEFAULT 0,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  pan varchar(10) DEFAULT NULL,
  pan_copy varchar(200) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO partnergstdetail (
    id, partnerid, gstin, sac, gstindoc, service_description,
    gst_verfied, verified_date, verfied_by, taxpayertype, gst_status,
    legalname, tradename, pan, pan_copy,
    code, name, name_in_local, is_active,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 20001, '32ABCDE1234F1Z5', '9984', 'gst_doc_20001.pdf',
    'Internet and Broadband Service', 1, NOW(), 'VerifierUser', 2, 1,
    'ABC Communications Pvt Ltd', 'ABC FiberNet', 'ABCDE1234F', 'pan_copy_abc.pdf',
    'GST001', 'GST Detail Alpha', 'ജി.എസ്.ടി. ഡീറ്റെയിൽ ആൽഫ',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table: partnergstinvoice
DROP TABLE IF EXISTS partnergstinvoice;

CREATE TABLE partnergstinvoice (
  id UUID DEFAULT gen_random_uuid(),
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
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX id_partnerid ON partnergstinvoice(partnerid);
CREATE INDEX id_invoicemonth ON partnergstinvoice(invoicemonth);

INSERT INTO partnergstinvoice (
    id, slno, state, partnerid, ptype, pst_code, billtype, invoiceno, invoicemonth,
    taxable_value, bss_gstin, taxpayertype, cgst_value, sgst_value, gst_value,
    invoice_value, anp_invoiceno, gst_invoiceno, invoicedate, central_tax, state_tax,
    code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), DEFAULT, 'Kerala', 10001, 'TypeA', 'KL', 1, 'INV-001', '2025-10',
    5000.00, '29ABCDE1234F1Z5', 1, 450.00, 450.00, 900.00,
    5900.00, 'ANP-001', 'GST-001', '2025-10-30', 450.00, 450.00,
    'PG001', 'GST Invoice Sample', 'ജിഎസ്‌ടി ഇൻവോയ്സ് സാമ്പിൾ',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table: partneronlinerecharge
DROP TABLE IF EXISTS partneronlinerecharge;

CREATE TABLE partneronlinerecharge (
  recharge_id UUID DEFAULT gen_random_uuid(),
  id UUID ,
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
  rechargesite INT DEFAULT 1,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX p_idx ON partneronlinerecharge(partnerid);

INSERT INTO partneronlinerecharge (
    recharge_id, id, ordernumber, status, amount, partnerid, order_time, txnid, banktxnid,
    txnamout, txndate, currency, respcode, respmsg, gatewayname, bankname, paymentmode,
    rechargesite, code, name, name_in_local, is_active, created_date, modified_date,
    created_by, modified_by
) VALUES (
    gen_random_uuid(), gen_random_uuid(), 'ORD-1001', 'SUCCESS', 250.00, 'P10001', NOW(), 'TXN12345', 'BANKTXN12345',
    250.00, NOW(), 'INR', '00', 'Transaction Successful', 'GatewayA', 'BankA', 1,
    1, 'POR001', 'Online Recharge Sample', 'ഓൺലൈൻ റീചാർജ് സാമ്പിൾ',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

-- Table: partnerreciept
DROP TABLE IF EXISTS partnerreciept;

CREATE TABLE partnerreciept (
  id UUID DEFAULT gen_random_uuid(),
  recieptid SERIAL ,
  partnerid bigint NOT NULL,
  amount float(10) NOT NULL,
  reciepttypeid int NOT NULL,
  recieptstatusid int NOT NULL,
  recieptdate timestamp NOT NULL,
  reference varchar(64) NOT NULL,
  Amtreceived float DEFAULT NULL,
  status varchar(25) DEFAULT NULL,
  receiveddate date DEFAULT NULL,
  chqno varchar(25) DEFAULT NULL,
  pchqno varchar(45) DEFAULT NULL,
  pchqdate date DEFAULT NULL,
  pchqbank varchar(100) DEFAULT NULL,
  attachment varchar(120) DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  code VARCHAR(50),
  name VARCHAR(100),
  name_in_local VARCHAR(100),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO partnerreciept (
    id, recieptid, partnerid, amount, reciepttypeid, recieptstatusid,
    recieptdate, reference, amtreceived, status, receiveddate,
    chqno, pchqno, pchqdate, pchqbank, attachment, remarks,
    code, name, name_in_local, is_active, created_date, modified_date,
    created_by, modified_by
) VALUES
(
    gen_random_uuid(), DEFAULT, 1001, 5000.00, 1, 1,
    NOW(), 'REF12345', 5000.00, 'Received', CURRENT_DATE,
    'CHQ001', 'PCHQ001', CURRENT_DATE, 'SBI Bank', 'receipt_doc.pdf', 'Initial payment received',
    'RCPT01', 'Partner Receipt', 'പാർട്നർ റസീറ്റ്', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

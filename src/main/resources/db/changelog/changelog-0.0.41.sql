DROP TABLE IF EXISTS ce_package CASCADE;

CREATE TABLE ce_package (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  packageid SERIAL,
  packagename varchar(45) NOT NULL,
  renewperiod int NOT NULL,
  serviceid int NOT NULL,
  sub_serviceid int DEFAULT NULL,
  renewalfee double precision DEFAULT 0,
  service_type int DEFAULT 0,
  --'1=Lease Line,2=L2-VPN,3=L3-VPN'
  speed_inmbps int DEFAULT NULL,
  m_profile varchar(45) DEFAULT NULL,
  plan_type int DEFAULT 1,
  --'1=Unlimited, 2=FUP'
  maxvolume double precision DEFAULT NULL,
  fallbackspeed varchar(30) DEFAULT NULL,
  otcfee double precision DEFAULT NULL,
  fbspeedinkbps bigint DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_package PRIMARY KEY (id)
);

INSERT INTO ce_package (
    id, code, name, name_in_local, is_active, packageid, packagename, renewperiod, serviceid, sub_serviceid, renewalfee, service_type, speed_inmbps, m_profile, plan_type, maxvolume, fallbackspeed, otcfee, fbspeedinkbps, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'PKG001', 'Premium Broadband Plan', 'പ്രീമിയം ബ്രോഡ്ബാൻഡ് പ്ലാൻ', true, 1, 'KFON Premium', 12, 101, 201, 999.99, 1, 100, 'MPROFILE001', 1, 500.00, '10Mbps', 250.00, 10240, gen_random_uuid(), gen_random_uuid()
);

DROP TABLE IF EXISTS ce_parent_customers CASCADE;

CREATE TABLE ce_parent_customers (
  customer_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  id SERIAL,
  department_name varchar(250) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_parent_customers PRIMARY KEY (customer_id)
);
INSERT INTO ce_parent_customers (
    customer_id, code, name, name_in_local, department_name, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'CUST001', 'Kerala Education Department', 'കേരള വിദ്യാഭ്യാസ വകുപ്പ്', 'Education Department', gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_payment_history CASCADE;

CREATE TABLE ce_payment_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  id SERIAL,
  invoiceid varchar(15) DEFAULT NULL,
  utr_number varchar(25) DEFAULT NULL,
  amount varchar(10) DEFAULT NULL,
  it_tdsamount decimal(10,2) DEFAULT 0.00,
  gst_tdsamount decimal(10,2) DEFAULT 0.00,
  payment_recipt varchar(150) DEFAULT NULL,
  created_by_platform varchar(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_payment_history PRIMARY KEY (history_id)
);

INSERT INTO ce_payment_history (
    history_id, code, name, name_in_local, invoiceid, utr_number, amount, it_tdsamount, gst_tdsamount, payment_recipt, created_by_platform, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'PAY001', 'First Payment - Renewal', 'ആദ്യ പേയ്മെന്റ് - പുതുക്കൽ', 'INV2025-001', 'UTR9876543210', '1500', 50.00, 25.00, 'receipt_2025.pdf', 'WebPortal', gen_random_uuid(), gen_random_uuid()
);

DROP TABLE IF EXISTS ce_payment_kyc_details CASCADE;

CREATE TABLE ce_payment_kyc_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  id SERIAL,
  subid int DEFAULT NULL,
  locid int DEFAULT NULL,
  cheque_doc varchar(50) DEFAULT NULL,
  cheque_date timestamp DEFAULT NULL,
  paymentreciept_doc varchar(50) DEFAULT NULL,
  paymentreciept_date timestamp DEFAULT NULL,
  wo_doc varchar(50) DEFAULT NULL,
  wo_date timestamp DEFAULT NULL,
  kyc_doc varchar(50) DEFAULT NULL,
  kyc_date timestamp DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_payment_kyc_details PRIMARY KEY (details_id)
);
INSERT INTO ce_payment_kyc_details (
    details_id, code, name, name_in_local, subid, locid, cheque_doc, cheque_date, paymentreciept_doc, paymentreciept_date, wo_doc, wo_date, kyc_doc, kyc_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'KYC001', 'KYC Payment Verification', 'കെവൈസി പേയ്‌മെന്റ് സ്ഥിരീകരണം', 2001, 3001, 'cheque_2001.pdf', CURRENT_TIMESTAMP, 'receipt_2001.pdf', CURRENT_TIMESTAMP, 'wo_2001.pdf', CURRENT_TIMESTAMP, 'kyc_2001.pdf', CURRENT_TIMESTAMP, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_po_movement CASCADE;

CREATE TABLE ce_po_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  id SERIAL,
  poid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  created_by_platform varchar(128) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_po_movement PRIMARY KEY (movement_id)
);
INSERT INTO ce_po_movement (
    movement_id, code, name, name_in_local, poid, approve_status, remarks, created_by_platform, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'PO001', 'Purchase Order Movement', 'വാങ്ങൽ ഓർഡർ നീക്കം', 1001, 1, 'PO approved successfully', 'system_admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, gen_random_uuid(), gen_random_uuid()
);





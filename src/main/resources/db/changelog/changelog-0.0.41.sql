DROP TABLE IF EXISTS ce_package CASCADE;

CREATE TABLE ce_package (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  packageid SERIAL,
  packagename varchar(45) NOT NULL,
  renewperiod int NOT NULL,
  serviceid int NOT NULL,
  sub_serviceid int DEFAULT NULL,
  renewalfee double precision DEFAULT 0,
  service_type int DEFAULT 0,
  speed_inmbps int DEFAULT NULL,
  m_profile varchar(45) DEFAULT NULL,
  plan_type int DEFAULT 1,
  maxvolume double precision DEFAULT NULL,
  fallbackspeed varchar(30) DEFAULT NULL,
  otcfee double precision DEFAULT NULL,
  fbspeedinkbps bigint DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_package PRIMARY KEY (id)
);

COMMENT ON COLUMN ce_package.service_type IS '1=Lease Line,2=L2-VPN,3=L3-VPN';
COMMENT ON COLUMN ce_package.plan_type IS '1=Unlimited, 2=FUP';
COMMENT ON COLUMN ce_package.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_parent_customers CASCADE;

CREATE TABLE ce_parent_customers (
  customers_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  department_name varchar(250) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_parent_customers PRIMARY KEY (customers_id)
);

COMMENT ON COLUMN ce_parent_customers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_payment_history CASCADE;

CREATE TABLE ce_payment_history (
  history_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  invoiceid varchar(15) DEFAULT NULL,
  utr_number varchar(25) DEFAULT NULL,
  amount varchar(10) DEFAULT NULL,
  it_tdsamount decimal(10,2) DEFAULT 0.00,
  gst_tdsamount decimal(10,2) DEFAULT 0.00,
  payment_recipt varchar(150) DEFAULT NULL,
  created_by varchar(150) DEFAULT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp DEFAULT CURRENT_TIMESTAMP,
  is_active  int DEFAULT 1,
  CONSTRAINT pk_ce_payment_history PRIMARY KEY (history_id)
);


DROP TABLE IF EXISTS ce_payment_kyc_details CASCADE;

CREATE TABLE ce_payment_kyc_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_ce_payment_kyc_details PRIMARY KEY (details_id)
);


DROP TABLE IF EXISTS ce_po_movement CASCADE;

CREATE TABLE ce_po_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  poid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_po_movement PRIMARY KEY (movement_id)
);

COMMENT ON COLUMN ce_po_movement.is_active IS '0=In Active,1=Active';



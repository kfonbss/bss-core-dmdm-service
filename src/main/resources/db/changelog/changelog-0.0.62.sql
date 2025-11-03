-- Table : df_pop_list
DROP TABLE IF EXISTS df_pop_list CASCADE;

CREATE TABLE df_pop_list (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  df_pop_list_id SERIAL,
  pop_name VARCHAR(255),
  name VARCHAR(256),
  name_in_local VARCHAR(256),
  is_active BOOLEAN DEFAULT TRUE,
  code VARCHAR(50),
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  --'0=In Active,1=Active',
    -- Primary key constraint
  CONSTRAINT pk_df_pop_list PRIMARY KEY (id)
);


INSERT INTO df_pop_list (
    id, pop_name, name, name_in_local, is_active, code,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'Thiruvananthapuram POP', 'TVM POP', 'തിരുവനന്തപുരം POP', TRUE, 'POP01',
    NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table : df_power_rating
DROP TABLE IF EXISTS df_power_rating CASCADE;

CREATE TABLE df_power_rating (
  df_power_rating_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  amount int NOT NULL,
  power_rating varchar(255) DEFAULT NULL,
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
CONSTRAINT pk_df_power_rating PRIMARY KEY (df_power_rating_id)
);

INSERT INTO df_power_rating (amount, power_rating, code, name, name_in_local, created_by, modified_by)
VALUES
(5000, '10 kW', 'PR001', 'Low Voltage Supply', 'താഴ്ന്ന വോൾട്ടേജ് വിതരണo', gen_random_uuid(), gen_random_uuid());


-- Table : df_purchase_order
DROP TABLE IF EXISTS df_purchase_order CASCADE;

CREATE TABLE df_purchase_order (
  df_purchase_order_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  po_no varchar(30) DEFAULT NULL,
  po_no_cus varchar(30) DEFAULT NULL,
  po_doc varchar(100) DEFAULT NULL,
  tfd_ref_num varchar(100) DEFAULT NULL,
  tfd_ref_doc varchar(100) DEFAULT NULL,
  enq_ref int DEFAULT NULL,
  customerid int DEFAULT NULL,
  approve_status int DEFAULT 0,
  remarks varchar(255) DEFAULT NULL,
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
CONSTRAINT pk_df_purchase_order PRIMARY KEY (df_purchase_order_id)
);

INSERT INTO df_purchase_order (
  po_no, po_no_cus, po_doc, tfd_ref_num, tfd_ref_doc,
  enq_ref, customerid, approve_status, remarks,
  code, name, name_in_local, created_by, modified_by
)
VALUES
('PO-001', 'CUS-PO-001', 'po_doc_001.pdf', 'TFD-REF-001', 'tfd_doc_001.pdf',
 101, 1001, 1, 'Approved and verified',
 'POC001', 'First Purchase Order', 'ആദ്യ പർച്ചേസ് ഓർഡർ', gen_random_uuid(), gen_random_uuid());


-- Table : df_renewal_details
DROP TABLE IF EXISTS df_renewal_details CASCADE;

CREATE TABLE df_renewal_details (
  df_renewal_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  groupid int DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  woid int NOT NULL,
  cause varchar(100) DEFAULT NULL,
  service_sdate date DEFAULT NULL,
  service_edate date DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  total_sdays int DEFAULT 0,
  amount decimal(26,10) DEFAULT NULL,
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
CONSTRAINT pk_df_renewal_details PRIMARY KEY (df_renewal_details_id)
);

INSERT INTO df_renewal_details (
  df_renewal_details_id, groupid, subscriberid, woid, cause,
  service_sdate, service_edate, subfinanceid, total_sdays, amount,
  code, name, name_in_local, is_active, created_by, modified_by
)
VALUES
  (gen_random_uuid(), 101, 5001, 10001, 'Service Renewal - Routine Maintenance',
   '2025-01-01', '2025-12-31', 301, 365, 12500.5000000000,
   'REN001', 'Fiber Renewal 2025', 'ഫൈബർ പുതുക്കൽ 2025', TRUE, gen_random_uuid(), gen_random_uuid());


-- Table : df_subfinance
DROP TABLE IF EXISTS df_subfinance CASCADE;

CREATE TABLE df_subfinance (
  df_subfinance_id UUID DEFAULT gen_random_uuid() NOT NULL,
  subfinanceid SERIAL,
  subscriberid int NOT NULL,
  amount decimal(10,2) NOT NULL,
  cause varchar(45) NOT NULL,
  woid int DEFAULT NULL,
  groupid int DEFAULT NULL,
  finrefid int DEFAULT NULL,
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
CONSTRAINT pk_df_subfinance PRIMARY KEY (df_subfinance_id)
);

INSERT INTO df_subfinance (
  df_subfinance_id, subscriberid, amount, cause, woid, groupid, finrefid,
  code, name, name_in_local, is_active, created_by, modified_by
)
VALUES
  (gen_random_uuid(), 5001, 12500.50, 'Renewal Payment', 10001, 101, 9001,
   'SUBFIN001', 'Renewal Finance - Group 101', 'ഫിനാൻസ് - ഗ്രൂപ്പ് 101', TRUE, gen_random_uuid(), gen_random_uuid());


-- Table : df_subscribers
DROP TABLE IF EXISTS df_subscribers CASCADE;

CREATE TABLE df_subscribers (
  df_subscribers_id UUID DEFAULT gen_random_uuid() NOT NULL,
  subscriberid SERIAL,
  username varchar(64) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  balance decimal(10,2) NOT NULL DEFAULT 0.00,
  woid int DEFAULT NULL,
  enq_ref int DEFAULT NULL,
  expirydate date DEFAULT NULL,
  comm_date date DEFAULT NULL,
  activation_date timestamp DEFAULT NULL,
  d_status int DEFAULT 0,
  d_status_date date DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_df_subscribers PRIMARY KEY (df_subscribers_id)
);


-- Table : df_trans_renewal_details
DROP TABLE IF EXISTS df_trans_renewal_details CASCADE;

CREATE TABLE df_trans_renewal_details (
  df_trans_renewal_details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  mg_invoiceid int DEFAULT NULL,
  lrhid int DEFAULT NULL,
  transmv_id int DEFAULT NULL,
  groupid int DEFAULT NULL,
  grouplinkid int DEFAULT NULL,
  linkid int DEFAULT NULL,
  cost_per_trand decimal(25,10) NOT NULL DEFAULT 0.0000000000,
  gst_cost_per_trand decimal(25,10) NOT NULL DEFAULT 0.0000000000,
  trand_service_days int DEFAULT 0,
  trands_send_date date DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_df_trans_renewal_details PRIMARY KEY (df_trans_renewal_details_id)
);


-- Table : df_transdetails
DROP TABLE IF EXISTS df_transdetails CASCADE;

CREATE TABLE df_transdetails (
  df_transdetails_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  groupid int DEFAULT NULL,
  grouplinkid int DEFAULT NULL,
  linkid int DEFAULT NULL,
  feeder_id int DEFAULT NULL,
  trandsid int DEFAULT NULL,
  trands_status int DEFAULT 0,
  -- '0=Transavailable,1=Transaallocated',
  strand_type INT DEFAULT 1,
  -- '1=Intecrcity,2=intracity',
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_df_transdetails PRIMARY KEY (df_transdetails_id)
);


-- Table : df_transdetails_movement
DROP TABLE IF EXISTS df_transdetails_movement CASCADE;

CREATE TABLE df_transdetails_movement (
  df_transdetails_movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  trandsid int DEFAULT NULL,
  trands_status int DEFAULT NULL,
  groupid int DEFAULT NULL,
  grouplinkid int DEFAULT NULL,
  linkid int DEFAULT NULL,
  feeder_id int DEFAULT NULL,
  starnd_d_status INT DEFAULT 1,
  -- '1=Commissioned,2=DeCommissioned',
  starnd_d_status_date date DEFAULT NULL,
  back_date_invoice INT DEFAULT 0,
  bd_invoice_sdate date DEFAULT NULL,
  bd_invoice_edate date DEFAULT NULL,
  bd_unit_price decimal(13,2) DEFAULT 0.00,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_df_transdetails_movement PRIMARY KEY (df_transdetails_movement_id)
);


-- Table : df_workorder
DROP TABLE IF EXISTS df_workorder CASCADE;

CREATE TABLE df_workorder (
  df_workorder_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  po_id int DEFAULT NULL,
  wo_no varchar(25) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_df_workorder PRIMARY KEY (df_workorder_id)
);


-- Table : disbursement
DROP TABLE IF EXISTS disbursement CASCADE;

CREATE TABLE disbursement (
  disbursement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  partnerid bigint DEFAULT NULL,
  partnername varchar(150) DEFAULT NULL,
  disburse_revenue decimal(10,2) DEFAULT NULL,
  actual_revenue decimal(10,2) DEFAULT NULL,
  finance_amount decimal(10,2) DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  disbursement_date timestamp DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_disbursement PRIMARY KEY (disbursement_id)
);


-- Table : disbursestatus
DROP TABLE IF EXISTS disbursestatus CASCADE;

CREATE TABLE disbursestatus (
  disbursestatus_id UUID DEFAULT gen_random_uuid() NOT NULL,
  disbursestatusid SERIAL,
  taskstatus varchar(45) NOT NULL,
  taskowner varchar(45) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_disbursestatus_taskstatus UNIQUE (taskstatus),
  -- Primary key constraint
CONSTRAINT pk_disbursestatus PRIMARY KEY (disbursestatus_id)
);

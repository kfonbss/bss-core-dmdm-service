DROP TABLE IF EXISTS ce_purchase_order CASCADE;

CREATE TABLE ce_purchase_order (
  order_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  slno SERIAL,
  customerid int DEFAULT NULL,
  quotationid int DEFAULT NULL,
  po_no_cus varchar(100) DEFAULT NULL,
  po_doc varchar(100) DEFAULT NULL,
  po_no varchar(30) DEFAULT NULL,
  mou_number varchar(100) DEFAULT NULL,
  mou_doc varchar(100) DEFAULT NULL,
  approve_status int DEFAULT 0,
  remarks varchar(255) DEFAULT NULL,
  po_start_date date DEFAULT NULL,
  po_end_date date DEFAULT NULL,
  noof_months int DEFAULT NULL,
  annual_charges decimal(26,10) DEFAULT 0.0000000000,
  otc_charges decimal(26,10) DEFAULT 0.0000000000,
  total_amount decimal(26,10) DEFAULT 0.0000000000,
  billing_frequency varchar(50) DEFAULT NULL,
  is_eo_customer int DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_purchase_order PRIMARY KEY (order_id)
);

INSERT INTO ce_purchase_order (
    order_id, code, name, name_in_local, slno, customerid, quotationid, po_no_cus,
    po_doc, po_no, mou_number, mou_doc, approve_status, remarks, po_start_date,
    po_end_date, noof_months, annual_charges, otc_charges, total_amount,
    billing_frequency, is_eo_customer, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'PO001', 'Purchase Order - Corporate', 'വാങ്ങൽ ഓർഡർ - കോർപ്പറേറ്റ്', 1, 2001, 3001, 'CUS-PO-2025',
    'po_doc.pdf', 'PO-2025-001', 'MOU-2025-01', 'mou_doc.pdf', 1, 'Approved by finance team',
    '2025-01-01', '2026-01-01', 12, 120000.0000000000, 5000.0000000000, 125000.0000000000,
    'Monthly', 0, CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);

DROP TABLE IF EXISTS ce_quoations CASCADE;

CREATE TABLE ce_quoations (
  quoations_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  customerid int DEFAULT NULL,
  quotation_name varchar(100) DEFAULT NULL,
  remarks text DEFAULT NULL,
  discount_apply int DEFAULT 0,
  discount_percent int DEFAULT 0,
  proposal_doc varchar(100) DEFAULT NULL,
  terms_and_cond text DEFAULT NULL,
  b_frequency varchar(50) DEFAULT NULL,
  special_terms_cond text DEFAULT NULL,
  version int DEFAULT NULL,
  approve_status int DEFAULT 1,
  --=Quotation created,2=Discount Approved,3=Discount Rejected
  is_eo_proposal boolean DEFAULT NULL,
  migrated int DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_quoations PRIMARY KEY (quoations_id)
);
INSERT INTO ce_quoations (
    quoations_id, id, code, name, name_in_local, customerid, quotation_name, remarks,
    discount_apply, discount_percent, proposal_doc, terms_and_cond, b_frequency, special_terms_cond,
    version, approve_status, is_eo_proposal, migrated, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 1, 'QTN001', 'Corporate Quotation', 'കോർപ്പറേറ്റ് ക്വട്ടേഷൻ', 1001, 'Broadband Plan Proposal',
    'Quotation prepared for corporate broadband service', 1, 10, 'proposal_v1.pdf',
    'Standard terms and conditions apply', 'Monthly', 'Special discount applied as per approval',
    1, 2, true, 0, CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_quoations_movement CASCADE;

CREATE TABLE ce_quoations_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  id SERIAL,
  quoationid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  remarks text DEFAULT NULL,
  discount_percent int DEFAULT NULL,
  version int DEFAULT NULL,
  proposal_doc varchar(100) DEFAULT NULL,
  created_by_name varchar(128) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_quoations_movement PRIMARY KEY (movement_id)
);

INSERT INTO ce_quoations_movement (
    movement_id, code, name, name_in_local, id, quoationid, approve_status, remarks,
    discount_percent, version, proposal_doc, created_by_name, created_date, modified_date,
    created_by, modified_by
) VALUES (
    gen_random_uuid(), 'QM001', 'Quotation Movement - Initial Approval', 'ക്വട്ടേഷൻ മൂവ്‌മെന്റ് - പ്രാഥമിക അംഗീകാരം', 1, 501, 1,
    'Quotation reviewed and approved by management', 10, 1, 'proposal_v1.pdf', 'John Mathew',
    CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_quoations_revision CASCADE;

CREATE TABLE ce_quoations_revision (
  revision_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  id SERIAL,
  proposalid int DEFAULT NULL,
  remarks text DEFAULT NULL,
  discount_apply int DEFAULT 0,
  discount_percent int DEFAULT 0,
  proposal_doc varchar(100) DEFAULT NULL,
  version int DEFAULT NULL,
  approve_status int DEFAULT 1,
  --1=Quotation created,2=Discount Approved,3=Discount Rejected
  migrated int DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_quoations_revision PRIMARY KEY (revision_id)
);
INSERT INTO ce_quoations_revision (
    revision_id, code, name, name_in_local, id, proposalid, remarks, discount_apply,
    discount_percent, proposal_doc, version, approve_status, migrated,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'QR001', 'Quotation Revision - Discount Review', 'ക്വട്ടേഷൻ റിവിഷൻ - ഡിസ്‌കൗണ്ട് റിവ്യൂ',
    1, 301, 'Revision made to include 10% discount as per customer request.',
    1, 10, 'proposal_rev_v2.pdf', 2, 2, 0,
    CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_renewal_details CASCADE;

CREATE TABLE ce_renewal_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  cause varchar(100) DEFAULT NULL,
  service_sdate date DEFAULT NULL,
  service_edate date DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  total_sdays int DEFAULT 0,
  amount decimal(26,10) DEFAULT NULL,
  discount_percent int DEFAULT 0,
  original_renewalfee double precision DEFAULT 0,
  renewalfee_after_disount double precision DEFAULT 0,
  cost_per_day double precision DEFAULT 0,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_renewal_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN ce_renewal_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_revision_connection_breakup CASCADE;

CREATE TABLE ce_revision_connection_breakup (
  breakup_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  serviceid int DEFAULT NULL,
  revi_quoationid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  otc_cost decimal(10,2) DEFAULT 0.00,
  noof_connections int DEFAULT 0,
  discount int DEFAULT 0,
  description varchar(250) DEFAULT NULL,
  version int DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  migrated int DEFAULT NULL,
  CONSTRAINT pk_ce_revision_connection_breakup PRIMARY KEY (breakup_id)
);

COMMENT ON COLUMN ce_revision_connection_breakup.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_service_list CASCADE;

CREATE TABLE ce_service_list (
  list_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  serviceid int DEFAULT NULL,
  servicename varchar(50) DEFAULT NULL,
  sname_short varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_service_list PRIMARY KEY (list_id)
);

COMMENT ON COLUMN ce_service_list.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_sub_customers CASCADE;

CREATE TABLE ce_sub_customers (
  customers_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  customerid varchar(100) DEFAULT NULL,
  company_name varchar(200) DEFAULT NULL,
  department_name varchar(50) DEFAULT NULL,
  billing_category varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_sub_customers PRIMARY KEY (customers_id)
);

COMMENT ON COLUMN ce_sub_customers.is_active IS '0=In Active,1=Active';
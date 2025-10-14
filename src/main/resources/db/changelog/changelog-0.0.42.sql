DROP TABLE IF EXISTS ce_purchase_order CASCADE;

CREATE TABLE ce_purchase_order (
  ce_purchase_order_id UUID PRIMARY KEY NOT NULL,
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
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_purchase_order.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_purchase_order.ce_purchase_order_id IS 'Unique identifier for CE purchase order records';


DROP TABLE IF EXISTS ce_quoations CASCADE;

CREATE TABLE ce_quoations (
  ce_quoations_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
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
  is_eo_proposal boolean DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  migrated int DEFAULT NULL
);

COMMENT ON COLUMN ce_quoations.approve_status IS '1=Quotation created,2=Discount Approved,3=Discount Rejected';
COMMENT ON COLUMN ce_quoations.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_quoations.ce_quoations_id IS 'Unique identifier for CE quotations records';


DROP TABLE IF EXISTS ce_quoations_movement CASCADE;

CREATE TABLE ce_quoations_movement (
  ce_quoations_movement_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  quoationid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  remarks text DEFAULT NULL,
  discount_percent int DEFAULT NULL,
  version int DEFAULT NULL,
  proposal_doc varchar(100) DEFAULT NULL,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_quoations_movement.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_quoations_movement.ce_quoations_movement_id IS 'Unique identifier for CE quotations movement records';


DROP TABLE IF EXISTS ce_quoations_revision CASCADE;

CREATE TABLE ce_quoations_revision (
  ce_quoations_revision_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  proposalid int DEFAULT NULL,
  remarks text DEFAULT NULL,
  discount_apply int DEFAULT 0,
  discount_percent int DEFAULT 0,
  proposal_doc varchar(100) DEFAULT NULL,
  version int DEFAULT NULL,
  approve_status int DEFAULT 1,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  migrated int DEFAULT NULL
);

COMMENT ON COLUMN ce_quoations_revision.approve_status IS '1=Quotation created,2=Discount Approved,3=Discount Rejected';
COMMENT ON COLUMN ce_quoations_revision.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_quoations_revision.ce_quoations_revision_id IS 'Unique identifier for CE quotations revision records';


DROP TABLE IF EXISTS ce_renewal_details CASCADE;

CREATE TABLE ce_renewal_details (
  ce_renewal_details_id UUID PRIMARY KEY NOT NULL,
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
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_renewal_details.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_renewal_details.ce_renewal_details_id IS 'Unique identifier for CE renewal details records';


DROP TABLE IF EXISTS ce_revision_connection_breakup CASCADE;

CREATE TABLE ce_revision_connection_breakup (
  ce_revision_connection_breakup_id UUID PRIMARY KEY NOT NULL,
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
  migrated int DEFAULT NULL
);

COMMENT ON COLUMN ce_revision_connection_breakup.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_revision_connection_breakup.ce_revision_connection_breakup_id IS 'Unique identifier for CE revision connection breakup records';


DROP TABLE IF EXISTS ce_service_list CASCADE;

CREATE TABLE ce_service_list (
  ce_service_list_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  serviceid int DEFAULT NULL,
  servicename varchar(50) DEFAULT NULL,
  sname_short varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1
);

COMMENT ON COLUMN ce_service_list.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_service_list.ce_service_list_id IS 'Unique identifier for CE service list records';


DROP TABLE IF EXISTS ce_sub_customers CASCADE;

CREATE TABLE ce_sub_customers (
  ce_sub_customers_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  customerid varchar(100) DEFAULT NULL,
  company_name varchar(200) DEFAULT NULL,
  department_name varchar(50) DEFAULT NULL,
  billing_category varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true
);

COMMENT ON COLUMN ce_sub_customers.is_active IS '0=In Active,1=Active';
COMMENT ON COLUMN ce_sub_customers.ce_sub_customers_id IS 'Unique identifier for CE sub customers records';
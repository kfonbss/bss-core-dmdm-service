DROP TABLE IF EXISTS ce_disbursement_history CASCADE;

CREATE TABLE ce_disbursement_history (
  history_id UUID NOT NULL,
  id SERIAL,
  type boolean DEFAULT true,
  disbid int DEFAULT NULL,
  partnergroupid int DEFAULT NULL,
  subscriberid int NOT NULL,
  locid int NOT NULL,
  packageid int DEFAULT NULL,
  cause varchar(30) DEFAULT NULL,
  servicestartdate timestamp DEFAULT NULL,
  serviceenddate timestamp DEFAULT NULL,
  revenue decimal(26,10) DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  revenueshareid int DEFAULT NULL,
  disbursestatusid boolean DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_ce_disbursement_history PRIMARY KEY (history_id)
);


DROP TABLE IF EXISTS ce_dnote_master CASCADE;

CREATE TABLE ce_dnote_master (
  master_id UUID NOT NULL,
  slno BIGSERIAL,
  subscriberid bigint DEFAULT NULL,
  locid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  notenumber varchar(64) DEFAULT NULL,
  notemonth varchar(20) DEFAULT NULL,
  notedate date DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  locamount decimal(26,10) DEFAULT NULL,
  servicetax decimal(10,10) DEFAULT NULL,
  servicetaxrate decimal(10,2) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  quarter_start_date date DEFAULT NULL,
  quarter_end_date date DEFAULT NULL,
  gst_value decimal(26,10) DEFAULT NULL,
  cgst_value decimal(26,10) DEFAULT NULL,
  sgst_value decimal(26,10) DEFAULT NULL,
  igst_value decimal(26,10) DEFAULT NULL,
  cgst_rate decimal(26,10) DEFAULT NULL,
  sgst_rate decimal(26,10) DEFAULT NULL,
  igst_rate decimal(26,10) DEFAULT NULL,
  paid_amount decimal(26,10) DEFAULT 0.0000000000,
  gstin varchar(18) DEFAULT NULL,
  taxpayertype smallint DEFAULT NULL,
  particulars varchar(180) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  CONSTRAINT pk_ce_dnote_master PRIMARY KEY (master_id)
);

COMMENT ON COLUMN ce_dnote_master.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_dnote_renewal_history CASCADE;

CREATE TABLE ce_dnote_renewal_history (
  history_id UUID NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  breakupid int DEFAULT NULL,
  serviceid int DEFAULT NULL,
  packageid int DEFAULT NULL,
  mg_invoiceid int DEFAULT NULL,
  service_sdate date DEFAULT NULL,
  service_edate date DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  total_sdays int DEFAULT 0,
  discount_percent int DEFAULT 0,
  disount_amount decimal(26,10) DEFAULT NULL,
  original_renewalfee decimal(26,10) DEFAULT NULL,
  renewalfee_after_disount decimal(26,10) DEFAULT NULL,
  cost_per_day decimal(26,10) DEFAULT NULL,
  loc_amount decimal(26,10) DEFAULT NULL,
  loc_gst_amount decimal(26,10) DEFAULT NULL,
  loc_grand_amount decimal(26,10) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_dnote_renewal_history PRIMARY KEY (history_id)
);

COMMENT ON COLUMN ce_dnote_renewal_history.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_eodetails CASCADE;

CREATE TABLE ce_eodetails (
  eodetails_id UUID NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  subid int DEFAULT NULL,
  contact_person_name varchar(50) DEFAULT NULL,
  mobileno varchar(10) DEFAULT NULL,
  land_line_number varchar(10) DEFAULT NULL,
  emailid varchar(50) DEFAULT NULL,
  customer_address varchar(250) DEFAULT NULL,
  installation_address varchar(250) DEFAULT NULL,
  commission_date date DEFAULT NULL,
  commission_doc varchar(250) DEFAULT NULL,
  created_by varchar(50) DEFAULT NULL,
  end_office_name varchar(100) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_eodetails PRIMARY KEY (eodetails_id)
);

COMMENT ON COLUMN ce_eodetails.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_inovoice CASCADE;

CREATE TABLE ce_inovoice (
  inovoice_id UUID NOT NULL,
  slno BIGSERIAL,
  subscriberid bigint DEFAULT NULL,
  locid int DEFAULT NULL,
  mg_invoiceid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  invoiceno varchar(64) DEFAULT NULL,
  invoicedate date DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  locamount decimal(26,10) DEFAULT NULL,
  servicetax decimal(10,10) DEFAULT NULL,
  servicetaxrate decimal(10,10) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  quarter_start_date date DEFAULT NULL,
  quarter_end_date date DEFAULT NULL,
  gst_value decimal(26,10) DEFAULT NULL,
  cgst_value decimal(26,10) DEFAULT NULL,
  sgst_value decimal(26,10) DEFAULT NULL,
  igst_value decimal(26,10) DEFAULT NULL,
  cgst_rate decimal(26,2) DEFAULT NULL,
  sgst_rate decimal(26,2) DEFAULT NULL,
  igst_rate decimal(26,2) DEFAULT NULL,
  gstin varchar(18) DEFAULT NULL,
  particulars varchar(180) DEFAULT NULL,
  packageid int DEFAULT NULL,
  enable_opay boolean DEFAULT false,
  status_opay boolean DEFAULT false,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  taxpayertype smallint DEFAULT NULL,
  loc_reccount int DEFAULT 0,
  CONSTRAINT pk_ce_inovoice PRIMARY KEY (inovoice_id)
);

COMMENT ON COLUMN ce_inovoice.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_inovoice_master CASCADE;

CREATE TABLE ce_inovoice_master (
  master_id UUID NOT NULL,
  slno BIGSERIAL,
  subscriberid bigint DEFAULT NULL,
  locid int DEFAULT NULL,
  subfinanceid int DEFAULT NULL,
  invoiceno varchar(64) DEFAULT NULL,
  invoicemonth varchar(20) DEFAULT NULL,
  invoicedate date DEFAULT NULL,
  grossamount decimal(26,10) DEFAULT NULL,
  locamount decimal(26,10) DEFAULT NULL,
  servicetax decimal(10,10) DEFAULT NULL,
  servicetaxrate decimal(10,2) DEFAULT NULL,
  servicestartdate date DEFAULT NULL,
  serviceenddate date DEFAULT NULL,
  quarter_start_date date DEFAULT NULL,
  quarter_end_date date DEFAULT NULL,
  gst_value decimal(26,10) DEFAULT NULL,
  cgst_value decimal(26,10) DEFAULT NULL,
  sgst_value decimal(26,10) DEFAULT NULL,
  igst_value decimal(26,10) DEFAULT NULL,
  cgst_rate decimal(26,10) DEFAULT NULL,
  sgst_rate decimal(26,10) DEFAULT NULL,
  igst_rate decimal(26,10) DEFAULT NULL,
  paid_amount decimal(26,10) DEFAULT 0.0000000000,
  gstin varchar(18) DEFAULT NULL,
  taxpayertype smallint DEFAULT NULL,
  particulars varchar(180) DEFAULT NULL,
  einvoice_generated boolean DEFAULT false,
  crnote_amount decimal(26,10) DEFAULT 0.0000000000,
  crnote_gst decimal(26,10) DEFAULT 0.0000000000,
  crnote_total decimal(26,10) DEFAULT 0.0000000000,
  poid int DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean DEFAULT true,
  CONSTRAINT pk_ce_inovoice_master PRIMARY KEY (master_id)
);

COMMENT ON COLUMN ce_inovoice_master.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_kyc_details CASCADE;

CREATE TABLE ce_kyc_details (
  kyc_id UUID NOT NULL,
  id SERIAL,
  customerid int DEFAULT NULL,
  pan_numer varchar(10) DEFAULT NULL,
  pan_copy varchar(100) DEFAULT NULL,
  gstin varchar(15) DEFAULT NULL,
  gstindoc varchar(100) DEFAULT NULL,
  supportdoc varchar(100) DEFAULT NULL,
  taxpayertype boolean DEFAULT NULL,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_status boolean DEFAULT false,
  lut_doc varchar(200) DEFAULT NULL,
  sez_verified boolean DEFAULT false,
  approve_status boolean DEFAULT false,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_kyc_details PRIMARY KEY (kyc_id)
);

COMMENT ON COLUMN ce_kyc_details.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS ce_location_movement CASCADE;

CREATE TABLE ce_location_movement (
  movement_id UUID NOT NULL,
  id SERIAL,
  locid int DEFAULT NULL,
  approve_status int DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  created_by varchar(128) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  CONSTRAINT pk_ce_location_movement PRIMARY KEY (movement_id)
);

COMMENT ON COLUMN ce_location_movement.is_active IS '0=In Active,1=Active';
DROP TABLE IF EXISTS bss_copy CASCADE;

CREATE TABLE bss_copy (
  copy_id UUID PRIMARY KEY NOT NULL,
  id int DEFAULT NULL,
  description varchar(20) DEFAULT NULL
);

COMMENT ON COLUMN bss_copy.copy_id IS 'Unique identifier for BSS copy records';


DROP TABLE IF EXISTS bunits_districts CASCADE;

CREATE TABLE bunits_districts (
  districts_id UUID PRIMARY KEY NOT NULL,
  bu_id int DEFAULT NULL,
  district_id int DEFAULT NULL
);

COMMENT ON COLUMN bunits_districts.districts_id IS 'Unique identifier for business units districts records';


DROP TABLE IF EXISTS business_rules CASCADE;

CREATE TABLE business_rules (
  rules_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  name varchar(256) DEFAULT NULL,
  level char(20) DEFAULT NULL,
  role char(50) DEFAULT NULL,
  status varchar(100) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  submit_action varchar(256) DEFAULT NULL,
  submit_action1 varchar(100) DEFAULT NULL,
  status_label varchar(50) DEFAULT NULL,
  trigger_action varchar(100) DEFAULT NULL
);

COMMENT ON COLUMN business_rules.rules_id IS 'Unique identifier for business rules records';


DROP TABLE IF EXISTS business_rules_movement CASCADE;

CREATE TABLE business_rules_movement (
  movement_id UUID PRIMARY KEY NOT NULL,
  mid SERIAL,
  brid int DEFAULT NULL,
  remarks text DEFAULT NULL,
  statuschanged_by varchar(100) DEFAULT NULL,
  statuschanged_on timestamp DEFAULT NULL
);

COMMENT ON COLUMN business_rules_movement.movement_id IS 'Unique identifier for business rules movement records';


DROP TABLE IF EXISTS businessunits CASCADE;

CREATE TABLE businessunits (
  units_id UUID PRIMARY KEY NOT NULL,
  companyid bigint NOT NULL,
  partnercompanyname varchar(150) DEFAULT NULL,
  status boolean NOT NULL DEFAULT false,
  companyregistrationno varchar(64) DEFAULT NULL,
  servicetaxno varchar(64) DEFAULT NULL,
  incometaxno varchar(45) DEFAULT NULL,
  vatno varchar(45) DEFAULT NULL,
  state varchar(64) DEFAULT NULL,
  pin int DEFAULT NULL,
  registrationdate date DEFAULT NULL,
  agreementno varchar(100) DEFAULT NULL,
  agreementdate date DEFAULT NULL,
  keycontactname varchar(45) DEFAULT NULL,
  keycontactnumber bigint DEFAULT NULL,
  keycontactemail varchar(128) DEFAULT NULL,
  lastupdate timestamp DEFAULT NULL,
  supportcontactname varchar(128) DEFAULT NULL,
  supportcontactno varchar(15) DEFAULT NULL,
  supportcontactemail varchar(128) DEFAULT NULL,
  managercontactname varchar(45) DEFAULT NULL,
  managercontactno bigint DEFAULT NULL,
  managercontactemail varchar(128) DEFAULT NULL,
  isactive int NOT NULL DEFAULT 1,
  allocated_bw varchar(45) DEFAULT NULL,
  consumed_bw varchar(45) DEFAULT NULL,
  pgiopt int NOT NULL DEFAULT 0,
  statecode varchar(5) DEFAULT NULL,
  acholdername varchar(100) DEFAULT NULL,
  actype varchar(5) DEFAULT NULL,
  bankname varchar(100) DEFAULT NULL,
  branchname varchar(100) DEFAULT NULL,
  acnumber varchar(50) DEFAULT NULL,
  IFSC varchar(30) DEFAULT NULL,
  ptype char(25) DEFAULT NULL,
  address varchar(300) DEFAULT NULL,
  approval_date timestamp DEFAULT NULL,
  approval_cl varchar(300) DEFAULT NULL,
  approval_response varchar(300) DEFAULT NULL,
  agreementcopy varchar(256) DEFAULT NULL,
  bankpasscopy varchar(256) DEFAULT NULL,
  incometaxproof varchar(256) DEFAULT NULL,
  servicetaxproof varchar(256) DEFAULT NULL,
  bank_acholder varchar(128) DEFAULT NULL,
  bank_actype varchar(45) DEFAULT NULL,
  bank_name varchar(128) DEFAULT NULL,
  bank_branch varchar(128) DEFAULT NULL,
  bank_acno varchar(64) DEFAULT NULL,
  bank_ifsc varchar(64) DEFAULT NULL,
  companynature varchar(64) DEFAULT NULL,
  STCode char(3) DEFAULT NULL,
  address_line1 varchar(120) DEFAULT NULL,
  address_line2 varchar(120) DEFAULT NULL,
  city varchar(64) DEFAULT NULL,
  PinCode varchar(7) DEFAULT NULL,
  StateName varchar(64) DEFAULT NULL,
  District varchar(64) DEFAULT NULL,
  gstin varchar(45) DEFAULT NULL,
  service_description varchar(180) DEFAULT NULL,
  SAC varchar(45) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  gst_verfied boolean NOT NULL DEFAULT false,
  taxpayertype boolean NOT NULL DEFAULT false,
  gstdeclartionstatus boolean NOT NULL DEFAULT false,
  subonrecharge boolean DEFAULT false,
  onlinepaymode varchar(100) DEFAULT NULL,
  mspverified smallint DEFAULT 1,
  otp varchar(20) DEFAULT NULL,
  otp_time timestamp DEFAULT NULL,
  remarks varchar(100) DEFAULT NULL,
  paymodedate timestamp DEFAULT NULL,
  mspverfieddate timestamp DEFAULT NULL,
  bankverfieddate timestamp DEFAULT NULL,
  lastrenewed_agreementdate date DEFAULT NULL,
  updated_by varchar(20) DEFAULT NULL,
  lastrenewed_agreementcopy varchar(256) DEFAULT NULL,
  loc_type int DEFAULT NULL,
  gst_status smallint DEFAULT NULL,
  catagory varchar(30) DEFAULT NULL,
  vas_enabled varchar(45) DEFAULT NULL,
  cbldoc varchar(256) DEFAULT NULL,
  railtelflag boolean DEFAULT true,
  territory_name varchar(45) DEFAULT NULL,
  ptnrattid varchar(100) DEFAULT NULL,
  ptnrlang varchar(100) DEFAULT NULL,
  bu_id SERIAL,
  name varchar(80) DEFAULT NULL,
  district_id int DEFAULT NULL,
  zone varchar(50) DEFAULT NULL,
  ce_zone varchar(50) DEFAULT NULL
);

COMMENT ON COLUMN businessunits.loc_type IS '1 Urban 2 Rural';
COMMENT ON COLUMN businessunits.units_id IS 'Unique identifier for business units records';
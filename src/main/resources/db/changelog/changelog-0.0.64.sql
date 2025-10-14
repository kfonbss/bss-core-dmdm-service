DROP TABLE IF EXISTS cordeletedipusers CASCADE;

CREATE TABLE cordeletedipusers (
  deletedipusers_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  framedip VARCHAR(18) DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  deleted_date TIMESTAMP DEFAULT NULL,
  created_date TIMESTAMP DEFAULT NULL,
  lastupdated_date TIMESTAMP DEFAULT NULL,
  deleted_by VARCHAR(50) DEFAULT NULL
);

COMMENT ON COLUMN cordeletedipusers.deletedipusers_id IS 'Unique identifier for deleted IP users records';


DROP TABLE IF EXISTS corframedipusers CASCADE;

CREATE TABLE corframedipusers (
  framedipusers_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  customerid INTEGER DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  ip_type INTEGER DEFAULT NULL,
  framed_pool VARCHAR(200) DEFAULT NULL,
  ipv4_address VARCHAR(200) DEFAULT NULL,
  delegated_IPv6_Prefix VARCHAR(200) DEFAULT NULL,
  alc_IPv6_Address VARCHAR(200) DEFAULT NULL,
  framed_route VARCHAR(200) DEFAULT NULL,
  active_from DATE DEFAULT NULL,
  active_to DATE DEFAULT NULL,
  rad_username VARCHAR(64) DEFAULT NULL,
  availinbss INTEGER DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1
);

COMMENT ON COLUMN corframedipusers.framedipusers_id IS 'Unique identifier for framed IP users records';
COMMENT ON COLUMN corframedipusers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS corp_ekyc CASCADE;

CREATE TABLE corp_ekyc (
  ekyc_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  olid INTEGER DEFAULT NULL,
  name VARCHAR(150) DEFAULT NULL,
  gender VARCHAR(50) DEFAULT NULL,
  co VARCHAR(150) DEFAULT NULL,
  house VARCHAR(200) DEFAULT NULL,
  street VARCHAR(200) DEFAULT NULL,
  lm VARCHAR(150) DEFAULT NULL,
  loc VARCHAR(200) DEFAULT NULL,
  vtc VARCHAR(150) DEFAULT NULL,
  po VARCHAR(100) DEFAULT NULL,
  subdist VARCHAR(100) DEFAULT NULL,
  dist VARCHAR(100) DEFAULT NULL,
  state VARCHAR(100) DEFAULT NULL,
  country VARCHAR(150) DEFAULT NULL,
  pc VARCHAR(64) DEFAULT NULL,
  dob VARCHAR(64) DEFAULT NULL,
  photo BYTEA,
  aadhaartranid VARCHAR(150) DEFAULT NULL,
  createdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  txtnid VARCHAR(150) DEFAULT NULL,
  aadharnum BIGINT DEFAULT NULL,
  mobilenum BIGINT DEFAULT NULL,
  email VARCHAR(128) DEFAULT NULL,
  status VARCHAR(30) DEFAULT NULL,
  subprofile BIGINT DEFAULT NULL,
  remarks VARCHAR(50) DEFAULT NULL,
  loc_code VARCHAR(8) DEFAULT NULL,
  verify_status SMALLINT DEFAULT 0,
  is_same_aadhar_conn_addr SMALLINT DEFAULT NULL,
  addressproof_type VARCHAR(256) DEFAULT NULL,
  addressproof_no VARCHAR(50) DEFAULT NULL,
  addressproof_copy BYTEA,
  username VARCHAR(50) DEFAULT NULL,
  commsiondate TIMESTAMP DEFAULT NULL,
  conn_house VARCHAR(100) DEFAULT NULL,
  conn_street VARCHAR(100) DEFAULT NULL,
  conn_lm VARCHAR(100) DEFAULT NULL,
  conn_loc VARCHAR(100) DEFAULT NULL,
  conn_vtc VARCHAR(100) DEFAULT NULL,
  conn_po VARCHAR(100) DEFAULT NULL,
  conn_subdist VARCHAR(100) DEFAULT NULL,
  conn_dist VARCHAR(100) DEFAULT NULL,
  conn_pc VARCHAR(100) DEFAULT NULL,
  pancard_copy BYTEA,
  gstinn_copy BYTEA,
  updated_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  anp VARCHAR(100) DEFAULT NULL,
  conn_constituency VARCHAR(256) DEFAULT NULL,
  address_status SMALLINT DEFAULT NULL,
  kyc_type CHAR(10) DEFAULT NULL,
  conn_addressproof_type VARCHAR(256) DEFAULT NULL,
  conn_addressproof_no VARCHAR(50) DEFAULT NULL,
  conn_addressproof_copy BYTEA,
  idproof_type VARCHAR(256) DEFAULT NULL,
  idproof_copy BYTEA,
  kyc_form_upload BYTEA,
  addressproof_copy1 VARCHAR(512) DEFAULT NULL,
  idproof_copy1 VARCHAR(512) DEFAULT NULL,
  kyc_form_upload1 VARCHAR(512) DEFAULT NULL,
  conn_addressproof_copy1 VARCHAR(512) DEFAULT NULL,
  created_on TIMESTAMP DEFAULT NULL,
  updated_on TIMESTAMP DEFAULT NULL,
  status_api_response VARCHAR(256) DEFAULT NULL,
  kyc_form_upload_back BYTEA,
  kyc_form_upload_back1 VARCHAR(512) DEFAULT NULL
);

COMMENT ON COLUMN corp_ekyc.ekyc_id IS 'Unique identifier for corporate eKYC records';
COMMENT ON COLUMN corp_ekyc.verify_status IS '0=Pending,1=Verified,2=Rejected';


DROP TABLE IF EXISTS corp_location_list CASCADE;

CREATE TABLE corp_location_list (
  location_list_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  corp_enq_id INTEGER DEFAULT NULL,
  status VARCHAR(150) DEFAULT '1',
  fe_id VARCHAR(150) DEFAULT NULL,
  partnerid BIGINT DEFAULT NULL,
  partnername VARCHAR(200) DEFAULT NULL,
  service_type VARCHAR(100) DEFAULT NULL,
  locname VARCHAR(100) DEFAULT NULL,
  district VARCHAR(50) DEFAULT NULL,
  pincode INTEGER DEFAULT NULL,
  location VARCHAR(100) DEFAULT NULL,
  address VARCHAR(500) DEFAULT NULL,
  lat VARCHAR(100) DEFAULT NULL,
  longt VARCHAR(100) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  created_by VARCHAR(50) DEFAULT NULL,
  is_active SMALLINT NOT NULL DEFAULT 1,
  contactno VARCHAR(10) DEFAULT NULL,
  constituency VARCHAR(100) DEFAULT NULL,
  gramapanchayath VARCHAR(256) DEFAULT NULL,
  geolocaddress TEXT,
  contact_person VARCHAR(200) DEFAULT NULL,
  email_id VARCHAR(200) DEFAULT NULL,
  no_of_users INTEGER DEFAULT NULL,
  bandwidth_required VARCHAR(100) DEFAULT NULL,
  no_of_private_ip INTEGER DEFAULT NULL,
  no_of_static_ip INTEGER DEFAULT NULL,
  no_of_eoffice_ip INTEGER DEFAULT NULL,
  pop_name VARCHAR(50) DEFAULT NULL,
  scope VARCHAR(100) DEFAULT NULL,
  boq VARCHAR(100) DEFAULT NULL,
  pppoe_migration SMALLINT DEFAULT 0,
  remarks TEXT,
  nearest_box_name VARCHAR(100) DEFAULT NULL,
  nearest_box_distance VARCHAR(100) DEFAULT NULL,
  nearest_box_pop VARCHAR(100) DEFAULT NULL,
  nearest_sub_id INTEGER DEFAULT NULL,
  nearest_sub_partnerid VARCHAR(50) DEFAULT NULL,
  nearest_sub_partnername VARCHAR(100) DEFAULT NULL,
  nearest_sub_partnermobile VARCHAR(15) DEFAULT NULL,
  nearest_sub_distance DECIMAL(10,2) DEFAULT NULL,
  nearest_partner_id VARCHAR(50) DEFAULT NULL,
  nearest_partner_name VARCHAR(100) DEFAULT NULL,
  nearest_partner_mobile VARCHAR(15) DEFAULT NULL,
  nearest_partner_distance DECIMAL(10,2) DEFAULT NULL,
  nearest_fe_id INTEGER DEFAULT NULL,
  nearest_box_latitude VARCHAR(100) DEFAULT NULL,
  nearest_box_longitude VARCHAR(100) DEFAULT NULL,
  est_fibre_qnty DECIMAL(10,2) DEFAULT NULL,
  bell_connected SMALLINT DEFAULT 0,
  est_fibre_cost DECIMAL(10,2) DEFAULT NULL,
  feasibility_checked SMALLINT DEFAULT 0
);

COMMENT ON COLUMN corp_location_list.location_list_id IS 'Unique identifier for corporate location list records';
COMMENT ON COLUMN corp_location_list.is_active IS '0=Inactive,1=Active';
COMMENT ON COLUMN corp_location_list.pppoe_migration IS '0=No,1=Yes';
COMMENT ON COLUMN corp_location_list.bell_connected IS '0=No,1=Yes';
COMMENT ON COLUMN corp_location_list.feasibility_checked IS '0=No,1=Yes';


DROP TABLE IF EXISTS corpenaltyemail CASCADE;

CREATE TABLE corpenaltyemail (
  penaltyemail_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  partnerid BIGINT DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  monthpart VARCHAR(50) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  db VARCHAR(10) DEFAULT NULL,
  sentdate TIMESTAMP DEFAULT NULL
);

COMMENT ON COLUMN corpenaltyemail.penaltyemail_id IS 'Unique identifier for penalty email records';


DROP TABLE IF EXISTS corporate_enquiries CASCADE;

CREATE TABLE corporate_enquiries (
  corporate_enquiries_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  company_name VARCHAR(100) DEFAULT NULL,
  contact_name VARCHAR(100) NOT NULL,
  contact_number BIGINT NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  latitude VARCHAR(50) DEFAULT NULL,
  longitude VARCHAR(50) DEFAULT NULL,
  company_address TEXT,
  requested_service TEXT,
  fesible_status VARCHAR(100) DEFAULT NULL,
  status VARCHAR(100) DEFAULT 'Open',
  corp_source VARCHAR(50) NOT NULL DEFAULT 'web',
  created_by VARCHAR(50) NOT NULL DEFAULT 'web',
  is_active SMALLINT NOT NULL DEFAULT 1,
  date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  ticket_id INTEGER DEFAULT NULL,
  connection_type VARCHAR(50) DEFAULT NULL,
  file_name VARCHAR(200) DEFAULT NULL,
  corp_enq_doc VARCHAR(200) DEFAULT NULL,
  company_type VARCHAR(100) DEFAULT NULL,
  remarks VARCHAR(1000) DEFAULT NULL,
  otp_value VARCHAR(10) DEFAULT NULL,
  otp_send_time TIMESTAMP DEFAULT NULL
);

COMMENT ON COLUMN corporate_enquiries.corporate_enquiries_id IS 'Unique identifier for corporate enquiries records';
COMMENT ON COLUMN corporate_enquiries.is_active IS '0=Inactive,1=Active';


DROP TABLE IF EXISTS corporate_enquiries_movement CASCADE;

CREATE TABLE corporate_enquiries_movement (
  corporate_enquiries_movement_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  corp_enq_id INTEGER DEFAULT NULL,
  fesible_status VARCHAR(100) DEFAULT NULL,
  status VARCHAR(100) DEFAULT NULL,
  created_by VARCHAR(100) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN corporate_enquiries_movement.corporate_enquiries_movement_id IS 'Unique identifier for corporate enquiries movement records';


DROP TABLE IF EXISTS corporate_service CASCADE;

CREATE TABLE corporate_service (
  corporate_service_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  service_name VARCHAR(100) NOT NULL,
  is_active SMALLINT NOT NULL DEFAULT 1
);

COMMENT ON COLUMN corporate_service.corporate_service_id IS 'Unique identifier for corporate service records';
COMMENT ON COLUMN corporate_service.is_active IS '0=Inactive,1=Active';



DROP TABLE IF EXISTS cordeletedipusers CASCADE;

CREATE TABLE cordeletedipusers (
  users_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  framedip VARCHAR(18) DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  deleted_date TIMESTAMP DEFAULT NULL,
  created_date TIMESTAMP DEFAULT NULL,
  lastupdated_date TIMESTAMP DEFAULT NULL,
  deleted_by VARCHAR(50) DEFAULT NULL,
  CONSTRAINT pk_cordeletedipusers PRIMARY KEY (users_id)
);


DROP TABLE IF EXISTS corframedipusers CASCADE;

CREATE TABLE corframedipusers (
  users_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  is_active INTEGER DEFAULT 1,
  CONSTRAINT pk_corframedipusers PRIMARY KEY (users_id)
);

COMMENT ON COLUMN corframedipusers.is_active IS '0=In Active,1=Active';


DROP TABLE IF EXISTS corp_ekyc CASCADE;

CREATE TABLE corp_ekyc (
  ekyc_id UUID DEFAULT gen_random_uuid() NOT NULL,
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
  kyc_form_upload_back1 VARCHAR(512) DEFAULT NULL,
  CONSTRAINT pk_corp_ekyc PRIMARY KEY (ekyc_id)
);


DROP TABLE IF EXISTS corp_location_list CASCADE;

CREATE TABLE corp_location_list (
  list_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active BOOLEAN,
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
  created_by_platform VARCHAR(50) DEFAULT NULL,
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
    --0=No,1=Yes
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
  --0=No,1=Yes
  est_fibre_cost DECIMAL(10,2) DEFAULT NULL,
  feasibility_checked SMALLINT DEFAULT 0,
  --0=No,1=Yes
   created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   modified_date TIMESTAMP,
   created_by UUID,
   modified_by UUID,
  CONSTRAINT pk_corp_location_list PRIMARY KEY (list_id)
);

INSERT INTO corp_location_list (
  list_id, id, code, name, name_in_local, is_active, corp_enq_id, status,
  fe_id, partnerid, partnername, service_type, locname, district, pincode, location,
  address, lat, longt, created_by_platform, contactno, constituency, gramapanchayath,
  geolocaddress, contact_person, email_id, no_of_users, bandwidth_required,
  no_of_private_ip, no_of_static_ip, no_of_eoffice_ip, pop_name, scope, boq,
  pppoe_migration, remarks, nearest_box_name, nearest_box_distance, nearest_box_pop,
  nearest_sub_id, nearest_sub_partnerid, nearest_sub_partnername, nearest_sub_partnermobile,
  nearest_sub_distance, nearest_partner_id, nearest_partner_name, nearest_partner_mobile,
  nearest_partner_distance, nearest_fe_id, nearest_box_latitude, nearest_box_longitude,
  est_fibre_qnty, bell_connected, est_fibre_cost, feasibility_checked,
  created_date, modified_date, created_by, modified_by
)
VALUES (
  gen_random_uuid(), 1, 'CL001', 'Corporate Location 1', 'കോർപ്പറേറ്റ് സ്ഥലം 1', true, 1001, '1',
  'FE123', 501, 'Partner A', 'Internet', 'Main Office', 'Kozhikode', 673001, 'City Center',
  '123 Main Street, Kozhikode', '11.2588', '75.7804', 'Web', '9876543210', 'Kozhikode North', 'Panchayat A',
  'Near Bus Stand', 'John Doe', 'info@example.com', 50, '100 Mbps',
  5, 2, 1, 'POP-001', 'Full', 'BOQ-001',
  1, 'Fiber connectivity required', 'Box A', '200m', 'POP-101',
  10, 'SUB123', 'Sub Partner A', '9999988888',
  0.75, 'P123', 'Partner A', '9999977777',
  0.80, 301, '11.256', '75.782',
  150.25, 1, 1200.50, 1,
  CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);

DROP TABLE IF EXISTS corpenaltyemail CASCADE;

CREATE TABLE corpenaltyemail (
  email_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  partnerid BIGINT DEFAULT NULL,
  subscriberid INTEGER DEFAULT NULL,
  monthpart VARCHAR(50) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  db VARCHAR(10) DEFAULT NULL,
  sentdate TIMESTAMP DEFAULT NULL,
  CONSTRAINT pk_corpenaltyemail PRIMARY KEY (email_id)
);


DROP TABLE IF EXISTS corporate_enquiries CASCADE;

CREATE TABLE corporate_enquiries (
  enquiries_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active BOOLEAN,
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
  created_by_platform VARCHAR(50) NOT NULL DEFAULT 'web',
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  ticket_id INTEGER DEFAULT NULL,
  connection_type VARCHAR(50) DEFAULT NULL,
  file_name VARCHAR(200) DEFAULT NULL,
  corp_enq_doc VARCHAR(200) DEFAULT NULL,
  company_type VARCHAR(100) DEFAULT NULL,
  remarks VARCHAR(1000) DEFAULT NULL,
  otp_value VARCHAR(10) DEFAULT NULL,
  otp_send_time TIMESTAMP DEFAULT NULL,
  CONSTRAINT pk_corporate_enquiries PRIMARY KEY (enquiries_id)
);

INSERT INTO corporate_enquiries (
  enquiries_id,
  code,
  name,
  name_in_local,
  is_active,
  id,
  company_name,
  contact_name,
  contact_number,
  email_id,
  latitude,
  longitude,
  company_address,
  requested_service,
  fesible_status,
  status,
  corp_source,
  created_by_platform,
  created_date,
  modified_date,
  created_by,
  modified_by,
  ticket_id,
  connection_type,
  file_name,
  corp_enq_doc,
  company_type,
  remarks,
  otp_value,
  otp_send_time
)
VALUES (
  gen_random_uuid(),
  'ENQ001',
  'John Doe',
  'ജോൺ ഡോ',
  TRUE,
  DEFAULT,
  'Tech Innovations Pvt Ltd',
  'John Doe',
  9876543210,
  'john.doe@example.com',
  '10.0156',
  '76.3419',
  '123, InfoPark Road, Kakkanad, Kochi',
  'Corporate Internet Connection',
  'Feasible',
  'Open',
  'web',
  'system',
  CURRENT_TIMESTAMP,
  NULL,
  NULL,
  NULL,
  1001,
  'Fiber',
  'quotation.pdf',
  'proposal.docx',
  'IT Company',
  'Requested urgent connection setup.',
  '123456',
  CURRENT_TIMESTAMP
);



DROP TABLE IF EXISTS corporate_enquiries_movement CASCADE;

CREATE TABLE corporate_enquiries_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  corp_enq_id INTEGER DEFAULT NULL,
  fesible_status VARCHAR(100) DEFAULT NULL,
  status VARCHAR(100) DEFAULT NULL,
  created_by VARCHAR(100) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_corporate_enquiries_movement PRIMARY KEY (movement_id)
);


DROP TABLE IF EXISTS corporate_service CASCADE;

CREATE TABLE corporate_service (
  service_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  service_name VARCHAR(100) NOT NULL,
  is_active SMALLINT NOT NULL DEFAULT 1,
  CONSTRAINT pk_corporate_service PRIMARY KEY (service_id)
);

COMMENT ON COLUMN corporate_service.is_active IS '0=Inactive,1=Active';



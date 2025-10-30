DROP TABLE IF EXISTS appliedonline_darkfibre CASCADE;

CREATE TABLE appliedonline_darkfibre (
  darkfibre_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  firm_name varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  firm_contactno varchar(20) DEFAULT NULL,
  firm_email varchar(156) DEFAULT NULL,
  contactperson_name varchar(256) DEFAULT NULL,
  contact_mobileno varchar(12) DEFAULT NULL,
  contact_email varchar(256) DEFAULT NULL,
  lease_purpose text DEFAULT NULL,
  internet_service_license_copy varchar(256) DEFAULT NULL,
  telecom_area_circle varchar(156) DEFAULT NULL,
  support_experience_certificate varchar(512) DEFAULT NULL,
  behalf_companylease varchar(256) DEFAULT NULL,
  covering_letter_copy varchar(512) DEFAULT NULL,
  route_form_copy varchar(512) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  approve_status int DEFAULT 0,
  pan varchar(10) DEFAULT NULL,
  pan_copy varchar(100) DEFAULT NULL,
  gstin varchar(15) DEFAULT NULL,
  gstindoc varchar(100) DEFAULT NULL,
  taxpayertype smallint DEFAULT NULL,
  legalname varchar(250) DEFAULT NULL,
  tradename varchar(250) DEFAULT NULL,
  sac varchar(20) DEFAULT NULL,
  service_description varchar(150) DEFAULT NULL,
  gst_status smallint DEFAULT 0,
  CONSTRAINT pk_appliedonline_darkfibre PRIMARY KEY (darkfibre_id)
);

CREATE UNIQUE INDEX firm_name_unique ON appliedonline_darkfibre (firm_name);
CREATE UNIQUE INDEX firm_contactno_unique ON appliedonline_darkfibre (firm_contactno);
CREATE UNIQUE INDEX firm_email_unique ON appliedonline_darkfibre (firm_email);
CREATE UNIQUE INDEX contact_mobileno_unique ON appliedonline_darkfibre (contact_mobileno);
CREATE UNIQUE INDEX contact_email_unique ON appliedonline_darkfibre (contact_email);


DROP TABLE IF EXISTS appliedonline_eo CASCADE;

CREATE TABLE appliedonline_eo (
  eo_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id BIGSERIAL,
  prefix varchar(10) DEFAULT NULL,
  cus_name varchar(200) DEFAULT NULL,
  cus_mobile varchar(10) DEFAULT NULL,
  cus_phone varchar(20) DEFAULT NULL,
  cus_email varchar(100) DEFAULT NULL,
  cus_address text DEFAULT NULL,
  cus_state varchar(50) DEFAULT NULL,
  cus_city varchar(50) DEFAULT NULL,
  cus_location varchar(100) DEFAULT NULL,
  cus_pincode varchar(20) DEFAULT NULL,
  cus_conn_type varchar(10) DEFAULT NULL,
  cus_speed varchar(30) DEFAULT NULL,
  status varchar(100) DEFAULT NULL,
  description text DEFAULT NULL,
  remarks text DEFAULT NULL,
  circle varchar(50) DEFAULT NULL,
  region varchar(50) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  partnername varchar(256) DEFAULT NULL,
  dmkg int DEFAULT NULL,
  previous_cmnts text DEFAULT NULL,
  previous_cmnts1 text DEFAULT NULL,
  district_code char(10) DEFAULT NULL,
  popname varchar(256) DEFAULT NULL,
  location varchar(256) DEFAULT NULL,
  endoffice_name varchar(256) DEFAULT NULL,
  CONSTRAINT pk_appliedonline_eo PRIMARY KEY (eo_id)
);

CREATE INDEX circle_eo_idx ON appliedonline_eo (circle);
CREATE INDEX region_eo_idx ON appliedonline_eo (region);
CREATE INDEX cus_name_eo_idx ON appliedonline_eo (cus_name);
CREATE INDEX cus_mobile_eo_idx ON appliedonline_eo (cus_mobile);
CREATE INDEX created_dt_eo_idx ON appliedonline_eo (created_dt);
CREATE INDEX status_eo_idx ON appliedonline_eo (status);

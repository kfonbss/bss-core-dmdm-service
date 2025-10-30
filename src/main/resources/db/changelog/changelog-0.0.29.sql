DROP TABLE IF EXISTS appliedonline_partners CASCADE;

CREATE TABLE appliedonline_partners (
  partners_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id BIGSERIAL,
  ptnr_name varchar(200) DEFAULT NULL,
  ptnr_mobile varchar(10) DEFAULT NULL,
  ptnr_phone varchar(12) DEFAULT NULL,
  ptnr_email varchar(100) DEFAULT NULL,
  ptnr_address text DEFAULT NULL,
  ptnr_state varchar(50) DEFAULT NULL,
  ptnr_city varchar(50) DEFAULT NULL,
  ptnr_location varchar(100) DEFAULT NULL,
  ptnr_pincode varchar(100) DEFAULT NULL,
  ptnr_assoc_any_other_isp varchar(10) DEFAULT NULL,
  status varchar(100) DEFAULT NULL,
  description text DEFAULT NULL,
  remarks varchar(256) DEFAULT NULL,
  circle varchar(50) DEFAULT NULL,
  region varchar(50) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  ptnr_latitude varchar(50) DEFAULT NULL,
  ptnr_longitude varchar(50) DEFAULT NULL,
  ptnr_aadharno varchar(50) DEFAULT NULL,
  ptnr_aadhar_copy varchar(100) DEFAULT NULL,
  ptnr_cabletv_reg_copy varchar(100) DEFAULT NULL,
  ptnr_cabbletv_subcount varchar(100) DEFAULT NULL,
  ptnr_internet_subcount varchar(100) DEFAULT NULL,
  ptnr_network_qty varchar(100) DEFAULT NULL,
  ptnr_companyname varchar(100) DEFAULT NULL,
  ptnr_postoffice varchar(100) DEFAULT NULL,
  district varchar(100) DEFAULT NULL,
  block varchar(100) DEFAULT NULL,
  panchayat varchar(100) DEFAULT NULL,
  locality char(20) DEFAULT NULL,
  fe_id int DEFAULT NULL,
  tracking_id varchar(10) DEFAULT NULL,
  ticket_id int DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_by varchar(100) DEFAULT NULL,
  creby_emp_name varchar(100) DEFAULT NULL,
  creby_emp_id varchar(100) DEFAULT NULL,
  CONSTRAINT pk_appliedonline_partners PRIMARY KEY (partners_id)
);

CREATE UNIQUE INDEX ptnr_mobile_unique ON appliedonline_partners (ptnr_mobile);
CREATE UNIQUE INDEX ptnr_email_unique ON appliedonline_partners (ptnr_email);
CREATE INDEX circle_partners_idx ON appliedonline_partners (circle);
CREATE INDEX region_partners_idx ON appliedonline_partners (region);
CREATE INDEX ptnr_name_idx ON appliedonline_partners (ptnr_name);
CREATE INDEX ptnr_mobile_idx ON appliedonline_partners (ptnr_mobile);
CREATE INDEX created_dt_partners_idx ON appliedonline_partners (created_dt);
CREATE INDEX status_partners_idx ON appliedonline_partners (status);

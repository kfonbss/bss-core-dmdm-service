DROP TABLE IF EXISTS appliedonline_agnp CASCADE;

CREATE TABLE appliedonline_agnp (
  online_agnp_id UUID DEFAULT gen_random_uuid() NOT NULL,
  agnp_id BIGSERIAL,
  agnp_name varchar(200) DEFAULT NULL,
  agnp_assoc_any_other_isp varchar(10) DEFAULT NULL,
  agnp_contact_name varchar(200) DEFAULT NULL,
  agnp_mobile_number varchar(10) DEFAULT NULL,
  agnp_altr_contact_number varchar(10) DEFAULT NULL,
  agnp_landline_number varchar(20) DEFAULT NULL,
  agnp_email varchar(100) DEFAULT NULL,
  agnp_address text DEFAULT NULL,
  agnp_location varchar(200) DEFAULT NULL,
  agnp_latitue varchar(50) DEFAULT NULL,
  agnp_longitude varchar(50) DEFAULT NULL,
  agnp_pincode varchar(10) DEFAULT NULL,
  agnp_postoffice varchar(50) DEFAULT NULL,
  agnp_district varchar(50) DEFAULT NULL,
  agnp_aadharno varchar(50) DEFAULT NULL,
  agnp_aadharcopy varchar(200) DEFAULT NULL,
  agnp_status varchar(50) DEFAULT NULL,
  agnp_source varchar(100) DEFAULT NULL,
  agnp_created_by varchar(100) DEFAULT NULL,
  agnp_created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  agnp_updated_date timestamp DEFAULT CURRENT_TIMESTAMP,
  agnp_updated_by varchar(100) DEFAULT NULL,
  agnp_remarks text DEFAULT NULL,
  is_active boolean NOT NULL DEFAULT true,
  tracking_id varchar(10) DEFAULT NULL,
  CONSTRAINT pk_appliedonline_agnp PRIMARY KEY (online_agnp_id)
);


DROP TABLE IF EXISTS appliedonline_agnp_movement CASCADE;

CREATE TABLE appliedonline_agnp_movement (
  movement_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id BIGSERIAL,
  agnp_id bigint DEFAULT NULL,
  note text DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  created_by varchar(100) DEFAULT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_appliedonline_agnp_movement PRIMARY KEY (movement_id)
);

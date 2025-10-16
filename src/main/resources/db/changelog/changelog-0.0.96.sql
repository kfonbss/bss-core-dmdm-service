-- Table : msplnp_tickets
DROP TABLE IF EXISTS msplnp_tickets CASCADE;

CREATE TABLE msplnp_tickets (
  msplnp_tickets_id UUID NOT NULL,
  id SERIAL,
  ticket_number varchar(50) NOT NULL,
  enquiry_type varchar(50) NOT NULL,
  enquiry_id int NOT NULL,
  tracking_id varchar(20) DEFAULT NULL,
  enquiry_district varchar(50) DEFAULT NULL,
  mobileno varchar(12) DEFAULT NULL,
  loc_address text DEFAULT NULL,
  username varchar(64) DEFAULT NULL,
  status_id int NOT NULL DEFAULT 1,
  fibre_4f_scope decimal(10,2) DEFAULT 0.00,
  -- 'in metres',
  fibre_ug_scope decimal(10,2) DEFAULT NULL,
  HDPE_pipe_scope decimal(10,2) DEFAULT NULL,
  splitter_1_2_scope int DEFAULT 0,
  splitter_1_4_scope int DEFAULT 0,
  splitter_1_8_scope int DEFAULT 0,
  ftb_scope int DEFAULT 0,
  -- 'in numbers',
  patch_cord_scope int DEFAULT 0,
  -- 'in numbers',
  tension_clamp_4f_scope int DEFAULT 0,
  -- 'in numbers',
  anchor_bolt_scope int DEFAULT 0,
  -- 'in numbers',
  protection_sleeve_scope int DEFAULT 0,
  -- 'in numbers',
  suspension_clamp_4f_scope int DEFAULT 0,
  -- 'in numbers',
  KFON_tag_scope int DEFAULT 0,
  stay_wire_scope int DEFAULT 0,
  fibre_4f_actual decimal(10,2) DEFAULT NULL,
  fibre_ug_actual decimal(10,2) DEFAULT NULL,
  HDPE_pipe_actual decimal(10,2) DEFAULT NULL,
  splitter_1_2_actual int DEFAULT NULL,
  splitter_1_4_actual int DEFAULT NULL,
  splitter_1_8_actual int DEFAULT NULL,
  ftb_actual int DEFAULT NULL,
  patch_cord_actual int DEFAULT NULL,
  tension_clamp_4f_actual int DEFAULT NULL,
  anchor_bolt_actual int DEFAULT NULL,
  protection_sleeve_actual int DEFAULT NULL,
  suspension_clamp_4f_actual int DEFAULT NULL,
  KFON_tag_actual int DEFAULT NULL,
  stay_wire_actual int DEFAULT NULL,
  splice_plan_uploaded varchar(50) DEFAULT 'no' CHECK (splice_plan_uploaded IN ('yes','no')),
  latitude varchar(100) DEFAULT NULL,
  longitude varchar(100) DEFAULT NULL,
  created_by varchar(50) DEFAULT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_msplnp_tickets_ticket_number UNIQUE (ticket_number),
  -- Primary key constraint
CONSTRAINT pk_msplnp_tickets PRIMARY KEY (msplnp_tickets_id)
);

-- Create indexes for better performance
CREATE INDEX idx_msplnp_tickets_idx_enquiry_type ON msplnp_tickets (enquiry_type);
CREATE INDEX idx_msplnp_tickets_idx_enquiry_id ON msplnp_tickets (enquiry_id);
CREATE INDEX idx_msplnp_tickets_idx_status_id ON msplnp_tickets (status_id);
CREATE INDEX idx_msplnp_tickets_idx_created_by ON msplnp_tickets (created_by);

-- Table : nas
DROP TABLE IF EXISTS nas CASCADE;

CREATE TABLE nas (
  nas_id UUID NOT NULL,
  id SERIAL,
  nasname varchar(128) NOT NULL,
  shortname varchar(32) DEFAULT NULL,
  type varchar(30) DEFAULT 'other',
  ports int DEFAULT NULL,
  secret varchar(60) NOT NULL DEFAULT 'secret',
  community varchar(50) DEFAULT NULL,
  description varchar(200) DEFAULT 'RADIUS Client',
  -- Primary key constraint
CONSTRAINT pk_nas PRIMARY KEY (nas_id)
);

-- Create indexes for better performance
CREATE INDEX idx_nas_nasname ON nas (nasname);

-- Table : network_performance_details
DROP TABLE IF EXISTS network_performance_details CASCADE;

CREATE TABLE network_performance_details (
  network_performance_details_id UUID NOT NULL,
  id SERIAL,
  device_id varchar(200) DEFAULT NULL,
  username varchar(60) DEFAULT NULL,
  mac_address varchar(60) DEFAULT NULL,
  packageid int DEFAULT NULL,
  packagename varchar(45) NOT NULL,
  download_mbps varchar(50) DEFAULT NULL,
  upload_mbps varchar(50) DEFAULT NULL,
  test_bytes_rx int DEFAULT NULL,
  test_bytes_tx int DEFAULT NULL,
  upload_period varchar(50) DEFAULT NULL,
  download_period varchar(50) DEFAULT NULL,
  packets_transmitted varchar(50) DEFAULT NULL,
  packets_received varchar(50) DEFAULT NULL,
  packets_loss varchar(50) DEFAULT NULL,
  ping_rtt_description varchar(50) DEFAULT NULL,
  packets_count varchar(50) DEFAULT NULL,
  packets_mean varchar(50) DEFAULT NULL,
  packets_std varchar(50) DEFAULT NULL,
  packets_min varchar(50) DEFAULT NULL,
  packets_25 varchar(50) DEFAULT NULL,
  packets_50 varchar(50) DEFAULT NULL,
  packets_75 varchar(50) DEFAULT NULL,
  packets_max varchar(50) DEFAULT NULL,
  execute_status int DEFAULT 0,
  -- '0=Not Executed,1=Executed',
  execute_time timestamp DEFAULT NULL,
  month_part varchar(10) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_network_performance_details PRIMARY KEY (network_performance_details_id)
);


-- Table : nms_endoffices
DROP TABLE IF EXISTS nms_endoffices CASCADE;

CREATE TABLE nms_endoffices (
  nms_endoffices_id UUID NOT NULL,
  id SERIAL,
  eo_uid varchar(20) DEFAULT NULL,
  popname varchar(50) DEFAULT NULL,
  ontmacaddress varchar(50) DEFAULT NULL,
  vlanid varchar(50) DEFAULT NULL,
  wannetwork varchar(50) DEFAULT NULL,
  subnetmask varchar(50) DEFAULT NULL,
  kfonendip varchar(50) DEFAULT NULL,
  customerip varchar(50) DEFAULT NULL,
  bandwidth_mbps int DEFAULT NULL,
  contactno varchar(20) DEFAULT NULL,
  landlineno varchar(20) DEFAULT NULL,
  department varchar(128) DEFAULT NULL,
  linedepartment varchar(100) DEFAULT NULL,
  conf_form_copy varchar(128) DEFAULT NULL,
  CONSTRAINT uq_nms_endoffices_contactno UNIQUE (contactno),
  CONSTRAINT uq_nms_endoffices_landlineno UNIQUE (landlineno),
  -- Primary key constraint
CONSTRAINT pk_nms_endoffices PRIMARY KEY (nms_endoffices_id)
);


-- Table : node
DROP TABLE IF EXISTS node CASCADE;

CREATE TABLE node (
  node_id UUID NOT NULL,
  nodeid int NOT NULL DEFAULT 0,
  nodename varchar(200) DEFAULT NULL,
  statecode varchar(5) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_node PRIMARY KEY (node_id)
);


-- Table : notice
DROP TABLE IF EXISTS notice CASCADE;

CREATE TABLE notice (
  notice_id UUID NOT NULL,
  noticeid int NOT NULL,
  type char(5) DEFAULT NULL,
  start_date timestamp DEFAULT NULL,
  end_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "from" varchar(120) DEFAULT NULL,
  "to" varchar(45) NOT NULL DEFAULT 'ALL',
  to_type varchar(45) DEFAULT NULL,
  title varchar(256) DEFAULT NULL,
  message text DEFAULT NULL,
  showonce INT NOT NULL DEFAULT 0,
  read INT NOT NULL DEFAULT 0,
  attachement int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_notice PRIMARY KEY (notice_id)
);

-- Create indexes for better performance
CREATE INDEX idx_notice_index2 ON notice (type, start_date, end_date, "to", to_type, showonce);

-- Table : of_splicers
DROP TABLE IF EXISTS of_splicers CASCADE;

CREATE TABLE of_splicers (
  of_splicers_id UUID NOT NULL,
  id SERIAL,
  name varchar(256) DEFAULT NULL,
  mobile varchar(15) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  district varchar(256) DEFAULT NULL,
  popm char(5) DEFAULT NULL,
  ownvehile char(5) DEFAULT NULL,
  filepath varchar(256) DEFAULT NULL,
  created_dt timestamp DEFAULT NULL,
  updated_dt timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_of_splicers PRIMARY KEY (of_splicers_id)
);


-- Table : onboard_config
DROP TABLE IF EXISTS onboard_config CASCADE;

CREATE TABLE onboard_config (
  onboard_config_id UUID NOT NULL,
  id SERIAL,
  rgnnoc_mailid varchar(250) DEFAULT NULL,
  cnoc_mail_ids varchar(250) DEFAULT NULL,
  intial_rcamount decimal(10,2) DEFAULT NULL,
  region varchar(50) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_onboard_config PRIMARY KEY (onboard_config_id)
);
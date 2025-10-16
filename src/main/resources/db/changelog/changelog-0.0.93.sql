-- Table : lnp_ont_invoicing
DROP TABLE IF EXISTS lnp_ont_invoicing CASCADE;

CREATE TABLE lnp_ont_invoicing (
  lnp_ont_invoicing_id UUID NOT NULL,
  slno SERIAL,
  invoicemonth varchar(20) DEFAULT NULL,
  invoiceno varchar(50) DEFAULT NULL,
  partnerid int DEFAULT NULL,
  total_amount decimal(10,2) DEFAULT NULL,
  TDSPartner decimal(13,2) DEFAULT NULL,
  cgsttds_amount decimal(13,2) DEFAULT NULL,
  sgsttds_amount decimal(13,2) DEFAULT NULL,
  gst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  gross_amount decimal(10,2) DEFAULT NULL,
  cgst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  sgst_amount decimal(13,2) NOT NULL DEFAULT 0.00,
  gst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  cgst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  sgst_rate decimal(13,2) NOT NULL DEFAULT 0.00,
  gstin varchar(15) DEFAULT NULL,
  Pan varchar(12) DEFAULT NULL,
  taxpayertype INT DEFAULT 0,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_lnp_ont_invoicing PRIMARY KEY (lnp_ont_invoicing_id)
);


-- Table : lnp_service_area_list
DROP TABLE IF EXISTS lnp_service_area_list CASCADE;

CREATE TABLE lnp_service_area_list (
  lnp_service_area_list_id UUID NOT NULL,
  id SERIAL,
  partnerid int DEFAULT NULL,
  pincode varchar(6) DEFAULT NULL,
  post_offc_name varchar(100) DEFAULT NULL,
  created_by varchar(150) DEFAULT NULL,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  is_active INT DEFAULT 1,
  -- Primary key constraint
CONSTRAINT pk_lnp_service_area_list PRIMARY KEY (lnp_service_area_list_id)
);


-- Table : loc_master
DROP TABLE IF EXISTS loc_master CASCADE;

CREATE TABLE loc_master (
  loc_master_id UUID NOT NULL,
  loc_code varchar(20) DEFAULT NULL,
  subscriber_name varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  pincode varchar(20) DEFAULT NULL,
  district varchar(100) DEFAULT NULL,
  gp varchar(512) DEFAULT NULL,
  constituency varchar(512) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_loc_master PRIMARY KEY (loc_master_id)
);


-- Table : locality
DROP TABLE IF EXISTS locality CASCADE;

CREATE TABLE locality (
  locality_id UUID NOT NULL,
  localityid SERIAL,
  localityname varchar(250) DEFAULT NULL,
  pin int DEFAULT NULL,
  cityid int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_locality PRIMARY KEY (locality_id)
);


-- Table : localitymap
DROP TABLE IF EXISTS localitymap CASCADE;

CREATE TABLE localitymap (
  localitymap_id UUID NOT NULL,
  localitymapid SERIAL,
  partnerid int NOT NULL,
  localityid int NOT NULL,
  CONSTRAINT uq_localitymap_partnerid_localityid UNIQUE (partnerid, localityid),
  -- Primary key constraint
CONSTRAINT pk_localitymap PRIMARY KEY (localitymap_id)
);


-- Table : logs
DROP TABLE IF EXISTS logs CASCADE;

CREATE TABLE logs (
  logs_id UUID NOT NULL,
  id SERIAL,
  uri varchar(255) NOT NULL,
  method varchar(6) NOT NULL,
  params text DEFAULT NULL,
  api_key varchar(40) NOT NULL,
  ip_address varchar(45) NOT NULL,
  time int NOT NULL,
  rtime decimal DEFAULT NULL,
  authorized varchar(1) NOT NULL,
  response_code smallint DEFAULT 0,
  -- Primary key constraint
CONSTRAINT pk_logs PRIMARY KEY (logs_id)
);


-- Table : mapp_users
DROP TABLE IF EXISTS mapp_users CASCADE;

CREATE TABLE mapp_users (
  mapp_users_id UUID NOT NULL,
  id SERIAL,
  username varchar(100) DEFAULT NULL,
  name varchar(150) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  partnerid int DEFAULT NULL,
  deviceid varchar(100) DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  user_type varchar(20) DEFAULT NULL,
  status INT DEFAULT NULL,
  pin_number int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_mapp_users PRIMARY KEY (mapp_users_id)
);

-- Create indexes for better performance
CREATE INDEX idx_mapp_users_index2 ON mapp_users (partnerid);

-- Table : mapp_version
DROP TABLE IF EXISTS mapp_version CASCADE;

CREATE TABLE mapp_version (
  mapp_version_id UUID NOT NULL,
  id SERIAL,
  version varchar(50) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_mapp_version PRIMARY KEY (mapp_version_id)
);


-- Table : menu
DROP TABLE IF EXISTS menu CASCADE;

CREATE TABLE menu (
  menu_id UUID NOT NULL,
  id SERIAL,
  title varchar(100) NOT NULL DEFAULT '',
  link_type varchar(20) NOT NULL DEFAULT 'uri',
  page_id int NOT NULL DEFAULT 0,
  module_name varchar(50) NOT NULL DEFAULT '',
  icon varchar(20) DEFAULT NULL,
  url varchar(255) NOT NULL DEFAULT '',
  uri varchar(255) NOT NULL DEFAULT '',
  dyn_group_id int NOT NULL DEFAULT 0,
  position int NOT NULL DEFAULT 0,
  target varchar(10) DEFAULT NULL,
  parent_id int NOT NULL DEFAULT 0,
  is_parent INT NOT NULL DEFAULT 0,
  show_menu VARCHAR(1) NOT NULL DEFAULT '1' CHECK (show_menu IN ('0','1')),
  role varchar(30) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_menu PRIMARY KEY (menu_id)
);


-- Table : mimoonlinerecharge
DROP TABLE IF EXISTS mimoonlinerecharge CASCADE;

CREATE TABLE mimoonlinerecharge (
  mimoonlinerecharge_id UUID NOT NULL,
  id SERIAL,
  subscriberid int  NOT NULL,
  partnerid int DEFAULT NULL,
  ordernumber varchar(64) DEFAULT NULL,
  txnid varchar(64) DEFAULT NULL,
  status varchar(64) DEFAULT NULL,
  amount decimal(13,2) DEFAULT NULL,
  txnamount decimal(13,2) DEFAULT NULL,
  anpshare decimal(20,2) DEFAULT NULL,
  railtelshare decimal(20,2) DEFAULT NULL,
  orderdate timestamp DEFAULT NULL,
  reportdate timestamp DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_mimoonlinerecharge PRIMARY KEY (mimoonlinerecharge_id)
);


-- Table : mobile_app_images
DROP TABLE IF EXISTS mobile_app_images CASCADE;

CREATE TABLE mobile_app_images (
  mobile_app_images_id UUID NOT NULL,
  id SERIAL,
  image_name varchar(100) DEFAULT NULL,
  screen_id int DEFAULT NULL,
  is_active int DEFAULT NULL,
  user_type int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_mobile_app_images PRIMARY KEY (mobile_app_images_id)
);
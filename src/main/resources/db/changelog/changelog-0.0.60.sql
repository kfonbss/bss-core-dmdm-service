DROP TABLE IF EXISTS cor_railtel_payment CASCADE;

CREATE TABLE cor_railtel_payment (
  payment_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  invoice_no VARCHAR(200) NOT NULL,
  payment_Date DATE DEFAULT NULL,
  amount DECIMAL(10,2) NOT NULL,
  bankref VARCHAR(256) DEFAULT NULL,
  railtel_remarks VARCHAR(256) DEFAULT NULL,
  invoice_month VARCHAR(256) DEFAULT NULL,
  file_upload VARCHAR(250) DEFAULT NULL
);

COMMENT ON COLUMN cor_railtel_payment.payment_id IS 'Unique identifier for railtel payment records';


DROP TABLE IF EXISTS cor_revenueshare_monthwise CASCADE;

CREATE TABLE cor_revenueshare_monthwise (
  monthwise_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  subgroup SMALLINT DEFAULT NULL,
  type SMALLINT DEFAULT 1,
  wid VARCHAR(30) DEFAULT NULL,
  cause VARCHAR(30) DEFAULT NULL,
  pgid INTEGER NOT NULL,
  locid INTEGER DEFAULT NULL,
  packageid INTEGER DEFAULT NULL,
  subid BIGINT DEFAULT NULL,
  disbid INTEGER NOT NULL,
  mdisbid INTEGER DEFAULT NULL,
  disb_status SMALLINT DEFAULT NULL,
  disb_date TIMESTAMP DEFAULT NULL,
  ssdate TIMESTAMP DEFAULT NULL,
  sedate TIMESTAMP DEFAULT NULL,
  revenueshareid INTEGER DEFAULT 0,
  revenue DECIMAL(26,10) DEFAULT 0.0000000000,
  ibnpid BIGINT DEFAULT 0,
  ibnp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  ibnp_percent DECIMAL(5,2) DEFAULT NULL,
  anpid BIGINT DEFAULT 0,
  anp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  anp_percent DECIMAL(5,2) DEFAULT NULL,
  prsid BIGINT DEFAULT 0,
  prs_share DECIMAL(26,10) DEFAULT 0.0000000000,
  prs_percent DECIMAL(5,2) DEFAULT NULL,
  ibwpid BIGINT DEFAULT 0,
  ibwp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  ibwp_percent DECIMAL(5,2) DEFAULT NULL,
  cnpid BIGINT DEFAULT 0,
  cnp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  cnp_percent DECIMAL(5,2) DEFAULT NULL,
  mktid BIGINT DEFAULT 0,
  mkt_share DECIMAL(26,10) DEFAULT 0.0000000000,
  mkt_percent DECIMAL(5,2) DEFAULT NULL,
  permid BIGINT DEFAULT 0,
  perm_share DECIMAL(26,10) DEFAULT 0.0000000000,
  perm_percent DECIMAL(5,2) DEFAULT NULL,
  agpid BIGINT DEFAULT 0,
  agp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  agp_percent DECIMAL(5,2) DEFAULT NULL,
  mspid BIGINT DEFAULT 0,
  msp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  msp_percent DECIMAL(5,2) DEFAULT NULL,
  ispid BIGINT DEFAULT 0,
  isp_share DECIMAL(26,10) DEFAULT 0.0000000000,
  isp_percent DECIMAL(5,2) DEFAULT NULL,
  dot_percent DECIMAL(5,2) DEFAULT NULL,
  dot_share DECIMAL(12,4) DEFAULT 0.0000,
  statecode VARCHAR(10) DEFAULT '0',
  pst_code VARCHAR(10) DEFAULT '0',
  revenue_type VARCHAR(20) DEFAULT '0',
  monthpart VARCHAR(20) DEFAULT '0',
  online INTEGER DEFAULT 0,
  remarks VARCHAR(100) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN cor_revenueshare_monthwise.monthwise_id IS 'Unique identifier for revenue share monthwise records';
COMMENT ON COLUMN cor_revenueshare_monthwise.subgroup IS '1-enterprise,2-govt,3-darkfiber,4-specialevent,5-BPL';


DROP TABLE IF EXISTS cor_smonthlyinvoice CASCADE;

CREATE TABLE cor_smonthlyinvoice (
  id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  Partnerid BIGINT DEFAULT NULL,
  pgid INTEGER DEFAULT NULL,
  subid BIGINT DEFAULT NULL,
  monthpart VARCHAR(20) DEFAULT NULL,
  amount DECIMAL(10,2) DEFAULT NULL,
  cause VARCHAR(30) DEFAULT NULL,
  agpid BIGINT DEFAULT NULL,
  statecode VARCHAR(10) DEFAULT NULL,
  mspid VARCHAR(20) DEFAULT NULL,
  workorderid VARCHAR(45) DEFAULT NULL
);

COMMENT ON COLUMN cor_smonthlyinvoice.id IS 'Unique identifier for subscriber monthly invoice records';


DROP TABLE IF EXISTS cor_smonthlyinvoice_BKP CASCADE;

CREATE TABLE cor_smonthlyinvoice_BKP (
  id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  Partnerid BIGINT DEFAULT NULL,
  pgid INTEGER DEFAULT NULL,
  subid BIGINT DEFAULT NULL,
  monthpart VARCHAR(20) DEFAULT NULL,
  amount DECIMAL(10,2) DEFAULT NULL,
  cause VARCHAR(30) DEFAULT NULL,
  agpid BIGINT DEFAULT NULL,
  statecode VARCHAR(10) DEFAULT NULL,
  mspid VARCHAR(20) DEFAULT NULL,
  workorderid VARCHAR(45) DEFAULT NULL
);

COMMENT ON COLUMN cor_smonthlyinvoice_BKP.id IS 'Unique identifier for subscriber monthly invoice backup records';


DROP TABLE IF EXISTS cor_vrfattri_users CASCADE;

CREATE TABLE cor_vrfattri_users (
  users_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  subscriberid BIGINT DEFAULT NULL,
  username VARCHAR(256) DEFAULT NULL,
  partnerid BIGINT DEFAULT NULL,
  partnercompanyname VARCHAR(256) DEFAULT NULL,
  vrfattribute VARCHAR(100) DEFAULT NULL,
  vrfvalue VARCHAR(50) DEFAULT NULL,
  createdt TIMESTAMP DEFAULT NULL,
  updatedt TIMESTAMP DEFAULT NULL
);

COMMENT ON COLUMN cor_vrfattri_users.users_id IS 'Unique identifier for VRF attribute users records';
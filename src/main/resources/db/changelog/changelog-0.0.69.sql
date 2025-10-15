DROP TABLE IF EXISTS ctr CASCADE;

CREATE TABLE ctr (
  ctr_id UUID PRIMARY KEY NOT NULL,
  sname VARCHAR(200) DEFAULT NULL,
  sid BIGINT DEFAULT NULL,
  pid BIGINT DEFAULT NULL,
  pgid INTEGER DEFAULT NULL,
  amt DECIMAL(10,2) DEFAULT NULL,
  oldpid BIGINT DEFAULT NULL,
  vlantableid INTEGER DEFAULT NULL
);

COMMENT ON COLUMN ctr.ctr_id IS 'Unique identifier for CTR records';


DROP TABLE IF EXISTS curmonth_usage CASCADE;

CREATE TABLE curmonth_usage (
  curmonth_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  username VARCHAR(64) DEFAULT NULL,
  session VARCHAR(45) DEFAULT NULL,
  download VARCHAR(45) DEFAULT NULL,
  upload VARCHAR(45) DEFAULT NULL,
  logins INTEGER DEFAULT NULL,
  package VARCHAR(45) DEFAULT NULL,
  partner VARCHAR(64) DEFAULT NULL
);

COMMENT ON COLUMN curmonth_usage.curmonth_id IS 'Unique identifier for current month usage records';


DROP TABLE IF EXISTS daily_partner_report CASCADE;

CREATE TABLE daily_partner_report (
  id UUID PRIMARY KEY NOT NULL,
  report_id SERIAL,
  report_date DATE DEFAULT NULL,
  anp DECIMAL(10,2) DEFAULT NULL,
  packageid INTEGER DEFAULT NULL,
  speed_profile VARCHAR(45) DEFAULT NULL,
  active_sub INTEGER DEFAULT NULL
);

COMMENT ON COLUMN daily_partner_report.id IS 'Unique identifier for daily partner report records';


DROP TABLE IF EXISTS daily_status_report CASCADE;

CREATE TABLE daily_status_report (
  id UUID PRIMARY KEY NOT NULL,
  report_id SERIAL,
  report_date DATE DEFAULT NULL,
  subscriberid BIGINT DEFAULT NULL,
  username VARCHAR(64) DEFAULT NULL,
  anp BIGINT DEFAULT NULL,
  anpname VARCHAR(120) DEFAULT NULL,
  agp BIGINT DEFAULT NULL,
  agpname VARCHAR(120) DEFAULT NULL,
  package INTEGER DEFAULT NULL,
  packagename VARCHAR(120) DEFAULT NULL,
  speed_profile VARCHAR(45) DEFAULT NULL,
  status VARCHAR(64) DEFAULT NULL,
  is_new INTEGER DEFAULT NULL,
  district INTEGER DEFAULT NULL,
  districtname VARCHAR(64) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN daily_status_report.id IS 'Unique identifier for daily status report records';


DROP TABLE IF EXISTS dailyactive CASCADE;

CREATE TABLE dailyactive (
  id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  partnerid BIGINT NOT NULL,
  active INTEGER DEFAULT NULL,
  curdate TIMESTAMP NOT NULL,
  state VARCHAR(50) NOT NULL
);

COMMENT ON COLUMN dailyactive.id IS 'Unique identifier for daily active records';


DROP TABLE IF EXISTS dailyexpired CASCADE;

CREATE TABLE dailyexpired (
  expired_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  partnerid BIGINT NOT NULL,
  expired INTEGER DEFAULT NULL,
  curdate TIMESTAMP NOT NULL,
  state VARCHAR(50) NOT NULL
);

COMMENT ON COLUMN dailyexpired.expired_id IS 'Unique identifier for daily expired records';


DROP TABLE IF EXISTS dailynew CASCADE;

CREATE TABLE dailynew (
  dailynew_id UUID PRIMARY KEY NOT NULL,
  partnerid BIGINT NOT NULL,
  active INTEGER DEFAULT NULL,
  curdate TIMESTAMP NOT NULL,
  state VARCHAR(50) NOT NULL
);

COMMENT ON COLUMN dailynew.dailynew_id IS 'Unique identifier for daily new records';


DROP TABLE IF EXISTS dailyreport CASCADE;

CREATE TABLE dailyreport (
  report_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  reportdate DATE DEFAULT NULL,
  active INTEGER DEFAULT NULL,
  suspended INTEGER DEFAULT NULL,
  autorenewal INTEGER DEFAULT NULL,
  renewal INTEGER DEFAULT NULL,
  demousers INTEGER DEFAULT NULL,
  discountoffer INTEGER DEFAULT NULL,
  newlycreated INTEGER DEFAULT NULL,
  newlyactivated INTEGER DEFAULT NULL,
  partnerid VARCHAR(45) DEFAULT NULL,
  noofrevenueitems INTEGER DEFAULT NULL,
  totalrevenue DECIMAL(10,2) DEFAULT NULL,
  open_active INTEGER DEFAULT NULL,
  open_demousers INTEGER DEFAULT NULL,
  open_discountoffer INTEGER DEFAULT NULL,
  statecode VARCHAR(5) DEFAULT NULL
);

COMMENT ON COLUMN dailyreport.report_id IS 'Unique identifier for daily report records';


DROP TABLE IF EXISTS darkfiber_movement CASCADE;

CREATE TABLE darkfiber_movement (
  movement_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  enq_ref INTEGER DEFAULT NULL,
  approve_status INTEGER DEFAULT NULL,
  remarks VARCHAR(255) DEFAULT NULL,
  created_by VARCHAR(128) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_active INTEGER DEFAULT 1
);

COMMENT ON COLUMN darkfiber_movement.movement_id IS 'Unique identifier for dark fiber movement records';
COMMENT ON COLUMN darkfiber_movement.is_active IS '0=In Active,1=Active';





DROP TABLE IF EXISTS agencydetail CASCADE;

CREATE TABLE agencydetail (
  detail_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  agency varchar(20) DEFAULT NULL,
  statecode varchar(5) DEFAULT NULL
);

COMMENT ON COLUMN agencydetail.detail_id IS 'Unique identifier for agency detail records';


DROP TABLE IF EXISTS agnpbank CASCADE;

CREATE TABLE agnpbank (
  bank_id UUID PRIMARY KEY NOT NULL,
  sl_no int DEFAULT NULL,
  agnpid bigint DEFAULT NULL,
  acholder varchar(53) DEFAULT NULL,
  actype varchar(3) DEFAULT NULL,
  bank varchar(100) DEFAULT NULL,
  branch varchar(27) DEFAULT NULL,
  acno varchar(19) DEFAULT NULL,
  IFSC varchar(13) DEFAULT NULL
);

COMMENT ON COLUMN agnpbank.bank_id IS 'Unique identifier for AGNP bank records';


DROP TABLE IF EXISTS anp_crm_penanlty CASCADE;

CREATE TABLE anp_crm_penanlty (
  penanlty_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  subscriberid int NOT NULL,
  partnerid bigint DEFAULT NULL,
  monthpart varchar(100) DEFAULT NULL,
  workorderid varchar(100) DEFAULT NULL,
  start_date timestamp DEFAULT NULL,
  end_date timestamp DEFAULT NULL,
  flag smallint DEFAULT 0,
  tarif decimal(10,2) DEFAULT NULL,
  ticketid varchar(50) DEFAULT NULL,
  expirydate date DEFAULT NULL,
  downtime varchar(50) DEFAULT NULL,
  t_app_date timestamp DEFAULT NULL
);

COMMENT ON COLUMN anp_crm_penanlty.penanlty_id IS 'Unique identifier for ANP CRM penalty records';


DROP TABLE IF EXISTS anp_feedback CASCADE;

CREATE TABLE anp_feedback (
  feedback_id UUID PRIMARY KEY NOT NULL,
  slno SERIAL,
  time_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  partnerid varchar(30) DEFAULT NULL,
  cus_care_satis char(1) DEFAULT NULL,
  network_service_satis char(1) DEFAULT NULL,
  satisfy char(1) DEFAULT NULL,
  feedbackdesc int DEFAULT NULL,
  feedback varchar(255) DEFAULT NULL,
  createdby varchar(100) DEFAULT NULL,
  feedbackdate timestamp DEFAULT NULL
);

COMMENT ON COLUMN anp_feedback.feedback_id IS 'Unique identifier for ANP feedback records';

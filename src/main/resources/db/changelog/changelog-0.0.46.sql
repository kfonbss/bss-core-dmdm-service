
DROP TABLE IF EXISTS ce_subscribers CASCADE;

CREATE TABLE ce_subscribers (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  subscriberid SERIAL,
  username varchar(64) DEFAULT NULL,
  password varchar(50) DEFAULT NULL,
  woid int DEFAULT NULL,
  customerid int DEFAULT NULL,
  group_type varchar(10) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_subscribers PRIMARY KEY (id)
);
INSERT INTO ce_subscribers (
    id, code, name, name_in_local, is_active, subscriberid, username, password, woid,
    customerid, group_type, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'SUB001', 'Alice Subscriber', 'അലീസ് സബ്‌സ്‌ക്രൈബർ', true, 1, 'alice123', 'pass@123', 5001,
    2001, 'CORP', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_subscribers_document CASCADE;

CREATE TABLE ce_subscribers_document (
  document_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  locid int DEFAULT NULL,
  sub_document varchar(50) DEFAULT NULL,
  doc_type boolean DEFAULT false,
  remarks varchar(150) DEFAULT NULL,
  data_collected_date date DEFAULT NULL,
  hyi_flag int DEFAULT 0,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_subscribers_document PRIMARY KEY (document_id)
);

INSERT INTO ce_subscribers_document (
    document_id, code, name, name_in_local, is_active, id, locid, sub_document,
    doc_type, remarks, data_collected_date, hyi_flag, created_date, modified_date,
    created_by, modified_by
) VALUES (
    gen_random_uuid(), 'DOC001', 'Subscriber Document', 'സബ്സ്ക്രൈബർ ഡോക്യുമെന്റ്', true, 1, 1001, 'id_proof.pdf',
    true, 'Verified successfully', CURRENT_DATE, 1, CURRENT_TIMESTAMP, NULL,
    gen_random_uuid(), gen_random_uuid()
);

DROP TABLE IF EXISTS ce_subshifdetails CASCADE;

CREATE TABLE ce_subshifdetails (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  serviceprovider int DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  frompartnerid bigint DEFAULT NULL,
  topartnerid bigint DEFAULT NULL,
  slaid varchar(20) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_subshifdetails PRIMARY KEY (details_id)
);
INSERT INTO ce_subshifdetails (
    details_id, code, name, name_in_local, is_active, id, serviceprovider,
    subscriberid, frompartnerid, topartnerid, slaid, created_date, modified_date,
    created_by, modified_by
) VALUES (
    gen_random_uuid(), 'SHIFT001', 'Subscriber Shift Details', 'സബ്‌സ്‌ക്രൈബർ ഷിഫ്റ്റ് വിശദാംശങ്ങൾ', true, 1, 101,
    5001, 3001, 3002, 'SLA123', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);


DROP TABLE IF EXISTS ce_supportsub_document CASCADE;

CREATE TABLE ce_supportsub_document (
  document_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  locid int DEFAULT NULL,
  caf_doc varchar(50) DEFAULT NULL,
  caf_date date DEFAULT NULL,
  agr_doc varchar(50) DEFAULT NULL,
  agr_date date DEFAULT NULL,
  icr_doc varchar(50) DEFAULT NULL,
  icr_date date DEFAULT NULL,
  preins_doc varchar(50) DEFAULT NULL,
  preins_date date DEFAULT NULL,
  postins_doc varchar(50) DEFAULT NULL,
  postins_date date DEFAULT NULL,
  network_doc varchar(50) DEFAULT NULL,
  network_date date DEFAULT NULL,
  kyc_doc varchar(50) DEFAULT NULL,
  kyc_date date DEFAULT NULL,
  hyi_doc varchar(50) DEFAULT NULL,
  hyi_date date DEFAULT NULL,
  oth_doc varchar(50) DEFAULT NULL,
  oth_date date DEFAULT NULL,
  hyi_flag int DEFAULT 0,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_supportsub_document PRIMARY KEY (document_id)
);

INSERT INTO ce_supportsub_document (
    document_id, code, name, name_in_local, is_active, id, locid,
    caf_doc, caf_date, agr_doc, agr_date, icr_doc, icr_date,
    preins_doc, preins_date, postins_doc, postins_date, network_doc, network_date,
    kyc_doc, kyc_date, hyi_doc, hyi_date, oth_doc, oth_date, hyi_flag,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'DOC001', 'Subscriber Support Document', 'സബ്‌സ്‌ക്രൈബർ സഹായ രേഖ', true, 1, 101,
    'CAF123.pdf', CURRENT_DATE - INTERVAL '30 days', 'AGR456.pdf', CURRENT_DATE - INTERVAL '28 days', 'ICR789.pdf', CURRENT_DATE - INTERVAL '25 days',
    'PREINS001.pdf', CURRENT_DATE - INTERVAL '20 days', 'POSTINS001.pdf', CURRENT_DATE - INTERVAL '15 days', 'NETWORK001.pdf', CURRENT_DATE - INTERVAL '10 days',
    'KYC001.pdf', CURRENT_DATE - INTERVAL '5 days', 'HYI001.pdf', CURRENT_DATE - INTERVAL '3 days', 'OTH001.pdf', CURRENT_DATE - INTERVAL '1 days', 1,
    CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);

DROP TABLE IF EXISTS ce_workorder CASCADE;

CREATE TABLE ce_workorder (
  workorder_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  slno SERIAL,
  po_id int DEFAULT NULL,
  wo_no varchar(25) DEFAULT NULL,
  short_name varchar(25) DEFAULT NULL,
  wo_start_date date DEFAULT NULL,
  wo_end_date date DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_ce_workorder PRIMARY KEY (workorder_id)
);

INSERT INTO ce_workorder (
    workorder_id, code, name, name_in_local, is_active, slno, po_id, wo_no, short_name, wo_start_date,
    wo_end_date, created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(), 'WO001', 'Fiber Laying Work Order', 'ഫൈബർ സ്ഥാപിക്കൽ വർക്ക് ഓർഡർ', true, 1, 1001, 'WO-2025-001', 'FiberWO',
    CURRENT_DATE - INTERVAL '10 days', CURRENT_DATE + INTERVAL '20 days', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), gen_random_uuid()
);

DROP TABLE IF EXISTS check_xmls CASCADE;

CREATE TABLE check_xmls (
  xmls_id UUID DEFAULT gen_random_uuid() NOT NULL,
  post text DEFAULT NULL,
  files text DEFAULT NULL,
  CONSTRAINT pk_check_xmls PRIMARY KEY (xmls_id)
);

COMMENT ON COLUMN check_xmls.xmls_id IS 'Unique identifier for check XMLs records';


DROP TABLE IF EXISTS ci_sessions CASCADE;

CREATE TABLE ci_sessions (
  sessions_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id varchar(40) NOT NULL,
  username varchar(100) DEFAULT NULL,
  ip_address varchar(45) NOT NULL,
  timestamp int NOT NULL DEFAULT 0,
  data bytea NOT NULL,
  CONSTRAINT pk_ci_sessions PRIMARY KEY (sessions_id)
);

CREATE INDEX ci_sessions_timestamp ON ci_sessions (timestamp);
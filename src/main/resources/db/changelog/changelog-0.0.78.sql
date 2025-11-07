-- Table : incentive_breakup
DROP TABLE IF EXISTS incentive_breakup CASCADE;

CREATE TABLE incentive_breakup (
  incentive_breakup_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  slab int DEFAULT NULL,
  subscribercount int DEFAULT NULL,
  percentage int DEFAULT NULL,
  lnpid int DEFAULT NULL,
  revenue decimal(10,2) DEFAULT NULL,
  agr decimal(10,2) DEFAULT NULL,
  incentive decimal(10,2) DEFAULT NULL,
  monthpart varchar(20) DEFAULT NULL,
  update_date timestamp DEFAULT CURRENT_TIMESTAMP,
  -- Primary key constraint
CONSTRAINT pk_incentive_breakup PRIMARY KEY (incentive_breakup_id)
);


-- Table : incentive_slab
DROP TABLE IF EXISTS incentive_slab CASCADE;

CREATE TABLE incentive_slab (
  incentive_slab_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  name varchar(30) DEFAULT NULL,
  category varchar(50) DEFAULT NULL,
  slab varchar(20) DEFAULT NULL,
  description varchar(30) DEFAULT NULL,
  activesubbase varchar(30) DEFAULT NULL,
  bonus decimal(10,2) DEFAULT NULL,
  incentive_type INT DEFAULT NULL,
  speed int DEFAULT NULL,
  min int DEFAULT NULL,
  max int DEFAULT NULL,
  percentage int DEFAULT 0,
  created_date timestamp DEFAULT CURRENT_TIMESTAMP,
  updated_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- Primary key constraint
CONSTRAINT pk_incentive_slab PRIMARY KEY (incentive_slab_id)
);


-- Table : incident_mimo
DROP TABLE IF EXISTS incident_mimo CASCADE;

CREATE TABLE incident_mimo (
  incident_mimo_id UUID DEFAULT gen_random_uuid() NOT NULL,
  ticketno SERIAL,
  ticketid varchar(50) DEFAULT NULL,
  startdate timestamp DEFAULT NULL,
  assignetomimo timestamp DEFAULT NULL,
  statusitmsp varchar(50) DEFAULT NULL,
  owner varchar(50) DEFAULT NULL,
  createdby varchar(100) DEFAULT NULL,
  description text DEFAULT NULL,
  issuetype varchar(30) DEFAULT NULL,
  itmspclosedate timestamp DEFAULT NULL,
  statecode varchar(45) DEFAULT NULL,
  etr varchar(50) DEFAULT NULL,
  statusmimo varchar(50) DEFAULT NULL,
  urgency varchar(50) DEFAULT NULL,
  impact varchar(50) DEFAULT NULL,
  severity varchar(5) DEFAULT NULL,
  responds_time timestamp DEFAULT NULL,
  mimo_closedtime timestamp DEFAULT NULL,
  mimoassigned varchar(50) DEFAULT NULL,
  sup_status varchar(25) DEFAULT NULL,
  sup_closetime timestamp DEFAULT NULL,
  assigned_datemimo date DEFAULT NULL,
  username varchar(30) NOT NULL,
  mobileno varchar(15) NOT NULL,
  orderno varchar(30) NOT NULL,
  txntdate timestamp NOT NULL,
  amount varchar(25) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_incident_mimo PRIMARY KEY (incident_mimo_id)
);

-- Create indexes for better performance
CREATE INDEX idx_incident_mimo_incdnt_ordrno ON incident_mimo (orderno);
CREATE INDEX idx_incident_mimo_incdntmmo_tcktid ON incident_mimo (ticketid);

-- Table : incidenttracker
DROP TABLE IF EXISTS incidenttracker CASCADE;

CREATE TABLE incidenttracker (
  incidenttracker_id UUID DEFAULT gen_random_uuid() NOT NULL,
  ticketno SERIAL,
  time_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  nodeid int DEFAULT NULL,
  startdate timestamp DEFAULT NULL,
  modifiedon date DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  assignedto varchar(100) DEFAULT NULL,
  createdby varchar(100) DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  resolution varchar(255) DEFAULT NULL,
  owner varchar(20) DEFAULT NULL,
  expclosedate timestamp DEFAULT NULL,
  modifiedby varchar(100) DEFAULT NULL,
  actualclosedate timestamp DEFAULT NULL,
  priority varchar(20) DEFAULT NULL,
  ticketid varchar(50) DEFAULT NULL,
  statecode varchar(45) DEFAULT NULL,
  source varchar(20) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_incidenttracker PRIMARY KEY (incidenttracker_id)
);


-- Table : inv_credit_notes
DROP TABLE IF EXISTS inv_credit_notes CASCADE;

CREATE TABLE inv_credit_notes (
  notes_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  dtid int DEFAULT NULL,
  dmid int DEFAULT NULL,
  dcid int DEFAULT NULL,
  dmoid int DEFAULT NULL,
  device_count decimal(10,2) DEFAULT 0.00,
  file_name varchar(70) DEFAULT NULL,
  created_by_name varchar(70) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_credit_notes PRIMARY KEY (notes_id)
);
INSERT INTO inv_credit_notes (
  notes_id, code, name, name_in_local, is_active, id, dtid, dmid, dcid, dmoid, device_count,
  file_name, created_by_name, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'CN001', 'Credit Note - Device', 'ക്രെഡിറ്റ് നോട്ട് - ഉപകരണം', true, 1, 101, 202, 303, 404, 5.00,
  'credit_device_list.pdf', 'Admin User', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);


-- Table : inv_dc_credit_notes
DROP TABLE IF EXISTS inv_dc_credit_notes CASCADE;

CREATE TABLE inv_dc_credit_notes (
  notes_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  device_count int DEFAULT 0,
  remarks varchar(70) DEFAULT NULL,
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_dc_credit_notes PRIMARY KEY (notes_id)
);
INSERT INTO inv_dc_credit_notes (
  notes_id, code, name, name_in_local, is_active, id, device_count, remarks,
  created_by_id, created_by_name, created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'DCCN001', 'DC Credit Note', 'ഡി.സി ക്രെഡിറ്റ് നോട്ട്', true, 1, 10, 'Return of defective devices',
  101, 'Admin User', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);


-- Table : inv_dccredit_notes
DROP TABLE IF EXISTS inv_dccredit_notes CASCADE;

CREATE TABLE inv_dccredit_notes (
  notes_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  device_count int DEFAULT 0,
  transfer_to INT DEFAULT 0,
  -- '1=Transfered TO KFON-DC,2=Transfered TO  MSP-DC,3=Transfered LNP',
  kfon_dcid int DEFAULT NULL,
  msp_dcid int DEFAULT NULL,
  lnpid bigint DEFAULT NULL,
  reqid int DEFAULT NULL,
  dc_reqid int DEFAULT NULL,
  created_by_id int DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_dccredit_notes PRIMARY KEY (notes_id)
);

INSERT INTO inv_dccredit_notes (
  notes_id, code, name, name_in_local, is_active, id, device_count, transfer_to,
  kfon_dcid, msp_dcid, lnpid, reqid, dc_reqid, created_by_id, created_by_name,
  created_date, modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'DCN001', 'Device Credit Note', 'ഉപകരണ ക്രെഡിറ്റ് നോട്ട്സ്', TRUE, 1, 25, 2,
  101, 202, 9876543210, 303, 404, 1001, 'System Admin',
  CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);

-- Table : inv_device_acknowledgement
DROP TABLE IF EXISTS inv_device_acknowledgement CASCADE;

CREATE TABLE inv_device_acknowledgement (
  ack_id UUID DEFAULT gen_random_uuid() NOT NULL,
  code VARCHAR(45),
  name VARCHAR(255),
  name_in_local VARCHAR(255),
  is_active boolean,
  id SERIAL,
  deviceid int DEFAULT NULL,
  lnp_reqid int DEFAULT NULL,
  device_status int DEFAULT 1,
  lnpid bigint DEFAULT NULL,
  reqid int DEFAULT NULL,
  dc_reqid int DEFAULT NULL,
  noc_id int DEFAULT NULL,
  kfondc_id int DEFAULT NULL,
  mspdc_id int DEFAULT NULL,
  created_by_id bigint DEFAULT NULL,
  created_by_name varchar(150) DEFAULT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
CONSTRAINT pk_inv_device_acknowledgement PRIMARY KEY (ack_id)
);
INSERT INTO inv_device_acknowledgement (
  ack_id, code, name, name_in_local, is_active, id, deviceid, lnp_reqid, device_status, lnpid,
  reqid, dc_reqid, noc_id, kfondc_id, mspdc_id, created_by_id, created_by_name, created_date,
  modified_date, created_by, modified_by
) VALUES (
  gen_random_uuid(), 'ACK001', 'Device Acknowledgement', 'ഡിവൈസ് അക്നലഡ്ജ്മെന്റ്', true, 1, 101, 5001, 1, 9876543210,
  7001, 3001, 9001, 8001, 7002, 1001, 'System Admin', CURRENT_TIMESTAMP, NULL, gen_random_uuid(), NULL
);

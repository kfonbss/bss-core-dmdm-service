-- Table : framed_pool_list
DROP TABLE IF EXISTS framed_pool_list CASCADE;

CREATE TABLE framed_pool_list (
  framed_pool_list_id UUID NOT NULL,
  id SERIAL,
  framed_pool varchar(200) DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active int DEFAULT 1,
  -- '0=In Active,1=Active',
  -- Primary key constraint
CONSTRAINT pk_framed_pool_list PRIMARY KEY (framed_pool_list_id)
);


-- Table : framedipusers
DROP TABLE IF EXISTS framedipusers CASCADE;

CREATE TABLE framedipusers (
  framedipusers_id UUID NOT NULL,
  slno SERIAL,
  framedip varchar(18) DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  lastupdate timestamp DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_framedipusers PRIMARY KEY (framedipusers_id)
);


-- Table : func
DROP TABLE IF EXISTS func CASCADE;

CREATE TABLE func (
  func_id UUID NOT NULL,
  name char(64) NOT NULL DEFAULT '',
  ret INT NOT NULL DEFAULT 0,
  dl char(128) NOT NULL DEFAULT '',
  type varchar(50) NOT NULL,
  -- above enum field values: function, aggregate
  -- Primary key constraint
CONSTRAINT pk_func PRIMARY KEY (func_id)
);


-- Table : govsubscribers
DROP TABLE IF EXISTS govsubscribers CASCADE;

CREATE TABLE govsubscribers (
  govsubscribers_id UUID NOT NULL,
  gsubid SERIAL,
  fullname varchar(128) NOT NULL,
  workoderid int NOT NULL,
  partnergroupid int NOT NULL,
  registrationdate timestamp DEFAULT NULL,
  subscriberprofileid int NOT NULL DEFAULT 3,
  email varchar(128) DEFAULT NULL,
  address varchar(256) DEFAULT NULL,
  connection_date timestamp DEFAULT NULL,
  contactno varchar(45) DEFAULT NULL,
  username varchar(64) NOT NULL,
  packageid int NOT NULL,
  isactive int NOT NULL DEFAULT 1,
  status int NOT NULL DEFAULT 0,
  nextrenewdate date DEFAULT NULL,
  balance decimal(10,2) NOT NULL DEFAULT 0.00,
  -- Primary key constraint
CONSTRAINT pk_govsubscribers PRIMARY KEY (govsubscribers_id)
);


-- Table : gri_status_type
DROP TABLE IF EXISTS gri_status_type CASCADE;

CREATE TABLE gri_status_type (
  gri_status_type_id UUID NOT NULL,
  gri_status_id SERIAL,
  Description varchar(100) DEFAULT NULL,
  "user" int DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_gri_status_type PRIMARY KEY (gri_status_type_id)
);

-- Create indexes for better performance
CREATE INDEX idx_gri_status_type_Description ON gri_status_type (Description);

-- Table : gri_ticket_movement
DROP TABLE IF EXISTS gri_ticket_movement CASCADE;

CREATE TABLE gri_ticket_movement (
  gri_ticket_movement_id UUID NOT NULL,
  noteid SERIAL,
  ticketid bigint DEFAULT NULL,
  note text DEFAULT NULL,
  created_by varchar(64) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  helpdesk varchar(64) DEFAULT NULL,
  assignedto varchar(45) DEFAULT NULL,
  assignedto_type char(5) DEFAULT NULL,
  attachment varchar(256) DEFAULT NULL,
  oldticketid varchar(20) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_gri_ticket_movement PRIMARY KEY (gri_ticket_movement_id)
);

-- Create indexes for better performance
CREATE INDEX idx_gri_ticket_movement_fk_ticketid1 ON gri_ticket_movement (ticketid);
CREATE INDEX idx_gri_ticket_movement_created_by ON gri_ticket_movement (created_by);
CREATE INDEX idx_gri_ticket_movement_ticketid ON gri_ticket_movement (ticketid);
CREATE INDEX idx_gri_ticket_movement_assignedto ON gri_ticket_movement (assignedto);

-- Table : gri_ticket_movement1
DROP TABLE IF EXISTS gri_ticket_movement1 CASCADE;

CREATE TABLE gri_ticket_movement1 (
  gri_ticket_movement1_id UUID NOT NULL,
  noteid SERIAL,
  ticketid bigint DEFAULT NULL,
  note text DEFAULT NULL,
  created_by varchar(64) DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  helpdesk varchar(64) DEFAULT NULL,
  assignedto varchar(45) DEFAULT NULL,
  assignedto_type char(5) DEFAULT NULL,
  attachment varchar(256) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_gri_ticket_movement1 PRIMARY KEY (gri_ticket_movement1_id)
);

-- Create indexes for better performance
CREATE INDEX idx_gri_ticket_movement1_fk_ticketid1 ON gri_ticket_movement1 (ticketid);
CREATE INDEX idx_gri_ticket_movement1_created_by ON gri_ticket_movement1 (created_by);
CREATE INDEX idx_gri_ticket_movement1_ticketid ON gri_ticket_movement1 (ticketid);
CREATE INDEX idx_gri_ticket_movement1_assignedto ON gri_ticket_movement1 (assignedto);

-- Table : gri_tickets
DROP TABLE IF EXISTS gri_tickets CASCADE;

CREATE TABLE gri_tickets (
  gri_tickets_id UUID NOT NULL,
  ticketid SERIAL,
  incident_dt timestamp DEFAULT NULL,
  submit_date timestamp DEFAULT NULL,
  due_date timestamp DEFAULT NULL,
  servicetype varchar(50) DEFAULT NULL,
  ticket_type varchar(50) DEFAULT NULL,
  complaint_type varchar(30) DEFAULT NULL,
  helpdesk varchar(10) DEFAULT NULL,
  source int DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  username varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  created_by varchar(45) DEFAULT NULL,
  assignedto varchar(45) DEFAULT NULL,
  assignedto_type char(5) DEFAULT NULL,
  subject text DEFAULT NULL,
  description text DEFAULT NULL,
  priority varchar(45) DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  region varchar(50) DEFAULT NULL,
  updated_dt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  mobile varchar(10) DEFAULT NULL,
  email varchar(128) DEFAULT NULL,
  oldticketid varchar(20) DEFAULT NULL,
  dmkg int DEFAULT NULL,
  subscriberid varchar(256) DEFAULT NULL,
  subscriberidd bigint DEFAULT NULL,
  pincode char(7) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_gri_tickets PRIMARY KEY (gri_tickets_id)
);

-- Create indexes for better performance
CREATE INDEX idx_gri_tickets_submit_date ON gri_tickets (submit_date);
CREATE INDEX idx_gri_tickets_ticket_type ON gri_tickets (ticket_type);
CREATE INDEX idx_gri_tickets_complaint_type ON gri_tickets (complaint_type);
CREATE INDEX idx_gri_tickets_created_by ON gri_tickets (created_by);
CREATE INDEX idx_gri_tickets_assignedto ON gri_tickets (assignedto);
CREATE INDEX idx_gri_tickets_circle ON gri_tickets (circle);
CREATE INDEX idx_gri_tickets_region ON gri_tickets (region);
CREATE INDEX idx_gri_tickets_updated_dt ON gri_tickets (updated_dt);
CREATE INDEX idx_gri_tickets_status ON gri_tickets (status);

-- Table : gri_tickets1
DROP TABLE IF EXISTS gri_tickets1 CASCADE;

CREATE TABLE gri_tickets1 (
  gri_tickets1_id UUID NOT NULL,
  ticketid SERIAL,
  incident_dt timestamp DEFAULT NULL,
  submit_date timestamp DEFAULT NULL,
  due_date timestamp DEFAULT NULL,
  servicetype varchar(50) DEFAULT NULL,
  ticket_type varchar(50) DEFAULT NULL,
  complaint_type varchar(30) DEFAULT NULL,
  helpdesk varchar(10) DEFAULT NULL,
  source int DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  username varchar(256) DEFAULT NULL,
  address text DEFAULT NULL,
  created_by varchar(45) DEFAULT NULL,
  assignedto varchar(45) DEFAULT NULL,
  assignedto_type char(5) DEFAULT NULL,
  subject text DEFAULT NULL,
  description text DEFAULT NULL,
  priority varchar(45) DEFAULT NULL,
  circle varchar(10) DEFAULT NULL,
  region varchar(50) DEFAULT NULL,
  updated_dt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  mobile varchar(10) DEFAULT NULL,
  email varchar(128) DEFAULT NULL,
  -- Primary key constraint
CONSTRAINT pk_gri_tickets1 PRIMARY KEY (gri_tickets1_id)
);
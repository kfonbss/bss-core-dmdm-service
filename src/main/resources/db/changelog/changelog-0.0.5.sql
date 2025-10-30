-- Drop table if exists
DROP TABLE IF EXISTS track_email_mobile;
CREATE TABLE track_email_mobile (
    track_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    subid VARCHAR(20),
    old_changes VARCHAR(50),
    change_type VARCHAR(20),
    changed_updated_by VARCHAR(30),
    updated_date VARCHAR(30)
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS trai_closedtickets;
CREATE TABLE trai_closedtickets (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    April NUMERIC(23,0),
    may NUMERIC(23,0),
    June NUMERIC(23,0)
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS trai_opentickets;
CREATE TABLE trai_opentickets (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    April NUMERIC(23,0),
    may NUMERIC(23,0),
    June NUMERIC(23,0)
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS trai_tickets;
CREATE TABLE trai_tickets (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    closed NUMERIC(23,0),
    total BIGINT NOT NULL DEFAULT 0
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS traiupdatedetail;
CREATE TABLE traiupdatedetail (
    update_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    packagenum VARCHAR(64),
    packageid BIGINT,
    state_code VARCHAR(20),
    createddate TIMESTAMP,
    lastupdatedate TIMESTAMP
);
-- Drop table if exists
DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    ticketid BIGSERIAL,
    submit_date TIMESTAMP,
    due_date TIMESTAMP,
    ticket_type INT,
    status VARCHAR(45),
    created_by VARCHAR(64),
    assignedto VARCHAR(45),
    assigned_toname VARCHAR(100),
    assignedto_type CHAR(50),
    subject TEXT,
    subscriberid VARCHAR(45),
    partnerid VARCHAR(45),
    helpdesk VARCHAR(64),
    source INT,
    priority VARCHAR(45),
    associate_ticketid BIGINT,
    subscriber VARCHAR(256),
    partnername VARCHAR(256),
    circle VARCHAR(10),
    district CHAR(20),
    region VARCHAR(20) DEFAULT 'south',
    action_date TIMESTAMP,
    closed_by VARCHAR(64),
    sub_type INT DEFAULT 1,
    cor_old_ticket VARCHAR(50),
    workorderid VARCHAR(100),
    loc_code VARCHAR(100),
    issueat VARCHAR(10),
    circuit_details VARCHAR(50),
    complaintthrough VARCHAR(50),
    complaintnum VARCHAR(50),
    reopen_date TIMESTAMP,
    calltype VARCHAR(50),
    eo_id VARCHAR(200),
    eo_ticketid VARCHAR(20),
    eoname VARCHAR(128),
    popname VARCHAR(128),
    ticket_cat INT,
    ticket_sub_cat INT,
    customer_id INT,
    reassignedto VARCHAR(45),
    reassigned_subject TEXT,
    department_id VARCHAR(20),
    df_group_id VARCHAR(100),
    df_group_name VARCHAR(150),
    df_link_name VARCHAR(150),
    df_link_id VARCHAR(100)
);

CREATE INDEX idx_tickets_submit_date ON tickets(submit_date);
CREATE INDEX idx_tickets_ticket_type ON tickets(ticket_type);
CREATE INDEX idx_tickets_created_by ON tickets(created_by);
CREATE INDEX idx_tickets_assignedto ON tickets(assignedto);
CREATE INDEX idx_tickets_circle ON tickets(circle);
CREATE INDEX idx_tickets_region ON tickets(region);
CREATE INDEX idx_tickets_action_date ON tickets(action_date);
CREATE INDEX idx_tickets_status ON tickets(status);

-- -------------------------------------------------------

DROP TABLE IF EXISTS tickets_backup;
CREATE TABLE tickets_backup AS TABLE tickets WITH NO DATA;

-- -------------------------------------------------------

DROP TABLE IF EXISTS top_menus;
CREATE TABLE top_menus (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    menuid SERIAL,
    parent_menuid INT DEFAULT 0 NOT NULL,
    icon VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    title VARCHAR(100) NOT NULL,
    link VARCHAR(100) NOT NULL,
    weight INT NOT NULL,
    link_target VARCHAR(50) NOT NULL,
    link_type VARCHAR(50) NOT NULL,
    status INT DEFAULT 1 NOT NULL,
    more_permissions VARCHAR(255),
    visibility INT DEFAULT 1 NOT NULL,
    description TEXT,
    created_date TIMESTAMP NOT NULL,
    created_by VARCHAR(100) NOT NULL,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_by VARCHAR(100) NOT NULL
);

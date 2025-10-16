-- Drop tables if they exist
DROP TABLE IF EXISTS ptnrgstinupdates CASCADE;
DROP TABLE IF EXISTS radacct_logs CASCADE;
DROP TABLE IF EXISTS radacct_logs2 CASCADE;
DROP TABLE IF EXISTS rail_territory_name CASCADE;
DROP TABLE IF EXISTS railregionaloffice CASCADE;
DROP TABLE IF EXISTS railtel_payment CASCADE;
DROP TABLE IF EXISTS reachus_table CASCADE;
DROP TABLE IF EXISTS realms CASCADE;
DROP TABLE IF EXISTS recieptstatus CASCADE;
DROP TABLE IF EXISTS reciepttype CASCADE;

-- Table: ptnrgstinupdates
CREATE TABLE ptnrgstinupdates (
    update_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    partnerid BIGINT,
    gstin VARCHAR(15) NOT NULL,
    updatedon VARCHAR(30) NOT NULL,
    updatedby VARCHAR(30)
);

-- Table: radacct_logs
CREATE TABLE radacct_logs (
    logs_id UUID NOT NULL PRIMARY KEY,
    acctsessionid VARCHAR(64),
    acctuniqueid VARCHAR(32),
    username VARCHAR(64),
    nasipaddress VARCHAR(15),
    nasportid VARCHAR(15),
    acctstarttime TIMESTAMP,
    acctstoptime TIMESTAMP,
    acctinputoctets BIGINT,
    acctoutputoctets BIGINT,
    calledstationid VARCHAR(50),
    callingstationid VARCHAR(50),
    framedipaddress VARCHAR(15),
    delegatedipv6prefix VARCHAR(45) DEFAULT '' NOT NULL,
    framedipv6prefix VARCHAR(45) DEFAULT '' NOT NULL
);

-- Table: radacct_logs2
CREATE TABLE radacct_logs2 (
    logs_id UUID NOT NULL PRIMARY KEY,
    acctsessionid VARCHAR(64),
    acctuniqueid VARCHAR(32),
    username VARCHAR(64),
    nasipaddress VARCHAR(15),
    nasportid VARCHAR(15),
    acctstarttime TIMESTAMP,
    acctstoptime TIMESTAMP,
    acctinputoctets BIGINT,
    acctoutputoctets BIGINT,
    calledstationid VARCHAR(50),
    callingstationid VARCHAR(50),
    framedipaddress VARCHAR(15),
    delegatedipv6prefix VARCHAR(45) DEFAULT '' NOT NULL,
    framedipv6prefix VARCHAR(45) DEFAULT '' NOT NULL
);

-- Table: rail_territory_name
CREATE TABLE rail_territory_name (
    rail_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    territory_name VARCHAR(100),
    stcode INT,
    status INT,
    c_code VARCHAR(45) NOT NULL
);

-- Table: railregionaloffice
CREATE TABLE railregionaloffice (
    id UUID NOT NULL PRIMARY KEY,
    idrailregionaloffice INT ,
    "to" VARCHAR(100),
    addressline1 VARCHAR(200),
    addressline2 VARCHAR(200),
    addressline3 VARCHAR(200),
    addressline4 VARCHAR(200)
);

-- Table: railtel_payment
CREATE TABLE railtel_payment (
    payment_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    billtype INT DEFAULT 1,
    invoice_no VARCHAR(200) NOT NULL,
    payment_date DATE,
    amount DOUBLE PRECISION NOT NULL,
    bankref VARCHAR(256),
    railtel_remarks VARCHAR(256),
    invoice_month VARCHAR(256),
    file_upload VARCHAR(250),
    partnerfinanceid BIGINT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1
);

-- Table: reachus_table
CREATE TABLE reachus_table (
    id UUID NOT NULL PRIMARY KEY,
    supp_id SERIAL ,
    tec_phone VARCHAR(100) NOT NULL,
    tec_email VARCHAR(100) NOT NULL,
    bill_phone VARCHAR(100) NOT NULL,
    bill_email VARCHAR(100) NOT NULL,
    sale_phone VARCHAR(100) NOT NULL,
    sale_email VARCHAR(100) NOT NULL,
    fk_state VARCHAR(100) NOT NULL,
    esc_matrix VARCHAR(200)
);

-- Table: realms
CREATE TABLE realms (
    realms_id UUID NOT NULL PRIMARY KEY,
    id BIGSERIAL ,
    realmname VARCHAR(128),
    type VARCHAR(32),
    authhost VARCHAR(256),
    accthost VARCHAR(256),
    secret VARCHAR(128),
    ldflag VARCHAR(64),
    nostrip INT,
    hints INT,
    notrealm INT,
    creationdate TIMESTAMP,
    creationby VARCHAR(128),
    updatedate TIMESTAMP,
    updateby VARCHAR(128)
);

-- Table: recieptstatus
CREATE TABLE recieptstatus (
    status_id UUID NOT NULL PRIMARY KEY,
    recieptstatusid SERIAL ,
    recieptstatus VARCHAR(45) NOT NULL UNIQUE,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: reciepttype
CREATE TABLE reciepttype (
    type_id UUID NOT NULL PRIMARY KEY,
    reciepttypeid SERIAL ,
    reciepttype VARCHAR(45) NOT NULL UNIQUE,
    defaultstatus VARCHAR(45) NOT NULL,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

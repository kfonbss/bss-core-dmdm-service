-- Drop tables if they exist
DROP TABLE IF EXISTS ponport_mapping_subscriber CASCADE;
DROP TABLE IF EXISTS pop_master CASCADE;
DROP TABLE IF EXISTS pop_master_backup2june CASCADE;
DROP TABLE IF EXISTS portspeed CASCADE;
DROP TABLE IF EXISTS premisedetail CASCADE;
DROP TABLE IF EXISTS premisetype CASCADE;
DROP TABLE IF EXISTS priority CASCADE;

-- Table: ponport_mapping_subscriber
CREATE TABLE ponport_mapping_subscriber (
    mapping_id UUID NOT NULL PRIMARY KEY,
    id SERIAL,
    partnerid BIGINT,
    ponport_device_id INT,
    pon_port_id INT,
    onl_app_id INT,
    subscriberid BIGINT,
    ont_position INT,
    created_by VARCHAR(150),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1
);

-- Table: pop_master
CREATE TABLE pop_master (
    master_id UUID NOT NULL PRIMARY KEY,
    id SERIAL,
    popname VARCHAR(256),
    district VARCHAR(100),
    poptype VARCHAR(50),
    popid VARCHAR(100),
    created_by VARCHAR(100),
    created_dt TIMESTAMP
);

-- Table: pop_master_backup2june
CREATE TABLE pop_master_backup2june (
    master_id UUID NOT NULL PRIMARY KEY,
    id INT DEFAULT 0,
    popname VARCHAR(256),
    created_by VARCHAR(100),
    created_dt TIMESTAMP
);

-- Table: portspeed
CREATE TABLE portspeed (
    id UUID NOT NULL PRIMARY KEY,
    portspeedid SERIAL,
    speedinkbps INT,
    baseportrental DOUBLE PRECISION,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    bodallowed INT DEFAULT 0,
    boddailyrental DOUBLE PRECISION DEFAULT 0.00,
    active INT DEFAULT 0,
    enddate TIMESTAMP DEFAULT '1970-01-01 00:00:00'
);

-- Table: premisedetail
CREATE TABLE premisedetail (
    id UUID NOT NULL PRIMARY KEY,
    premiseid SERIAL,
    partnergroupid INT,
    vlantableid INT,
    premisename VARCHAR(256),
    premisetypeid INT NOT NULL,
    street VARCHAR(256),
    locality INT,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    partner VARCHAR(64)
);

-- Table: premisetype
CREATE TABLE premisetype (
    id UUID NOT NULL PRIMARY KEY,
    premisetypeid SERIAL,
    premisetype VARCHAR(45) NOT NULL UNIQUE,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: priority
CREATE TABLE priority (
    priority_id UUID NOT NULL PRIMARY KEY,
    id INT,
    priority VARCHAR(25),
    status VARCHAR(15)
);

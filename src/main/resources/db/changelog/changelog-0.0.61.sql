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
    id UUID NOT NULL PRIMARY KEY,
    master_id SERIAL,
    popname VARCHAR(256),
    district VARCHAR(100),
    poptype VARCHAR(50),
    popid VARCHAR(100),
    code VARCHAR(50),
    name VARCHAR(256),
    name_in_local VARCHAR(256),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO pop_master (
    id, master_id, popname, district, poptype, popid, code, name, name_in_local,
    is_active, created_date, modified_date, created_by, modified_by
) VALUES
(
    gen_random_uuid(), DEFAULT, 'Thiruvananthapuram POP', 'Thiruvananthapuram', 'TypeA', 'POP001',
    'POP01', 'TVM POP', 'തിരുവനന്തപുരം POP', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table: pop_master_backup2june
CREATE TABLE pop_master_backup2june (
    id UUID NOT NULL PRIMARY KEY,
    master_id INT DEFAULT 0,
    popname VARCHAR(256),
    code VARCHAR(50),
    name VARCHAR(256),
    name_in_local VARCHAR(256),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO pop_master_backup2june (
    id, master_id, popname, code, name, name_in_local,
    is_active, created_date, modified_date, created_by, modified_by
) VALUES
(
    gen_random_uuid(), 0, 'Thiruvananthapuram POP Backup', 'POP01', 'TVM POP Backup', 'തിരുവനന്തപുരം POP ബാക്കപ്പ്',
    TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
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

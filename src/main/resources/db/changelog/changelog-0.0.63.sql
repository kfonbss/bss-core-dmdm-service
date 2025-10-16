-- Drop tables if they exist
DROP TABLE IF EXISTS po_renewal_status CASCADE;
DROP TABLE IF EXISTS po_unit CASCADE;
DROP TABLE IF EXISTS po_upload CASCADE;
DROP TABLE IF EXISTS po_wo_location CASCADE;
DROP TABLE IF EXISTS po_workorder CASCADE;
DROP TABLE IF EXISTS ponport_mapping_lnp CASCADE;

-- Table: po_renewal_status
CREATE TABLE po_renewal_status (
    status_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    pono VARCHAR(100),
    version INT,
    stdate DATE,
    eddate DATE,
    version_date TIMESTAMP,
    clarify_status INT DEFAULT 0,
    approve_status INT DEFAULT 0,
    edit_approve INT DEFAULT 0,
    region VARCHAR(50),
    mapped_status INT DEFAULT 0
);

-- Table: po_unit
CREATE TABLE po_unit (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL ,
    unit VARCHAR(10),
    region VARCHAR(100)
);

-- Table: po_upload
CREATE TABLE po_upload (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL ,
    time_date TIMESTAMP,
    uploadedby VARCHAR(100),
    type VARCHAR(100),
    size VARCHAR(50),
    path VARCHAR(250),
    po_no VARCHAR(100),
    name VARCHAR(150),
    region VARCHAR(100)
);

-- Table: po_wo_location
CREATE TABLE po_wo_location (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL ,
    loc_code VARCHAR(8),
    circle VARCHAR(50),
    locadr VARCHAR(150),
    district VARCHAR(128),
    taluks VARCHAR(50),
    package VARCHAR(30),
    po_no VARCHAR(25),
    ANP BIGINT,
    AGNP BIGINT,
    status INT,
    commisiondate TIMESTAMP,
    city VARCHAR(50),
    remarks VARCHAR(250),
    ANdate TIMESTAMP,
    wo_no VARCHAR(50),
    wocode VARCHAR(25),
    locname VARCHAR(100),
    bank VARCHAR(50)
);

-- Table: po_workorder
CREATE TABLE po_workorder (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL ,
    po_no VARCHAR(25),
    wo_no VARCHAR(25),
    circle VARCHAR(20),
    amount DOUBLE PRECISION,
    corporateid INT,
    wocode VARCHAR(25),
    createdby VARCHAR(200),
    createdon TIMESTAMP,
    datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    region VARCHAR(100)
);

-- Table: ponport_mapping_lnp
CREATE TABLE ponport_mapping_lnp (
    lnp_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    partnerid BIGINT,
    device_id BIGINT,
    ponport_number VARCHAR(100),
    lnp_maped INT DEFAULT 0,
    created_by VARCHAR(150),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1
);

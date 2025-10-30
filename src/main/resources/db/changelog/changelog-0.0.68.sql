-- Drop tables if they exist
DROP TABLE IF EXISTS plan_mig CASCADE;
DROP TABLE IF EXISTS pmonthlyinvoice CASCADE;
DROP TABLE IF EXISTS pnew CASCADE;
DROP TABLE IF EXISTS po_approval_clarify CASCADE;
DROP TABLE IF EXISTS po_connection_breakup CASCADE;
DROP TABLE IF EXISTS po_finance CASCADE;
DROP TABLE IF EXISTS po_location CASCADE;
DROP TABLE IF EXISTS po_location_dup CASCADE;

-- Table: plan_mig
CREATE TABLE plan_mig (
   plan_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    oldplan INT,
    newplan INT,
    status INT DEFAULT 0 NOT NULL,
    start_date DATE,
    end_date DATE,
    create_date TIMESTAMP,
    remarks VARCHAR(160)
);

-- Table: pmonthlyinvoice
CREATE TABLE pmonthlyinvoice (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    Partnerid BIGINT,
    monthpart VARCHAR(20),
    sharename VARCHAR(20),
    shareamt DOUBLE PRECISION,
    statecode VARCHAR(10)
);

-- Table: pnew
CREATE TABLE pnew (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    pgid INT,
    statecode VARCHAR(10),
    revenue DOUBLE PRECISION,
    monthpart VARCHAR(10),
    ibnp BIGINT,
    ibnpamt DOUBLE PRECISION,
    ibnpshare INT,
    anp BIGINT,
    anpamt DOUBLE PRECISION,
    anpshare INT,
    agp BIGINT,
    agpamt DOUBLE PRECISION,
    agpshare INT,
    msp BIGINT,
    mspamt DOUBLE PRECISION,
    mspshare INT,
    prs BIGINT,
    prsamt DOUBLE PRECISION,
    prsshare INT,
    mkt BIGINT,
    mktamt DOUBLE PRECISION,
    mktshare INT,
    cnp BIGINT,
    cnpamt DOUBLE PRECISION,
    cnpshare INT,
    isp BIGINT,
    ispamt DOUBLE PRECISION,
    ispshare INT,
    pst_code CHAR(3),
    cashbackelg DOUBLE PRECISION,
    cashbackcur DOUBLE PRECISION
);

-- Table: po_approval_clarify
CREATE TABLE po_approval_clarify (
    approval_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    remarks VARCHAR(500),
    role VARCHAR(100),
    po_no VARCHAR(50),
    update_time TIMESTAMP,
    region VARCHAR(50)
);

-- Table: po_connection_breakup
CREATE TABLE po_connection_breakup (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    po_no VARCHAR(30),
    circle VARCHAR(50),
    package_id VARCHAR(50),
    Connections VARCHAR(10),
    rate DOUBLE PRECISION,
    amount DOUBLE PRECISION,
    region VARCHAR(100),
    created_date TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: po_finance
CREATE TABLE po_finance (
    finance_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    po_no VARCHAR(50) NOT NULL,
    date TIMESTAMP,
    cause VARCHAR(200),
    amount DOUBLE PRECISION,
    balance DOUBLE PRECISION,
    wo_no VARCHAR(100),
    region VARCHAR(50)
);

-- Table: po_location
CREATE TABLE po_location (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    loc_code VARCHAR(200),
    circle VARCHAR(50),
    locadr VARCHAR(150),
    district VARCHAR(128),
    taluks VARCHAR(50),
    package VARCHAR(50),
    po_no VARCHAR(25),
    ANP VARCHAR(50),
    AGNP VARCHAR(50),
    status VARCHAR(50),
    commisiondate TIMESTAMP,
    city VARCHAR(50),
    remarks VARCHAR(250),
    ANdate TIMESTAMP,
    wo_no VARCHAR(50),
    locname VARCHAR(256),
    bank VARCHAR(50),
    region VARCHAR(100),
    enq_id INT,
    created_date TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gp VARCHAR(256),
    constituency VARCHAR(256),
    department VARCHAR(256),
    linedepartment VARCHAR(256),
    legalname VARCHAR(100)
);

-- Table: po_location_dup
CREATE TABLE po_location_dup (
    location_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    slno INT,
    po_no VARCHAR(50),
    loc_code VARCHAR(50),
    locname VARCHAR(100),
    locadr VARCHAR(100),
    dcount INT
);

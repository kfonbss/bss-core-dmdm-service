-- Table structure for talukdetail
DROP TABLE IF EXISTS talukdetail;
CREATE TABLE talukdetail (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL,
    oltabid VARCHAR(50),
    region VARCHAR(100),
    blockname VARCHAR(50),
    district VARCHAR(100),
    pincode VARCHAR(50)
);

-- Table structure for talukdetail1
DROP TABLE IF EXISTS talukdetail1;
CREATE TABLE talukdetail1 (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid VARCHAR(50),
    oltabid VARCHAR(50),
    officename VARCHAR(100),
    region VARCHAR(100),
    taluk VARCHAR(100),
    district VARCHAR(100),
    pincode VARCHAR(50)
);

-- Table structure for talukdetail_allcircle
DROP TABLE IF EXISTS talukdetail_allcircle;
CREATE TABLE talukdetail_allcircle (
    id UUID NOT NULL PRIMARY KEY,
    officename VARCHAR(255),
    region VARCHAR(255),
    taluk VARCHAR(255),
    district VARCHAR(255),
    pincode VARCHAR(50),
    state VARCHAR(50)
);

-- Table structure for taxcollection
DROP TABLE IF EXISTS taxcollection;
CREATE TABLE taxcollection (
    id UUID NOT NULL PRIMARY KEY,
    code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active BOOLEAN,
    taxcollectionid SERIAL,
    subscriberrecieptid BIGINT NOT NULL,
    taxtypeid INT NOT NULL DEFAULT 1,
    taxamount NUMERIC(10,2) NOT NULL,
    lastupdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX idx_taxcollection_subscriberrecieptid ON taxcollection(subscriberrecieptid);
-- Enable UUID generation
INSERT INTO taxcollection (
    id,
    code,
    name,
    name_in_local,
    is_active,
    subscriberrecieptid,
    taxtypeid,
    taxamount
) VALUES (
    gen_random_uuid(),
    'TAXCOL001',
    'Property Tax',
    'പ്രോപ്പർട്ടി ടാക്‌സ്',
    TRUE,
    1001,
    1,
    2500.75
);

-- Table structure for taxdetail
DROP TABLE IF EXISTS taxdetail;
CREATE TABLE taxdetail (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL,
    lco_pan_ind NUMERIC(4,2),
    lco_pan_oth NUMERIC(4,2),
    lco_nopan NUMERIC(4,2),
    agp_pan NUMERIC(4,2),
    agp_nopan NUMERIC(4,2),
    msp_pan NUMERIC(4,2),
    msp_nopan NUMERIC(4,2),
    sgst NUMERIC(4,2),
    cgst NUMERIC(4,2),
    sgsttds NUMERIC(4,2),
    cgsttds NUMERIC(4,2),
    kfc NUMERIC(4,2),
    transcharge NUMERIC(4,2),
    status VARCHAR(10),
    createdon TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enddate TIMESTAMP,
    remarks VARCHAR(100)
);

-- Table structure for taxdisbursement
DROP TABLE IF EXISTS taxdisbursement;
CREATE TABLE taxdisbursement (
    id UUID NOT NULL PRIMARY KEY,
    taxdisbursementid BIGSERIAL,
    usagetransactionid BIGINT NOT NULL,
    taxtypeid INT NOT NULL DEFAULT 1,
    taxamount INT DEFAULT 0,
    lastupdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table structure for taxdistribution
DROP TABLE IF EXISTS taxdistribution;
CREATE TABLE taxdistribution (
    id UUID NOT NULL PRIMARY KEY,
    sno BIGSERIAL,
    partnerid BIGINT NOT NULL,
    taxcollected DOUBLE PRECISION NOT NULL,
    taxdisbursed DOUBLE PRECISION NOT NULL,
    taxtorailtel DOUBLE PRECISION NOT NULL,
    lastupdate TIMESTAMP NOT NULL
);

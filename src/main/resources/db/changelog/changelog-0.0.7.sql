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
    code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active BOOLEAN,
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
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    enddate TIMESTAMP,
    remarks VARCHAR(100)
);
INSERT INTO taxdetail (
    id, code, name, name_in_local, is_active, lco_pan_ind, lco_pan_oth, lco_nopan,
    agp_pan, agp_nopan, msp_pan, msp_nopan, sgst, cgst, sgsttds, cgsttds,
    kfc, transcharge, status, created_by, modified_by, enddate, remarks
)
VALUES (
    gen_random_uuid(), 'TXD001', 'Local Cable Operator Tax Detail', 'ലോക്കൽ കേബിൾ ഓപ്പറേറ്റർ നികുതി വിശദാംശം',
    TRUE, 5.00, 5.00, 10.00,
    5.00, 10.00, 5.00, 10.00,
    9.00, 9.00, 2.00, 2.00,
    1.00, 0.50, 'ACTIVE',
    gen_random_uuid(), gen_random_uuid(),
    NOW() + INTERVAL '1 year', 'Initial tax configuration data'
);

-- Table structure for taxdisbursement
DROP TABLE IF EXISTS taxdisbursement;
CREATE TABLE taxdisbursement (
    id UUID NOT NULL PRIMARY KEY,
    code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active BOOLEAN,
    taxdisbursementid BIGSERIAL,
    usagetransactionid BIGINT NOT NULL,
    taxtypeid INT NOT NULL DEFAULT 1,
    taxamount INT DEFAULT 0,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
    );
    INSERT INTO taxdisbursement
    (id, code, name, name_in_local, is_active, usageTransactionId, taxTypeId, taxAmount, created_date, modified_date, created_by, modified_by)
    VALUES
    (gen_random_uuid(), 'TD001', 'Property Tax Disbursement', 'പ്രോപ്പർട്ടി ടാക്‌സ് വിതരണം', true, 1001, 1, 5000, NULL, NULL, NULL, NULL);

-- Table structure for taxdistribution
DROP TABLE IF EXISTS taxdistribution;
CREATE TABLE taxdistribution (
    id UUID NOT NULL PRIMARY KEY,
    code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active BOOLEAN,
    sno BIGSERIAL,
    partnerid BIGINT NOT NULL,
    taxcollected DOUBLE PRECISION NOT NULL,
    taxdisbursed DOUBLE PRECISION NOT NULL,
    taxtorailtel DOUBLE PRECISION NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
   );

   INSERT INTO taxdistribution
   (id, code, name, name_in_local, is_active, partnerid, taxcollected, taxdisbursed, taxtorailtel, created_date, modified_date, created_by, modified_by)
   VALUES
   (gen_random_uuid(), 'TDI001', 'Property Tax Distribution', 'പ്രോപ്പർട്ടി ടാക്‌സ് വിതരണം', true, 2001, 10000, 8000, 2000, NULL, NULL, NULL, NULL);


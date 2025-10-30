-- Table: subdata
DROP TABLE IF EXISTS subdata;
CREATE TABLE subdata (
    data_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    username VARCHAR(64) NOT NULL,
    fullname VARCHAR(128),
    partnername VARCHAR(128),
    partnerid VARCHAR(45) NOT NULL,
    vlanname VARCHAR(64),
    vlanid VARCHAR(10) NOT NULL,
    packageid VARCHAR(10) NOT NULL,
    packagename VARCHAR(45),
    premiseid INT NOT NULL,
    address VARCHAR(256),
    expirydate DATE,
    accountbalance NUMERIC(10,2),
    lastrechargedate TIMESTAMP,
    lastrechargeamount NUMERIC(10,2),
    lastrecharegmode VARCHAR(50),
    framedip VARCHAR(15),
    nasip VARCHAR(15),
    servicetype VARCHAR(32),
    starttime TIMESTAMP,
    endtime TIMESTAMP,
    terminatecause VARCHAR(32),
    lastlogintime TIMESTAMP,
    lastUsagedaywise VARCHAR(45),
    currentusageUP BIGINT,
    currentusageDOWN BIGINT,
    currentusageSPEED VARCHAR(45),
    mac VARCHAR(50),
    fixedip VARCHAR(15)
);

-- Table: subgstinupdates
DROP TABLE IF EXISTS subgstinupdates;
CREATE TABLE subgstinupdates (
    updates_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    subscriberid INT,
    gstin VARCHAR(20),
    updatedon TIMESTAMP,
    updatedby VARCHAR(50)
);

-- Table: subiprequest
DROP TABLE IF EXISTS subiprequest;
CREATE TABLE subiprequest (
    request_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    staticpackageid INT,
    subscriberid BIGINT,
    partnerid BIGINT,
    status VARCHAR(20),
    createddate TIMESTAMP,
    createdby INT,
    lastupdate TIMESTAMP
);

-- Table: subonlinerecharge
DROP TABLE IF EXISTS subonlinerecharge;
CREATE TABLE subonlinerecharge (
    recharge_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    ordernumber VARCHAR(64),
    status CHAR(18),
    amount NUMERIC(13,2),
    order_time TIMESTAMP,
    subscriberid BIGINT,
    txnid VARCHAR(64),
    banktxnid VARCHAR(64),
    txnamout NUMERIC(13,2),
    txndate TIMESTAMP,
    currency VARCHAR(5),
    respcode VARCHAR(45),
    respmsg VARCHAR(256),
    gatewayname VARCHAR(45),
    bankname VARCHAR(256),
    paymentmode VARCHAR(45),
    ErrorStatus VARCHAR(45),
    ErrorDescription VARCHAR(200),
    anpshare NUMERIC(20,2) DEFAULT 0.00,
    railtelshare NUMERIC(20,2) DEFAULT 0.00,
    flag BOOLEAN DEFAULT FALSE,
    packageid INT,
    partnerid BIGINT,
    recon_date DATE,
    txncharge NUMERIC(13,2),
    txnpercenatge NUMERIC(13,2),
    mimostatus VARCHAR(15),
    statecode CHAR(5),
    recharge_priority BOOLEAN DEFAULT FALSE,
    rwstatus BOOLEAN DEFAULT FALSE,
    rechargesite INT DEFAULT 1
);

-- Table: subonlinerechargeatom
DROP TABLE IF EXISTS subonlinerechargeatom;
CREATE TABLE subonlinerechargeatom (
    line_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    ordernumber VARCHAR(64) UNIQUE,
    status CHAR(18),
    amount NUMERIC(13,2),
    order_time TIMESTAMP,
    subscriberid BIGINT,
    txnid VARCHAR(64),
    banktxnid VARCHAR(64),
    txnamout NUMERIC(13,2),
    txndate TIMESTAMP,
    currency VARCHAR(5),
    respcode VARCHAR(45),
    respmsg VARCHAR(500),
    gatewayname VARCHAR(45),
    bankname VARCHAR(256),
    paymentmode VARCHAR(45),
    ErrorStatus VARCHAR(100),
    ErrorDescription VARCHAR(200),
    anpshare NUMERIC(20,2) DEFAULT 0.00,
    railtelshare NUMERIC(20,2) DEFAULT 0.00,
    flag BOOLEAN DEFAULT FALSE,
    packageid INT,
    partnerid BIGINT,
    statecode CHAR(5),
    rechargesite INT DEFAULT 1,
    paymnetgateway INT DEFAULT 1,
    utrnumber VARCHAR(100),
    dsb_date TIMESTAMP,
    utr_updated_date TIMESTAMP
);

-- Table: subonlinetransaction
DROP TABLE IF EXISTS subonlinetransaction;
CREATE TABLE subonlinetransaction (
    transaction_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    ordernumber VARCHAR(64),
    status CHAR(18),
    amount NUMERIC(13,2),
    order_time TIMESTAMP,
    subscriberid BIGINT,
    txnid VARCHAR(64),
    banktxnid VARCHAR(64),
    txnamout NUMERIC(13,2),
    txndate TIMESTAMP,
    currency VARCHAR(5),
    respcode VARCHAR(45),
    respmsg VARCHAR(256),
    gatewayname VARCHAR(45),
    bankname VARCHAR(256),
    paymentmode VARCHAR(45),
    ErrorStatus VARCHAR(45),
    ErrorDescription VARCHAR(200)
);

-- Table: subscriber_contact_information
DROP TABLE IF EXISTS subscriber_contact_information;
CREATE TABLE subscriber_contact_information (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    information_id SERIAL,
    name VARCHAR(30),
    mobile VARCHAR(12),
    email VARCHAR(100),
    pincode VARCHAR(6),
    address VARCHAR(250),
    district VARCHAR(100),
    postoffice VARCHAR(100),
    connection_type INT,
    comments VARCHAR(250),
    rationcard VARCHAR(100),
    status INT DEFAULT 1,
    houseno VARCHAR(30),
    street VARCHAR(100),
    locality VARCHAR(100),
    area VARCHAR(100),
    concern INT,
    remarks VARCHAR(200),
    tracking_id VARCHAR(10),
    partnerid BIGINT,
    partnercompanyname VARCHAR(100),
    code VARCHAR(50),
    name_in_local VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO subscriber_contact_information
(id, information_id,name, mobile, email, pincode, address, district, postoffice, connection_type, comments, rationcard, status, houseno, street, locality, area, concern, remarks, tracking_id, partnerid, partnercompanyname, code, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 1,'John Doe', '9876543210', 'john@example.com', '600001', '123 Street', 'District A', 'Post Office A', 1, 'Test Comment', 'RC001', 1, '12A', 'Main Street', 'Locality A', 'Area A', 0, 'No remarks', 'TRK001', 3001, 'Partner Co', 'INFO001', 'ജോൺ ഡോ', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());

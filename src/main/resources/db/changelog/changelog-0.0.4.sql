-- Drop table if exists
DROP TABLE IF EXISTS users_districts;
CREATE TABLE users_districts (
    user_district_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    user_id INTEGER,
    district_id INTEGER,
    district_value VARCHAR(45)
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS vas_config;
CREATE TABLE vas_config (
    config_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    authorizations VARCHAR(300),
    api_end_point VARCHAR(250),
    vendor_code VARCHAR(100),
    max_timeout INTEGER,
    provider_name VARCHAR(100),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INTEGER DEFAULT 1
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS vas_packages;
CREATE TABLE vas_packages (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    vas_packid SERIAL,
    comp_packageid INTEGER,
    sub_packageid INTEGER,
    servicepack VARCHAR(100),
    pack_group_name VARCHAR(100),
    vas_type INTEGER DEFAULT 1,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    upadate_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INTEGER DEFAULT 1
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS vas_recharge_list;
CREATE TABLE vas_recharge_list (
    recharge_list_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    subscriberid BIGINT,
    packageid INTEGER,
    finrefid VARCHAR(100),
    ordernumber VARCHAR(64),
    mobileno VARCHAR(13),
    vasrefno VARCHAR(100),
    response_message VARCHAR(250),
    trans_status INTEGER DEFAULT 1,
    vas_type INTEGER DEFAULT 1,
    sstart_date TIMESTAMP,
    send_date TIMESTAMP,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    upadate_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INTEGER DEFAULT 1
);
--------------------------------------------------------
-- Drop existing tables if they exist
DROP TABLE IF EXISTS trouble_ticket;
CREATE TABLE trouble_ticket (
    trouble_ticket_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    severity VARCHAR(45),
    ticketId VARCHAR(75) UNIQUE,
    subject TEXT,
    priority VARCHAR(45),
    status VARCHAR(60),
    deviceType VARCHAR(45),
    pop VARCHAR(45),
    popId VARCHAR(45),
    district VARCHAR(45),
    networkElement TEXT,
    popType VARCHAR(45),
    gisId VARCHAR(45),
    faultCategory VARCHAR(45),
    alarmGroup VARCHAR(45),
    rootCause VARCHAR(45),
    alarmName VARCHAR(45),
    alarmDispName VARCHAR(45),
    alarmOccurenceTime TIMESTAMP NULL,
    emsAlarmRaisedTime TIMESTAMP NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS tspoc_users;
CREATE TABLE tspoc_users (
    users_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    username VARCHAR(120) NOT NULL,
    empname VARCHAR(120) NOT NULL,
    emptitle VARCHAR(120) NOT NULL,
    official VARCHAR(45) NOT NULL,
    email VARCHAR(120) NOT NULL,
    mobile VARCHAR(10) NOT NULL,
    created_date TIMESTAMP,
    modified_date TIMESTAMP
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS txtnadhaar;
CREATE TABLE txtnadhaar (
    aadhaar_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    ordernumber VARCHAR(64),
    adhaarno BIGINT,
    status CHAR(10),
    partnerid BIGINT,
    txtn_date TIMESTAMP
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS uploads;
CREATE TABLE uploads (
    uploads_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    mobile_no BIGINT,
    upload_path VARCHAR(300),
    CreatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate TIMESTAMP,
    IP VARCHAR(20)
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    users_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    username VARCHAR(128) NOT NULL UNIQUE,
    empname VARCHAR(128) NOT NULL,
    emptitle VARCHAR(128),
    empdetails VARCHAR(128),
    password VARCHAR(300),
    auditdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    remarks VARCHAR(128),
    official VARCHAR(45),
    role VARCHAR(45),
    addl_role VARCHAR(45),
    session_id VARCHAR(255),
    mobile VARCHAR(20),
    email VARCHAR(128),
    district VARCHAR(50),
    region VARCHAR(45) DEFAULT 'SOUTH',
    name VARCHAR(45),
    email_verified_at TIMESTAMP NULL,
    remember_token VARCHAR(45),
    zone VARCHAR(50),
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL
);

-- -------------------------------------------------------

DROP TABLE IF EXISTS users_bunits;
CREATE TABLE users_bunits (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    user_id INTEGER,
    bu_id INTEGER
);

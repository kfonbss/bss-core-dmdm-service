-- subscriber_feedback
DROP TABLE IF EXISTS subscriber_feedback;

CREATE TABLE subscriber_feedback (
    id UUID NOT NULL PRIMARY KEY,
    feedback_id SERIAL,
    subscriberid BIGINT,
    username VARCHAR(256),
    partnerid BIGINT,
    partnername VARCHAR(256),
    ticketid BIGINT,
    circle VARCHAR(100),
    rating INTEGER,
    feedback TEXT,
    status INT DEFAULT 1,
    code VARCHAR(50),
    name VARCHAR(256),
    name_in_local VARCHAR(256),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO subscriber_feedback (id, feedback_id, subscriberid, username, partnerid, partnername, ticketid, circle, rating, feedback, status, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES (gen_random_uuid(), 1, 1234567890, 'john_doe', 1001, 'Partner Inc', 9876543210, 'Mumbai', 5, 'Very satisfied with the service', 1, 'FB001', 'Feedback Example', 'ഫീഡ്ബാക്ക് ഉദാഹരണം', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- subscriber_offers
DROP TABLE IF EXISTS subscriber_offers;

CREATE TABLE subscriber_offers (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL,
    subscriberid INTEGER,
    applied_date TIMESTAMP,
    partnerid VARCHAR(45),
    code VARCHAR(50),
    name VARCHAR(256),
    name_in_local VARCHAR(256),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO subscriber_offers (id, subscriberid, applied_date, partnerid, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 1001, NOW(), '2001', 'OF001', 'Offer 1', 'ഓഫർ 1', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());

-- subscriber_status_type
DROP TABLE IF EXISTS subscriber_status_type;

CREATE TABLE subscriber_status_type (
    id UUID NOT NULL PRIMARY KEY,
    status_id SERIAL,
    description VARCHAR(100),
    code VARCHAR(50),
    name VARCHAR(100),
    name_in_local VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

CREATE INDEX idx_subscriber_status_type_description
    ON subscriber_status_type(description);

INSERT INTO subscriber_status_type (
    id, status_id, description, code, name, name_in_local, is_active,
    created_date, modified_date, created_by, modified_by
) VALUES (gen_random_uuid(), 1, 'Active subscriber status', 'STAT001', 'Active', 'സജീവം', TRUE,
    NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- subscriberaccount
DROP TABLE IF EXISTS subscriberaccount;

CREATE TABLE subscriberaccount (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid INTEGER,
    balance NUMERIC(13,2),
    code VARCHAR(50),
    name VARCHAR(100),
    name_in_local VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);


INSERT INTO subscriberaccount (
    id, subscriberid, balance, code, name, name_in_local, is_active,
    created_date, modified_date, created_by, modified_by
) VALUES (gen_random_uuid(), 1001, 250.50, 'ACC001', 'John Doe', 'ജോൺ ഡോ', TRUE,
    NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);

-- subscriberaccountstaticip
DROP TABLE IF EXISTS subscriberaccountstaticip;

CREATE TABLE subscriberaccountstaticip (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid INTEGER,
    balance NUMERIC(10,2) DEFAULT 0.00,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- subscriberdatausege
DROP TABLE IF EXISTS subscriberdatausege;

CREATE TABLE subscriberdatausege (
    data_usage_id UUID NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    subscriberid INTEGER,
    username VARCHAR(64),
    partnerid BIGINT,
    packagename VARCHAR(200),
    uploaded VARCHAR(45),
    downloaded VARCHAR(45),
    startdate DATE,
    enddate DATE,
    billingtype VARCHAR(30)
);


-- subscriberdetail
DROP TABLE IF EXISTS subscriberdetail;

CREATE TABLE subscriberdetail (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid SERIAL,
    username VARCHAR(64) UNIQUE,
    partnerid VARCHAR(45),
    firstname VARCHAR(64),
    middlename VARCHAR(45),
    lastname VARCHAR(64),
    premiseid INTEGER,
    mobileno BIGINT,
    email VARCHAR(128),
    dateofbirth VARCHAR(10),
    registrationdate TIMESTAMP,
    machineaddress VARCHAR(17),
    subscriberprofileid INTEGER DEFAULT 1,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    landlineno BIGINT,
    doorno VARCHAR(10),
    apno VARCHAR(45),
    oltabid INTEGER,
    address VARCHAR(300),
    disabled INT DEFAULT 0,
    gstin VARCHAR(20),
    sac VARCHAR(20),
    pan VARCHAR(15),
    pancard_copy VARCHAR(120),
    gstindoc VARCHAR(120),
    lutdoc VARCHAR(255),
    subprofile VARCHAR(45),
    otp INTEGER,
    otpstarttime TIMESTAMP,
    taxpayertype INT DEFAULT 0,
    gst_status INT,
    gender INT,
    apptype INT,
    sez_verfied INT,
    latitude VARCHAR(100),
    longitude VARCHAR(100),
    ponport_details_sub_id INTEGER,
    workorderid INTEGER
);

CREATE INDEX idx_subscriberdetail_premiseid ON subscriberdetail(premiseid);


-- subscriberemail
DROP TABLE IF EXISTS subscriberemail;

CREATE TABLE subscriberemail (
    email_id UUID NOT NULL PRIMARY KEY,
    id SERIAL,
    subscriberid INTEGER,
    username VARCHAR(250),
    email VARCHAR(250),
    sentdate TIMESTAMP
);

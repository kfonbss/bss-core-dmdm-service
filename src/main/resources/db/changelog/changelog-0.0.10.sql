-- subscriber_feedback
DROP TABLE IF EXISTS subscriber_feedback;

CREATE TABLE subscriber_feedback (
    feedback_id UUID NOT NULL PRIMARY KEY,
    id BIGSERIAL,
    subscriberid BIGINT,
    username VARCHAR(256),
    partnerid BIGINT,
    partnername VARCHAR(256),
    ticketid BIGINT,
    circle VARCHAR(100),
    rating INTEGER,
    feedback TEXT,
    status INT DEFAULT 1
);


-- subscriber_offers
DROP TABLE IF EXISTS subscriber_offers;

CREATE TABLE subscriber_offers (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL,
    subscriberid INTEGER,
    applied_date TIMESTAMP,
    partnerid VARCHAR(45)
);


-- subscriber_status_type
DROP TABLE IF EXISTS subscriber_status_type;

CREATE TABLE subscriber_status_type (
    status_id SERIAL PRIMARY KEY,
    description VARCHAR(100)
);

CREATE INDEX idx_subscriber_status_type_description
    ON subscriber_status_type(description);


-- subscriberaccount
DROP TABLE IF EXISTS subscriberaccount;

CREATE TABLE subscriberaccount (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid INTEGER,
    balance NUMERIC(13,2),
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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

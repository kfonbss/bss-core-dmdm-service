-- online_customers_movement
DROP TABLE IF EXISTS online_customers_movement CASCADE;

CREATE TABLE online_customers_movement (
    movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    ticketid BIGINT,
    note TEXT,
    created_by VARCHAR(64),
    createdby_id INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(45),
    followupdate DATE,
    fe_name VARCHAR(100),
    partnerid BIGINT,
    partnername VARCHAR(250)
);

-- online_customers_ticket_movement
DROP TABLE IF EXISTS online_customers_ticket_movement CASCADE;

CREATE TABLE online_customers_ticket_movement (
    movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    ticketid BIGINT,
    note TEXT,
    created_by VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(45)
);

-- online_fe_reference
DROP TABLE IF EXISTS online_fe_reference CASCADE;

CREATE TABLE online_fe_reference (
    reference_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    description VARCHAR(50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1 -- 0=In Active,1=Active
);

-- online_partners_enquiry_movement
DROP TABLE IF EXISTS online_partners_enquiry_movement CASCADE;

CREATE TABLE online_partners_enquiry_movement (
    online_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    ticketid BIGINT,
    note TEXT,
    created_by VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(45)
);

-- online_subscribers_movement
DROP TABLE IF EXISTS online_subscribers_movement CASCADE;

CREATE TABLE online_subscribers_movement (
    movement_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    ticketid BIGINT,
    note TEXT,
    created_by VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(45),
    partnerid BIGINT,
    partnercompanyname VARCHAR(100)
);

-- onlineapplication
DROP TABLE IF EXISTS onlineapplication CASCADE;

CREATE TABLE onlineapplication (
    application_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    apno VARCHAR(45) NOT NULL,
    status VARCHAR(45) NOT NULL DEFAULT 'Submitted',
    create_date TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    partnerid VARCHAR(45) NOT NULL,
    packageid INT NOT NULL,
    agpid VARCHAR(45),
    firstname VARCHAR(64) NOT NULL,
    middlename VARCHAR(64),
    lastname VARCHAR(64),
    mobileno VARCHAR(45) NOT NULL,
    email VARCHAR(256),
    dateofbirth DATE,
    address VARCHAR(256) NOT NULL,
    idproof VARCHAR(255),
    addressproof VARCHAR(255) NOT NULL,
    addressproof_backdetails VARCHAR(255),
    appform VARCHAR(256),
    submit_remarks VARCHAR(256),
    verify_remarks VARCHAR(256),
    reject_remarks VARCHAR(256),
    disconnect_remarks VARCHAR(256),
    resubmit_remarks VARCHAR(256),
    street VARCHAR(256),
    addressproof_no VARCHAR(256),
    idproof_no VARCHAR(256),
    id_type VARCHAR(256),
    address_type VARCHAR(256),
    proofstatus INT DEFAULT 0,
    resubmit_date TIMESTAMP,
    otpekyc VARCHAR(6),
    aadharno BIGINT,
    uname VARCHAR(64),
    doorno VARCHAR(255),
    stcode CHAR(3),
    city VARCHAR(150),
    district VARCHAR(150),
    pincode CHAR(6),
    villagename VARCHAR(255),
    block VARCHAR(150),
    gstin VARCHAR(64),
    gstinproof VARCHAR(256),
    pan VARCHAR(64),
    panproof VARCHAR(256),
    employeridproof VARCHAR(200),
    contact_manager VARCHAR(200),
    contact_manager_no VARCHAR(200),
    caf_type VARCHAR(200),
    employer_name VARCHAR(200),
    aadhartokenno VARCHAR(100),
    taxpayertype INT DEFAULT 0,
    gst_status INT,
    legalname VARCHAR(250),
    tradename VARCHAR(250),
    otccharge NUMERIC(10,2),
    cafid BIGINT,
    gender VARCHAR(10),
    subdistrict VARCHAR(20),
    photo VARCHAR(100),
    post_office_name VARCHAR(100),
    panchayat_type INT,
    loc_type INT,
    doorno_insta VARCHAR(255),
    streetlo_insta VARCHAR(256),
    cityname_insta VARCHAR(150),
    pincode_insta CHAR(6),
    post_office_name_insta VARCHAR(100),
    district_insta VARCHAR(150),
    loc_type_insta INT DEFAULT 0,
    panchayat_type_insta INT DEFAULT 0,
    village_name_insta VARCHAR(255),
    block_insta VARCHAR(150),
    doorno_billing VARCHAR(255),
    streetlo_billing VARCHAR(256),
    cityname_billing VARCHAR(150),
    pincode_billing CHAR(6),
    post_office_name_billing VARCHAR(100),
    district_billing VARCHAR(150),
    loc_type_billing INT DEFAULT 0,
    panchayat_type_billing INT DEFAULT 0,
    village_name_billing VARCHAR(255),
    block_billing VARCHAR(150),
    deviceid INT,
    lutproof VARCHAR(255),
    device_provid INT DEFAULT 0,
    device_typeid INT DEFAULT 0,
    device_make VARCHAR(50),
    device_model VARCHAR(50),
    device_address VARCHAR(50),
    olt_type INT,
    paddress_as_aadhar INT DEFAULT 0,
    iaddress_as_paddress INT DEFAULT 0,
    kyc_type INT DEFAULT 0, -- 0=Normal KYC,1=EKYC
    source INT DEFAULT 1, -- 1=WebPortal,2=MobileApp
    lnp_vlanid VARCHAR(20),
    ssid_2_4ghz VARCHAR(30),
    preshared_2_4ghz VARCHAR(20),
    ssid_5_0ghz VARCHAR(30),
    preshared_5_0ghz VARCHAR(20),
    ont_position INT,
    ponport_details_id INT,
    ration_card_type INT,
    app_enqid INT,
    member_type INT,
    appliedonline_enqid VARCHAR(100)
);

CREATE INDEX application_index ON onlineapplication(packageid, update_date, status);

-- onlinestatus
DROP TABLE IF EXISTS onlinestatus CASCADE;

CREATE TABLE onlinestatus (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    status VARCHAR(50)
);

-- Drop table if exists
DROP TABLE IF EXISTS package_map CASCADE;

CREATE TABLE package_map (
    id UUID NOT NULL PRIMARY KEY,
    mapid BIGSERIAL ,
    partnerid BIGINT NOT NULL,
    packageid INT,
    status INT NOT NULL DEFAULT 1,
    update_date TIMESTAMP
);

CREATE INDEX index1 ON package_map(partnerid, status);

-- packagecategory
DROP TABLE IF EXISTS packagecategory CASCADE;

CREATE TABLE packagecategory (
    id UUID NOT NULL PRIMARY KEY,
    pkg_ctgy_id SERIAL ,
    categoryname VARCHAR(250) NOT NULL,
    createdate TIMESTAMP NOT NULL
);

-- packagechangerequests
DROP TABLE IF EXISTS packagechangerequests CASCADE;

CREATE TABLE packagechangerequests (
    id UUID NOT NULL PRIMARY KEY,
    requestno SERIAL ,
    requeststatus INT NOT NULL DEFAULT 0,
    subscriberid INT,
    newpackageid INT,
    oldpackageid INT,
    requestdate TIMESTAMP,
    created_by VARCHAR(250)
);

CREATE INDEX index_requests ON packagechangerequests(subscriberid);

-- packages
DROP TABLE IF EXISTS packages CASCADE;

CREATE TABLE packages (
    id UUID NOT NULL PRIMARY KEY,
    packageid SERIAL ,
    packagename VARCHAR(45),
    serviceid INT,
    package_type VARCHAR(45),
    customer_type VARCHAR(45),
    category VARCHAR(45),
    qos VARCHAR(45),
    speed VARCHAR(45),
    unit VARCHAR(10),
    connection_type VARCHAR(45),
    allocated_volume VARCHAR(45),
    validity VARCHAR(45),
    offers VARCHAR(45),
    discount NUMERIC(10,2),
    mrc VARCHAR(45),
    otc NUMERIC(10,2),
    created_on TIMESTAMP
);

-- pan_gst_history
DROP TABLE IF EXISTS pan_gst_history CASCADE;

CREATE TABLE pan_gst_history (
    history_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    partnerid VARCHAR(15),
    partner_group INT,
    sla_ticket_id VARCHAR(15),
    old_pan VARCHAR(10),
    new_pan VARCHAR(10),
    old_gstin VARCHAR(15),
    new_gstin VARCHAR(15),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- partner_confirmation_from_agnp
DROP TABLE IF EXISTS partner_confirmation_from_agnp CASCADE;

CREATE TABLE partner_confirmation_from_agnp (
    agnp_id UUID NOT NULL PRIMARY KEY,
    id BIGSERIAL ,
    partnerid BIGINT,
    document VARCHAR(4200),
    status VARCHAR(45),
    note TEXT,
    created_by VARCHAR(64),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- partner_confirmation_from_agnp_movement
DROP TABLE IF EXISTS partner_confirmation_from_agnp_movement CASCADE;

CREATE TABLE partner_confirmation_from_agnp_movement (
    movement_id UUID NOT NULL PRIMARY KEY,
    id BIGSERIAL ,
    pcf_id BIGINT,
    note TEXT,
    status VARCHAR(45),
    created_by VARCHAR(64),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- partner_gstvalet
DROP TABLE IF EXISTS partner_gstvalet CASCADE;

CREATE TABLE partner_gstvalet (
    id UUID NOT NULL PRIMARY KEY,
    slno SERIAL ,
    partnerid BIGINT,
    partnername VARCHAR(200),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(200),
    BSS_invoiceno VARCHAR(20),
    gst_amt NUMERIC(10,2),
    approved_amt NUMERIC(10,2),
    balance_amt NUMERIC(10,2),
    submit_status VARCHAR(20),
    approve_status VARCHAR(20),
    submit_date TIMESTAMP,
    approve_date TIMESTAMP,
    ptype VARCHAR(10),
    billtype VARCHAR(10),
    remarks VARCHAR(200),
    gst_invoiceno VARCHAR(25),
    irn_no VARCHAR(150),
    gst_invoicedate DATE,
    gstin_proof VARCHAR(250),
    updated_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- partner_revenue
DROP TABLE IF EXISTS partner_revenue CASCADE;

CREATE TABLE partner_revenue (
    revenue_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    partnerid INT,
    partnername VARCHAR(60),
    state VARCHAR(30) NOT NULL,
    revenue VARCHAR(30) NOT NULL,
    billtype VARCHAR(30) NOT NULL,
    reportdate VARCHAR(30)
);

-- partneraccount
DROP TABLE IF EXISTS partneraccount CASCADE;

CREATE TABLE partneraccount (
    id UUID NOT NULL PRIMARY KEY,
    partneraccountid SERIAL ,
    partnerid BIGINT NOT NULL UNIQUE,
    balance DOUBLE PRECISION,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

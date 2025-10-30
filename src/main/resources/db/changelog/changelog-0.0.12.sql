-- Table: streetbox_location
DROP TABLE IF EXISTS streetbox_location;
CREATE TABLE streetbox_location (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    Equipment_Name VARCHAR(100),
    POP_Name VARCHAR(100),
    District VARCHAR(25),
    POP_Type VARCHAR(100),
    Latitude DECIMAL(10,8),
    Longitude DECIMAL(10,8),
    type VARCHAR(100),
    Snum SERIAL,
    category VARCHAR(50)
);

-- Table: sub_cause_details
DROP TABLE IF EXISTS sub_cause_details;
CREATE TABLE sub_cause_details (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    cause_id SERIAL,
    sfin_outflow VARCHAR(50),
    disb_inflow VARCHAR(50),
    lnp_disb_cause VARCHAR(50),
    agp_disb_cause VARCHAR(50),
    msp_disb_cause VARCHAR(50),
    isp_disb_cause VARCHAR(50),
    provider_disb_cause VARCHAR(50),
    disbid_before VARCHAR(3),
    disbid_after VARCHAR(3),
    rstatus INT DEFAULT 0,
    payment_gateway VARCHAR(10),
    paymode INT DEFAULT 1,  -- 1=Offline,2=Online
    service_type INT,
    package_type VARCHAR(50),
    plantype INT,
    remarks VARCHAR(50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: sub_invoice
DROP TABLE IF EXISTS sub_invoice;
CREATE TABLE sub_invoice (
    invoice_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    subscriberid BIGINT,
    cause VARCHAR(100),
    receiptdate DATE,
    packageid INT,
    statecode VARCHAR(100),
    amount NUMERIC(10,2),
    stax NUMERIC(10,2),
    total NUMERIC(10,2),
    ssdate DATE,
    expiry DATE,
    invoiceno VARCHAR(100),
    invoicemonth VARCHAR(50),
    referenceno VARCHAR(100),
    workorderid VARCHAR(100),
    sbces NUMERIC(10,2),
    kkcess NUMERIC(10,2),
    taxtotal NUMERIC(10,2),
    service_days INT,
    cus_type INT, -- 1=BPL,2=EndOffice
    gstin VARCHAR(15),
    taxpayertype INT,
    pan VARCHAR(10),
    einvoice_generated BOOLEAN DEFAULT FALSE,
    crnote_amount NUMERIC(26,10) DEFAULT 0.0000000000,
    crnote_gst NUMERIC(26,10) DEFAULT 0.0000000000,
    crnote_total NUMERIC(26,10) DEFAULT 0.0000000000,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: sub_mbalance
DROP TABLE IF EXISTS sub_mbalance;
CREATE TABLE sub_mbalance (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    subscriberid INT,
    amount NUMERIC(10,2)
);

-- Table: sub_package
DROP TABLE IF EXISTS sub_package;
CREATE TABLE sub_package (
   sub_package_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    comp_packageid INT DEFAULT 0,
    packagevalue NUMERIC(10,2) DEFAULT 0.00,
    service_type INT,
    package_type VARCHAR(50),
    revenueshareid INT DEFAULT 0,
    providerid BIGINT,
    remarks VARCHAR(256),
    sequence INT DEFAULT 1,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1  -- 0=Inactive, 1=Active
);

-- Table: sub_package_servicetype
DROP TABLE IF EXISTS sub_package_servicetype;
CREATE TABLE sub_package_servicetype (
    service_type_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    service_type INT,
    description VARCHAR(100),
    category VARCHAR(50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1  -- 0=Inactive, 1=Active
);

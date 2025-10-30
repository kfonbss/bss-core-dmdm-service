-- Drop tables if they exist
DROP TABLE IF EXISTS po_location_tmp CASCADE;
DROP TABLE IF EXISTS po_locstatus CASCADE;
DROP TABLE IF EXISTS po_packages CASCADE;
DROP TABLE IF EXISTS po_packagetype CASCADE;
DROP TABLE IF EXISTS po_purchase_order CASCADE;
DROP TABLE IF EXISTS po_renew_package CASCADE;
DROP TABLE IF EXISTS po_renewal_clarify CASCADE;
DROP TABLE IF EXISTS po_renewal_file CASCADE;

-- Table: po_location_tmp
CREATE TABLE po_location_tmp (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    loc_code VARCHAR(15),
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
    linedepartment VARCHAR(256)
);

-- Table: po_locstatus
CREATE TABLE po_locstatus (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    statusid SERIAL ,
    status VARCHAR(50)
);

-- Table: po_packages
CREATE TABLE po_packages (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    po_no VARCHAR(30),
    speed VARCHAR(50),
    type VARCHAR(20),
    tarif VARCHAR(50),
    package_id VARCHAR(50),
    otc DOUBLE PRECISION,
    unit VARCHAR(10),
    region VARCHAR(100),
    package_type VARCHAR(100),
    allotcated_vol DOUBLE PRECISION,
    fallback_speed VARCHAR(100),
    renewal_period INT DEFAULT 30
);

-- Table: po_packagetype
CREATE TABLE po_packagetype (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    type VARCHAR(10)
);

-- Table: po_purchase_order
CREATE TABLE po_purchase_order (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL ,
    po_no VARCHAR(30),
    customer VARCHAR(50),
    podesc VARCHAR(200),
    po_amount DOUBLE PRECISION,
    approvestatus INT DEFAULT 0,
    createdon TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    po_period INT,
    anp_pay_period INT,
    agp_pay_period INT,
    totalconnections INT,
    approvedby VARCHAR(150),
    approvedon TIMESTAMP,
    designation VARCHAR(100),
    po_code VARCHAR(20),
    approving_authority VARCHAR(150),
    corporateid INT,
    remarks VARCHAR(255),
    stdate DATE,
    eddate DATE,
    region VARCHAR(100),
    fin_status INT DEFAULT 0,
    mkg_status INT DEFAULT 1,
    mkg_approved TIMESTAMP,
    last_expiry_date DATE,
    last_start_date DATE,
    enq_ref VARCHAR(60),
    bill_stdate DATE,
    po_type VARCHAR(45),
    parent_po_code VARCHAR(50)
);

-- Table: po_renew_package
CREATE TABLE po_renew_package (
    package_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    username VARCHAR(255),
    date TIMESTAMP,
    old_package VARCHAR(100),
    new_package VARCHAR(100),
    status INT DEFAULT 0,
    workorderid VARCHAR(100),
    po_no VARCHAR(50),
    mkg_status INT DEFAULT 0,
    mkg_date TIMESTAMP,
    gm_status INT DEFAULT 0,
    gm_date TIMESTAMP,
    fin_status INT DEFAULT 0,
    fin_date TIMESTAMP,
    amount DOUBLE PRECISION,
    version INT,
    region VARCHAR(50),
    stdate DATE,
    eddate DATE,
    user_enterd_date DATE
);

-- Table: po_renewal_clarify
CREATE TABLE po_renewal_clarify (
    clarify_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id INT DEFAULT 0,
    remarks VARCHAR(250),
    version INT,
    role VARCHAR(100),
    po_no VARCHAR(50),
    update_time TIMESTAMP,
    region VARCHAR(50)
);

-- Table: po_renewal_file
CREATE TABLE po_renewal_file (
    file_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    ID SERIAL ,
    filepath VARCHAR(255) NOT NULL,
    pono VARCHAR(255),
    version INT,
    region VARCHAR(50)
);

-- Drop tables if they exist
DROP TABLE IF EXISTS partnertaxpayerlogs CASCADE;
DROP TABLE IF EXISTS password_resets CASCADE;
DROP TABLE IF EXISTS pbalance_mclose CASCADE;
DROP TABLE IF EXISTS pincode_details CASCADE;
DROP TABLE IF EXISTS pincodes CASCADE;
DROP TABLE IF EXISTS pkg_discount CASCADE;

-- Table: partnertaxpayerlogs
CREATE TABLE partnertaxpayerlogs (
    logs_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    partnerid BIGINT NOT NULL,
    partnercompanyname VARCHAR(30),
    gstin VARCHAR(50),
    taxpayertype INT,
    STcode INT,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: password_resets
CREATE TABLE password_resets (
    id UUID NOT NULL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    token VARCHAR(255) NOT NULL,
    created_at TIMESTAMP
);

-- Table: pbalance_mclose
CREATE TABLE pbalance_mclose (
    close_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    parnterid VARCHAR(45),
    balance DOUBLE PRECISION NOT NULL DEFAULT 0.00,
    audit_date TIMESTAMP
);

-- Table: pincode_details
CREATE TABLE pincode_details (
    id UUID NOT NULL PRIMARY KEY,
    details_id BIGSERIAL ,
    pincode INT,
    post_office_name VARCHAR(250),
    sub_po_name VARCHAR(250),
    district VARCHAR(100),
    districtcode INT,
    name VARCHAR(250),
    name_in_local VARCHAR(250),
    code VARCHAR(50),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO pincode_details (
    id, details_id, pincode, post_office_name, sub_po_name, district, districtcode,
    name, name_in_local, code,is_active,  created_date, modified_date, created_by, modified_by
) VALUES
    (gen_random_uuid(), DEFAULT, 695001, 'Thiruvananthapuram GPO', 'Thiruvananthapuram', 'Thiruvananthapuram', 1,
     'TVM GPO', 'തിരുവനന്തപുരം ജിപിഒ', 'TVM01',TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- Table: pincodes
CREATE TABLE pincodes (
    id UUID NOT NULL PRIMARY KEY,
    pin_id SERIAL ,
    PostOfficeName VARCHAR(256),
    Pincode VARCHAR(8),
    City VARCHAR(256),
    District VARCHAR(256),
    State VARCHAR(256),
    status INT,
    code VARCHAR(50),
    name VARCHAR(256),
    name_in_local VARCHAR(256),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

INSERT INTO pincodes (
    id, pin_id, PostOfficeName, Pincode, City, District, State,
    code, name, name_in_local, status, is_active, created_date, modified_date, created_by, modified_by
) VALUES
(
    gen_random_uuid(), DEFAULT, 'Thiruvananthapuram GPO', '695001', 'Thiruvananthapuram', 'Thiruvananthapuram', 'Kerala',
    'TVM01', 'TVM GPO', 'തിരുവനന്തപുരം ജിപിഒ', 1, TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid()
);


-- Table: pkg_discount
CREATE TABLE pkg_discount (
    discount_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    discount_name VARCHAR(65),
    discount_mode INT,
    discount_val DOUBLE PRECISION,
    discount_method VARCHAR(45),
    categorise VARCHAR(45),
    type_customer VARCHAR(45),
    volume_limit VARCHAR(45),
    created_update TIMESTAMP,
    lastupdate TIMESTAMP
);

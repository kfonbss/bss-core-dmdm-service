-- onlinesub
DROP TABLE IF EXISTS onlinesub CASCADE;

CREATE TABLE onlinesub (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    srno BIGSERIAL ,
    name VARCHAR(64),
    ip VARCHAR(64)
);

-- ont_device_providers
DROP TABLE IF EXISTS ont_device_providers CASCADE;

CREATE TABLE ont_device_providers (
    provider_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    provider_name VARCHAR(50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1 -- 0=In Active, 1=Active
);

-- ont_device_types
DROP TABLE IF EXISTS ont_device_types CASCADE;

CREATE TABLE ont_device_types (
    types_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    device_type INT,
    device_type_name VARCHAR(100),
    device_amount NUMERIC(13,2) DEFAULT 0.00,
    noof_disburs INT DEFAULT 0,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1 -- 0=In Active, 1=Active
);

-- ont_subscriberaccount
DROP TABLE IF EXISTS ont_subscriberaccount CASCADE;

CREATE TABLE ont_subscriberaccount (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    subscriberid BIGSERIAL ,
    partnerid VARCHAR(45),
    balance NUMERIC(13,2),
    noof_disburs INT DEFAULT 0,
    noof_disburs_done INT DEFAULT 0,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1 -- 0=In Active, 1=Active
);

-- ont_subscriberfinance
DROP TABLE IF EXISTS ont_subscriberfinance CASCADE;

CREATE TABLE ont_subscriberfinance (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    finid SERIAL ,
    subscriberid INT,
    partnerid BIGINT,
    amount NUMERIC(13,2),
    cause VARCHAR(100),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1 -- 0=In Active, 1=Active
);

-- ott_platforms
DROP TABLE IF EXISTS ott_platforms CASCADE;

CREATE TABLE ott_platforms (
    ott_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL ,
    pack_group_name VARCHAR(100),
    ott_platform_name VARCHAR(250),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1, -- 0=In Active, 1=Active
    img_id INT
);

-- package
DROP TABLE IF EXISTS package CASCADE;

CREATE TABLE package (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    packageid SERIAL ,
    name VARCHAR(45) NOT NULL,
    renewperiod INT NOT NULL,
    free_service INT,
    initial_free_service INT,
    subscriberprofileid INT NOT NULL,
    portspeedid INT NOT NULL,
    serviceid INT NOT NULL,
    billingtypeid INT NOT NULL,
    onetimecharge NUMERIC(10,2) DEFAULT 0.00,
    discount NUMERIC(10,2) DEFAULT 0.00,
    renewalfee DOUBLE PRECISION DEFAULT 0,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    renewaltaxtypeid INT DEFAULT 1,
    trailpackage INT DEFAULT 0,
    active INT DEFAULT 0,
    enddate TIMESTAMP,
    bandid INT,
    maxvolume DOUBLE PRECISION,
    fallbackspeed VARCHAR(10),
    description VARCHAR(256),
    speedinkbps BIGINT,
    m_profile VARCHAR(45),
    j_profile VARCHAR(45),
    category VARCHAR(45) DEFAULT 'REGULAR',
    plan_type VARCHAR(45) DEFAULT 'ALL',
    parent_package INT DEFAULT 0,
    bod_min BIGINT DEFAULT 0,
    bod_max BIGINT DEFAULT 0,
    fbspeedinkbps BIGINT,
    qos VARCHAR(45),
    revenueshareid INT,
    code VARCHAR(50),
    name_in_local VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

CREATE INDEX package_index ON package(portspeedid, billingtypeid);

INSERT INTO package (id, packageid, name, renewperiod, free_service, initial_free_service, subscriberprofileid, portspeedid, serviceid, billingtypeid, onetimecharge, discount, renewalfee, lastupdate, renewaltaxtypeid, trailpackage, active, enddate, bandid, maxvolume, fallbackspeed, description, speedinkbps, m_profile, j_profile, category, plan_type, parent_package, bod_min, bod_max, fbspeedinkbps, qos, revenueshareid, code, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 1, 'Premium Internet', 30, 2, 1, 201, 1, 101, 1, 100.00, 10.00, 500.00, NOW(), 1, 0, 1, NOW() + interval '30 days', 1, 1000, '50Mbps', 'High speed package', 100000, 'M1', 'J1', 'REGULAR', 'ALL', 0, 0, 0, 50000,'HIGH', 1, 'PKG002', 'പ്രീമിയം ഇന്റർനെറ്റ്', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());

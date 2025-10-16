-- onlinesub
DROP TABLE IF EXISTS onlinesub CASCADE;

CREATE TABLE onlinesub (
    id UUID NOT NULL PRIMARY KEY,
    srno BIGSERIAL ,
    name VARCHAR(64),
    ip VARCHAR(64)
);

-- ont_device_providers
DROP TABLE IF EXISTS ont_device_providers CASCADE;

CREATE TABLE ont_device_providers (
    provider_id UUID NOT NULL PRIMARY KEY,
    id SERIAL ,
    provider_name VARCHAR(50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1 -- 0=In Active, 1=Active
);

-- ont_device_types
DROP TABLE IF EXISTS ont_device_types CASCADE;

CREATE TABLE ont_device_types (
    types_id UUID NOT NULL PRIMARY KEY,
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
    id UUID NOT NULL PRIMARY KEY,
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
    id UUID NOT NULL PRIMARY KEY,
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
    ott_id UUID NOT NULL PRIMARY KEY,
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
    id UUID NOT NULL PRIMARY KEY,
    packageid SERIAL ,
    packagename VARCHAR(45) NOT NULL,
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
    created_on TIMESTAMP,
    qos VARCHAR(45),
    revenueshareid INT
);

CREATE INDEX package_index ON package(portspeedid, billingtypeid);

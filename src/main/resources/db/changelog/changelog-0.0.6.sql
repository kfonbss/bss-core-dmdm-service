DROP TABLE IF EXISTS tempdashboard;

CREATE TABLE tempdashboard (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    hp VARCHAR(2) NOT NULL DEFAULT '',
    subscriberid INT NOT NULL,
    partnergroupid INT,
    expiry TIMESTAMP,
    status INT DEFAULT 0,
    packageid INT DEFAULT 1,
    registrationdate TIMESTAMP,
    renewalfee NUMERIC(10,2),
    maxvolume DOUBLE PRECISION,
    speedinkbps BIGINT,
    ibnp BIGINT,
    username VARCHAR(45)
);

-------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS ticket_movement;

CREATE TABLE ticket_movement (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    noteid BIGSERIAL,
    ticketid BIGINT,
    note VARCHAR(600),
    created_by VARCHAR(64),
    create_date TIMESTAMP,
    status VARCHAR(45),
    helpdesk VARCHAR(64),
    assignedto VARCHAR(45),
    assignedto_type CHAR(50),
    attachment VARCHAR(600),
    assigned_from VARCHAR(100),
    assigned_from_role VARCHAR(100),
    assigned_from_name VARCHAR(100),
    assigned_to_name VARCHAR(100),
    visibility VARCHAR(100)
);

------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS ticket_status;

CREATE TABLE ticket_status (
    status_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id INTEGER NOT NULL DEFAULT 0,
    status VARCHAR(50)
);

-------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS ticket_type;

CREATE TABLE ticket_type (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    typeid BIGSERIAL,
    name VARCHAR(50)
);
------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS taxpayertype;

CREATE TABLE taxpayertype (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active BOOLEAN,
    taxpayertypeid INT,
    taxpayertype VARCHAR(45),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);
INSERT INTO taxpayertype (
    id, code, name, name_in_local, is_active, taxpayertypeid, taxpayertype,
    created_date, modified_date, created_by, modified_by
) VALUES (
    gen_random_uuid(),
    'TP001',
    'Individual',
    'വ്യക്തി',
    TRUE,
    1,
    'Individual',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    gen_random_uuid(),
    gen_random_uuid()
);
-------------------------------------------------------------------

DROP TABLE IF EXISTS taxtype;

CREATE TABLE taxtype (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    code VARCHAR(45),
    name VARCHAR(255),
    name_in_local VARCHAR(255),
    is_active BOOLEAN,
    taxtypeid SERIAL,
    taxvaluepercent NUMERIC(10,2) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
    );

CREATE INDEX idx_name ON taxtype(name);

INSERT INTO taxtype (
    id, code, name, name_in_local, is_active, taxvaluepercent, created_by, modified_by
) VALUES
    ('a1b2c3d4-e5f6-7890-abcd-1234567890ab', 'GST01', 'Goods and Services Tax', 'സാധന സേവന നികുതി', TRUE, 18.00, NULL, NULL);
--------------------------------------------------------------------------

DROP TABLE IF EXISTS tds;

CREATE TABLE tds (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    sno BIGSERIAL,
    partnerid BIGINT NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    lastupdate TIMESTAMP NOT NULL,
    cause VARCHAR(45) NOT NULL
);

------------------------------------------------------------------------------

DROP TABLE IF EXISTS tds_pan;

CREATE TABLE tds_pan (
    plan_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    pan NUMERIC(10,2) NOT NULL,
    nopan NUMERIC(10,2) NOT NULL
);

---------------------------------------------------------------------------------

DROP TABLE IF EXISTS temp_sub_new;

CREATE TABLE temp_sub_new (
    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    slno SERIAL,
    subscriberid INT,
    s_op_bal NUMERIC(10,2),
    s_inflow NUMERIC(10,2),
    s_rechargewithtax NUMERIC(10,2),
    s_revert_partner NUMERIC(10,2),
    s_cl_bal NUMERIC(10,2),
    partnerid VARCHAR(20),
    monthpart VARCHAR(15),
    s_revenuewithtax NUMERIC(10,2),
    remarks VARCHAR(50)
);

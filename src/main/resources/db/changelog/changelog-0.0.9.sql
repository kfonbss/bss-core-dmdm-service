-- subscriberfinance
DROP TABLE IF EXISTS subscriberfinance;

CREATE TABLE subscriberfinance (
    id UUID NOT NULL PRIMARY KEY,
    finid BIGSERIAL,
    subscriberid INTEGER,
    amount NUMERIC(13,2),
    cause VARCHAR(100),
    partnerfinanceid INTEGER,
    rstatus INT NOT NULL DEFAULT 1,
    subonlineref BIGINT,
    packageid INTEGER,
    term_count INT,
    cause_detail_id INTEGER DEFAULT 0,
    code VARCHAR(50),
    name VARCHAR(100),
    name_in_local VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT NOW(),
    modified_date TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

CREATE INDEX sub_indx ON subscriberfinance(subscriberid, cause, modified_date);

INSERT INTO subscriberfinance
(id, finid, subscriberid, amount, cause, partnerfinanceid, rstatus, subonlineref, packageid, term_count, cause_detail_id, code, name, name_in_local, is_active, created_date, modified_date, created_by, modified_by)
VALUES
(gen_random_uuid(), 1, 1001, 250.75, 'Monthly Payment', 2001, 1, 50001, 101, 12, 0, 'FIN001', 'Finance Record 1', 'ഫിനാൻസ് രേഖ 1', TRUE, NOW(), NOW(), gen_random_uuid(), gen_random_uuid());


-- subscribergstdetail
DROP TABLE IF EXISTS subscribergstdetail;

CREATE TABLE subscribergstdetail (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid SERIAL,
    gstin VARCHAR(20),
    sac VARCHAR(20),
    pan VARCHAR(15),
    pancard_copy VARCHAR(120),
    gstindoc VARCHAR(120),
    lutdoc VARCHAR(255),
    gst_verfied INT DEFAULT 0,
    created_date TIMESTAMP,
    createdby INTEGER,
    verified_date TIMESTAMP,
    verfied_by VARCHAR(50),
    taxpayertype INT NOT NULL DEFAULT 0,
    gst_status INT,
    legalname VARCHAR(100),
    tradename VARCHAR(100)
);


-- subscriberinovoice
DROP TABLE IF EXISTS subscriberinovoice;

CREATE TABLE subscriberinovoice (
    id UUID NOT NULL PRIMARY KEY,
    slno BIGSERIAL,
    subscriberid BIGINT,
    invoiceno VARCHAR(64),
    invoicedate DATE,
    grossamount NUMERIC(26,15),
    particulars VARCHAR(180),
    referenceid VARCHAR(100) UNIQUE,
    package VARCHAR(120),
    packagefee NUMERIC(10,2),
    servicetax NUMERIC(10,2),
    servicetaxrate NUMERIC(10,2),
    servicestartdate DATE,
    serviceenddate DATE,
    gst_value NUMERIC(26,15),
    cgst_value NUMERIC(26,15),
    sgst_value NUMERIC(26,15),
    igst_value NUMERIC(26,15),
    cgst_rate NUMERIC(10,2),
    sgst_rate NUMERIC(10,2),
    igst_rate NUMERIC(10,2),
    gstin VARCHAR(18),
    tariff NUMERIC(10,2),
    discount_rate NUMERIC(10,2),
    discount_value NUMERIC(10,2),
    post_upload NUMERIC(10,2) DEFAULT 0.00,
    post_download NUMERIC(10,2) DEFAULT 0.00,
    term_count INT,
    packageid INTEGER,
    taxpayertype INTEGER,
    kfc_rate NUMERIC(10,2) DEFAULT 0.00,
    kfc_value NUMERIC(10,2),
    acctsessiontime BIGINT,
    gst_status INT,
    rechargemode INT DEFAULT 0,
    partnerid BIGINT,
    plantype INT DEFAULT 0,
    sub_caf_type INT,
    reccount INTEGER,
    churn_recovery_days INTEGER DEFAULT 0,
    is_churn_recovery INT DEFAULT 0,
    einvoice_generated INT DEFAULT 0,
    crnote_amount NUMERIC(26,10) DEFAULT 0,
    crnote_gst NUMERIC(26,10) DEFAULT 0,
    crnote_total NUMERIC(26,10) DEFAULT 0,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX index2 ON subscriberinovoice(subscriberid, invoicedate);
CREATE INDEX idx_service_start_end ON subscriberinovoice(serviceenddate, servicestartdate);


-- subscriberprofile
DROP TABLE IF EXISTS subscriberprofile;

CREATE TABLE subscriberprofile (
    id UUID NOT NULL PRIMARY KEY,
    profileid INT,
    name VARCHAR(80) NOT NULL,
    discount NUMERIC(10,2) NOT NULL,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active INT DEFAULT 1
);

CREATE INDEX idx_subscriberprofile_name ON subscriberprofile(name);


-- subscriberusernames
DROP TABLE IF EXISTS subscriberusernames;

CREATE TABLE subscriberusernames (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid SERIAL,
    username VARCHAR(50)
);


-- subscription
DROP TABLE IF EXISTS subscription;

CREATE TABLE subscription (
    id UUID NOT NULL PRIMARY KEY,
    subscriberid BIGINT,
    status INT DEFAULT 0,
    expiry TIMESTAMP,
    packageid INTEGER DEFAULT 1,
    firstuse INT NOT NULL DEFAULT 1,
    lastupdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    partnergroupid INTEGER,
    vlantableid INTEGER,
    alloted_vol BIGINT,
    consumed_vol BIGINT,
    cur_speed VARCHAR(18),
    bod_profile VARCHAR(45) DEFAULT '',
    offerid INT,
    reset_request INT DEFAULT 0,
    reset_request_date TIMESTAMP,
    remarks VARCHAR(200),
    last_topup_date TIMESTAMP,
    last_topup_amount NUMERIC(10,2) DEFAULT 0.00,
    disabled INT NOT NULL DEFAULT 0,
    plan_mig INT NOT NULL DEFAULT 0,
    payment_mode INT DEFAULT 1,
    reactive_date TIMESTAMP,
    addon_data NUMERIC(12,2) DEFAULT 0.00,
    addon_consumed NUMERIC(12,2) DEFAULT 0.00,
    volume_afterfallback NUMERIC(12,2) DEFAULT 0.00,
    usage_flag INT NOT NULL DEFAULT 0,
    last_recharge TIMESTAMP,
    addon_data_start TIMESTAMP,
    fallback_data_start TIMESTAMP,
    acctlastupdatetime TIMESTAMP,
    rad_account INT DEFAULT 0,
    fallback_coa INT NOT NULL DEFAULT 0,
    profile_type VARCHAR(45) DEFAULT 'Juniper',
    send_alert_id BIGINT DEFAULT 0,
    send_alert_date TIMESTAMP,
    term_count INT DEFAULT 0,
    term_validity TIMESTAMP,
    fup_alert INT NOT NULL DEFAULT 0,
    recharge_lock INT NOT NULL DEFAULT 0,
    extension_remarks VARCHAR(180),
    iptv_package INTEGER,
    iptv_bss_expiry TIMESTAMP,
    onetimecharges VARCHAR(45),
    newrad VARCHAR(20),
    free_validity INTEGER,
    frc_date TIMESTAMP
);

CREATE INDEX idx_subscription_status_expiry_packageid 
    ON subscription(status, expiry, packageid);

<<<<<<< HEAD
-- Seed: add missing ANP partner type
INSERT INTO partner (id, name, description, is_active)
SELECT gen_random_uuid(), 'ANP', 'Access Network Provider', TRUE
WHERE NOT EXISTS (SELECT 1 FROM partner WHERE name = 'ANP');
=======
--liquibase formatted sql

--changeset dmdm:107-1
CREATE TABLE IF NOT EXISTS client_application
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    app_code    VARCHAR(50)  NOT NULL UNIQUE,
    app_name    VARCHAR(200) NOT NULL,
    description TEXT,
    is_active   BOOLEAN          DEFAULT TRUE,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    created_by    UUID,
    modified_by   UUID
);

--changeset dmdm:107-2
CREATE TABLE IF NOT EXISTS form_field_master
(
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    field_key            VARCHAR(100) NOT NULL UNIQUE,
    field_label          VARCHAR(200) NOT NULL,
    field_type           VARCHAR(50)  NOT NULL,
    field_category       VARCHAR(50),
    default_validations  JSONB,
    metadata             JSONB,
    is_system            BOOLEAN          DEFAULT FALSE,
    is_active            BOOLEAN          DEFAULT TRUE,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    created_by    UUID,
    modified_by   UUID
);

--changeset dmdm:107-3
CREATE TABLE IF NOT EXISTS application_field_config
(
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    application_id      UUID        NOT NULL REFERENCES client_application (id),
    field_id            UUID        NOT NULL REFERENCES form_field_master (id),
    is_included         BOOLEAN          DEFAULT TRUE,
    is_required         BOOLEAN          DEFAULT FALSE,
    display_order       INTEGER,
    section             VARCHAR(100),
    custom_label        VARCHAR(200),
    custom_validations  JSONB,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    created_by    UUID,
    modified_by   UUID,
    UNIQUE (application_id, field_id)
);

--changeset dmdm:107-4
CREATE TABLE IF NOT EXISTS tenant_field_config
(
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tenant_id           VARCHAR(100) NOT NULL,
    application_id      UUID         NOT NULL REFERENCES client_application (id),
    field_id            UUID         NOT NULL REFERENCES form_field_master (id),
    is_visible          BOOLEAN          DEFAULT TRUE,
    is_required         BOOLEAN,
    display_order       INTEGER,
    custom_label        VARCHAR(200),
    custom_validations  JSONB,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    created_by    UUID,
    modified_by   UUID,
    UNIQUE (tenant_id, application_id, field_id)
);

--changeset dmdm:107-5
CREATE TABLE IF NOT EXISTS tenant_custom_field
(
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tenant_id      VARCHAR(100) NOT NULL,
    application_id UUID         NOT NULL REFERENCES client_application (id),
    field_key      VARCHAR(100) NOT NULL,
    field_label    VARCHAR(200) NOT NULL,
    field_type     VARCHAR(50)  NOT NULL,
    section        VARCHAR(100),
    is_required    BOOLEAN          DEFAULT FALSE,
    display_order  INTEGER,
    validations    JSONB,
    metadata       JSONB,
    is_active      BOOLEAN          DEFAULT TRUE,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    created_by    UUID,
    modified_by   UUID
);

--changeset dmdm:107-6
CREATE INDEX IF NOT EXISTS idx_app_field_config_app_id ON application_field_config (application_id);
CREATE INDEX IF NOT EXISTS idx_tenant_field_config_tenant_app ON tenant_field_config (tenant_id, application_id);
CREATE INDEX IF NOT EXISTS idx_tenant_custom_field_tenant_app ON tenant_custom_field (tenant_id, application_id);

--changeset dmdm:107-7
INSERT INTO client_application (app_code, app_name, description, is_active)
VALUES ('KFON', 'KFON Client', 'Kerala Fiber Optic Network', TRUE),
       ('RAILWARE', 'Railware Client', 'Railway Broadband Network', TRUE)
ON CONFLICT (app_code) DO NOTHING;

--changeset dmdm:107-8
INSERT INTO form_field_master (field_key, field_label, field_type, field_category, default_validations, is_system, is_active)
VALUES
    ('name',            'Full Name',          'TEXT',     'PERSONAL',  '{"required": true, "maxLength": 100}', TRUE, TRUE),
    ('mobile_number',   'Mobile Number',      'PHONE',    'PERSONAL',  '{"required": true, "pattern": "^[0-9]{10}$"}', TRUE, TRUE),
    ('email',           'Email Address',      'EMAIL',    'PERSONAL',  '{"required": false}', TRUE, TRUE),
    ('address',         'Address',            'TEXTAREA', 'ADDRESS',   '{"required": true}', TRUE, TRUE),
    ('pincode',         'Pincode',            'TEXT',     'ADDRESS',   '{"required": true, "pattern": "^[0-9]{6}$"}', TRUE, TRUE),
    ('agreement_doc',   'Agreement Document', 'FILE',     'DOCUMENT',  '{"required": true, "fileTypes": ["pdf"], "maxSizeMB": 5}', TRUE, TRUE),
    ('territory_name',  'Territory Name',     'TEXT',     'NETWORK',   '{"required": false}', FALSE, TRUE),
    ('gateway_name',    'Gateway Name',       'TEXT',     'NETWORK',   '{"required": false}', FALSE, TRUE),
    ('bras_name',       'BRAS Name',          'TEXT',     'NETWORK',   '{"required": false}', FALSE, TRUE),
    ('pop_name',        'POP Name',           'DROPDOWN', 'NETWORK',   '{"required": false}', FALSE, TRUE),
    ('train_route',     'Train Route',        'DROPDOWN', 'TECHNICAL', '{"required": false}', FALSE, TRUE),
    ('zone_code',       'Zone Code',          'TEXT',     'TECHNICAL', '{"required": false}', FALSE, TRUE)
ON CONFLICT (field_key) DO NOTHING;
>>>>>>> 7a84529 (DFG apis added)

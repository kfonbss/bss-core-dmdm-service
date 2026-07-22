--liquibase formatted sql

--changeset dmdm:112-1
CREATE TABLE IF NOT EXISTS onboarding_form_definition
(
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    application_id  UUID         NOT NULL REFERENCES client_application (id),
    tenant_id       VARCHAR(100) NULL,
    form_type       VARCHAR(50)  NOT NULL,
    name            VARCHAR(200) NOT NULL,
    version         INT          NOT NULL DEFAULT 1,
    status          VARCHAR(20)  NOT NULL DEFAULT 'DRAFT',
    description     TEXT,
    created_date    TIMESTAMP,
    modified_date   TIMESTAMP,
    created_by      UUID,
    modified_by     UUID
);

--changeset dmdm:112-2
CREATE UNIQUE INDEX IF NOT EXISTS uq_form_def_app_level
    ON onboarding_form_definition (application_id, form_type, version)
    WHERE tenant_id IS NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uq_form_def_tenant_level
    ON onboarding_form_definition (application_id, tenant_id, form_type, version)
    WHERE tenant_id IS NOT NULL;

--changeset dmdm:112-3
CREATE TABLE IF NOT EXISTS form_section
(
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    form_definition_id UUID         NOT NULL REFERENCES onboarding_form_definition (id),
    section_key        VARCHAR(100) NOT NULL,
    section_label      VARCHAR(200) NOT NULL,
    display_order      INT,
    is_visible         BOOLEAN          DEFAULT TRUE,
    created_date       TIMESTAMP,
    modified_date      TIMESTAMP,
    created_by         UUID,
    modified_by        UUID,
    UNIQUE (form_definition_id, section_key)
);

--changeset dmdm:112-4
CREATE TABLE IF NOT EXISTS form_definition_field
(
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    form_definition_id UUID         NOT NULL REFERENCES onboarding_form_definition (id),
    section_id         UUID REFERENCES form_section (id),
    field_id           UUID REFERENCES form_field_master (id),
    field_key          VARCHAR(100),
    custom_label       VARCHAR(200),
    placeholder        VARCHAR(200),
    default_value      TEXT,
    is_required        BOOLEAN DEFAULT FALSE,
    is_visible         BOOLEAN DEFAULT TRUE,
    is_readonly        BOOLEAN DEFAULT FALSE,
    display_order      INT,
    custom_validations JSONB,
    lookup_type        VARCHAR(100),
    created_date       TIMESTAMP,
    modified_date      TIMESTAMP,
    created_by         UUID,
    modified_by        UUID
);

--changeset dmdm:112-5
CREATE UNIQUE INDEX IF NOT EXISTS uq_form_def_field_master
    ON form_definition_field (form_definition_id, field_id)
    WHERE field_id IS NOT NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uq_form_def_field_custom
    ON form_definition_field (form_definition_id, field_key)
    WHERE field_id IS NULL;

--changeset dmdm:112-6
CREATE TABLE IF NOT EXISTS lookup_master
(
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    lookup_type    VARCHAR(100) NOT NULL,
    lookup_code    VARCHAR(100) NOT NULL,
    lookup_value   VARCHAR(200) NOT NULL,
    parent_code    VARCHAR(100),
    display_order  INT,
    is_active      BOOLEAN DEFAULT TRUE,
    application_id UUID REFERENCES client_application (id),
    tenant_id      VARCHAR(100) NULL,
    created_date   TIMESTAMP,
    modified_date  TIMESTAMP,
    created_by     UUID,
    modified_by    UUID
);

--changeset dmdm:112-7
CREATE UNIQUE INDEX IF NOT EXISTS uq_lookup_global
    ON lookup_master (lookup_type, lookup_code)
    WHERE application_id IS NULL AND tenant_id IS NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uq_lookup_app_level
    ON lookup_master (lookup_type, lookup_code, application_id)
    WHERE application_id IS NOT NULL AND tenant_id IS NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uq_lookup_tenant_level
    ON lookup_master (lookup_type, lookup_code, application_id, tenant_id)
    WHERE application_id IS NOT NULL AND tenant_id IS NOT NULL;

--changeset dmdm:112-8
CREATE INDEX IF NOT EXISTS idx_form_def_app_type_status
    ON onboarding_form_definition (application_id, form_type, status);

CREATE INDEX IF NOT EXISTS idx_form_section_def_id
    ON form_section (form_definition_id);

CREATE INDEX IF NOT EXISTS idx_form_def_field_def_id
    ON form_definition_field (form_definition_id);

CREATE INDEX IF NOT EXISTS idx_lookup_type_app_tenant
    ON lookup_master (lookup_type, application_id, tenant_id);

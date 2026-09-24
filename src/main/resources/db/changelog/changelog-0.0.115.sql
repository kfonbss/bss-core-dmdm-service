--liquibase formatted sql

--changeset dmdm:115-1
CREATE TABLE IF NOT EXISTS nms_details (
    nms_detail_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
    id SERIAL,
    ip VARCHAR(255) NOT NULL,
    token VARCHAR(512) NOT NULL,
    state_code VARCHAR(10) NOT NULL,
    description VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by UUID,
    modified_by UUID
);

--changeset dmdm:115-2
CREATE UNIQUE INDEX IF NOT EXISTS idx_nms_details_state_code ON nms_details(state_code);
--liquibase formatted sql

--changeset dmdm:113-1
ALTER TABLE form_definition_field
    ADD COLUMN IF NOT EXISTS field_type VARCHAR(50);
--liquibase formatted sql

--changeset dmdm:114-1
ALTER TABLE form_definition_field
    ADD COLUMN IF NOT EXISTS metadata jsonb;
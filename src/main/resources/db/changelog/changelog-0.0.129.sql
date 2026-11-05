--liquibase formatted sql

--changeset kfonbss:0.0.129-village
-- Village master, below sub-district (legacy billing_master district_village_details).
-- code = 6-digit Census / LGD village code (legacy VILLCode zero-padded, e.g. '061394'), unique across India.
-- Rows are loaded by schema/village_seed/*.sql (one file per state, not here), which use the same
-- CREATE TABLE IF NOT EXISTS so the two can run in either order.
CREATE TABLE IF NOT EXISTS village (
  village_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id BIGSERIAL,
  code VARCHAR(10) NOT NULL,
  name VARCHAR(250) NOT NULL,
  name_in_local VARCHAR(250),
  sub_district_id UUID NOT NULL,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_village PRIMARY KEY (village_id),
  CONSTRAINT uk_village_code UNIQUE (code),
  CONSTRAINT fk_village_sub_district FOREIGN KEY (sub_district_id) REFERENCES sub_district (sub_district_id)
);
CREATE INDEX IF NOT EXISTS idx_village_sub_district_id ON village (sub_district_id);
--rollback DROP TABLE IF EXISTS village;

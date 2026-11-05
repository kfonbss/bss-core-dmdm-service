--liquibase formatted sql

--changeset kfonbss:0.0.127-sub-district
-- Sub-district (taluk / tehsil / mandal) master, between district and village.
-- code = 5-digit Census sub-district code (legacy billing_master SDTCode zero-padded, e.g. '05674'),
-- unique across India. Rows are loaded by schema/sub_district_seed_all_india.sql (not here), which
-- uses the same CREATE TABLE IF NOT EXISTS so the two can run in either order.
CREATE TABLE IF NOT EXISTS sub_district (
  sub_district_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id BIGSERIAL,
  code VARCHAR(10) NOT NULL,
  name VARCHAR(250) NOT NULL,
  name_in_local VARCHAR(250),
  district_id UUID NOT NULL,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT pk_sub_district PRIMARY KEY (sub_district_id),
  CONSTRAINT uk_sub_district_code UNIQUE (code),
  CONSTRAINT fk_sub_district_district FOREIGN KEY (district_id) REFERENCES district (district_id)
);
CREATE INDEX IF NOT EXISTS idx_sub_district_district_id ON sub_district (district_id);
--rollback DROP TABLE IF EXISTS sub_district;

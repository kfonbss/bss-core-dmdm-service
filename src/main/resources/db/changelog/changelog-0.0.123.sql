--liquibase formatted sql

--changeset kfonbss:0.0.123-package-masters-service-type
-- Package masters move from bss-package-management-services into dmdm. These masters are GLOBAL —
-- one set shared by every tenant, so none of the tables below carry a tenant column.
-- Columns mirror the package service's tables 1:1 so rows can be copied across with their UUIDs,
-- integer ids and codes unchanged: billing-finance persists sub_package_type codes
-- (disbursement_cause.r_code), service_type UUIDs (rule_scope.service_type_id) and service_type
-- type_ids (topup_info.service_type), so none of those values may change in the move.
-- No seed rows here: data is loaded from the package service DB by the one-off migration script
-- (scripts/migrate_package_masters.py), which keeps the source UUIDs.
--
-- service_type already exists in dmdm (changelog-0.0.45.sql) with a single placeholder row
-- ('INT', type_id 1) that no service reads. It collides with the package service's INTERNET row
-- (also type_id 1), so it is removed and type_id is made the unique business key.
DELETE FROM service_type WHERE code = 'INT';
ALTER TABLE service_type ALTER COLUMN type_id SET NOT NULL;
ALTER TABLE service_type ADD CONSTRAINT uk_service_type_type_id UNIQUE (type_id);

--changeset kfonbss:0.0.123-package-masters-simple-types
CREATE TABLE IF NOT EXISTS package_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  package_type_id INT NOT NULL,
  code VARCHAR(50),
  name VARCHAR(45),
  name_in_local VARCHAR(150),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_package_type_type_id UNIQUE (package_type_id)
);

CREATE TABLE IF NOT EXISTS plan_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  plan_type_id INT NOT NULL,
  code VARCHAR(50),
  name VARCHAR(45),
  name_in_local VARCHAR(150),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_plan_type_type_id UNIQUE (plan_type_id)
);

CREATE TABLE IF NOT EXISTS category_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  category_type_id INT NOT NULL,
  code VARCHAR(50),
  name VARCHAR(45),
  name_in_local VARCHAR(150),
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_category_type_type_id UNIQUE (category_type_id)
);

CREATE TABLE IF NOT EXISTS package_plan_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  package_plan_type_id INT NOT NULL,
  code VARCHAR(50),
  name VARCHAR(45),
  name_in_local VARCHAR(150),
  is_active BOOLEAN DEFAULT TRUE,
  category_type_id UUID REFERENCES category_type (id),
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_package_plan_type_type_id UNIQUE (package_plan_type_id)
);

--changeset kfonbss:0.0.123-package-masters-sub-package-type
-- service_type (INT) is the legacy integer link (= service_type.type_id); service_type_id is the
-- UUID link. Both are kept because the package service reads both.
CREATE TABLE IF NOT EXISTS sub_package_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  sub_package_type_id INT NOT NULL,
  code VARCHAR(50),
  name VARCHAR(45),
  name_in_local VARCHAR(150),
  is_active BOOLEAN DEFAULT TRUE,
  service_type INT,
  service_type_id UUID REFERENCES service_type (id),
  disb_before INT,
  disb_after INT,
  invoice_report BOOLEAN DEFAULT FALSE,
  disburse_report BOOLEAN DEFAULT FALSE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_sub_package_type_type_id UNIQUE (sub_package_type_id)
);

--changeset kfonbss:0.0.123-package-masters-service-category
CREATE TABLE IF NOT EXISTS service_category (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  service_category_id SERIAL,
  name VARCHAR(50) NOT NULL,
  label VARCHAR(100),
  sub_service_count INT,
  bundle_type VARCHAR(20),
  is_active BOOLEAN DEFAULT TRUE,
  is_addon BOOLEAN DEFAULT FALSE,
  is_bod BOOLEAN DEFAULT FALSE,
  service_category_type VARCHAR(50),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_service_category_service_category_id UNIQUE (service_category_id)
);

CREATE TABLE IF NOT EXISTS service_category_mapping (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  mapping_id SERIAL,
  service_category_id UUID NOT NULL REFERENCES service_category (id),
  service_type_id UUID REFERENCES service_type (id),
  discountable BOOLEAN DEFAULT FALSE,
  provider_mapping BOOLEAN DEFAULT FALSE,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID,
  CONSTRAINT uk_service_category_mapping_mapping_id UNIQUE (mapping_id),
  CONSTRAINT uq_sc_st UNIQUE (service_category_id, service_type_id)
);

--changeset kfonbss:0.0.123-package-masters-speeds
-- speed_profile_id / fallback_speed_id are the codes package.speed_profile and
-- package.fallbackspeed hold (soft references, no FK).
CREATE TABLE IF NOT EXISTS speed_profile (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  speed_profile_id VARCHAR(45),
  name VARCHAR(45),
  speed_mb INT NOT NULL,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE TABLE IF NOT EXISTS fallback_speed (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  fallback_speed_id VARCHAR(45),
  name VARCHAR(45),
  speed_mb INT NOT NULL,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT NOW(),
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

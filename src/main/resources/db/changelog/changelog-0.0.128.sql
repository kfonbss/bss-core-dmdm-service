--liquibase formatted sql

--changeset kfonbss:0.0.128-block-details-census-code
-- Census blocks (legacy billing_master STATE_DIST_SUBDIST_BLOCK) are loaded into block_details as
-- 'Block Panchayat' rows by schema/block_seed_all_india.sql, so the existing /api/block-detail APIs serve them.
-- code            = Census block code (NBLKCode, e.g. '056300001'; some are 10 digits or end in a letter, so not int)
-- sub_district_id = sub-district the block lies in (NULL for Kerala/Lakshadweep local bodies without a match)
ALTER TABLE block_details ADD COLUMN IF NOT EXISTS code VARCHAR(20);
ALTER TABLE block_details ADD COLUMN IF NOT EXISTS sub_district_id UUID;
CREATE UNIQUE INDEX IF NOT EXISTS uk_block_details_code ON block_details (code) WHERE code IS NOT NULL;
CREATE INDEX IF NOT EXISTS idx_block_details_sub_district_id ON block_details (sub_district_id);
-- the block-detail APIs filter on district_entity + village_type_id, which had no index
CREATE INDEX IF NOT EXISTS idx_block_details_district_entity ON block_details (district_entity, village_type_id);
--rollback DROP INDEX IF EXISTS idx_block_details_district_entity;
--rollback DROP INDEX IF EXISTS idx_block_details_sub_district_id;
--rollback DROP INDEX IF EXISTS uk_block_details_code;
--rollback ALTER TABLE block_details DROP COLUMN IF EXISTS sub_district_id;
--rollback ALTER TABLE block_details DROP COLUMN IF EXISTS code;

--changeset kfonbss:0.0.128-block-details-sub-district-fk splitStatements:false
DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'fk_block_details_sub_district') THEN
    ALTER TABLE block_details ADD CONSTRAINT fk_block_details_sub_district
      FOREIGN KEY (sub_district_id) REFERENCES sub_district (sub_district_id);
  END IF;
END $$;
--rollback ALTER TABLE block_details DROP CONSTRAINT IF EXISTS fk_block_details_sub_district;

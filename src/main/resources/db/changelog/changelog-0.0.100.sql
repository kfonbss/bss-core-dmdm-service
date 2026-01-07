ALTER TABLE village_types
    ALTER COLUMN is_active DROP DEFAULT;

ALTER TABLE village_types
DROP CONSTRAINT IF EXISTS village_types_is_active_check;

ALTER TABLE village_types
ALTER COLUMN is_active TYPE BOOLEAN
USING is_active = 1;

ALTER TABLE village_types
    ALTER COLUMN is_active SET DEFAULT true;

ALTER TABLE village_types
    ALTER COLUMN is_active SET NOT NULL;

ALTER TABLE village_types
    RENAME COLUMN create_date TO created_date;

ALTER TABLE village_types
    RENAME COLUMN update_date TO modified_date;

ALTER TABLE village_types
    ADD COLUMN created_by UUID,
    ADD COLUMN modified_by UUID;

ALTER TABLE block_details
    RENAME COLUMN create_date TO created_date;

ALTER TABLE block_details
    RENAME COLUMN update_date TO modified_date;

ALTER TABLE block_details
ALTER COLUMN village_name TYPE VARCHAR(256);

ALTER TABLE block_details
ALTER COLUMN block_name TYPE VARCHAR(256);


ALTER TABLE block_details
    ALTER COLUMN is_active SET NOT NULL;

ALTER TABLE block_details
    ALTER COLUMN is_active SET DEFAULT true;

ALTER TABLE block_details
    ADD COLUMN created_by UUID,
    ADD COLUMN modified_by UUID;

ALTER TABLE block_details
    ADD COLUMN district_entity UUID;

ALTER TABLE block_details
    ADD CONSTRAINT fk_block_details_district
        FOREIGN KEY (district_entity)
            REFERENCES district (district_id);





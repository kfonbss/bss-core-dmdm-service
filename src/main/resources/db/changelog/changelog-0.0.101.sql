ALTER TABLE district
    ADD COLUMN created_date TIMESTAMP,
ADD COLUMN modified_date TIMESTAMP,
ADD COLUMN created_by UUID,
ADD COLUMN modified_by UUID;


ALTER TABLE pincode_details
    ADD COLUMN district_id UUID;


ALTER TABLE pincode_details
    ADD CONSTRAINT fk_pincode_details_district_uuid
        FOREIGN KEY (district_id)
            REFERENCES district(district_id);


UPDATE pincode_details pd
SET district_id = d.district_id
    FROM district d
WHERE pd.district IS NOT NULL
  AND d.name IS NOT NULL
  AND LOWER(pd.district) = LOWER(d.name);

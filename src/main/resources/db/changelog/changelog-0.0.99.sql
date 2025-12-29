ALTER TABLE pincodes
    ADD COLUMN district_id UUID;

UPDATE pincodes p
SET district_id = d.district_id
    FROM district d
WHERE LOWER(p.district) = LOWER(d.name)
  AND p.district_id IS NULL;


ALTER TABLE pincodes
    ADD CONSTRAINT fk_pincodes_district
        FOREIGN KEY (district_id)
            REFERENCES district(district_id);

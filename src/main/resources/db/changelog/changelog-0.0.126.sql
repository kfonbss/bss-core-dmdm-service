--liquibase formatted sql

--changeset kfonbss:0.0.126-district-census-lgd-codes
-- Location master normalisation (legacy billing_master STATE_DIST_SUBDIST_BLOCK + district_village_details).
-- census_code = district code used in the legacy billing_master tables (Census DTCode)
-- lgd_code    = Govt. Local Government Directory district code
-- Both are needed to link the sub-district / block / village masters to district.
-- District rows for the other states are loaded by schema/district_seed_all_india.sql (not here).
ALTER TABLE district ADD COLUMN IF NOT EXISTS census_code VARCHAR(10);
ALTER TABLE district ADD COLUMN IF NOT EXISTS lgd_code VARCHAR(10);

--changeset kfonbss:0.0.126-district-kerala-state-code
-- District.state is joined on district.state_code = state.code, and Kerala's state.code is '32'
-- (changelog-0.0.102), so the Kerala rows stored as 'KL' never resolved their state and the
-- district-by-state API returned nothing for Kerala. Lakshadweep stays 'LD' (its state.code is 'LD').
-- The circle queries that are called with 'KL' map it to '32' through invoice_statecode.
UPDATE district d
SET state_code = '32', census_code = v.census_code, lgd_code = v.lgd_code, modified_date = NOW()
FROM (VALUES
  ('Thiruvananthapuram', '601', '565'), ('Kollam', '600', '559'), ('Pathanamthitta', '599', '564'),
  ('Alappuzha', '598', '554'), ('Kottayam', '597', '560'), ('Idukki', '596', '556'),
  ('Ernakulam', '595', '555'), ('Thrissur', '594', '566'), ('Palakkad', '593', '563'),
  ('Malappuram', '592', '562'), ('Kozhikode', '591', '561'), ('Wayanad', '590', '567'),
  ('Kannur', '589', '557'), ('Kasaragod', '588', '558')
) AS v(name, census_code, lgd_code)
WHERE d.state_code IN ('KL', '32') AND d.name = v.name;
--rollback UPDATE district SET state_code = 'KL', census_code = NULL, lgd_code = NULL WHERE state_code = '32';

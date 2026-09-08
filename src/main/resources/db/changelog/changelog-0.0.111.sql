DROP TABLE IF EXISTS gateway_locations CASCADE;

CREATE TABLE gateway_locations (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  state_code VARCHAR(10) NOT NULL,
  district VARCHAR(100),
  gatewayname VARCHAR(100),
  status INT DEFAULT 0,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_date TIMESTAMP
);

CREATE INDEX idx_gateway_locations_state_code ON gateway_locations(state_code);

INSERT INTO gateway_locations (state_code, district, gatewayname, status, created_date, updated_date) VALUES
  ('33', 'Chennai', 'Chennai', 1, '2022-04-28 23:48:22', NULL),
  ('27', 'Mumbai',  'Mumbai',  1, '2022-04-28 23:48:23', NULL),
  ('7',  'Delhi',   'Delhi',   1, '2022-04-28 23:48:23', NULL),
  ('19', 'Kolkata', 'Kolkata', 1, '2022-04-28 23:48:23', NULL);

DROP TABLE IF EXISTS state_district CASCADE;

CREATE TABLE state_district (
  district_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id BIGSERIAL,
  statename VARCHAR(64),
  stcode CHAR(5),
  dtname VARCHAR(64),
  statecode CHAR(3),
  districtcode VARCHAR(45)
);

CREATE INDEX idx_state_district_stcode ON state_district (stcode);
CREATE INDEX idx_state_district_statecode ON state_district (statecode);

DROP TABLE IF EXISTS api_configuration_details CASCADE;

CREATE TABLE api_configuration_details (
  details_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  api_id int NOT NULL,
  endpoint varchar(300) DEFAULT NULL,
  s_key varchar(300) DEFAULT NULL,
  workplace varchar(300) DEFAULT NULL,
  updated_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_active boolean NOT NULL DEFAULT true,
  CONSTRAINT pk_api_configuration_details PRIMARY KEY (details_id)
);

CREATE UNIQUE INDEX idx_api_id ON api_configuration_details (api_id);

DROP TABLE IF EXISTS apikeys CASCADE;

CREATE TABLE apikeys (
  keys_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  user_id int NOT NULL,
  apikey varchar(40) NOT NULL,
  level int NOT NULL,
  ignore_limits boolean NOT NULL DEFAULT false,
  is_private_key boolean NOT NULL DEFAULT false,
  ip_addresses text DEFAULT NULL,
  date_created int NOT NULL,
  CONSTRAINT pk_apikeys PRIMARY KEY (keys_id)
);

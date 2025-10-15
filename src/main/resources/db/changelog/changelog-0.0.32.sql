DROP TABLE IF EXISTS badusers CASCADE;


CREATE TABLE badusers (
  badusers_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  UserName varchar(30) DEFAULT NULL,
  IncidentDate timestamp NOT NULL DEFAULT '1970-01-01 00:00:00',
  Reason varchar(200) DEFAULT NULL,
  Admin varchar(30) DEFAULT '-'
);

CREATE INDEX UserName_idx ON badusers (UserName);
CREATE INDEX IncidentDate_idx ON badusers (IncidentDate);
COMMENT ON COLUMN badusers.badusers_id IS 'Unique identifier for bad users records';


DROP TABLE IF EXISTS bandwidth CASCADE;

CREATE TABLE bandwidth (
  bandwidth_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  bandwidth int DEFAULT NULL,
  description varchar(64) DEFAULT NULL,
  radius_profile varchar(64) DEFAULT NULL
);

COMMENT ON COLUMN bandwidth.bandwidth_id IS 'Unique identifier for bandwidth records';


DROP TABLE IF EXISTS bank_details CASCADE;

CREATE TABLE bank_details (
  id UUID PRIMARY KEY NOT NULL,
  bank_id BIGSERIAL,
  bank_name varchar(100) NOT NULL,
  bank_ifsc_code varchar(100) NOT NULL,
  bank_micr varchar(100) NOT NULL,
  bank_branch varchar(100) NOT NULL,
  bank_address varchar(250) NOT NULL,
  bank_contact int NOT NULL,
  bank_city varchar(150) NOT NULL,
  bank_district varchar(150) NOT NULL,
  bank_state varchar(150) NOT NULL
);

CREATE INDEX bank_ifsc_code_idx ON bank_details (bank_ifsc_code);
COMMENT ON COLUMN bank_details.id IS 'Unique identifier for bank details records';

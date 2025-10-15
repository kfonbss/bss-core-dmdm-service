DROP TABLE IF EXISTS access CASCADE;

CREATE TABLE access (
  access_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  apikey varchar(40) NOT NULL DEFAULT '',
  all_access boolean NOT NULL DEFAULT false,
  controller varchar(50) NOT NULL DEFAULT '',
  date_created timestamp DEFAULT NULL,
  date_modified timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN access.access_id IS 'Unique identifier for access records';


DROP TABLE IF EXISTS accessgroup CASCADE;

CREATE TABLE accessgroup (
  group_id UUID PRIMARY KEY NOT NULL,
  accessgroupid SERIAL,
  accessname varchar(45) NOT NULL,
  accesstypeid int NOT NULL,
  connectiontypeid int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX Index_3 ON accessgroup (accesstypeid);
COMMENT ON COLUMN accessgroup.group_id IS 'Unique identifier for access group records';


DROP TABLE IF EXISTS accesstype CASCADE;

CREATE TABLE accesstype (
  type_id UUID PRIMARY KEY NOT NULL,
  accesstypeid SERIAL,
  accesstype varchar(45) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  attribute varchar(45) NOT NULL DEFAULT 'NAS-Port-Type'
);

CREATE UNIQUE INDEX Index_2 ON accesstype (accesstype);
COMMENT ON COLUMN accesstype.type_id IS 'Unique identifier for access type records';

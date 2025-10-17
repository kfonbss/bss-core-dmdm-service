DROP TABLE IF EXISTS access CASCADE;

CREATE TABLE access (
  access_id UUID NOT NULL,
  id SERIAL,
  apikey varchar(40) NOT NULL DEFAULT '',
  all_access boolean NOT NULL DEFAULT false,
  controller varchar(50) NOT NULL DEFAULT '',
  date_created timestamp DEFAULT NULL,
  date_modified timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_access PRIMARY KEY (access_id)
);


DROP TABLE IF EXISTS accessgroup CASCADE;

CREATE TABLE accessgroup (
  group_id UUID NOT NULL,
  accessgroupid SERIAL,
  accessname varchar(45) NOT NULL,
  accesstypeid int NOT NULL,
  connectiontypeid int NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_accessgroup PRIMARY KEY (group_id)
);

CREATE INDEX idx_accessgroup_accesstypeid  ON accessgroup (accesstypeid);


DROP TABLE IF EXISTS accesstype CASCADE;

CREATE TABLE accesstype (
  type_id UUID NOT NULL,
  accesstypeid SERIAL,
  accesstype varchar(45) NOT NULL,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  attribute varchar(45) NOT NULL DEFAULT 'NAS-Port-Type'
);

CREATE UNIQUE INDEX idx_accesstype_accesstype  ON accesstype (accesstype);

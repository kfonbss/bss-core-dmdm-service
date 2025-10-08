DROP TABLE IF EXISTS actonrecharge CASCADE;

CREATE TABLE actonrecharge (
  actonrecharge_id UUID PRIMARY KEY NOT NULL,
  rechargeid BIGSERIAL,
  subscriberid int NOT NULL,
  recieptdate timestamp NOT NULL,
  iscomplete int NOT NULL DEFAULT 0
);

COMMENT ON COLUMN actonrecharge.actonrecharge_id IS 'Unique identifier for act on recharge records';


DROP TABLE IF EXISTS addl_data_plans CASCADE;

CREATE TABLE addl_data_plans (
  addl_data_plans_id UUID PRIMARY KEY NOT NULL,
  planid SERIAL,
  plan varchar(64) DEFAULT NULL,
  planfee decimal(10,2) DEFAULT NULL,
  maxvolume int DEFAULT NULL,
  plantype int DEFAULT NULL,
  status smallint DEFAULT NULL,
  create_date timestamp DEFAULT NULL
);

COMMENT ON COLUMN addl_data_plans.addl_data_plans_id IS 'Unique identifier for additional data plans records';

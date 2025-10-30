DROP TABLE IF EXISTS actonrecharge CASCADE;

CREATE TABLE actonrecharge (
  recharge_id UUID DEFAULT gen_random_uuid() NOT NULL,
  rechargeid BIGSERIAL,
  subscriberid int NOT NULL,
  recieptdate timestamp NOT NULL,
  iscomplete int NOT NULL DEFAULT 0,
  CONSTRAINT pk_actonrecharge PRIMARY KEY (recharge_id)
);


DROP TABLE IF EXISTS addl_data_plans CASCADE;

CREATE TABLE addl_data_plans (
  plans_id UUID DEFAULT gen_random_uuid() NOT NULL,
  planid SERIAL,
  plan varchar(64) DEFAULT NULL,
  planfee decimal(10,2) DEFAULT NULL,
  maxvolume int DEFAULT NULL,
  plantype int DEFAULT NULL,
  status smallint DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  CONSTRAINT pk_addl_data_plans PRIMARY KEY (plans_id)
);


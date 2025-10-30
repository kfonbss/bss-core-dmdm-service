DROP TABLE IF EXISTS anp_field_engg CASCADE;

CREATE TABLE anp_field_engg (
  engg_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  emp_id varchar(10) DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  import_flag int DEFAULT NULL,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_anp_field_engg PRIMARY KEY (engg_id)
);


DROP TABLE IF EXISTS anp_users CASCADE;

CREATE TABLE anp_users (
  anp_users_id UUID DEFAULT gen_random_uuid() NOT NULL,
  user_id SERIAL,
  user_name varchar(64) DEFAULT NULL,
  emp_name varchar(150) DEFAULT NULL,
  phone bigint DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(150) DEFAULT NULL,
  last_update timestamp NOT NULL,
  role varchar(45) NOT NULL,
  partnerid bigint DEFAULT NULL,
  CONSTRAINT pk_anp_users PRIMARY KEY (anp_users_id)
);


DROP TABLE IF EXISTS anpfeedback CASCADE;

CREATE TABLE anpfeedback (
  feedback_id UUID DEFAULT gen_random_uuid() NOT NULL,
  id SERIAL,
  discription varchar(50) DEFAULT NULL,
  score int DEFAULT NULL,
  CONSTRAINT pk_anpfeedback PRIMARY KEY (feedback_id)
);
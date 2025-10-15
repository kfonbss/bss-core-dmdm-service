DROP TABLE IF EXISTS anp_field_engg CASCADE;

CREATE TABLE anp_field_engg (
  engg_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  emp_id varchar(10) DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  create_date timestamp DEFAULT CURRENT_TIMESTAMP,
  import_flag int DEFAULT NULL,
  update_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN anp_field_engg.engg_id IS 'Unique identifier for ANP field engineer records';


DROP TABLE IF EXISTS anp_users CASCADE;

CREATE TABLE anp_users (
  anp_users_id UUID PRIMARY KEY NOT NULL,
  user_id SERIAL,
  user_name varchar(64) DEFAULT NULL,
  emp_name varchar(150) DEFAULT NULL,
  phone bigint DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  password varchar(150) DEFAULT NULL,
  last_update timestamp NOT NULL,
  role varchar(45) NOT NULL,
  partnerid bigint DEFAULT NULL
);

COMMENT ON COLUMN anp_users.anp_users_id IS 'Unique identifier for ANP users records';


DROP TABLE IF EXISTS anpfeedback CASCADE;

CREATE TABLE anpfeedback (
  feedback_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  discription varchar(50) DEFAULT NULL,
  score int DEFAULT NULL
);

COMMENT ON COLUMN anpfeedback.feedback_id IS 'Unique identifier for ANP feedback configuration records';

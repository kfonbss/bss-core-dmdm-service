DROP TABLE IF EXISTS approvestatus CASCADE;

CREATE TABLE approvestatus (
  id UUID NOT NULL,
  slno SERIAL,
  status varchar(25) DEFAULT NULL,
  status_id int DEFAULT NULL,
  CONSTRAINT pk_approvestatus PRIMARY KEY (id)
);


DROP TABLE IF EXISTS atom_refund_details CASCADE;

CREATE TABLE atom_refund_details (
  details_id UUID NOT NULL,
  id SERIAL,
  orderid int DEFAULT NULL,
  orderd_sate_code varchar(100) DEFAULT NULL,
  billing_state_code varchar(100) DEFAULT NULL,
  order_time timestamp DEFAULT NULL,
  txndate timestamp DEFAULT NULL,
  username varchar(100) DEFAULT NULL,
  subscriberid int DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  ordernumber varchar(64) DEFAULT NULL,
  txnid varchar(64) DEFAULT NULL,
  amount decimal(13,2) DEFAULT NULL,
  txnamout decimal(13,2) DEFAULT NULL,
  status_bss char(18) DEFAULT NULL,
  status_atom char(18) DEFAULT NULL,
  reason_for_refund varchar(250) DEFAULT NULL,
  refund_requested_by varchar(50) DEFAULT NULL,
  refund_requested_time timestamp DEFAULT NULL,
  refund_requested_status int DEFAULT 0,
  refund_approved_by varchar(50) DEFAULT NULL,
  refund_initiated_time timestamp DEFAULT NULL,
  refund_txn_id varchar(60) DEFAULT NULL,
  refund_message varchar(60) DEFAULT NULL,
  CONSTRAINT pk_atom_refund_details PRIMARY KEY (details_id)
);

COMMENT ON COLUMN atom_refund_details.refund_requested_status IS '0=Means Not Forworded to RONOC Fin,1=Forworded to RONOC Fin ,2=Means Refund Intiated';


DROP TABLE IF EXISTS atommerchantdetail CASCADE;

CREATE TABLE atommerchantdetail (
  detail_id UUID NOT NULL,
  id SERIAL,
  merchanttid varchar(45) NOT NULL,
  merchantpassword varchar(45) NOT NULL,
  status boolean NOT NULL,
  reqhascode varchar(150) DEFAULT NULL,
  reqenctype varchar(150) DEFAULT NULL,
  reqsalt varchar(150) DEFAULT NULL,
  responsehascode varchar(150) DEFAULT NULL,
  responseenctype varchar(150) DEFAULT NULL,
  responsesalt varchar(150) DEFAULT NULL,
  config_type varchar(10) DEFAULT NULL,
  region varchar(10) DEFAULT NULL,
  CONSTRAINT pk_atommerchantdetail PRIMARY KEY (detail_id)
);


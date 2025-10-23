DROP TABLE IF EXISTS billdesk CASCADE;

CREATE TABLE billdesk (
  desk_id UUID NOT NULL,
  id BIGSERIAL,
  ORDERNUMBER varchar(45) NOT NULL,
  status varchar(45) NOT NULL DEFAULT 'PENDING',
  amount decimal(10,2) NOT NULL,
  order_time timestamp DEFAULT NULL,
  TxnReferenceNo varchar(45) DEFAULT NULL,
  TxnDate timestamp DEFAULT NULL,
  TxnAmount decimal(10,2) DEFAULT NULL,
  AuthStatus_code varchar(45) DEFAULT NULL,
  AuthStatus_desc varchar(250) DEFAULT NULL,
  response_message varchar(600) DEFAULT NULL,
  Reconciliation varchar(45) DEFAULT NULL,
  Reconciliation_date varchar(45) DEFAULT NULL,
  Reconciliation_amount varchar(45) DEFAULT NULL,
  partnerid varchar(45) DEFAULT NULL,
  ErrorStatus varchar(45) DEFAULT NULL,
  ErrorDescription varchar(350) DEFAULT NULL,
  ChecksumStatus varchar(45) DEFAULT NULL,
  updatelock int NOT NULL DEFAULT 0,
  trans_sync varchar(100) DEFAULT NULL,
  CONSTRAINT pk_billdesk PRIMARY KEY (desk_id)
);

CREATE INDEX order_idx ON billdesk (ORDERNUMBER);


DROP TABLE IF EXISTS billdesk_conf CASCADE;

CREATE TABLE billdesk_conf (
  conf_id UUID NOT NULL,
  id SERIAL,
  MID varchar(45) DEFAULT NULL,
  SECURITYID varchar(45) DEFAULT NULL,
  CHK_KEY varchar(45) DEFAULT NULL,
  STCode char(5) DEFAULT NULL,
  CONSTRAINT pk_billdesk_conf PRIMARY KEY (conf_id)
);

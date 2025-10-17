DROP TABLE IF EXISTS Trai_Reg CASCADE;

CREATE TABLE Trai_Reg (
  reg_id UUID NOT NULL,
  monthpart varchar(10) DEFAULT NULL,
  regcount int DEFAULT NULL,
  state varchar(5) DEFAULT NULL,
  CONSTRAINT pk_Trai_Reg PRIMARY KEY (reg_id)
);


DROP TABLE IF EXISTS Trai_Sub CASCADE;

CREATE TABLE Trai_Sub (
  sub_id UUID NOT NULL,
  monthpart varchar(10) DEFAULT NULL,
  subcount int DEFAULT NULL,
  state varchar(5) DEFAULT NULL,
  CONSTRAINT pk_Trai_Sub PRIMARY KEY (sub_id)
);


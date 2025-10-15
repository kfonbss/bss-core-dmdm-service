DROP TABLE IF EXISTS Trai_Reg CASCADE;

CREATE TABLE Trai_Reg (
  reg_id UUID PRIMARY KEY NOT NULL,
  monthpart varchar(10) DEFAULT NULL,
  regcount int DEFAULT NULL,
  state varchar(5) DEFAULT NULL
);

COMMENT ON COLUMN Trai_Reg.reg_id IS 'Unique identifier for TRAI registration records';


DROP TABLE IF EXISTS Trai_Sub CASCADE;

CREATE TABLE Trai_Sub (
  sub_id UUID PRIMARY KEY NOT NULL,
  monthpart varchar(10) DEFAULT NULL,
  subcount int DEFAULT NULL,
  state varchar(5) DEFAULT NULL
);

COMMENT ON COLUMN Trai_Sub.sub_id IS 'Unique identifier for TRAI subscription records';

-- Table: gateway
DROP TABLE IF EXISTS gateway CASCADE;

CREATE TABLE gateway (
  gateway_id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  id INT,
  code VARCHAR(10),
  type VARCHAR(50),
  gateid INT
);

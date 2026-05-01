DROP TABLE IF EXISTS streetbox_location CASCADE;

CREATE TABLE streetbox_location (

                                    id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,

                                    equipment_name VARCHAR(100),
                                    pop_name VARCHAR(100),
                                    district VARCHAR(25),
                                    pop_type VARCHAR(100),

                                    latitude DECIMAL(10,8),
                                    longitude DECIMAL(10,8),

                                    type VARCHAR(100),
                                    category VARCHAR(50),

                                    snum SERIAL,
                                    UNIQUE (snum)

);
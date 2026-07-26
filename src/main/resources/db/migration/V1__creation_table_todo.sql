CREATE TABLE todo (
                      id UUID NOT NULL,
                      title VARCHAR(255)  ,
                       created_at TIMESTAMP  DEFAULT now(),
                        update_at TIMESTAMP  DEFAULT now(),
                        description VARCHAR(255),
                        completed BOOLEAN NOT NULL DEFAULT FALSE
);
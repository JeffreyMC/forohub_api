CREATE TABLE usuario (
                         id SERIAL PRIMARY KEY,
                         username VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL
);

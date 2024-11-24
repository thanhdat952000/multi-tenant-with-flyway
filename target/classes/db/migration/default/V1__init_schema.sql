CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE agency
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    tenant_id varchar(255) NOT NULL
);
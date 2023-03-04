CREATE TABLE cities (
    ibge_code integer NOT NULL,
    name character varying(80),
    state character varying(2),
    CONSTRAINT cities_pkey PRIMARY KEY (ibge_code)
);
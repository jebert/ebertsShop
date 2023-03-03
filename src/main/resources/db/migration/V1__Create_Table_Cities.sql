CREATE TABLE cities (
    ibge_code integer NOT NULL,
    name character varying(120),
    state character varying(5),
    CONSTRAINT cities_pkey PRIMARY KEY (ibge_code)
);
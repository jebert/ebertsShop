CREATE TABLE cities (
    ibge_code integer NOT NULL,
    name character varying(120),
    state character varying(5)
);

ALTER TABLE cities OWNER TO postgres;

ALTER TABLE ONLY cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (ibge_code);
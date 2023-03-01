CREATE TABLE IF NOT EXISTS addresses
(
    id uuid NOT NULL,
    complement character varying(255) ,
    delivery_address boolean NOT NULL,
    district character varying(255),
    "number" character varying(25),
    street character varying(255),
    zip character varying(10),
    ibge_code integer,
    CONSTRAINT addresses_pkey PRIMARY KEY (id),
    CONSTRAINT city_pkey FOREIGN KEY (ibge_code)
        REFERENCES public.cities (ibge_code) MATCH SIMPLE
)

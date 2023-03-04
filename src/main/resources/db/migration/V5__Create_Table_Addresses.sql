CREATE TABLE addresses (
    id uuid NOT NULL,
    ibge_code integer,
    complement character varying(255),
    delivery_address boolean NOT NULL,
    district character varying(255),
    number character varying(255) NOT NULL,
    street character varying(255),
    zip character varying(255) NOT NULL,
    CONSTRAINT addresses_pkey PRIMARY KEY (id)
);

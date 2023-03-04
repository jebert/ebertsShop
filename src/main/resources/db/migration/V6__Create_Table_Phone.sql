CREATE TABLE phone (
    id uuid NOT NULL,
    is_whats_app boolean,
    ddd integer,
    number character varying(10),
    phone_type integer,
    CONSTRAINT phone_pkey PRIMARY KEY (id)
);

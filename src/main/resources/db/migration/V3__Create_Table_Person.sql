CREATE TABLE IF NOT EXISTS person
(
    id uuid NOT NULL,
    email character varying(30),
    name character varying(120),
    CONSTRAINT person_pkey PRIMARY KEY (id)
)

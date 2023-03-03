CREATE TABLE public.phones (
    id uuid NOT NULL,
    is_whats_app boolean,
    number character varying(10),
    phone_type integer,
    owner_id uuid,
    CONSTRAINT phone_pkey PRIMARY KEY (id)
);

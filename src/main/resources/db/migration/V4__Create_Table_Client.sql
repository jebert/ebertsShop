CREATE TABLE IF NOT EXISTS clients
(
    gender character varying(10) ,
    last_name character varying(30),
    password character varying(255),
    user_name character varying(30),
    id uuid NOT NULL,
    CONSTRAINT clients_pkey PRIMARY KEY (id)
)
CREATE TABLE IF NOT EXISTS clients
(
    gender character varying(10) ,
    last_name character varying(30),
    password character varying(255),
    user_name character varying(30),
    id uuid NOT NULL,
    client_id uuid,
    CONSTRAINT clients_pkey PRIMARY KEY (id),
    CONSTRAINT fk_person_id FOREIGN KEY (id) REFERENCES person (id)
)
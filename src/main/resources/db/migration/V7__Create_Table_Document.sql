CREATE TABLE IF NOT EXISTS document
(
    id uuid NOT NULL,
    doc_type character varying(5),
    document character varying(30),
    CONSTRAINT document_pkey PRIMARY KEY (id)
)

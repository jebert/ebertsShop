CREATE TABLE IF NOT EXISTS documents
(
    id uuid NOT NULL,
    doc_type character varying(255),
    document character varying(255),
    CONSTRAINT document_pkey PRIMARY KEY (id)
)

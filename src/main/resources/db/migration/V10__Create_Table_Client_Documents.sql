CREATE TABLE IF NOT EXISTS clients_documents
(
    client_id uuid NOT NULL,
    documents_id uuid NOT NULL,
    CONSTRAINT uk_documents UNIQUE (documents_id),
    CONSTRAINT fk_documents_id FOREIGN KEY (documents_id)
        REFERENCES documents (id) MATCH SIMPLE,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id)
        REFERENCES clients (id) MATCH SIMPLE
)
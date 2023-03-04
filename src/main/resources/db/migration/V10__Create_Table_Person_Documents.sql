CREATE TABLE public.person_documents (
    person_id uuid NOT NULL,
    documents_id uuid NOT NULL,
    CONSTRAINT uk_person_documents UNIQUE (documents_id),
    CONSTRAINT fk_p_d_documents_id FOREIGN KEY (documents_id) REFERENCES public.document(id),
    CONSTRAINT fk_p_d_person_id FOREIGN KEY (person_id) REFERENCES public.person(id)
    
);

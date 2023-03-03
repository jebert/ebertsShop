CREATE TABLE public.person_phones (
    person_id uuid NOT NULL,
    phones_id uuid NOT NULL,
    CONSTRAINT uk_phones_id UNIQUE (phones_id)
);

ALTER TABLE ONLY public.person_phones
    ADD CONSTRAINT fk_phones_id FOREIGN KEY (phones_id) REFERENCES public.phones(id);

ALTER TABLE ONLY public.person_phones
    ADD CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES public.person(id);

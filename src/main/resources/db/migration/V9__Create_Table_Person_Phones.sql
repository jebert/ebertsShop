CREATE TABLE public.person_phones (
    person_id uuid NOT NULL,
    phones_id uuid NOT NULL,
    CONSTRAINT fk_p_p_phones_id FOREIGN KEY (phones_id) REFERENCES public.phone(id),
    CONSTRAINT fk_p_p_person_id FOREIGN KEY (person_id) REFERENCES public.person(id)
);
CREATE TABLE public.person_addresses (
    person_id uuid NOT NULL,
    addresses_id uuid NOT NULL,
    CONSTRAINT uk_person_addresses UNIQUE (addresses_id),
    CONSTRAINT fk_p_a_address_id FOREIGN KEY (addresses_id) REFERENCES public.addresses(id),
    CONSTRAINT fk_p_a_person_id FOREIGN KEY (person_id) REFERENCES public.person(id)
);
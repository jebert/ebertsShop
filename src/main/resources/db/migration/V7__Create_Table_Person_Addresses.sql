CREATE TABLE public.person_addresses (
    person_id uuid NOT NULL,
    addresses_id uuid NOT NULL,
    CONSTRAINT uk_unique_address UNIQUE (addresses_id)
);

ALTER TABLE ONLY public.person_addresses
    ADD CONSTRAINT fk_address_id FOREIGN KEY (addresses_id) REFERENCES public.addresses(id);


ALTER TABLE ONLY public.person_addresses
    ADD CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES public.person(id);

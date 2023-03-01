package com.eberts.shop.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eberts.shop.models.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}

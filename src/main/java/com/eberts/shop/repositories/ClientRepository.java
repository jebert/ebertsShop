package com.eberts.shop.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eberts.shop.models.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

	@Query("FROM Client c WHERE lower(c.name) like lower(concat('%', :clientName,'%'))")
	Page<Client> findClientByNameIgnoreCase(
            @Param("clientName") String cityName, 
            Pageable pageable);

}

package com.eberts.shop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eberts.shop.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("FROM City c WHERE lower(c.name) like lower(concat('%', :cityName,'%'))")
     Page<City> findCityByNameIgnoreCase(
             @Param("cityName") String cityName, 
             Pageable pageable);
    
    @Query("FROM City c where c.state = :state AND lower(c.name) like lower(concat('%', :cityName,'%'))")
    Page<City> findCityByStateIgnoreCase(
            @Param("cityName") String cityName, 
            @Param("state") String state, 
            Pageable pageable);
	
}

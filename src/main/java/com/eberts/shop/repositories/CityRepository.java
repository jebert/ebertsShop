package com.eberts.shop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eberts.shop.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("FROM City c WHERE c.name like %:cityName%")
     Page<City> findCityByName(
             @Param("cityName") String cityName, 
             Pageable pageable);
	

}

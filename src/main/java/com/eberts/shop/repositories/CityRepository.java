package com.eberts.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eberts.shop.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}

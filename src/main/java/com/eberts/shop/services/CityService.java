package com.eberts.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eberts.shop.models.City;
import com.eberts.shop.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public CityService() {}

	public List<City> findAllCitys() {
		return cityRepository.findAll();
	}
	
	public Page<City> findPage(Integer page, Integer linesPerPage, String direction, String order ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , order);	
		
		return cityRepository.findAll(pageRequest);
	}
	
	public Page<City> findCityByName(String name, Integer page, Integer linesPerPage, String direction, String order){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , order);	
		return cityRepository.findCityByName(name, pageRequest);
	}

}

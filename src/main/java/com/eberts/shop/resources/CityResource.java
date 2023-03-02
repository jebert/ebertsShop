package com.eberts.shop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.services.CityService;

@RestController
@RequestMapping(value = "city")
public class CityResource {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping(value = "/{state}/{name}")
	public ResponseEntity<?> findCitiesByStateAndName(
			@PathVariable String state,
			@PathVariable String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5")  Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC")  String direction,
			@RequestParam(value = "orderBy", defaultValue = "name")  String orderBy
			
			) {
		//String name, String state, Integer page, Integer linesPerPage, String direction, String order
		return ResponseEntity.ok(cityService.findCityByNameAndState(name, state, page, linesPerPage, direction, orderBy));
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<?> findAllCitiesByState(
			@PathVariable String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5")  Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC")  String direction,
			@RequestParam(value = "orderBy", defaultValue = "name")  String orderBy
			
			) {
		//String name, String state, Integer page, Integer linesPerPage, String direction, String order
		return ResponseEntity.ok(cityService.findCityByName(name, page, linesPerPage, direction, orderBy));
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCities(
			@PathVariable String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5")  Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC")  String direction,
			@RequestParam(value = "orderBy", defaultValue = "name")  String orderBy
			
			) {
		//String name, String state, Integer page, Integer linesPerPage, String direction, String order
		return ResponseEntity.ok(cityService.findCityByName(name, page, linesPerPage, direction, orderBy));
	}

}

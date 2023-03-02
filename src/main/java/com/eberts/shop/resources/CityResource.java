package com.eberts.shop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.models.City;
import com.eberts.shop.services.CityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "city")
@Tag(name = "City", description = "Endpoints to Manage Cities")
public class CityResource {

	@Autowired
	private CityService cityService;

	@GetMapping(value = "/{state}/{name}", produces = { "application/json" })
	@Operation(summary = "Find Cities by Name and State", tags = "City", responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = {
							@Content(mediaType = "application/json", 
							array = @ArraySchema(schema = @Schema(implementation = City.class)))
			}
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> findCitiesByStateAndName(@PathVariable String state, @PathVariable String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy

	) {
		// String name, String state, Integer page, Integer linesPerPage, String
		// direction, String order
		return ResponseEntity
				.ok(cityService.findCityByNameAndState(name, state, page, linesPerPage, direction, orderBy));
	}

	@GetMapping(value = "/{name}", produces = { "application/json" })
	@Operation(summary = "Find Cities By Name", tags = "City", responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = {
							@Content(mediaType = "application/json", 
							array = @ArraySchema(schema = @Schema(implementation = City.class)))
			}
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> findAllCitiesByState(@PathVariable String name,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy

	) {
		// String name, String state, Integer page, Integer linesPerPage, String
		// direction, String order
		return ResponseEntity.ok(cityService.findCityByName(name, page, linesPerPage, direction, orderBy));
	}

	@GetMapping(produces = { "application/json" })
	@Operation(summary = "Find All Cities", tags = "City", responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = {
							@Content(mediaType = "application/json", 
							array = @ArraySchema(schema = @Schema(implementation = City.class)))
			}
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> findAllCities(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy

	) {
		// String name, String state, Integer page, Integer linesPerPage, String
		// direction, String order
		return ResponseEntity.ok(cityService.findPage(page, linesPerPage, direction, orderBy));
	}

}

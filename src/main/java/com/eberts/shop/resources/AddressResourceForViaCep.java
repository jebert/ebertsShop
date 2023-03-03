package com.eberts.shop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.models.Address;
import com.eberts.shop.services.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "cep")
@Tag(name = "ViaCep", description = "Endpoints to Get Address by ViaCep API")
public class AddressResourceForViaCep {

	@Autowired
	private AddressService addressService;

	@GetMapping(value = "/{cep}", produces = "application/json")
	@Operation(summary = "Find an Address by its CEP", tags = "ViaCep", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Address.class)) }),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> findAddressByCep(@PathVariable String cep) {

		return ResponseEntity.ok(addressService.findAddressByCep(cep));
	}

	
	@GetMapping( produces = "application/json")
	@Operation(summary = "Find CEPs by a Partial Address", tags = "ViaCep", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Address.class))) }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> getCepByAddressPartial(@RequestParam(value = "state", defaultValue = "RS") String state,
			@RequestParam(value = "city", defaultValue = "Sapiranga") String city,
			@RequestParam(value = "street") String street) {

		return ResponseEntity.ok(addressService.getAddressByAddressPartial(state, city, street));
	}

}

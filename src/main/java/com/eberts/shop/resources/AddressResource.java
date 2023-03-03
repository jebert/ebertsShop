package com.eberts.shop.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.models.Address;
import com.eberts.shop.models.vo.AddressVo;
import com.eberts.shop.services.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "address")
@Tag(name = "Address", description = "Endpoints to Manage Addresses")
public class AddressResource {

	@Autowired
	private AddressService addressService;


	@GetMapping(value = "/{uuid}", produces = "application/json")
	@Operation(summary = "Find an Address by UUID", tags = "Address", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Address.class)) }),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> findAddressByUUID(@PathVariable UUID uuid) {

		return ResponseEntity.ok(addressService.findAddressById(uuid).get());
	}
	
	@GetMapping( produces = "application/json")
	@Operation(summary = "Find all Saved Address", tags = "Address", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Address.class)) }),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> findAllAddresses() {

		return ResponseEntity.ok(addressService.findAllAddresss());
	}
	


	@PostMapping(consumes = "application/json", produces = "application/json")
	@Operation(summary = "Save an Address", tags = "Address", responses = {
			@ApiResponse(description = "Created", responseCode = "201", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Address.class)) }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> saveAddress(@RequestBody @Valid AddressVo addressvo) {
		Address address = addressService.findAddressByCep(addressvo.getCep()).get();
		address.setNumber(addressvo.getNumber());
		address.setDeliveryAddress(addressvo.getDeliveryAddress());
		address.setComplement(addressvo.getComplement());

		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.saveAddress(address));

	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Delete an Address by UUID", tags = "Address", responses = {
			@ApiResponse(description = "No content", responseCode = "203", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> deleteAddress(@PathVariable UUID uuid) {

		addressService.delete(uuid);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Address deleted");

	}
	
	@PutMapping(value = "/{uuid}", consumes = "application/json", produces = "application/json")
	@Operation(summary = "Update an Address", tags = "Address", responses = {
			@ApiResponse(description = "Created", responseCode = "201", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Address.class)) }),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content) })
	public ResponseEntity<?> updateAddress(
			@PathVariable UUID uuid, 
			@RequestBody @Valid AddressVo addressvo) {
		Address newAddress = addressService.findAddressByCep(addressvo.getCep()).get();
		Address address = addressService.findAddressById(uuid).get();
		newAddress.setNumber(addressvo.getNumber());
		newAddress.setDeliveryAddress(addressvo.getDeliveryAddress());
		newAddress.setComplement(addressvo.getComplement());
		newAddress.setId(address.getId());

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(addressService.saveAddress(newAddress));

	}

}

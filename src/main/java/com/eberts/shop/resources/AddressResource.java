package com.eberts.shop.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.models.Address;
import com.eberts.shop.models.vo.AddressVoForSave;
import com.eberts.shop.services.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping(value = "address")
@Tag(name = "Address", description = "Endpoints to Manage Addresses")
public class AddressResource {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping(value = "/cep/{cep}", produces = "application/json")
	@Operation(summary = "Find an Address by its CEP", tags = "Address", responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = {
							@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Address.class))
			}
			),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)
	})
	public ResponseEntity<?> findAddressByCep(@PathVariable String cep) {
		
		return ResponseEntity.ok(addressService.findAddressByCep(cep));
	}
	
	@GetMapping(value = "/cep", produces = "application/json")
	@Operation(summary = "Find CEPs for a Partial Address", tags = "Address", responses = {
			@ApiResponse(description = "Success", responseCode = "200", 
					content = {
							@Content(mediaType = "application/json", 
							array = @ArraySchema(schema = @Schema(implementation = Address.class)))
			}
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)	})
	public ResponseEntity<?> getCepByAddressPartial(
			@RequestParam(value = "state", defaultValue = "RS") String state,
			@RequestParam(value = "city", defaultValue = "Sapiranga") String city,
			@RequestParam(value = "street") String street
			) {
		
		return ResponseEntity.ok(addressService.getAddressByAddressPartial(state, city, street));
	}
	
	@PostMapping
	(consumes = "application/json",
	produces = "application/json" )
	@Operation(summary = "Save an Address", tags = "Address", responses = {
			@ApiResponse(description = "Created", responseCode = "201", 
					content = {
							@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Address.class))
			}
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)	})
	public ResponseEntity<?> saveAddress( @RequestBody AddressVoForSave addressvo ) {
		Address  address = addressService.findAddressByCep(addressvo.getCep()).get();
		address.setNumber(addressvo.getNumber());
		address.setDeliveryAddress(addressvo.getDeliveryAddress());
		address.setComplement(addressvo.getComplement());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.saveAddress(address));
		
	}
	
	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Delete an Address by ID", tags = "Address", responses = {
			@ApiResponse(description = "No content", responseCode = "203", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "403", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content)	})
	public ResponseEntity<?> deleteAddress( @PathVariable UUID uuid ) {

		addressService.delete(uuid);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Address deleted");
		
	}

}

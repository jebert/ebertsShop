package com.eberts.shop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eberts.shop.services.AddressService;



@RestController
@RequestMapping(value = "address")
public class AddressResource {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping(value = "/cep/{cep}")
	public ResponseEntity<?> findAddressByCep(@PathVariable String cep) {
		
		return ResponseEntity.ok(addressService.findAddressByCep(cep));
	}
	
	@GetMapping(value = "/cep")
	public ResponseEntity<?> getCepByAddressPartial(
			@RequestParam(value = "state", defaultValue = "RS") String state,
			@RequestParam(value = "city", defaultValue = "Sapiranga") String city,
			@RequestParam(value = "street") String street
			) {
		
		return ResponseEntity.ok(addressService.getAddressByAddressPartial(state, city, street));
	}

}

package com.eberts.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eberts.shop.models.Address;
import com.eberts.shop.models.City;
import com.eberts.shop.models.vo.AddressVoForViaCep;
import com.eberts.shop.repositories.AddressRepository;
import com.eberts.shop.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public AddressService() {}

	@Transactional
	public Address saveAddress(Address address, String number) {
		if (address.getNumber() == null) 
			address.setNumber(number);
			
		return address = addressRepository.save(address);
	}
	public List<Address> findAllAddresss() {
		return addressRepository.findAll();
	}
	
	public Optional<Address> findAddressById(UUID id) {
		Optional<Address> address = addressRepository.findById(id);
		return Optional.of(address.orElseThrow(()-> new ObjectNotFoundException("Address not found with id:" + id.toString())));
	}
	
	public Optional<AddressVoForViaCep> findAddressByCep(String cep) {
		AddressVoForViaCep x = new RestTemplate().getForEntity("https://viacep.com.br/ws/" +cep+ "/json/", AddressVoForViaCep.class).getBody();
		if(x.getCep() == null) throw new ObjectNotFoundException("CEP: " + cep + " is not valid!");
		return Optional.of(x) ;
	}
	
	public List<AddressVoForViaCep> getAddressByAddressPartial(String state, String city, String street){

		List<AddressVoForViaCep> lista = new ArrayList<>();

		
		AddressVoForViaCep[] lista1 = new RestTemplate()
				.getForEntity("https://viacep.com.br/ws/"+ state +"/" +city+ "/" + street + "/json/", AddressVoForViaCep[].class).getBody();

		for (AddressVoForViaCep add : lista1) {
			AddressVoForViaCep address = new AddressVoForViaCep();
			BeanUtils.copyProperties( add, address);
			lista.add(address);
		}
		 return lista;
	}
	
	public Address convertFromAddressVoForViaCep (AddressVoForViaCep vo) {
		City city = new City(vo.getLocalidade(), vo.getUf(), vo.getIbge());
		return new Address(null, vo.getCep(), vo.getLogradouro(), null, vo.getComplemento(), vo.getBairro(), false, city);
	}
	
}
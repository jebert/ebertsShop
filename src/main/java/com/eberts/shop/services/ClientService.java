package com.eberts.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eberts.shop.models.Address;
import com.eberts.shop.models.Client;
import com.eberts.shop.models.Document;
import com.eberts.shop.models.vo.AddressVo;
import com.eberts.shop.models.vo.ClientVo;
import com.eberts.shop.models.vo.DocumentVo;
import com.eberts.shop.models.vo.PhoneVo;
import com.eberts.shop.repositories.ClientRepository;
import com.eberts.shop.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressService addressService;
	
	public ClientService() {}

	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}
	
	public Optional<Client> findClientById (UUID id){
		Optional<Client> client = clientRepository.findById(id);
		return Optional.of(client.orElseThrow(()-> new ObjectNotFoundException("Client not found with id:" + id.toString())));
	}
	
	@Transactional
	public Client saveClient (Client client) {
		return clientRepository.save(client);
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String direction, String order ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , order);	
		
		Page<Client> p = clientRepository.findAll(pageRequest);
		System.out.println(p);
		return p;
	}
	
	public Page<Client> findClientByName(String name, Integer page, Integer linesPerPage, String direction, String order){
	
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , order);	
		
		Page<Client> p = clientRepository.findClientByNameIgnoreCase(name, pageRequest);

		return p;
	}

	public void delete(UUID uuid) {
		clientRepository.delete(findClientById(uuid).get());		
	}
	
	public Client converFromClientVo (ClientVo clientVo) {
		
		Client client = new Client( null, clientVo.getName(),clientVo.getEmail(),clientVo.getLastName(),clientVo.getUserName(),clientVo.getPassword(),clientVo.getGender());
		
		for (AddressVo addressVo : clientVo.getAddresses()){
			Address address = addressService.ConvertAddressFromVo(addressVo);
			client.getAddresses().add(address);
		}
		
		for (PhoneVo phoneVo : clientVo.getPhones()) {
			client.getPhones().add(phoneVo.convertFromVo(phoneVo));
		}
		
		for (Document doc : clientVo.getDocuments()) {
			client.getDocuments().add(doc);	
		}
		
		return client;

	}
	
}

/*    private UUID id;

    private String name;
	private String lastName;
    private String userName;
    private String email;
    private String password;
    private String gender;
    
	private List<AddressVo> addresses = new ArrayList<>();
    private String cep;
	private String number;
	private String complement;
	private Boolean deliveryAddress;


    private List<PhoneVo> phones = new ArrayList<>();
	private String cep;
	private String number;
	private String complement;
	private Boolean deliveryAddress;

    private List<DocumentVo> documents = new ArrayList<>();
    
    private String document;
	private String docType;
    */
























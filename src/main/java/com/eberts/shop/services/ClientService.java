package com.eberts.shop.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eberts.shop.models.Client;
import com.eberts.shop.models.vo.ClientVo;
import com.eberts.shop.repositories.ClientRepository;
import com.eberts.shop.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService() {}

	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}
	
	public Optional<Client> findClientById (UUID id){
		Optional<Client> client = clientRepository.findById(id);
		return Optional.of(client.orElseThrow(()-> new ObjectNotFoundException("Client not found with id:" + id.toString())));
	}
	
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
	
	public Client converFromClientVo (ClientVo clientVoForSave) {
		
	}
	
}

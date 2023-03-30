package com.eberts.shop.services;


import com.eberts.shop.models.User;
import com.eberts.shop.repositories.UserRepository;
import com.eberts.shop.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService{


	private UserRepository repository;
	@Autowired
	public UserService(UserRepository userRepository) {
		this.repository = userRepository;
	}

	public UserService() {}

	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	public Optional<User> findUserById (UUID id){
		Optional<User> User = repository.findById(id);
		return Optional.of(User.orElseThrow(()-> new ObjectNotFoundException("User not found with id:" + id.toString())));
	}
	
	@Transactional
	public User saveUser (User User) {
		return repository.save(User);
	}
	


	public void delete(UUID uuid) {
		repository.delete(findUserById(uuid).get());
	}

}























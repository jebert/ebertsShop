package com.eberts.shop.services;


import com.eberts.shop.models.User;
import com.eberts.shop.repositories.UserRepository;
import com.eberts.shop.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	public UserService() {}

	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	public Optional<User> findUserById (UUID id){
		Optional<User> User = repository.findById(id);
		return Optional.of(User.orElseThrow(()-> new ObjectNotFoundException("User not found with id:" + id.toString())));
	}

	public User findUserByUsername (String username){
		var user = repository.findByUserName(username);
		return user;
	}
	
	@Transactional
	public User saveUser (User User) {
		return repository.save(User);
	}

	public void delete(UUID uuid) {
		repository.delete(findUserById(uuid).get());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = findUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found"+ username);
		}

		return user;
	}
}























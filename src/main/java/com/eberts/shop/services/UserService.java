package com.eberts.shop.services;


import com.eberts.shop.models.Permission;
import com.eberts.shop.models.User;
import com.eberts.shop.models.vo.UserVo;
import com.eberts.shop.repositories.UserRepository;
import com.eberts.shop.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;

	public UserService() {}

	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	public Optional<User> findUserById (UUID id){
		Optional<User> User = repository.findById(id);
		return Optional.of(User.orElseThrow(()-> new ObjectNotFoundException("User not found with id:" + id)));
	}

	public User findUserByUserName (String username){
		User user = repository.findByUserName(username);
		System.out.println(user);
		return user;
	}
	
	@Transactional
	public User saveUser (User user) {
		return repository.save(user);
	}
	


	public void delete(UUID uuid) {
		repository.delete(findUserById(uuid).get());
	}


	public User convertFromUserVo(UserVo uservo) {
		//UUID id, String userName, String fullName, String password, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled
		User user = new User(null, uservo.getUserName(), uservo.getFullName(), passwordEncoder.encode(uservo.getPassword()),uservo.getAccountNonExpired(),uservo.getAccountNonLocked(),uservo.getCredentialsNonExpired(),uservo.getEnabled() );
		List<Permission> permissions = new ArrayList();
		for (Permission p : uservo.getPermissions()){
			permissions.add(p);
		}
		user.setPermissions(permissions);
		return user;
	}
}























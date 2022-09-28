package com.NMSCinemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NMSCinemas.model.User;
import com.NMSCinemas.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	public User getUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			return userRepository.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	public User updateUser(Long id, User newUser) {
		if(userRepository.findById(id).isPresent()) {
			User oldUser= userRepository.findById(id).get();
			oldUser.setFname(newUser.getFname());
			oldUser.setLname(newUser.getLname());
			oldUser.setEmail(newUser.getEmail());
			oldUser.setPassword(newUser.getPassword());
			
			return userRepository.save(oldUser);
		}
		else {
			return null;
		}
	}
	
	
	public boolean deleteUser(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

}

package com.NMSCinemas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NMSCinemas.model.User;
import com.NMSCinemas.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/user")
		
public class UserController {
		
	 @Autowired
	  UserRepository userRepository;


	  @GetMapping("/find/{id}")
	  public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
	    Optional<User> userData = userRepository.findById(id);

	    if (userData.isPresent()) {
	      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/create")
	  public ResponseEntity<User> createUser(@RequestBody User user) {
	    try {
	      User _user = userRepository
	          .save(new User (user.getFname(), user.getLname(), user.getEmail(), user.getPassword()));
	      return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/update/{id}")
	  public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
	    Optional<User> userData = userRepository.findById(id);

	    if (userData.isPresent()) {
	      User _user = userData.get();
	      _user.setFname(user.getFname());
	      _user.setLname(user.getLname());
	      _user.setEmail(user.getEmail());
	      _user.setPassword(user.getPassword());
	      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
	    try {
	      userRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
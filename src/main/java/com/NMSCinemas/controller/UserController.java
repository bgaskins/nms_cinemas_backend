package com.NMSCinemas.controller;

import java.util.List;

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
import com.NMSCinemas.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
		


public class UserController {
		
	 @Autowired
	  UserService userService; 
	 
	 @PostMapping("/newUser")
		public ResponseEntity<User> createUser(@RequestBody User users){
			User user = userService.createUser(users);
			if(user!=null)
				return new ResponseEntity<User>(users,HttpStatus.CREATED);
			else
				return new ResponseEntity<User>(users,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 	
		@GetMapping("/all")
		public List<User> getAllUsers(){
			return userService.getAllUsers();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<User> getUserById(@PathVariable Long id){
			User user= userService.getUserById(id);
			
			if(user!=null)
				return new ResponseEntity<User>(user, HttpStatus.FOUND);
			else
				return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateUser(@PathVariable Long id,@RequestBody User users){
			User user= userService.updateUser(id, users);
			
			if (user!=null)
				return new ResponseEntity<Object>(user,HttpStatus.OK);
			else
				return new ResponseEntity<Object>("No User Available to Update",HttpStatus.NOT_FOUND);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String>deleteUser(@PathVariable Long id){
			boolean result = userService.deleteUser(id);
			if(result) 
				return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
			else
				return new ResponseEntity<String>("NO user Found", HttpStatus.NOT_FOUND);
			
		}
	
	 
	}
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

import com.NMSCinemas.model.Admin;
import com.NMSCinemas.repository.AdminRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	  @Autowired
	  AdminRepository adminRepository;


	  @GetMapping("/find/{id}")
	  public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {
	    Optional<Admin> adminData = adminRepository.findById(id);

	    if (adminData.isPresent()) {
	      return new ResponseEntity<>(adminData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @PostMapping("/create")
	  public ResponseEntity<Admin> createAdmin(@RequestBody Admin ad) {
	    try {
	      Admin _admin = adminRepository
	          .save(new Admin (ad.getFname(), ad.getLname(), ad.getEmail(), ad.getPassword()));
	      return new ResponseEntity<>(_admin, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @PutMapping("/update/{id}")
	  public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Long id, @RequestBody Admin ad) {
	    Optional<Admin> adminData = adminRepository.findById(id);

	    if (adminData.isPresent()) {
	      Admin _admin = adminData.get();
	      _admin.setFname(ad.getFname());
	      _admin.setLname(ad.getLname());
	      _admin.setEmail(ad.getEmail());
	      return new ResponseEntity<>(adminRepository.save(_admin), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") Long id) {
	    try {
	      adminRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


	}

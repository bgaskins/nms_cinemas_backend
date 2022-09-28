package com.NMSCinemas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NMSCinemas.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	
	@Query(value = "INSERT INTO users (fname, lname, email, password) VALUES (?,?,?,?)", nativeQuery = true)
	public Optional<User> createUser(@Param("id") Long id,
			@Param("fname") String fname,
			@Param("lname") String lname,
			@Param("email") String email,
			@Param("password") String password);
	
	@Query(value = "INSERT INTO user WHERE email = :email", nativeQuery = true)
	public Optional<User> getUserByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
	public Optional<User> getUserById(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM user", nativeQuery = true)
	public Optional<User> getAllUsers();
	
	@Query(value = "UPDATE user SET fname=?, lname=?, email=?, password=? WHERE id=?", nativeQuery = true)
	public Optional<User> updateUser(@Param("id") Long id);
	
	@Query(value = "DELETE * FROM user WHERE id = :id", nativeQuery = true)
	public Optional<User> deleteUser(@Param("id") Long id);
	
	
}

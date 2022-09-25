package com.NMSCinemas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NMSCinemas.model.Admin;

	@Repository
	public interface AdminRepository extends JpaRepository<Admin, Long> {
		@Query(value = "SELECT * FROM admin WHERE id = :id", nativeQuery = true)
		public Optional<Admin> getAdminById(@Param("id") Long id);
		
		
		@Query(value = "INSERT INTO movies (fname, lname, email, password) VALUES (?,?,?,?)", nativeQuery = true)
		public Optional<Admin> createUser(@Param("id") Long id,
				@Param("fName") String fName,
				@Param("lName") String lName,
				@Param("email") String email,
				@Param("password") String password);

		@Query(value = "UPDATE user SET fname=?, lname=?, email=?, password=? WHERE id=?", nativeQuery = true)
		public Optional<Admin> updateAdmin(@Param("id") Long id);
		
		@Query(value = "DELETE * FROM admin WHERE id = :id", nativeQuery = true)
		public Optional<Admin> deleteAdmin(@Param("id") Long id);

	}


package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// get user details by supplied email
	Optional<User> findByEmail(String email);
	// get user details by supplied email and password+

	@Query(value = "select u from User u where u.email=:email and u.password=:password")
	Optional<User> findByEmailAndPassword(String email, String password);
	
	public List<User> findAllByRole(Role role);
	
	public Long countByRole(Role roleName);
}

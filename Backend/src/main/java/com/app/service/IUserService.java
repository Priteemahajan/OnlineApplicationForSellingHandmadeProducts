package com.app.service;

import java.util.List;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface IUserService {
	// add a method to return all available users
	List<User> getAllUsers();

	// add a method to return User details if exits otherwise throw custom exception
	User getUserDetails(String em);

	// add a method to save new User details
	User saveUserDetails(User u);

	// add a method to update User details
	User updateUserDetails(int uid, User u);

	//add a method to delete a User
	User deleteUserDetails(int uid);

	List<User> getUserByRole(Role roleName);
	
	Long countUserbyRole(Role roleName);
}

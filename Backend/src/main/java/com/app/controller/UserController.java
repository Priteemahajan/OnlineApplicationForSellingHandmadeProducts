package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	//dependencies: userService
	@Autowired
	private IUserService userService;
	
	public UserController() {
		System.out.println("in user controller ");
	}
	
	//add REST request handling method to access all available Users
	@GetMapping
	public List<User> getAllUsers()
	{
		System.out.println("in get all users ");
		return userService.getAllUsers();
	}

	//add REST request handling method to show User details by a specific email
	@GetMapping("/{email}")
	public User getUserByEmail(@PathVariable String email)
	{
		System.out.println("in get user details by email "+email);
		return userService.getUserDetails(email);
	}
	
	//add REST request handling to add User details(=> creating a new resource) : POST
	//json representation of User details ---> Java object (de serailization / un marshalling)
	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody User userDetails)
	{
		System.out.println("in add new User "+userDetails);
		try {
			return new ResponseEntity<>(userService.saveUserDetails(userDetails),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	//add REST request handling to update User details(=> update) : PUT
	//typically front end sends a resource id ( User id) : as a URI variable
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUserDetails(@PathVariable int userId,@RequestBody User details)
	{
		System.out.println("in update User "+userId+" "+details);
		try {
			return new ResponseEntity<>(userService.updateUserDetails(userId, details),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	//add REST request handling method for User deletion
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int userId)
	{
		System.out.println("in delete User "+userId);
		try {
			return new ResponseEntity<>(userService.deleteUserDetails(userId),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}			
	}

}

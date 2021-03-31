package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDTO;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IProductService;
import com.app.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService uservice;
	
	@Autowired
	private IProductService pservice;
	
	@GetMapping("/role/{role}")
	public ResponseEntity<?> getUserByRole(@PathVariable Role role) {
		System.out.println("in get user By Role" + role);
		// invoke service method
		List<User> userByRole = uservice.getUserByRole(role);
		System.out.println("User details "+userByRole);
		return ResponseEntity.ok(new ResponseDTO<>(userByRole));		
	}

	@GetMapping("/productCount")
	public ResponseEntity<Long> getProductsCount() {
		
		Long pCount = pservice.getProductsCount();
		System.out.println("product count :  "+pCount);
		
		if (pCount==0)

			return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the count
		return new ResponseEntity<Long>(pCount, HttpStatus.OK);
	
	}
	
	@GetMapping("/roleCount/{role}")
	public ResponseEntity<Long> getSupplierUserCount(@PathVariable Role role) {
		
		Long uCount = uservice.countUserbyRole(role);
		System.out.println("user count :  "+uCount);
		
		if (uCount==0)

			return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the count
		return new ResponseEntity<Long>(uCount, HttpStatus.OK);
	
	}
}

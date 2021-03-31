/*package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDto;
import com.app.dto.UserDTO;
import com.app.pojos.User;
import com.app.service.RegisterServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class RegisterController {
	// dependencies : registerService
	@Autowired
	private RegisterServiceImpl registerService;

	public RegisterController() {
		System.out.println("in register controller ");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody  LoginRequestDto loginRequestDto) {
		String tempEmailId = loginRequestDto.getEmail();
		String tempPassword = loginRequestDto.getPassword();
		System.out.println("in login user " + loginRequestDto);
		try {
			UserDTO userDto = registerService.fetchUserByEmailAndPassword(tempEmailId, tempPassword);
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerNewUser(@RequestBody User newUser) {

		System.out.println("in login user " + newUser);
		try {
			UserDTO userDto = registerService.saveUser(newUser);
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}*/

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDto;
import com.app.dto.UserDTO;
import com.app.pojos.AESAlgo;
import com.app.pojos.User;
import com.app.service.RegisterServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class RegisterController {
	// dependencies : registerService
	@Autowired
	private RegisterServiceImpl registerService;

	public RegisterController() {
		System.out.println("in register controller ");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody  LoginRequestDto loginRequestDto) {
		String tempEmailId = loginRequestDto.getEmail();
		String tempPassword = loginRequestDto.getPassword();
		System.out.println("in login user " + loginRequestDto);
		try {
			
			UserDTO userDto = registerService.fetchUserByEmailAndPassword(tempEmailId, AESAlgo.en(tempPassword));
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerNewUser(@RequestBody User newUser) {

		System.out.println("in login user " + newUser);
		
		try {
			newUser.setPassword(AESAlgo.en(newUser.getPassword()));
			UserDTO userDto = registerService.saveUser(newUser);
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

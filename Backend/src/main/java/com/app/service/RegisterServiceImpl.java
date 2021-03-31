package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome.excs.UserNotFoundException;
import com.app.dao.UserRepository;
import com.app.dto.UserDTO;
import com.app.pojos.User;

@Service
@Transactional
public class RegisterServiceImpl {
	//dependencies : userDao
	@Autowired
	private UserRepository userRepo;
	
	public UserDTO saveUser(User u)
	{
		User persistentUser = userRepo.save(u);
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(persistentUser, dto);
		return dto;
	}
	
	public UserDTO fetchUserByEmailAndPassword(String em,String pwd)
	{
		User user = userRepo.findByEmailAndPassword(em, pwd).orElseThrow(() -> new UserNotFoundException("Invalid User Email "+em+"and Password "+pwd));
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO, "password");
		System.out.println("user " + user);
		System.out.println("user DTO  " + userDTO);
		return userDTO;
	}

}

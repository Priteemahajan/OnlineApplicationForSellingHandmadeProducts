package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome.excs.UserNotFoundException;
import com.app.dao.UserRepository;
import com.app.dto.ProductDTO;
import com.app.pojos.Product;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	//Dependencies : user dao
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserDetails(String em) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(em).orElseThrow(() -> new UserNotFoundException("Invalid User Email "+em));
	}

	@Override
	public User saveUserDetails(User u) {
		// TODO Auto-generated method stub
		return userRepo.save(u);
	}

	@Override
	public User updateUserDetails(int uid, User u) {
		// validate if user exists
		Optional<User> optionalUser=userRepo.findById(uid);
		User user=optionalUser.orElseThrow(() -> new UserNotFoundException("Invalid user id"));
		return userRepo.save(u);
	}

	@Override
	public User deleteUserDetails(int uid) {
		// validate if user exists
		Optional<User> optionalUser=userRepo.findById(uid);
		User user=optionalUser.orElseThrow(() -> new UserNotFoundException("Invalid user id"));
		userRepo.deleteById(uid);
		return user;
	}

	@Override
	public List<User> getUserByRole(Role roleName) {
		List<User> u=userRepo.findAllByRole(roleName);
		List<ProductDTO> dto=new ArrayList<ProductDTO>();
		BeanUtils.copyProperties(u,dto);
		System.out.println("User "+u);
		System.out.println("User DTO "+dto);
		return u;
	}

	@Override
	public Long countUserbyRole(Role roleName) {
		// TODO Auto-generated method stub
		return userRepo.countByRole(roleName);
	}
	
	

}

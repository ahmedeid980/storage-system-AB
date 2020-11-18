package com.ahmedeid.securityandjwt.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.security.TokenUtil;
import com.ahmedeid.securityandjwt.demo.services.UserService;

@CrossOrigin
@RestController
@RequestMapping(value= "/userController")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@PostMapping(value= "/getUsersList")
	public List<User> getAllUser() {
		return userService.getAll();
	}
	
	@PostMapping({"/checkAdminThenGetAllUsers"})
	public List<User> getAllUserByCheckAdmin(@RequestBody String token) {
		String userName = tokenUtil.getUserNameFromToken(token);
		User userDetails = (User) userService.loadUserByUsername(userName);
		System.out.println(userDetails);
		if(userDetails.getIsAdmin() != 0) {
			return userService.getAll();
		}
		List<User> users = new ArrayList<User>();
		users.add(userService.getUserById(userDetails.getId()));
		return users;
		
	}
	
	

}

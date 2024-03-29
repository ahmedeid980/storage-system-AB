package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.entities.Store;
import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.repository.SqlStatement;
import com.ahmedeid.securityandjwt.demo.security.JwtResponse;
import com.ahmedeid.securityandjwt.demo.security.LoginRequest;
import com.ahmedeid.securityandjwt.demo.security.TokenUtil;
import com.ahmedeid.securityandjwt.demo.services.CategoryService;
import com.ahmedeid.securityandjwt.demo.services.IncomingCompanyService;
import com.ahmedeid.securityandjwt.demo.services.UserService;
import com.ahmedeid.securityandjwt.demo.uibean.IncomingToUIBean;
import com.ahmedeid.securityandjwt.demo.uibean.UserUIBean;

@CrossOrigin
@RestController
@RequestMapping(value="/storageSystem/userlogin")
public class AuthController {

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private UserService userService;
	
	@Autowired
	private IncomingCompanyService incomingCompanyService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private SqlStatement sql;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(value = {"","/"})
	public JwtResponse Login(@RequestBody LoginRequest loginRequest) {
		final Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
		String token = null;
		JwtResponse jwtResponse = null;
		if(userDetails != null) {
			token = tokenUtil.generateToken(userDetails);
			jwtResponse = new JwtResponse(token , "you have a new token" , userDetails);
		} else {
			jwtResponse = new JwtResponse(null , "username or password invalid, "
					+ "try again later or you can register this login again" ,null);
		}
		
		
		return jwtResponse;
	}
	
	@PostMapping(value="/register")
	public User register(@RequestBody UserUIBean userUI) {
		
		User newUser = new User();
		newUser.setEmail(userUI.getEmail());
		newUser.setUserName(userUI.getUsername());
		newUser.setPassword(userUI.getPassword());
		
		User saveUser = userService.saveUser(newUser);
		return saveUser;
		
	}
	
	@GetMapping("/getIncomingDataToUIBean/{userId}")
	public IncomingToUIBean getIncomingDataToUIBean(@PathVariable("userId") int userId) {
		
		Store stores = sql.getStoreByUserId(userId);
		List<IncomingCompany> incomingCompanies = incomingCompanyService.getAll();
		List<Category> categories = categoryService.getAll();
		
		IncomingToUIBean incomingToUIBean = new IncomingToUIBean();
		incomingToUIBean.setStores(stores);
		incomingToUIBean.setCategories(categories);
		incomingToUIBean.setIncomingCompanise(incomingCompanies);
		
		return incomingToUIBean;
		
	}
	
	@GetMapping("/getOutBoundDataToUIBean/{userId}")
	public IncomingToUIBean getOutBoundDataToUIBean(@PathVariable("userId") int userId) {
		
		Store stores = sql.getStoreByUserId(userId);
		Project project = sql.getProjectByStoreId(stores.getId());
		List<Category> categories = categoryService.getAll();
		
		IncomingToUIBean incomingToUIBean = new IncomingToUIBean();
		incomingToUIBean.setStores(stores);
		incomingToUIBean.setCategories(categories);
		incomingToUIBean.setProject(project);
		
		return incomingToUIBean;
		
	}
	
	@GetMapping("/getTransterDataToUIBean/{userId}")
	public IncomingToUIBean getTransterDataToUIBean(@PathVariable("userId") int userId) {
		
		Store store = sql.getStoreByUserId(userId);
		List<Store> stores = sql.getStores(store.getId());
		List<Category> categories = categoryService.getAll();
		
		IncomingToUIBean incomingToUIBean = new IncomingToUIBean();
		incomingToUIBean.setStores(store);
		incomingToUIBean.setCategories(categories);
		incomingToUIBean.setStoreList(stores);
		
		return incomingToUIBean;
		
	}
	
	@GetMapping("/getBouncedBackDataToUIBean/{userId}")
	public IncomingToUIBean getBouncedBackDataToUIBean(@PathVariable("userId") int userId) {
		
		Store stores = sql.getStoreByUserId(userId);
		Project project = sql.getProjectByStoreId(stores.getId());
		List<Category> categories = categoryService.getAll();
		
		IncomingToUIBean incomingToUIBean = new IncomingToUIBean();
		incomingToUIBean.setStores(stores);
		incomingToUIBean.setCategories(categories);
		incomingToUIBean.setProject(project);
		
		return incomingToUIBean;
		
	}

}

package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.Role;
import com.ahmedeid.securityandjwt.demo.services.RoleService;

@CrossOrigin
@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String getAll()
//	{
//		return"hello world";
//	}
	
	@GetMapping("/")
	public List<Role> getAll() {
		return roleService.getAll();

	}

	@GetMapping("/{roleId}")
	public Role getRoleById(@PathVariable("roleId") int roleId) {

		return roleService.getRoleById(roleId);
	}

	@DeleteMapping("/{roleId}")
	public void deleteRole(@PathVariable("roleId") int roleId) {
		roleService.deleteRole(roleId);
	}

	@PostMapping("/")
	public Role saveRole (@RequestBody Role role)
	{
		return roleService.saveOrUpdateRole(role);
	}
	
}

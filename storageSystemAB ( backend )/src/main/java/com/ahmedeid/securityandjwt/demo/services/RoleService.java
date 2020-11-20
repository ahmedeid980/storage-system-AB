package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.entities.Role;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.ProjectRepository;
import com.ahmedeid.securityandjwt.demo.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	// get all users Lookup
		public List<Role> getAll() {
			List<Role> role = roleRepository.findAll();
			return role;
		}

		// get user by id
		public Role getUserById(int id) {
			Role role = roleRepository.findById(id).get();

			return role;
		}

		// save new user
		public Role saveUser(Role roles) {
			Role role = roleRepository.save(roles);
			return role;
		}

		// delete user
		public void deleteUser(int id) {
			roleRepository.deleteById(id);
		}

}

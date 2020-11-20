package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	// get all users Lookup
		public List<Project> getAll() {
			List<Project> project = projectRepository.findAll();
			return project;
		}

		// get user by id
		public Project getUserById(int id) {
			Project project = projectRepository.findById(id).get();

			return project;
		}

		// save new user
		public Project saveUser(Project projects) {
			Project project = projectRepository.save(projects);
			return project;
		}

		// delete user
		public void deleteUser(int id) {
			projectRepository.deleteById(id);
		}

}

package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.entities.Role;
import com.ahmedeid.securityandjwt.demo.entities.Store;
import com.ahmedeid.securityandjwt.demo.entities.StoreType;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.ProjectRepository;
import com.ahmedeid.securityandjwt.demo.repository.RoleRepository;
import com.ahmedeid.securityandjwt.demo.repository.StoreRepository;
import com.ahmedeid.securityandjwt.demo.repository.StoreTypeRepository;

@Service
public class StoreTypeService {
	
	@Autowired
	private StoreTypeRepository storeTypeRepository;
	
	// get all users Lookup
		public List<StoreType> getAll() {
			List<StoreType> storeType = storeTypeRepository.findAll();
			return storeType;
		}

		// get user by id
		public StoreType getUserById(int id) {
			StoreType storeType = storeTypeRepository.findById(id).get();

			return storeType;
		}

		// save new user
		public StoreType saveUser(StoreType storeTypes) {
			StoreType storeType = storeTypeRepository.save(storeTypes);
			return storeType;
		}

		// delete user
		public void deleteUser(int id) {
			storeTypeRepository.deleteById(id);
		}

}

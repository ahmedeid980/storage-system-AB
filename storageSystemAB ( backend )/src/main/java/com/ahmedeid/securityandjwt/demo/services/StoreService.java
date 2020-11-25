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
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.ProjectRepository;
import com.ahmedeid.securityandjwt.demo.repository.RoleRepository;
import com.ahmedeid.securityandjwt.demo.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// get all users Lookup
		public List<Store> getAll() {
			List<Store> store = storeRepository.findAll();
			return store;
		}

		// get user by id
		public Store getStoreById(int id) {
			Store store = storeRepository.findById(id).get();

			return store;
		}

		// save new user
		public Store saveOrUpdateStore(Store stores) {
			Store store = storeRepository.save(stores);
			return store;
		}

		// delete user
		public void deleteStore(int id) {
			storeRepository.deleteById(id);
		}

}

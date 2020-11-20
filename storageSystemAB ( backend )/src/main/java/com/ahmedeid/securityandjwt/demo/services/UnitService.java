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
import com.ahmedeid.securityandjwt.demo.entities.Unit;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.ProjectRepository;
import com.ahmedeid.securityandjwt.demo.repository.RoleRepository;
import com.ahmedeid.securityandjwt.demo.repository.StoreRepository;
import com.ahmedeid.securityandjwt.demo.repository.StoreTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.UnitRepository;

@Service
public class UnitService {
	
	@Autowired
	private UnitRepository unitRepository;
	
	// get all users Lookup
		public List<Unit> getAll() {
			List<Unit> unit = unitRepository.findAll();
			return unit;
		}

		// get user by id
		public Unit getUserById(int id) {
			Unit unit = unitRepository.findById(id).get();

			return unit;
		}

		// save new user
		public Unit saveUser(Unit units) {
			Unit unit = unitRepository.save(units);
			return unit;
		}

		// delete user
		public void deleteUser(int id) {
			unitRepository.deleteById(id);
		}

}

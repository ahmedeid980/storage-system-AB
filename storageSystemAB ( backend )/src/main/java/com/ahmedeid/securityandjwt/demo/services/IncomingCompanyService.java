package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.CategoryRepository;
import com.ahmedeid.securityandjwt.demo.repository.IncomingCompanyRepository;

@Service
public class IncomingCompanyService {
	
	@Autowired
	private IncomingCompanyRepository incomingCompanyRepository;
	
	// get all users Lookup
		public List<IncomingCompany> getAll() {
			List<IncomingCompany> incomingCompany = incomingCompanyRepository.findAll();
			return incomingCompany;
		}

		// get user by id
		public IncomingCompany getUserById(int id) {
			IncomingCompany incomingCompany = incomingCompanyRepository.findById(id).get();

			return incomingCompany;
		}

		// save new user
		public IncomingCompany saveUser(IncomingCompany incomingCompanies) {
			IncomingCompany incomingCompany = incomingCompanyRepository.save(incomingCompanies);
			return incomingCompany;
		}

		// delete user
		public void deleteUser(int id) {
			incomingCompanyRepository.deleteById(id);
		}

}

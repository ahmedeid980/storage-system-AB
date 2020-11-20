package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	// get all users Lookup
		public List<Bill> getAll() {
			List<Bill> bill = billRepository.findAll();
			return bill;
		}

		// get user by id
		public Bill getUserById(int id) {
			Bill bill = billRepository.findById(id).get();

			return bill;
		}

		// save new user
		public Bill saveUser(Bill bills) {
			Bill bill = billRepository.save(bills);
			return bill;
		}

		// delete user
		public void deleteUser(int id) {
			billRepository.deleteById(id);
		}

}

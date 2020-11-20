package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;

@Service
public class BillProductService {
	
	@Autowired
	private BillProductRepository billProductRepository;
	
	// get all users Lookup
		public List<BillProduct> getAll() {
			List<BillProduct> billProducts = billProductRepository.findAll();
			return billProducts;
		}

		// get user by id
		public BillProduct getUserById(int id) {
			BillProduct billProducts = billProductRepository.findById(id).get();

			return billProducts;
		}

		// save new user
		public BillProduct saveUser(BillProduct billProduct) {
			BillProduct billProducts = billProductRepository.save(billProduct);
			return billProducts;
		}

		// delete user
		public void deleteUser(int id) {
			billProductRepository.deleteById(id);
		}

}

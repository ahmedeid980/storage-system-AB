package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;

@Service
public class BillTypeService {
	
	@Autowired
	private BillTypeRepository billTypeRepository;
	
	// get all users Lookup
		public List<BillType> getAll() {
			List<BillType> billType = billTypeRepository.findAll();
			return billType;
		}

		// get user by id
		public BillType getBillTypeById(int id) {
			BillType billType = billTypeRepository.findById(id).get();

			return billType;
		}

		// save new user
		public BillType saveOrUpdateBillType(BillType billType) {
			BillType billTypes = billTypeRepository.save(billType);
			return billTypes;
		}

		// delete user
		public void deleteBillType(int id) {
			billTypeRepository.deleteById(id);
		}

}

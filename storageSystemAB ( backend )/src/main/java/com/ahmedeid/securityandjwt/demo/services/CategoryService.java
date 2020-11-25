package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.repository.BillProductRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillRepository;
import com.ahmedeid.securityandjwt.demo.repository.BillTypeRepository;
import com.ahmedeid.securityandjwt.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// get all users Lookup
		public List<Category> getAll() {
			List<Category> category = categoryRepository.findAll();
			return category;
		}

		// get user by id
		public Category getCategoryById(int id) {
			Category category = categoryRepository.findById(id).get();

			return category;
		}

		// save new user
		public Category saveOrUpdateCategory(Category categories) {
			Category category = categoryRepository.save(categories);
			return category;
		}

		// delete user
		public void deleteCategory(int id) {
			categoryRepository.deleteById(id);
		}

}

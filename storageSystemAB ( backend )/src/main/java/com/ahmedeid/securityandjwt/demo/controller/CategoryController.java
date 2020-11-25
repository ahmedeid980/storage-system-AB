package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.services.CategoryService;

@CrossOrigin
@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAll()
	{
		return categoryService.getAll();
	}
	
	@GetMapping("{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") int categoryId )
	{
		return categoryService.getCategoryById(categoryId);
	}
	
	@PostMapping
	public Category saveCategory(@RequestBody Category category )
	{
		return categoryService.saveOrUpdateCategory(category);
	}
	
	@DeleteMapping("{categoryId}")
	public void delelteCategory(@PathVariable("categoryId") int categoryId)
	{
		categoryService.deleteCategory(categoryId);
	}

}

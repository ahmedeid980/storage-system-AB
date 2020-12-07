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
import com.ahmedeid.securityandjwt.demo.repository.SqlStatement;
import com.ahmedeid.securityandjwt.demo.services.CategoryService;
import com.ahmedeid.securityandjwt.demo.uibean.IncomingToUIBean;

@CrossOrigin
@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private SqlStatement sqlStatement;
	
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
	
	@GetMapping("/checkAvilability/{categoryId}/{storeId}/{quantity}")
	public IncomingToUIBean checkAvilability(@PathVariable("categoryId") int categoryId,
			@PathVariable("storeId") int storeId, @PathVariable("quantity") long quantity) {
		
		IncomingToUIBean incomingToUIBean=new IncomingToUIBean();
		
		Long totalIncoming = sqlStatement.getTotalIncomCategory(storeId, categoryId) == null ? 0 : sqlStatement.getTotalIncomCategory(storeId, categoryId);
		Long totalOutbound = sqlStatement.getTotalOutBoundCategory(storeId, categoryId) == null ? 0 : sqlStatement.getTotalOutBoundCategory(storeId, categoryId);
		
		Long total = totalIncoming - totalOutbound;
		
		if(total >= quantity) {
			incomingToUIBean.setStatus(true);
		}else
		{
			incomingToUIBean.setStatus(false);
			incomingToUIBean.setQuantity(total);
		}
		
		return incomingToUIBean;
		
	}

}

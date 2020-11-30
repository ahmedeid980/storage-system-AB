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

import com.ahmedeid.securityandjwt.demo.entities.Store;
import com.ahmedeid.securityandjwt.demo.repository.SqlStatement;
import com.ahmedeid.securityandjwt.demo.repository.StoreRepository;
import com.ahmedeid.securityandjwt.demo.services.StoreService;

@CrossOrigin
@RestController
@RequestMapping(value = "/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private SqlStatement sql;
	
	@GetMapping("/")
	public List<Store> getAll()
	{
		return storeService.getAll();
	}
	
	
	@GetMapping("/{storeId}")
	public Store getStoreById(@PathVariable("storeId") int storeId)
	{
		
		return storeService.getStoreById(storeId);
	}
	
	@GetMapping("/getStoreByUserId/{userId}")
	public Store getStoreByUserId(@PathVariable("userId") int userId)
	{
		Store store = sql.getStoreByUserId(userId);
		return (store); 
	}
	
	@PostMapping("/")
	public Store saveStore(@RequestBody Store store)
	{
		return storeService.saveOrUpdateStore(store);
	}
	
	@DeleteMapping("/{storeId}")
	public void deleteStore(@PathVariable("storeId") int storeId)
	{
		storeService.deleteStore(storeId);
	}
}

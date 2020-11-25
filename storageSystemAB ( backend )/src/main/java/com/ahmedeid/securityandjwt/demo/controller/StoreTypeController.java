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

import com.ahmedeid.securityandjwt.demo.entities.StoreType;
import com.ahmedeid.securityandjwt.demo.services.StoreTypeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/storetype")
public class StoreTypeController {
	
	@Autowired
	private StoreTypeService storeTypeService;
	
	@GetMapping("/")
	public List<StoreType> getAll()
	{
		return storeTypeService.getAll();
	}
	
	@GetMapping("/{storeTypeId}")
	public StoreType getStoreTypeById(@PathVariable("storeTypeId") int storeTypeId)
	{
		return storeTypeService.getStoreTypeById(storeTypeId);
	}
	
	@PostMapping
	public StoreType saveStoreType(@RequestBody StoreType storeType)
	{
		return storeTypeService.saveOrUpdateStoreType(storeType);
	}
	
	@DeleteMapping("/{storeTypeId}")
	public void deleteStoreType(@PathVariable("storeTypeId") int storeTypeId)
	{
		storeTypeService.deleteStoreType(storeTypeId);
		
	}

}

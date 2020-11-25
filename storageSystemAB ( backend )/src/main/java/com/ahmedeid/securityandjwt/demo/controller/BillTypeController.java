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

import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.services.BillTypeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/billtype")
public class BillTypeController {
	
	@Autowired 
	BillTypeService  billTypeService ;
	
	
	@GetMapping("/")
	public List<BillType> getAll()
	{
		return billTypeService.getAll();
	}
	
	@GetMapping("/{billTypeId}")
	public BillType getBillTypeById(@PathVariable("billTypeId") int billTypeId)
	{
		return billTypeService.getBillTypeById(billTypeId);
	}
	@PostMapping("/")
	public BillType saveBillType(@RequestBody BillType billType)
	{
		return billTypeService.saveOrUpdateBillType(billType);
	}
	
	@DeleteMapping("/{billTypeId}")
	public void deleteBillType(@PathVariable("billTypeId") int billTypeId)
	{
		billTypeService.deleteBillType(billTypeId);
	}
}

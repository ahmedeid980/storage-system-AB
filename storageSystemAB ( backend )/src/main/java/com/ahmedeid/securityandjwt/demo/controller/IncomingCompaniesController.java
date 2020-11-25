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

import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.services.IncomingCompanyService;

@CrossOrigin
@RestController
@RequestMapping(value = "/incomingCompany")
public class IncomingCompaniesController {
	

	@Autowired
	private IncomingCompanyService incomingCompanyService;
	
	@GetMapping("/")
	public List<IncomingCompany> getAll()
	{
		return incomingCompanyService.getAll();
	}
	
	@GetMapping("{incomingCompanyId}")
	public IncomingCompany getIncomingCompanyById(@PathVariable("incomingCompanyId") int incomingCompanyId)
	{
		return incomingCompanyService.getIncomingCompanyById(incomingCompanyId);
	}
	
	
	@PostMapping
	public IncomingCompany saveIncomingCompany(@RequestBody IncomingCompany incomingCompany)
	{
		return incomingCompanyService.saveOrUpIncomingCompany(incomingCompany);
	}
	@DeleteMapping("{incomingCompanyId}")
	public void deleteIncomingCompany(@PathVariable("incomingCompanyId") int incomingCompanyId)
	{
		incomingCompanyService.deleteIncomingCompany(incomingCompanyId);
	}
	
	
	
}

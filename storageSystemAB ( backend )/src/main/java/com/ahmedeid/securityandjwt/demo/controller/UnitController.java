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

import com.ahmedeid.securityandjwt.demo.entities.Unit;
import com.ahmedeid.securityandjwt.demo.repository.UnitRepository;
import com.ahmedeid.securityandjwt.demo.services.UnitService;

@CrossOrigin
@RestController
@RequestMapping(value = "/unit")
public class UnitController {
	
	@Autowired 
	UnitService unitService ;
	
	@GetMapping("/")
	public List<Unit> getAll()
	{
		return unitService.getAll();
	}
	
	@GetMapping("/{unitId}")
	public Unit getUnitById(@PathVariable("unitId") int unitId )
	{
		return unitService.getUnitById(unitId);
	}
	
	
	@PostMapping("/")
	public Unit saveUnit(@RequestBody Unit unit)
	{
		return unitService.saveOrUpdateUnit(unit);
	}
	
	@DeleteMapping("/{unitId}")
	
	public void deleteUnit(@PathVariable("unitId") int unitId)
	{
		unitService.deleteUnit(unitId);
		
	}
	
	
	

}

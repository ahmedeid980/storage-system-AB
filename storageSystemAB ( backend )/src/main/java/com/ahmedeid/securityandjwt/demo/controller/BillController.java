package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.services.BillService;
import com.ahmedeid.securityandjwt.demo.uibean.IncomingBean;

@CrossOrigin
@RestController
@RequestMapping(value = "/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping("/")
	public List<Bill> getAll()
	{
		return billService.getAll();
	}
	
	@GetMapping("/{id}")
	public Bill getBillById(@PathVariable("id") int id)
	{
		return  billService.getBillById(id);
	}
	
	@PostMapping("/saveBill")
	public Bill saveBill(@RequestBody Bill bill)
	{
		return billService.saveOrUpdateBill(bill);
	}
	
	@PostMapping("/addIncoming")
	public void addIncomingBill(@RequestBody IncomingBean incomingBean)
	{
		System.out.println(incomingBean.toString());
		//return billService.saveOrUpdateBill(bill);
	}
	
	
	
}

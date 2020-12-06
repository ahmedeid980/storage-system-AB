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
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.repository.SqlStatement;
import com.ahmedeid.securityandjwt.demo.services.BillProductService;
import com.ahmedeid.securityandjwt.demo.services.BillService;
import com.ahmedeid.securityandjwt.demo.services.IncomingCompanyService;
import com.ahmedeid.securityandjwt.demo.uibean.IncomingBean;
import com.ahmedeid.securityandjwt.demo.uibean.ListOfBillCategory;
import com.ahmedeid.securityandjwt.demo.wrapper.WrapperManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin
@RestController
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@Autowired
	private BillProductService billProductsService;

	@Autowired
	private IncomingCompanyService incomingCompanyService;
	
	@Autowired
	private SqlStatement sqlStatement;

	@GetMapping("/")
	public List<Bill> getAll() {
		return billService.getAll();
	}

	@GetMapping("/{id}")
	public Bill getBillById(@PathVariable("id") int id) {
		return billService.getBillById(id);
	}

	@PostMapping("/saveBill")
	public Bill saveBill(@RequestBody Bill bill) {
		return billService.saveOrUpdateBill(bill);
	}

	@PostMapping("/addIncoming")
	public Bill addIncomingBill(@RequestBody String incomingBean) {

		System.out.println(incomingBean.toString());
		Gson gson = null;
		IncomingBean incoming_bean = new IncomingBean();
		Bill bill = null;
		Bill bills = null;

		try {

			GsonBuilder gsonBuilder = new GsonBuilder();
			gson = gsonBuilder.create();
			incoming_bean = gson.fromJson(incomingBean, IncomingBean.class);

			WrapperManager wrapperManager = new WrapperManager();
			bill = wrapperManager.wrapperUIToDB(incoming_bean);

			bills = billService.saveOrUpdateBill(bill);
			Bill billId = new Bill();
			billId.setId(bills.getId());
			for (int i = 0; i < bill.getBillProducts().size(); i++) {

				bill.getBillProducts().get(i).setBill(billId);
			}
			billProductsService.saveAll(bill.getBillProducts());

			bills.setIncomingCompany(incomingCompanyService.getIncomingCompanyById(bills.getIncomingCompany().getId()));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bills;
	}
	
	@GetMapping("/getBillProductByBillId/{billId}")
	public List<BillProduct> getBillProductByBillId(@PathVariable("billId") int billId) {
		
		List<BillProduct> billProducts = this.sqlStatement.getBillProductByBillId(billId);
		
		return billProducts;
		
	}

}

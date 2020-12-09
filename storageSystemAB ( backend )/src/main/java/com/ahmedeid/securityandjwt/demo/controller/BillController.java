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
import com.ahmedeid.securityandjwt.demo.services.ProjectService;
import com.ahmedeid.securityandjwt.demo.services.StoreService;
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
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ProjectService projectService;

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
	
	@PostMapping("/addOutbound")
	public Bill addOutboundBill(@RequestBody String outboundBean) {

		System.out.println(outboundBean.toString());
		Gson gson = null;
		IncomingBean incoming_bean = new IncomingBean();
		Bill bill = null;
		Bill bills = null;

		try {

			GsonBuilder gsonBuilder = new GsonBuilder();
			gson = gsonBuilder.create();
			incoming_bean = gson.fromJson(outboundBean, IncomingBean.class);

			WrapperManager wrapperManager = new WrapperManager();
			bill = wrapperManager.wrapperUIToDB(incoming_bean);

			bills = billService.saveOrUpdateBill(bill);
			Bill billId = new Bill();
			billId.setId(bills.getId());
			for (int i = 0; i < bill.getBillProducts().size(); i++) {

				bill.getBillProducts().get(i).setBill(billId);
			}
			billProductsService.saveAll(bill.getBillProducts());

			bills.setProject(projectService.getProjectById(bills.getProject().getId()));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bills;
	}
	
	@GetMapping("/billsByBillType/{billTypeId}/{storeId}")
	public List<Bill> getBillsByBillType(@PathVariable("billTypeId") int billTypeId, 
			@PathVariable("storeId") int storeId) {
		
		List<Bill> bills = this.sqlStatement.getBillsByBillType(billTypeId, storeId);
		
		return bills;
		
	}
	
	@PostMapping("/addTransfer")
	public Bill addTransferBill(@RequestBody String transferBean) {

		System.out.println(transferBean.toString());
		Gson gson = null;
		IncomingBean incoming_bean = new IncomingBean();
		Bill bill = null;
		Bill bills = null;

		try {

			GsonBuilder gsonBuilder = new GsonBuilder();
			gson = gsonBuilder.create();
			incoming_bean = gson.fromJson(transferBean, IncomingBean.class);

			WrapperManager wrapperManager = new WrapperManager();
			bill = wrapperManager.wrapperUIToDB(incoming_bean);

			bills = billService.saveOrUpdateBill(bill);
			Bill billId = new Bill();
			billId.setId(bills.getId());
			for (int i = 0; i < bill.getBillProducts().size(); i++) {

				bill.getBillProducts().get(i).setBill(billId);
			}
			billProductsService.saveAll(bill.getBillProducts());

			bills.setStoreTo(storeService.getStoreById(bills.getStoreTo().getId()));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bills;
	}
	
	@PostMapping("/addBouncedBack")
	public Bill addBouncedBackBill(@RequestBody String bouncedBackBean) {

		System.out.println(bouncedBackBean.toString());
		Gson gson = null;
		IncomingBean bounced_bean = new IncomingBean();
		Bill bill = null;
		Bill bills = null;

		try {

			GsonBuilder gsonBuilder = new GsonBuilder();
			gson = gsonBuilder.create();
			bounced_bean = gson.fromJson(bouncedBackBean, IncomingBean.class);

			WrapperManager wrapperManager = new WrapperManager();
			bill = wrapperManager.wrapperUIToDB(bounced_bean);

			bills = billService.saveOrUpdateBill(bill);
			Bill billId = new Bill();
			billId.setId(bills.getId());
			for (int i = 0; i < bill.getBillProducts().size(); i++) {

				bill.getBillProducts().get(i).setBill(billId);
			}
			billProductsService.saveAll(bill.getBillProducts());

//			bills.setIncomingCompany(incomingCompanyService.getIncomingCompanyById(bills.getIncomingCompany().getId()));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bills;
	}

}

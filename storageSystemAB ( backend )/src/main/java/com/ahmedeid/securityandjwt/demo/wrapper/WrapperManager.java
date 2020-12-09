package com.ahmedeid.securityandjwt.demo.wrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.entities.Store;
import com.ahmedeid.securityandjwt.demo.uibean.IncomingBean;
import com.ahmedeid.securityandjwt.demo.uibean.ListOfBillCategory;

public class WrapperManager {
	
	public Bill wrapperUIToDB(IncomingBean incoming_bean) {
		
		Bill bill = new Bill();

		if(incoming_bean.getBillType() != 0) {
			BillType billType = new BillType();
			billType.setId(incoming_bean.getBillType());
			bill.setBillType(billType);
		}
		
		if(incoming_bean.getCodeGeneration() != null && !incoming_bean.getCodeGeneration().equals("")) {
			bill.setCodeGeneration(incoming_bean.getCodeGeneration());
		}
		
		if(incoming_bean.getIncomingCompany() != 0) {
			IncomingCompany incomingCompany = new IncomingCompany();
			incomingCompany.setId(incoming_bean.getIncomingCompany());
			bill.setIncomingCompany(incomingCompany);
		}
		
		if(incoming_bean.getProject() != 0) {
			Project project = new Project();
			project.setId(incoming_bean.getProject());
			bill.setProject(project);
		}
		
		bill.setCreatedDate(new Date());

		if(incoming_bean.getStoreId() != 0) {
			Store store = new Store();
			store.setId(incoming_bean.getStoreId());
			bill.setStore(store);
		}
		
		if(incoming_bean.getStoreTo() != 0) {
			Store store = new Store();
			store.setId(incoming_bean.getStoreTo());
			bill.setStoreTo(store);
		}
		
		List<BillProduct> billProducts = new ArrayList<BillProduct>();
		if(!incoming_bean.getListOfBillCategory().isEmpty() && incoming_bean.getListOfBillCategory() != null) {
			for(ListOfBillCategory listOfBillCategory: incoming_bean.getListOfBillCategory()) {
				BillProduct billProduct = new BillProduct();
				Category category = new Category();
				category.setId(listOfBillCategory.getCategoryObj().getId());
				billProduct.setCategory(category);
				
				if(listOfBillCategory.getNotes() != null && !listOfBillCategory.getNotes().equals(""))
					billProduct.setNotes(listOfBillCategory.getNotes());
				
				if(listOfBillCategory.getQuantity() != null && !listOfBillCategory.getQuantity().equals(""))
					billProduct.setQuantity(Integer.valueOf(listOfBillCategory.getQuantity()));
				
				billProducts.add(billProduct);
			}
			bill.setBillProducts(billProducts);
		}
		return bill;
	}

}

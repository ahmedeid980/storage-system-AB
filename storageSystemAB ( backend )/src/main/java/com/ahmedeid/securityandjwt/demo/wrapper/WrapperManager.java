package com.ahmedeid.securityandjwt.demo.wrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.BillType;
import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.entities.Store;
import com.ahmedeid.securityandjwt.demo.uibean.IncomingBean;
import com.ahmedeid.securityandjwt.demo.uibean.ListOfBillCategory;

public class WrapperManager {
	
	public Bill wrapperUIToDB(IncomingBean incoming_bean) {
		
		Bill bill = new Bill();

		if(incoming_bean.getBillType() != 0) {
			System.out.println("incoming_bean.getBillType() : "+incoming_bean.getBillType());
			BillType billType = new BillType();
			billType.setId(incoming_bean.getBillType());
			bill.setBillType(billType);
		}
		
		if(incoming_bean.getCodeGeneration() != null && !incoming_bean.getCodeGeneration().equals("")) {
			System.out.println("incoming_bean.getCodeGeneration() : "+incoming_bean.getCodeGeneration());
			bill.setCodeGeneration(incoming_bean.getCodeGeneration());
		}
		
		if(incoming_bean.getIncomingCompany() != 0) {
			System.out.println("incoming_bean.getIncomingCompany() : "+incoming_bean.getIncomingCompany());
			IncomingCompany incomingCompany = new IncomingCompany();
			incomingCompany.setId(incoming_bean.getIncomingCompany());
			bill.setIncomingCompany(incomingCompany);
		}
		
		bill.setCreatedDate(new Date());

		if(incoming_bean.getStoreId() != 0) {
			System.out.println("incoming_bean.getStoreId() : "+incoming_bean.getStoreId());
			Store store = new Store();
			store.setId(incoming_bean.getStoreId());
			bill.setStore(store);
		}
		
		List<BillProduct> billProducts = new ArrayList<BillProduct>();
		if(!incoming_bean.getListOfBillCategory().isEmpty() && incoming_bean.getListOfBillCategory() != null) {
			System.out.println("incoming_bean.getListOfBillCategory() : "+incoming_bean.getListOfBillCategory().toString());
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
			System.out.println("here added .. ");
			bill.setBillProducts(billProducts);
		}
		return bill;
	}

}

package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.List;

import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.entities.Store;

public class IncomingToUIBean {

	private Store stores;
	private List<IncomingCompany> incomingCompanise;
	private List<Category> categories;
	private String codeGeneration;

	public IncomingToUIBean() {
		super();
	}

	public Store getStores() {
		return stores;
	}

	public void setStores(Store stores) {
		this.stores = stores;
	}

	public List<IncomingCompany> getIncomingCompanise() {
		return incomingCompanise;
	}

	public void setIncomingCompanise(List<IncomingCompany> incomingCompanise) {
		this.incomingCompanise = incomingCompanise;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getCodeGeneration() {
		return codeGeneration;
	}

	public void setCodeGeneration(String codeGeneration) {
		this.codeGeneration = codeGeneration;
	}

}

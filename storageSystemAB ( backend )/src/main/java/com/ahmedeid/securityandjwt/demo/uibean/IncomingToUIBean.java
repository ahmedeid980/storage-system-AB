package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.List;

import com.ahmedeid.securityandjwt.demo.entities.Category;
import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.entities.Store;

public class IncomingToUIBean {

	private Store stores;
	private List<IncomingCompany> incomingCompanise;
	private List<Category> categories;
	private List<Store> storeList;
	private String codeGeneration;
	private Project project;
	private Long quantity;
	private boolean status;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

}

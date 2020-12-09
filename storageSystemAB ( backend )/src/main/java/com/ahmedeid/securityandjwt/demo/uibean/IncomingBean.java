package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.ArrayList;
import java.util.List;

import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

public class IncomingBean {

	private String codeGeneration;
	private int billType;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private int incomingCompany;
	private int storeId;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private int project;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private int storeTo;

	@SerializedName("listOfBillCategory")
	private List<ListOfBillCategory> listOfBillCategory = new ArrayList<ListOfBillCategory>();

	public IncomingBean() {

		// TODO Auto-generated constructor stub
	}

	public String getCodeGeneration() {
		return codeGeneration;
	}

	public void setCodeGeneration(String codeGeneration) {
		this.codeGeneration = codeGeneration;
	}

	public int getBillType() {
		return billType;
	}

	public void setBillType(int billType) {
		this.billType = billType;
	}

	public int getIncomingCompany() {
		return incomingCompany;
	}

	public void setIncomingCompany(int incomingCompany) {
		this.incomingCompany = incomingCompany;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public List<ListOfBillCategory> getListOfBillCategory() {
		return listOfBillCategory;
	}

	public void setListOfBillCategory(List<ListOfBillCategory> listOfBillCategory) {
		this.listOfBillCategory = listOfBillCategory;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public int getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(int storeTo) {
		this.storeTo = storeTo;
	}

}

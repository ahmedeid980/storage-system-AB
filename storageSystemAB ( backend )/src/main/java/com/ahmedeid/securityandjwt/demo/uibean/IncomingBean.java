package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.ArrayList;
import java.util.List;

import com.ahmedeid.securityandjwt.demo.entities.BillProduct;

public class IncomingBean {
	
	private String codecodeGeneration;
	private Integer billType;
	private Integer incomingCompany ;
	private Integer storeId ;
	private List<BillProductUIBean> listOfBillCategory=new ArrayList<BillProductUIBean>();
	
	
	
	
	
	public IncomingBean() {
	
		// TODO Auto-generated constructor stub
	}
	public String getCodecodeGeneration() {
		return codecodeGeneration;
	}
	public void setCodecodeGeneration(String codecodeGeneration) {
		this.codecodeGeneration = codecodeGeneration;
	}
	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	public Integer getIncomingCompany() {
		return incomingCompany;
	}
	public void setIncomingCompany(Integer incomingCompany) {
		this.incomingCompany = incomingCompany;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public List<BillProductUIBean> getListOfBillCategory() {
		return listOfBillCategory;
	}
	public void setListOfBillCategory(List<BillProductUIBean> listOfBillCategory) {
		this.listOfBillCategory = listOfBillCategory;
	}
	
	
	
	
	

}

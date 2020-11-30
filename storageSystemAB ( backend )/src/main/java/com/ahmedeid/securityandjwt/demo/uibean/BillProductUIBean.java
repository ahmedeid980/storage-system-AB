package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.ArrayList;
import java.util.List;

public class BillProductUIBean {
	
	private String category ;
	private String notes;
	private String quantity;
	private String unit;
	private List<CategoryUIBean> categoryObj=new ArrayList<CategoryUIBean>();
	
	
	
	public BillProductUIBean() {
		super();
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public List<CategoryUIBean> getCategoryObj() {
		return categoryObj;
	}
	public void setCategoryObj(List<CategoryUIBean> categoryObj) {
		this.categoryObj = categoryObj;
	}
	
	
	
	

}

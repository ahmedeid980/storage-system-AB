package com.ahmedeid.securityandjwt.demo.uibean;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListOfBillCategory {

	private String category;
	private String notes;
	private String quantity;
	private String unit;

	@SerializedName("categoryObj")
//	private List<CategoryObj> categoryObj;
	private CategoryObj categoryObj;

	public ListOfBillCategory() {
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

//	public List<CategoryObj> getCategoryObj() {
//		return categoryObj;
//	}
//	public void setCategoryObj(List<CategoryObj> categoryObj) {
//		this.categoryObj = categoryObj;
//	}
	public CategoryObj getCategoryObj() {
		return categoryObj;
	}

	public void setCategoryObj(CategoryObj categoryObj) {
		this.categoryObj = categoryObj;
	}

	@Override
	public String toString() {
		return "ListOfBillCategory [category=" + category + ", notes=" + notes + ", quantity=" + quantity + ", unit="
				+ unit + ", categoryObj=" + categoryObj + "]";
	}

}

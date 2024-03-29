package com.ahmedeid.securityandjwt.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "bill_products")
public class BillProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "notes")
	private String notes;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	})
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	})
	@JoinColumn(name = "bill_id", referencedColumnName = "id")
	@JsonBackReference
	private Bill bill;

	public BillProduct() {
		super();
	}

	public BillProduct(String item, String notes, int quantity, Category category, Bill bill) {
		super();
		this.notes = notes;
		this.quantity = quantity;
		this.category = category;
		this.bill = bill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "BillProduct [id=" + id  + ", notes=" + notes + ", quantity=" + quantity
				+ ", category=" + category + ", bill=" + bill + "]";
	}

}

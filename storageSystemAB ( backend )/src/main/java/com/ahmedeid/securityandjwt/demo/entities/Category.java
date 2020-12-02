package com.ahmedeid.securityandjwt.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "decription")
	private String decription;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_type_id")
	private StoreType storeType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "unit_id", referencedColumnName = "id")
	private Unit unit;

	public Category() {
		super();
	}

	public Category(String decription, StoreType storeType, List<BillProduct> billProducts) {
		super();
		this.decription = decription;
		this.storeType = storeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", decription=" + decription + ", storeType=" + storeType + "]";
	}

}

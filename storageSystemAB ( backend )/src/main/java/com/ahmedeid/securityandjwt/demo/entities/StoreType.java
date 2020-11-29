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
@Table(name = "store_type")
public class StoreType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "decription")
	private String decription;

	@NotNull
	@Column(name = "location")
	private String location;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "store_id")
	private Store store;

	public StoreType() {
		super();
	}

	public StoreType(String decription, String location, Store store, List<Category> categories) {
		super();
		this.decription = decription;
		this.location = location;
		this.store = store;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "StoreType [id=" + id + ", decription=" + decription + ", location=" + location + ", store=" + store
				+"]";
	}

}

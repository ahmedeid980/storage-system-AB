package com.ahmedeid.securityandjwt.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "bill_type")
public class BillType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "decription")
	private String decription;

//	@OneToMany(mappedBy = "billType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Bill> bills;

	public BillType() {
		super();
	}

	public BillType(String decription, List<Bill> bills) {
		super();
		this.decription = decription;
//		this.bills = bills;
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

//	public List<Bill> getBills() {
//		return bills;
//	}
//
//	public void setBills(List<Bill> bills) {
//		this.bills = bills;
//	}

	@Override
	public String toString() {
		return "BillType [id=" + id + ", decription=" + decription + "]";
	}

}

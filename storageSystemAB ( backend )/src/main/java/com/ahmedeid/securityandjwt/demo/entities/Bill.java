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
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "code_generation")
	private String codeGeneration;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BillProduct> billProducts;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "incoming_company_id")
	private IncomingCompany incomingCompany;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_type_id")
	private BillType billType;

	public Bill() {
		super();
	}

	public Bill(String codeGeneration, Store store, List<BillProduct> billProducts, Project project,
			IncomingCompany incomingCompany, BillType billType) {
		super();
		this.codeGeneration = codeGeneration;
		this.store = store;
		this.billProducts = billProducts;
		this.project = project;
		this.incomingCompany = incomingCompany;
		this.billType = billType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeGeneration() {
		return codeGeneration;
	}

	public void setCodeGeneration(String codeGeneration) {
		this.codeGeneration = codeGeneration;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<BillProduct> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public IncomingCompany getIncomingCompany() {
		return incomingCompany;
	}

	public void setIncomingCompany(IncomingCompany incomingCompany) {
		this.incomingCompany = incomingCompany;
	}

	public BillType getBillType() {
		return billType;
	}

	public void setBillType(BillType billType) {
		this.billType = billType;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", codeGeneration=" + codeGeneration + ", store=" + store + ", billProducts="
				+ billProducts + ", project=" + project + ", incomingCompany=" + incomingCompany + ", billType="
				+ billType + "]";
	}

}

package com.ahmedeid.securityandjwt.demo.entities;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

	@ManyToOne(cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	}, fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id", referencedColumnName = "id")
	private Store store;

	@ManyToOne(cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	}, fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;

	@ManyToOne(cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	})
	@JoinColumn(name = "incoming_company_id", referencedColumnName = "id")
	private IncomingCompany incomingCompany;

	@ManyToOne(cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	},fetch = FetchType.EAGER)
	@JoinColumn(name = "bill_type_id", referencedColumnName = "id")
	private BillType billType;

	@Column(name = "created_date")
	private Date createdDate;
	
	@OneToMany(mappedBy = "bill"
			, fetch = FetchType.EAGER,cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	})
	@JsonBackReference
	private List<BillProduct> billProducts;

	public Bill() {
		super();
	}

	public Bill(String codeGeneration, Store store, List<BillProduct> billProducts, Project project,
			IncomingCompany incomingCompany, BillType billType) {
		super();
		this.codeGeneration = codeGeneration;
		this.store = store;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<BillProduct> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", codeGeneration=" + codeGeneration + ", store=" + store + ", project=" + project
				+ ", incomingCompany=" + incomingCompany + ", billType=" + billType + ", createdDate=" + createdDate
				+ "]";
	}

}

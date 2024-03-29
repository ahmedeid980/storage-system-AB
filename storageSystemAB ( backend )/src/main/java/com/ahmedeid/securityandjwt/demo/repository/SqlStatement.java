package com.ahmedeid.securityandjwt.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.ahmedeid.securityandjwt.demo.entities.Bill;
import com.ahmedeid.securityandjwt.demo.entities.BillProduct;
import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.entities.Store;

@Repository
public class SqlStatement {

	@Autowired
	private EntityManager entityManager;

	public Store getStoreByUserId(int userId) {

		Session session = entityManager.unwrap(Session.class);

		Query userSQL = session.createQuery("from Store where user.id= :userId");
		userSQL.setParameter("userId", userId);
		Store store = (Store) userSQL.uniqueResult();

		return store;

	}

	public List<BillProduct> getBillProductByBillId(int billId) {

		Session session = entityManager.unwrap(Session.class);

		Query billSQL = session.createQuery("from BillProduct where bill.id= :billId");
		billSQL.setParameter("billId", billId);
		List<BillProduct> billProduct = billSQL.list();

		return billProduct;

	}
	
	public Project getProjectByStoreId(int storeId) {

		Session session = entityManager.unwrap(Session.class);

		Query projectSQL = session.createQuery("from Project where store.id= :storeId");
		projectSQL.setParameter("storeId", storeId);
		Project project = (Project) projectSQL.uniqueResult();

		return project;

	}
	
	public Long getTotalIncomCategory(int storeId, int categoryId) {

		Session session = entityManager.unwrap(Session.class);

		Query userSQL = session.createQuery("SELECT sum(quantity) "
				+ "from BillProduct where category.id= :categoryId and "
				+ "bill.store.id= :storeId and bill.billType.id=1");
		userSQL.setParameter("categoryId", categoryId);
		userSQL.setParameter("storeId", storeId);
		Long totalQuantity = (Long) userSQL.uniqueResult();

		return totalQuantity;

	}
	
	public Long getTotalOutBoundCategory(int storeId, int categoryId) {

		Session session = entityManager.unwrap(Session.class);

		Query userSQL = session.createQuery("SELECT sum(quantity) "
				+ "from BillProduct where category.id= :categoryId and "
				+ "bill.store.id= :storeId and bill.billType.id in (2,3)");
		userSQL.setParameter("categoryId", categoryId);
		userSQL.setParameter("storeId", storeId);
		Long totalQuantity = (Long) userSQL.uniqueResult();

		return totalQuantity;

	}
	
	public List<Bill> getBillsByBillType(int billTypeId, int storeId) {

		Session session = entityManager.unwrap(Session.class);

		Query billSQL = session.createQuery("from Bill where billType.id= :billTypeId and store.id= :storeId");
		billSQL.setParameter("billTypeId", billTypeId);
		billSQL.setParameter("storeId", storeId);
		List<Bill> bills = billSQL.list();

		return bills;

	}
	
	public List<Store> getStores(int storeId) {

		Session session = entityManager.unwrap(Session.class);

		Query billSQL = session.createQuery("from Store where id != :storeId");
		billSQL.setParameter("storeId", storeId);
		List<Store> stores = billSQL.list();

		return stores;

	}

}

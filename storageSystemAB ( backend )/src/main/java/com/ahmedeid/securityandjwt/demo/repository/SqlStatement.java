package com.ahmedeid.securityandjwt.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

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
	
}

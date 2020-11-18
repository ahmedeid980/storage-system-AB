package com.ahmedeid.securityandjwt.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


@Repository
public class AddingSqlToUser {

	@Autowired
	private EntityManager entityManager;
	
	public List<User> getByPassword() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<User> userSQL = session.createQuery("from User where password=123456",User.class);
		
		List<User> users = userSQL.getResultList();
		
		return users;
		
	}
	
}

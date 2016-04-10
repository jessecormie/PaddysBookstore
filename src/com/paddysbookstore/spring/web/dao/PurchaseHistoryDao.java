package com.paddysbookstore.spring.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("purchaseHistoryDao")
public class PurchaseHistoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public void create(PurchaseHistory purchaseHistory) {
		session().saveOrUpdate(purchaseHistory);
	}
}


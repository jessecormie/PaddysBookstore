package com.paddysbookstore.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("UserDao")
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void create(User user) {
		session().save(user);
	}
	
	@Transactional
	public void saveOrUpdate(User user) {
		session().saveOrUpdate(user);
	}
	
	@Transactional
	public void removeShoppingCart(ShoppingCart shoppingCart) {
		session().delete(shoppingCart);
	}


	public boolean exists(String username) {
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		User user = (User) crit.uniqueResult();
		return user != null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User").list();
	}

	public User getUser(String name) {
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.idEq(name));
		User user = (User) crit.uniqueResult();
		return user;
	}

}

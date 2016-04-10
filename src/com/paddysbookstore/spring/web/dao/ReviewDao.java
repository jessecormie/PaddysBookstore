package com.paddysbookstore.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("reviewDao")
public class ReviewDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Review> getReview() {
		Criteria crit = session().createCriteria(Review.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Review> getReview(String username) {
		Criteria crit = session().createCriteria(Review.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	public void saveOrUpdate(Review review) {
		session().saveOrUpdate(review);
	}

	public boolean delete(int id) {
		Query query = session().createQuery("delete from Review where id=:id");// hql
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	public Review getReview(int id) {
		Criteria crit = session().createCriteria(Review.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(id));
		return (Review) crit.uniqueResult();
	}
}
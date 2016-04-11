package com.paddysbookstore.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("bookDao")
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBook() {
		Criteria crit = session().createCriteria(Book.class);

		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getBookDetails(String title) {
		Criteria crit = session().createCriteria(Book.class);
		crit.add(Restrictions.like("title", title,MatchMode.ANYWHERE));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getBookByCategory(String category) {
		Criteria crit = session().createCriteria(Book.class);
		crit.add(Restrictions.like("category", category,MatchMode.EXACT));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getBookByAuthor(String author) {
		Criteria crit = session().createCriteria(Book.class);
		crit.add(Restrictions.like("author", author,MatchMode.ANYWHERE));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	

	public boolean delete(int id) {
		Query query = session().createQuery("delete from Book where id=:id");// hql
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	public void saveOrUpdate(Book book) {
		session().saveOrUpdate(book);
	}
}

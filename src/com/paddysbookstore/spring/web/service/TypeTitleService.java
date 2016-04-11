package com.paddysbookstore.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.BookDao;
import com.paddysbookstore.spring.web.strategy.Strategy;

@Service("typeTitleService")
public class TypeTitleService implements Strategy{

	private BookDao bookDao;

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}


	public List<Book> searchBar(String search) {
		
		System.out.println("Search: " + search);
		return bookDao.getBookDetails(search);
		
	}

}

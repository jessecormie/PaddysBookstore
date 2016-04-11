package com.paddysbookstore.spring.web.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.BookDao;
import com.paddysbookstore.spring.web.iterator.BookIterator;

@Service("bookListService")
public class BookListService implements BookIterator {

	private BookDao bookDao;	
	List<Book> allBooks;

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void getBook() {
		allBooks = bookDao.getBook();
	}
	
	@Override
	public Iterator createIterator() {
		getBook();
		return allBooks.iterator();
	}
}
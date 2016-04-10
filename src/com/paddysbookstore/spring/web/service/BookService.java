package com.paddysbookstore.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.BookDao;
import com.paddysbookstore.spring.web.dao.Review;

@Service("bookService")
public class BookService {

	private BookDao bookDao;

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBook() {
		return bookDao.getBook();
	}
	
	public List<Book> getBookDetails(String title){
		System.out.println("test 3 " + title);
		return bookDao.getBookDetails(title);
	}

	public void saveOrUpdate(Book book) {
		bookDao.saveOrUpdate(book);
	}

}
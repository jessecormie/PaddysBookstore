package com.paddysbookstore.spring.web.strategy;

import java.util.List;

import com.paddysbookstore.spring.web.dao.Book;

public interface Strategy {
	public List<Book> searchBar(String search);
}

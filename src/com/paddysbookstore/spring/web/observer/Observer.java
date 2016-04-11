package com.paddysbookstore.spring.web.observer;

import com.paddysbookstore.spring.web.dao.Book;

public interface Observer {

	public void update(Book book);
	
}

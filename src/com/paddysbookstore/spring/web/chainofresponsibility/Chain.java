package com.paddysbookstore.spring.web.chainofresponsibility;

import com.paddysbookstore.spring.web.dao.Book;

public interface Chain {
	
	public void setNextChain(Chain nextChain);

	public void calculate(Book book, String request, int number);
	
}

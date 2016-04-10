package com.paddysbookstore.spring.web.chainofresponsibility;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.LineItem;

public class RemoveStock implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {
		// TODO Auto-generated method stub
		nextInChain = nextChain;
	}

	@Override
	public void calculate(Book book, String request, int number) {
		// TODO Auto-generated method stub
		System.out.println("testing the request " + request);
		if (request.equalsIgnoreCase("subtract")) {
			System.out.println("here");
			book.setStock(book.getStock() - number);

		} else {

			nextInChain.calculate(book, request, number);

		}

	}

}

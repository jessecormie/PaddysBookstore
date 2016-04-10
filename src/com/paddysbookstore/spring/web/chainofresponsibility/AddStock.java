package com.paddysbookstore.spring.web.chainofresponsibility;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.LineItem;

public class AddStock implements Chain {

	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextChain) {
		// TODO Auto-generated method stub
		nextInChain = nextChain;
	}

	@Override
	public void calculate(LineItem book, String request, int number) {
		// TODO Auto-generated method stub
		if (request == "add") {
			System.out.print(book.getBook().getStock() + " + " + request.getNumber2() + " = "
					+ (request.getNumber1() + request.getNumber2()));

		} else {

			nextInChain.calculate(request);

		}

	}

}

package com.paddysbookstore.spring.web.observer;

import com.paddysbookstore.spring.web.dao.Book;

public class PriceObserver implements Observer{

	private Book book;
	private double sale;
	
	public static int observerIDTracker = 0;
	
	private Subject priceGrabber;
	
	public int observerID;

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}
	
//	public PriceObserver(Subject priceGrabber){
//		this.priceGrabber = priceGrabber;
//		this.observerID = ++observerIDTracker;
//		
//		System.out.println("New observer " + this.observerID);
//		
//		priceGrabber.register(this);
//	}
//	
//	@Override
//	public void update(Book book) {
//		this.book = book;
//		for(Book b : book.getPrice()){
//		System.out.println(observerID + " ");
//		}
//		
//	}

}

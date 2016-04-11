package com.paddysbookstore.spring.web.observer;

import java.util.ArrayList;

import com.paddysbookstore.spring.web.dao.Book;

public class PriceGrabber implements Subject{

	private ArrayList<Observer> observers;
	private Book book;
			
	public PriceGrabber() {
		this.observers = new ArrayList<Observer>();
		this.book = book;
	}

	public void register(Observer newObserver) {
		
		observers.add(newObserver);
	}

	public void unregister(Observer deleteObserver) {

		int observerIndex = observers.indexOf(deleteObserver);
		observers.remove(observerIndex);
	}

	public void notifyObserver() {
		
		for(Observer observer : observers){
			observer.update(book);
		}
	}
	
	public void setBook(Book book){
		this.book = book;
		notifyObserver();
	}
}

package com.paddysbookstore.spring.web.strategy;

import java.util.List;

import com.paddysbookstore.spring.web.dao.Book;

public class Situation {
	private Strategy strategy;
	
	public Situation(Strategy strategy){
		this.strategy = strategy;
	}
	
	public List<Book> searchBar(String search){
		return this.strategy.searchBar(search);
	}
}

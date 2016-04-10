package com.paddysbookstore.spring.web.strategy;


public class Situation {
	private Strategy strategy;
	
	public Situation(Strategy strategy){
		this.strategy = strategy;
	}
	
	public void searchBar(String search){
		this.strategy.searchBar(search);
	}
}

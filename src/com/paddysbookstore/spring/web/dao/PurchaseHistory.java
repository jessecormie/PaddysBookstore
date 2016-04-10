package com.paddysbookstore.spring.web.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PurchaseHistory {

	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	private ShoppingCart shoppingCartHistory;

	private String date;
	
	public PurchaseHistory() {
		super();
	}

	public PurchaseHistory(ShoppingCart shoppingCartHistory, String date) {
		super();
		this.shoppingCartHistory = shoppingCartHistory;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}



	public ShoppingCart getShoppingCartHistory() {
		return shoppingCartHistory;
	}



	public void setShoppingCartHistory(ShoppingCart shoppingCartHistory) {
		this.shoppingCartHistory = shoppingCartHistory;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "PurchaseHistory [id=" + id + ", shoppingCartHistory=" + shoppingCartHistory + ", date=" + date + "]";
	}

	

}

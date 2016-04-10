package com.paddysbookstore.spring.web.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue
	private int id;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<LineItem> lineItemShoppingCart;

	private double total;

	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(int id, List<LineItem> lineItemShoppingCart, double total) {
		super();
		this.id = id;
		this.lineItemShoppingCart = lineItemShoppingCart;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LineItem> getLineItemShoppingCart() {
		return lineItemShoppingCart;
	}

	public void setLineItemShoppingCart(List<LineItem> lineItemShoppingCart) {
		this.lineItemShoppingCart = lineItemShoppingCart;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
	
}
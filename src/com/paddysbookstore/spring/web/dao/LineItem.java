package com.paddysbookstore.spring.web.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LineItem {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Book book;

	public LineItem() {
		super();
	}

	public LineItem(int quantity, Book book) {
		super();
		this.quantity = quantity;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return " quantity=" + quantity + ", book=" + book;
	}

}
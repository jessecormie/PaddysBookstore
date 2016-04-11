package com.paddysbookstore.spring.web.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.paddysbookstore.spring.web.observer.Observer;

@Entity
public class Book implements Observer {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String author;
	private double price;
	private String category;
	private String image;
	private int stock;
	private boolean sale;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Review> userReviews;

	public Book(double price) {
		this.price = price;
	}

	public Book() {

	}

	public Book(int id, String title, String author, double price, String category, String image, int stock,
			List<Review> userReviews, boolean sale) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.image = image;
		this.stock = stock;
		this.userReviews = userReviews;
		this.sale = sale; 
	}

	public boolean isSale() {
		return sale;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
	}

	public List<Review> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", category="
				+ category + ", image=" + image + ", stock=" + stock + ", userReviews=" + userReviews + "]";
	}

	@Override
	public void update(Book book) {
		book.setPrice(this.price * 0.5);

	}

}
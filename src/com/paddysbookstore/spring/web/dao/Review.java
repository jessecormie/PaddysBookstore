package com.paddysbookstore.spring.web.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue
	private int id;

	private String reviewTitle;
	private String reviewContent;
	private String date;
	private double rating;

	@ManyToOne
	private User user;

	public Review() {
		this.user = new User();
	}

	public Review(int id, String reviewTitle, String reviewContent, String date, double rating, User user) {
		super();
		this.id = id;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.date = date;
		this.rating = rating;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", date="
				+ date + ", rating=" + rating + ", user=" + user + "]";
	}

}
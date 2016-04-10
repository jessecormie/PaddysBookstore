package com.paddysbookstore.spring.web.dao;

public class ShippingPayment {
	
	private String nameOnCard;
	private int cardNumber;
	private int cvc;
	private String month;
	private int year;
	private String address;
	private int zip;
	private String city;
	private String country;
	
	public ShippingPayment(String nameOnCard, int cardNumber, int cvc, String month, int year, String address, int zip,
			String city, String country) {
		super();
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.cvc = cvc;
		this.month = month;
		this.year = year;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.country = country;
	}
	public ShippingPayment() {
		super();
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}

package com.paddysbookstore.spring.web.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	private boolean enabled = false;
	private String authority;
	private String password;
	@Id
	@Column(name = "username")
	private String username;
	private String firstName;
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private ShoppingCart userShoppingCart;

	public User(boolean enabled, String authority, String password, String username, String firstName, String lastName,
			com.paddysbookstore.spring.web.dao.ShoppingCart userShoppingCart) {
		super();
		this.enabled = enabled;
		this.authority = authority;
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userShoppingCart = userShoppingCart;
	}

	public User() {
		super();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ShoppingCart getUserShoppingCart() {
		return userShoppingCart;
	}

	public void setUserShoppingCart(ShoppingCart userShoppingCart) {
		this.userShoppingCart = userShoppingCart;
	}

	@Override
	public String toString() {
		return "User [enabled=" + enabled + ", authority=" + authority + ", password=" + password + ", username="
				+ username + ", firstName=" + firstName + ", lastName=" + lastName + ", userShoppingCart="
				+ userShoppingCart + "]";
	}
	
	
}

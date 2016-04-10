package com.paddysbookstore.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.ShoppingCart;
import com.paddysbookstore.spring.web.dao.User;
import com.paddysbookstore.spring.web.dao.UserDao;


@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void create(User user) {
		userDao.create(user);
	}
	
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}
	
	public boolean exists(String username) {
		return userDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public User getUser(String name){
		return userDao.getUser(name);
	}

	public void removeShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		userDao.removeShoppingCart(shoppingCart);
	}
}

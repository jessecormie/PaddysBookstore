package com.paddysbookstore.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.LineItem;
import com.paddysbookstore.spring.web.dao.LineItemDao;
import com.paddysbookstore.spring.web.dao.ShoppingCart;

@Service("lineItemService")
public class LineItemService {

	private LineItemDao lineItemDao;
	
	@Autowired
	public void setLineItemDao(LineItemDao lineItemDao) {
		this.lineItemDao = lineItemDao;
	}

	public void create(LineItem lineItem, ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		lineItemDao.create(lineItem, shoppingCart);
	}
}

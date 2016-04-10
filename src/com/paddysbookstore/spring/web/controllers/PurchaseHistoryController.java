package com.paddysbookstore.spring.web.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paddysbookstore.spring.web.dao.PurchaseHistory;
import com.paddysbookstore.spring.web.dao.ShoppingCart;
import com.paddysbookstore.spring.web.dao.User;
import com.paddysbookstore.spring.web.service.PurchaseHistoryService;
import com.paddysbookstore.spring.web.service.UserService;

@Controller
public class PurchaseHistoryController {

	private PurchaseHistoryService purchaseHistoryService;
	private UserService userService;

	@Autowired
	public void setPurchaseHistoryService(PurchaseHistoryService purchaseHistoryService) {
		this.purchaseHistoryService = purchaseHistoryService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/purchaseHistory")
	public String purchaseHistory(Model model, Principal principal) {

		User user = userService.getUser(principal.getName());

		ShoppingCart shoppingCart = user.getUserShoppingCart();
		System.out.println("Shopping cart ID: " + shoppingCart.getId());

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentDate = dateFormat.format(date);

		PurchaseHistory purchaseHistory = new PurchaseHistory(shoppingCart,currentDate);
		
		purchaseHistory.setDate(currentDate);
		purchaseHistory.setShoppingCartHistory(shoppingCart);
		purchaseHistoryService.create(purchaseHistory);

		
		model.addAttribute("purchaseHistory", purchaseHistory);

		return "home";
	}
}
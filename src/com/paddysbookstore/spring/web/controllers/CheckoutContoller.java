package com.paddysbookstore.spring.web.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paddysbookstore.spring.web.dao.ShippingPayment;
import com.paddysbookstore.spring.web.dao.ShoppingCart;
import com.paddysbookstore.spring.web.dao.User;
import com.paddysbookstore.spring.web.service.UserService;

@Controller
public class CheckoutContoller {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/checkout")
	public String checkout(Model model, Principal principal) {

		User user = userService.getUser(principal.getName());
		ShoppingCart shoppingCart = user.getUserShoppingCart();
		model.addAttribute("totalPrice", shoppingCart.getTotal());
		return "checkout";
	}

	@RequestMapping("/proceed")
	public String proceed(@PathParam("nameOnCard") String nameOnCard, @PathParam("cardNumber") int cardNumber,
			@PathParam("cvc") int cvc, @PathParam("month") String month, @PathParam("year") int year,
			@PathParam("address") String address, @PathParam("zip") int zip, @PathParam("city") String city,
			@PathParam("country") String country, Model model, Principal principal) {

		ShippingPayment sp = new ShippingPayment(nameOnCard, cardNumber, cvc, month, year, address, zip, city, country);

		User user = userService.getUser(principal.getName());

		ShoppingCart shoppingCart = user.getUserShoppingCart();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentDate = dateFormat.format(date);
		
		model.addAttribute("lineitemlist", shoppingCart.getLineItemShoppingCart());
		model.addAttribute("sp", sp);
		model.addAttribute("totalPrice", shoppingCart.getTotal());
		model.addAttribute("currentDate", currentDate);

		return "receipt";
	}
}

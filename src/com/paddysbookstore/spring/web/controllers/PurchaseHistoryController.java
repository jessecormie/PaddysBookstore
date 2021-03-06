package com.paddysbookstore.spring.web.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paddysbookstore.spring.web.chainofresponsibility.AddStock;
import com.paddysbookstore.spring.web.chainofresponsibility.Chain;
import com.paddysbookstore.spring.web.chainofresponsibility.RemoveStock;
import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.LineItem;
import com.paddysbookstore.spring.web.dao.PurchaseHistory;
import com.paddysbookstore.spring.web.dao.ShoppingCart;
import com.paddysbookstore.spring.web.dao.User;
import com.paddysbookstore.spring.web.service.BookService;
import com.paddysbookstore.spring.web.service.PurchaseHistoryService;
import com.paddysbookstore.spring.web.service.UserService;

@Controller
public class PurchaseHistoryController {

	private PurchaseHistoryService purchaseHistoryService;
	private UserService userService;
	private BookService bookService;

	@Autowired
	public void setPurchaseHistoryService(PurchaseHistoryService purchaseHistoryService) {
		this.purchaseHistoryService = purchaseHistoryService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/purchaseHistory")
	public String purchaseHistory(Model model, Principal principal) {

		User user = userService.getUser(principal.getName());

		ShoppingCart shoppingCart = user.getUserShoppingCart();
		System.out.println("Shopping cart ID: " + shoppingCart.getId());

		for (LineItem lineItem : shoppingCart.getLineItemShoppingCart()) {
			Book theBook = lineItem.getBook();
			String sum = "subtract";
			int number = lineItem.getQuantity();

			Chain chainCalc1 = new AddStock();
			Chain chainCalc2 = new RemoveStock();

			chainCalc1.setNextChain(chainCalc2);

			chainCalc1.calculate(theBook, sum, number);
			bookService.saveOrUpdate(theBook);
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentDate = dateFormat.format(date);

		String username = user.getUsername();
		PurchaseHistory purchaseHistory = new PurchaseHistory(shoppingCart, currentDate, username);

		purchaseHistoryService.create(purchaseHistory);

		ShoppingCart cart = user.getUserShoppingCart();
		cart = null;
		user.setUserShoppingCart(cart);
		// user.getUserShoppingCart().getLineItemShoppingCart().clear();
		// user.getUserShoppingCart().setTotal(0);
		userService.saveOrUpdate(user);

		model.addAttribute("purchaseHistory", purchaseHistory);

		return "home";
	}

	@RequestMapping("/admin")
	public String displayPurchaseHistory(Model model) {
		List<Book> book = bookService.getBook();
		model.addAttribute("book", book);

		List<PurchaseHistory> purchaseHistory = purchaseHistoryService.displayPurchaseHistory();
		// purchaseHistory.get(0).getShoppingCartHistory().getLineItemShoppingCart().get(0).get
		model.addAttribute("purchaseHistory", purchaseHistory);
		return "admin";
	}
}
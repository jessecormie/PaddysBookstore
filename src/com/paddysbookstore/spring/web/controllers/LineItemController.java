package com.paddysbookstore.spring.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.LineItem;
import com.paddysbookstore.spring.web.dao.ShoppingCart;
import com.paddysbookstore.spring.web.dao.User;
import com.paddysbookstore.spring.web.service.BookService;
import com.paddysbookstore.spring.web.service.LineItemService;
import com.paddysbookstore.spring.web.service.UserService;

@Controller
public class LineItemController {

	private LineItemService lineItemService;
	private BookService bookService;
	private UserService userService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setLineItemService(LineItemService lineItemService) {
		this.lineItemService = lineItemService;
	}

	@RequestMapping("/shoppingcart")
	public String showShoppingCart(Model model, Principal principal) {

		User user = userService.getUser(principal.getName());
		ShoppingCart shoppingCart = user.getUserShoppingCart();
		model.addAttribute("lineitemlist", shoppingCart.getLineItemShoppingCart());
		model.addAttribute("totalPrice", shoppingCart.getTotal());
		return "shoppingcart";
	}

	@RequestMapping(value = "/addLineItem/{title}")
	public String addLineItem(@PathVariable String title, Model model, @RequestParam("quantity") int quantity,
			Principal principal) {

		// Get the list of books with that title
		List<Book> book = bookService.getBookDetails(title);
		// Get user that is signed in
		User user = userService.getUser(principal.getName());

		ShoppingCart shoppingCart;

		try {
			// set shoppingcart to equal the users current shoppingcart
			shoppingCart = user.getUserShoppingCart();
		} catch (Exception e) {
			// if they dont have a shoppingcart then create a new one
			shoppingCart = new ShoppingCart();
		}

		// get book object
		Book lineItemBook = book.get(0);
		// Search line items for
		List<LineItem> lineItemList;

		try {
			lineItemList = user.getUserShoppingCart().getLineItemShoppingCart();
			boolean sameBook = false;
			for (LineItem li : lineItemList) {
				if (li.getBook().getTitle().equals(title)) {
					int newQuant = li.getQuantity() + quantity;
					li.setQuantity(newQuant);
					System.out.println("same book");
					sameBook = true;
				}
			}
			if (!sameBook) {
				System.out.println("new book");
				LineItem lineItem = new LineItem(quantity, lineItemBook);
				lineItemList.add(lineItem);
			}

		} catch (Exception e) {
			lineItemList = new ArrayList<LineItem>();
			LineItem lineItem = new LineItem(quantity, lineItemBook);
			lineItemList.add(lineItem);
		}

		double shoppingCartPrice;
		double totalPrice = lineItemBook.getPrice() * quantity;
		try {
			shoppingCartPrice = shoppingCart.getTotal() + totalPrice;
		} catch (Exception e) {
			shoppingCartPrice = totalPrice;
		}

		shoppingCart = new ShoppingCart();
		shoppingCart.setTotal(shoppingCartPrice);
		shoppingCart.setLineItemShoppingCart(lineItemList);
		
		user.setUserShoppingCart(shoppingCart);
		userService.saveOrUpdate(user);
		model.addAttribute("book", book);

		return "bookdetails";
	}

}

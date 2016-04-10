package com.paddysbookstore.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paddysbookstore.spring.web.chainofresponsibility.AddStock;
import com.paddysbookstore.spring.web.chainofresponsibility.Chain;
import com.paddysbookstore.spring.web.chainofresponsibility.RemoveStock;
import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/book")
	public String showBook(Model model) { // HttpSession session
		List<Book> book = bookService.getBook();
		model.addAttribute("book", book);

		return "book";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/book/{title}")
	public String showBookDetails(@PathVariable String title, Model model) {
		System.out.println("test " + title);
		List<Book> book = bookService.getBookDetails(title);
		model.addAttribute("book", book);

		return "bookdetails";
	}

	@RequestMapping(value = "/stock/{title}")
	public String changeStock(@PathVariable String title, Model model, @RequestParam("number") int number,
			@RequestParam("sum") String sum) {

		List<Book> book = bookService.getBookDetails(title);
		Book theBook = book.get(0);

		Chain chainCalc1 = new AddStock();
		Chain chainCalc2 = new RemoveStock();

		chainCalc1.setNextChain(chainCalc2);

		chainCalc1.calculate(theBook, sum, number);
		bookService.saveOrUpdate(theBook);
		model.addAttribute("book", book);

		return "home";
	}

	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam("search") String search, @RequestParam("type") String type) {
		System.out.println("Search: " + search + " Type: " + type);
		
		return "book";
	}

}
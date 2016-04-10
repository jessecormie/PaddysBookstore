package com.paddysbookstore.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.service.BookService;
import com.paddysbookstore.spring.web.service.ReviewService;

@Controller
public class BookController {

	private ReviewService reviewService;
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
	
}
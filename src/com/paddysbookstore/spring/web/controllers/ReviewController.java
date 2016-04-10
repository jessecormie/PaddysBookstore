package com.paddysbookstore.spring.web.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paddysbookstore.spring.web.dao.Book;
import com.paddysbookstore.spring.web.dao.FormValidationGroup;
import com.paddysbookstore.spring.web.dao.Review;
import com.paddysbookstore.spring.web.service.BookService;
import com.paddysbookstore.spring.web.service.ReviewService;
import com.paddysbookstore.spring.web.service.UserService;

@Controller
public class ReviewController {

	private ReviewService reviewService;
	private UserService userService;
	private BookService bookService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) { // HttpSession
																			// session
		System.out.println("Id is: " + id);
		return "home";
	}

	@RequestMapping("/review")
	public String showReview(Model model) { // HttpSession session

		List<Review> review = reviewService.getCurrent();
		model.addAttribute("review", review);

		return "review";
	}

	@RequestMapping("/createreview")
	public String createReview(Model model, Principal principal) { // HttpSession
																	// session
		model.addAttribute("review", new Review());
		return "createreview";
	}

	@RequestMapping(value = "/docreate/{title}", method = RequestMethod.POST)
	public String doCreate(@PathVariable String title, Model model,
			@Validated(value = FormValidationGroup.class) Review review,@PathParam (value="reviewContent") String reviewContent, BindingResult result, Principal principal) {
		
		if (result.hasErrors()) {
			return "home";
		}
	
		String content = review.getReviewContent();
		review.setReviewContent(content.substring(1));
		
		String username = principal.getName();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		String currentdate = dateFormat.format(date);

		review.setUser(userService.getUser(username));
		review.setDate(currentdate);
		
		List<Book> bookList = bookService.getBookDetails(title);
		
		Book book = new Book();
		book = bookList.get(0);
		List<Review> reviewList = book.getUserReviews();
		reviewList.add(review);
		bookService.saveOrUpdate(book);
		System.out.println("Book review: " + book.getUserReviews().get(0).getReviewContent());
		reviewService.create(review);

		return "home";
	}
	

}

package com.paddysbookstore.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.Review;
import com.paddysbookstore.spring.web.dao.ReviewDao;

@Service("reviewService")
public class ReviewService {

	private ReviewDao reviewDao;

	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	public List<Review> getCurrent() {
		return reviewDao.getReview();
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Review review) {
		reviewDao.saveOrUpdate(review);
	}

	public Review getReview(String username) {
		if (username == null) {
			return null;
		}
		List<Review> review = reviewDao.getReview(username);

		if (review.size() == 0) {
			return null;
		}
		return review.get(0);
	}

	// can use if you want to edit the most recent forum
	public void saveOrUpdate(Review review) {
		reviewDao.saveOrUpdate(review);
	}
}

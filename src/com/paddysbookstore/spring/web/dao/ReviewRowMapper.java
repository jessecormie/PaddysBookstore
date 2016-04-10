package com.paddysbookstore.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReviewRowMapper implements RowMapper<Review>{

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setAuthority(rs.getString("authority"));
		user.setEnabled(true);
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setUsername(rs.getString("username"));

		Review review = new Review();
		review.setId(rs.getInt("id"));
		review.setReviewTitle(rs.getString("reviewTitle"));
		review.setReviewContent(rs.getString("reviewContent"));
		review.setUser(user);
		
		return review;
	}

}

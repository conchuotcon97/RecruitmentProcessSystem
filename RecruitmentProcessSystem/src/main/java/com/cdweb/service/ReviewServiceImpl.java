package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.ReviewDao;
import com.cdweb.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
@Autowired
private ReviewDao reviewDao;
	@Override
	public List<Review> getAllReview() {
		return reviewDao.getAllReview();
	}

}

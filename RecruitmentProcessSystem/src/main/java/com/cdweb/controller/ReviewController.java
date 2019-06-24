package com.cdweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.Review;
import com.cdweb.service.ReviewService;

@RestController
@CrossOrigin(value="http://localhost:4200")
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@GetMapping()
	public List<Review> getAllReview(){
		return  reviewService.getAllReview();
	}
	
	
	
	

}

package com.cdweb.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdweb.entity.Review;
@Repository
@Transactional
public class ReviewDaoImpl implements ReviewDao{
@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Review> getAllReview() {
		
		return sessionFactory.getCurrentSession().createCriteria(Review.class).list();
	}
	

}

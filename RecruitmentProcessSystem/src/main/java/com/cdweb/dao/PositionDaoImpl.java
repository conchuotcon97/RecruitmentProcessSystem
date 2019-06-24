package com.cdweb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.entity.Position;

@Repository
public class PositionDaoImpl implements PositionDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<Position> getPositionList() {
		return sessionFactory.getCurrentSession().createQuery("from position").getResultList();
	}

}

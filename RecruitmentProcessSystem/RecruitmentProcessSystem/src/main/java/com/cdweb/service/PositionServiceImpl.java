package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.dao.PositionDao;
import com.cdweb.entity.Position;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionDao positionDao;

	@Override
	public List<Position> getPositionList() {
		return positionDao.getPositionList();
	}

}

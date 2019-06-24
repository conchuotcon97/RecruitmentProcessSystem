package com.cdweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdweb.entity.Position;

public interface PositionDao {
	List<Position> getPositionList();

}

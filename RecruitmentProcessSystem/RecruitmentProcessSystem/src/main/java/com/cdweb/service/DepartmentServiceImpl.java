package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.DepartmentDao;
import com.cdweb.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> departmentLst() {
		return departmentDao.departmentList();
	}

}

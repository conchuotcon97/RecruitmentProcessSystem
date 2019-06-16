package com.cdweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.entity.Department;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Department> departmentList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Department> listDepartment = session.createQuery("from department").getResultList();
		return listDepartment;
	}

}

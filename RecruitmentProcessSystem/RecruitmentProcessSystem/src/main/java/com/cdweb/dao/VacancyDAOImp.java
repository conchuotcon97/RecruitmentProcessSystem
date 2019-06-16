package com.cdweb.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdweb.entity.Department;
import com.cdweb.entity.Position;
import com.cdweb.entity.User;
import com.cdweb.entity.Vacancy;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VacancyDAOImp implements VacancyDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Vacancy> getListVacancy() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from vacancy";
		List<Vacancy> listVacancy = session.createQuery(sql).getResultList();
		return listVacancy;
	}

//	@Override
//	@Transactional
//	public void addVacancy(String positionName, int numberOpening, String departmentName,
//			String description, String offer, int experience, String gender, String degree, String typeOfStaff, String dateClose,String status) {
//		Session session = sessionFactory.getCurrentSession();
//		Vacancy vacancy = new Vacancy();
//		Position position = (Position) session.createQuery("from position where positionName = '" + positionName + "'")
//				.getSingleResult();
//		Department department = (Department) session
//				.createQuery("from department where departmentName = '" + departmentName + "'").getSingleResult();
//		int maxID = (Integer) session.createQuery("SELECT max(idVacancy) from vacancy").getSingleResult();
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		User user = (User) session.createQuery("from user where username = '" + username + "'").getSingleResult();
//		boolean b = false;
//		if (gender.equals("Male")) {
//			b = true;
//		} else if (gender.equals("Female")) {
//			b = false;
//		}
//
//		vacancy.setVacancyNumber("F" + (maxID + 1));
//		vacancy.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
//		vacancy.setDateClose(Timestamp.valueOf(dateClose));
//		vacancy.setPosition(position);
//		vacancy.setNumberOpening(numberOpening);
//		vacancy.setDepartment(department);
////		vacancy.setRequirement(requirement);
//		vacancy.setUser(user);
//		vacancy.setState("Open");
//		vacancy.setDescription(description);
//		vacancy.setOffer(offer);
//		vacancy.setExperience(experience);
//		vacancy.setGender(b);
//		vacancy.setDegree(degree);
//		session.save(vacancy);
//	}

	

//	@Override
//	@Transactional
//	public void addVacancy(String positionName, int numberOpening, String departmentName, String requirement,
//			String description, String offer, int experience, String gender, String degree, String dateClose,
//			String status, String typeOfStaff) {
//		Session session = sessionFactory.getCurrentSession();
//		Vacancy vacancy = new Vacancy();
//		Position position = (Position) session.createQuery("from position where positionName = '" + positionName + "'")
//				.getSingleResult();
//		Department department = (Department) session
//				.createQuery("from department where departmentName = '" + departmentName + "'").getSingleResult();
//		int maxID = (Integer) session.createQuery("SELECT max(idVacancy) from vacancy").getSingleResult();
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		User user = (User) session.createQuery("from user where username = '" + username + "'").getSingleResult();
//		boolean b = false;
//		if (gender.equalsIgnoreCase("male")) {
//			b = true;
//		} else if (!gender.equalsIgnoreCase("female")) {
//			b = false;
//		}
//
//		vacancy.setVacancyNumber("F" + (maxID + 1));
//		vacancy.setDateCreated(Date.valueOf(LocalDate.now()));
//		vacancy.setDateClose(Date.valueOf(dateClose));
//		vacancy.setPosition(position);
//		vacancy.setNumberOpening(numberOpening);
//		vacancy.setDepartment(department);
//		vacancy.setRequirement(requirement);
//		vacancy.setUser(user);
//		vacancy.setState("Open");
//		vacancy.setDescription(description);
//		vacancy.setOffer(offer);
//		vacancy.setExperience(experience);
//		vacancy.setGender(b);
//		vacancy.setDegree(degree);
//		vacancy.setTypeOfStaff(typeOfStaff);
//		session.save(vacancy);
//	}
	
	@Override
	@Transactional
	public void addVacancy(Vacancy v) {
		sessionFactory.getCurrentSession().save(v);
	}
	
}

package com.cdweb.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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



	@Override
	@Transactional
	public void addVacancy(Vacancy v) {
		Session session = sessionFactory.getCurrentSession();
		Vacancy vacancy = new Vacancy();

		int maxID = (Integer) session.createQuery("SELECT max(idVacancy) from vacancy").getSingleResult();

		vacancy.setVacancyNumber("F" + (maxID + 1));
		vacancy.setDateCreated(Date.valueOf(LocalDate.now()));
		vacancy.setDateClose(v.getDateClose());
		vacancy.setPosition(v.getPosition());
		vacancy.setNumberOpening(v.getNumberOpening());
		vacancy.setDepartment(v.getDepartment());
		vacancy.setRequirement(v.getRequirement());
		vacancy.setUser(v.getUser());
		vacancy.setState("Open");
		vacancy.setDescription(v.getDescription());
		vacancy.setOffer(v.getOffer());
		vacancy.setExperience(v.getExperience());
		vacancy.setGender(true);
		vacancy.setDegree(v.getDegree());
		vacancy.setTypeOfStaff(v.getTypeOfStaff());
		session.save(vacancy);
	}

	@Transactional
	@Override
	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		// Delete a persistent object

		try {
			Vacancy vacancy = session.find(Vacancy.class, id);
			if (vacancy != null) {
				session.delete(vacancy);
				System.out.println("vacan 1 is deleted");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

//		finally {
//			session.close();
//		}
	}
	
	@Transactional
	public Vacancy getVacancy(int idVacancy) {
		Session session = sessionFactory.getCurrentSession();
		Vacancy vacancy = (Vacancy) session.find(Vacancy.class, idVacancy);
		return vacancy;
	}

}

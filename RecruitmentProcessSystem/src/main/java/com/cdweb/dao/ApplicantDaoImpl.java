package com.cdweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.entity.ApplicantDetails;
import com.cdweb.entity.ApplicantVacancy;

@Repository
@Transactional
public class ApplicantDaoImpl implements ApplicantDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void deleleApplicantByIdVacancy(int idVacancy) {
		Session session = sessionFactory.getCurrentSession();
		List<ApplicantVacancy> pllicantVacancyList = (List<ApplicantVacancy>) session
				.createQuery("from ApplicantVacancy where idVacancy = '" + idVacancy + "'").getResultList();
		for (ApplicantVacancy applicantVacancy : pllicantVacancyList) {
			session.delete(applicantVacancy);
			ApplicantDetails applDetails= (ApplicantDetails)session.createQuery("from ApplicantDetails where idApplicantDetails='"+applicantVacancy.getIdApplicantVacancy()+"'").getSingleResult();
			session.delete(applDetails);
		}
		
		session.createQuery("Delete from ApplicantVacancy where idVacancy = '" + idVacancy + "'").executeUpdate();

	}

	@Override
	@Transactional
	public void deleteApplicantDetailsByIdApplicant(int idApplicant) {
		Session session = sessionFactory.getCurrentSession();

		session.createQuery("Delete from ApplicantDetails where idApplicantVacancy = '" + idApplicant + "'")
				.executeUpdate();

	}

}

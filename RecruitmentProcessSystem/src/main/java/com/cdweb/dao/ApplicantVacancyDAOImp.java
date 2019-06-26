package com.cdweb.dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;

import com.cdweb.entity.ApplicantVacancy;
import com.cdweb.entity.ScheduleInterviewDetails;
import com.cdweb.entity.UserRole;
import com.cdweb.entity.Vacancy;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicantVacancyDAOImp implements ApplicantVacancyDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ApplicantVacancy> getListApplicantVacancy(int idVacancy) {
		Session session = sessionFactory.getCurrentSession();

		
		List<ApplicantVacancy> listApplicantVacancy = session
				.createQuery("from ApplicantVacancy where idVacancy = '" + idVacancy + "'").getResultList();

		System.out.println(listApplicantVacancy.size());
		return listApplicantVacancy;
	}

	@Transactional
	public void addApplicantVacancy(int idVacancy, ApplicantVacancy applicant) {

		Session session = sessionFactory.getCurrentSession();
		if (applicant.getScheduleInterviewDetails().getDateOfTheScheduleInterview()
				.compareTo(Date.valueOf(LocalDate.now())) > 0) {
			if (applicant.getScheduleInterviewDetails().getEndTime()
					.compareTo(applicant.getScheduleInterviewDetails().getStartTime()) > 0) {
				ScheduleInterviewDetails scheduleInterviewDetails = new ScheduleInterviewDetails();
				scheduleInterviewDetails.setDateOfTheScheduleInterview(
						applicant.getScheduleInterviewDetails().getDateOfTheScheduleInterview());
				scheduleInterviewDetails.setStartTime(applicant.getScheduleInterviewDetails().getStartTime());
				scheduleInterviewDetails.setEndTime(applicant.getScheduleInterviewDetails().getEndTime());
				session.save(scheduleInterviewDetails);

				ApplicantVacancy applicantVacancy = new ApplicantVacancy();
				int maxId = (Integer) session.createQuery("select max(idApplicantVacancy) from ApplicantVacancy")
						.getSingleResult();
				Vacancy vacancy = (Vacancy) session.find(Vacancy.class, idVacancy);
				applicantVacancy.setApplicantNumber("A" + (maxId + 1));
				applicantVacancy.setApplicantVacancyName(applicant.getApplicantVacancyName());
				applicantVacancy.setEmailApplicant(applicant.getEmailApplicant());
				applicantVacancy.setVacancy(vacancy);
				applicantVacancy.setDateOnApplicantVacancy(applicant.getDateOnApplicantVacancy());
				applicantVacancy.setState(applicant.getState());
				applicantVacancy.setCv(applicant.getCv());
				applicantVacancy.setScheduleInterviewDetails(scheduleInterviewDetails);
				session.save(applicantVacancy);

				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
				MailSender mailSender = (MailSender) context.getBean("mailSender2");
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setFrom("trthi95@gmail.com");
				simpleMailMessage.setTo(applicant.getEmailApplicant());
				simpleMailMessage.setSubject(vacancy.getDescription());
				simpleMailMessage.setText("moi ban " + applicant.getApplicantVacancyName() + "toi phong van vao "
						+ scheduleInterviewDetails.getEndTime() + " "
						+ scheduleInterviewDetails.getDateOfTheScheduleInterview());
				mailSender.send(simpleMailMessage);
				System.out.println("sending successful");
				context.close();
			}
		}
	}

	@Transactional
	public ApplicantVacancy getApplicantVacancy(int idApplicant) {
		Session session = sessionFactory.getCurrentSession();
		ApplicantVacancy applicantVacancy = (ApplicantVacancy) session.find(ApplicantVacancy.class, idApplicant);

		return applicantVacancy;
	}

	@Transactional
	public ApplicantVacancy editApplicantVacancy(ApplicantVacancy applicant) {
		Session session = sessionFactory.getCurrentSession();

		ScheduleInterviewDetails scheduleInterviewDetails = applicant.getScheduleInterviewDetails();
		System.out.println(scheduleInterviewDetails.getDateOfTheScheduleInterview());
		if (scheduleInterviewDetails.getDateOfTheScheduleInterview().compareTo(Date.valueOf(LocalDate.now())) > 0) {
			if (scheduleInterviewDetails.getEndTime().compareTo(scheduleInterviewDetails.getStartTime()) > 0) {

				session.update(applicant);

			}
		}
		return applicant;
	}

	@Override
	public List<ApplicantVacancy> getListApplicant() {
		return sessionFactory.getCurrentSession().createQuery("from applicant_vacancy").list();
	}

}

package com.cdweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.entity.InterviewerScheduleInterview;

@Repository
public class InterviewerScheduleInterviewDAOImp implements InterviewerScheduleInterviewDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterviewById(int idSchedule) {
		Session session = sessionFactory.getCurrentSession();
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = session
				.createQuery("from interviewer_scheduleinterview where idSchedule = '" + idSchedule + "'")
				.getResultList();
		return listInterviewerScheduleInterview;
	}
	@Transactional
	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterview() {
		Session session = sessionFactory.getCurrentSession();
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = session
				.createQuery("from interviewer_scheduleinterview")
				.getResultList();
		return listInterviewerScheduleInterview;
	}

}

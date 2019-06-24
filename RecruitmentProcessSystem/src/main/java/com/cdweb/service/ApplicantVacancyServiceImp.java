package com.cdweb.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.ApplicantVacancyDAO;
import com.cdweb.entity.ApplicantVacancy;

@Service
public class ApplicantVacancyServiceImp implements ApplicantVacancyService {
	@Autowired
	ApplicantVacancyDAO applicantVacancyDAO;

	public List<ApplicantVacancy> getListApplicantVacancy(int idVacancy) {

		return applicantVacancyDAO.getListApplicantVacancy(idVacancy);
	}

	public void addApplicantVacancy(String vacancyNumber, String applicantVacancyName, String emailApplicant,
			Date dateOnApplicantVacancy, String state, String cv, Date dateOfTheScheduleInterview, Time startTime,
			Time endTime, List<Integer> listIdUser) {
		applicantVacancyDAO.addApplicantVacancy(vacancyNumber, applicantVacancyName, emailApplicant,
				dateOnApplicantVacancy, state, cv, dateOfTheScheduleInterview, startTime, endTime, listIdUser);

	}

	public ApplicantVacancy getApplicantVacancy(String applicantNumber) {
		return applicantVacancyDAO.getApplicantVacancy(applicantNumber);
	}

	public ApplicantVacancy editApplicantVacancy(String vacancyNumber, String applicantNumber, String applicantVacancyName,
			String emailApplicant, Date dateOnApplicantVacancy, String state, String cv,
			Date dateOfTheScheduleInterview, Time startTime, Time endTime) {
		return applicantVacancyDAO.editApplicantVacancy(vacancyNumber, applicantNumber, applicantVacancyName, emailApplicant,
				dateOnApplicantVacancy, state, cv, dateOfTheScheduleInterview, startTime, endTime);

	}

}

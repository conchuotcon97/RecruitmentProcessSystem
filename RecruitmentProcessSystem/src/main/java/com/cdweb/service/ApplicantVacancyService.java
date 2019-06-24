package com.cdweb.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.cdweb.entity.ApplicantVacancy;

public interface ApplicantVacancyService {
	public List<ApplicantVacancy> getListApplicantVacancy(int idVacancy);

	public void addApplicantVacancy(String vacancyNumber, String applicantVacancyName, String emailApplicant,
			Date dateOnApplicantVacancy, String state, String cv, Date dateOfTheScheduleInterview, Time startTime,
			Time endTime, List<Integer> listIdUser);

	public ApplicantVacancy getApplicantVacancy(String applicantNumber);

	public ApplicantVacancy editApplicantVacancy(String vacancyNumber, String applicantNumber, String applicantVacancyName,
			String emailApplicant, Date dateOnApplicantVacancy, String state, String cv,
			Date dateOfTheScheduleInterview, Time startTime, Time endTime);
}

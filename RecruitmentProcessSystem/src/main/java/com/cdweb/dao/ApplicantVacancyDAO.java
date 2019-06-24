package com.cdweb.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdweb.entity.ApplicantVacancy;

public interface ApplicantVacancyDAO {
	public List<ApplicantVacancy> getListApplicantVacancy(int idVacancy);

	public void addApplicantVacancy(String vacancyNumber, String applicantVacancyName, String emailApplicant,
			Date dateOnApplicantVacancy, String state, String cv, Date dateOfTheScheduleInterview, Time startTime,
			Time endTime, List<Integer> listIdUser);

	public ApplicantVacancy getApplicantVacancy(String applicantNumber);

	public ApplicantVacancy editApplicantVacancy(String vacancyNumber, String applicantNumber, String applicantVacancyName,
			String emailApplicant, Date dateOnApplicantVacancy, String state,String cv, Date dateOfTheScheduleInterview,
			Time startTime, Time endTime);
	
	public ApplicantVacancy getApplicantVacancyByIdSchedule(int IdSchedule);
}

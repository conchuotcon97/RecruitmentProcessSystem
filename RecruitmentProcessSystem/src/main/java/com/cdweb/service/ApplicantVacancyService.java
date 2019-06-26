package com.cdweb.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.cdweb.entity.ApplicantVacancy;

public interface ApplicantVacancyService {
	public List<ApplicantVacancy> getListApplicantVacancy(int idVacancy);

	public void addApplicantVacancy(int idVacancy,ApplicantVacancy applicant);

	public ApplicantVacancy getApplicantVacancy(int idApplicant);

	public ApplicantVacancy editApplicantVacancy(ApplicantVacancy applicant);
public List<ApplicantVacancy> getListApplicant();
}

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
	public List<ApplicantVacancy> getListApplicant();

	public void addApplicantVacancy(int id, ApplicantVacancy applicant);

	public ApplicantVacancy getApplicantVacancy(int	idApplicant);

	public ApplicantVacancy editApplicantVacancy(ApplicantVacancy applicant);
}

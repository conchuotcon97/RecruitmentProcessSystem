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

	@Override
	public List<ApplicantVacancy> getListApplicantVacancy(int idVacancy) {

		return applicantVacancyDAO.getListApplicantVacancy(idVacancy);
	}

	public void addApplicantVacancy(int idVacancy, ApplicantVacancy applicant) {
		applicantVacancyDAO.addApplicantVacancy(idVacancy,applicant);

	}

	public ApplicantVacancy getApplicantVacancy(int idApplicant) {
		return applicantVacancyDAO.getApplicantVacancy(idApplicant);
	}

	public ApplicantVacancy editApplicantVacancy(ApplicantVacancy applicant) {
		return applicantVacancyDAO.editApplicantVacancy(applicant);

	}

	@Override
	public List<ApplicantVacancy> getListApplicant() {
		return applicantVacancyDAO.getListApplicant();
	}

}

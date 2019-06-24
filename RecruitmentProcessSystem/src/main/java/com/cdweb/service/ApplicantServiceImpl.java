package com.cdweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.ApplicantDao;

@Service
public class ApplicantServiceImpl implements ApplicantService{
	@Autowired
	private ApplicantDao applicantDao;

	@Override
	public void deleleApplicantByIdVacancy(int idVacancy) {
		applicantDao.deleleApplicantByIdVacancy(idVacancy);
		
	}

	@Override
	public void deleteApplicantDetailsByIdApplicant(int idApplicant) {
	applicantDao.deleteApplicantDetailsByIdApplicant(idApplicant);
		
	}

}

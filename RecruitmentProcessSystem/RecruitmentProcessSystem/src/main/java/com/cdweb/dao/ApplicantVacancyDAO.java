package com.cdweb.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.cdweb.imp.ApplicantVacancyInt;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicantVacancyDAO implements ApplicantVacancyInt{
	
	public void addApplicantVacancy() {
		
	}

}

package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.VacancyDAO;
import com.cdweb.entity.Vacancy;

@Service
public class VacancyServiceImp implements VacancyService {

	@Autowired
	VacancyDAO vacancyDAO;

	@Override
	public List<Vacancy> getListVacancy() {
		return vacancyDAO.getListVacancy();
	}
	@Override
	public void addVacancy(Vacancy v) {
		vacancyDAO.addVacancy(v);
	}

	@Override
	public void remove(int id) {
vacancyDAO.remove(id);		
	}
	@Override
	public Vacancy getVacancy(int idVacancy) {
		return vacancyDAO.getVacancy(idVacancy);
	}


}

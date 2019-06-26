package com.cdweb.dao;

import java.util.List;

import com.cdweb.entity.Vacancy;

public interface VacancyDAO {
	public List<Vacancy> getListVacancy();

	public void addVacancy(Vacancy v);

	public void remove(int id);
	public Vacancy getVacancy(int idVacancy);
}
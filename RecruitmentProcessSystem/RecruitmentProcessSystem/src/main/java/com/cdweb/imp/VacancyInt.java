package com.cdweb.imp;

import java.util.List;

import com.cdweb.entity.Vacancy;

public interface VacancyInt {
	public List<Vacancy> getListVacancy();

	public void addVacancy(String positionName, int numberOpening, String departmentName, String requirement,
			String description, String offer, int experience, String gender, String degree);
}

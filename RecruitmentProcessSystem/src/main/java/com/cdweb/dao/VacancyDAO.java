package com.cdweb.dao;

import java.util.List;

import com.cdweb.entity.Vacancy;

public interface VacancyDAO {
	public List<Vacancy> getListVacancy();

	public void addVacancy(Vacancy v);
//	public void addVacancy(String positionName, int numberOpening, String departmentName, 
//			String description, String offer, int experience, String gender, String degree,
//			String typeOfStaff, String dateClose,String status);
//}

	public void remove(int id);
}
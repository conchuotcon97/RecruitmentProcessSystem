package com.cdweb.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.cdweb.entity.Vacancy;

public interface VacancyService {

	public List<Vacancy> getListVacancy();

//	public void addVacancy(String positionName, int numberOpening,
//			 String departmentName,  String requirement,  String description,
//			 String offer,  int experience,  String gender,
//			  String degree,String dateClose, String status,String typeOfStaff);
	public void addVacancy(Vacancy v);

	public void remove(int id);

//	public void addVacancy(String positionName, int numberOpening, String departmentName, 
//			String description, String offer, int experience, String gender, String degree,
//			String typeOfStaff, String dateClose,String status);
}
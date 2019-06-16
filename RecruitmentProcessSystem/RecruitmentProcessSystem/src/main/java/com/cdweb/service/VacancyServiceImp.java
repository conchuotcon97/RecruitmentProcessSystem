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

//	@Override
//	public void addVacancy(String positionName, int numberOpening, String departmentName, String description,
//			String offer, int experience, String gender, String degree, String typeOfStaff, String dateClose,
//			String status) {
//
//		vacancyDAO.addVacancy(positionName, numberOpening, departmentName, description, offer, experience, gender,
//				degree, typeOfStaff, dateClose, status);
//
//	}
	@Override
	public void addVacancy(Vacancy v) {
		vacancyDAO.addVacancy(v);
	}

//	@Override
//	public void addVacancy(String positionName, int numberOpening,
//			 String departmentName,  String requirement,  String description,
//			 String offer,  int experience,  String gender,
//			  String degree,String dateClose, String status,String typeOfStaff) {
//		 vacancyDAO.addVacancy(positionName,numberOpening,departmentName,requirement,description,offer,experience,gender,degree,dateClose,status,typeOfStaff);
//	}

}

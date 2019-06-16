package com.cdweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.Department;
import com.cdweb.entity.Position;
import com.cdweb.entity.Vacancy;
import com.cdweb.service.DepartmentService;
import com.cdweb.service.PositionService;
import com.cdweb.service.VacancyService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
//@RequestMapping("/")
public class VacancyController {
	@Autowired
	VacancyService vacancyService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	PositionService positionService;

	@RequestMapping("/vacancys")
	public ResponseEntity<List<Vacancy>> getListVacancy() {
		List<Vacancy> lst = vacancyService.getListVacancy();
		System.out.println("accessed on list vacancy with username:"
				+ SecurityContextHolder.getContext().getAuthentication().getName() + "Role:"
				+ SecurityContextHolder.getContext().getAuthentication().getAuthorities() + "isAuthentited:"
				+ SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
		return ResponseEntity.ok().body(lst);

	}

	@RequestMapping(value = "/addVacancy", method = RequestMethod.POST, produces = "application/json")
	public void addVacancyDefault(@RequestBody  Vacancy v) {
		vacancyService.addVacancy(v);

		
	}

}

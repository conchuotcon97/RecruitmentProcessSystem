package com.cdweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.ApplicantVacancy;
import com.cdweb.entity.Department;
import com.cdweb.entity.InterviewerScheduleInterview;
import com.cdweb.entity.Position;
import com.cdweb.entity.Vacancy;
import com.cdweb.service.ApplicantService;
import com.cdweb.service.ApplicantVacancyService;
import com.cdweb.service.DepartmentService;
import com.cdweb.service.InterviewerScheduleInterviewService;
import com.cdweb.service.PositionService;
import com.cdweb.service.VacancyService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
//@RequestMapping("/")
public class VacancyController {
	@Autowired
	ApplicantVacancyService applicantVacancyService;

	@Autowired
	InterviewerScheduleInterviewService interviewerScheduleInterviewService;
	@Autowired
	VacancyService vacancyService;
@Autowired
ApplicantService applicantService;
	@Autowired
	DepartmentService departmentService;

	@Autowired
	PositionService positionService;

	@RequestMapping("/vacancys")
	public List<Vacancy> getListVacancy() {
		List<Vacancy> lst = vacancyService.getListVacancy();
		System.out.println("accessed on list vacancy with username:"
				+ SecurityContextHolder.getContext().getAuthentication().getName() + "Role:"
				+ SecurityContextHolder.getContext().getAuthentication().getAuthorities() + "isAuthentited:"
				+ SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
		return lst;

	}

	@RequestMapping(value = "/vacancys", method = RequestMethod.POST, produces = "application/json")
	public void addVacancyDefault(@RequestBody  Vacancy v) {
		vacancyService.addVacancy(v);

		
	}
	@RequestMapping(value = "/vacancys/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Vacancy deleteVacancy(@PathVariable int id) {
		System.out.println("vao xu ly delate");
		Vacancy  vacancy=null;
		for (Vacancy v : this.getListVacancy()) {
			if(v.getIdVacancy()==id) {
//				applicantService.deleleApplicantByIdVacancy(id);
				System.out.println("All applicant on this vacany will not exist ");
				vacancyService.remove(id);
			vacancy=v;
			break;
			}
		}
		System.out.println("delete vacancy sucess");
		return vacancy;
		
	}
	@RequestMapping(value = "/vacancys/{idVacancy}/applicants",method = RequestMethod.GET,produces = "application/json")
	public Map<ApplicantVacancy, List<InterviewerScheduleInterview>> applicantList(@PathVariable(value = "idVacancy") int idVacancy) {
		List<ApplicantVacancy> listApplicantVacancy = applicantVacancyService.getListApplicantVacancy(idVacancy);
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = interviewerScheduleInterviewService
				.getListInterviewerScheduleInterview();
		Map<ApplicantVacancy, List<InterviewerScheduleInterview>> models = new HashMap<ApplicantVacancy, List<InterviewerScheduleInterview>>();
		for (ApplicantVacancy applicantVacancy : listApplicantVacancy) {
			System.out.println(applicantVacancy.toString());
			int idSchedule = applicantVacancy.getScheduleInterviewDetails().getIdSchedule();
			listInterviewerScheduleInterview = interviewerScheduleInterviewService
					.getListInterviewerScheduleInterviewById(idSchedule);
			models.put(applicantVacancy, listInterviewerScheduleInterview);
			for (InterviewerScheduleInterview interviewerScheduleInterview : listInterviewerScheduleInterview) {
				System.out.println(interviewerScheduleInterview.getUser().getFullName());
			}
		}
		System.out.println(" handler het list applicant by id vacancy");

		return models;
	}

}

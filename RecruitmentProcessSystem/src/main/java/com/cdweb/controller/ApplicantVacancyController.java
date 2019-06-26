package com.cdweb.controller;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdweb.entity.ApplicantVacancy;
import com.cdweb.entity.InterviewerScheduleInterview;
import com.cdweb.entity.Vacancy;
import com.cdweb.service.ApplicantVacancyService;
import com.cdweb.service.InterviewerScheduleInterviewService;
import com.cdweb.service.VacancyService;

@Controller
@RequestMapping("hr/")
public class ApplicantVacancyController {

	@Autowired
	ApplicantVacancyService applicantVacancyService;
	@Autowired
	InterviewerScheduleInterviewService interviewerScheduleInterviewService;
	@Autowired
	VacancyService vacancyService;

	@RequestMapping("applicants")
	public Map<ApplicantVacancy, List<InterviewerScheduleInterview>> getApplicantList() {
		List<ApplicantVacancy> listApplicantVacancy = applicantVacancyService.getListApplicant();
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

	@RequestMapping(path = "vacancys/{idVacancy}/applicants/addApplicantVacancy", method = RequestMethod.POST)
	public void addApplicantVacancy(@PathVariable int idVacancy, @RequestBody ApplicantVacancy applicant) {

		Vacancy vacancy = vacancyService.getVacancy(idVacancy);
		String description = vacancy.getDescription();
		applicantVacancyService.addApplicantVacancy(idVacancy, applicant);
	}

	@PutMapping("applicants/{idApplicant}")
	public ResponseEntity<Object> editApplicantVacancy(@PathVariable int idApplicant,
			@RequestBody ApplicantVacancy applicant) {
		ApplicantVacancy applicantVacancy = applicantVacancyService.getApplicantVacancy(idApplicant);
		if (applicantVacancy == null)
			return ResponseEntity.notFound().build();

		applicant.setIdApplicantVacancy(idApplicant);
		applicantVacancyService.editApplicantVacancy(applicant);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value = "/vacancys/{idVacancy}/applicants", method = RequestMethod.POST)
	public  Map<String, Object> PostFormDataByMap(@RequestBody Map<String, Object> obj) {	
		
		return obj;
	}

}

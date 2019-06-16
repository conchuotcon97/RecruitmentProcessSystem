package com.cdweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hr/")
public class ApplicantVacancy {
	
	@RequestMapping("applicantVacancy")
	public String pageDefault(){
		return "applicantVacancy";
	}
}

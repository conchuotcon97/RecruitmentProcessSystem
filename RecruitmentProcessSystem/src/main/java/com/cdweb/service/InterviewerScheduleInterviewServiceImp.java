package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.InterviewerScheduleInterviewDAO;
import com.cdweb.entity.InterviewerScheduleInterview;

@Service
public class InterviewerScheduleInterviewServiceImp implements InterviewerScheduleInterviewService {
	@Autowired
	InterviewerScheduleInterviewDAO interviewerScheduleInterviewDAO;

	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterviewById(int idSchedule) {
		return interviewerScheduleInterviewDAO.getListInterviewerScheduleInterviewById(idSchedule);
	}

	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterview() {
		return interviewerScheduleInterviewDAO.getListInterviewerScheduleInterview();
	}

}

package com.cdweb.service;

import java.util.List;

import com.cdweb.entity.InterviewerScheduleInterview;

public interface InterviewerScheduleInterviewService {
	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterviewById(int idSchedule);
	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterview();
}

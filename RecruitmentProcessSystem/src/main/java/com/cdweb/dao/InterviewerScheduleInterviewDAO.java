package com.cdweb.dao;

import java.util.List;

import com.cdweb.entity.InterviewerScheduleInterview;

public interface InterviewerScheduleInterviewDAO {
	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterviewById(int idSchedule);
	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterview();
}

package com.cdweb.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "schedule_interview_details")
public class ScheduleInterviewDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSchedule;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfTheScheduleInterview;
	private Time startTime;
	private Time endTime;
	
	@JoinColumn(name="idSchedule")
	@OneToMany(fetch = FetchType.EAGER)
	private List<InterviewerScheduleInterview> listInterviewerScheduleInterview;

	@JoinColumn(name="idSchedule")
	@OneToMany
	@JsonIgnore
	private List<ApplicantVacancy> listApplicantVacancy;
	
	public ScheduleInterviewDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Date getDateOfTheScheduleInterview() {
		return dateOfTheScheduleInterview;
	}

	public void setDateOfTheScheduleInterview(Date dateOfTheScheduleInterview) {
		this.dateOfTheScheduleInterview = dateOfTheScheduleInterview;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public List<InterviewerScheduleInterview> getListInterviewerScheduleInterview() {
		return listInterviewerScheduleInterview;
	}

	public void setListInterviewerScheduleInterview(List<InterviewerScheduleInterview> listInterviewerScheduleInterview) {
		this.listInterviewerScheduleInterview = listInterviewerScheduleInterview;
	}

	public List<ApplicantVacancy> getListApplicantVacancy() {
		return listApplicantVacancy;
	}

	public void setListApplicantVacancy(List<ApplicantVacancy> listApplicantVacancy) {
		this.listApplicantVacancy = listApplicantVacancy;
	}
}

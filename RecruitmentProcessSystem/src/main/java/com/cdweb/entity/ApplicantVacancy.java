package com.cdweb.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.jmx.snmp.Timestamp;

@Entity
@Table(name = "applicant_vacancy")
public class ApplicantVacancy implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idApplicantVacancy;
	private String applicantNumber;
	private String applicantVacancyName;
	private String emailApplicant;

	@JoinColumn(name = "idVacancy")
	@OneToOne
	private Vacancy vacancy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOnApplicantVacancy;
	private String state;
	private String cv;

	@JoinColumn(name = "idSchedule")
	@OneToOne

	private ScheduleInterviewDetails scheduleInterviewDetails;
	@JsonIgnore
	@JoinColumn(name = "idApplicantVacancy")
	@OneToOne(cascade = CascadeType.REMOVE)
	private ApplicantDetails listApplicantDetails;
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "idApplicantVacancy")
	private List<Review> listReview;

	public ApplicantVacancy() {
		// TODO Auto-generated constructor stub
	}

	public int getIdApplicantVacancy() {
		return idApplicantVacancy;
	}

	public void setIdApplicantVacancy(int idApplicantVacancy) {
		this.idApplicantVacancy = idApplicantVacancy;
	}

	public String getApplicantNumber() {
		return applicantNumber;
	}

	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
	}

	public String getApplicantVacancyName() {
		return applicantVacancyName;
	}

	public void setApplicantVacancyName(String applicantVacancyName) {
		this.applicantVacancyName = applicantVacancyName;
	}

	public String getEmailApplicant() {
		return emailApplicant;
	}

	public void setEmailApplicant(String emailApplicant) {
		this.emailApplicant = emailApplicant;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public Date getDateOnApplicantVacancy() {
		return dateOnApplicantVacancy;
	}

	public void setDateOnApplicantVacancy(Date dateOnApplicantVacancy) {
		this.dateOnApplicantVacancy = dateOnApplicantVacancy;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public ScheduleInterviewDetails getScheduleInterviewDetails() {
		return scheduleInterviewDetails;
	}

	public void setScheduleInterviewDetails(ScheduleInterviewDetails scheduleInterviewDetails) {
		this.scheduleInterviewDetails = scheduleInterviewDetails;
	}

	public ApplicantDetails getListApplicantDetails() {
		return listApplicantDetails;
	}

	public void setListApplicantDetails(ApplicantDetails listApplicantDetails) {
		this.listApplicantDetails = listApplicantDetails;
	}

	public List<Review> getListReview() {
		return listReview;
	}

	public void setListReview(List<Review> listReview) {
		this.listReview = listReview;
	}

	@Override
	public String toString() {
		return "ApplicantVacancy [idApplicantVacancy=" + idApplicantVacancy + ", applicantNumber=" + applicantNumber
				+ ", applicantVacancyName=" + applicantVacancyName + ", emailApplicant=" + emailApplicant + ", vacancy="
				+ vacancy + ", dateOnApplicantVacancy=" + dateOnApplicantVacancy + ", state=" + state + ", cv=" + cv
				+ ", scheduleInterviewDetails=" + scheduleInterviewDetails 
				 + "]";
	}
	
}

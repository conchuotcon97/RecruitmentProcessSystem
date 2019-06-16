package com.cdweb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReview;

	@OneToOne
	@JoinColumn(name = "idApplicantVacancy")
	private ApplicantVacancy applicantVacancy;
	private String positionRecommend;
	private String technicalReview;
	private String behaviorReview;
	private int experience;
	private String languageReview;
	private String result;
	private String note;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public int getIdReview() {
		return idReview;
	}

	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}

	public ApplicantVacancy getApplicantVacancy() {
		return applicantVacancy;
	}

	public void setApplicantVacancy(ApplicantVacancy applicantVacancy) {
		this.applicantVacancy = applicantVacancy;
	}

	public String getPositionRecommend() {
		return positionRecommend;
	}

	public void setPositionRecommend(String positionRecommend) {
		this.positionRecommend = positionRecommend;
	}

	public String getTechnicalReview() {
		return technicalReview;
	}

	public void setTechnicalReview(String technicalReview) {
		this.technicalReview = technicalReview;
	}

	public String getBehaviorReview() {
		return behaviorReview;
	}

	public void setBehaviorReview(String behaviorReview) {
		this.behaviorReview = behaviorReview;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getLanguageReview() {
		return languageReview;
	}

	public void setLanguageReview(String languageReview) {
		this.languageReview = languageReview;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}

package com.cdweb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "vacancy")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Vacancy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacancy;

	private String vacancyNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp dateCreated;

	@JoinColumn(name = "idUser")
	@OneToOne

	private User user;

	private String state;

	@JoinColumn(name = "idPosition")
	@OneToOne
	private Position position;

	private String description;
	private int numberOpening;

	@JoinColumn(name = "idDepartment")
	@OneToOne
	private Department department;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp dateClose;

	private String requirement;
	private String offer;
	private int experience;
	private boolean gender;
	private String degree;
	private String typeOfStaff;;

	@JoinColumn(name = "idVacancy")
	@JsonIgnore
	@OneToMany
	private List<ApplicantVacancy> listApplicantVacancy;

	public Vacancy() {
		// TODO Auto-generated constructor stub
	}

	public Vacancy(int idVacancy, String vacancyNumber, Timestamp TimestampCreated, User user, String state, Position position,
			String description, int numberOpening, Department department, java.sql.Timestamp TimestampClose, String requirement,
			String offer, int experience, boolean gender, String degree, String typeOfStaff,
			List<ApplicantVacancy> listApplicantVacancy) {
		super();
		this.idVacancy = idVacancy;
		this.vacancyNumber = vacancyNumber;
		this.dateCreated = TimestampCreated;
		this.user = user;
		this.state = state;
		this.position = position;
		this.description = description;
		this.numberOpening = numberOpening;
		this.department = department;
		this.dateClose = TimestampClose;
		this.requirement = requirement;
		this.offer = offer;
		this.experience = experience;
		this.gender = gender;
		this.degree = degree;
		this.typeOfStaff = typeOfStaff;
		this.listApplicantVacancy = listApplicantVacancy;
	}

	public int getIdVacancy() {
		return idVacancy;
	}

	public void setIdVacancy(int idVacancy) {
		this.idVacancy = idVacancy;
	}

	public String getVacancyNumber() {
		return vacancyNumber;
	}

	public void setVacancyNumber(String vacancyNumber) {
		this.vacancyNumber = vacancyNumber;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp TimestampCreated) {

		this.dateCreated = TimestampCreated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOpening() {
		return numberOpening;
	}

	public void setNumberOpening(int numberOpening) {
		this.numberOpening = numberOpening;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Timestamp getDateClose() {
		return dateClose;
	}

	public void setDateClose(java.sql.Timestamp Timestamp) {
		this.dateClose = Timestamp;
	}

	public List<ApplicantVacancy> getListApplicantVacancy() {
		return listApplicantVacancy;
	}

	public void setListApplicantVacancy(List<ApplicantVacancy> listApplicantVacancy) {
		this.listApplicantVacancy = listApplicantVacancy;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTypeOfStaff() {
		return typeOfStaff;
	}

	public void setTypeOfStaff(String typeOfStaff) {
		this.typeOfStaff = typeOfStaff;
	}

	@Override
	public String toString() {
		return "Vacancy [idVacancy=" + idVacancy + ", vacancyNumber=" + vacancyNumber + ", TimestampCreated=" + dateCreated
				+ ", user=" + user + ", state=" + state + ", position=" + position + ", description=" + description
				+ ", numberOpening=" + numberOpening + ", department=" + department + ", TimestampClose=" + dateClose
				+ ", requirement=" + requirement + ", offer=" + offer + ", experience=" + experience + ", gender="
				+ gender + ", degree=" + degree + ", typeOfStaff=" + typeOfStaff + ", listApplicantVacancy="
				+ listApplicantVacancy + "]";
	}

//	@PrePersist
//	public void checkNull() {
//		if (this.TimestampClose == null) {
////			this.TimestampClose = LocalTimestamp.now().toString();
//		}
//	}

}

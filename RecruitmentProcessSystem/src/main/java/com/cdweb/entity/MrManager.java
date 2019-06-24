package com.cdweb.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="mrmanager")
public class MrManager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRequiet;
	
	@JoinColumn(name="idPosition")
	@OneToOne
	private Position position;
	
	@JoinColumn(name="idUser")
	@OneToOne
	private User requier;
	
	private int experience;
	private Date fromDate;
	private Date toDate;
	private String state;
	
	public MrManager() {
		// TODO Auto-generated constructor stub
	}

	public int getIdRequiet() {
		return idRequiet;
	}

	public void setIdRequiet(int idRequiet) {
		this.idRequiet = idRequiet;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public User getRequier() {
		return requier;
	}

	public void setRequier(User requier) {
		this.requier = requier;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}

package com.sarthak.restfult.webservices.social.media.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Integer id;
	
	@Size(min = 3, message = "Entering size of username is not valid")
	private String userName;
	
//	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	@Past(message = "birthData should be in Past!!")
	private LocalDate birthDate;

	public User() {
		super();
	}

	public User(Integer id, String userName, LocalDate birthDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthDate=" + birthDate + "]";
	}
	
	
}

package com.sarthak.restfult.webservices.social.media.model;

public class User {
	private Integer id;
	
	private String userName;
	
//	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	private String birthDate;

	public User() {
		super();
	}

	public User(Integer id, String userName, String birthDate) {
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthDate=" + birthDate + "]";
	}
	
	
}
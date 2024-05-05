package com.sarthak.restfult.webservices.social.media.versioning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	@JsonProperty(value = "name")
	
	@JsonIgnore
	private String studentName;
	
	@JsonProperty(value = "roll")
	private Integer stdRollNumber;
	
	@JsonIgnore
	@JsonProperty("mob")
	private Long stdMobNumber;
	
	@JsonProperty(value = "email-id")
	private String stdEmail;
	
	public Student() {
		
	}

	public Student(String studentName, Integer stdRollNumber, Long stdMobNumber, String stdEmail) {
		super();
		this.studentName = studentName;
		this.stdRollNumber = stdRollNumber;
		this.stdMobNumber = stdMobNumber;
		this.stdEmail = stdEmail;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStdRollNumber() {
		return stdRollNumber;
	}

	public void setStdRollNumber(Integer stdRollNumber) {
		this.stdRollNumber = stdRollNumber;
	}

	public Long getStdMobNumber() {
		return stdMobNumber;
	}

	public void setStdMobNumber(Long stdMobNumber) {
		this.stdMobNumber = stdMobNumber;
	}

	public String getStdEmail() {
		return stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", stdRollNumber=" + stdRollNumber + ", stdMobNumber="
				+ stdMobNumber + ", stdEmail=" + stdEmail + "]";
	}
	
	

}

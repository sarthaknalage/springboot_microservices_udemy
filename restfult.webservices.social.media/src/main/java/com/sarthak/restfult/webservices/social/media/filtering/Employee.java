package com.sarthak.restfult.webservices.social.media.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

// Here we apply dynamic filtreing only , static filtering we all ready discuss and versioning concept

@JsonFilter(value = "empfilter")
public class Employee {
//	@JsonProperty("name")
	private String empName;
	
//	@JsonProperty("id")
	private Integer empId;
	
//	@JsonProperty("mail")
	private String empMail;

	public Employee() {
		super();
	}

	public Employee(String empName, Integer empId, String empMail) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empMail = empMail;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empMail=" + empMail + "]";
	}

}

package com.sarthak.restfult.webservices.social.media.versioning;

public class UserName {
	
	private String firstName;
	private String lastName;
	
	public UserName() {
		
	}
	public UserName(String fName, String lName) {
		this.firstName=fName;
		this.lastName=lName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserName [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

}

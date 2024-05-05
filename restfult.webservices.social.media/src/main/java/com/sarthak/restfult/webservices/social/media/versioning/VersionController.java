package com.sarthak.restfult.webservices.social.media.versioning;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Here we see basic Vesion control used for REST API designing
/*
 * 	1. resources(directly resource designing as per versions requirement) : used by twitter
 * 	2. parameter versioning. used by: amazon
 * 	3. header versioning (X-API-VERSION=1) used by: Microsoft
 *  4. mediatype versioning. used by github
 */
@RestController
@RequestMapping(value = "/version")
public class VersionController {
	
	// returning simple reponse as userfullname consider this is as version:1
	
	@GetMapping(path = "/users/uri/v1")
	public ResponseEntity<String> getUserNameV1(){
		return ResponseEntity.status(HttpStatus.OK).body("Sarthak Nalage");
	}
	@GetMapping(path = "/users/uri/v2")
	public ResponseEntity<UserName> getUserNameV2(){
		UserName userNameJson=new UserName("Sarthak","Nalage");
		return ResponseEntity.status(HttpStatus.OK).body(userNameJson);
	}
	
	
//	version controlling with params value
//	Here we implement serialization of bean over the network by changing field name as per requirement
//	Requirement( for version 1 company) is:change the name of fields whenever they are fetched
	@GetMapping(path = "/users/param", params = "version=1")
	public ResponseEntity<Student> getStudent(){
		Student student=new Student("Sarthak Nalage", 47, 940458573086L, "saro@gamail.com");
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
//	same like that implement for version=2
	
//	3rd Approach: header versioning (In this add X-API-VERSION=value) in request header along with the set header 
//	attribute inside the GetMapping Annotation
	
	@GetMapping(path = "/users/header", headers = "X-API-VERSION=1")
	public ResponseEntity<String> getHeaderVersion1(){
		return ResponseEntity.status(HttpStatus.OK).body("This is Version 1 implemented by header approach!!");
	}
	
	@GetMapping(path = "/users/header", headers = "X-API-VERSION=2")
	public ResponseEntity<String> getHeaderVersion2(){
		return ResponseEntity.status(HttpStatus.OK).body("This is Version 2 implemented by header approach!!");
	}
	
//	4rth Approach: It's called as media versioning, need to be add specific header inside the request header and  corresponding to
//	mention produces attribute in mapping 
	
	@GetMapping(path = "/users/media", produces = "application/vnd.company.app-v1+json")
	public ResponseEntity<String> getMediaVersion1(){
		return ResponseEntity.status(HttpStatus.OK).body("This is Version 1 implemented by media type versioning approach!!");
	}
	
	@GetMapping(path = "/users/media", produces = "application/vnd.company.app-v2+json")
	public ResponseEntity<String> getMediaVersion2(){
		return ResponseEntity.status(HttpStatus.OK).body("This is Version 2 implemented by media type versioning approach!!");
	}
}
package com.sarthak.restfult.webservices.social.media.versioning;
// this is contoller for managing the custom filters as per the client request
// Here we domonstrate the static filtering and dynamic filtering

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	// code for static filtering
//	Requirements clinet 1: doesn't want name,mobile number of student
//	Keep in mind that we're performing all the operations on Student Bean
	
	@GetMapping(path = "/student/static")
	public ResponseEntity<Student> getStudentStaticFilter(){
		Student student=new Student("Sarthak",47,92131752514L,"saro@gmail.com");
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
}

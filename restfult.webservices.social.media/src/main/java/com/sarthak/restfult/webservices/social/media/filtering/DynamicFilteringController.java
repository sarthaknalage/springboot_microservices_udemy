package com.sarthak.restfult.webservices.social.media.filtering;
// This controller will controller dynamic filtering of Employee bean

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {

//	Client:1 Requirements are please only provide the name and mail of Employee bean
	
	@GetMapping("/employees/dynamic")
	public ResponseEntity<MappingJacksonValue> readEmployees() {
		
//		created MappingJacksonValue instace in order to send to client
//		and add filters to it
		Employee employee=new Employee("Sarthak N",47048,"saro@gmail.com");
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(employee);
		//creation of filter
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("empName","empMail");
		
		// creation of filters and adding filter to the filters
		 FilterProvider filters = new SimpleFilterProvider().addFilter("empfilter", filter);
//		 setting filters to mappingJacksonValue
		mappingJacksonValue.setFilters(filters);
		return ResponseEntity.status(HttpStatus.OK).body(mappingJacksonValue);
	
	}
}

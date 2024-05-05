package com.sarthak.restfult.webservices.social.media.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class BasicsController {
	
	@RequestMapping(method=RequestMethod.GET, path = "/greet")
	public String greetUser() {
		return "Welcome, User !!!";
	}
	
	@GetMapping(path = "/greet/{name}")
	public String greetWithUserName(@PathVariable("name") String user_name) {
		return String.format("Hello ,%s regards KKR", user_name);
	}

	@GetMapping(path = "/name/json")
	public EnhancedMsg showJsonFormateName(@RequestParam String name) {
		EnhancedMsg msg=new EnhancedMsg(name);
		return msg;
	}
}
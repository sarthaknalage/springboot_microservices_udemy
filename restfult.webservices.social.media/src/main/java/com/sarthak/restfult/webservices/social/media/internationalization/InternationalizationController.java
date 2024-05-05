package com.sarthak.restfult.webservices.social.media.internationalization;
// This RestController for handling the request of Internationalization content
// Here we do greet to the User with their native language

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalizationController {
	@Autowired
	private MessageSource messageSource;
	
//	public InternationalizationController(MessageSource messageSource) {
//		this.messageSource=messageSource;
//	}
	
	@GetMapping("/greet/i18n/{user}")
	public ResponseEntity<String> greetUserWithNamefr(@PathVariable String user){
		Locale locale= LocaleContextHolder.getLocale();
		System.out.println("Locale of client is "+locale);
		System.out.println(messageSource.getClass().getName());
		String msg=messageSource.getMessage("good.morning.message", null,"Default Message",locale);
		System.out.println(msg);
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
}

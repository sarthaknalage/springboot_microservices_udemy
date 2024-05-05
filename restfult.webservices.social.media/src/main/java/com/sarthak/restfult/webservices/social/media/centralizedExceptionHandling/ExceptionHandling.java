package com.sarthak.restfult.webservices.social.media.centralizedExceptionHandling;
// This centralized logic for handling the any kind of exception that occurs in our business logic

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler{
	// mentioning the @ExceptionHandler will raises exception saying it is ambugious
	@Override
//	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		StringBuilder msg=new StringBuilder("");
		ex.getFieldErrors().parallelStream().forEach(error->msg.append(error.getDefaultMessage()));
		System.out.println(msg);
		String localMsg="Exception occured: Exception count "+ex.getErrorCount()+" Messages are "+msg;
		System.out.println("call comes here *******");
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),localMsg,request.getDescription(false));
		return ResponseEntity.status(status).body(errorDetails);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request){
		ErrorDetails errorDetails =new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(true)); // false means doesn't include client info
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
	}
	

}

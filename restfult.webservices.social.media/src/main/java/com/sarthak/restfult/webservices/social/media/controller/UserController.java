package com.sarthak.restfult.webservices.social.media.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sarthak.restfult.webservices.social.media.model.User;
import com.sarthak.restfult.webservices.social.media.service.UserService;

import jakarta.validation.Valid;

/*
 * disc: this is user controller for static user data doesn't used in memory or physical db.
 */

@RestController
public class UserController {
	
	private UserService userService;
// Here doesn't required to autowired the service? Spring boot Autoconfiguration features show his power
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUserList(){
		List<User> list=this.userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable Integer id) {
		User fetchedUser=userService.getUserById(id);
		if(fetchedUser!=null) {
			return fetchedUser;
		}else {
		throw new RuntimeException("User with id is not found !!");
	}
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser=this.userService.postUser(user);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
// delete the User with the id provide
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id) {
		boolean isDeleted=this.userService.deleteById(id);
		return isDeleted?ResponseEntity.status(HttpStatus.NO_CONTENT).body(isDeleted):ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(isDeleted);
	}

}

package com.sarthak.restfult.webservices.social.media.hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.restfult.webservices.social.media.controller.UserController;
import com.sarthak.restfult.webservices.social.media.model.User;
import com.sarthak.restfult.webservices.social.media.service.UserService;

import jakarta.validation.Valid;

//  HATEOAS( Hypermedia as the engine of application state) defines the subsequent operation you can perform on response

@RestController
public class HateoasController {
	
//	Here with response passing as User is created at the same time we pass link to all the users
//	Here we do constructor injection of UserDao service which is another package to perform POST operation on user
//	this service uses temporary db as static list
	
	private UserService userService;
	@Autowired
	public HateoasController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping(path = "/users/hateoas")
	public ResponseEntity<EntityModel<User>> postUser(@Valid @RequestBody User user){
		User savedUser=this.userService.postUser(user);
		EntityModel<User> entityModel= EntityModel.of(user);
		WebMvcLinkBuilder link=linkTo(methodOn(UserController.class).getUserList());
		entityModel.add(link.withRel("user-list"));
		return ResponseEntity.status(HttpStatus.CREATED).body(entityModel);
	}

}

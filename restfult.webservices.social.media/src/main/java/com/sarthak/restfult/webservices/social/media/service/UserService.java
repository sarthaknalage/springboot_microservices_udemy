package com.sarthak.restfult.webservices.social.media.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sarthak.restfult.webservices.social.media.model.User;
@Component
public class UserService {
	
//	We didn't use any kind of database so create static list for storing the Users and performing CURD operations.
	
	private static List<User> userList=new ArrayList<>();
	// Init data to List
	static {
		userList.add(new User(1, "Sarthak", LocalDate.now().minusYears(21).toString()));
		userList.add(new User(2, "Ruturaj", LocalDate.now().minusYears(25).toString()));
		userList.add(new User(3, "Rupali", LocalDate.now().minusYears(43).toString()));
		userList.add(new User(4, "Sanjay", LocalDate.now().minusYears(52).toString()));
	}
	
//	Defining the method for fetching the User and posting the User
	
	public User getUserById(Integer id) {
		Optional<User> fetchedUser=userList.stream().filter(user->user.getId().equals(id)).findFirst();
		return fetchedUser.isPresent()?fetchedUser.get():null ;
	}
	
	public User postUser(User user) {
		if(user!=null) {
			userList.add(user);
		}
		return user;
	}
}

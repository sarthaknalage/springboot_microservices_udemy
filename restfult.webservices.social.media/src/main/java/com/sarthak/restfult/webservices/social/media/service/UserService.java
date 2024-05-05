package com.sarthak.restfult.webservices.social.media.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.sarthak.restfult.webservices.social.media.model.User;
@Component
public class UserService {
	
//	We didn't use any kind of database so create static list for storing the Users and performing CURD operations.
	
	private static List<User> userList=new ArrayList<>();
	// Init data to List
	static {
		userList.add(new User(1, "Sarthak", LocalDate.now().minusYears(21)));
		userList.add(new User(2, "Ruturaj", LocalDate.now().minusYears(25)));
		userList.add(new User(3, "Rupali", LocalDate.now().minusYears(43)));
		userList.add(new User(4, "Sanjay", LocalDate.now().minusYears(52)));
	}
	
//	Defining the method for fetching the User and posting the User
	
	public User getUserById(Integer id) {
		Optional<User> fetchedUser=userList.stream().filter(user->user.getId().equals(id)).findFirst();
		return fetchedUser.isPresent()?fetchedUser.get():null ;
	}
	
	public User postUser(User user) {
		if(user!=null) {
			int id=userList.size()+1;
			user.setId(id);
			userList.add(user);
		}
		return user;
	}
	
//	Fetched all users
	public List<User> getAllUsers(){
		return userList.isEmpty()?null:userList;
	}
	
//	delete user by it's id
	public boolean deleteById(Integer id) {
//		till no any validations are done for IllegaalArguments we can bypass it by throwing our own exception
//		below exception handling is only for if there is any kind of method/business logic failure then it will handle that exception
		if(id!=null && id>0) {
			Predicate<User> deletePredicate=user->user.getId().equals(id);
			userList.removeIf(deletePredicate);
		}
		return !userList.stream().anyMatch(user->user.getId().equals(id));
	}
}

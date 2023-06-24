package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.function.*;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User (1, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User (2, "Eve", LocalDate.now().minusYears(20)));
		users.add(new User (3, "Jim", LocalDate.now().minusYears(24)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id){
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}


}

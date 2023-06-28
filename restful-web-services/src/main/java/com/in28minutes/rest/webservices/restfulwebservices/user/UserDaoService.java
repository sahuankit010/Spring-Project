package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.function.*;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User (++userCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User (++userCount, "Eve", LocalDate.now().minusYears(20)));
		users.add(new User (++userCount, "Jim", LocalDate.now().minusYears(24)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id){
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}



}

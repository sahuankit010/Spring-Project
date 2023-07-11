package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	@Autowired
	PersonJdbcDao dao;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("All user -> {}", dao.findAll());
		
		logger.info("user by id 10001-> {}", dao.findByID(10001));
		
		logger.info("user by name Ranga -> {}", dao.findByName("Ranga"));
		
		logger.info("delete by id 10002-> {}", dao.deleteByID(10002));
		
		logger.info("Inserting 10004 -> {}", 
				dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		
		logger.info("Update 10003 -> {}", 
				dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

}

package com.learnJavaDBs.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learnJavaDBs.databasedemo.entity.Person;
import com.learnJavaDBs.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	@Autowired
	PersonJdbcDAO dao;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(" ============ ALL USERES =======> " + dao.findeAll());
		logger.info(" ============ ");
		logger.info(" ============ USER WITH ID 1 ===> " + dao.findById(1));
		logger.info(" ============ ");
		logger.info(" ============ DELETE USER 1 ====> " + dao.deleteById(1));
		logger.info(" ============ ");
		logger.info(" ============ INSERT NEW =======> ");
		logger.info(dao.insertNewPerson(new Person(5, "Jack", "Lisbon", "20-05-1989")));
		logger.info(" ============ ");
		logger.info(" ============ UPDATE PERSON ====> ");
		logger.info(dao.updatePErson(dao.findById(2), "BARCELONA"));
		logger.info(" ============ ");
		logger.info(" ============ ALL USERES AGAIN => " + dao.findeAll());
	}

}

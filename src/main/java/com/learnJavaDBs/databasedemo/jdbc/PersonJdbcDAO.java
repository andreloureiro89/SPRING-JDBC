package com.learnJavaDBs.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learnJavaDBs.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findeAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
	}
	
	public Person findById(int id) {
		return (Person) jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id }, new BeanPropertyRowMapper(Person.class));
	}
	
	public boolean deleteById(int id) {
	    String sql = "delete from person where id=?";
	    Object[] args = new Object[] {id};

	    return jdbcTemplate.update(sql, args) == 1;
	}
	
	public String insertNewPerson(Person newPerson) {
		
		final String INSERT_SQL = "INSERT INTO PERSON (ID, NAME, LOCATION, BIRTHDAY ) VALUES (?, ?, ?, ?)";

		jdbcTemplate.update(INSERT_SQL, new Object[] { newPerson.getId(), newPerson.getName(), newPerson.getLocation(), newPerson.getBirthday() });
		
		return "NEW PERSON ADDED => " + newPerson;
	}
	
	public String updatePErson(Person updatePerson, String newCity) {
		
		final String INSERT_SQL = "UPDATE PERSON SET NAME = ?, location = ?, birthday = ? WHERE ID = ?";

		jdbcTemplate.update(INSERT_SQL, new Object[] {updatePerson.getName(), newCity, updatePerson.getBirthday(), updatePerson.getId() });
		
		return "UDPATE PERSON => " + updatePerson;
	}
	
}

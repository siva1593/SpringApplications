package com.crmindz.bcjmay2017.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crmindz.bcjmay2017.pojo.User;

/**
 * @author Siva Reddy
 *
 *         It is a repository which connects with database to perform CRUD
 *         operations. It has implementation of abstract methods.
 */
@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	JdbcOperations jdbcOperations;
	private static final Logger logger = Logger.getLogger(RegistrationDAOImpl.class);

	public String registerUser(User user) {

		logger.info("in dao class, saveUser method");

		String query = "insert into user_details (firstName, lastName,email,phone) values (?,?,?,?)";
		Object[] args = new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone() };

		int count = 0;
		try {
			
			count = jdbcOperations.update(query, args);
			
		} catch (Exception e) {
			
			return "emailExist";
		}
		
		if (0 != count) {
			
			logger.info("user details inserted successfully");
			String query1 = "select user_id from user_details where firstName=?&&lastName=?&&email=?&&phone=?";

			int userId = jdbcTemplate.queryForObject(query1,
					new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone() },
					Integer.class);

			if (0 != userId) {
				
				user.setUserId(userId);
				logger.info("User Id is " + user.getUserId());
				
				String query2 = "insert into login_details (username,password,usertype,user_id) values (?,?,?,?)";
				
				Object[] args1 = new Object[] { user.getLogin().getEmail(), user.getLogin().getPassword(),
						user.getLogin().getUserType(), user.getUserId() };
				
				if (0 != jdbcOperations.update(query2, args1)) {
					
					logger.info("login details inserted successfully");
					String query3 = "insert into address (addressline1, addressline2, city, state, zipcode, user_id) values (?,?,?,?,?,?)";
					
					Object[] args2 = new Object[] { user.getAddress().getAddressLine1(),
							user.getAddress().getAddressLine2(), user.getAddress().getCity(),
							user.getAddress().getState(), user.getAddress().getZipCode(), user.getUserId() };
					
					if (0 != jdbcTemplate.update(query3, args2)) {
						
						logger.info("Address details inserted successfully");
						return "success";
						
					} else {
						
						return "failure";
					}
				}
			}
		}

		return null;
	}

	
	
	public List<String> getUserType() {

		String query = "select name from usertype";
		List<Map<String, Object>> userType = jdbcTemplate.queryForList(query);
		List<String> listOfValue = new ArrayList<String>();
		for (Map<String, Object> map : userType) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				// logger.info(entry.getKey() + " - " + entry.getValue());
				listOfValue.add((String) entry.getValue());
			}
		}

		return (List<String>) listOfValue;
	}


	
	public List<String> getStates() {

		String query = "select state_name from state";
		List<Map<String, Object>> userType = jdbcTemplate.queryForList(query);
		List<String> listOfValue = new ArrayList<String>();
		for (Map<String, Object> map : userType) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				// logger.info(entry.getKey() + " - " + entry.getValue());
				listOfValue.add((String) entry.getValue());

			}
		}

		return (List<String>) listOfValue;
	}


}

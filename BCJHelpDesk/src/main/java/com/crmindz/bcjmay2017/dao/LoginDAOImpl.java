package com.crmindz.bcjmay2017.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crmindz.bcjmay2017.pojo.LoginDetails;
import com.crmindz.bcjmay2017.pojo.User;

/**
 * @author Siva Reddy
 *
 *         It is a repository which connects with database to perform CRUD
 *         operations. It has implementation of abstract methods.
 */
@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	JdbcOperations jdbcOperations;
	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);
	
	public User verifyUser(User user) {
		
		logger.info("In dao class, verifyUser method");
		String query = "select * from login_details where username = ? && password = ?";

		logger.info(user.getLogin().getEmail());
		
		try {
			
			LoginDetails login = (LoginDetails) jdbcTemplate.queryForObject(query,
					new Object[] { user.getLogin().getEmail(), user.getLogin().getPassword() },
					new BeanPropertyRowMapper<LoginDetails>(LoginDetails.class));
			
			logger.info(login.getPassword());
			
			String query1 = "select * from user_details where user_id = ?";
			User userDB = (User) jdbcTemplate.queryForObject(query1, new Object[] { login.getUserId() },
					new BeanPropertyRowMapper<User>(User.class));
			
			logger.info("user Id" + userDB.getUserId());
			logger.info("first name" + userDB.getFirstName());
			logger.info("last name" + userDB.getLastName());
			userDB.setLogin(login);
			return userDB;
		} catch (EmptyResultDataAccessException e) {
			logger.info("exception is handled");
			return null;
		} catch (java.lang.NullPointerException e) {

			logger.info("Null pointer Exception handled correctly");
			return null;
		}

	}
}
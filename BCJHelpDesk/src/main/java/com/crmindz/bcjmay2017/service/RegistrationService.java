package com.crmindz.bcjmay2017.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmindz.bcjmay2017.dao.RegistrationDAO;
import com.crmindz.bcjmay2017.pojo.User;

/**
 * @author Siva Reddy
 *
 *         Implements methods to generate business logic wherever
 *         required and forward/retrieve data to/from DAO.
 */
@Service
public class RegistrationService {

	@Autowired
	private RegistrationDAO registartionDao;
	private static final Logger logger = Logger.getLogger(RegistrationService.class);

	/**
	 * Receives user information to register.
	 * 
	 * @param User
	 *            data in user entity class.
	 * @return Returns a message if user is register or not.
	 */
	public String registerUser(User user) {

		logger.info("In service class, saveUser method");
		return registartionDao.registerUser(user);
	}

	
	/**
	 * Retrieves list of user types.
	 * 
	 * @return Returns a list that has user types.
	 */
	public List<String> getUserType() {
		List<String> data = registartionDao.getUserType();
		return data;
	}

	
	/**
	 * Retrieves list of states in US.
	 * 
	 * @return List of States in USA.
	 */
	public List<String> getStates() {
		List<String> data = registartionDao.getStates();
		return data;
	}

}

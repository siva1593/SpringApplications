package com.crmindz.bcjmay2017.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmindz.bcjmay2017.dao.LoginDAO;
import com.crmindz.bcjmay2017.pojo.User;

/**
 * @author Siva Reddy
 *
 *         Implements methods to generate business logic wherever
 *         required.
 */
@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDao;
	private static final Logger logger = Logger.getLogger(LoginService.class);

	/**
	 * It takes user details and sends its to DAO class for
	 * authentication.
	 * 
	 * @param user
	 *            Verification details are in this class.
	 * @return Returns login information of the user.
	 */
	public User verifyUser(User user) {
		logger.info("In service class, Verify user method");
		User user1 = loginDao.verifyUser(user);
		return user1;

	}

}

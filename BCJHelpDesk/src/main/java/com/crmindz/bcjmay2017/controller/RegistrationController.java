package com.crmindz.bcjmay2017.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crmindz.bcjmay2017.pojo.User;
import com.crmindz.bcjmay2017.service.RegistrationService;

/**
 * @author Siva Reddy
 *
 *         Implements methods to register users and confirm their
 *         registration.
 */
@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	
	/**
	 * Render's the view of Home page.
	 * 
	 * @return A string.
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {

		return "welcome";
	}

	
	
	/**
	 * Render's a view based on the status of registration.
	 * 
	 * @param model
	 *            It has the user information to be registered.
	 * @param user
	 *            The user information from the Model is mapped to the User
	 *            entity class.
	 * @return A Message and view.
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registerUser(Model model, User user) {
		
		logger.info("In controller class, signup method");
		
		String flag = registrationService.registerUser(user);

		if ("success".equals(flag)) {

			ModelAndView modelView = new ModelAndView("welcome");
			modelView.addObject("message", "Your registration is successfull <br/> Please login In");

			return modelView;

		} else if ("emailExist".equals(flag)) {

			ModelAndView modelView = new ModelAndView("welcome");
			modelView.addObject("message", "Email Id already registered");

			return modelView;

		} else {

			ModelAndView modelView = new ModelAndView("welcome");
			modelView.addObject("message", "Sorry, Your registration is unsuccessfull");

			return modelView;

		}

	}

	
	
	/**
	 * Forward's user Types to populate while registering.
	 * 
	 * @return List of user types.
	 */
	@RequestMapping(value = "/getUserType", method = RequestMethod.GET)
	public @ResponseBody List<String> getUserType() {

		logger.info("in usertype");
		
		List<String> usertype = registrationService.getUserType();
		logger.info(usertype);
		
		return usertype;
	}

	
	
	/**
	 * Forwards States in US to populate while registering.
	 * 
	 * @return List of States in USA.
	 */
	@RequestMapping(value = "/getState", method = RequestMethod.GET)
	public @ResponseBody List<String> getStates() {

		logger.info("in state");
		List<String> states = registrationService.getStates();
		return states;

	}

	
	
	/**
	 * Forwards time.
	 * 
	 * @return String that has time.
	 */
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public @ResponseBody String getTime() {

		String result = "<b>" + new Date().toString() + "</b>";
		return result;
	}

}

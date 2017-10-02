package com.crmindz.bcjmay2017.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crmindz.bcjmay2017.pojo.User;
import com.crmindz.bcjmay2017.service.LoginService;

/**
 * @author Siva Reddy
 *
 *         Implements methods to verify users login and render their respective
 *         home page.
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	private static final Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * Render's view based on the authentication.
	 * 
	 * @param model
	 *            It has information for authentication.
	 * @param user
	 *            User's login information is mapped to login entity class.
	 * @param session
	 *            To set attributes for using in future request's form of user.
	 * @return A Message and view.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView verifyUser(User user, Model model, HttpSession session) {

		ModelAndView modelView;
		logger.info("In Login" + user.getLogin().getEmail());
		User userDB = loginService.verifyUser(user);

		if (null != userDB) {

			int userId = userDB.getUserId();
			session.setAttribute("userId", userId);
			session.setAttribute("userType", userDB.getLogin().getUserType());

			if ("Employee".equalsIgnoreCase(userDB.getLogin().getUserType())) {
				
				modelView = new ModelAndView("EmployeeHome");
			} else {
				
				modelView = new ModelAndView("UserHome");
			}
			
			modelView.addObject("user", userDB);
			modelView.addObject("message", "Logged In");
			return modelView;
			
		} else {
			
			modelView = new ModelAndView("welcome");
			modelView.addObject("message", "Login is not successfull <br> Invalid Email/Password");
			return modelView;
		}
	}

	/**
	 * Render's view based on user type.
	 * 
	 * @param session
	 *            Getting the session of the user who want's the home page.
	 * @return A Message and View.
	 */
	@RequestMapping(value = "/userHome", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displayHomePage(HttpSession session) {

		String userType = (String) session.getAttribute("userType");

		if ("Employee".equalsIgnoreCase(userType)) {

			ModelAndView modelView = new ModelAndView("EmployeeHome");
			return modelView;
			
		} else {

			ModelAndView modelView = new ModelAndView("UserHome");
			return modelView;
		}
	}

	/**
	 * Render's the view after invalidating the session.
	 * 
	 * @param session
	 *            Getting the session of the user who want's to log out.
	 * @return Message and view.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {

		logger.info("Session " + session.getId() + " has ended.");
		session.invalidate();

		ModelAndView modelView = new ModelAndView("welcome");
		modelView.addObject("message", "Logged out Successfully");

		return modelView;
	}

}

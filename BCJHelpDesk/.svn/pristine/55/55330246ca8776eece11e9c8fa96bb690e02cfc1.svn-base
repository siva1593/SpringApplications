package com.crmindz.bcjmay2017.mockitotest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crmindz.bcjmay2017.dao.LoginDAO;
import com.crmindz.bcjmay2017.pojo.LoginDetails;
import com.crmindz.bcjmay2017.pojo.User;
import com.crmindz.bcjmay2017.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@Mock
	private LoginDAO loginDao;

	@InjectMocks
	private LoginService loginService;

	@Test
	public void testVerifyUser() {
		User user = new User();
		LoginDetails login = new LoginDetails();
		login.setEmail("sivayarram2793@gmail.com");
		user.setLogin(login);
		when(loginDao.verifyUser(user)).thenReturn(user);
		assertEquals(user, loginService.verifyUser(user));
	}
}

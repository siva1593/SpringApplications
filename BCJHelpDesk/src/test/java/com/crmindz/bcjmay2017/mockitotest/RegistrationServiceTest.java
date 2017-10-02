package com.crmindz.bcjmay2017.mockitotest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crmindz.bcjmay2017.dao.RegistrationDAO;
import com.crmindz.bcjmay2017.pojo.User;
import com.crmindz.bcjmay2017.service.RegistrationService;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest extends TestCase {
	@Mock
	private RegistrationDAO registrationDao;

	@InjectMocks
	private RegistrationService registartionService;

	
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setFirstName("siva");
		when(registrationDao.registerUser(user)).thenReturn("Success");
		assertEquals("Success", registartionService.registerUser(user));

	}

	
	
	@Test
	public void testGetUserType() {

		List<String> data = new ArrayList<String>();
		data.add("Student");
		when(registrationDao.getUserType()).thenReturn(data);
		assertEquals(data, registartionService.getUserType());
	}

	
	@Test
	public void testGetStates() {

		List<String> data = new ArrayList<String>();
		data.add("Texas");
		when(registrationDao.getStates()).thenReturn(data);
		assertEquals(data, registartionService.getStates());
	}
}

package com.crmindz.bcjmay2017.mockitotest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.crmindz.bcjmay2017.dao.EmployeeTicketsDAO;
import com.crmindz.bcjmay2017.pojo.Ticket;
import com.crmindz.bcjmay2017.service.EmployeeTicketsService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTicketsServiceTest {

	@Mock
	private EmployeeTicketsDAO employeeTicketsDao;

	@InjectMocks
	private EmployeeTicketsService employeeTicketsService;

	@Test
	public void fetchNewTicketsTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setCategory("Recruitement");
		list.add(ticket);
		when(employeeTicketsDao.fetchNewTickets()).thenReturn(list);
		assertEquals(list, employeeTicketsService.fetchNewTickets());
	}

	
	@Test
	public void fetchApprovedTicketsTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setCategory("Recruitement");
		list.add(ticket);
		when(employeeTicketsDao.fetchApprovedTickets()).thenReturn(list);
		assertEquals(list, employeeTicketsService.fetchApprovedTickets());
	}

	
	@Test
	public void fetchDeniedTicketsTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setCategory("Recruitement");
		list.add(ticket);
		when(employeeTicketsDao.fetchDeniedTickets()).thenReturn(list);
		assertEquals(list, employeeTicketsService.fetchDeniedTickets());
	}

	
	@Test
	public void approveTicketTest() {
		when(employeeTicketsDao.approveTicket(Mockito.any(Ticket.class), Mockito.anyInt())).thenReturn(true);
		assertEquals(true, employeeTicketsService.approveTicket(new Ticket(), 5));
	}

	
	@Test
	public void rejectTicketTest() {
		when(employeeTicketsDao.rejectTicket(Mockito.any(Ticket.class), Mockito.anyInt())).thenReturn(true);
		assertEquals(true, employeeTicketsService.rejectTicket(new Ticket(), 5));
	}
}

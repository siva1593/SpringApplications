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

import com.crmindz.bcjmay2017.dao.TicketDAO;
import com.crmindz.bcjmay2017.pojo.Ticket;
import com.crmindz.bcjmay2017.service.TicketService;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {

	@Mock
	private TicketDAO ticketDao;

	@InjectMocks
	private TicketService ticketService;

	@Test
	public void getCategoryTest() {

		List<String> ticketCategoryInfo = new ArrayList<String>();
		ticketCategoryInfo.add("Letters");
		when(ticketDao.getTicketCategoryInfo()).thenReturn(ticketCategoryInfo);
		String category = "<option value='" + "Letters" + "'>" + "Letters" + "</option>";
		assertEquals(category, ticketService.getTicketCategoryInfo());
	}
	

	@Test
	public void getSubCategoryTest() {
		List<String> list = new ArrayList<String>();
		list.add("Offer Letter");
		when(ticketDao.getTicketSubCategoryInfo(Mockito.anyString())).thenReturn(list);
		String subCategory = "<option value='" + "Offer Letter" + "'>" + "Offer Letter" + "</option>";
		assertEquals(subCategory, ticketService.getTicketSubCategoryInfo(Mockito.anyString()));
	}
	

	@Test
	public void saveTicketTest() {
		when(ticketDao.createTicket(Mockito.any(Ticket.class), Mockito.anyInt())).thenReturn(true);
		assertEquals(true, ticketService.createTicket(new Ticket(), 5));
	}
	

	@Test
	public void getTicketsListByUserIdTest() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setCategory("Letters");
		list.add(ticket);
		when(ticketDao.getTicketsListByUserId(Mockito.anyInt())).thenReturn(list);
		assertEquals(list, ticketService.getTicketsListByUserId(Mockito.anyInt()));
	}
}
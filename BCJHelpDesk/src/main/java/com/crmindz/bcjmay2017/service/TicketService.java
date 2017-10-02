package com.crmindz.bcjmay2017.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmindz.bcjmay2017.dao.TicketDAO;
import com.crmindz.bcjmay2017.pojo.Ticket;

/**
 * @author Siva Reddy
 *
 *         Implements methods to generate business logic wherever required.
 */
@Service
public class TicketService {

	@Autowired
	public TicketDAO ticketDao;
	List<Ticket> ticketList = new ArrayList<Ticket>();

	/**
	 * Retrieves ticket category list.
	 * 
	 * @return A list, that has categories.
	 */
	public String getTicketCategoryInfo() {
		List<String> ticketCategoryInfo = ticketDao.getTicketCategoryInfo();

		String ticketCategory1 = "";
		for (String ticketCategory : ticketCategoryInfo) {
			ticketCategory1 += "<option value='" + ticketCategory + "'>" + ticketCategory + "</option>";
		}
		return ticketCategory1;
	}

	
	
	/**
	 * Retrieves sub category list based on the category selected by user.
	 * 
	 * @param ticketCategoryName
	 *            It has category value.
	 * @return A list of sub category.
	 */
	public String getTicketSubCategoryInfo(String ticketCategoryName) {
		List<String> subTicketCategoryInfo = ticketDao.getTicketSubCategoryInfo(ticketCategoryName);

		String ticketSubCategory = "";
		for (String ticketSubCategory1 : subTicketCategoryInfo) {
			ticketSubCategory += "<option value='" + ticketSubCategory1 + "'>" + ticketSubCategory1 + "</option>";
		}
		return ticketSubCategory;
	}

	
	
	/**
	 * Creates ticket by generating ticket number and forwards to DAO CLass.
	 * 
	 * @param ticket
	 *            Gets ticket details
	 * @param userId
	 * @return Returns true or false.
	 */
	public boolean createTicket(Ticket ticket, int userId) {

		ticket.setTicketNo((int) (Math.random() * 70000));
		ticket.setStatus("Pending");
		ticket.setComments("Under Review");
		if (ticketDao.createTicket(ticket, userId)) {
			return true;
		} else {
			return false;
		}
	}

	
	
	/**
	 * This method retrieves list of tickets of the user.
	 * 
	 * @param UserId
	 *            User Id of the user who is requesting the tickets.
	 * @return Returns a list of tickets of user.
	 */
	public List<Ticket> getTicketsListByUserId(int user_Id) {

		ticketList = ticketDao.getTicketsListByUserId(user_Id);
		return ticketList;
	}

}

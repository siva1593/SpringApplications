package com.crmindz.bcjmay2017.dao;

import java.util.List;

import com.crmindz.bcjmay2017.pojo.Ticket;

/**
 * @author Siva Reddy. 
 * 		   Acts as an Interface which contains only
 *         Abstract methods Implemented by various classes.
 */
public interface EmployeeTicketsDAO {

	/**
	 * Gets the new tickets generated by students or consultants for
	 * employee.
	 * 
	 * @return Returns a list of map's that has new tickets.
	 */
	public List<Ticket> fetchNewTickets();

	
	/**
	 * Gets the approved tickets generated by employee.
	 * 
	 * @return Returns a list of map's that has approved tickets.
	 */
	public List<Ticket> fetchApprovedTickets();

	
	/**
	 * Gets the denied tickets generated by employee.
	 * 
	 * @return Returns a list of map's that has denied tickets.
	 */
	public List<Ticket> fetchDeniedTickets();

	
	/**
	 * Updates the ticket with status as approval.
	 * 
	 * @param ticket
	 *            It has the ticket details to be updated.
	 * @return Returns boolean based on the update query.
	 */
	public boolean approveTicket(Ticket ticket, int userId);

	
	/**
	 * Updates the ticket with status as rejection.
	 * 
	 * @param ticket
	 *            It has the ticket details to be updated.
	 * @return Returns boolean based on the update query.
	 */
	public boolean rejectTicket(Ticket ticket, int userId);

}

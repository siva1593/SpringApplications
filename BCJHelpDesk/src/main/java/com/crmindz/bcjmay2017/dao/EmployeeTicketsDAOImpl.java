package com.crmindz.bcjmay2017.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crmindz.bcjmay2017.pojo.Ticket;

/**
 * @author Siva Reddy
 *
 *         It is a repository which connects with database to perform CRUD
 *         operations. It has implementation of abstract methods.
 */
@Repository
public class EmployeeTicketsDAOImpl implements EmployeeTicketsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	JdbcOperations jdbcOperations;
	private static final Logger logger = Logger.getLogger(EmployeeTicketsDAOImpl.class);

	
	
	
	
	
	public List<Ticket> fetchNewTickets() {
		logger.info(" In DAO, fetchTicketmethod");

		String query = "select ticketNo,category,subCategory,description,subject,status,comments from ticket where status = 'Pending'";

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Ticket> newTickets = new ArrayList<Ticket>();

		for (Map<String, Object> row : rows) {
			Ticket ticket = new Ticket();

			ticket.setTicketNo((Integer) (row.get("ticketNo")));
			System.out.println(row.get("ticketNo"));
			ticket.setCategory((String) row.get("category"));
			ticket.setSubCategory((String) row.get("subCategory"));
			ticket.setDescription((String) row.get("description"));
			ticket.setSubject((String) row.get("subject"));
			ticket.setStatus((String) row.get("status"));
			ticket.setComments((String) row.get("comments"));
			newTickets.add(ticket);

		}

		if (!newTickets.isEmpty()) {
			System.out.println(newTickets.get(0).getStatus());
		}

		return newTickets;
	}

	
	
	public List<Ticket> fetchApprovedTickets() {
		logger.info("In  DAO, fetchApprovedTicketmethod");

		String query = "select ticketNo,category,subCategory,description,subject,status,comments from ticket where status = 'Approved'";

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Ticket> approvedTickets = new ArrayList<Ticket>();

		for (Map<String, Object> row : rows) {
			Ticket ticket = new Ticket();

			ticket.setTicketNo((Integer) (row.get("ticketNo")));
			System.out.println(row.get("ticketNo"));
			ticket.setCategory((String) row.get("category"));
			ticket.setSubCategory((String) row.get("subCategory"));
			ticket.setDescription((String) row.get("description"));
			ticket.setSubject((String) row.get("subject"));
			ticket.setStatus((String) row.get("status"));
			ticket.setComments((String) row.get("comments"));
			approvedTickets.add(ticket);

		}

		if (!approvedTickets.isEmpty()) {
			System.out.println(approvedTickets.get(0).getStatus());
		}

		return approvedTickets;
	}

	
	
	public List<Ticket> fetchDeniedTickets() {
		logger.info("In DAO, fetchDeniedTicketmethod");

		String query = "select ticketNo,category,subCategory,description,subject,status,comments from ticket where status = 'Denied'";

		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Ticket> deniedTickets = new ArrayList<Ticket>();

		for (Map<String, Object> row : rows) {
			Ticket ticket = new Ticket();

			ticket.setTicketNo((Integer) (row.get("ticketNo")));
			System.out.println(row.get("ticketNo"));
			ticket.setCategory((String) row.get("category"));
			ticket.setSubCategory((String) row.get("subCategory"));
			ticket.setDescription((String) row.get("description"));
			ticket.setSubject((String) row.get("subject"));
			ticket.setStatus((String) row.get("status"));
			ticket.setComments((String) row.get("comments"));
			deniedTickets.add(ticket);

		}

		if (!deniedTickets.isEmpty()) {
			System.out.println(deniedTickets.get(0).getStatus());
		}

		return deniedTickets;
	}

	
	
	public boolean approveTicket(Ticket ticket, int userId) {
		logger.info("in dao class, approveTicket method");
		logger.info(ticket.getStatus() + "  " + ticket.getComments());

		String query = "update ticket set status = ? ,comments = ? where ticketNo = ?";
		Object[] args = new Object[] { ticket.getStatus(), ticket.getComments(), ticket.getTicketNo() };
		if (0 != jdbcOperations.update(query, args)) {
			logger.info("tickets details updated successfully in approve method");
			return true;
		} else {
			return false;
		}
	}

	
	
	public boolean rejectTicket(Ticket ticket, int userId) {
		logger.info("in dao class, rejectTicket method");
		logger.info(ticket.getSubCategory() + "  " + ticket.getDescription());

		String query = "update ticket set status = ? ,comments = ? where ticketNo = ?";
		Object[] args = new Object[] { ticket.getStatus(), ticket.getComments(), ticket.getTicketNo() };
		if (0 != jdbcOperations.update(query, args)) {
			logger.info("ticket details updated successfully in reject method");
			return true;
		} else {
			return false;
		}
	}


}

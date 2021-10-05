package servlet;


import model.Ticket;
import service.TicketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/IssueTicketServlet")
public class IssueTicketServlet extends HttpServlet {
    public IssueTicketServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ticket ticket = new Ticket();
        TicketService service = new TicketService();

        ticket.setPassenger(Integer.parseInt(request.getParameter("passenger")));
        ticket.setPickup(request.getParameter("pickup"));
        ticket.setDestination(request.getParameter("destination"));
        ticket.setDate(Date.valueOf(request.getParameter("booking")));

        int number = Integer.parseInt(request.getParameter("nooftickets"));


            service.issueTicket(ticket);

        response.sendRedirect("RequestATicket.jsp");





    }
}

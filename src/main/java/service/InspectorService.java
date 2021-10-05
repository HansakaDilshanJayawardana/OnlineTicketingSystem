package service;
import model.Ticket;
import util.DBConnectionUtil;
import util.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InspectorService implements IInspectors {
    Connection con;
    PreparedStatement preparedStatement;

    @Override
    public void checkTicket(Ticket ticket) {
        TicketService ticketService = new TicketService();
        boolean result = ticketService.validateTicket(ticket.getId());

        if (result == false) {
            try {
                //Establishing a Connection
                con = DBConnectionUtil.getConnection();
                //SQL QUERY (INSERT)
                String sql = Query.ADD_INVALID;
                //Create a statement using connection object
                preparedStatement = con.prepareStatement(sql);

                //Get data from form inputs and Add data to PreparedStatement
                preparedStatement.setInt(1, ticket.getId());
                preparedStatement.setDate(2, ticket.getDate());


                //Execute Query (It will return the number of affected rows)
                preparedStatement.execute();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }if(result==true){

        }


    }
}

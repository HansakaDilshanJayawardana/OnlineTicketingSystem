package service;

import model.Ticket;
import model.Timetable;
import util.DBConnectionUtil;
import util.Query;

import java.sql.*;

public class TicketService implements ITicket{

    Connection con;
    PreparedStatement preparedStatement;

    @Override
    public boolean validateTicket(int id) {

        //Declare a variable and assign to null
        boolean status  = false;
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = Query.VALIDATE_TICKET;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {


                //Create an Object
                int result = rs.getInt(1);

                if (result > 0) {

                    status =true;
                }


            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void issueTicket(Ticket ticket) {

        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (INSERT)
            String sql = Query.ISSUE_TICKET;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);

            //Get data from form inputs and Add data to PreparedStatement
            preparedStatement.setInt(1,ticket.getPassenger());
            preparedStatement.setString(2,ticket.getPickup());
            preparedStatement.setString(3,ticket.getDestination());
            preparedStatement.setDate(4,ticket.getDate());

            //Execute Query (It will return the number of affected rows)
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

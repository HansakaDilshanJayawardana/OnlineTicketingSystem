package service;

import model.Inspectors;
import util.DBConnectionUtil;
import util.Query;

import java.sql.*;

public class TransportmanagerService implements ITransportmanager {

    //declare Variables
    Connection con;
    PreparedStatement preparedStatement;

    @Override
    public void viewReport() {

    }

    @Override
    public void assignInspectors(Inspectors inspectors) {
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (INSERT)
            String sql = Query.ASSIGN_INSPECTOR;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);

            //Get data from form inputs and Add data to PreparedStatement
            preparedStatement.setString(1,inspectors.getName());
            preparedStatement.setString(2,inspectors.getNic());
            preparedStatement.setString(3,inspectors.getPhone());
            preparedStatement.setString(4,inspectors.getEmail());
            preparedStatement.setString(5,inspectors.getLocation());

            //Execute Query (It will return the number of affected rows)
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

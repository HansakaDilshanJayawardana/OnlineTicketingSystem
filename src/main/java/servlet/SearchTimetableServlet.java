package servlet;

import model.Timetable;
import util.DBConnectionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/SearchTimetableServlet")
public class SearchTimetableServlet extends HttpServlet {
    public SearchTimetableServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get Name, NIC, Phone or NIC
        String a = request.getParameter("txt");
        //SQL QUERY (RETRIEVE)
        String sql = "SELECT * FROM timetable WHERE (id LIKE '%"+a+"%' OR name LIKE '%"+a+"%')";

        //declare Variable
        Connection con = null;
        //Create a new ArrayList
        ArrayList<Timetable> list = new ArrayList<>();
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                //Get values to Student Details Table
                int id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String startingTime = rs.getString(3);
                String endTime = rs.getString(4);
                String startingPoint = rs.getString(5);
                String destination = rs.getString(6);

                //Create an Object
                Timetable timetable = new Timetable();

                //Retrieve Student Details from studentdetails table(DB) & studentlearnsubject table(DB)
                timetable.setId(id);
                timetable.setName(name);
                timetable.setStartingTime(Time.valueOf(startingTime));
                timetable.setEndTime(Time.valueOf(endTime));
                timetable.setStartingPoint(startingPoint);
                timetable.setDestination(destination);

                list.add(timetable);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("txt",list);
        //Direct to view_student_details page
        RequestDispatcher view = request.getRequestDispatcher("ViewTimetable.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

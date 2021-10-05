package servlet;

import model.Timetable;
import service.TimetableService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;

@WebServlet("/AddTimetableServlet")
public class AddTimetableServlet extends HttpServlet {
    public AddTimetableServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create an Object
        Timetable timetable = new Timetable();

        //Get data sent from jsp file and set them
        timetable.setName(request.getParameter("name"));
        timetable.setStartingTime(Time.valueOf(request.getParameter("startingTime")));
        timetable.setEndTime(Time.valueOf(request.getParameter("endTime")));
        timetable.setStartingPoint(request.getParameter("startingPoint"));
        timetable.setDestination(request.getParameter("destination"));

        //Create an Object
        TimetableService timetableService = new TimetableService();

        //Call addStudent function in studentService
        timetableService.addTimetable(timetable);
        //Direct to view_student_details page
        response.sendRedirect("ViewTimetable.jsp");
    }
}

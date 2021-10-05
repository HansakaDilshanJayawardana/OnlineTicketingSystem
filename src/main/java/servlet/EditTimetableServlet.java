package servlet;

import model.Timetable;
import service.TimetableService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;

@WebServlet("/EditTimetableServlet")
public class EditTimetableServlet extends HttpServlet {
    //Create an Object
    TimetableService timetableService = new TimetableService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create an Object
        Timetable timetable = new Timetable();

        //Get data sent from update_student_details jsp file and set them
        timetable.setId(Integer.parseInt(request.getParameter("id")));
        timetable.setName(request.getParameter("name"));
        timetable.setStartingTime(Time.valueOf(request.getParameter("startingTime")));
        timetable.setEndTime(Time.valueOf(request.getParameter("endTime")));
        timetable.setStartingPoint(request.getParameter("startingPoint"));
        timetable.setDestination(request.getParameter("destination"));

        //Call editStudent function in studentService
        timetableService.editTimetable(timetable);
        //Direct to view_student_details page
        response.sendRedirect("ViewTimetable.jsp");
    }
}

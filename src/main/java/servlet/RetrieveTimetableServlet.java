package servlet;

import model.Timetable;
import service.TimetableService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RetrieveTimetableServlet")
public class RetrieveTimetableServlet extends HttpServlet {
    public RetrieveTimetableServlet() {
        super();
    }

    //Create an object
    TimetableService timetableService= new TimetableService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get Student ID
        int id = Integer.parseInt(request.getParameter("id"));

        //Declare a variable
        Timetable existingTimetable;
        try {
            //Call selectStudent function in studentService
            existingTimetable = timetableService.selectTimetable(id);
            //Set id to selectStudent function
            existingTimetable.setId(id);

            //Direct to update_student_details page
            RequestDispatcher dispatcher = request.getRequestDispatcher("update_timetable_details.jsp");
            request.setAttribute("timetable", existingTimetable);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

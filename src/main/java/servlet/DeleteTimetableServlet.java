package servlet;

import service.TimetableService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeleteTimetableServlet")
public class DeleteTimetableServlet extends HttpServlet {
    //Create an Object
    TimetableService service = new TimetableService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Get Student ID, First Name & Last Name
            int id = Integer.parseInt(request.getParameter("getId"));

            //Call deleteStudent function in studentService
            service.deleteTimetable(id);
            //Direct to view_student_details page
            response.sendRedirect("ViewTimetable.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

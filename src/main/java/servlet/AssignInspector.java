package servlet;



import model.Inspectors;
import service.TransportmanagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

//Servlet implementation class Assign Inspector
@WebServlet("/AssignInspector")
public class AssignInspector extends HttpServlet {
    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create an Object
        Inspectors inspectors = new Inspectors();

        //Get data sent from jsp file and set them
        inspectors.setName(request.getParameter("name"));
        inspectors.setNic(request.getParameter("nic"));
        inspectors.setPhone(request.getParameter("phone"));
        inspectors.setEmail(request.getParameter("email"));
        inspectors.setLocation(request.getParameter("location"));


        //Create an Object
        TransportmanagerService service = new TransportmanagerService();

        //Call addAttendance function in AttendanceMarker
        service.assignInspectors(inspectors);
        //Direct to attendance_markers_list page
        response.sendRedirect("/pages/inspector/assignInspector.jsp");
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

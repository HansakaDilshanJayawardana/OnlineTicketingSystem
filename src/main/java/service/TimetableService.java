package service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Timetable;
import util.DBConnectionUtil;
import util.Query;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TimetableService implements ITimetable {
    //declare Variables
    Connection con;
    PreparedStatement preparedStatement;

    @Override
    public void addTimetable(Timetable timetable) {
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (INSERT)
            String sql = Query.ADD_TIMETABLE;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);

            //Get data from form inputs and Add data to PreparedStatement
            preparedStatement.setString(1, timetable.getName());
            preparedStatement.setTime(2, timetable.getStartingTime());
            preparedStatement.setTime(3, timetable.getEndTime());
            preparedStatement.setString(4, timetable.getStartingPoint());
            preparedStatement.setString(5, timetable.getDestination());

            //Execute Query (It will return the number of affected rows)
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editTimetable(Timetable timetable) {
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (UPDATE)
            String sql = Query.UPDATE_TIMETABLE_DETAILS+timetable.getId();
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);

            //Get data from update form inputs and Add data to PreparedStatement
            preparedStatement.setString(1, timetable.getName());
            preparedStatement.setTime(2, timetable.getStartingTime());
            preparedStatement.setTime(3, timetable.getEndTime());
            preparedStatement.setString(4, timetable.getStartingPoint());
            preparedStatement.setString(5, timetable.getDestination());

            //Update Query (It will return the number of affected rows)
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Timetable> viewTimetable() {
        //using try-with-resources to avoid closing resources (boiler plate code)
        ArrayList<Timetable> list = new ArrayList<>();
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = Query.SEE_ALL_TIMETABLES;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                //Get values to Student Details Table
                int id = Integer.parseInt(rs.getString(1));
                String name = (rs.getString(2));
                Time startingTime = rs.getTime(3);
                Time endTime = rs.getTime(4);
                String startingPoint = rs.getString(5);
                String destination = rs.getString(6);

                //Create an Object
                Timetable timetable = new Timetable();

                //Retrieve Timetable Details from timetable table(DB)
                timetable.setId(id);
                timetable.setName(name);
                timetable.setStartingTime(startingTime);
                timetable.setEndTime(endTime);
                timetable.setStartingPoint(startingPoint);
                timetable.setDestination(destination);

                list.add(timetable);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Timetable selectTimetable(int id) {
        //Declare a variable and assign to null
        Timetable timetable = null;
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = Query.SEE_TIMETABLE_BY_BUSID;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                //Get Student Details
                String name = rs.getString(2);
                Time startingTime = rs.getTime(3);
                Time endTime = rs.getTime(4);
                String startingPoint = rs.getString(5);
                String destination = rs.getString(6);

                //Create an Object
                timetable = new Timetable();

                //Retrieve Student Details from studentdetails table(DB) & studentlearnsubject table(DB)
                timetable.setId(id);
                timetable.setName(name);
                timetable.setStartingTime(startingTime);
                timetable.setEndTime(endTime);
                timetable.setStartingPoint(startingPoint);
                timetable.setDestination(destination);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return timetable;
    }

    @Override
    public boolean deleteTimetable(int id) {
        //Declare variables and assign to false
        boolean rowDeleted = false;

        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERIES (DELETE)
            String sql= Query.DELETE_TIMETABLE;

            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            //Get id and set id to PreparedStatement
            preparedStatement.setInt(1, id);

            //Use to update the query
            rowDeleted = preparedStatement.executeUpdate() > 0;//return number of rows deleted
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    //Generate Student List Report
    public void generateTimetable() throws IOException, DocumentException {
        //Create an Object
        TimetableService timetableService = new TimetableService();
        //Call Service Method
        ArrayList<Timetable> list = new ArrayList<>();
        //Call viewAttendMarkers function in attendanceMarkerService
        list =timetableService.viewTimetable();

        //Create an Object
        Document document = new Document();

        //Define Output File Path
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ADMIN\\reports\\timetable" + ".pdf"));
        document.open();

        //Heading Designs
        com.itextpdf.text.Font heading1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.BOLD, BaseColor.GREEN);
        com.itextpdf.text.Font heading2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.NORMAL, BaseColor.GREEN);
        com.itextpdf.text.Font heading3 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD, BaseColor.WHITE);

        //Declare a variable and assign a value
        int count =1;

        //Define Header Titles
        Chunk head = new Chunk("TRAVELWISE", heading1);
        Chunk head3 = new Chunk("Timetables", heading1);
        Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Malabe\nHotline:072323435\nemail:Rasa@gmail.com", heading2);

        //Image Path (PDF Logo)
        String path = "C:\\Users\\ADMIN\\reports\\logo.png";
        com.itextpdf.text.Image img = Image.getInstance(path);

        PdfPTable table1 = new PdfPTable(2); // 3 columns.
        PdfPTable table2 = new PdfPTable(1); // 1 column

        //Create an Object
        Paragraph p1 = new Paragraph();
        //Print Heads
        p1.add(head);
        p1.add(head2);

        //Create Header Cell Objects
        PdfPCell cella = new PdfPCell(img);
        PdfPCell cellb = new PdfPCell(p1);
        PdfPCell cellc = new PdfPCell(new Paragraph(head3));

        //Decorations for PDF Header
        //Set Border Widths
        cella.setBorderWidth(0);
        cellb.setBorderWidth(0);
        cellc.setBorderWidth(0);
        //Set Height
        cella.setFixedHeight(100);
        //Set Background Colour For Header
        cellc.setBackgroundColor(BaseColor.WHITE);
        //Set Header Table Width Percentages
        table1.setWidthPercentage(100);
        table2.setWidthPercentage(200);

        table1.addCell(cella);
        table1.addCell(cellb);
        table2.addCell(cellc);
        document.add(table2);
        document.add(table1);
        document.add(table2);

        //Define Current Date
        LocalDate date = LocalDate.now();
        //Print Today's Date
        Paragraph main = new Paragraph("Date  " + date);
        main.setSpacingAfter(40);
        document.add(main);

        float[] columnWidths = {200, 200, 200, 200, 200, 200};
        PdfPTable table = new PdfPTable(columnWidths); // 4 columns.

        //Table Header Names
        PdfPCell cell1 = new PdfPCell(new Phrase("Bus ID", heading3));
        PdfPCell cell2 = new PdfPCell(new Phrase("Bus Name", heading3));
        PdfPCell cell3 = new PdfPCell(new Phrase("Starting Time", heading3));
        PdfPCell cell4 = new PdfPCell(new Phrase("End Time", heading3));
        PdfPCell cell5 = new PdfPCell(new Phrase("Starting Point", heading3));
        PdfPCell cell6 = new PdfPCell(new Phrase("Destination", heading3));

        //Set Cell BackgroundColor
        cell1.setBackgroundColor(BaseColor.GREEN);
        cell2.setBackgroundColor(BaseColor.GREEN);
        cell3.setBackgroundColor(BaseColor.GREEN);
        cell4.setBackgroundColor(BaseColor.GREEN);
        cell5.setBackgroundColor(BaseColor.GREEN);
        cell6.setBackgroundColor(BaseColor.GREEN);

        //Add Table Header Names to Cell
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);

        for(Timetable tt: list) {
            //Table Data
            PdfPCell cell7 = new PdfPCell(new Phrase(tt.getId()+" "));
            PdfPCell cell8= new PdfPCell(new Phrase(tt.getName()));
            PdfPCell cell9 = new PdfPCell(new Phrase(String.valueOf(tt.getStartingTime())));
            PdfPCell cell10 = new PdfPCell(new Phrase(String.valueOf(tt.getEndTime())));
            PdfPCell cell11 = new PdfPCell(new Phrase(tt.getStartingPoint()));
            PdfPCell cell12 = new PdfPCell(new Phrase(tt.getDestination()));

            //Add Data to Cell
            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);
        }
        document.add(table);
        document.close();
    }
}

package util;

public class Query {

    //TransportManager Queries
    public final static String ASSIGN_INSPECTOR="INSERT INTO inspectors(name,nic,phone,email,location) values(?,?,?,?,?)";

    //Timetable Queries
    public final static String ADD_TIMETABLE = "INSERT INTO timetable(name,startingTime,endTime,startingPoint,destination values(?,?,?,?,?)";
    public final static String UPDATE_TIMETABLE_DETAILS = "UPDATE timetable SET name=?, startingTime=?, endTime=?, startingPoint=?, destination=? WHERE id = ";
    public final static String SEE_ALL_TIMETABLES = "SELECT * FROM timetable";
    public final static String SEE_TIMETABLE_BY_BUSID = "SELECT * FROM timetable WHERE id = ?";
    public final static String DELETE_TIMETABLE = "DELETE FROM timetable where id = ?";

    //Ticket Queries
    public final static String ISSUE_TICKET ="INSERT INTO ticket(passenger,pickup,destination,bookingdate) values(?,?,?,?)";
    public final static String VALIDATE_TICKET = "SELECT * FROM ticket WHERE id = ?";

    //Invalid table query
    public final static String ADD_INVALID ="INSERT INTO invalid(ticketId,date) values(?,?)";
}

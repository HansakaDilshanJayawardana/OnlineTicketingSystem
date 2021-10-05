package model;

import java.sql.Date;

public class Ticket {
    //declare variables
    private int id;
    private int passenger;
    private String pickup;
    private String destination;
    private Date date;
    private Date issueDate;

    //default constructor
    public Ticket() {
    }

    //overloaded constructor
    public Ticket(int id, String pickup, String destination, Date date) {
        this.id = id;
        this.pickup = pickup;
        this.destination = destination;
        this.date = date;
    }

    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPassenger() {return passenger;}

    public void setPassenger(int passenger) {this.passenger = passenger;}

    public Date getIssueDate() {return issueDate;}

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}

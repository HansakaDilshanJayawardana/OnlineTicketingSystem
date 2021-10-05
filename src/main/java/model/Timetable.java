package model;

import java.sql.Time;

public class Timetable {
    //declare variables
    private int id;
    private String name;
    private Time startingTime;
    private Time endTime;
    private String startingPoint;
    private String destination;

    //default constructor
    public Timetable() {
    }

    //overloaded constructor
    public Timetable(int id, String name, Time startingTime, Time endTime, String startingPoint, String destination) {
        this.id = id;
        this.name = name;
        this.startingTime = startingTime;
        this.endTime = endTime;
        this.startingPoint = startingPoint;
        this.destination = destination;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Time startingTime) {
        this.startingTime = startingTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

package service;

import model.Timetable;

import java.util.ArrayList;

public interface ITimetable {

    public void addTimetable(Timetable timetable);
    public void editTimetable(Timetable timetable);
    public ArrayList<Timetable> viewTimetable();
    public Timetable selectTimetable(int id);
    public boolean deleteTimetable(int id);
}

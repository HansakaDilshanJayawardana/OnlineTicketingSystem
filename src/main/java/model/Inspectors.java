package model;

public class Inspectors extends Staff {
    //declare variables
    private String location;

    //default constructor
    public Inspectors() {
    }

    //overload constructor
    public Inspectors(int id, String name, String nic, String phone, String email, String location) {
        super(id, name, nic, phone, email);
        this.location = location;
    }

    //getters and setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

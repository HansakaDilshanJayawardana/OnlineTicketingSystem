package model;

public class Transportmanager extends Staff{
    //declare variables
    private String branch;

    //default constructor
    public Transportmanager() {}


    //overload constructor

    public Transportmanager(int id, String name, String nic, String phone, String email, String branch1) {
        super(id, name, nic, phone, email);
        this.branch = branch1;
    }


    //getters and setters


    public String getBranch() {
        return branch;
    }


    public void setBranch(String branch) {
        this.branch = branch;
    }
}

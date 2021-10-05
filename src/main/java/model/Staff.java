package model;

abstract class Staff {
    //declare variables
    private int id;
    private String name;
    private String nic;
    private String phone;
    private String email;


    //default constructor
    public Staff(){}

    //overload constructor
    public Staff(int id, String name, String nic, String phone, String email) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.email = email;

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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

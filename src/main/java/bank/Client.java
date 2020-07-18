package main.java.bank;

import java.sql.Date;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String userId;
    private String password;
    private Date birth_date;
    private String address;
    private boolean isAdmin;

    Client (int id, String firstName, String lastName, String userId, String password, Date date, String address, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.password = password;
        this.birth_date = date;
        this.address = address;
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthDate() {
        return birth_date;
    }

    public String getAddress() {
        return address;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}

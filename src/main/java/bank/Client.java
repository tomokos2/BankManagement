package main.java.bank;

import java.sql.Date;

public class Client {

    static Client currentClient = null;
    private int id;
    private String firstName;
    private String lastName;
    private String userId;
    private String password;
    private Date birthDate;
    private String address;
    private boolean isAdmin;

    public Client (int id, String firstName, String lastName, String userId, String password, Date date, String address, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.password = password;
        this.birthDate = date;
        this.address = address;
        this.isAdmin = isAdmin;
    }

    public static Client getCurrentClient() { return currentClient; }

    public static void login(Client c) {
        currentClient = c;
    }

    public static void logout() {
        currentClient = null;
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
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public int getId() { return id; }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}

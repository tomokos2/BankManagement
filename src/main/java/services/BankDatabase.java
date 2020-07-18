package main.java.services;

import java.sql.*;

public class BankDatabase {
    private static BankDatabase db = null;

    private Connection connection;
    private PreparedStatement statement;

    public static void addClient(String firstName, String lastName, Date date,
                                 String address, String userID, String password) {
        db.get().iAddClient(firstName, lastName, date,address, userID, password);
    }

    private BankDatabase() {
        try {
            connection = DriverManager.getConnection(Constants.HOST, Constants.USER_NAME, Constants.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static BankDatabase get() {
        if (db == null) {
            db = new BankDatabase();
        }
        return db;
    }

    private void iAddClient(String firstName, String lastName, Date date,
                          String address, String userID, String password) {
        try {
            statement = connection.prepareStatement("INSERT INTO " +
                    "bank.clients(first_name, last_name, user_id, password, birth_date, address)" +
                    " VALUES(?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, userID);
            statement.setString(4, password);
            statement.setDate(5, date);
            statement.setString(6, address);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void iGetClient(String id, String password) {
        try {
            statement = connection.prepareStatement("SELECT * FROM clients WHERE user_id = ? and password = ?");
            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

            }

        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }
}

package main.java.services;

import main.java.bank.Client;

import java.sql.*;

public class BankDatabase {
    private static BankDatabase db = null;

    private Connection connection;
    private PreparedStatement statement;

    public static void addClient(String firstName, String lastName, Date date,
                                 String address, String userID, String password) {
        db.get().iAddClient(firstName, lastName, date,address, userID, password);
    }

    public static Client getClient(String id, String password) {
        return db.get().iGetClient(id, password);
    }

    private BankDatabase() {
        try {
            connection = DriverManager.getConnection(Constants.HOST, Constants.USER_NAME, Constants.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void shutDown() {
        try {
            get().connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    private Client iGetClient(String id, String password) {
        Client client;
        try {
            statement = connection.prepareStatement("SELECT * FROM clients WHERE user_id = ? and password = ?");
            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                client = new Client(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("user_id"),
                        rs.getString("password"),
                        rs.getDate("birth_date"),
                        rs.getString("address"),
                        rs.getBoolean("is_admin")
                        );
            } else {
                return null;
            }

            return client;

        } catch (SQLException e) {
            e.printStackTrace();;
        }

        return null;
    }
}

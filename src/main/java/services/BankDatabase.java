package main.java.services;

import main.java.bank.Account;
import main.java.bank.AccountFactory;
import main.java.bank.Client;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public static void addAccount(int client_id, int deposit, String type) {
        db.get().iAddAccount(client_id, deposit, type);
    }

    public static List<Account> getAccounts(String id, String type) {
        return db.get().iGetAccounts(id, type);
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

    private void iAddAccount(int clientId, int deposit, String type) {
        try {
            statement = connection.prepareStatement("INSERT INTO bank.accounts(balance, acc_type, client_id)" +
                    "VALUES(?, ?, ?)");
            statement.setString(1, Integer.toString(deposit));
            statement.setString(2, type);
            statement.setString(3, Integer.toString(clientId));
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

    private List<Account> iGetAccounts(String id, String type) {
        LinkedList<Account> accounts = new LinkedList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM accounts WHERE user_id = ? AND acc_type = ?");
            statement.setString(1, id);
            statement.setString(2, type);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                accounts.add(AccountFactory.makeAccount(type, rs.getInt("balance")));
            }

            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}

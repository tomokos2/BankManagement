package main.java.bank;

import main.java.bank.accountTypes.CDAccount;
import main.java.bank.accountTypes.CheckingAccount;
import main.java.bank.accountTypes.RetirementAccount;
import main.java.bank.accountTypes.SavingsAccount;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class AccountFactory {
    public static Account makeAccount(String type, int id, int balance, LocalDateTime dateCreated, LinkedList<Transaction> transactions) {
        switch (type) {
            case "cd":
                return new CDAccount(id, balance, dateCreated, transactions);
            case "savings":
                return new SavingsAccount(id, balance, dateCreated, transactions);
            case "retirement":
                return new RetirementAccount(id, balance, dateCreated, transactions);
            case "checking":
                return new CheckingAccount(id, balance, dateCreated, transactions);
            default:
                System.err.println("Invalid account type");
                return null;
        }
    }
}

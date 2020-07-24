package main.java.bank;

import main.java.bank.accountTypes.CDAccount;
import main.java.bank.accountTypes.CheckingAccount;
import main.java.bank.accountTypes.RetirementAccount;
import main.java.bank.accountTypes.SavingsAccount;

public abstract class AccountFactory {
    public static Account makeAccount(String type, int balance) {
        switch (type) {
            case "cd":
                return new CDAccount(balance);
            case "savings":
                return new SavingsAccount(balance);
            case "retirement":
                return new RetirementAccount(balance);
            case "checking":
                return new CheckingAccount(balance);
            default:
                System.err.println("Invalid account type");
                return null;
        }
    }
}

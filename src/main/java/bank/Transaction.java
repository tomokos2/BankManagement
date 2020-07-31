package main.java.bank;

import java.time.LocalDateTime;

public class Transaction {
    public static final int SUCCESS = 0;
    public static final int ERROR = -1;
    public static final int PENDING = 1;
    private int accountId;
    private LocalDateTime date;
    private double amount;
    private int status;
    private String type;
    private String errorMsg;

    public static final String INSUFFICIENT_FUNDS = "Insufficient funds";

    public Transaction(int accountId, LocalDateTime date, double amount, int status, String type, String errorMsg) {
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.type = type;
        this.errorMsg = errorMsg;
    }

    public int getAccountId() {
        return accountId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getErrorMsg() { return errorMsg; }

    public String getStatusString() {
        if (status == SUCCESS) {
            return "Success";
        } else if (status == ERROR) {
            return "Error";
        } else {
            return "Processing";
        }
    }
}

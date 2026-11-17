package klickpay.src.main.java.com.klickpay.model;

import java.time.LocalDateTime;

public class TransactionModel {
    private String transactionId;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public TransactionModel(String transactionId, String type, double amount) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() { return transactionId; }

    public String getType() { return type; }

    public double getAmount() { return amount; }

    public LocalDateTime getTimestamp() { return timestamp; }
}
package src.klickpay.model;

import java.time.LocalDateTime;

public class TransactionModel {
    private String transactionId;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private String numberDetails;

    public TransactionModel(String transactionId, String type, double amount, String numberDetails) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.numberDetails = numberDetails;
    }

    public String getTransactionId() { return transactionId; }

    public String getType() { return type; }

    public double getAmount() { return amount; }

    public LocalDateTime getTimestamp() { return timestamp; }

    public String getNumberDetails() { return numberDetails; }
}
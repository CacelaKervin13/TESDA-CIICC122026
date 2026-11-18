package src.klickpay.service;

import src.klickpay.model.TransactionModel;
import src.klickpay.model.UserModel;

import java.util.Map;

public class UserTransaction {

    public void viewTransactionHistory(UserModel user) {
        Map<String, TransactionModel> transactions = user.getTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transaction history found for your account.");
            return;
        }

        System.out.println("==========================================");
        System.out.println("          TRANSACTION HISTORY             ");
        System.out.println("==========================================");
        for (TransactionModel transaction : transactions.values()) {
            System.out.println("ID             : " + transaction.getTransactionId());
            System.out.println("Type           : " + transaction.getType());
            System.out.println("Amount         : ₱" + transaction.getAmount());
            System.out.println("Number Details : " + transaction.getNumberDetails());
            System.out.println("Timestamp      : " + transaction.getTimestamp());
            System.out.println("---------------------------------------");
        }
    }

    public void deposit(UserModel user, double amount) {
        if (amount <= 0) {
            System.out.println("\nDeposit failed: Amount must be greater than zero.");
            return;
        }

        user.setBalance(user.getBalance() + amount);

        String transactionId = "TXN-" + System.currentTimeMillis();
        TransactionModel transaction = new TransactionModel(transactionId, "DEPOSIT", amount, user.getNumber());

        user.addTransaction(transaction);

        System.out.println("\nSuccessfully deposited ₱" + amount + ". New balance: ₱" + user.getBalance());
    }

    public void transfer(UserModel sender, UserModel recipient, double amount) {
        if (amount <= 0) {
            System.out.println("\nTransfer failed: Amount must be greater than zero.");
            return;
        }

        if (recipient == null) {
            System.out.println("\nTransfer failed: Recipient account does not exist.");
            return;
        }
        
        if (sender.getNumber().equals(recipient.getNumber())) {
            System.out.println("\nTransfer failed: You cannot transfer money to your own account.");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("\nTransfer failed: Insufficient balance.");
            return;
        }

        // Record sender transaction
        sender.setBalance(sender.getBalance() - amount);
        String senderTxId = "TXN-OUT-" + System.currentTimeMillis();
        TransactionModel senderTx = new TransactionModel(senderTxId, "TRANSFER_OUT", amount, recipient.getNumber());
        sender.addTransaction(senderTx);

        // Record receiver transaction
        recipient.setBalance(recipient.getBalance() + amount);
        String recipientTxId = "TXN-IN-" + System.currentTimeMillis();
        TransactionModel recipientTx = new TransactionModel(recipientTxId, "TRANSFER_IN", amount, sender.getNumber());
        recipient.addTransaction(recipientTx);

        System.out.println("\nSuccessfully transferred ₱" + amount + " to " + recipient.getName() + ".");
        System.out.println("Your new balance: ₱" + sender.getBalance());
    }
}



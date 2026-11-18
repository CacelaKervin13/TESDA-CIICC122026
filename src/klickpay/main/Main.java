package src.klickpay.main;

import src.klickpay.model.UserModel;
import src.klickpay.service.UserAuthentication;
import src.klickpay.service.UserTransaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuthentication auth = new UserAuthentication();
        UserTransaction transService = new UserTransaction();
        boolean isRunning = true;

        System.out.println("========================================");
        System.out.println("            WELCOME TO KLICKPAY         ");
        System.out.println("========================================");

        while (isRunning) {
            UserModel currentUser = auth.getLoggedInUser();
            System.out.println("\n________________________________________");

            if (currentUser == null) {
                System.out.println("Status: [ NOT LOGGED IN ]");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
            } else {
                System.out.println("Status: [ LOGGED IN AS: " + currentUser.getName() + 
                " | Balance: ₱" + currentUser.getBalance() + " ]");
                System.out.println("1. Deposit Money");
                System.out.println("2. Transfer Money");
                System.out.println("3. View Transaction History");
                System.out.println("4. Change PIN");
                System.out.println("5. Logout");
                System.out.println("6. Exit");
            }

            System.out.println("\n________________________________________");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            if (currentUser == null) {
                switch (choice) {
                    case "1":
                        System.out.print("Enter Full Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine().trim();
                        System.out.print("Enter Mobile Number: ");
                        String number = scanner.nextLine().trim();
                        System.out.print("Enter PIN: ");
                        String pin = scanner.nextLine().trim();
                        auth.registerUser(name, email, number, pin);
                        break;

                    case "2":
                        System.out.print("Enter Email: ");
                        String loginEmail = scanner.nextLine().trim();
                        System.out.print("Enter PIN: ");
                        String loginPin = scanner.nextLine().trim();
                        auth.login(loginEmail, loginPin);
                        break;

                    case "3":
                        isRunning = false;
                        System.out.println("Thank you for using KlickPay. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again!");
                }
            } else {
                switch (choice) {
                    case "1": // Deposit
                        System.out.print("Enter amount to deposit: ₱");
                        try {
                            double depositAmount = Double.parseDouble(scanner.nextLine().trim());
                            transService.deposit(currentUser, depositAmount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount format. Please enter a valid number.");
                        }
                        break;

                    case "2": // Transfer
                        System.out.print("Enter Recipient Mobile Number: ");
                        String recipientNumber = scanner.nextLine().trim();

                        System.out.print("Enter amount to transfer: ₱");
                        try {
                            double transferAmount = Double.parseDouble(scanner.nextLine().trim());

                            UserModel recipient = auth.getUserByNumber(recipientNumber);
                            transService.transfer(currentUser, recipient, transferAmount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount format. Please enter a valid number.");
                        }
                        break;

                    case "3": // View Transaction History
                        transService.viewTransactionHistory(currentUser);
                        break;

                    case "4": // Change PIN
                        System.out.print("Enter Current PIN: ");
                        String oldPin = scanner.nextLine().trim();
                        System.out.print("Enter New PIN: ");
                        String newPin = scanner.nextLine().trim();
                        auth.changePin(currentUser.getEmail(), oldPin, newPin);
                        break;

                    case "5": // Logout
                        auth.logout();
                        break;

                    case "6": // Exit
                        isRunning = false;
                        System.out.println("Thank you for using KlickPay. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again!");
                }
            }
        }
        scanner.close();
    }
}
package src.klickpay.service;

import src.klickpay.model.UserModel;

import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private Map<String, UserModel> userDatabase = new HashMap<>();
    private long idCounter = 200;

    private UserModel loggedInUser = null;

    public boolean registerUser(String name, String email, String number, String pin) {
        if (userDatabase.containsKey(email)) {
            System.out.println("\nRegistration failed: User with email " + email + " already exists.");
            return false;
        }

        long autoID = idCounter++;

        UserModel newUser = new UserModel(autoID, name, email, number, pin);
        userDatabase.put(email, newUser);
        System.out.println("\nRegistration successful! welcome to Klickpay");
        return true;
    }

    public UserModel login(String email, String pin) {
        UserModel user = userDatabase.get(email);

        if (user == null) {
            System.out.println("\nLogin failed: No account with this email.");
            return null;
        }

        if (user.isLocked()) {
            long remainingSeconds = user.getRemainingLockoutTimeSeconds();
            System.out.println("\nLogin failed: Account is locked. Please try again in " + remainingSeconds + " second(s).");
            return null;
        }

        if (!user.getPin().equals(pin)) {
            user.incrementFailedAttempts();
            int remainingAttempts = 3 - user.getFailedAttempts();

            if (user.getFailedAttempts() >= 3) {
                user.triggerLockout();
                System.out.println("\nIncorrect PIN. Account locked for 1 minute due to 3 failed login attempts.");
            } else {
                System.out.println("\nLogin failed: Incorrect PIN. You have " + remainingAttempts + " attempt(s) left.");
            }
            return null;
        }

        loggedInUser = user;
        System.out.println("\nLogin successful. Welcome, " + user.getName() + "!");
        return loggedInUser;
    }

    public void logout() {
        if (loggedInUser != null) {
            System.out.println("\nLogged out successfully.");
            loggedInUser = null;
        } else {
            System.out.println("\nNo user is currently logged in.");
        }
    }

    public boolean changePin(String email, String oldPin, String newPin) {
        UserModel user = userDatabase.get(email);

        if (user == null) {
            System.out.println("\nError: User not found.");
            return false;
        }

        if (!user.getPin().equals(oldPin)) {
            System.out.println("\nPIN change failed: Current PIN is incorrect.");
            return false;
        }

        if (newPin == null || newPin.trim().isEmpty()) {
            System.out.println("\nPIN change failed: New PIN cannot be empty.");
            return false;
        }

        user.setPin(newPin);
        System.out.println("\nPIN updated successfully.");
        return true;
    }

    public UserModel getUserByNumber(String number) {
        for (UserModel user : userDatabase.values()) {
            if (user.getNumber().equals(number)) {
                return user;
            }
        }
        return null;
    }

    public UserModel getLoggedInUser() { return loggedInUser; }
}
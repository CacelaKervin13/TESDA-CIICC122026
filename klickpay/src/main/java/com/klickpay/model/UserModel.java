package klickpay.src.main.java.com.klickpay.model;

public class UserModel {
    private long ID;
    private String name;
    private String email;
    private String number;
    private String pin;
    private double balance = 0.0;

    private int failedAttempts = 0;
    private long lockoutEndTime = 0;
    private static final long LOCKOUT_DURATION_MS = 60 * 1000;

    public UserModel(long ID, String name, String email, String number,  String pin){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.number = number;
        this.pin = pin;
    }

    public void setBalance(double balance){ this.balance = balance; }
    public void setPin(String pin){ this.pin = pin; }


    public long getID(){ return ID; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }
    public String getNumber(){ return number; }
    public String getPin(){ return pin; }
    public double getBalance() { return balance; }


    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void incrementFailedAttempts() {
        this.failedAttempts++;
    }

    public boolean isLocked() {
        if (lockoutEndTime > 0) {
            if (System.currentTimeMillis() < lockoutEndTime) {
                return true;
            } else {
                resetLockout();
                return false;
            }
        }
        return false;
    }

    public long getRemainingLockoutTimeSeconds() {
        if (lockoutEndTime > System.currentTimeMillis()) {
            return (lockoutEndTime - System.currentTimeMillis()) / 1000;
        }
        return 0;
    }

    public void triggerLockout() {
        this.lockoutEndTime = System.currentTimeMillis() + LOCKOUT_DURATION_MS;
    }

    public void resetLockout() {
        this.failedAttempts = 0;
        this.lockoutEndTime = 0;
    }
}

package klickpay.src.main.java.com.klickpay.model;

public class UserModel {
    private long ID;
    private String name;
    private String email;
    private String number;
    private String pin;
    private double balance = 0.0;

    public UserModel(int ID, String name, String email, String number,  String pin){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.number = number;
        this.pin = pin;
    }

    public void setBalance(double balance){ this.balance = balance; }


    public long getID(){ return ID; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }
    public String getNumber(){ return number; }
    public String getPin(){ return pin; }
    public double getBalance() { return balance; }
}

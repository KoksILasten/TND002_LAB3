package lab3;

public class Account {
    // Objects
    protected int accountNumber;
    protected String accountType; // Current & Savings
    protected double balance;
    protected Account otherAccount;
    public static double FEE, INTREST;

    // Methods
    public Account(int accnum) {
        accountNumber = accnum;
        accountType = "Current";
    }

    public Account(int accnum, Current c) {
        accountNumber = accnum;
        otherAccount = c; // binds savningsaccount with currentaccount
        c.otherAccount = this; // binds currentaccount to savningsaccount
        accountType = "Savings";
    }

    public String getAccountType() {
        return accountType;
    }

    public int getNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void annualCharge() {
        FEE = 10.0;
        INTREST = 0.02;
        if (accountType.equals("Current")) {
            balance = balance - FEE;
        } else if (accountType.equals("Savings")) {
            balance = balance + balance * INTREST;
        }
    }

}
package lab3;

public class Transaction {
    private int theAccount;
    private double theAmount;
    private String tofrom;

    public Transaction(String tofr, int account, double amount) { // Stores information from otherAccount
        tofrom = tofr;
        theAccount = account;
        theAmount = amount;
    }

    public String toString() {
        return String.format("Money Transfer: %-5s account: %4d : %6.2f", tofrom, theAccount, theAmount);
    }
}

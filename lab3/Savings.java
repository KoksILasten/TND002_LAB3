package lab3;

public class Savings extends Account {
    public Savings(Current c, int accnum) {
        super(accnum, c);
        balance = 0.0;
    }

    public void changeBalance(double ammount) {
        balance += ammount;
    }

    public double getBalance() {
        return balance;
    }
}

package lab3;

import java.util.ArrayList;

public class Current extends Account {
    private Customer theCustomer;
    private ArrayList<Transaction> theTransactions;

    public Current(Customer c, int accnum, double money) {
        super(accnum);
        theCustomer = c;
        balance = money;
        theTransactions = new ArrayList<Transaction>();
    }

    public Customer getCustomer() {
        return theCustomer;
    }

    public void transfer(double transamo) {
        double money = Math.abs(transamo);

        if (transamo > 0.0) {
            if (balance < money) {
                money = balance;
            }
            balance -= money;
            otherAccount.balance += money;
            theTransactions.add(new Transaction("to", otherAccount.getNumber(), money));
        } else if (transamo <= 0.0) {
            if (otherAccount.balance < money) {
                money = otherAccount.balance;
            }
            balance += money;
            otherAccount.balance -= money;
            theTransactions.add(new Transaction("from", otherAccount.getNumber(), money));
        }
    }

    public void deposit(Current c, double money) {
        balance += money;
        theTransactions.add(new Transaction("from", c.getNumber(), money));
    }

    public void transfer(Current c, double money) {
        balance -= money;
        c.deposit(this, money);
        theTransactions.add(new Transaction("to", c.getNumber(), money));
    }

    public String toString() {
        String result = String.format("%23s %19s\n %21s %15s\n %21s %15s\n %21s %14s\n %1s\n ",
                "Customer: ", theCustomer.getName(),
                "Account number:", accountNumber,
                "Balance:", balance,
                "Savings:", otherAccount.getBalance(),
                "List of transactions:\n");

        for (int i = 0; i < theTransactions.size(); i++) {
            result += theTransactions.get(i).toString() + "\n";
        }
        return result;

    }
}

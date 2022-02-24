package lab3;

public class Customer {
    // Objects
    private String name; // Customer Name
    private Current currentAccount; // Contains Account number
    private Savings savingsAccount;

    // Methods
    public Customer(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public Current getcurrentAccount() {
        return currentAccount;
    }

    public void addAccounts(Current c, Savings money) {
        currentAccount = c;
        savingsAccount = money;

    }

    public String toString() {
        String result = String.format("Name of Customer: %-16s", name) + "\n";

        if (currentAccount != null && savingsAccount != null) { // Shows Accounts number if set
            result = result + String.format("Current Account: %-15s", currentAccount.getNumber()) + "\n";
            result += String.format("Savnings Account: %-15s", savingsAccount.getNumber());
        }
        return result;
    }
}

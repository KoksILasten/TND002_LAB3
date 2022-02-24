package lab3;

import java.util.ArrayList;

public class Bank {
    // Objects
    private ArrayList<Customer> customerList;
    private ArrayList<Account> accountList;
    private int accountNumber;

    // Methods
    public Bank() {
        customerList = new ArrayList<Customer>();
        accountList = new ArrayList<Account>();
        accountNumber = 1000;
    }

    public String addCustomer(String name, double sum) {

        if (findCustomer(name) != null) {
            return "Customer exists already";

        } else {
            Customer qwe = new Customer(name);

            customerList.add(qwe);

            Current myCurrent = new Current(qwe, accountNumber, sum);
            accountNumber++;
            Savings mySavings = new Savings(myCurrent, accountNumber);
            accountNumber++;

            qwe.addAccounts(myCurrent, mySavings);
            accountList.add(myCurrent);
            accountList.add(mySavings);

            // customerList.add(c);

            return "Customer added";
        }
    }

    public Customer findCustomer(String checkname) {
        Customer c = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(checkname)) {
                c = customerList.get(i);
                break;
            }
        }
        if (c == null) {
            System.out.println("Customer does not exist!");
        }
        return c;
    }

    public void transfer(String name, double money) {
        Customer c = findCustomer(name);
        if (c != null) {
            c.getcurrentAccount().transfer(money);
        }
    }

    public void transfer(String fromname, String toname, double transferamount) {
        Customer fromCustomer = findCustomer(fromname);
        Customer toCustomer = findCustomer(toname);
        fromCustomer.getcurrentAccount().transfer(toCustomer.getcurrentAccount(), transferamount);

    }

    public String checkAccount(int accnum) {
        String result = "Not a current account";
        int numbr = accnum - 1000;

        if (numbr <= accountList.size()) {
            if (accountList.get(numbr).getAccountType().equals("Current")) {
                result = accountList.get(numbr).toString();
            }
        }
        return result;
    }

    public void annualChange() {
        for (Account a : accountList) {
            a.annualCharge();
        }

    }

    public String toString() {
        double money = 0.0;
        for (int i = 0; i < accountList.size(); i++) {
            money += accountList.get(i).getBalance();
        }

        String result = String.format("%10s\n ------------\n", "\nBank statistics");
        result += String.format("%12s %10s\n", "Customers: ", customerList.size());
        result += String.format("%12s %10.2f", "Money: ", money);
        return result;
    }

}

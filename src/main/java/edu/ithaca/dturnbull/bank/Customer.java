package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;

public class Customer {

    String name;   
    String customerID;
    String password;
    ArrayList<Account> accounts;

    public Customer(String nameIn, String customerID, String password) {
        this.name = nameIn;
        this.customerID = customerID;
        this.password = password;
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public void removeAccount(Account accountToDelete) {
        accounts.remove(accountToDelete);
    }
    
}

package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;

public class Customer {
    String name;   
    int customerID;
    String password;
    ArrayList<Account> accounts;

    public Customer(String nameIn, int customerID, String password) {
        this.name = nameIn;
        this.customerID = customerID;
        this.password = password;
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    public void removeAccount(Account accountToDelete) {
        accounts.remove(accountToDelete);
      
    }

    public String getName() {
        return name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }
    
    public String getName() {
        return name;
    }

    public int getID() {
        return customerID;
    }

    public void changePassword(String newPassword) {
        password = newPassword;
    }
}

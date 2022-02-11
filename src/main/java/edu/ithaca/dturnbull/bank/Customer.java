package edu.ithaca.dturnbull.bank;

public class Customer {

    String name;   
    String customerID;
    String password;
    Account[] accounts;

    public Customer(String nameIn, String customerID, String password) {
        this.name = nameIn;
        this.customerID = customerID;
        this.password = password;
    }

    public void addAccount(Account newAccount) {
        
    }
    
}

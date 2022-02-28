package edu.ithaca.dturnbull.bank;

import java.util.List;

public class BankTeller extends Teller {
    private int tellerID;
    private List<Customer> customerList;
    
   
    public BankTeller(CentralBank centralBank) {
        super(centralBank);
        customerList = centralBank.getCustomerList();
        tellerID = centralBank.getNextBankTellerID();
        centralBank.increaseBankTellerID();
        
    }
    
    public void createAccount(CentralBank centralBank, String customerName, double balance, Boolean saving) {
        if (saving) {
            SavingAccount savingAccount = new SavingAccount(balance, centralBank.getNextAccountID(), 0.05, 1000);
            centralBank.increaseAccountID();
            for (Customer customerToFind: customerList) {
                if (customerToFind.getName() == customerName) {
                    customerToFind.addAccount(savingAccount);
                }
            }
        } else {
            CheckingAccount checkingAccount = new CheckingAccount(balance, centralBank.getNextAccountID());
            centralBank.increaseAccountID();
            for (Customer customerToFind: customerList) {
                if (customerToFind.getName() == customerName) {
                    customerToFind.addAccount(checkingAccount);
                }
            }
        }
    }

    public void closeAccount(CentralBank centralBank, String customerName, Boolean savingOrNot) {
        for (Customer customerToFind: customerList) {
            if (customerToFind.getName() == customerName) {
                List<Account> accounts = customerToFind.getAccounts();
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).saving == savingOrNot) {
                        customerToFind.removeAccount(accounts.get(i));
                    }
                }
            }
        }
    }

    public int getID() {
        return tellerID;
    }

    public void registerCustomer(CentralBank centralBank, String name, String password) {
        int customerID = centralBank.getNextCustomerID();
        Customer newCustomer = new Customer(name, customerID, password);
        centralBank.increaseCustomerID();
        centralBank.addCustomer(newCustomer);
    }
}

package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private static List<Customer> customerList;
    private static List<List<Teller>> tellerList;
    private static List<Teller> atmList;
    private static List<Teller> bankTellerList;
    private static int nextCustomerID = 0;
    private static int nextAccountID = 0;
    private static int nextAtmID = 0;
    private static int nextBankTellerID = 0;

    public CentralBank() {
        customerList = new ArrayList<>();
        atmList = new ArrayList<>();
        bankTellerList = new ArrayList<>();
        tellerList.add(bankTellerList);
        tellerList.add(atmList);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public int getNextCustomerID() {
        return nextCustomerID;
    }

    public int getNextAccountID() {
        return nextAccountID;
    }
    
    public int getNextAtmID() {
        return nextAtmID;
    }

    public int getNextBankTellerID() {
        return nextBankTellerID;
    }

    public void increaseCustomerID() {
        nextCustomerID++;
    }

    public void increaseAccountID() {
        nextAccountID++;
    }

    public void increaseAtmID() {
        nextAtmID++;
    }

    public void increaseBankTellerID() {
        nextBankTellerID++;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
   
}

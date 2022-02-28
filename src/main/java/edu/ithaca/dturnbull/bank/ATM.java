package edu.ithaca.dturnbull.bank;

import java.util.List;

public class ATM extends Teller {
    private int tellerID;
    private String location;
    private List<Customer> customerList;
    
    public ATM(CentralBank centralBank, String atmLocation) {
        super(centralBank);
        tellerID = centralBank.getNextAtmID();
        location = atmLocation;
        customerList = centralBank.getCustomerList();
        centralBank.increaseAtmID();
    }

    public int getID() {
        return tellerID;
    }

    public String getLocation() {
        return location;
    }

}

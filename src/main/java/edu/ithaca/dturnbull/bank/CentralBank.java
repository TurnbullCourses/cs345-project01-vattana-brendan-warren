package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Customer> customerList;
    private List<List<Teller>> tellerList;
    private int nextAccountID = 0;
    private int nextAtmID = 0;
    private int nextBankTellerID = 0;

    public CentralBank() {
        customerList = new ArrayList<>();
        tellerList = new ArrayList<>();
    }
}

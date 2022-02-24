package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Customer> customerList;
    private List<List<Teller>> tellerList;

    public CentralBank() {
        customerList = new ArrayList<>();
        tellerList = new ArrayList<>();
    }
}

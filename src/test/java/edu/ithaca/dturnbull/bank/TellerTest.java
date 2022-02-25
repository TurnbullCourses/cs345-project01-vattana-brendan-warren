package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TellerTest {
    @Test
    void bankTellerTest() throws InsufficientFundsException {
        //id test
        CentralBank chase = new CentralBank();
        BankTeller bankTeller1 = new BankTeller(chase);
        assertEquals(0, bankTeller1.getID());

        BankTeller bankTeller2 = new BankTeller(chase);
        assertEquals(1, bankTeller2.getID());

        BankTeller bankTeller3 = new BankTeller(chase);
        assertEquals(2, bankTeller3.getID());
        
        //create account test
        Customer customer1 = new Customer("Brendan", 001, "omg");
      
        bankTeller1.createAccount(chase, customer1, 500, true);

        assertEquals(500, bankTeller1.checkAccountBalance(customer1, customer1.accounts.get(0)));

        bankTeller1.createAccount(chase, customer1, 1000, false);

        assertEquals(1000, bankTeller1.checkAccountBalance(customer1, customer1.accounts.get(1)));

        //close account test
        assertEquals(2, customer1.accounts.size());
        bankTeller1.closeAccount(customer1, customer1.getAccounts().get(0));
        assertEquals(1, customer1.accounts.size());

        bankTeller1.closeAccount(customer1, customer1.getAccounts().get(0));
        assertEquals(0, customer1.accounts.size());



        registerCustomerTest(chase); //test for registering new customers
    }

    void registerCustomerTest(CentralBank centralBank) {
        BankTeller testBankTeller = new BankTeller(centralBank);
        testBankTeller.registerCustomer("Vattana", "123");

        assertEquals(1 ,centralBank.getCustomerList().size());

        
    }

    @Test
    void atmTest() {
        //id test
        CentralBank bank = new CentralBank();
        ATM atm1 = new ATM(bank, "New York City");
        assertEquals(0, atm1.getID());

        ATM atm2 = new ATM(bank, "Chicago City");
        assertEquals(1, atm2.getID());

        ATM atm3 = new ATM(bank, "Mexico City");
        assertEquals(2, atm3.getID());

    }
}

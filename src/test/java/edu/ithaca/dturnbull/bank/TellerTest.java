package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TellerTest {
    @Test
    void bankTellerTests() throws InsufficientFundsException {
       // idTestForBankTeller();
        registerCustomerTest();
        //closeAccountTest();
    }
         
    void idTestForBankTeller() {
        //id test
        CentralBank chase = new CentralBank();
        BankTeller bankTeller1 = new BankTeller(chase);
        assertEquals(1, bankTeller1.getID());

        BankTeller bankTeller2 = new BankTeller(chase);
        assertEquals(2, bankTeller2.getID());

        BankTeller bankTeller3 = new BankTeller(chase);
        assertEquals(3, bankTeller3.getID());
    }

    @Test
    void closeAccountTest() {
        CentralBank chase = new CentralBank();
        BankTeller bankTeller1 = new BankTeller(chase);
        assertEquals(0, chase.getCustomerList().size());

        bankTeller1.registerCustomer(chase, "Kenny", "123"); //register a customer

        assertEquals(1, chase.getCustomerList().size());
        assertEquals(0, chase.getCustomerList().get(0).getAccounts().size()); //the customer doesn't have any accounts yet

        bankTeller1.createAccount(chase, "Kenny", 500, true); //create a saving account
        assertEquals(1, chase.getCustomerList().get(0).getAccounts().size()); //the customer now has an account

        bankTeller1.createAccount(chase, "Kenny", 500, false); //create a checking account
        assertEquals(2, chase.getCustomerList().get(0).getAccounts().size()); //the customer now has two accounts

        bankTeller1.closeAccount(chase, "Kenny", false);
        assertEquals(1, chase.getCustomerList().get(0).getAccounts().size()); //the customer now has only 1 account

        bankTeller1.closeAccount(chase, "Kenny", false);
        assertEquals(1, chase.getCustomerList().get(0).getAccounts().size()); //the customer doesn't have any more checking account to close

        bankTeller1.closeAccount(chase, "Kenny", true);
        assertEquals(0, chase.getCustomerList().get(0).getAccounts().size()); //the customer doesn't have any more account
    }
         
    @Test
    void createAccountAndCheckAccountBalanceTestForBankTellerAndAtm() throws InsufficientFundsException{
        //create account test
        CentralBank chase = new CentralBank();
        assertEquals(0,chase.getCustomerList().size()); //no customers yet
        
        //checkBalance for BankTeller
        BankTeller bankTeller1 = new BankTeller(chase);

        assertEquals(-1, bankTeller1.checkAccountBalance("Kenny", true)); //no saving account associated with the customer found
        assertEquals(-1, bankTeller1.checkAccountBalance("Kenny", false)); //no checking account associated with the customer found

        bankTeller1.registerCustomer(chase, "Kenny", "123");
        bankTeller1.createAccount(chase, "Kenny", 500, true);
        assertEquals(1,chase.getCustomerList().size()); //there is only one customer

        assertEquals(500, bankTeller1.checkAccountBalance("Kenny", true));
        assertEquals(-1, bankTeller1.checkAccountBalance("Kenny", false)); //no checking account associated with the customer found

        bankTeller1.createAccount(chase, "Kenny", 1000, false);

        assertEquals(500, bankTeller1.checkAccountBalance("Kenny", true));
        assertEquals(1000, bankTeller1.checkAccountBalance("Kenny", false));

        //checkBalance for ATM
        ATM atm1 = new ATM(chase, "Ithaca City");
        assertEquals(500, atm1.checkAccountBalance("Kenny", true));
        assertEquals(1000, atm1.checkAccountBalance("Kenny", false));
    }

    void registerCustomerTest() {
        //test for registering new customers
        CentralBank chase = new CentralBank();
        BankTeller testBankTeller = new BankTeller(chase);
        testBankTeller.registerCustomer(chase, "Vattana", "123");
        assertEquals(1 ,chase.getCustomerList().size());
        assertEquals("Vattana", chase.getCustomerList().get(0).getName());
        assertEquals(1, chase.getCustomerList().get(0).getID());

        testBankTeller.registerCustomer(chase, "Karren", "123");
        assertEquals(2 ,chase.getCustomerList().size());
        assertEquals("Karren", chase.getCustomerList().get(1).getName());
        assertEquals(2, chase.getCustomerList().get(1).getID());

        testBankTeller.registerCustomer(chase, "Brendan", "321");
        assertEquals(3 , chase.getCustomerList().size());
        assertEquals("Brendan", chase.getCustomerList().get(2).getName());
        assertEquals(3, chase.getCustomerList().get(2).getID());

        testBankTeller.registerCustomer(chase, "Warren", "213");
        assertEquals(4 ,chase.getCustomerList().size());
        assertEquals("Warren", chase.getCustomerList().get(3).getName());
        assertEquals(4, chase.getCustomerList().get(3).getID());

        testBankTeller.registerCustomer(chase, "asd", "213");
        assertEquals(5, chase.getCustomerList().get(4).getID());
    }

  
    void transferTestForBankTellerAndAtm() {

    }

    @Test
    void depositTestForBankTellerAndAtm() throws InsufficientFundsException {
        CentralBank chase = new CentralBank();
        BankTeller bankTeller1 = new BankTeller(chase);
        ATM atm1 = new ATM(chase, "Ithaca City");

        bankTeller1.registerCustomer(chase, "Kelly", "123");

        //bankteller deposit test for checking account
        bankTeller1.createAccount(chase, "Kelly", 0, false);

        bankTeller1.deposit("Kelly", false, 1000);
        assertEquals(1000, bankTeller1.checkAccountBalance("Kelly", false)); 

        //atm deposit test for checking acount
        atm1.deposit("Kelly", false, 500);
        assertEquals(1500, bankTeller1.checkAccountBalance("Kelly", false)); 

        //bankteller deposit for saving account
        bankTeller1.createAccount(chase, "Kelly", 10000, true);

        bankTeller1.deposit("Kelly", true, 900);
        assertEquals(10900, bankTeller1.checkAccountBalance("Kelly", true)); 

        //atm deposit test for saving account
        atm1.deposit("Kelly", true, 100);
        assertEquals(11000, bankTeller1.checkAccountBalance("Kelly", true)); 
    }

    @Test
    void withdrawTestForBankTellerAndAtm() throws InsufficientFundsException {
        CentralBank chase = new CentralBank();
        BankTeller bankTeller1 = new BankTeller(chase);
        ATM atm1 = new ATM(chase, "Ithaca City");

        bankTeller1.registerCustomer(chase, "Kelly", "123");

        //bankteller withdrawal test for checking account
        bankTeller1.createAccount(chase, "Kelly", 10000, false);

        bankTeller1.withdraw("Kelly", false, 1000);
        assertEquals(9000, bankTeller1.checkAccountBalance("Kelly", false)); 

        //atm withdrawal test for checking acount
        atm1.withdraw("Kelly", false, 1000);
        assertEquals(8000, bankTeller1.checkAccountBalance("Kelly", false)); 

        //bankteller withdrawal for saving account
        bankTeller1.createAccount(chase, "Kelly", 10000, true);

        bankTeller1.withdraw("Kelly", true, 900);
        assertEquals(9100, bankTeller1.checkAccountBalance("Kelly", true)); 

        //atm withdrawal test for saving account
        atm1.withdraw("Kelly", true, 100);
        assertEquals(9000, bankTeller1.checkAccountBalance("Kelly", true)); 

        assertThrows(InsufficientFundsException.class, () -> atm1.withdraw("Kelly", true, 5000));

    }

    @Test
    void atmTest() {
        //id test
        CentralBank bank = new CentralBank();
        ATM atm1 = new ATM(bank, "New York City");
        assertEquals(1, atm1.getID());

        ATM atm2 = new ATM(bank, "Chicago City");
        assertEquals(2, atm2.getID());

        ATM atm3 = new ATM(bank, "Mexico City");
        assertEquals(3, atm3.getID());

    }

    @Test
    void transferTestForAtm() {

    }

    void depositTestForAtm() {

    }

    void withdrawTestForAtm() {
        
    }

    void checkAccountBalanceTestForAtm() {
        
    }
}

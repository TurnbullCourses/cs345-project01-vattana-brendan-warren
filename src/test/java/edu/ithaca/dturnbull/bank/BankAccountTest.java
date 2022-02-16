package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void constructorAndCheckAccountBalanceTest() {
        //check CheckingAccount constructor
        Account brendan = new CheckingAccount(50, "001");  
        assertEquals(50, brendan.checkAccountBalance());

        Account warren = new CheckingAccount(0.01, "002");
        assertEquals(0.01, warren.checkAccountBalance());

        //check SavingAccount constructor
        Account blosom = new SavingAccount(100, "003", 0.06, 1000);
        assertEquals(100, blosom.checkAccountBalance());

        Account yennefer = new SavingAccount(75, "004", 0.06, 1000);
        assertEquals(75, yennefer.checkAccountBalance());

        //check throws when initializing the constructor
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(-1, "001"));
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(5.003, "001"));
    }

    @Test
    void withdrawForCheckingAccountTest() throws InsufficientFundsException{
        Account brendan = new CheckingAccount(100, "001");
        assertEquals(100, brendan.checkAccountBalance());

        brendan.withdraw(5);
        assertEquals(95, brendan.checkAccountBalance());

        brendan.withdraw(0.01);
        assertEquals(94.99, brendan.checkAccountBalance());

        assertThrows(IllegalArgumentException.class, () -> brendan.withdraw(-1));
        assertThrows(InsufficientFundsException.class, () -> brendan.withdraw(1000));
    }

    @Test
    void withdrawForSavingAccountTest() throws InsufficientFundsException {
        Account brendan = new SavingAccount(10000, "001", 0.04, 1000);
        assertEquals(10000, brendan.checkAccountBalance());

        brendan.withdraw(5);
        assertEquals(9995, brendan.checkAccountBalance());

        brendan.withdraw(0.01);
        assertEquals(9994.99, brendan.checkAccountBalance());

        assertThrows(IllegalArgumentException.class, () -> brendan.withdraw(-1));
        assertThrows(InsufficientFundsException.class, () -> brendan.withdraw(100000));
    }

    @Test
    void depositForCheckingAndSavingAccountTest() {
        //deposit for CheckingAccount
        Account brendan = new CheckingAccount(500, "001");
        assertEquals(500, brendan.checkAccountBalance());

        brendan.deposit(10);
        assertEquals(510, brendan.checkAccountBalance());

        brendan.deposit(0.01);
        assertEquals(510.01, brendan.checkAccountBalance());

        //deposit for SavingAccount
        Account warren = new SavingAccount(500, "002", 0.05, 100);
        assertEquals(500, warren.checkAccountBalance());

        warren.deposit(10);
        assertEquals(510, warren.checkAccountBalance());

        warren.deposit(0.01);
        assertEquals(510.01, warren.checkAccountBalance());
    }

    @Test
    void transferTest() throws IllegalAccessException, InsufficientFundsException {
        Account brendanChecking = new CheckingAccount(5000, "001C");
        Account brendanSaving = new SavingAccount(2500, "001S", 0.03, 3600);

        Account warrenChecking = new CheckingAccount(3000, "002C");
        Account warrenSaving = new SavingAccount(7500, "002S", 0.06, 5000);
        
        //Checking to Checking
        assertEquals(5000, brendanChecking.checkAccountBalance());
        assertEquals(3000, warrenChecking.checkAccountBalance());

        brendanChecking.transfer(2500, warrenChecking);
        assertEquals(2500, brendanChecking.checkAccountBalance());
        assertEquals(5500, warrenChecking.checkAccountBalance());

        //Checking to Saving
        assertEquals(2500, brendanChecking.checkAccountBalance());
        assertEquals(2500, brendanSaving.checkAccountBalance());

        brendanChecking.transfer(500, brendanSaving);
        assertEquals(2000, brendanChecking.checkAccountBalance());
        assertEquals(3000, brendanSaving.checkAccountBalance());

        //Saving to Checking
        assertEquals(2000, brendanChecking.checkAccountBalance());
        assertEquals(3000, brendanSaving.checkAccountBalance());

        brendanSaving.transfer(500, brendanChecking);
        assertEquals(2500, brendanChecking.checkAccountBalance());
        assertEquals(2500, brendanSaving.checkAccountBalance());

        //Saving to Saving
       assertEquals(2500, brendanSaving.checkAccountBalance());
       assertEquals(7500, warrenSaving.checkAccountBalance());

       brendanSaving.transfer(2000, warrenSaving);
       assertEquals(500, brendanSaving.checkAccountBalance());
       assertEquals(9500, warrenSaving.checkAccountBalance());
    }

    @Test
    void addTest() {
        assertEquals(0, Account.add(0, 0));
        assertEquals(1, Account.add(1, 0));
        assertEquals(1, Account.add(0, 1));
        assertEquals(300, Account.add(100, 200));
    }
 }
package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void constructorAndCheckAccountBalanceTest() {
        // check CheckingAccount constructor
        Account brendan = new CheckingAccount(50, 001);
        assertEquals(50, brendan.checkAccountBalance());

        Account warren = new CheckingAccount(0.01, 002);
        assertEquals(0.01, warren.checkAccountBalance());
        

        // check SavingAccount constructor
        Account blosom = new SavingAccount(100, 003, 0.06, 1000);
        assertEquals(100, blosom.checkAccountBalance());

        Account yennefer = new SavingAccount(75, 004, 0.06, 1000);
        assertEquals(75, yennefer.checkAccountBalance());

        // check throws when initializing the constructor
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(-1, 001));
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(5.003, 001));
    }

    @Test
    void withdrawForCheckingAccountTest() throws InsufficientFundsException {
        Account brendan = new CheckingAccount(100, 001);
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
        Account brendan = new SavingAccount(10000, 001, 0.04, 1000);
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
        // deposit for CheckingAccount
        Account brendan = new CheckingAccount(500, 001);
        assertEquals(500, brendan.checkAccountBalance());

        brendan.deposit(10);
        assertEquals(510, brendan.checkAccountBalance());

        brendan.deposit(0.01);
        assertEquals(510.01, brendan.checkAccountBalance());

        // deposit for SavingAccount
        Account warren = new SavingAccount(500, 002, 0.05, 100);
        assertEquals(500, warren.checkAccountBalance());

        warren.deposit(10);
        assertEquals(510, warren.checkAccountBalance());

        warren.deposit(0.01);
        assertEquals(510.01, warren.checkAccountBalance());
    }

    @Test
    void transferTest() throws IllegalAccessException, InsufficientFundsException {
        Account brendanChecking = new CheckingAccount(5000, 001);
        Account brendanSaving = new SavingAccount(2500, 001, 0.03, 3600);

        Account warrenChecking = new CheckingAccount(3000, 002);
        Account warrenSaving = new SavingAccount(7500, 002, 0.06, 5000);

        // Checking to Checking
        assertEquals(5000, brendanChecking.checkAccountBalance());
        assertEquals(3000, warrenChecking.checkAccountBalance());

        brendanChecking.transfer(2500, warrenChecking);
        assertEquals(2500, brendanChecking.checkAccountBalance());
        assertEquals(5500, warrenChecking.checkAccountBalance());

        // Checking to Saving
        assertEquals(2500, brendanChecking.checkAccountBalance());
        assertEquals(2500, brendanSaving.checkAccountBalance());

        brendanChecking.transfer(500, brendanSaving);
        assertEquals(2000, brendanChecking.checkAccountBalance());
        assertEquals(3000, brendanSaving.checkAccountBalance());

        // Saving to Checking
        assertEquals(2000, brendanChecking.checkAccountBalance());
        assertEquals(3000, brendanSaving.checkAccountBalance());

        brendanSaving.transfer(500, brendanChecking);
        assertEquals(2500, brendanChecking.checkAccountBalance());
        assertEquals(2500, brendanSaving.checkAccountBalance());

        // Saving to Saving
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

    @Test
    void addAccountTest() {
        Customer customer = new Customer("Brendan", 00001, "password");
        Account account1 = new Account(1000, 000001);
        Account account2 = new Account(1000, 000002);
        customer.addAccount(account1);
        assertEquals(1, customer.getAccounts().size());
        customer.addAccount(account2);
        assertEquals(2, customer.getAccounts().size());
        Account listAccount1 = customer.getAccounts().get(0);
        assertEquals(listAccount1.checkAccountBalance(), 1000);
    }

    @Test
    void removeAccountTest() {
        Customer customer = new Customer("Brendan", 00001, "password");
        Account account1 = new Account(1000, 000001);
        Account account2 = new Account(1000, 000002);
        customer.addAccount(account1);
        customer.addAccount(account2);
        assertEquals(2, customer.getAccounts().size());
        customer.removeAccount(customer.getAccounts().get(0));
        assertEquals(1, customer.getAccounts().size());
        customer.removeAccount(customer.getAccounts().get(0));
        assertEquals(0, customer.getAccounts().size());
    }

    @Test
    void checkAccountHistory() throws InsufficientFundsException {
        //checkAccountHistory for CheckingAccount
        Account brendan = new CheckingAccount(300, 001);
        assertEquals(2, brendan.checkAccountHistory().size()); //the history list contains two lists, which are deposits and withdrawals so the size is 2
        assertEquals(0,  brendan.checkAccountHistory().get(0).size()); //deposit list is empty; therefore, the size is 0
        assertEquals(0, brendan.checkAccountHistory().get(1).size()); //withdrawal list is empty; therefore, the size is 0

        brendan.deposit(500);
        assertEquals(1, brendan.checkAccountHistory().get(0).size());
        assertEquals(500, brendan.checkAccountHistory().get(0).get(0));

        brendan.deposit(1000);
        assertEquals(2, brendan.checkAccountHistory().get(0).size());
        assertEquals(1000, brendan.checkAccountHistory().get(0).get(1));

        brendan.withdraw(300);
        assertEquals(1, brendan.checkAccountHistory().get(1).size());
        assertEquals(300, brendan.checkAccountHistory().get(1).get(0));

        brendan.withdraw(700);
        assertEquals(2, brendan.checkAccountHistory().get(1).size());
        assertEquals(700, brendan.checkAccountHistory().get(1).get(1));
        
        //checkAccountHistory for SavingAccount
        Account warren = new SavingAccount(500, 002, 0.05, 1000);
        assertEquals(2, warren.checkAccountHistory().size()); //the history list contains two lists, which are deposits and withdrawals so the size is 2
        assertEquals(0,  warren.checkAccountHistory().get(0).size()); //deposit list is empty; therefore, the size is 0
        assertEquals(0, warren.checkAccountHistory().get(1).size()); //withdrawal list is empty; therefore, the size is 0

        warren.deposit(500);
        assertEquals(1, warren.checkAccountHistory().get(0).size());
        assertEquals(500, warren.checkAccountHistory().get(0).get(0));

        warren.deposit(1000);
        assertEquals(2, warren.checkAccountHistory().get(0).size());
        assertEquals(1000, warren.checkAccountHistory().get(0).get(1));

        warren.withdraw(300);
        assertEquals(1, warren.checkAccountHistory().get(1).size());
        assertEquals(300, warren.checkAccountHistory().get(1).get(0));

        warren.withdraw(700);
        assertEquals(2, warren.checkAccountHistory().get(1).size());
        assertEquals(700, warren.checkAccountHistory().get(1).get(1));
    }
}

package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    void testFrozenAccount() throws InsufficientFundsException {
        Admin admin = new Admin("frog", "frogpassword");
        Account account = new CheckingAccount(500, 1);
        assertFalse(account.isFrozen());
        admin.freezeAccount(account);
        assertTrue(account.isFrozen());

        // expecting balance to remain unchanged due to account being frozen
        double frozenBalance = account.checkAccountBalance();
        account.withdraw(100);
        assertEquals(500, account.checkAccountBalance());
    }

    @Test
    void testCustomerSumBalance() throws InsufficientFundsException {
        Admin admin = new Admin("frog", "frogpassword");
        Customer customer = new Customer("Brendan", 0, "brendanpassword");
        customer.addAccount(new Account(100, 1));
        customer.addAccount(new Account(150, 2));
        customer.addAccount(new Account(50, 3));
        assertEquals(300, admin.getCustomerSum(customer));
        customer.getAccounts().get(0).withdraw(100);
        assertEquals(200, admin.getCustomerSum(customer));
    }
}

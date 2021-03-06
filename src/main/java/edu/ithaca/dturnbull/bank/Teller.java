package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;
import java.util.List;

public class Teller {
    private List<Customer> customerList;

    public Teller(CentralBank centralBank) {
        customerList = centralBank.getCustomerList();
    }

    protected void transfer(String fromCustomer, String toCustomer, Boolean fromAccountSavingOrNot, Boolean toAccountSavingOrNot, double amount) throws IllegalAccessException, InsufficientFundsException {
        //ArrayList<Account> fromAccounts = fromCustomer.getAccounts();
        //ArrayList<Account> toAccounts = toCustomer.getAccounts();
        //if (fromAccounts.contains(fromAccount) && toAccounts.contains(toAccount) ) {
        //    fromAccount.transfer(amount, toAccount);
        //}

        for (Customer customer: customerList) {
            if (customer.getName() == fromCustomer) {
                for (Account fromAccount: customer.accounts) {
                    if (fromAccount.saving == fromAccountSavingOrNot) {
                        fromAccount.withdraw(amount);
                    }
                }
            }
            if (customer.getName() == toCustomer) {
                for (Account toAccount: customer.accounts) {
                    if (toAccount.saving == fromAccountSavingOrNot) {
                        toAccount.deposit(amount);
                    }
                }
            }
        }
    }

    protected void deposit(String customerName, Boolean savingOrNot, double amount) throws InsufficientFundsException {
        //ArrayList<Account> accounts = customer.getAccounts();
        //if (accounts.contains(account)) {
        //    account.deposit(amount);
        //}
        for (Customer customer: customerList) {
            if (customer.getName() == customerName) {
                List<Account> accounts = customer.getAccounts();
                for (Account account: accounts) {
                    if (account.saving == savingOrNot) {
                        account.deposit(amount);
                    }
                }
            }
        }
    }

    protected void withdraw(String customerName, Boolean savingOrNot, double amount) throws InsufficientFundsException {
        //ArrayList<Account> accounts = customer.getAccounts();
        //if (accounts.contains(account)) {
        //    account.withdraw(amount);
        //}
        for (Customer customer: customerList) {
            if (customer.getName() == customerName) {
                List<Account> accounts = customer.getAccounts();
                for (Account account: accounts) {
                    if (account.saving == savingOrNot) {
                        account.withdraw(amount);
                    }
                }
            }
        }
    }

    protected double checkAccountBalance(String customerName, Boolean savingOrNot) throws InsufficientFundsException {
        //ArrayList<Account> accounts = customer.getAccounts();
        //if (accounts.contains(account)) {
        //    return account.checkAccountBalance();
        //} 
        //return -1;
        //}
        for (Customer customer: customerList) {
            if (customer.getName() == customerName) {
                List<Account> accounts = customer.getAccounts();
                for (Account account: accounts) {
                    if (account.saving == savingOrNot) {
                        return account.checkAccountBalance();
                    }
                }
            }
        }
        return -1;
    }
}

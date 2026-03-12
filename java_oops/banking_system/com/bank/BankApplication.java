package com.bank;

import com.bank.customers.Customer;
import com.bank.accounts.SavingsAccount;
import com.bank.loans.Loan;

import static com.bank.util.BankUtil.generateAccountNumber;
import static com.bank.util.BankUtil.validateMinimumBalance;

public class BankApplication {
    public static void main(String[] args) {
        System.out.println("--- Bank Application Started ---");

        String newAccountNumber = generateAccountNumber();
        double initialDeposit = 1500.0;

        System.out.println("Checking minimum balance for deposit " + initialDeposit + ": " +
                (validateMinimumBalance(initialDeposit) ? "Valid" : "Invalid"));

        SavingsAccount sa = new SavingsAccount(newAccountNumber, initialDeposit, 4.5);
        Customer customer = new Customer("CUST123", "Alice Smith");

        customer.linkAccount(sa);

        sa.deposit(500.0);
        sa.withdraw(300.0);
        sa.calculateInterest();

        Loan loan = new Loan(50000.0);
        loan.calculateEMI(sa);

        System.out.println("--- Bank Application Finished ---");
    }
}

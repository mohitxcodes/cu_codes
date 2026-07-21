package com.bank.loans;

import com.bank.accounts.Account;

public class Loan {
    private double loanAmount;

    public Loan(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void calculateEMI(Account account) {
        System.out.println("--- EMI Calculation ---");
        System.out.println("Loan Amount: " + loanAmount);

        // Demonstrating access control behavior
        System.out.println("Accessible - Account Number (public): " + account.accountNumber);

        // Uncommenting these would result in compilation errors:
        // System.out.println("Inaccessible - Balance (protected): " + account.balance);
        // System.out.println("Inaccessible - defaultAccessMember (package-private): " +
        // account.defaultAccessMember);

        System.out.println("Accessible - Balance via getter: " + account.getBalance());

        double emi = (loanAmount * 1.05) / 12; // Simple 5% interest over 1 year
        System.out.println("Calculated Monthly EMI: " + String.format("%.2f", emi));
    }
}

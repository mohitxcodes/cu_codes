package com.bank.accounts;

public class Account {
    public String accountNumber;
    protected double balance;
    double defaultAccessMember; // package-private

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Withdrawal failed. Check balance or amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

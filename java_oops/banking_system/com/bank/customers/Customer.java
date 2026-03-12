package com.bank.customers;

public class Customer {
    private String customerId;
    private String name;
    private com.bank.accounts.Account account; // FQCN usage

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void linkAccount(com.bank.accounts.Account account) {
        this.account = account;
        System.out.println("Account " + account.accountNumber + " linked to Customer " + name);
    }

    public com.bank.accounts.Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}

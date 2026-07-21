package com.bank.util;

public class BankUtil {
    public static String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

    public static boolean validateMinimumBalance(double balance) {
        return balance >= 1000.0;
    }
}

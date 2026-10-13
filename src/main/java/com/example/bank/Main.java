package com.example.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Asha", 1000);

        account.deposit(250);
        account.withdraw(100);

        try {
            account.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage());
        }

        System.out.println("Owner:   " + account.getOwner());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("History:");
        account.getHistory().forEach(h -> System.out.println("  - " + h));
    }
}

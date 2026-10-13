package com.example.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void depositIncreasesBalance() {
        BankAccount acc = new BankAccount("Test", 100);
        acc.deposit(50);
        assertEquals(150, acc.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        BankAccount acc = new BankAccount("Test", 100);
        acc.withdraw(40);
        assertEquals(60, acc.getBalance());
    }

    @Test
    void overdrawThrows() {
        BankAccount acc = new BankAccount("Test", 100);
        assertThrows(InsufficientFundsException.class, () -> acc.withdraw(500));
    }

    @Test
    void negativeDepositRejected() {
        BankAccount acc = new BankAccount("Test", 100);
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-5));
    }

    @Test
    void historyIsRecorded() {
        BankAccount acc = new BankAccount("Test", 100);
        acc.deposit(10);
        assertEquals(2, acc.getHistory().size());
    }
}

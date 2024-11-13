package org.example;

public class Acount {
    public static class Account {
        private double balance;
        public Account(double initialBalance) {
            this.balance = initialBalance;
        }
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public double checkBalance() {
            return balance;
        }
    }
}

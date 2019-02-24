package com.example.cucumberpractice.models;

public class Account{
    private Money balance = new Money();
    public void deposit(Money amount){
        balance.add(amount);
    }

    public Money getBalance() {
        return balance;
    }
}


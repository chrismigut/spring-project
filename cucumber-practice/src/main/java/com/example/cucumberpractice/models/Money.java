package com.example.cucumberpractice.models;

public class Money{
    private int dollars, cents = 0;
    public Money(){}
    public Money(int dollars, int cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public void add(Money amount) {
        this.dollars = amount.getDollars();
        this.cents = amount.getCents();
    }

    public int getCents() {
        return this.cents;
    }

    public int getDollars() {
        return this.dollars;
    }
}

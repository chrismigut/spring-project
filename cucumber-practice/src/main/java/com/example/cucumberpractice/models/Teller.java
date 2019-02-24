package com.example.cucumberpractice.models;

public class Teller {

    private CashSlot cashSlot;

    public Teller(CashSlot cashSlot){
        this.cashSlot = cashSlot;
    }

    public void withdrawFromAccount(Account myAccount, int dollars) {
        cashSlot.dispense(dollars);
    }
}

package com.example.cucumberpractice.bdd.support;

import com.example.cucumberpractice.models.Account;
import com.example.cucumberpractice.models.CashSlot;
import com.example.cucumberpractice.models.Teller;

public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new Teller(getCashSlot());
        }
        return teller;
    }
}

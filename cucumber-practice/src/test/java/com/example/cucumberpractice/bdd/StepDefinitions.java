package com.example.cucumberpractice.bdd;

import com.example.cucumberpractice.bdd.transforms.MoneyConverter;
import com.example.cucumberpractice.models.Money;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private final KnowsTheDomain helper;

    class Account{
        private Money balance = new Money();
        public void deposit(Money amount){
            balance.add(amount);
        }

        public Money getBalance() {
            return balance;
        }
    }

    private class Teller {

        private CashSlot cashSlot;

        public Teller(CashSlot cashSlot){
            this.cashSlot = cashSlot;
        }

        public void withdrawFromAccount(Account myAccount, int dollars) {
            cashSlot.dispense(dollars);
        }
    }
    private class CashSlot {
        private int contents;
        public int getContents() {
            return contents;
        }

        public void dispense(int dollars) {
            contents = dollars;
        }
    }

    private class KnowsTheDomain {
        private Account myAccount;
        private CashSlot cashSlot;
        private Teller teller;

        public Account getMyAccount(){
            if (myAccount == null){
                myAccount = new Account();
            }
            return myAccount;
        }

        public CashSlot getCashSlot() {
            if (cashSlot == null){
                cashSlot = new CashSlot();
            }
            return cashSlot;
        }

        public Teller getTeller(){
            if (teller == null){
                teller = new Teller(getCashSlot());
            }
            return teller;
        }
    }

    StepDefinitions(){
        helper = new KnowsTheDomain();
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        helper.getMyAccount().deposit(amount);

        Assert.assertEquals("Incorrect account balance - ", amount.getDollars(), helper.getMyAccount().getBalance().getDollars());
    }

    @When("^I withdraw \\$(\\d+)$")
    public void withdraw(int dollars) throws Throwable {
        helper.getTeller().withdrawFromAccount(helper.getMyAccount(), dollars);

    }

    @Then("^\\$(\\d+) should be be dispensed$")
    public void $_should_be_be_dispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars, helper.getCashSlot().getContents());
    }



}

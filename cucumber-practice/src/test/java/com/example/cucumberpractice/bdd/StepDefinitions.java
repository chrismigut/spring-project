package com.example.cucumberpractice.bdd;

import com.example.cucumberpractice.bdd.support.KnowsTheDomain;
import com.example.cucumberpractice.bdd.transforms.MoneyConverter;
import com.example.cucumberpractice.models.Account;
import com.example.cucumberpractice.models.CashSlot;
import com.example.cucumberpractice.models.Money;
import com.example.cucumberpractice.models.Teller;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    private final KnowsTheDomain helper;

    StepDefinitions() {
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

package com.example.cucumberpractice.bdd.transforms;

import com.example.cucumberpractice.models.Money;
import cucumber.api.Transformer;

/*
page 126
Convert a string value from cucumber stepDef to that of an object
*/

public class MoneyConverter extends Transformer<Money> {

    @Override
    public Money transform(String amount) {
        String[] numbers = amount.substring(1).split("\\.");
        int dollars = Integer.parseInt(numbers[0]);
        int cents = Integer.parseInt(numbers[1]);

        return new Money(dollars, cents);
    }
}

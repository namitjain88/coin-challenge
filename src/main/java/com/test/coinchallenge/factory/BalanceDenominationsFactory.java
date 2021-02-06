package com.test.coinchallenge.factory;

import com.test.coinchallenge.enums.Country;
import com.test.coinchallenge.exception.InvalidValueException;
import com.test.coinchallenge.impl.IndiaBalanceDenominations;
import com.test.coinchallenge.impl.UsaBalanceDenominations;

public class BalanceDenominationsFactory {
    public static BalanceDenominations createBalanceDenomination(Country country) {
        switch (country) {
            case USA:
                return new UsaBalanceDenominations();
            case INDIA:
                return new IndiaBalanceDenominations();
            //case EUROPE: return new EuropeBalanceDenominations();
            default:
                throw new InvalidValueException("Unexpected value: " + country);
        }
    }
}

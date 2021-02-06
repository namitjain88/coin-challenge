package com.test.coinchallenge;

import com.test.coinchallenge.enums.Country;
import com.test.coinchallenge.factory.BalanceDenominations;
import com.test.coinchallenge.factory.BalanceDenominationsFactory;

import static com.test.coinchallenge.utilities.BalanceChangePrinter.printUsCurrency;

public class BalanceDenominationsMain {
    public static void main(String[] args) {
        BalanceDenominations balanceChange = BalanceDenominationsFactory.createBalanceDenomination(Country.USA);
        printUsCurrency(balanceChange.findBalanceDenominations(1063));
        //printIndiaCurrency(balanceChange.findBalanceDenominations(10824));
    }
}

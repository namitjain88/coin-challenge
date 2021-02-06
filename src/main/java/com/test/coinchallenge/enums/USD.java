package com.test.coinchallenge.enums;

public enum USD implements CurrencyMarker{
    DOLLAR_100(10000),
    DOLLAR_50(5000),
    DOLLAR_20(2000),
    DOLLAR_10(1000),
    DOLLAR_5(500),
    DOLLAR(100),
    QUARTER(25),
    DIME(10),
    NICKLE(5),
    PENNY(1);

    int value;

    USD(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

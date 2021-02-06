package com.test.coinchallenge.enums;

public enum INR implements CurrencyMarker{
    RUPEE_10(1000),
    RUPEE_5(500),
    RUPEE_2(200),
    PAISE_50(50),
    PAISE_25(25),
    PAISE_10(10),
    PAISA(1);

    int value;

    INR(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

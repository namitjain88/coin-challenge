package com.test.coinchallenge.factory;

import com.test.coinchallenge.enums.CurrencyMarker;
import com.test.coinchallenge.exception.InvalidValueException;

import java.util.Map;

public abstract class BalanceDenominations {
    public abstract Map<CurrencyMarker, Integer> findBalanceDenominations(int balance)
            throws InvalidValueException;
}

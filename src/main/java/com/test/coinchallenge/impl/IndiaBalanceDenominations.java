package com.test.coinchallenge.impl;

import com.test.coinchallenge.enums.CurrencyMarker;
import com.test.coinchallenge.enums.INR;
import com.test.coinchallenge.exception.InvalidValueException;
import com.test.coinchallenge.factory.BalanceDenominations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IndiaBalanceDenominations extends BalanceDenominations {
    @Override
    public Map<CurrencyMarker, Integer> findBalanceDenominations(int balance) throws InvalidValueException {
        if (balance < 1) throw new InvalidValueException("balance should be greater than 0");

        Map<CurrencyMarker, Integer> dMap = new LinkedHashMap<>(INR.values().length);
        for (INR c : INR.values()) {
            if (balance != 0 && balance >= c.getValue()) {
                dMap.put(c, balance / c.getValue());
                balance = balance % c.getValue();
            }
        }
        return dMap;
    }

    public List<CurrencyMarker> getSupportedDenominations() {
        return Arrays.asList(INR.values());
    }
}

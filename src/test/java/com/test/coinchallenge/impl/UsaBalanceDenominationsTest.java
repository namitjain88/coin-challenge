package com.test.coinchallenge.impl;

import com.test.coinchallenge.enums.Country;
import com.test.coinchallenge.enums.USD;
import com.test.coinchallenge.exception.InvalidValueException;
import com.test.coinchallenge.factory.BalanceDenominations;
import com.test.coinchallenge.factory.BalanceDenominationsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UsaBalanceDenominationsTest {
    private BalanceDenominations bd;

    @BeforeEach
    public void init() {
        bd = BalanceDenominationsFactory.createBalanceDenomination(Country.USA);
    }

    @ParameterizedTest(name = "{0} should throw InvalidValueException")
    @DisplayName("Balance of ")
    @ValueSource(ints = {0, -1})
    public void testInvalidValueException(int balance) {
        assertThrows(InvalidValueException.class, () -> bd.findBalanceDenominations(balance));
    }

    @ParameterizedTest(name = "{1} should be returned as {2} ")
    @DisplayName("Balance of ")
    @MethodSource("fetchTestInputData")
    public void testFindBalanceDenominations(Map<USD, Integer> expectedDenMap, int balance, String testMsg) {
        assertEquals(expectedDenMap, bd.findBalanceDenominations(balance), testMsg);
    }

    private static Stream<Arguments> fetchTestInputData() {
        return Stream.of(
                Arguments.of(initExpectedDenMap(new USD[]{USD.DOLLAR, USD.QUARTER, USD.DIME, USD.PENNY}, new int[]{2, 3, 1, 2}), 287, "2 Dollars, 3 Quarters, 1 Dime, 2 Pennies"),
                Arguments.of(initExpectedDenMap(new USD[]{USD.DOLLAR, USD.QUARTER, USD.DIME, USD.PENNY}, new int[]{1, 1, 1, 1}), 136, "1 Dollar, 3 Quarters, 1 Dime, 2 Pennies"),
                Arguments.of(initExpectedDenMap(new USD[]{USD.DIME}, new int[]{1}), 10, "1 Dime"),
                Arguments.of(initExpectedDenMap(new USD[]{USD.DOLLAR, USD.QUARTER, USD.DIME, USD.PENNY}, new int[]{4, 3, 2, 4}), 499, "4 Dollars, 3 Quarters, 2 Dimes, 4 Pennies")
        );
    }

    private static Map<USD, Integer> initExpectedDenMap(USD[] denominations, int[] values) {
        Map<USD, Integer> expectedDenMap = new HashMap<>();
        for (int i = 0; i < denominations.length; i++) {
            expectedDenMap.put(denominations[i], values[i]);
        }
        return expectedDenMap;
    }
}

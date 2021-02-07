package com.test.coinchallenge.impl;

import com.test.coinchallenge.enums.Country;
import com.test.coinchallenge.enums.CurrencyMarker;
import com.test.coinchallenge.enums.INR;
import com.test.coinchallenge.exception.InvalidValueException;
import com.test.coinchallenge.factory.BalanceDenominations;
import com.test.coinchallenge.factory.BalanceDenominationsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IndiaBalanceDenominationsTest {
    private BalanceDenominations bd;

    @BeforeEach
    public void init() {
        bd = BalanceDenominationsFactory.createBalanceDenomination(Country.INDIA);
    }

    @ParameterizedTest(name = "balance as {0} should throw InvalidValueException")
    @DisplayName("Testing invalid input balance value")
    @ValueSource(ints = {0, -1})
    public void testInvalidValueException(int balance) {
        assertThrows(
                InvalidValueException.class,
                () -> bd.findBalanceDenominations(balance),
                () -> "balance of " + balance + " should throw InvalidValueException.");
    }

    @ParameterizedTest(name = "balance of {1} should be returned as {2} ")
    @DisplayName("Testing balance denominations")
    @MethodSource("fetchTestInputData")
    public void testFindBalanceDenominations(Map<INR, Integer> expectedDenMap, int balance, String testMsg) {
        assertEquals(
                expectedDenMap,
                bd.findBalanceDenominations(balance),
                () -> "balance of " + balance + " should be returned as " + testMsg);
    }

    @Test
    @DisplayName("Testing supported denominations ")
    public void testGetSupportedDenominations() {
        List<CurrencyMarker> expected = Arrays.asList(INR.values());
        List<CurrencyMarker> actual = bd.getSupportedDenominations();
        assertIterableEquals(expected, actual, () -> "should be " + expected);
    }

    private static Stream<Arguments> fetchTestInputData() {
        return Stream.of(
                Arguments.of(initExpectedDenMap(
                        new INR[]{INR.RUPEE_2, INR.PAISE_50, INR.PAISE_25, INR.PAISE_10, INR.PAISA},
                        new int[]{1, 1, 1, 1, 2}),
                        287,
                        "1 two rupee coin, 1 fifty paise coin, 1 twenty five paise coin, 1 ten paise coin, 2 one paise coins"),
                Arguments.of(initExpectedDenMap(
                        new INR[]{INR.PAISE_50, INR.PAISE_25, INR.PAISE_10, INR.PAISA},
                        new int[]{2, 1, 1, 1}),
                        136,
                        "2 fifty paise coins, 1 twenty five paise coin, 1 ten paise coin, 1 one paise coin"),
                Arguments.of(initExpectedDenMap(
                        new INR[]{INR.PAISE_10},
                        new int[]{1}),
                        10,
                        "1 ten paise coin"),
                Arguments.of(initExpectedDenMap(
                        new INR[]{INR.RUPEE_2, INR.PAISE_50, INR.PAISE_25, INR.PAISE_10, INR.PAISA},
                        new int[]{2, 1, 1, 2, 4}),
                        499,
                        "2 two rupee coins, 1 fifty paise coin, 1 twenty five paise coin, 2 ten paise coins, 4 one paise coins"),
                Arguments.of(initExpectedDenMap(
                        new INR[]{INR.RUPEE_10, INR.RUPEE_5, INR.RUPEE_2, INR.PAISE_50, INR.PAISE_10, INR.PAISA},
                        new int[]{10, 1, 1, 2, 2, 4}),
                        10824,
                        "10 ten rupee notes, 1 five rupee note, 1 two rupee coin, 2 fifty paise coins, 2 ten paise coins, 4 one paise coins")
        );
    }

    private static Map<INR, Integer> initExpectedDenMap(INR[] denominations, int[] values) {
        Map<INR, Integer> expectedDenMap = new HashMap<>();
        for (int i = 0; i < denominations.length; i++) {
            expectedDenMap.put(denominations[i], values[i]);
        }
        return expectedDenMap;
    }
}

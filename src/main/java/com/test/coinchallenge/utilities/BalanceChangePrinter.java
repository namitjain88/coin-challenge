package com.test.coinchallenge.utilities;

import com.test.coinchallenge.enums.CurrencyMarker;
import com.test.coinchallenge.enums.INR;
import com.test.coinchallenge.enums.USD;

import java.util.Map;

public class BalanceChangePrinter {
    public static void printUsCurrency(Map<CurrencyMarker, Integer> bdMap) {

        StringBuilder resultStr = new StringBuilder();
        for (CurrencyMarker currency : bdMap.keySet()) {
            USD c = (USD) currency;
            Integer value = bdMap.get(c);
            switch (c) {
                case DOLLAR_50:
                    resultStr.append(value).append(value > 1 ? " Fifty Dollars, " : " Fifty Dollar, ");
                    break;
                case DOLLAR_20:
                    resultStr.append(value).append(value > 1 ? " Twenty Dollars, " : " Twenty Dollar, ");
                    break;
                case DOLLAR_10:
                    resultStr.append(value).append(value > 1 ? " Ten Dollars, " : " Ten Dollar, ");
                    break;
                case DOLLAR_5:
                    resultStr.append(value).append(value > 1 ? " Five Dollars, " : " Five Dollar, ");
                    break;
                case DOLLAR:
                    resultStr.append(value).append(value > 1 ? " One Dollars, " : " One Dollar, ");
                    break;
                case QUARTER:
                    resultStr.append(value).append(value > 1 ? " Quarters, " : " Quarter, ");
                    break;
                case DIME:
                    resultStr.append(value).append(value > 1 ? " Dimes, " : " Dime, ");
                    break;
                case PENNY:
                    resultStr.append(value).append(value > 1 ? " Pennies, " : " Penny, ");
                    break;
                default:
            }
        }
        System.out.println(resultStr.substring(0, resultStr.lastIndexOf(",")));
    }

    public static void printIndiaCurrency(Map<CurrencyMarker, Integer> dMap) {
        StringBuilder resultStr = new StringBuilder();
        for (CurrencyMarker currency : dMap.keySet()) {
            INR c = (INR) currency;
            Integer value = dMap.get(c);
            switch (c) {
                case RUPEE_10:
                    resultStr.append(value).append(value > 1 ? " ten rupee notes, " : " ten rupee note, ");
                    break;
                case RUPEE_5:
                    resultStr.append(value).append(value > 1 ? " five rupee notes, " : " five rupee note, ");
                    break;
                case RUPEE_2:
                    resultStr.append(value).append(value > 1 ? " two rupee coins, " : " two rupee coin, ");
                    break;
                case PAISE_50:
                    resultStr.append(value).append(value > 1 ? " fifty paise coins, " : " fifty paise coin, ");
                    break;
                case PAISE_25:
                    resultStr.append(value).append(value > 1 ? " twenty five paise coins, " : " twenty five paise coin, ");
                    break;
                case PAISE_10:
                    resultStr.append(value).append(value > 1 ? " ten paise coins, " : " ten paise coin, ");
                    break;
                case PAISA:
                    resultStr.append(value).append(value > 1 ? " one paise coins, " : " one paise coin, ");
                    break;
            }
        }
        System.out.println(resultStr.substring(0, resultStr.lastIndexOf(",")));
    }

    /*private static void print(Map<CurrencyMarker, Integer> dMap) {

        for (CurrencyMarker currency : dMap.keySet()) {
            USD c = (USD) currency;
            switch (c) {
                case DOLLAR_100:
                    System.out.println(dMap.get(USD.DOLLAR_100) + " " + USD.DOLLAR_100);
                    break;
                case DOLLAR_50:
                    System.out.println(dMap.get(USD.DOLLAR_50) + " " + USD.DOLLAR_50);
                    break;
                case DOLLAR_20:
                    System.out.println(dMap.get(USD.DOLLAR_20) + " " + USD.DOLLAR_20);
                    break;
                case DOLLAR_10:
                    System.out.println(dMap.get(USD.DOLLAR_10) + " " + USD.DOLLAR_10);
                    break;
                case DOLLAR_5:
                    System.out.println(dMap.get(USD.DOLLAR_5) + " " + USD.DOLLAR_5);
                    break;
                case DOLLAR:
                    System.out.println(dMap.get(USD.DOLLAR) + " " + USD.DOLLAR);
                    break;
                case QUARTER:
                    System.out.println(dMap.get(USD.QUARTER) + " " + USD.QUARTER);
                    break;
                case DIME:
                    System.out.println(dMap.get(USD.DIME) + " " + USD.DIME);
                    break;
                case NICKLE:
                    System.out.println(dMap.get(USD.NICKLE) + " " + USD.NICKLE);
                    break;
                case PENNY:
                    System.out.println(dMap.get(USD.PENNY) + " " + USD.PENNY);
                    break;
            }
        }
    }*/
}

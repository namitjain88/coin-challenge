package com.test.coinchallenge;

import com.test.coinchallenge.exception.InvalidValueException;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class CoinchallengeApplication {

    public static void main(String[] args) throws InvalidValueException {
        SpringApplication.run(CoinchallengeApplication.class, args);
        //findDenominations(9462);
    }

    /*private static void findDenominations(int balance) {
        BalanceDenominations bd = new BalanceDenominations();
        Map<Integer, Integer> bdMap = bd.findBalanceDenominations(balance,
                new int[]{1, 10, 25, 100, 500, 1000, 2000, 5000, 10000});
        print(bdMap);
    }*/

    /*private static void print(Map<Integer, Integer> bdMap) {
        Iterator<Integer> itr = bdMap.keySet().iterator();
        StringBuilder resultStr = new StringBuilder();
        while (itr.hasNext()) {
            Integer key = itr.next();
            Integer value = bdMap.get(key);
            switch (key) {
                case 1:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Pennies," : " Penny,");
                    break;
                case 10:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Dimes," : " Dime,");
                    break;
                case 25:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Quarters," : " Quarter,");
                    break;
                case 100:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " One Dollars," : " One Dollar,");
                    break;
                case 500:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Five Dollars," : " Five Dollar,");
                    break;
                case 1000:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Ten Dollars," : " Ten Dollar,");
                    break;
                case 2000:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Twenty Dollars," : " Twenty Dollar,");
                    break;
                case 5000:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Fifty Dollars," : " Fifty Dollar,");
                    break;
                case 10000:
                    if (value > 0)
                        resultStr.append(value).append(value > 1 ? " Hundred Dollars," : " Hundred Dollar,");
                    break;
                default:
            }
        }
        System.out.println(resultStr.substring(0, resultStr.lastIndexOf(",")));
    }*/

}

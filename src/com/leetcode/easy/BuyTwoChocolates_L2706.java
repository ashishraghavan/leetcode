package com.leetcode.easy;

import java.util.Arrays;

//prob # 2706 - buy two chocolates
public class BuyTwoChocolates_L2706 {
    public static void main(String[] args) {
        //9,72,36,26,65,84,83,96,81 | 95
        //3,2,3 | 3
        //1,2,2 | 3
        System.out.println(buyChoco(new int[]{9,72,36,26,65,84,83,96,81},33));
    }

    //9,72,36,26,65,84,83,96,81 | money = 95 -sort-> 9,26,36,65,72,81,83,84,96
    //sum = 0, for i in range (0,prices.length-1) if sum + prices[i] <= money? sum +=
    public static int buyChoco(int[] prices, int money) {
        int origAmt = money;
        Arrays.sort(prices);
        int cnt = 0,i=0;
        while(cnt++ < 2) {
            money -= prices[i++];
        }
        return money < 0 ? origAmt : money;
    }
}

package com.leetcode.medium.array_strings;

import java.util.Arrays;

//prob #1561 = max coins you can get
public class MaxCoinsYouCanGet_L1561 {
    public static void main(String[] args) {
        //9,8,7,6,5,1,2,3,4
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for(int i=piles.length/3;i<piles.length;i+=2) {
            sum += piles[i];
        }
        return sum;
    }
}

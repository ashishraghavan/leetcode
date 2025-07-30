package com.leetcode.easy;

import java.util.Arrays;

//prob # 2144 - minimum cost of buying candies with discount
public class MinimumCostOfBuyingCandiesWithDiscount_L2144 {
    public static void main(String[] args) {
        //6,5,7,9,2,2
        //1,2,3
        //5,5
        //38, 7, 46, 72, 95, 77, 66, 67, 61, 17
        //38, 7, 46, 72, 95, 77, 66, 67, 61, 17, 57, 95, 32, 98, 64, 77, 44, 56, 28, 91
        //38, 7, (46, 72, 95), (77, 66, 67), (61, 17, 57), (95, 32, 98), (64, 77, 44), (56, 28, 91) (n=20)
        System.out.println(minimumCost(new int[]{38, 7, 46, 72, 95, 77, 66, 67, 61, 17, 57, 95, 32, 98, 64, 77, 44, 56, 28, 91}));
    }

    //6,5,7,9,2,2 -> 2,2,5,6,7,9 || 9,7,6,5,2,2
    //7, (17, 38, 46), (61, 66, 67), (72, 77, 95) ->
    //cnt = cost.length/3, rem = cost.length%3
    // i in (0,cnt)
    public static int minimumCost(int[] cost) {
        int minCost = 0;
        if(cost.length <= 2) {
            for (int j : cost) {
                minCost += j;
            }
            return minCost;
        }
        Arrays.sort(cost);
        int cnt = cost.length/3, rem = cost.length % 3,j=cost.length-1;
        for(;cnt > 0;cnt--,j-=3) {
            minCost += (cost[j] + cost[j-1]);
        }
        if(rem != 0) {
            while(j>=0) {
                minCost += cost[j];
                j--;
            }
        }
        return minCost;
    }
}

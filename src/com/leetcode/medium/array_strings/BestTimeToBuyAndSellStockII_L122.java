package com.leetcode.medium.array_strings;

//TODO: check https://algo.monster/liteproblems/122 for detailed & intuitive solution
//prob #122 - best time to buy & sell stock II
public class BestTimeToBuyAndSellStockII_L122 {
    public static void main(String[] args) {
        //7,1,5,3,6,4
        //1,2,3,4,5
        //7,6,4,3,1
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    //7,1,5,3,6,4
    //it is given that we can hold at most one share of stock at any time.
    // So if we buy 1 stock on day 2, our max profit is either by selling on day 3 or day 5 - but not both!
    // b=1, s=5
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=0;i<=prices.length-2;i++) {
            if(i+1 < prices.length && prices[i+1] - prices[i] >= 0) {
                sum += (prices[i+1] - prices[i]);
            }
        }
        //System.out.println(sum);
        return sum;
    }
}

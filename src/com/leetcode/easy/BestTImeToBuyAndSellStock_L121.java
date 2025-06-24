package com.leetcode.easy;

//problem # 121 - best time to buy & sell stock
public class BestTImeToBuyAndSellStock_L121 {
    public static void main(String[] args) {
        //7,1,5,3,6,4
        //7,6,4,3,1
        //1,3,1,8,7,4
        //1,2
        //[]
        //1,1
        //2,1
        System.out.println(maxProfit(new int[]{1,3,1,8,7,4}));
    }

    //7,1,5,3,6,4
    //find i,j such that j >= i &&  p[j]-p[i] is max
    //sliding window? p.length < 2 ? return 0
    //track lowest till current index
    //i=0,j=1 if p[j] > p[i], low = i; max = math.max(p[j]-p[i],max)
    //max = Integer.MIN_VALUE, low = 0, i in (1:p.length-1) if p[i] < p[low] ? low = i; else max = math.max(p[i]-p[low],max)
    public static int maxProfit(int[] prices) {
        int low = 0, max = 0;
        if(prices.length < 2)return 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] < prices[low]) {
                low = i;
            } else {
                max = Math.max(prices[i]-prices[low],max);
            }
        }
        return max;
    }
}

package com.leetcode.medium.binary_search_on_answer;

//#1011
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        //3,2,2,4,1,4|3
        //1, 2, 3, 4, 5, 6, 7, 8, 9, 10|5
        //1, 2, 3, 1, 1|4 - N
        //10|1
        //1, 2, 3, 4, 5|1
        //1, 2, 3, 4, 5|5 - N
        //5, 5, 5, 5|2
        //5, 5, 5, 5, 5|2
        //1, 1, 1, 100, 1, 1|3
        int[] weights = new int[]{1, 2, 3, 1, 1};
        int days = 4;
        System.out.println(shipWithinDays(weights,days));
    }

    //3,2,2,4,1,4   3
    public static int shipWithinDays(int[] W, int D) {
        int totalWt = 0;
        int max = Integer.MIN_VALUE;
        for(int weight : W) {
            totalWt += weight;
            max = Math.max(max,weight);
        }
        //minimum possible ship capacity cannot be less than the heaviest weight
        int left = max;
        int right = totalWt;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(canLoad(W,mid,D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canLoad(int[] W,int expectedWeight,int days) {
        int totalDays = 0;
        int currWeight = 0;
        for(int weight : W) {
            if(currWeight+weight > expectedWeight) {
                totalDays++;
                currWeight = 0;
            }
            currWeight += weight;
        }
        return totalDays <= days;
    }
}

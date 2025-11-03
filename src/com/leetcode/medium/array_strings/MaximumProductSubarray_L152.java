package com.leetcode.medium.array_strings;

//TODO: definitely [revise], deals with prefix & suffix sum
// check https://www.youtube.com/watch?v=hnswaLJvr6g for intuitive solution
//prob #152 - maximum product subarray
public class MaximumProductSubarray_L152 {
    public static void main(String[] args) {
        //-2,-10,9,-8,-6,-9,5,2
        //-1,-10,-9,-9,1,-6,8,7
        //-2,-10,9,-8,-6
        //-2,0,-1
        //1,0,-1,2,3,-5,-2
        System.out.println(maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
    }

    //-2,-10,9,-8,-6,-9,5,2
    //-2,20,180,-1440,8640,-77760,388800,777600
    //can't sort as that would change order

    //2,3,-2,4
    //left[] = [2,]
    //right[] = [,,4,4]

    //-2,-10,9,-8
    //prefixSum = -2,20,180,-1440
    //suffixSum = -1440,720,-72,-8
    public static int maxProduct(int[] nums) {
        int prefixSum=1,suffixSum=1,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(prefixSum == 0)prefixSum=1;
            if(suffixSum == 0)suffixSum=1;
            prefixSum *= nums[i];
            suffixSum *= nums[nums.length-i-1];
            max = Math.max(max,Math.max(prefixSum,suffixSum));
        }
        return max;
    }
}

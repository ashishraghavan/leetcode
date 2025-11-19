package com.leetcode.medium.array_strings;

import java.util.Arrays;

//TODO: definitely [revise], Can be done with prefix & suffix sum (see maxProduct(...) & check https://www.youtube.com/watch?v=hnswaLJvr6g)
// or kadane's algorithm (see maxProductII(...) & check https://www.youtube.com/watch?v=lq8KOs1Ujas)
//prob #152 - maximum product subarray
public class MaximumProductSubarray_L152 {
    public static void main(String[] args) {
        //-2,-10,9,-8,-6,-9,5,2
        //-1,-10,-9,-9,1,-6,8,7
        //-2,-10,9,-8,-6
        //-2,0,-1
        //1,0,-1,2,3,-5,-2
        //-2,-10,9,-8,-6,-9,5,2
        //-2,-3,4,-2,-6,-5,5,2
        System.out.println(maxProductIII(new int[]{-2,0,-1}));
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

    //-2,-10,9,-8,-6,-9,5,2
    //pfsum = [-2,20,180,-1440,8640,-ve,-ve,-ve]
    //sfsum = [,,,-8640,1440,-180,10,2]

    //[-2,-10,9,-8,-6,-9,5,2]
    //TODO: INCORRECT APPROACH!!!
    public static int maxProductII(int[] nums) {
//        int[] pfSum = new int[nums.length];
//        int[] sfSum = new int[nums.length];
//        int n = nums.length;
//        pfSum[0]=nums[0];
//        sfSum[nums.length-1] = nums[nums.length-1];
//        for(int i=1;i<nums.length;i++) {
//            pfSum[i] = pfSum[i-1] * nums[i];
//            sfSum[n-i-1] = sfSum[n-i] * nums[n-i];
//        }
//        System.out.println(Arrays.toString(pfSum));
//        System.out.println(Arrays.toString(sfSum));
        int product = nums[0],maxProduct=Integer.MIN_VALUE,currProduct = product;
        for(int i=1;i<nums.length;i++) {
            currProduct = Math.max(nums[i],nums[i]*currProduct);
            maxProduct = Math.max(currProduct,maxProduct);
        }
        return maxProduct;
    }


    //[-2,-10,9,-8,-6,-9,5,2]
    //Only 2 possible cases
    //1. even # of -ve's(doesn't matter what other numbers are) -> return product of entire array as ans
    //2. odd # of -ve's(doesn't matter what other numbers are) -> ignore one of the -ve #(max_idx), max product will be either
    // product of [start...max_idx-1] or product of [max_idx+1,end] ie. max(product_[start...max_idx-1],product_[max_idx+1,end])

    //          [-2,-3,4,-2,-6,-5,5,2]
    //pfsum =   [1,-2,6,24,-48,288,-1440,7200]
    //sfsum =   [,,,,,,-50,10,2,1]

    //-2,-3,4,-2,-6,-5,5,2
    //1,0,-1,2,3,-5,-2
    //-2,0,-1
    public static int maxProductIII(int[] nums) {
//        pfSum[0] = 1;
//        sfSum[sfSum.length-1]=1;
//        int currPfSum = 1,currSfSum=1;
//        for(int i=1;i<pfSum.length;i++) {
//            currPfSum = (nums[i-1]==0) ? 1 : currPfSum * nums[i-1];
//            pfSum[i] = currPfSum;
//        }
//        for(int i=sfSum.length-2;i>=0;i--) {
//            currSfSum = (nums[i+1]==0) ? 1 : currSfSum * nums[i+1];
//            sfSum[i] = currSfSum;
//        }
//        System.out.println(Arrays.toString(pfSum));
//        System.out.println(Arrays.toString(sfSum));
//        int maxProduct = Integer.MIN_VALUE,currMax;
//        for(int i=0;i<nums.length;i++) {
//            currMax = Math.max(pfSum[i],sfSum[i]);
//            maxProduct = Math.max(maxProduct,currMax);
//        }
//        return maxProduct;
        int pf = 1,sf = 1,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(pf == 0)pf = 1;
            if(sf == 0)sf = 1;
            pf *= nums[i];
            sf *= nums[nums.length - i - 1];
            max = Math.max(max,Math.max(pf,sf));
        }
        return max;
    }
}

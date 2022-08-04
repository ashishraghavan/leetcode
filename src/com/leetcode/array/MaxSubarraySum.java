package com.leetcode.array;

public class MaxSubarraySum {
    public static void main(String[] args) {
        //5,4,-1,7,8
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int mx = nums[0];
        int cMx;
        for(int i=1;i<nums.length;i++) {
            sum += nums[i];
            cMx = Math.max(nums[i],sum);
            if(cMx > mx) {
                mx = cMx;
                sum = nums[i];
            }
        }
        return mx;
    }
}

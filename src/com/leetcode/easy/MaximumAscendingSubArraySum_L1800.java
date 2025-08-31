package com.leetcode.easy;

//prob # 1800 maximum ascending subarray sum
public class MaximumAscendingSubArraySum_L1800 {
    public static void main(String[] args) {
        //10,20,30,5,10,50
        //12,17,15,13,10,11,12
        //10,20,30,40,50
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
    }

    //10,20,30,5,10,50
    //sliding window?
    //if nums.length==1 return nums[0]
    //i=0,j=1, mxSum=nums[0],currSum=mxSum, if nums[j] > nums[i] ? currSum+=nums[j], mxSum = Math.max(mxSum,currSum)
    public static int maxAscendingSum(int[] nums) {
        if(nums.length == 1)return nums[0];
        int i=0,j=1,mxSum=nums[0],currSum=nums[0];
        while(j < nums.length) {
            if(nums[j] > nums[i]) {
                currSum += nums[j];
                mxSum = Math.max(mxSum,currSum);
                i++;
                j++;
            } else {
                i=j;
                j=i+1;
                currSum=nums[i];
            }
        }
        return mxSum;
    }
}

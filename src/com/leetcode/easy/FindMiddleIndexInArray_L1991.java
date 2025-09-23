package com.leetcode.easy;

//prob #1991 - find middle index in array
//used concept of suffix, prefix array to store sum at each index
public class FindMiddleIndexInArray_L1991 {
    public static void main(String[] args) {
        //2,3,-1,8,4
        //1,-1,4
        //2,5
        System.out.println(findMiddleIndex(new int[]{2,5}));
    }

    //2,3,-1,8,4, leftSum[] = [2,5,4,12,16], rightSum[] = [16,14,11,12,4]
    //i in range(0,nums.length-1) leftSum=i==0?0:leftSum[i-1], rightSum=i==nums.length-1?0:rightSum[i+1]
    //if(leftSum==rightSum)return i;
    //return -1;
    public static int findMiddleIndex(int[] nums) {
        int[] lSum = new int[nums.length];
        int[] rSum = new int[nums.length];
        int sum = 0,leftSum,rightSum;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            lSum[i]=sum;
        }
        sum=0;
        for(int i=nums.length-1;i>=0;i--) {
            sum += nums[i];
            rSum[i]=sum;
        }
        for(int i=0;i<nums.length;i++) {
            //leftSum=i==0?0:leftSum[i-1], rightSum=i==nums.length-1?0:rightSum[i+1]
            leftSum = (i==0) ? 0 : lSum[i-1];
            rightSum = (i==nums.length-1) ? 0 : rSum[i+1];
            if(leftSum == rightSum)return i;
        }
        return -1;
    }
}

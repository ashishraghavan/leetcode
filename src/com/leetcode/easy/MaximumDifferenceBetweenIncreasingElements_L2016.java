package com.leetcode.easy;

//problem #2016 - maximum difference between increasing elements in array
public class MaximumDifferenceBetweenIncreasingElements_L2016 {
    public static void main(String[] args) {
        //7,1,5,4
        //9,4,3,2
        //1,5,2,10
        System.out.println(maximumDifference(new int[]{1,5,2,10}));
    }

    //7,1,5,4 -> 7,1,1,1 | 7,7,7,7 ||
    // diff = 0, low = 0, high = 0, i in (1,A.length-1) A[i] < A[low] {low=i;} A[i] > A[low] && i > low?diff = max(A[i]-A[low],diff);
    //1,5,2,10 -> 1,1,1,1 | 1,5,5,10
    // diff = 0, low = 0, high = 0, i in (1,A.length-1) A[i] < A[low] {low=i;} A[i] > A[low] && i > low?diff = max(A[i]-A[low],diff);
    public static int maximumDifference(int[] nums) {
        int diff = -1,low = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] < nums[low]) {
                low = i;
            }
            if(nums[i] > nums[low] && i > low) {
                diff = Math.max(nums[i]-nums[low],diff);
            }
        }
        return diff;
    }
}

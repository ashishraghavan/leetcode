package com.leetcode.easy;

import java.util.Arrays;

//TODO: pending
//problem # 2099 largest sum subsequence of length k
public class LargestSumSubsequenceOfLengthK_L2099 {
    public static void main(String[] args) {
        //-1,-2,3,4 | 3
        //10, -11, 8, 5, -7, -8, -1, 8 | 3
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1,-2,3,4},3)));
    }

    //-1,-2,3,4 | 3
    //all possible 3 element subsequences - (-1,-2,3), (-1,-2,4), (-1,3,4), (-2,3,4)
    //mx = nums[0],
    // i=1;i<nums.length;i++
    //      mx = math.max(mx,mx+)
    //can't change order therefore can't sort, sliding window

    //10, -11, 8, 5, -7, -8, -1, 8 | 4 -> 10,8,5,8
    public static int[] maxSubsequence(int[] nums, int k) {
        return nums;
    }
}

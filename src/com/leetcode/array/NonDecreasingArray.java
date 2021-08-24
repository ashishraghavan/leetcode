package com.leetcode.array;

/**
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * <p>
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * The n belongs to [1, 10,000].
 * TODO : Not solved. Test case for which this is not solved is {3,4,2,3}
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        //3,4,2,3
        //4,2,1
        //
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
    }

    private static boolean checkPossibility(int[] nums) {
        int nonDecreasingCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((i + 1 < nums.length) && (nums[i + 1] >= nums[i])) {
                nonDecreasingCount++;
            }
        }
        return (nonDecreasingCount == nums.length ||
                (nonDecreasingCount == nums.length - 1));
    }
}

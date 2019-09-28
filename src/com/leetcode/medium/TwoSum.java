package com.leetcode.medium;

import java.util.Arrays;

/**
 * Problem statement :
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum {
    public static void main(String[] args) {
        //[2, 7, 11, 15], target = 9
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[2];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    result[count++] = i;
                    result[count++] = j;
                }
            }
        }
        return result;
    }
}

package com.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * EASY #1
 * Problem statement :
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * 09-04-2021 - redoing problem.
 */

public class TwoSum {
    public static void main(String[] args) {
        //[2, 7, 11, 15], target = 9
        //3,2,4, target = 6
        //[29, 53, 59, 26, 32, 32, 68, 23, 50, 32, 53, 29, 45, 53, 6, 45, 43, 28, 17, 0, 11, 7, 78, 57, 31, 10, 77, 72, 14, 49, 9, 66, 14, 27, 42, 17, 69, 37, 62, 67, 71, 12, 38, 28, 66, 62, 12, 37, 23, 31, 16, 77, 60, 41, 44, 43, 31, 12, 65, 61, 72, 76, 28, 77, 1, 0, 0, 63, 66, 78, 64, 44, 30, 14, 50, 28, 16, 32, 73, 59, 11, 49, 63, 12, 73, 27, 40, 67, 27, 9, 78, 0, 13, 25, 40, 17, 47, 10, 0, 76]
        int[] nums = new int[]{29, 53, 59, 26, 32, 32, 68, 23, 50, 32, 53, 29, 45, 53, 6, 45, 43, 28, 17, 0, 11, 7, 78, 57, 31, 10, 77, 72, 14, 49, 9, 66, 14, 27, 42, 17, 69, 37, 62, 67, 71, 12, 38, 28, 66, 62, 12, 37, 23, 31, 16, 77, 60, 41, 44, 43, 31, 12, 65, 61, 72, 76, 28, 77, 1, 0, 0, 63, 66, 78, 64, 44, 30, 14, 50, 28, 16, 32, 73, 59, 11, 49, 63, 12, 73, 27, 40, 67, 27, 9, 78, 0, 13, 25, 40, 17, 47, 10, 0, 76};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    //-10^9 <= nums[i] <= 10^9
    public static int[] twoSum(int[] nums, int target) {
        //because of constraint | 2 <= nums.length <= Math.pow(10,4) |
        if(nums.length == 2) {
            nums[0] = 0;
            nums[1] = 1;
            return nums;
        }
        int[] result = new int[2];
        int count = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            mp.put(nums[i],i);
        }
        int diff;
        for(int i = 0;i<nums.length;i++) {
            diff = target - nums[i];
            if(mp.containsKey(diff) && mp.get(diff) > i) {
                result[count++] = i;
                result[count] = mp.get(diff);
                return result;
            }
        }
        return result;
    }
}

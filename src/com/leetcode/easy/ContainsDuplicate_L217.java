package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//prob. # 217 - contains duplicate
public class ContainsDuplicate_L217 {
    public static void main(String[] args) {
        //1,2,3,4
        //1,1,1,3,3,4,3,2,4,2
        //1,2,3,1
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    //sorting - O(nlogn), linear search O(n) => O(nlogn) time
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1)return false;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i-1])return true;
        }
        return false;
    }

    //Use a set to add elements. If set.add(element) returns false?return true
    public static boolean containsDuplicateII(int[] nums) {
        Set<Integer> dups = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!dups.add(num)) return true;
        }
        return false;
    }
}

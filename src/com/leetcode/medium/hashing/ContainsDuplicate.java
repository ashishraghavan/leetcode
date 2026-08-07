package com.leetcode.medium.hashing;

import java.util.HashSet;
import java.util.Set;

//#217
public class ContainsDuplicate {
    public static void main(String[] args) {
        //1,2,3,4
        //-1, -2, -3, -4, -1
        //1, 1, 1, 1, 1
        //0, 1, 2, 0
        System.out.println(containsDuplicate(new int[]{0, 1, 2, 0}));
    }

    //-1, -2, -3, -4, -1
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.add(num))return true;
        }
        return false;
    }
}

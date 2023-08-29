package com.leetcode.array;

import java.util.Arrays;

public class GenerateAllPossibleSubsequences {
    public static void main(String[] args) {
        //exp. O/P -- [4] : [4,1] : [4,1,5] : [4,5] : [1] : [1,5] : [5] : []
        //int[] arr = new int[]{4,1,5};
        //genSS(arr,0,arr.length,0,arr.length);
        String str = "ABC";

    }

    /**
     * [4,1,5] -> []
     * i=0, skip i, take sub-array [i+1, nums.length] i.e. [1,5]
     *          i=0, skip i, take sub-array [i+1, nums.length] i.e. [5]
     *              current arr.length == 1, so print [5] & return
     *          i=1, skip i, take sub-array [i+1, nums.length] i.e. undefined coz i+1 = 2 == nums.length.
     *          before exiting loop, print sub-array [1,5]
     *
     */
    static void genSS(int[] nums, int lbegin, int lend, int rbegin, int rend) {

    }

    static void genSS(String prefix, String suffix) {

    }
}

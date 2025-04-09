package com.leetcode.array;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        //{1,3,5,6},5
        //{1,3,5,6},2
        //{1,3,5,6},7
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
    }

    public static int searchInsert(int[] nums, int target) {
        int insPos = Arrays.binarySearch(nums,target);
        if(insPos < 0) {
            insPos = Math.abs(insPos) - 1;
        }
        return insPos;
    }
}

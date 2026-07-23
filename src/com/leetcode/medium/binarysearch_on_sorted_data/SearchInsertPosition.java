package com.leetcode.medium.binarysearch_on_sorted_data;

import java.util.Arrays;

//#35
public class SearchInsertPosition {
    public static void main(String[] args) {
        //1,3,5,6|5
        //1,3,5,6|2
        //1,3,5,6|7 -> -5
        //1|1
        //3|1
        //3|5
        //-5, -3, -1, 1, 3|-2
        //1,3|2
        //2, 4, 6, 8, 10|6
        System.out.println(binarySearch(new int[]{2, 4, 6, 8, 10},6));
    }

    //1,3,5,6|5
    public static int searchInsert(int[] nums, int target) {
        return -1;
    }

    public static int binarySearch(int[] A,int target) {
        int idx = Arrays.binarySearch(A,0,A.length,target);
        return idx >= 0 ? idx : Math.abs(idx)-1;
    }
}

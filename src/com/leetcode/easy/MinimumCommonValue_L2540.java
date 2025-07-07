package com.leetcode.easy;

import java.util.Arrays;

//prob # 2540 - minimum common value
public class MinimumCommonValue_L2540 {
    public static void main(String[] args) {
        //nums1 = [1,2,3], nums2 = [2,4]
        //nums1 = [1,2,3,6], nums2 = [2,3,4,5]
        //3,5,7,11  13,16,17,20
        //2,5,5,5   5
        System.out.println(getCommon(new int[]{2,5,5,5},new int[]{5}));
    }

    //nums1 = [1,2,3], nums2 = [2,4]
    //if nums1[nums1.len-1] < nums2[0] || nums2[nums2.len-1] < nums1[0] return -1
    //if nums1.len <= nums2.len ? short = nums1, long = nums2 else short = nums2, long = nums1
    //for i in nums2.len-1
    public static int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(nums1[n1-1] < nums2[0] || nums2[n2-1] < nums1[0])return -1;
        for (int j : nums2) {
            if (Arrays.binarySearch(nums1, 0, n1, j) >= 0) return j;
        }
        return -1;
    }
}

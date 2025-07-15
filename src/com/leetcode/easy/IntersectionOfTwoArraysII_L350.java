package com.leetcode.easy;

import java.util.Arrays;

//prob. # 350 - intersection of two arrays II
public class IntersectionOfTwoArraysII_L350 {
    public static void main(String[] args) {
        //nums1 = [1,2,2,1], nums2 = [2,2]
        //nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        //[10, 18, 16, 5, 10, 14, 1, 9, 19, 11, 17, 3, 5, 14, 14, 5, 9, 18, 14, 0], [11, 3, 15, 2, 16, 4, 19, 9, 19, 7]
        System.out.println(Arrays.toString(intersect(new int[]{10, 18, 16, 5, 10, 14, 1, 9, 19, 11, 17, 3, 5, 14, 14, 5, 9, 18, 14, 0},
                new int[]{11, 3, 15, 2, 16, 4, 19, 9, 19, 7})));
    }

    //sort nums1, nums2
    //[4,9,5], [9,4,9,8,4] --> [4,5,9],[4,4,8,9,9]
    //List ans = new <>(Math.max(nums1.length,nums2.length))
    //for i in nums1,j in nums2
    // -- int res = Integer.compare(nums1[i],nums2[j])
    // res == 0 ? ans.add(nums1[i]),i++,j++
    //else res < 0 ? j++
    //else i++
    //return ans
    //[4,5,9],[4,4,8,9,9]
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(nums1.length,nums2.length)];
        int i=0,j=0,res,idx=0;
        while(i < nums1.length && j < nums2.length) {
            res = Integer.compare(nums1[i],nums2[j]);
            if(res == 0){
                ans[idx++] = nums1[i];
                i++;
                j++;
            } else if(res < 0) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(ans,idx);
    }
}

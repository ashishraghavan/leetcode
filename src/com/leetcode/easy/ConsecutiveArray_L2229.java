package com.leetcode.easy;

import java.util.Arrays;

//prob # 2229 - consecutive array [premium]
//An array is consecutive if it contains every number in the range [x, x + n - 1] (inclusive),
// where x is the minimum number in the array and n is the length of the array.
//1 <= nums.length <= 100000, 0 <= nums[i] <= 100000
public class ConsecutiveArray_L2229 {
    public static void main(String[] args) {
        //1,3,4,2
        //1,3
        //3,5,4
        //4,8,6,9,3,5,7
        //4,8,6,9,3,7
        System.out.println(isConsecutive(new int[]{1,3,4,2}));
    }

    //4,8,6,9,3,7 -> [3,4,6,7,8,9], contains(3,8)?
    public static boolean isConsecutive(int[] A) {
        Arrays.sort(A);
        int j=0;
        for(int i=A[0];i<=A[0]+A.length-1;i++) {
            if(j >= A.length || A[j++] != i)return false;
        }
        return true;
    }
}

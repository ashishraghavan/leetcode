package com.leetcode.easy;

import java.util.Arrays;

//prob # 2164 - sort even & odd indices separately
public class SortEvenOddIndicesSeparately_L2164 {
    public static void main(String[] args) {
        //4,1,2,3
        //4,1,2,3,8,4,7,9,2,1,5,12,10
        //4,1,2,3,8,4,7,9,2,1,5,12
        //2,1
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{2})));
    }

    //4,1,2,3 -> 2,3,4,1
    //4,1,2,3,8,4,7,9 -> [4,2,8,7], [1,3,4,9] -> [2,4,7,8], [9,4,3,1] -> [2,9,4,4,7,3,8,1]
    //4,1,2,3,8,4,7,9,
    public static int[] sortEvenOdd(int[] nums) {
        int[] evenidx = new int[nums.length % 2 == 0 ? nums.length/2 : (nums.length/2) + 1];
        int[] oddidx = new int[nums.length-evenidx.length];
        int evenCt=0,oddCnt=0;
        for(int i=0;i<nums.length;i++) {
            if(i % 2 == 0) {
                evenidx[evenCt++] = nums[i];
            } else {
                oddidx[oddCnt++] = nums[i];
            }
        }
        Arrays.sort(evenidx);
        Arrays.sort(oddidx);
        System.out.println(Arrays.toString(evenidx));
        System.out.println(Arrays.toString(oddidx));
        int[] res = new int[nums.length];
        evenCt=0;
        oddCnt = oddidx.length-1;
        for(int i=0;i<nums.length;i+=2) {
            res[i] = evenidx[evenCt++];
        }
        for(int j=1;j<nums.length;j+=2) {
            res[j] = oddidx[oddCnt--];
        }
        return res;
    }
}

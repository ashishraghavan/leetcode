package com.leetcode.easy;

import java.util.Arrays;

//prob. # 724 - pivot index
public class PivotIndex_L724 {
    public static void main(String[] args) {
        //1,7,3,6,5,6
        //2,1,-1
        //1,2,3
        System.out.println(pivotIndex(new int[]{1}));
    }

    //1,7,3,6,5,6
    //L[] = [0,1,8,11,17,22], R[] = [27,20,17,11,6,0]
    public static int pivotIndex(int[] nums) {
        if(nums.length == 1)return 0;
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
        int lsum = 0, rsum = 0;
        for(int j=1;j<L.length;j++) {
            lsum += nums[j-1];
            L[j] = lsum;
        }
        for(int j=R.length-2;j>=0;j--) {
            rsum += nums[j+1];
            R[j] = rsum;
        }
        //System.out.println(Arrays.toString(L));
        //System.out.println(Arrays.toString(R));
        for(int i=0;i<L.length;i++) {
            if(L[i] == R[i])return i;
        }
        return -1;
    }
}

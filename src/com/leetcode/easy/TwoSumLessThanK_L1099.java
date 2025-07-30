package com.leetcode.easy;

import java.util.Arrays;

//prob # 1099 - two sum less than k, [PREMIUM]
public class TwoSumLessThanK_L1099 {
    public static void main(String[] args) {
        //34,23,1,24,75,33,54,8     60
        //10,20,30      15
        System.out.println(twoSumLessThanK(new int[]{10,20,30},15));
    }

    //34,23,1,24,75,33,54,8 -> 1,8,23,24,33,34,54,75
    //if A[0] < k return -1
    //i=0,j=A.len-1, while i<j { if A[j] > k ? j--,continue
    //if A[i]+A[j] < sum ? increment i else decrement j return mxSum;
    public static int twoSumLessThanK(int[] A,int k) {
        if(A.length == 1)return -1;
        Arrays.sort(A);
        int i=0,j=A.length-1,mxSum = -1,currSum;
        while(i < j) {
            if(A[j] > k) {
                j--;
                continue;
            }
            currSum = A[i] + A[j];
            if(currSum < k) {
                mxSum = Math.max(currSum,mxSum);
                i++;
            } else {
                j--;
            }
        }
        return mxSum;
    }
}
